package net.zswca.zombie;

import net.zswca.zombie.data.providers.IGunProvider;
import net.zswca.zombie.managers.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Zombie extends JavaPlugin {
    private static Zombie currentPlugin;

    public IGunProvider getGunProvider() {
        return gunProvider;
    }

    private IGunProvider gunProvider;
    private GameManager currentGame;

    @Override
    public void onEnable() {
        // Plugin startup logic
        currentPlugin = this;
        // Use a Factory here?

    }

    public static Zombie getInstance() {
        return currentPlugin;
    }

}
