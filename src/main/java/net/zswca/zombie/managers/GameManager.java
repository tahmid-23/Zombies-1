package net.zswca.zombie.managers;

import net.zswca.zombie.enums.GameState;
import net.zswca.zombie.listeners.PlayersController;

public class GameManager {
    private PlayersController controller;
    private UserManager userManager;
    private GameState gameState;

    public GameManager() {
        this.controller = new PlayersController(this);
        this.userManager = new UserManager();
    }

    public PlayersController getController() {
        return controller;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setGameState(GameState state){
        gameState = state;
    }

    public GameState getGameState(){
        return gameState;
    }
}
