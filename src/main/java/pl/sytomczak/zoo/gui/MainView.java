package pl.sytomczak.zoo.gui;

import pl.sytomczak.zoo.Vet;
import pl.sytomczak.zoo.animals.Animal;
import pl.sytomczak.zoo.animals.birds.Bird;
import pl.sytomczak.zoo.animals.birds.Parrot;
import pl.sytomczak.zoo.animals.birds.Pigeon;
import pl.sytomczak.zoo.animals.canine.Canine;
import pl.sytomczak.zoo.animals.canine.Dog;
import pl.sytomczak.zoo.animals.canine.Wolf;
import pl.sytomczak.zoo.animals.earlessSeals.Seal;
import pl.sytomczak.zoo.animals.feline.*;
import pl.sytomczak.zoo.animals.lagomorphs.Rabbit;
import pl.sytomczak.zoo.animals.reptiles.Snake;
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

    private ArrayList<String> specieNames = new ArrayList<>();
    private ArrayList<Bird> birds = new ArrayList<>();
    private ArrayList<Canine> canines = new ArrayList<>();
    private ArrayList<Seal> seals = new ArrayList<>();
    private ArrayList<Feline> felines = new ArrayList<>();

    private ArrayList<Rabbit> rabbits = new ArrayList<>();
    private ArrayList<Snake>  snakes = new ArrayList<>();
    private ZooModel zooModel;

    public MainView() {
        animalSpeciesCombobox.addActionListener(e -> animalSpeciesOnSelect());
        animalSelectionCombobox.addActionListener(e -> animalsOnSelect());

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

        animalSpeciesCombobox.setSelectedIndex(-1);
    }

    private void initializeAnimals() {

        if (birds == null)
            birds = new ArrayList<>();
        else
            birds.clear();

        if(canines == null)
            canines = new ArrayList<>();
        else
            canines.clear();

        if(seals == null)
            seals = new ArrayList<>();
        else
            seals.clear();

        if(rabbits == null)
            rabbits = new ArrayList<>();
        else
            rabbits.clear();

        if(snakes == null)
            snakes = new ArrayList<>();
        else
            snakes.clear();

        birds = zooModel.getBirds();
        canines = zooModel.getCanines();
        seals = zooModel.getEarlessSealss();
        felines = zooModel.getFelines();
        rabbits = zooModel.getLagomorps();
        snakes = zooModel.getReptiles();
    }


    private void animalSpeciesOnSelect() {

      try{
          animalSelectionCombobox.removeAllItems();
          if(animalSpeciesCombobox.getSelectedIndex() == -1)
              return;

          switch (animalSpeciesCombobox.getModel().getSelectedItem().toString()) {
              case "Birds":
              {
                  for(int i=0;i<birds.size();i++)
                      animalSelectionCombobox.addItem(birds.get(i).getName());
              }
              break;
              case "Canines": 
              {
                  for(int i=0;i<canines.size();i++)
                      animalSelectionCombobox.addItem(canines.get(i).getName());
              }
              break;
              case "Earless Seals": 
              {
                  for(int i=0;i<seals.size();i++)
                      animalSelectionCombobox.addItem(seals.get(i).getName());
              }
              break;
              case "Felines": 
              {
                  for(int i=0;i<felines.size();i++)
                      animalSelectionCombobox.addItem(felines.get(i).getName());
              }
              break;
              case "Lagomorphs": 
              {
                  for(int i=0;i<rabbits.size();i++)
                      animalSelectionCombobox.addItem(rabbits.get(i).getName());
              }
              break;
              case "Reptiles": 
              {
                  for(int i=0;i<snakes.size();i++)
                      animalSelectionCombobox.addItem(snakes.get(i).getName());
              }
              break;

          }
      }catch (Exception ex)
      {
          ex.printStackTrace();
      }
    }

    private void animalsOnSelect() {
        String animalSpecies = (String)animalSpeciesCombobox.getSelectedItem();
        String animalName = (String) animalSelectionCombobox.getSelectedItem();

        switch (animalSpecies) {
            case "Birds":
            {
                Bird bird = null;
                for (int i = 0; i < birds.size(); i++)
                {
                    if(birds.get(i).getName() == animalName) {
                        bird = birds.get(i);
                        break;
                    }
                }
                if(bird == null)
                    break;

                FillControls(bird);
                soundTextField.setText(bird.makeASound());
            }
            break;
            case "Canines":
            {
                Canine canine = null;
                for (int i = 0; i < canines.size(); i++)
                {
                    if(canines.get(i).getName() == animalName) {
                        canine = canines.get(i);
                        break;
                    }
                }
                if(canine == null)
                    break;

                FillControls(canine);
                soundTextField.setText(canine.makeASound());
            }
            break;
            case "Earless Seals":
            {
                Seal seal = null;
                for (int i = 0; i < seals.size(); i++)
                {
                    if(seals.get(i).getName() == animalName) {
                        seal = seals.get(i);
                        break;
                    }
                }
                if(seal == null)
                    break;

                FillControls(seal);
                soundTextField.setText(seal.makeASound());
            }
            break;
            case "Felines":
            {
                Feline feline = null;
                for (int i = 0; i < felines.size(); i++)
                {
                    if(felines.get(i).getName() == animalName) {
                        feline = felines.get(i);
                        break;
                    }
                }
                if(feline == null)
                    break;

                FillControls(feline);
                soundTextField.setText(feline.makeASound());
            }
            break;
            case "Lagomorphs":
            {
                Rabbit rabbit = null;
                for (int i = 0; i < rabbits.size(); i++)
                {
                    if(rabbits.get(i).getName() == animalName) {
                        rabbit = rabbits.get(i);
                        break;
                    }
                }
                if(rabbit == null)
                    break;

                FillControls(rabbit);
            }
            break;
            case "Reptiles":
            {
                Snake snake = null;
                for (int i = 0; i < snakes.size(); i++)
                {
                    if(snakes.get(i).getName() == animalName) {
                        snake = snakes.get(i);
                        break;
                    }
                }
                if(snake == null)
                    break;

                FillControls(snake);
            }
            break;
        }
    }

    private void FillControls(Animal animal){
        if(animal == null)
            return;

        nameTextField.setText(animal.getName());
        foodTextField.setText(String.valueOf(animal.getFood()));
        moveTextField.setText(animal.move());
        sleepTextField.setText(animal.sleep());
        eatTextField.setText(animal.eat());
        ageTextField.setText(String.valueOf(animal.getAge()));
        colorTextField.setText(animal.getColor());
        maleTextField.setText(String.valueOf(animal.isMale()));
        weightTextField.setText(String.valueOf(animal.getWeight()));
        mealsTextField.setText(String.valueOf(animal.getNumberOfMealsInDay()));
        vetActionTextField.setText(String.valueOf(animal.getVetAction()));
        locationXTextField.setText(String.valueOf(animal.getLocationX()));
        locationYTextField.setText(String.valueOf(animal.getLocationY()));
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
