package warriors.client.console;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jdk.jfr.events.FileReadEvent;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.Board;
import warriors.engine.Cases;
import warriors.engine.CasesAdapter;
import warriors.engine.Warriors;

public class ClientConsole {

    private static String MENU_COMMENCER_PARTIE = "1";
    private static String MENU_COMMENCER_TEST = "2";
    private static String MENU_SAVE_GAME = "3";
    private static String MENU_QUITTER = "4";
    private static ArrayList<Board> mapJsonSave = new ArrayList<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        String arg0 = args[0];
        WarriorsAPI warriors = new Warriors();
        Scanner sc = new Scanner(System.in);
        String menuChoice = "";
        do {
            menuChoice = displayMenu(sc);
            if (menuChoice.equals(MENU_COMMENCER_PARTIE)) {
                startGame(warriors, sc, false, arg0, false);
            } else if (menuChoice.equals(MENU_COMMENCER_TEST)) {
                startGame(warriors, sc, true, arg0, false);
            } else if (menuChoice.equals(MENU_SAVE_GAME)) {
                startGame(warriors, sc, false, arg0, true);
            }
        } while (!menuChoice.equals(MENU_QUITTER));
        sc.close();
        System.out.println("à bientôt");
    }

    /**
     * @param map
     */
    static void save(Map map) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Cases.class, new CasesAdapter());
        builder.setPrettyPrinting();
        Gson mapToJson = builder.create();
        String saveMap = mapToJson.toJson(map);
//        System.out.println(saveMap);
        String saveGameID = UUID.randomUUID().toString();
        File file = new File("./partieSave/" + saveGameID + ".json");
        file.getParentFile().mkdirs();
        try {
            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
            fileWriter.write(saveMap);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    static void read(boolean saveGame) {
        mapJsonSave.clear();
        File folder;
        if(!saveGame){
            folder = new File("./partieClassic");
        }else {
            folder = new File("./partieSave");
        }
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String jsonMap = "";
                try {
                    jsonMap = new String(Files.readAllBytes(Paths.get(file.getPath())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GsonBuilder builder = new GsonBuilder();
                builder.registerTypeAdapter(Cases.class, new CasesAdapter());
                builder.setPrettyPrinting();
                Gson jsonToMap = builder.create();
                Board map = jsonToMap.fromJson(jsonMap, Board.class);
                mapJsonSave.add(map);
            }
        }
    }

    /**
     * @param warriors
     * @param sc
     * @param debug
     * @param path
     */
    private static void startGame(WarriorsAPI warriors, Scanner sc, boolean debug, String path, boolean saveGame) {
        System.out.println();
        System.out.println("Entrez votre nom : ");
        String playerName = sc.nextLine();

        System.out.println("Choisissez votre héro : ");
        for (int i = 0; i < warriors.getHeroes().size(); i++) {
            Hero heroe = warriors.getHeroes().get(i);
            System.out.println(i + 1 + " - " + heroe.getName());
            System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
            System.out.println("    Niveau de vie : " + heroe.getLife());
        }
        Hero chosenHeroe = warriors.getHeroes().get(Integer.parseInt(sc.nextLine()) - 1);
        System.out.println("Vous avez choisi : " + chosenHeroe.getName());

        System.out.println("Choisissez votre map : ");
        Map choosenMap;

            read(saveGame);
            int i = 0;
            for (Board var : mapJsonSave) {
                Board choosenSaveMap = var;
                System.out.println(i + 1 + " - " + choosenSaveMap.getName());
                i++;
            }
            choosenMap = mapJsonSave.get(Integer.parseInt(sc.nextLine()) - 1);

        System.out.println("Vous avez choisi : " + choosenMap.getName());

        GameState gameState = warriors.createGame(playerName, chosenHeroe, choosenMap);
        String gameId = gameState.getGameId();
        if (!debug) {
            while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
                System.out.println(gameState.getLastLog());
                System.out.println("\nAppuyer sur une touche pour lancer le dé");
                if (sc.hasNext()) {
                    sc.nextLine();
                    gameState = warriors.nextTurn(gameId);
                }
            }
            System.out.println(gameState.getLastLog());
            saveMenu(gameState, sc);// je sauvegarde la partie jouée
        } else {
            String contentArgs = "";
            try {
                contentArgs = new String(Files.readAllBytes(Paths.get(path)));
//                System.out.println(contentArgs);
            } catch (IOException e) {
                e.printStackTrace();
            }
            debug(contentArgs, gameState, warriors, gameId);
        }
    }

    /**
     * @param contentArgs
     * @param gameState
     * @param warriors
     * @param gameId
     */
    private static void debug(String contentArgs, GameState gameState, WarriorsAPI warriors, String gameId) {

        String[] dice = contentArgs.split(",");
        for (String var : dice) {
            int valeurDe = Integer.parseInt(var);
            if (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
                System.out.println(gameState.getLastLog());
                gameState = ((Warriors) warriors).nextTurnDebug(gameId, valeurDe);
            } else {
                break;
            }
        }
        System.out.println(gameState.getLastLog());
    }

    private static String saveMenu(GameState gameState, Scanner sc) {

        System.out.println("Voulez vous sauvegader votre partie ?");
        System.out.println("1 - Oui");
        System.out.println("2 - Non");
        if (sc.hasNext()) {
            String saveChoice = sc.nextLine();
            if (saveChoice.equals("1")) {
                System.out.println("Non de votre sauvergarde :");
                if (sc.hasNext()) {
                    String gameName = sc.nextLine();
                    ((Board) gameState.getMap()).setName(gameName + " Joué par : " + gameState.getPlayerName());//je set le nom de la partie avec le nom donné par l'utilisateur
                    save(gameState.getMap());//sauvegarde partie joué dans Json
                }

            }
        }
        return "";
    }


    /**
     * @param sc
     * @return
     */
    private static String displayMenu(Scanner sc) {

        System.out.println();
        System.out.println("==================*** Donjon et Dragon *** ==================");
        System.out.println("1 - Commencer une partie");
        System.out.println("2 - Commencer un test");
        System.out.println("3 - Commencer une partie sauvgardé");
        System.out.println("4 - Quitter");
        if (sc.hasNext()) {
            String choice = sc.nextLine();
            return choice;
        }
        return "";
    }
}

