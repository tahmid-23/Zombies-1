package net.zswca.zombie.data.providers;

// Provides methods for how reload gun, usually change gun config file without stop and restart the server/ plugin
public interface IReloadAbleGunProvider extends IGunProvider {
    void reloadAllGuns();
}
