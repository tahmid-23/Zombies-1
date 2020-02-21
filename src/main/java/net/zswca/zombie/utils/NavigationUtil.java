package net.zswca.zombie.utils;

import jdk.internal.jline.internal.Nullable;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.lang.reflect.Method;

/**
 * Utils for mob navigation by SkylineX
 */
public class NavigationUtil {

    private static Class<?> attributeInstance;
    private static Class<?> entityInsentient;
    private static Class<?> navigationAbstract;
    private static Class<?> genericAttributes;
    private static Class<?> iAttribute;
    private static Class<?> pathEntity;
    private static Class<?> craftEntity;
    private static Class<?> entityLiving;
    private static Class<?> controllerLook;
    private static Class<?> nmsEntity;
    private static Method getEntityHandle;
    private static Method getNavigation;
    private static Method aLocation;
    private static Method aEntity;
    private static Method getControllerLook;
    private static Method a;
    private static Method getAttributeInstance;
    private static Method setValue;
    private static Method aLookControl;
    private static Method a2LookControl;
    private static Object movementSpeed;

    public static void initialize() {
        try {
            craftEntity = Reflection.getCraftClass("entity.CraftEntity");
            entityLiving = Reflection.getNMSClass("EntityLiving");
            nmsEntity = Reflection.getNMSClass("Entity");
            pathEntity = Reflection.getNMSClass("PathEntity");
            iAttribute = Reflection.getNMSClass("IAttribute");
            genericAttributes = Reflection.getNMSClass("GenericAttributes");
            entityInsentient = Reflection.getNMSClass("EntityInsentient");
            navigationAbstract = Reflection.getNMSClass("NavigationAbstract");
            attributeInstance = Reflection.getNMSClass("AttributeInstance");
            getEntityHandle = craftEntity.getDeclaredMethod("getHandle");
            getControllerLook = entityInsentient.getDeclaredMethod("getControllerLook");
            controllerLook = Reflection.getNMSClass("ControllerLook");
            aLookControl = controllerLook.getDeclaredMethod("a",Double.TYPE,Double.TYPE,Double.TYPE,Float.TYPE,Float.TYPE);
            a2LookControl = controllerLook.getDeclaredMethod("a",nmsEntity,Float.TYPE,Float.TYPE);
            getNavigation = entityInsentient.getDeclaredMethod("getNavigation");
            aLocation = navigationAbstract.getDeclaredMethod("a", Double.TYPE, Double.TYPE, Double.TYPE); // PathEntity path = navigation.a(x, y, z);
            aEntity = navigationAbstract.getDeclaredMethod("a", pathEntity, Double.TYPE); //navigation.a(path, speed);
            a = navigationAbstract.getDeclaredMethod("a", Double.TYPE);
            getAttributeInstance = entityLiving.getDeclaredMethod("getAttributeInstance", iAttribute);
            setValue = attributeInstance.getDeclaredMethod("setValue", Double.TYPE);
            movementSpeed = Reflection.getField(genericAttributes.getDeclaredField("MOVEMENT_SPEED")).get((Object) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigate an entity to a designated location with a certain speed.
     *
     * @param entity the entity to be navigated
     * @param location the location where the entity is going to be navigated to
     * @param speed speed of the entity during the navigation
     */
    public static void walk(Entity entity, Location location, @Nullable double speed) {
        Object entityInsentientNavigation = new Object();
        Object entityInsentientObj = new Object();
        try {
            Object entityHandle = getEntityHandle.invoke(entity); //var1
            entityInsentientObj = entityInsentient.cast(entityHandle);
            entityInsentientNavigation = getNavigation.invoke(entityInsentientObj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Object var11 = aLocation.invoke(entityInsentientNavigation, location.getX(), location.getY(), location.getZ()); //return a pathEntity
            if (var11 != null) {
                aEntity.invoke(entityInsentientNavigation, var11, 1.0D); //store the return value in var10
            }
            a.invoke(entityInsentientNavigation, 1.0D);
            if(speed != 0) {
                setValue.invoke(getAttributeInstance.invoke(entityInsentientObj, movementSpeed), speed);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Make an entity look at somewhere with certain yaw and pitch.
     *
     * @param entity the Entity
     * @param yaw the yaw
     * @param pitch the pitch
     */
    public static void rotate(Entity entity, float yaw, float pitch) {
        Object entityInsentientObj = new Object();
        Object entityHandle = new Object();
        try {
            entityHandle = getEntityHandle.invoke(entity); //entityHandle is a nmsEntity
            entityInsentientObj = entityInsentient.cast(entityHandle);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Object controllerLookObj = getControllerLook.invoke(entityInsentientObj);
            aLookControl.invoke(controllerLookObj,entity.getLocation().getX(),entity.getLocation().getY(),entity.getLocation().getZ(),yaw,pitch);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}