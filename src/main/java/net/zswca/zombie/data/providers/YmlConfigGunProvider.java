package net.zswca.zombie.data.providers;

import net.zswca.zombie.data.GunData;

import java.io.File;

public class YmlConfigGunProvider implements ISavableGunProvider, IReloadAbleGunProvider {
    private final File gunConfigFolder;

    public YmlConfigGunProvider(File gunConfigFolder) {
        this.gunConfigFolder = gunConfigFolder;
    }

    @Override
    public GunData getGun(String name) {
        return null;
    }

    @Override
    public void reloadAllGuns() {

    }

    @Override
    public void saveGuns() {

    }
}
