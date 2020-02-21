package net.zswca.zombie.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeaponStatsLoreBuilder {
    private final List<String> descriptions;
    private final List<String> stats;
    private final List<String> instructions;

    public WeaponStatsLoreBuilder() {
        this.descriptions = new ArrayList<String>();
        this.stats = new ArrayList<String>();
        this.instructions = new ArrayList<String>();
    }

    public static String[] getGunInstructionLore() {
        // TODO: Fix the chat color
        return new String[] {
                ChatColor.YELLOW.toString() + "LEFT-CLICK " + ChatColor.GRAY + "to reload.",
                ChatColor.YELLOW.toString() + "RIGHT-CLICK" + ChatColor.GRAY + "to shoot."
        };
    }

    public static String[] getGunPlaceHolderLore() {
        return new String[] {
                "Purchase guns at " + ChatColor.GOLD + "Shops " + ChatColor.GRAY + "or at",
                "the " + ChatColor.DARK_PURPLE + "Lucky Chest" + ChatColor.GRAY + "!"
        };
    }

    /**
     * Set the description lore of the weapon
     * @param descriptions the weapon instruction
     * @return current builder
     */
    public WeaponStatsLoreBuilder withDescriptions(String... descriptions) {
        this.descriptions.clear();
        Collections.addAll(this.descriptions, descriptions);

        return this;
    }

    /**
     * Set the description lore of the weapon
     * @param description a line of the weapon instruction
     * @return current builder
     */
    public WeaponStatsLoreBuilder addDescription(String description) {
        this.descriptions.add(description);

        return this;
    }

    /**
     * Add the lore stats of the weapon for ultimate value.
     * @param name stats name
     * @param oldValue the previous level stats
     * @param newValue the current level stats
     * @return current builder
     */
    public WeaponStatsLoreBuilder addStats(String name, Object oldValue, Object newValue, String unit) {
        // TODO: Fix the chat color, use String.format? to improve readability
        // stats.add(name + ": " + ChatColor.DARK_GRAY + oldValue + " " + unit + " ➔ " + ChatColor.GREEN + newValue + " " + unit);

        stats.add(String.format("%s: %s%s %s ➔ %s%s %s", name, ChatColor.DARK_GRAY, oldValue, unit, ChatColor.GREEN, newValue, unit));
        return this;
    }

    /**
     * Add the lore of the weapon for non ultimate value.
     * @param name stats name
     * @param value the previous level stats
     * @return current builder
     */
    public WeaponStatsLoreBuilder addStats(String name, Object value, String unit) {
        stats.add(name + ": " + ChatColor.GREEN + value + " " + unit);

        return this;
    }

    /**
     * Set the instruction lore of the weapon
     * @param instructions the weapon instruction
     * @return current builder
     */
    public WeaponStatsLoreBuilder withInstruction (String... instructions) {
        this.instructions.clear();
        Collections.addAll(this.instructions, instructions);

        return this;
    }

    /**
     * Set the instruction lore of the weapon
     * @param instruction a line of the weapon instruction
     * @return current builder
     */
    public WeaponStatsLoreBuilder addInstruction(String instruction ) {
        this.instructions.add(instruction);

        return this;
    }


    /**
     * Build the weapon lore
     * @return a string array represent weapon lore
     */
    public List<String> build() {
        List<String> lore = new ArrayList<String>();
        for (String item : descriptions) {
            lore.add(item);
        }

        lore.add("");
        for (String item : stats) {
            lore.add(item);
        }

        lore.add("");
        for (String item : instructions) {
            lore.add(item);
        }

        return lore;
    }
}
