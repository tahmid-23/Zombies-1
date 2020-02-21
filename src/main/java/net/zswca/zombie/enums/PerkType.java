package net.zswca.zombie.enums;

import org.bukkit.Material;

public enum PerkType {
    FAST_REVIVE(Material.COOKIE),
    QUICK_FIRE(Material.REDSTONE),
    EXTRA_HEALTH(Material.GOLD_NUGGET);

    private final Material item;

    PerkType(Material item){
        this.item = item;
    }

    public Material getPerkMaterial(){
        return item;
    }
}
