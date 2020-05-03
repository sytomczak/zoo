package pl.sytomczak.zoo.dbUtils;

import pl.sytomczak.zoo.Food;
import pl.sytomczak.zoo.animals.birds.Bird;
import pl.sytomczak.zoo.animals.birds.Parrot;
import pl.sytomczak.zoo.animals.birds.Pigeon;
import pl.sytomczak.zoo.animals.canine.Canine;
import pl.sytomczak.zoo.animals.canine.Dog;
import pl.sytomczak.zoo.animals.canine.Wolf;
import pl.sytomczak.zoo.animals.earlessSeals.Seal;
import pl.sytomczak.zoo.animals.feline.Cat;
import pl.sytomczak.zoo.animals.feline.Feline;
import pl.sytomczak.zoo.animals.feline.Lion;
import pl.sytomczak.zoo.animals.lagomorphs.Rabbit;
import pl.sytomczak.zoo.animals.reptiles.Snake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZooModel {
    private Connection connection;

    public ZooModel(){
        this.connection = DBConnection.getConnection();
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

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Canine getCanineById(Integer id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Canine animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM canine WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    CaninesSpecies cs = CaninesSpecies.valueOf(species);
                    switch (cs)
                    {
                        case Dog:
                            animal = new Dog(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                        case Wolf:
                            animal = new Wolf(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Seal getEarlessSealsById(Integer id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Seal animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM earlessSeals WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    EarlessSealsSpecies ess = EarlessSealsSpecies.Seal.valueOf(species);
                    switch (ess) {
                        case Seal:
                            animal = new Seal(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Feline getFelineById(Integer id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Feline animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM feline WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    FelineSpecies fs = FelineSpecies.valueOf(species);
                    switch (fs)
                    {
                        case Cat:
                            animal = new Cat(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                        case Lion:
                            animal = new Lion(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Rabbit getLagomorphsById(Integer id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Rabbit animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM Lagomorphs WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    LagomorphsSpecies ls = LagomorphsSpecies.Rabbit.valueOf(species);
                    switch (ls)
                    {
                        case Rabbit:
                            animal = new Rabbit(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Snake getReptilesById(Integer id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Snake animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM reptiles WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    ReptilesSpecies res = ReptilesSpecies.valueOf(species);
                    switch (res)
                    {
                        case Snake:
                            animal = new Snake(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Canine getCanineByName(String name){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Canine animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM canine WHERE name = ?");
            ps.setString(1, name);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    CaninesSpecies cs = CaninesSpecies.valueOf(species);
                    switch (cs)
                    {
                        case Dog:
                            animal = new Dog(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                        case Wolf:
                            animal = new Wolf(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Seal getEarlessSealsByName(String name){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Seal animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM earlessSeals WHERE id = ?");
            ps.setString(1, name);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    EarlessSealsSpecies ess = EarlessSealsSpecies.Seal.valueOf(species);
                    switch (ess) {
                        case Seal:
                            animal = new Seal(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Feline getFelineByName(String name){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Feline animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM feline WHERE id = ?");
            ps.setString(1, name);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    FelineSpecies fs = FelineSpecies.valueOf(species);
                    switch (fs)
                    {
                        case Cat:
                            animal = new Cat(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                        case Lion:
                            animal = new Lion(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Rabbit getLagomorphsByName(String name){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Rabbit animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM Lagomorphs WHERE id = ?");
            ps.setString(1, name);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    LagomorphsSpecies ls = LagomorphsSpecies.Rabbit.valueOf(species);
                    switch (ls)
                    {
                        case Rabbit:
                            animal = new Rabbit(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public Snake getReptilesByName(String name){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Snake animal = null;

        try {
            ps = this.connection.prepareStatement("SELECT * FROM reptiles WHERE id = ?");
            ps.setString(1, name);

            rs = ps.executeQuery();
            if(rs.next()) {
                String species = rs.getString("species");

                if(species != "")
                {
                    ReptilesSpecies res = ReptilesSpecies.valueOf(species);
                    switch (res)
                    {
                        case Snake:
                            animal = new Snake(rs.getInt("id"),rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage"));
                            break;
                    }
                }
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

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return birds;
    }

    public ArrayList<Canine> getCanine() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Canine> canines = new ArrayList<>();

        try {
            ps = this.connection.prepareStatement("SELECT * FROM canine");
            rs = ps.executeQuery();
            while (rs.next()) {
                String species = rs.getString("species");

                if (species != "") {
                    CaninesSpecies cs = CaninesSpecies.valueOf(species);
                    switch (cs) {
                        case Dog:
                            canines.add(new Dog(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage")));
                            break;
                        case Wolf:
                            canines.add(new Wolf(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage")));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return canines;
    }

    public ArrayList<Seal> getEarlessSeals() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Seal> seals = new ArrayList<>();

        try {
            ps = this.connection.prepareStatement("SELECT * FROM earlessSeals");
            rs = ps.executeQuery();
            while (rs.next()) {
                String species = rs.getString("species");

                if (species != "") {
                    EarlessSealsSpecies ess = EarlessSealsSpecies.Seal.valueOf(species);
                    switch (ess) {
                        case Seal:
                            seals.add(new Seal(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage")));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return seals;
    }

    public ArrayList<Feline> getFeline() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Feline> feline = new ArrayList<>();

        try {
            ps = this.connection.prepareStatement("SELECT * FROM feline");
            rs = ps.executeQuery();
            while (rs.next()) {
                String species = rs.getString("species");

                if (species != "") {
                    FelineSpecies fs = FelineSpecies.valueOf(species);
                    switch (fs) {
                        case Cat:
                            feline.add(new Cat(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage")));
                            break;
                        case Lion:
                            feline.add(new Lion(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage")));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return feline;
    }

    public ArrayList<Rabbit> getLagomorps() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Rabbit> rabbits = new ArrayList<>();

        try {
            ps = this.connection.prepareStatement("SELECT * FROM lagomorphs");
            rs = ps.executeQuery();
            while (rs.next()) {
                String species = rs.getString("species");

                if (species != "") {
                    LagomorphsSpecies ls = LagomorphsSpecies.Rabbit.valueOf(species);
                    switch (ls) {
                        case Rabbit:
                            rabbits.add(new Rabbit(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage")));
                            break;

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rabbits;
    }

    public ArrayList<Snake> getReptiles() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Snake> reptiles = new ArrayList<>();

        try {
            ps = this.connection.prepareStatement("SELECT * FROM reptiles");
            rs = ps.executeQuery();
            while (rs.next()) {
                String species = rs.getString("species");

                if (species != "") {
                    ReptilesSpecies res = ReptilesSpecies.valueOf(species);
                    switch (res) {
                        case Snake:
                            reptiles.add(new Snake(rs.getInt("id"), rs.getString("name"), rs.getString("species"),
                                    rs.getInt("age"), rs.getString("move"), rs.getString("sleep"), rs.getString("eat"),
                                    rs.getString("vetAction"), rs.getString("sound"), rs.getString("color"), Food.valueOf(rs.getString("food")),
                                    rs.getBoolean("male"), rs.getInt("weight"), rs.getInt("numberOfMeals"), rs.getInt("locationXInCage"),
                                    rs.getInt("locationYInCage")));
                            break;

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return reptiles;
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

    public boolean addCanine(Canine canine) {
        if (canine == null)
            return false;

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = this.connection.prepareStatement("SELECT * from canine WHERE id = ? AND name = ?");
            ps.setInt(1, canine.getId());
            ps.setString(2, canine.getName());
            rs = ps.executeQuery();

            if(rs.next())
                return  false;

            ps = this.connection.prepareStatement("INSERT INTO canine(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage)" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, canine.getName());
            ps.setString(2, canine.getSpecies());
            ps.setInt(3, canine.getAge());
            ps.setString(4, canine.getMove());
            ps.setString(5, canine.getSleep());
            ps.setString(6, canine.getSleep());
            ps.setString(7, canine.getEat());
            ps.setString(8, canine.getVetAction());
            ps.setString(9, canine.getSound());
            ps.setString(10, canine.getColor());
            ps.setString(11, canine.getFood().toString());
            ps.setBoolean(12, canine.isMale());
            ps.setInt(13, canine.getWeight());
            ps.setInt(14, canine.getNumberOfMealsInDay());
            ps.setInt(15, canine.getLocationX());
            ps.setInt(16, canine.getLocationY());

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addEarlessSeals(Seal seal) {
        if (seal == null)
            return false;

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = this.connection.prepareStatement("SELECT * from seal WHERE id = ? AND name = ?");
            ps.setInt(1, seal.getId());
            ps.setString(2, seal.getName());
            rs = ps.executeQuery();

            if(rs.next())
                return  false;

            ps = this.connection.prepareStatement("INSERT INTO seal(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage)" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, seal.getName());
            ps.setString(2, seal.getSpecies());
            ps.setInt(3, seal.getAge());
            ps.setString(4, seal.getMove());
            ps.setString(5, seal.getSleep());
            ps.setString(6, seal.getSleep());
            ps.setString(7, seal.getEat());
            ps.setString(8, seal.getVetAction());
            ps.setString(9, seal.getSound());
            ps.setString(10, seal.getColor());
            ps.setString(11, seal.getFood().toString());
            ps.setBoolean(12, seal.isMale());
            ps.setInt(13, seal.getWeight());
            ps.setInt(14, seal.getNumberOfMealsInDay());
            ps.setInt(15, seal.getLocationX());
            ps.setInt(16, seal.getLocationY());

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addFeline(Feline feline) {
        if (feline == null)
            return false;

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = this.connection.prepareStatement("SELECT * from feline WHERE id = ? AND name = ?");
            ps.setInt(1, feline.getId());
            ps.setString(2, feline.getName());
            rs = ps.executeQuery();

            if(rs.next())
                return  false;

            ps = this.connection.prepareStatement("INSERT INTO feline(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage)" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, feline.getName());
            ps.setString(2, feline.getSpecies());
            ps.setInt(3, feline.getAge());
            ps.setString(4, feline.getMove());
            ps.setString(5, feline.getSleep());
            ps.setString(6, feline.getSleep());
            ps.setString(7, feline.getEat());
            ps.setString(8, feline.getVetAction());
            ps.setString(9, feline.getSound());
            ps.setString(10, feline.getColor());
            ps.setString(11, feline.getFood().toString());
            ps.setBoolean(12, feline.isMale());
            ps.setInt(13, feline.getWeight());
            ps.setInt(14, feline.getNumberOfMealsInDay());
            ps.setInt(15, feline.getLocationX());
            ps.setInt(16, feline.getLocationY());

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addLagomorphs(Rabbit rabbit) {
        if (rabbit == null)
            return false;

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = this.connection.prepareStatement("SELECT * from rabbit WHERE id = ? AND name = ?");
            ps.setInt(1, rabbit.getId());
            ps.setString(2, rabbit.getName());
            rs = ps.executeQuery();

            if(rs.next())
                return  false;

            ps = this.connection.prepareStatement("INSERT INTO rabbit(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage)" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, rabbit.getName());
            ps.setString(2, rabbit.getSpecies());
            ps.setInt(3, rabbit.getAge());
            ps.setString(4, rabbit.getMove());
            ps.setString(5, rabbit.getSleep());
            ps.setString(6, rabbit.getSleep());
            ps.setString(7, rabbit.getEat());
            ps.setString(8, rabbit.getVetAction());
            ps.setString(9, rabbit.getSound());
            ps.setString(10, rabbit.getColor());
            ps.setString(11, rabbit.getFood().toString());
            ps.setBoolean(12, rabbit.isMale());
            ps.setInt(13, rabbit.getWeight());
            ps.setInt(14, rabbit.getNumberOfMealsInDay());
            ps.setInt(15, rabbit.getLocationX());
            ps.setInt(16, rabbit.getLocationY());

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addReptiles(Snake snake) {
        if (snake == null)
            return false;

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = this.connection.prepareStatement("SELECT * from reptiles WHERE id = ? AND name = ?");
            ps.setInt(1, snake.getId());
            ps.setString(2, snake.getName());
            rs = ps.executeQuery();

            if(rs.next())
                return  false;

            ps = this.connection.prepareStatement("INSERT INTO reptiles(name, species, age, move, sleep, eat, vetAction, sound, color, food, male, weight, numberOfMeals, locationXInCage, locationYInCage)" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, snake.getName());
            ps.setString(2, snake.getSpecies());
            ps.setInt(3, snake.getAge());
            ps.setString(4, snake.getMove());
            ps.setString(5, snake.getSleep());
            ps.setString(6, snake.getSleep());
            ps.setString(7, snake.getEat());
            ps.setString(8, snake.getVetAction());
            ps.setString(9, snake.getSound());
            ps.setString(10, snake.getColor());
            ps.setString(11, snake.getFood().toString());
            ps.setBoolean(12, snake.isMale());
            ps.setInt(13, snake.getWeight());
            ps.setInt(14, snake.getNumberOfMealsInDay());
            ps.setInt(15, snake.getLocationX());
            ps.setInt(16, snake.getLocationY());

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

    public boolean updateCanine(Canine canine) {
        if (canine == null)
            return false;

        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement("UPDATE canine SET name = ?, species = ?, age = ?, move = ?, sleep = ?, eat = ?, vetAction = ?, sound = ?, color = ?, food = ?, male = ?, weight = ?, numberOfMeals = ?, locationXInCage = ?, locationYInCage = ? WHERE id = ?");
            ps.setString(1, canine.getName());
            ps.setString(2, canine.getSpecies());
            ps.setInt(3, canine.getAge());
            ps.setString(4, canine.getMove());
            ps.setString(5, canine.getSleep());
            ps.setString(6, canine.getEat());
            ps.setString(7, canine.getVetAction());
            ps.setString(8, canine.getSound());
            ps.setString(9, canine.getColor());
            ps.setString(10, canine.getFood().toString());
            ps.setBoolean(11, canine.isMale());
            ps.setInt(12, canine.getWeight());
            ps.setInt(13, canine.getNumberOfMealsInDay());
            ps.setInt(14, canine.getLocationX());
            ps.setInt(15, canine.getLocationY());
            ps.setInt(16, canine.getId());

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateEarlessSeals(Seal seal) {
        if (seal == null)
            return false;

        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement("UPDATE seaks SET name = ?, species = ?, age = ?, move = ?, sleep = ?, eat = ?, vetAction = ?, sound = ?, color = ?, food = ?, male = ?, weight = ?, numberOfMeals = ?, locationXInCage = ?, locationYInCage = ? WHERE id = ?");
            ps.setString(1, seal.getName());
            ps.setString(2, seal.getSpecies());
            ps.setInt(3, seal.getAge());
            ps.setString(4, seal.getMove());
            ps.setString(5, seal.getSleep());
            ps.setString(6, seal.getEat());
            ps.setString(7, seal.getVetAction());
            ps.setString(8, seal.getSound());
            ps.setString(9, seal.getColor());
            ps.setString(10, seal.getFood().toString());
            ps.setBoolean(11, seal.isMale());
            ps.setInt(12, seal.getWeight());
            ps.setInt(13, seal.getNumberOfMealsInDay());
            ps.setInt(14, seal.getLocationX());
            ps.setInt(15, seal.getLocationY());
            ps.setInt(16, seal.getId());

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateFeline(Feline feline) {
        if (feline == null)
            return false;

        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement("UPDATE feline SET name = ?, species = ?, age = ?, move = ?, sleep = ?, eat = ?, vetAction = ?, sound = ?, color = ?, food = ?, male = ?, weight = ?, numberOfMeals = ?, locationXInCage = ?, locationYInCage = ? WHERE id = ?");
            ps.setString(1, feline.getName());
            ps.setString(2, feline.getSpecies());
            ps.setInt(3, feline.getAge());
            ps.setString(4, feline.getMove());
            ps.setString(5, feline.getSleep());
            ps.setString(6, feline.getEat());
            ps.setString(7, feline.getVetAction());
            ps.setString(8, feline.getSound());
            ps.setString(9, feline.getColor());
            ps.setString(10, feline.getFood().toString());
            ps.setBoolean(11, feline.isMale());
            ps.setInt(12, feline.getWeight());
            ps.setInt(13, feline.getNumberOfMealsInDay());
            ps.setInt(14, feline.getLocationX());
            ps.setInt(15, feline.getLocationY());
            ps.setInt(16, feline.getId());

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateLagomorphs(Rabbit rabbit) {
        if (rabbit == null)
            return false;

        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement("UPDATE lagomorphs SET name = ?, species = ?, age = ?, move = ?, sleep = ?, eat = ?, vetAction = ?, sound = ?, color = ?, food = ?, male = ?, weight = ?, numberOfMeals = ?, locationXInCage = ?, locationYInCage = ? WHERE id = ?");
            ps.setString(1, rabbit.getName());
            ps.setString(2, rabbit.getSpecies());
            ps.setInt(3, rabbit.getAge());
            ps.setString(4, rabbit.getMove());
            ps.setString(5, rabbit.getSleep());
            ps.setString(6, rabbit.getEat());
            ps.setString(7, rabbit.getVetAction());
            ps.setString(8, rabbit.getSound());
            ps.setString(9, rabbit.getColor());
            ps.setString(10, rabbit.getFood().toString());
            ps.setBoolean(11, rabbit.isMale());
            ps.setInt(12, rabbit.getWeight());
            ps.setInt(13, rabbit.getNumberOfMealsInDay());
            ps.setInt(14, rabbit.getLocationX());
            ps.setInt(15, rabbit.getLocationY());
            ps.setInt(16, rabbit.getId());

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateReptiles(Snake snake) {
        if (snake == null)
            return false;

        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement("UPDATE retiles SET name = ?, species = ?, age = ?, move = ?, sleep = ?, eat = ?, vetAction = ?, sound = ?, color = ?, food = ?, male = ?, weight = ?, numberOfMeals = ?, locationXInCage = ?, locationYInCage = ? WHERE id = ?");
            ps.setString(1, snake.getName());
            ps.setString(2, snake.getSpecies());
            ps.setInt(3, snake.getAge());
            ps.setString(4, snake.getMove());
            ps.setString(5, snake.getSleep());
            ps.setString(6, snake.getEat());
            ps.setString(7, snake.getVetAction());
            ps.setString(8, snake.getSound());
            ps.setString(9, snake.getColor());
            ps.setString(10, snake.getFood().toString());
            ps.setBoolean(11, snake.isMale());
            ps.setInt(12, snake.getWeight());
            ps.setInt(13, snake.getNumberOfMealsInDay());
            ps.setInt(14, snake.getLocationX());
            ps.setInt(15, snake.getLocationY());
            ps.setInt(16, snake.getId());

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
