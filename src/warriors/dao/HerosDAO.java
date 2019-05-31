package warriors.dao;

import warriors.contracts.Hero;
import warriors.engine.Guerrier;
import warriors.engine.Magicien;
import warriors.engine.Personnages;
import warriors.engine.Warriors;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class HerosDAO {

    private String url = "jdbc:mysql://localhost/donjon_dragon?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String user = "root";
    private String pwd = "";
    Scanner sc = new Scanner(System.in);
    List<Hero> listHeros;

    public HerosDAO() {

    }

    /**
     * @return
     * @throws
     */
    public List<Hero> getAllHero() {
        List<Hero> listHeros = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            statement = connection.createStatement();
            resultat = statement.executeQuery("select * from myheros");
            while (resultat.next()) {

                int idHero = resultat.getInt("idHero");
                String classe = resultat.getString("classe");
                String name = resultat.getString("name");
                int life = resultat.getInt("life");
                int attack = resultat.getInt("attack");
                int maxLife = resultat.getInt("maxLife");
                int maxAttack = resultat.getInt("maxAttack");
                String image = resultat.getString("image");

                if (classe.equals("Guerrier")) {
                    listHeros.add(new Guerrier(idHero, classe, name, life, attack, maxLife, maxAttack, image));
                } else {
                    listHeros.add(new Magicien(idHero, classe, name, life, attack, maxLife, maxAttack, image));
                }
            }
        } catch (SQLException ex) {

        } finally {
            if (resultat != null) {
                try {
                    resultat.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return listHeros;
    }

    /**
     * @return
     * @throws InputMismatchException
     */
    public Hero createHero() throws InputMismatchException {

        Connection myConnection = null;
        PreparedStatement myStatement = null;
        Personnages myHero = new Guerrier();
        try {

            System.out.println("Entrez la Classe de votre Héro : ");
            myHero.setClasse(sc.nextLine());
            System.out.println("Entrez le Nom de votre Héro : ");
            myHero.setName(sc.nextLine());
            System.out.println("Entrez la Vie de votre Héro : ");
            myHero.setNiveauVie(sc.nextInt());
            System.out.println("Entrez l'Attaque de votre Héro : ");
            myHero.setAttackLevel(sc.nextInt());
            System.out.println("Entrez la Vie maximum de votre Héro : ");
            myHero.setMaxLife(sc.nextInt());
            System.out.println("Entrez l'Attaque maximum de votre Héro : ");
            myHero.setMaxAttackLevel(sc.nextInt());


            //Get connection to database
            myConnection = DriverManager.getConnection(url, user, pwd);
            //Prepare statement
            myStatement = myConnection.prepareStatement("INSERT into myheros(classe, name, life, attack, maxLife, maxAttack)VALUE (?,?,?,?,?,?)");
            //Set the parameters
            myStatement.setString(1, myHero.getClasse());
            myStatement.setString(2, myHero.getName());
            myStatement.setInt(3, myHero.getLife());
            myStatement.setInt(4, myHero.getAttackLevel());
            myStatement.setInt(5, myHero.getMaxLife());
            myStatement.setInt(6, myHero.getMaxAttackLevel());
            myStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myHero;
    }

    /**
     * @throws InputMismatchException
     */
    public void deleteHero() throws InputMismatchException {
        displayHero(true);
        System.out.println(" Quel héro voulez-vous supprimer ?");
        try {
            int id = sc.nextInt();
            String sql = "delete from myheros where idhero =" + id;
            Connection connection = DriverManager.getConnection(url, user, pwd);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws InputMismatchException
     */
    public void modifyHero() throws InputMismatchException {

        displayHero(true);
        System.out.println(" Quel héro voulez-vous modifier ?");
        Personnages modifyHero = (Personnages) listHeros.get(sc.nextInt() - 1);

        try {
            Connection connection = DriverManager.getConnection(url, user, pwd);
            Scanner scan = new Scanner(System.in);
            System.out.println(" voulez-vous modifier la vie ?");
            System.out.println("1 - Oui");
            System.out.println("2 - Non");
            if (scan.nextLine().equals("1")) {
                System.out.println(" nouvelle vie :");
                modifyHero.setNiveauVie(scan.nextInt());
            }
            scan.nextLine();
            System.out.println(" voulez-vous modifier le nom ?");
            System.out.println("1 - Oui");
            System.out.println("2 - Non");
            if (scan.nextLine().equals("1")) {
                System.out.println(" nouveau nom :");
                modifyHero.setName(scan.nextLine());
            }
            System.out.println(" voulez-vous modifier l'attaque?");
            System.out.println("1 - Oui");
            System.out.println("2 - Non");
            if (scan.nextLine().equals("1")) {
                System.out.println(" nouvelle attaque :");
                modifyHero.setAttackLevel(scan.nextInt());
            }
            String sqlQuery = "update myheros SET life = ?, name = ?, attack = ?  where idhero =" + modifyHero.getIdHero();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, modifyHero.getLife());
            preparedStatement.setString(2, modifyHero.getName());
            preparedStatement.setInt(3, modifyHero.getAttackLevel());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public void menuCrud() {

        System.out.println(" 1 - Créer un Héro");
        System.out.println(" 2 - Modifier un Héro ");
        System.out.println(" 3 - Supprimer un Héro ");

        if (sc.hasNext()) {
            String saveChoice = sc.nextLine();
            if (saveChoice.equals("1")) {
                createHero();
            } else if (saveChoice.equals("2")) {
                modifyHero();
            } else if (saveChoice.equals("3")) {
                deleteHero();
            }
        }
    }

    public List<Hero> displayHero(boolean idHero) {

        listHeros = getAllHero();
        for (int i = 0; i < listHeros.size(); i++) {
            Hero heroe = listHeros.get(i);
            System.out.println(i + 1 + " - " + heroe.getName());
            if (idHero) {
                System.out.println("    Id du Héro : " + ((Personnages) heroe).getIdHero());
            }
            System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
            System.out.println("    Niveau de vie : " + heroe.getLife());
        }
        return listHeros;
    }
}

