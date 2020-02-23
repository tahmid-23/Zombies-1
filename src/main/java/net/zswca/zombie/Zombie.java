package net.zswca.zombie;

import net.zswca.zombie.data.providers.IGunProvider;
import net.zswca.zombie.data.providers.YmlConfigGunProvider;
import net.zswca.zombie.managers.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.nio.file.Paths;

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

        // Import guns data
        try {
            gunProvider = new YmlConfigGunProvider(Paths.get(getDataFolder().getName(), "guns").toFile());
        } catch (IOException e) {
            System.err.println("Error: cannot load guns from data files");
            e.printStackTrace();
        }
    }

    public static Zombie getInstance() {
        return currentPlugin;
    }

}
