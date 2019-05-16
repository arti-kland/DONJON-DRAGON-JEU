package warriors.engine;
import warriors.contracts.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Warriors implements WarriorsAPI {
    private Hashtable<String, GameStateImpl> myGameStates = new Hashtable();

    @Override
    public List<Hero> getHeroes() {
        Personnages hunts = new Guerrier("Alucart", 5, 5);
        Personnages elfe = new Magicien("Cyclop", 3, 8);
        List<Hero> listHeros = new ArrayList<>();
        listHeros.add(hunts);
        listHeros.add(elfe);
        return listHeros;
    }

    @Override
    public List<Map> getMaps() {
        Board myMap = new Board("Map 1", 64);
        List<Map> map1 = new ArrayList<>();
        map1.add(myMap);
        //        setNumberOfCase();
//        myGameStates.getCurrentCase();
        return map1;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        GameStateImpl myGameStateImpl = new GameStateImpl(playerName, hero, map);
        myGameStates.put(myGameStateImpl.getGameId(), myGameStateImpl);
        return myGameStateImpl;
    }

    @Override
    public GameState nextTurn(String gameID) {
        GameStateImpl myCurrentGame = myGameStates.get(gameID);
        int valeurDe = myCurrentGame.throwDice();
        int pos = myCurrentGame.getLocationHero() + valeurDe;
        if(pos + valeurDe <= 64) {
            myCurrentGame.heroMove(valeurDe);
            myCurrentGame.setLastLog("Vous avez fait un : " + valeurDe + "\n " + "Vous êtes maintenant sur la case n° : " + pos);

        }else{
            myCurrentGame.setGameStatus(GameStatus.FINISHED);
            myCurrentGame.setLastLog("Bravo vous avez gagné !!! ");
        }
        return myCurrentGame;
    }
}

