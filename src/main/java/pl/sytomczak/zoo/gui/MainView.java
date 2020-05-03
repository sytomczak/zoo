package pl.sytomczak.zoo.gui;

import pl.sytomczak.zoo.Vet;
import pl.sytomczak.zoo.animals.Animal;
import pl.sytomczak.zoo.animals.birds.Bird;
import pl.sytomczak.zoo.animals.birds.Parrot;
import pl.sytomczak.zoo.animals.birds.Pigeon;
import pl.sytomczak.zoo.animals.canine.Dog;
import pl.sytomczak.zoo.animals.canine.Wolf;
import pl.sytomczak.zoo.animals.earlessSeals.Seal;
import pl.sytomczak.zoo.animals.feline.*;
import pl.sytomczak.zoo.animals.lagomorphs.Rabbit;
import pl.sytomczak.zoo.dbUtils.DBConnection;
import pl.sytomczak.zoo.dbUtils.ZooModel;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;

public class MainView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox animalSelectionCombobox;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JLabel ageLabel;
    private JTextField colorTextField;
    private JLabel colorLabel;
    private JTextField mealsTextField;
    private JTextField maleTextField;
    private JTextField weightTextField;
    private JTextField foodTextField;
    private JTextField locationXTextField;
    private JTextField locationYTextField;
    private JLabel foodLabel;
    private JLabel maleLabel;
    private JLabel weightLabel;
    private JLabel mealsLabel;
    private JLabel locationXLabel;
    private JLabel locationYLabel;
    private JLabel VetActionLabel;
    private JTextField vetActionTextField;
    private JLabel soundJLabel;
    private JTextField soundTextField;
    private JLabel eatJLabel;
    private JTextField eatTextField;
    private JLabel sleepJLabel;
    private JTextField sleepTextField;
    private JLabel moveJLabel;
    private JTextField moveTextField;
    private JLabel animalSpeciesLabel;
    private JComboBox animalSpeciesCombobox;
    private JLabel animalsLabel;


    private Parrot parrot;
    private Pigeon pigeon;
    private Dog dog;
    private Wolf wolf;
    private Seal seal;
    private Cat cat;
    private Lion lion;
    private Rabbit rabbit;

    private Vet vet;

    private ArrayList<String> specieNames = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();
    private ZooModel zooModel;

    public MainView() {
        vet = new Vet();
        zooModel = new ZooModel();
        initializeSpecies();
        initializeAnimals();

        Connection con = DBConnection.getConnection();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        animalSpeciesCombobox.addActionListener(e -> animalSpeciesOnSelect());
        animalSelectionCombobox.addActionListener(e -> animalsOnSelect());
    }

    private void initializeSpecies(){
        if(specieNames == null)
            specieNames = new ArrayList<>();
        else
            specieNames.clear();

        specieNames.add("Birds");
        specieNames.add("Canines");
        specieNames.add("Earless Seals");
        specieNames.add("Felines");
        specieNames.add("Lagomorphs");
        specieNames.add("Reptiles");

        for(int i=0;i<specieNames.size();i++)
        animalSpeciesCombobox.addItem(specieNames.get(i));

//
//import pl.sytomczak.zoo.animals.Animal;
//import pl.sytomczak.zoo.animals.birds.Bird;
//import pl.sytomczak.zoo.animals.birds.Pigeon;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ZooModel {
//    private Connection connection;
//
//    public ZooModel(){
//        this.connection = DBConnection.getConnection();
//    }
//
//    public Animal getBirdByNr(Integer nr){
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try{
//            ps = this.connection.prepareStatement("SELECT * FROM birds WHERE nr = ?");
//            ps.setInt(1, nr);
//
//            rs = ps.executeQuery();
//            if(rs.next()) {
//                Integer idSpecies = rs.getInt("isSpecies");
//
//                // do dorobienia tabele gatunkow np birdSpecies, canineSpecies itd. i potem sprawdzenie nazw po idSpecies i dorzucenie switcha, gdzie bedzie wybor
//                // gatunku ptaka. mozna dodac jeszcze nameSpecies do species albo ogolnie utworzyc nowa klase Species i w niej propertiesy: id, name
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//}

    }

    private void initializeAnimals() {

        if (animals == null)
            animals = new ArrayList<>();
        else
            animals.clear();

    }


    private void animalSpeciesOnSelect() {

      try{
          animalSelectionCombobox.removeAllItems();
          if(animalSpeciesCombobox.getModel().getSelectedItem() == "Birds"){
              ArrayList<Bird>  birds = zooModel.getBirds();
              for(int i=0;i< birds.size();i++)
                  animalSelectionCombobox.addItem(birds.get(i).getName());
          }
          //animalSpeciesCombobox.getModel().getSelectedItem()
      }catch (Exception ex)
      {
          ex.printStackTrace();
      }
    }

    private void animalsOnSelect() {
        switch ((String) animalSelectionCombobox.getSelectedItem()) {
            case "Pigeon":
                nameTextField.setText(pigeon.getName());
                foodTextField.setText(String.valueOf(pigeon.getFood()));
                moveTextField.setText(pigeon.move());
                sleepTextField.setText(pigeon.sleep());
                eatTextField.setText(pigeon.eat());
                soundTextField.setText(pigeon.makeASound());
                ageTextField.setText(String.valueOf(parrot.getAge()));
                colorTextField.setText(pigeon.getColor());
                maleTextField.setText(String.valueOf(pigeon.isMale()));
                weightTextField.setText(String.valueOf(pigeon.getWeight()));
                mealsTextField.setText(String.valueOf(pigeon.getNumberOfMealsInDay()));
                vetActionTextField.setText(String.valueOf(pigeon.getVetAction()));
                locationXTextField.setText(String.valueOf(pigeon.getLocationX()));
                locationYTextField.setText(String.valueOf(pigeon.getLocationY()));
                break;

            case "Parrot":
                nameTextField.setText(parrot.getName());
                foodTextField.setText(String.valueOf(parrot.getFood()));
                moveTextField.setText(parrot.move());
                sleepTextField.setText(parrot.sleep());
                eatTextField.setText(parrot.eat());
                soundTextField.setText(parrot.makeASound());
                ageTextField.setText(String.valueOf(parrot.getAge()));
                colorTextField.setText(parrot.getColor());
                maleTextField.setText(String.valueOf(parrot.isMale()));
                weightTextField.setText(String.valueOf(parrot.getWeight()));
                mealsTextField.setText(String.valueOf(parrot.getNumberOfMealsInDay()));
                vetActionTextField.setText(String.valueOf(parrot.getVetAction()));
                locationXTextField.setText(String.valueOf(parrot.getLocationX()));
                locationYTextField.setText(String.valueOf(parrot.getLocationY()));
                break;

            case "Dog":
                nameTextField.setText(dog.getName());
                foodTextField.setText(String.valueOf(dog.getFood()));
                moveTextField.setText(dog.move());
                sleepTextField.setText(dog.sleep());
                eatTextField.setText(dog.eat());
                soundTextField.setText(dog.makeASound());
                ageTextField.setText(String.valueOf(dog.getAge()));
                colorTextField.setText(dog.getColor());
                maleTextField.setText(String.valueOf(dog.isMale()));
                weightTextField.setText(String.valueOf(dog.getWeight()));
                mealsTextField.setText(String.valueOf(dog.getNumberOfMealsInDay()));
                vetActionTextField.setText(String.valueOf(dog.getVetAction()));
                locationXTextField.setText(String.valueOf(dog.getLocationX()));
                locationYTextField.setText(String.valueOf(dog.getLocationY()));
                break;

            case "Wolf":
                nameTextField.setText(wolf.getName());
                foodTextField.setText(String.valueOf(wolf.getFood()));
                moveTextField.setText(wolf.move());
                sleepTextField.setText(wolf.sleep());
                eatTextField.setText(wolf.eat());
                soundTextField.setText(wolf.makeASound());
                ageTextField.setText(String.valueOf(wolf.getAge()));
                colorTextField.setText(wolf.getColor());
                maleTextField.setText(String.valueOf(wolf.isMale()));
                weightTextField.setText(String.valueOf(wolf.getWeight()));
                mealsTextField.setText(String.valueOf(wolf.getNumberOfMealsInDay()));
                vetActionTextField.setText(String.valueOf(wolf.getVetAction()));
                locationXTextField.setText(String.valueOf(wolf.getLocationX()));
                locationYTextField.setText(String.valueOf(wolf.getLocationY()));
                break;

            case "Seal":
                nameTextField.setText(seal.getName());
                foodTextField.setText(String.valueOf(seal.getFood()));
                moveTextField.setText(seal.move());
                sleepTextField.setText(seal.sleep());
                eatTextField.setText(seal.eat());
                soundTextField.setText(seal.makeASound());
                ageTextField.setText(String.valueOf(seal.getAge()));
                colorTextField.setText(seal.getColor());
                maleTextField.setText(String.valueOf(seal.isMale()));
                weightTextField.setText(String.valueOf(seal.getWeight()));
                mealsTextField.setText(String.valueOf(seal.getNumberOfMealsInDay()));
                vetActionTextField.setText(String.valueOf(seal.getVetAction()));
                locationXTextField.setText(String.valueOf(seal.getLocationX()));
                locationYTextField.setText(String.valueOf(seal.getLocationY()));
                break;

            case "Cat":
                nameTextField.setText(cat.getName());
                foodTextField.setText(String.valueOf(cat.getFood()));
                moveTextField.setText(cat.move());
                sleepTextField.setText(cat.sleep());
                eatTextField.setText(cat.eat());
                soundTextField.setText(cat.makeASound());
                ageTextField.setText(String.valueOf(cat.getAge()));
                colorTextField.setText(cat.getColor());
                maleTextField.setText(String.valueOf(cat.isMale()));
                weightTextField.setText(String.valueOf(cat.getWeight()));
                mealsTextField.setText(String.valueOf(cat.getNumberOfMealsInDay()));
                vetActionTextField.setText(String.valueOf(cat.getVetAction()));
                locationXTextField.setText(String.valueOf(cat.getLocationX()));
                locationYTextField.setText(String.valueOf(cat.getLocationY()));
                break;

            case "Lion":
                nameTextField.setText(lion.getName());
                foodTextField.setText(String.valueOf(lion.getFood()));
                moveTextField.setText(lion.move());
                sleepTextField.setText(lion.sleep());
                eatTextField.setText(lion.eat());
                soundTextField.setText(lion.makeASound());
                ageTextField.setText(String.valueOf(lion.getAge()));
                colorTextField.setText(lion.getColor());
                maleTextField.setText(String.valueOf(lion.isMale()));
                weightTextField.setText(String.valueOf(lion.getWeight()));
                mealsTextField.setText(String.valueOf(lion.getNumberOfMealsInDay()));
                vetActionTextField.setText(String.valueOf(lion.getVetAction()));
                locationXTextField.setText(String.valueOf(lion.getLocationX()));
                locationYTextField.setText(String.valueOf(lion.getLocationY()));
                break;

            case "Rabbit":
                nameTextField.setText(rabbit.getName());
                foodTextField.setText(String.valueOf(rabbit.getFood()));
                moveTextField.setText(rabbit.move());
                sleepTextField.setText(rabbit.sleep());
                eatTextField.setText(rabbit.eat());
                ageTextField.setText(String.valueOf(rabbit.getAge()));
                colorTextField.setText(rabbit.getColor());
                maleTextField.setText(String.valueOf(rabbit.isMale()));
                weightTextField.setText(String.valueOf(rabbit.getWeight()));
                mealsTextField.setText(String.valueOf(rabbit.getNumberOfMealsInDay()));
                vetActionTextField.setText(String.valueOf(rabbit.getVetAction()));
                locationXTextField.setText(String.valueOf(rabbit.getLocationX()));
                locationYTextField.setText(String.valueOf(rabbit.getLocationY()));
                break;

        }
    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        MainView dialog = new MainView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
