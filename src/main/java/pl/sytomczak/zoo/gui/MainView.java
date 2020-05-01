package pl.sytomczak.zoo.gui;

import pl.sytomczak.zoo.Food;
import pl.sytomczak.zoo.Vet;
import pl.sytomczak.zoo.VetAction;
import pl.sytomczak.zoo.animals.Animal;
import pl.sytomczak.zoo.animals.birds.Alex;
import pl.sytomczak.zoo.animals.birds.Bird;
import pl.sytomczak.zoo.animals.birds.Parrot;
import pl.sytomczak.zoo.animals.birds.Pigeon;
import pl.sytomczak.zoo.animals.canine.Arya;
import pl.sytomczak.zoo.animals.canine.Dog;
import pl.sytomczak.zoo.animals.canine.Wolf;
import pl.sytomczak.zoo.animals.earlessSeals.Foczi;
import pl.sytomczak.zoo.animals.earlessSeals.Seal;
import pl.sytomczak.zoo.animals.feline.*;
import pl.sytomczak.zoo.animals.lagomorphs.Rabbit;
import pl.sytomczak.zoo.animals.lagomorphs.Tuptuś;
import pl.sytomczak.zoo.animals.reptiles.Nagini;
import pl.sytomczak.zoo.animals.reptiles.Snake;
import pl.sytomczak.zoo.dbUtils.DBConnection;
import pl.sytomczak.zoo.dbUtils.ZooModel;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private MiuMiu miuMiu;
    private Mufasa mufasa;
    private Foczi foczi;
    private Tuptuś tuptus;
    private Nagini nagini;
    private Alex alex;
    private Arya arya;
    private Parrot parrot;
    private Pigeon pigeon;
    private Dog dog;
    private Wolf wolf;
    private Seal seal;
    private Cat cat;
    private Lion lion;
    private Rabbit rabbit;
    private Snake snake;

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

        if(animals == null)
            animals = new ArrayList<>();
        else
            animals.clear();



        miuMiu = new MiuMiu();
        miuMiu.setName("MiuMiu");
        miuMiu.setAge(5);
        miuMiu.setColor("White");
        miuMiu.setFood(Food.MOUSE);
        miuMiu.setMale(true);
        miuMiu.setWeight(7);
        miuMiu.setNumberOfMealsInDay(20);
        miuMiu.setVetAction(VetAction.SHOT.toString());

        mufasa = new Mufasa();
        mufasa.setName("Mufasa");
        mufasa.setAge(7);
        mufasa.setColor("Orange");
        mufasa.setFood(Food.LAMB);
        mufasa.setMale(true);
        mufasa.setWeight(50);
        mufasa.setNumberOfMealsInDay(1);
        mufasa.setLocationX(1);
        mufasa.setLocationY(1);

        foczi = new Foczi();
        foczi.setName("Foczi");
        foczi.setAge(24);
        foczi.setColor("Blue");
        foczi.setFood(Food.FISH);
        foczi.setMale(false);
        foczi.setWeight(30);
        foczi.setNumberOfMealsInDay(4);
        foczi.setLocationX(2);
        foczi.setLocationY(2);

        tuptus = new Tuptuś();
        tuptus.setName("Tuptuś");
        tuptus.setAge(2);
        tuptus.setColor("Gray");
        tuptus.setFood(Food.CARROT);
        tuptus.setMale(true);
        tuptus.setWeight(4);
        tuptus.setNumberOfMealsInDay(50);
        tuptus.setLocationX(3);
        tuptus.setLocationY(3);

        nagini = new Nagini();
        nagini.setName("Nagini");
        nagini.setAge(120);
        nagini.setColor("Brown");
        nagini.setFood(Food.MEAT);
        nagini.setMale(false);
        nagini.setWeight(35);
        nagini.setNumberOfMealsInDay(1);
        nagini.setLocationX(4);
        nagini.setLocationY(4);

        alex = new Alex();
        alex.setName("Alex");
        alex.setAge(6);
        alex.setColor("Yellow");
        alex.setFood(Food.SEEDS);
        alex.setMale(true);
        alex.setWeight(1);
        alex.setNumberOfMealsInDay(6);
        alex.setLocationX(5);
        alex.setLocationY(5);
        alex.setVetAction(VetAction.SURGERY.toString());

        arya = new Arya();
        arya.setName("Arya");
        arya.setAge(1);
        arya.setColor("Black");
        arya.setFood(Food.MEAT);
        arya.setMale(false);
        arya.setWeight(32);
        arya.setNumberOfMealsInDay(2);

        pigeon = new Pigeon();
        pigeon.setName("Pigeon");
        pigeon.setFood(Food.SEEDS);
        pigeon.sleep();
        pigeon.eat();
        pigeon.fly();
        pigeon.makeASound();
        pigeon.setAge(0);
        pigeon.setColor("");
        pigeon.setMale(false);
        pigeon.setWeight(0);
        pigeon.setNumberOfMealsInDay(0);
        pigeon.setLocationX(0);
        pigeon.setLocationY(0);
        pigeon.setVetAction("");

        parrot = new Parrot();
        parrot.setName("Parrot");
        parrot.setFood(Food.SEEDS);
        parrot.sleep();
        parrot.eat();
        parrot.fly();
        parrot.makeASound();
        parrot.setAge(0);
        parrot.setColor("");
        parrot.setMale(false);
        parrot.setWeight(0);
        parrot.setNumberOfMealsInDay(0);
        parrot.setLocationX(0);
        parrot.setLocationY(0);
        parrot.setVetAction("");

        dog = new Dog();
        dog.setName("Dog");
        dog.setFood(Food.LAMB);
        dog.sleep();
        dog.eat();
        dog.move();
        dog.makeASound();
        dog.setAge(0);
        dog.setColor("");
        dog.setMale(false);
        dog.setWeight(0);
        dog.setNumberOfMealsInDay(0);
        dog.setLocationX(0);
        dog.setLocationY(0);
        dog.setVetAction("");

        wolf = new Wolf();
        wolf.setName("Wolf");
        wolf.setFood(Food.MEAT);
        wolf.sleep();
        wolf.eat();
        wolf.move();
        wolf.makeASound();
        wolf.setAge(0);
        wolf.setColor("");
        wolf.setMale(false);
        wolf.setWeight(0);
        wolf.setNumberOfMealsInDay(0);
        wolf.setLocationX(0);
        wolf.setLocationY(0);
        wolf.setVetAction("");

        seal = new Seal();
        seal.setName("Seal");
        seal.setFood(Food.FISH);
        seal.sleep();
        seal.eat();
        seal.move();
        seal.makeASound();
        seal.setAge(0);
        seal.setColor("");
        seal.setMale(false);
        seal.setWeight(0);
        seal.setNumberOfMealsInDay(0);
        seal.setLocationX(0);
        seal.setLocationY(0);
        seal.setVetAction("");

        cat = new Cat();
        cat.setName("Dog");
        cat.setFood(Food.MOUSE);
        cat.sleep();
        cat.eat();
        cat.move();
        cat.makeASound();
        cat.setAge(0);
        cat.setColor("");
        cat.setMale(false);
        cat.setWeight(0);
        cat.setNumberOfMealsInDay(0);
        cat.setLocationX(0);
        cat.setLocationY(0);
        cat.setVetAction("");

        lion = new Lion();
        lion.setName("Lion");
        lion.setFood(Food.MEAT);
        lion.sleep();
        lion.eat();
        lion.move();
        lion.makeASound();
        lion.setAge(0);
        lion.setColor("");
        lion.setMale(false);
        lion.setWeight(0);
        lion.setNumberOfMealsInDay(0);
        lion.setLocationX(0);
        lion.setLocationY(0);
        lion.setVetAction("");

        rabbit = new Rabbit();
        rabbit.setName("Rabbit");
        rabbit.setFood(Food.GRASS);
        rabbit.sleep();
        rabbit.eat();
        rabbit.move();
        rabbit.setAge(0);
        rabbit.setColor("");
        rabbit.setMale(false);
        rabbit.setWeight(0);
        rabbit.setNumberOfMealsInDay(0);
        rabbit.setLocationX(0);
        rabbit.setLocationY(0);
        rabbit.setVetAction("");

        snake = new Snake();
        snake.setName("Snake");
        snake.setFood(Food.HARRY_POTTER);
        snake.sleep();
        snake.eat();
        snake.move();
        snake.makeASound();
        snake.setAge(0);
        snake.setColor("");
        snake.setMale(false);
        snake.setWeight(0);
        snake.setNumberOfMealsInDay(0);
        snake.setLocationX(0);
        snake.setLocationY(0);
        snake.setVetAction("");
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
            case "MiuMiu":
                nameTextField.setText(miuMiu.getName());
                ageTextField.setText(String.valueOf(miuMiu.getAge()));
                colorTextField.setText(miuMiu.getColor());
                foodTextField.setText(String.valueOf(miuMiu.getFood()));
                maleTextField.setText(String.valueOf(miuMiu.isMale()));
                weightTextField.setText(String.valueOf(miuMiu.getWeight()));
                mealsTextField.setText(String.valueOf(miuMiu.getNumberOfMealsInDay()));
                vetActionTextField.setText(String.valueOf(miuMiu.getVetAction()));
                soundTextField.setText(miuMiu.makeASound());
                moveTextField.setText(miuMiu.move());
                sleepTextField.setText(miuMiu.sleep());
                eatTextField.setText(miuMiu.eat());
                break;

            case "Mufasa":
                nameTextField.setText(mufasa.getName());
                ageTextField.setText(String.valueOf(mufasa.getAge()));
                colorTextField.setText(mufasa.getColor());
                foodTextField.setText(String.valueOf(mufasa.getFood()));
                maleTextField.setText(String.valueOf(mufasa.isMale()));
                weightTextField.setText(String.valueOf(mufasa.getWeight()));
                mealsTextField.setText(String.valueOf(mufasa.getNumberOfMealsInDay()));
                locationXTextField.setText(String.valueOf(mufasa.getLocationX()));
                locationYTextField.setText(String.valueOf(mufasa.getLocationY()));
                soundTextField.setText(mufasa.makeASound());
                moveTextField.setText(mufasa.move());
                sleepTextField.setText(mufasa.sleep());
                eatTextField.setText(mufasa.eat());
                break;

            case "Foczi":
                nameTextField.setText(foczi.getName());
                ageTextField.setText(String.valueOf(foczi.getAge()));
                colorTextField.setText(foczi.getColor());
                foodTextField.setText(String.valueOf(foczi.getFood()));
                maleTextField.setText(String.valueOf(foczi.isMale()));
                weightTextField.setText(String.valueOf(foczi.getWeight()));
                mealsTextField.setText(String.valueOf(foczi.getNumberOfMealsInDay()));
                locationXTextField.setText(String.valueOf(foczi.getLocationX()));
                locationYTextField.setText(String.valueOf(foczi.getLocationY()));
                soundTextField.setText(foczi.makeASound());
                moveTextField.setText(foczi.move());
                sleepTextField.setText(foczi.sleep());
                eatTextField.setText(foczi.eat());
                break;

            case "Tuptuś":
                nameTextField.setText(tuptus.getName());
                ageTextField.setText(String.valueOf(tuptus.getAge()));
                colorTextField.setText(tuptus.getColor());
                foodTextField.setText(String.valueOf(tuptus.getFood()));
                maleTextField.setText(String.valueOf(tuptus.isMale()));
                weightTextField.setText(String.valueOf(tuptus.getWeight()));
                mealsTextField.setText(String.valueOf(tuptus.getNumberOfMealsInDay()));
                locationXTextField.setText(String.valueOf(tuptus.getLocationX()));
                locationYTextField.setText(String.valueOf(tuptus.getLocationY()));
                moveTextField.setText(tuptus.move());
                sleepTextField.setText(tuptus.sleep());
                eatTextField.setText(tuptus.eat());
                break;

            case "Nagini":
                nameTextField.setText(nagini.getName());
                ageTextField.setText(String.valueOf(nagini.getAge()));
                colorTextField.setText(nagini.getColor());
                foodTextField.setText(String.valueOf(nagini.getFood()));
                maleTextField.setText(String.valueOf(nagini.isMale()));
                weightTextField.setText(String.valueOf(nagini.getWeight()));
                mealsTextField.setText(String.valueOf(nagini.getNumberOfMealsInDay()));
                locationXTextField.setText(String.valueOf(nagini.getLocationX()));
                locationYTextField.setText(String.valueOf(nagini.getLocationY()));
                soundTextField.setText(nagini.makeASound());
                moveTextField.setText(nagini.move());
                sleepTextField.setText(nagini.sleep());
                eatTextField.setText(nagini.eat());
                break;

            case "Alex":
                nameTextField.setText(alex.getName());
                ageTextField.setText(String.valueOf(alex.getAge()));
                colorTextField.setText(alex.getColor());
                foodTextField.setText(String.valueOf(alex.getFood()));
                maleTextField.setText(String.valueOf(alex.isMale()));
                weightTextField.setText(String.valueOf(alex.getWeight()));
                mealsTextField.setText(String.valueOf(alex.getNumberOfMealsInDay()));
                locationXTextField.setText(String.valueOf(alex.getLocationX()));
                locationYTextField.setText(String.valueOf(alex.getLocationY()));
                soundTextField.setText(alex.makeASound());
                moveTextField.setText(alex.move());
                sleepTextField.setText(alex.sleep());
                eatTextField.setText(alex.eat());
                vetActionTextField.setText(String.valueOf(alex.getVetAction()));
                break;

            case "Arya":
                nameTextField.setText(arya.getName());
                ageTextField.setText(String.valueOf(arya.getAge()));
                colorTextField.setText(arya.getColor());
                foodTextField.setText(String.valueOf(arya.getFood()));
                maleTextField.setText(String.valueOf(arya.isMale()));
                weightTextField.setText(String.valueOf(arya.getWeight()));
                mealsTextField.setText(String.valueOf(arya.getNumberOfMealsInDay()));
                soundTextField.setText(arya.makeASound());
                moveTextField.setText(arya.move());
                sleepTextField.setText(arya.sleep());
                eatTextField.setText(arya.eat());
                break;

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

            case "Snake":
                nameTextField.setText(snake.getName());
                foodTextField.setText(String.valueOf(snake.getFood()));
                moveTextField.setText(snake.move());
                sleepTextField.setText(snake.sleep());
                eatTextField.setText(snake.eat());
                soundTextField.setText(snake.makeASound());
                ageTextField.setText(String.valueOf(snake.getAge()));
                colorTextField.setText(snake.getColor());
                maleTextField.setText(String.valueOf(snake.isMale()));
                weightTextField.setText(String.valueOf(snake.getWeight()));
                mealsTextField.setText(String.valueOf(snake.getNumberOfMealsInDay()));
                vetActionTextField.setText(String.valueOf(snake.getVetAction()));
                locationXTextField.setText(String.valueOf(snake.getLocationX()));
                locationYTextField.setText(String.valueOf(snake.getLocationY()));
                break;
            default:
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
