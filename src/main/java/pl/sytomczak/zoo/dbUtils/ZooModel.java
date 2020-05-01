package pl.sytomczak.zoo.dbUtils;

import com.sun.org.apache.xpath.internal.operations.Bool;
import pl.sytomczak.zoo.Food;
import pl.sytomczak.zoo.animals.Animal;
import pl.sytomczak.zoo.animals.birds.Bird;
import pl.sytomczak.zoo.animals.birds.Parrot;
import pl.sytomczak.zoo.animals.birds.Pigeon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZooModel {
    private Connection connection;

    public ZooModel(){
        this.connection = DBConnection.getConnection();
        // ookok
    }

    public Bird getBirdById(Integer id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Bird animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM birds WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    Birdspecies bs = Birdspecies.valueOf(species);
                    switch (bs)
                    {
                        case Parrot:
                            animal = new Parrot(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                        case Pigeon:
                            animal = new Pigeon(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }

                // do dorobienia tabele gatunkow np birdSpecies, canineSpecies itd. i potem sprawdzenie nazw po idSpecies i dorzucenie switcha, gdzie bedzie wybor
                // gatunku ptaka. mozna dodac jeszcze nameSpecies do species albo ogolnie utworzyc nowa klase Species i w niej propertiesy: id, name

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Bird getBirdByName(String name){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Bird animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM birds WHERE name = ?");
            ps.setString(1, name);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    Birdspecies bs = Birdspecies.valueOf(species);
                    switch (bs)
                    {
                        case Parrot:
                            animal = new Parrot(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                        case Pigeon:
                            animal = new Pigeon(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }

                // do dorobienia tabele gatunkow np birdSpecies, canineSpecies itd. i potem sprawdzenie nazw po idSpecies i dorzucenie switcha, gdzie bedzie wybor
                // gatunku ptaka. mozna dodac jeszcze nameSpecies do species albo ogolnie utworzyc nowa klase Species i w niej propertiesy: id, name

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public ArrayList<Bird> getBirds() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Bird> birds = new ArrayList<>();

        try {
            ps = this.connection.prepareStatement("SELECT * FROM birds");
            rs = ps.executeQuery();
            while (rs.next()) {
                String species = rs.getString("species");

                if (species != "") {
                    Birdspecies bs = Birdspecies.valueOf(species);
                    switch (bs) {
                        case Parrot:
                            birds.add(new Parrot(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage")));
                            break;
                        case Pigeon:
                            birds.add(new Pigeon(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage")));
                            break;
                    }
                }

                // do dorobienia tabele gatunkow np birdSpecies, canineSpecies itd. i potem sprawdzenie nazw po idSpecies i dorzucenie switcha, gdzie bedzie wybor
                // gatunku ptaka. mozna dodac jeszcze nameSpecies do species albo ogolnie utworzyc nowa klase Species i w niej propertiesy: id, name

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return birds;
    }

    public boolean addBird(Bird bird) {
        if (bird == null)
            return false;

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = this.connection.prepareStatement("SELECT * from birds WHERE id = ? AND name = ?");
            ps.setInt(1, bird.getId());
            ps.setString(2, bird.getName());
            rs = ps.executeQuery();

            // sprawdzenie w bazie czy bird z takim id i name istnieje, jak tak to nie dodaje i zwraca false
            if(rs.next())
                return  false;

            ps = this.connection.prepareStatement("INSERT INTO birds(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage)" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, bird.getName());
            ps.setString(2, bird.getSpecies());
            ps.setInt(3, bird.getAge());
            ps.setString(4, bird.getMove());
            ps.setString(5, bird.getSleep());
            ps.setString(6, bird.getSleep());
            ps.setString(7, bird.getEat());
            ps.setString(8, bird.getVetAction());
            ps.setString(9, bird.getSound());
            ps.setString(10, bird.getColor());
            ps.setString(11, bird.getFood().toString());
            ps.setBoolean(12, bird.isMale());
            ps.setInt(13, bird.getWeight());
            ps.setInt(14, bird.getNumberOfMealsInDay());
            ps.setInt(15, bird.getLocationX());
            ps.setInt(16, bird.getLocationY());

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBird(Bird bird) {
        if (bird == null)
            return false;

        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement("UPDATE birds SET name = ?, species = ?, age = ?, move = ?, sleep = ?, eat = ?, vetAction = ?, sound = ?, color = ?, food = ?, male = ?, weight = ?, numberOfMeals = ?, locationXInCage = ?, locationYInCage = ? WHERE id = ?");
            ps.setString(1, bird.getName());
            ps.setString(2, bird.getSpecies());
            ps.setInt(3, bird.getAge());
            ps.setString(4, bird.getMove());
            ps.setString(5, bird.getSleep());
            ps.setString(6, bird.getEat());
            ps.setString(7, bird.getVetAction());
            ps.setString(8, bird.getSound());
            ps.setString(9, bird.getColor());
            ps.setString(10, bird.getFood().toString());
            ps.setBoolean(11, bird.isMale());
            ps.setInt(12, bird.getWeight());
            ps.setInt(13, bird.getNumberOfMealsInDay());
            ps.setInt(14, bird.getLocationX());
            ps.setInt(15, bird.getLocationY());
            ps.setInt(16, bird.getId());

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public enum Birdspecies{
        Parrot,
        Pigeon
    }

    public enum CaninesSpecies
    {
        Dog,
        Wolf
    }

    public enum EarlessSealsSpecies{
        Seal,
    }

    public enum FelineSpecies
    {
        Cat,
        Lion
    }

    public enum LagomorphsSpecies{
        Rabbit
    }

    public enum ReptilesSpecies{
        Snake
    }
}
