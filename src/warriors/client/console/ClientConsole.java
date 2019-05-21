package warriors.client.console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.Warriors;

public class ClientConsole {

    private static String MENU_COMMENCER_PARTIE = "1";
    private static String MENU_COMMENCER_TEST = "2";
    private static String MENU_QUITTER = "3";

    public static void main(String[] args) {
        String arg0 = args[0];
        WarriorsAPI warriors = new Warriors();
        Scanner sc = new Scanner(System.in);
        String menuChoice = "";
        do {
            menuChoice = displayMenu(sc);
            if (menuChoice.equals(MENU_COMMENCER_PARTIE)) {
                startGame(warriors, sc, false, arg0);
            } else if (menuChoice.equals(MENU_COMMENCER_TEST)) {
                startGame(warriors, sc, true, arg0);
            }
        } while (!menuChoice.equals(MENU_QUITTER));
        sc.close();
        System.out.println("à bientôt");
    }


    private static void startGame(WarriorsAPI warriors, Scanner sc, boolean debug, String path) {
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
        for (int i = 0; i < warriors.getMaps().size(); i++) {
            Map map = warriors.getMaps().get(i);
            System.out.println(i + 1 + " - " + map.getName());
        }
        Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);
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
        }else {
            String contentArgs = "";
            try {
                contentArgs = new String(Files.readAllBytes(Paths.get(path)));
                System.out.println(contentArgs);
            } catch (IOException e) {
                e.printStackTrace();
            }
            debug(contentArgs, gameState, warriors, gameId);
        }
    }

    private static void debug(String contentArgs, GameState gameState, WarriorsAPI warriors,String gameId) {

        String [] dice = contentArgs.split(",");
        for (String var : dice){
            int valeurDe = Integer.parseInt(var);
            if (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
                System.out.println(gameState.getLastLog());
                gameState = ((Warriors)warriors).nextTurnDebug(gameId, valeurDe);
            }
            else{break;}
        }
        System.out.println(gameState.getLastLog());
    }

    private static String displayMenu(Scanner sc) {
        System.out.println();
        System.out.println("================== Java Warriors ==================");
        System.out.println("1 - Commencer une partie");
        System.out.println("2 - Commencer un test");
        System.out.println("3 - Quitter");
        if (sc.hasNext()) {
            String choice = sc.nextLine();
            return choice;
        }
        return "";
    }
}

