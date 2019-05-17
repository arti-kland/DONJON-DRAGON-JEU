package warriors.engine;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;


public class GameStateImpl implements GameState {

    private String gameId;
    private String playerName;
    private Hero hero;
    private Map map;
    private String log;
    private GameStatus statusGame;
    private int locationHero = 0;

    public GameStateImpl ( String playerName, Hero hero, Map map){
        this.playerName = playerName;
        this.hero = hero;
        this.map = map;
        this.log = "Bienvenu dans le jeu :" + playerName ;
        this.statusGame = GameStatus.IN_PROGRESS;
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public String getGameId() {
        return "L'ID est : ";
    }

    @Override
    public GameStatus getGameStatus() {
        return statusGame;
    }

    public void setGameStatus(GameStatus statusGame) {
        this.statusGame = statusGame;
    }

    @Override
    public Hero getHero() {
        return this.hero;
    }

    @Override
    public Map getMap() {
        return this.map;
    }

    @Override
    public String getLastLog() {
        return log;
    }

    public void setLastLog(String log){
        this.log = log;
    }

    @Override
    public int getCurrentCase() {

        return this.locationHero;
    }

    public int getLocationHero(){
        return locationHero;
    }

    public int throwDice(){
        int nbDe = 1 + (int) (Math.random() * ((6 - 1) + 1));
        return nbDe;
    }

    public void heroMove(int nbDe){
        locationHero = locationHero + nbDe;
    }


}
