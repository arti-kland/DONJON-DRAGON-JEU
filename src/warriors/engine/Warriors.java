package warriors.engine;
import warriors.contracts.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Warriors implements WarriorsAPI {
    private Hashtable<String, GameStateImpl> myGameStates = new Hashtable();
    GameStateImpl myCurrentGame;

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
        Board myMap = new Board("Tous les chemins mènent à la mort !!! ", 64);
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
        myCurrentGame = myGameStates.get(gameID);
        int valeurDe = myCurrentGame.throwDice();
        int pos = myCurrentGame.getLocationHero() + valeurDe;
        if(pos + valeurDe <= 64) {
            myCurrentGame.heroMove(valeurDe);
            myCurrentGame.setLastLog(myCurrentGame.getPlayerName() + " à fait un : " + valeurDe + "\n" + myCurrentGame.getPlayerName() +" est sur la case n° : " + pos  + "\n" + checkCase(pos, gameID));

        }else{
            myCurrentGame.setGameStatus(GameStatus.FINISHED);
            myCurrentGame.setLastLog("Bravo " + myCurrentGame.getPlayerName() + " vous avez gagné !!! ");
        }
        return myCurrentGame;
    }

    public String checkCase(int pos,String gameID) {
        String nomCase = ((Board) myGameStates.get(gameID).getMap()).getCase().get(pos).toString();
        return nomCase;

//        return ;
//        if(currentCase.getName() == "Dragon"){
//            //method1 ex: combat
//        }else if (currentCase.getName() == "Sorcier"){
//            //method2
//        }
    }
}

