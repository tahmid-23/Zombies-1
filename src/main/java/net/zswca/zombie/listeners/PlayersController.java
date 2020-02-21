package net.zswca.zombie.listeners;

import net.zswca.zombie.Zombie;
import net.zswca.zombie.managers.GameManager;
import net.zswca.zombie.objects.User;
import net.zswca.zombie.objects.guns.Gun;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

// Handle all player control in-game
public class PlayersController implements Listener {
    private final GameManager manager;

    public PlayersController(GameManager manager) {
        this.manager = manager;
    }

    public void activateController() {
        Bukkit.getPluginManager().registerEvents(this, Zombie.getInstance());
    }

    public void deactivateController() {
        HandlerList.unregisterAll(this);
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent e) {
        // Check for the current user
        Player player = e.getPlayer();
        User currentUser = manager.getUserManager().getUser(player);

        if(currentUser != null) {
            if (true) { // TODO: placeholder value
                processGunShot(e, player, currentUser);
            } else {
                // TODO: implement shops
            }
        }
    }

    private void processGunShot(PlayerInteractEvent e, Player player, User currentUser) {
        Gun gun = currentUser.getGun().getGunByItemStack(player.getInventory().getItemInMainHand());
        if(gun != null) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                gun.shoot();
            } else if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                gun.reload();
            }
        }
    }
}
