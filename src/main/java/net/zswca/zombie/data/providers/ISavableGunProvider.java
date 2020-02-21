package net.zswca.zombie.data.providers;

import net.zswca.zombie.data.GunData;

// Provide methods to save gun data. Use for Editor plugin to hot modify gun values
public interface ISavableGunProvider extends IGunProvider {
    void saveGuns();
}
