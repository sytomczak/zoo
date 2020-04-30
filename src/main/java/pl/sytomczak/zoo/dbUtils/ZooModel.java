package pl.sytomczak.zoo.dbUtils;

import pl.sytomczak.zoo.animals.Animal;
import pl.sytomczak.zoo.animals.birds.Bird;
import pl.sytomczak.zoo.animals.birds.Parrot;
import pl.sytomczak.zoo.animals.birds.Pigeon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZooModel {
    private Connection connection;

    public ZooModel(){
        this.connection = DBConnection.getConnection();
        // ookok
    }

    public Bird getBirdById(Integer id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Animal animal = null;

        try{
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
                            animal = new Parrot();

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
