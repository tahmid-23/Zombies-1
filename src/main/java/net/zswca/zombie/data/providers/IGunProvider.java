package net.zswca.zombie.data.providers;

import net.zswca.zombie.data.GunData;

import java.io.File;

// means of import gun data
public interface IGunProvider {
    GunData getGun(String name);
}
