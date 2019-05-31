package warriors.engine;

import warriors.contracts.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 */
public class Warriors implements WarriorsAPI {
    private Hashtable<String, GameStateImpl> myGameStates = new Hashtable();
    private List<Hero> listHeros;
    GameStateImpl myCurrentGame;
    Board myMap = new Board("Easy - Promenons nous dans les bois !", 64);
    Board myMap2 = new Board("Medium - Promenons nous dans le cimetière !!", 64);
    Board myMap3 = new Board("Hard - Promenons nous en enfert !!!", 64);

    /**
     * @return
     */
    @Override
    public List<Hero> getHeroes() {

        return listHeros;
    }

    public void setHeroes(List listHeros) {

        this.listHeros = listHeros;
    }

    /**
     * @return
     */
    @Override
    public List<Map> getMaps() {
        List<Map> maps = new ArrayList<>();
        maps.add(myMap);
        maps.add(myMap2);
        maps.add(myMap3);
        return maps;
    }

    /**
     * @param playerName the name of the player
     * @param hero       the chosen hero for the game
     * @param map        the chosen map for the game
     * @return
     */
    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        GameStateImpl myGameStateImpl = new GameStateImpl(playerName, hero, map);
        myGameStates.put(myGameStateImpl.getGameId(), myGameStateImpl);
        return myGameStateImpl;
    }

    /**
     * @param gameID the ID of the game
     * @return playGame (myCurrentGame, valeurDe, gameID)
     */
    @Override
    public GameState nextTurn(String gameID) {
        myCurrentGame = myGameStates.get(gameID);
        int dicevalue = myCurrentGame.throwDice();
        return playGame(myCurrentGame, dicevalue, gameID);
    }

    /**
     * @param gameID
     * @param dicevalue
     * @return
     */
    public GameState nextTurnDebug(String gameID, int dicevalue) {
        myCurrentGame = myGameStates.get(gameID);
        return playGame(myCurrentGame, dicevalue, gameID);
    }

    /**
     * Method managing all the action during one trun
     * throw dice + move hero + action on case + check gameStatus
     * @param myCurrentGame
     * @param dicevalue
     * @param gameID
     * @return myCurrentGame = new currentHero states
     */
    public GameState playGame(GameStateImpl myCurrentGame, int dicevalue, String gameID) {
        int pos = myCurrentGame.getLocationHero() + dicevalue;
        if (pos < 64) {
            myCurrentGame.heroMove(dicevalue);
            Personnages myHero = (Personnages) myCurrentGame.getHero();
            Board myBoard = ((Board) myCurrentGame.getMap());
            myBoard.getBoardLength(pos).updateHero(myHero);
            myCurrentGame.setLastLog(myCurrentGame.getPlayerName() + " à fait un : " + dicevalue + "\n" + myCurrentGame.getPlayerName() + " est sur la case n° : " + pos + "\n" + checkCase(pos, gameID) + " " + myCurrentGame.getHero());
            if (myHero.getLife() <= 0) {
                myCurrentGame.setGameStatus(GameStatus.GAME_OVER);
                myCurrentGame.setLastLog(myCurrentGame.getLastLog() + "\n Vous êtes MORT " + myCurrentGame.getPlayerName() + " !!!!!" + " entrainez-vous et réessayez ! ");
            }
        } else {
            myCurrentGame.setGameStatus(GameStatus.FINISHED);
            myCurrentGame.setLastLog("Bravo " + myCurrentGame.getPlayerName() + " vous avez gagné !!! ");
        }
        return myCurrentGame;
    }

    /**
     * @param pos
     * @param gameID
     * @return
     */
    public String checkCase(int pos, String gameID) {
        String nomCase = ((Board) myGameStates.get(gameID).getMap()).getCase().get(pos).toString();
        return nomCase;
    }

}

