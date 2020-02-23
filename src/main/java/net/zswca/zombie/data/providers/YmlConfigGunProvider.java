package net.zswca.zombie.data.providers;

import net.zswca.zombie.data.GunData;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class YmlConfigGunProvider implements ISavableGunProvider, IReloadAbleGunProvider {
    private final Yaml yamlParser;
    private final File gunConfigFolder;
    private final Hashtable<File, GunData> guns;

    public YmlConfigGunProvider(File gunConfigFolder) throws IOException {
        this.guns = new Hashtable<>();
        // TODO: Create custom constructor to resolve feature
        this.yamlParser = new Yaml(new Constructor());
        this.gunConfigFolder = gunConfigFolder;
        reloadAllGuns();
    }

    @Override
    public GunData getGun(String name) {
        return null;
    }

    @Override
    public void reloadAllGuns() throws IOException {
        List<File> gunFiles =  Files.walk(Paths.get(gunConfigFolder.getAbsolutePath()))
                .filter(path -> path.endsWith(".gundata"))
                .map(Path::toFile)
                .collect(Collectors.toList());

        for (File gunData : gunFiles) {
             GunData currentGun = yamlParser.load(new FileInputStream(gunData));
             guns.put(gunData, currentGun);
        }
    }

    @Override
    public void saveGuns() {

    }
}
