package pl.sytomczak.zoo.dbUtils;

import java.io.File;
import java.sql.*;

public class DBConnection {
    private static String USERNAME = "dbUser";
    private static String PASSWORD = "dbPassword";
    private static String MYSQLCONN = "jdbc:mysql://localhost/login";
    private static String DBFILEPATH = "zoo.sqlite";
    private static String SQLITECONN = "jdbc:sqlite:"+DBFILEPATH; // jdbc:sqlite:sciezkaDoBazyDanych (na windowsie folder musi istniec, inaczej exception, nie wiem jak jest na linuxie) np. jdbc:sqlite:/GIT/notepad/db/myDatabase.db

    public static Connection getConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            File file = new File(DBFILEPATH);
            if(!file.exists())
            {
                Connection conn = DriverManager.getConnection(SQLITECONN);
                createTables();
                return conn;
            }
            //if(jesli baza danych nie istnieje)
                //CreateDatabase("zoo.sqlite");
            return DriverManager.getConnection(SQLITECONN);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // tworzenie bazy danych z konkretna nazwa tzn. pliku bazy danych z X nazwa np zoo.sqlite
//    public static void CreateDatabase(String fileName){
//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:"+fileName)){
//            if(conn != null)
//            {
//                DatabaseMetaData meta = conn.getMetaData();
//                System.out.println("Nazwa Drivera bazy danych: " + meta.getDriverName());
//                System.out.println("Baza danych utworzona");
//
//     //można tutaj dodac tworzenie tabel itd. albo wywolac tutaj metode do tworzenia tabel itd.
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    private static boolean createTables() {
        try {

            // birds
            String sql = "CREATE TABLE if not exists birds (\n" +
                    "    id              INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name            VARCHAR (100),\n" +
                    "    species         VARCHAR (50),\n"  +
                    "    age             INTEGER,\n" +
                    "    move            VARCHAR (50),\n" +
                    "    sleep           VARCHAR (50),\n" +
                    "    eat             VARCHAR (50),\n" +
                    "    vetAction       VARCHAR (50),\n" +
                    "    sound           VARCHAR (50),\n" +
                    "    color           VARCHAR (50),\n" +
                    "    food            VARCHAR (50),\n" +
                    "    male            BOOLEAN,\n" +
                    "    weight          INTEGER,\n" +
                    "    numberOfMeals   INTEGER,\n" +
                    "    locationXInCage INTEGER,\n" +
                    "    locationYInCage INTEGER\n" +
                    ");\n";

            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.executeUpdate();

            // canines
            sql = "CREATE TABLE if not exists canines (\n" +
                    "    id              INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name            VARCHAR (100),\n" +
                    "    species         VARCHAR (50),\n"  +
                    "    age             INTEGER,\n" +
                    "    move            VARCHAR (50),\n" +
                    "    sleep           VARCHAR (50),\n" +
                    "    eat             VARCHAR (50),\n" +
                    "    vetAction       VARCHAR (50),\n" +
                    "    sound           VARCHAR (50),\n" +
                    "    color           VARCHAR (50),\n" +
                    "    food            VARCHAR (50),\n" +
                    "    male            BOOLEAN,\n" +
                    "    weight          INTEGER,\n" +
                    "    numberOfMeals   INTEGER,\n" +
                    "    locationXInCage INTEGER,\n" +
                    "    locationYInCage INTEGER\n" +
                    ");\n";

            ps = getConnection().prepareStatement(sql);
            ps.executeUpdate();

            // eareless Seals
            sql = "CREATE TABLE if not exists earlessSeals (\n" +
                    "    id              INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name            VARCHAR (100),\n" +
                    "    species         VARCHAR (50),\n"  +
                    "    age             INTEGER,\n" +
                    "    move            VARCHAR (50),\n" +
                    "    sleep           VARCHAR (50),\n" +
                    "    eat             VARCHAR (50),\n" +
                    "    vetAction       VARCHAR (50),\n" +
                    "    sound           VARCHAR (50),\n" +
                    "    color           VARCHAR (50),\n" +
                    "    food            VARCHAR (50),\n" +
                    "    male            BOOLEAN,\n" +
                    "    weight          INTEGER,\n" +
                    "    numberOfMeals   INTEGER,\n" +
                    "    locationXInCage INTEGER,\n" +
                    "    locationYInCage INTEGER\n" +
                    ");\n";

            ps = getConnection().prepareStatement(sql);
            ps.executeUpdate();

            // felines
            sql = "CREATE TABLE if not exists felines (\n" +
                    "    id              INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name            VARCHAR (100),\n" +
                    "    species         VARCHAR (50),\n"  +
                    "    age             INTEGER,\n" +
                    "    move            VARCHAR (50),\n" +
                    "    sleep           VARCHAR (50),\n" +
                    "    eat             VARCHAR (50),\n" +
                    "    vetAction       VARCHAR (50),\n" +
                    "    sound           VARCHAR (50),\n" +
                    "    color           VARCHAR (50),\n" +
                    "    food            VARCHAR (50),\n" +
                    "    male            BOOLEAN,\n" +
                    "    weight          INTEGER,\n" +
                    "    numberOfMeals   INTEGER,\n" +
                    "    locationXInCage INTEGER,\n" +
                    "    locationYInCage INTEGER\n" +
                    ");\n";

            ps = getConnection().prepareStatement(sql);
            ps.executeUpdate();

            // lagomorphs
            sql = "CREATE TABLE if not exists lagomorphs (\n" +
                    "    id              INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name            VARCHAR (100),\n" +
                    "    species         VARCHAR (50),\n"  +
                    "    age             INTEGER,\n" +
                    "    move            VARCHAR (50),\n" +
                    "    sleep           VARCHAR (50),\n" +
                    "    eat             VARCHAR (50),\n" +
                    "    vetAction       VARCHAR (50),\n" +
                    "    sound           VARCHAR (50),\n" +
                    "    color           VARCHAR (50),\n" +
                    "    food            VARCHAR (50),\n" +
                    "    male            BOOLEAN,\n" +
                    "    weight          INTEGER,\n" +
                    "    numberOfMeals   INTEGER,\n" +
                    "    locationXInCage INTEGER,\n" +
                    "    locationYInCage INTEGER\n" +
                    ");\n";

            ps = getConnection().prepareStatement(sql);
            ps.executeUpdate();

            // reptiles
            sql = "CREATE TABLE if not exists reptiles (\n" +
                    "    id              INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name            VARCHAR (100),\n" +
                    "    species         VARCHAR (50),\n"  +
                    "    age             INTEGER,\n" +
                    "    move            VARCHAR (50),\n" +
                    "    sleep           VARCHAR (50),\n" +
                    "    eat             VARCHAR (50),\n" +
                    "    vetAction       VARCHAR (50),\n" +
                    "    sound           VARCHAR (50),\n" +
                    "    color           VARCHAR (50),\n" +
                    "    food            VARCHAR (50),\n" +
                    "    male            BOOLEAN,\n" +
                    "    weight          INTEGER,\n" +
                    "    numberOfMeals   INTEGER,\n" +
                    "    locationXInCage INTEGER,\n" +
                    "    locationYInCage INTEGER\n" +
                    ");\n";

            ps = getConnection().prepareStatement(sql);
            ps.executeUpdate();

            Statement statement = getConnection().createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("INSERT INTO birdsSpecies(name) VALUES('Parrot')");
            statement.executeUpdate("INSERT INTO birdsSpecies(name) VALUES('Pigeon')");

            statement.executeUpdate("INSERT INTO caninesSpecies(name) VALUES('Dog')");
            statement.executeUpdate("INSERT INTO caninesSpecies(name) VALUES('Wolf')");

            statement.executeUpdate("INSERT INTO earlessSealsSpecies(name) VALUES('Foczi')");

            statement.executeUpdate("INSERT INTO felinesSpecies(name) VALUES('Cat')");
            statement.executeUpdate("INSERT INTO felinesSpecies(name) VALUES('Lion')");

            statement.executeUpdate("INSERT INTO lagomorphsSpecies(name) VALUES('Rabbit')");

            statement.executeUpdate("INSERT INTO reptilesSpecies(name) VALUES('Snake')");


            statement.executeUpdate("INSERT INTO birds(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Alex', 'Parrot', 6, 'Move like animal', 'Sleep like bird', 'Eat like bird', 'SURGERY', 'Shout', 'Yellow', 'SEEDS', true, 1, 6, 5, 5)");
            statement.executeUpdate("INSERT INTO canines(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Arya', 'Dog', 6, 'Move like dog', 'Sleep on back', 'Eat like canine', 'SURGERY', 'Hau Hau', 'Black', 'MEAT', false, 32, 2, 5, 5)");
            statement.executeUpdate("INSERT INTO earlessSeals(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Foczi', 'Foczi', 24, 'Swim', 'Sleep like animal', 'Eat like animal', '', 'Mooore food', 'Blue', 'FISH', false, 30, 4, 2, 2)");
            // do wypelnienia poprawnie valuesy
            statement.executeUpdate("INSERT INTO felines(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Foczi', 'Foczi', 24, 'Swim', 'Sleep like animal', 'Eat like animal', '', 'Mooore food', 'Blue', 'FISH', false, 30, 4, 2, 2)");
            statement.executeUpdate("INSERT INTO felines(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Foczi', 'Foczi', 24, 'Swim', 'Sleep like animal', 'Eat like animal', '', 'Mooore food', 'Blue', 'FISH', false, 30, 4, 2, 2)");
            statement.executeUpdate("INSERT INTO lagomorphs(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Foczi', 'Foczi', 24, 'Swim', 'Sleep like animal', 'Eat like animal', '', 'Mooore food', 'Blue', 'FISH', false, 30, 4, 2, 2)");
            statement.executeUpdate("INSERT INTO reptiles(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Foczi', 'Foczi', 24, 'Swim', 'Sleep like animal', 'Eat like animal', '', 'Mooore food', 'Blue', 'FISH', false, 30, 4, 2, 2)");

            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }
    }

}
