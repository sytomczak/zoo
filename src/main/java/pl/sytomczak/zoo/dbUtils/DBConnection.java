package pl.sytomczak.zoo.dbUtils;

import java.io.File;
import java.sql.*;

public class DBConnection {
    private static String USERNAME = "dbUser";
    private static String PASSWORD = "dbPassword";
    private static String MYSQLCONN = "jdbc:mysql://localhost/login";
    private static String DBFILEPATH = "zoo.sqlite";
    private static String SQLITECONN = "jdbc:sqlite:"+DBFILEPATH;

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
            return DriverManager.getConnection(SQLITECONN);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    private static boolean createTables() {
        try {

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
            statement.setQueryTimeout(30);

            statement.executeUpdate("INSERT INTO birds(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Alex', 'Parrot', 6, 'Move like animal', 'Sleep like bird', 'Eat like bird', 'SURGERY', 'Shout', 'Yellow', 'SEEDS', 1, 1, 6, 5, 5)");
            statement.executeUpdate("INSERT INTO birds(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Gru', 'Pigeon', 3, 'Move like animal', 'Sleep like bird', 'Eat like bird', '', 'Gru gru', 'Gray', 'SEEDS', 0, 1, 20, 0, 0)");
            statement.executeUpdate("INSERT INTO canines(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Arya', 'Dog', 1, 'Move like dog', 'Sleep on back', 'Eat like canine', 'SURGERY', 'Hau Hau', 'Black', 'MEAT', 0, 32, 2, 5, 5)");
            statement.executeUpdate("INSERT INTO canines(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Ares', 'Dog', 3, 'Move like dog', 'Sleep', 'Eat like canine', '', 'Grr', 'White', 'MEAT', 1, 40, 3, 6, 6)");
            statement.executeUpdate("INSERT INTO earlessSeals(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Foczi', 'Seal', 24, 'Swim', 'Sleep like animal', 'Eat like animal', '', 'Mooore food', 'Blue', 'FISH', 0, 30, 4, 2, 2)");
            statement.executeUpdate("INSERT INTO earlessSeals(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Seale', 'Seal', 21, 'Swim', 'Sleep like animal', 'Eat like animal', '', 'Mniam', 'Blue', 'SHRIMP', 1, 35, 2, 7, 7)");
            statement.executeUpdate("INSERT INTO felines(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Miumiu', 'Cat', 5, 'Move like cat', 'Sleep like animal', 'Eat like feline', 'SHOT', 'Fooooood', 'White', 'MOUSE', 1, 7, 20, 0, 0)");
            statement.executeUpdate("INSERT INTO felines(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Mufasa', 'Lion', 7, 'Move like feline', 'Sleep very long', 'Eat like feline', '', 'Rawr', 'Orange', 'LAMB', 1, 50, 1, 1, 1)");
            statement.executeUpdate("INSERT INTO lagomorphs(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Tuptuś', 'Rabbit', 2, 'kic kic', 'Sleep like animal', 'Om om Carrot', '', 'RABIT XD', 'Gray', 'CARROT', 1, 4, 50, 3, 3)");
            statement.executeUpdate("INSERT INTO lagomorphs(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Rabbitos', 'Rabbit', 5, 'kic kic', 'Sleep like rabbit', 'Hrup hrup', '', '', 'Brown', 'GRASS', 0, 2, 40, 3, 1)");
            statement.executeUpdate("INSERT INTO reptiles(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Nagini', 'Snake', 120, 'Move like animal', 'Sleep like animal', 'Eat Harry Potter', '', 'SSsss', 'Brown', 'MEAT', 0, 35, 1, 4, 4)");
            statement.executeUpdate("INSERT INTO reptiles(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage) VALUES('Boa', 'Snake', 100, 'Move like snake', 'Sleep like snake', 'Eat mouse', '', 'Ssss', 'Brown', 'ANIMAL', 1, 50, 2, 4, 1)");

            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }
    }

}
