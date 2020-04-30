package pl.sytomczak.zoo.dbUtils;

import pl.sytomczak.zoo.animals.Animal;
import pl.sytomczak.zoo.animals.birds.Bird;
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

    public Animal getBirdByNr(Integer nr){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = this.connection.prepareStatement("SELECT * FROM birds WHERE nr = ?");
            ps.setInt(1, nr);

            rs = ps.executeQuery();
            if(rs.next()) {
                Integer idSpecies = rs.getInt("isSpecies");

                // do dorobienia tabele gatunkow np birdSpecies, canineSpecies itd. i potem sprawdzenie nazw po idSpecies i dorzucenie switcha, gdzie bedzie wybor
                // gatunku ptaka. mozna dodac jeszcze nameSpecies do species albo ogolnie utworzyc nowa klase Species i w niej propertiesy: id, name

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
