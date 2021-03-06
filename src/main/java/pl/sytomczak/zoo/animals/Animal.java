package pl.sytomczak.zoo.animals;

import pl.sytomczak.zoo.Food;
import pl.sytomczak.zoo.VetAction;
import pl.sytomczak.zoo.actions.Eatable;
import pl.sytomczak.zoo.actions.Moveable;
import pl.sytomczak.zoo.actions.Sleepable;

import java.util.logging.Logger;

public abstract class Animal implements Eatable, Moveable, Sleepable {
    public Logger log = Logger.getLogger(this.getClass().getName());

    private int id;
    private String name;
    private int age;
    private String move;
    private String sleep;
    private String eat;
    private int weight;
    private boolean isMale;
    private String color;
    private int numberOfMealsInDay;
    private Food food;
    private String vetAction;
    private String sound;

    private int locationX;
    private int locationY;

    public void setLog(Logger log) {
        this.log = log;
    }

    private String species;

    @Override
    public String eat() {
        return "Eat like animal";
    }

    @Override
    public String move() {
        return "Move like animal";
    }

    @Override
    public String sleep() {
        return "Sleep like animal";
    }

    private void setId(Integer id) { this.id = id; }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMove(String move) { this.move = move; }

    public void setSleep(String sleep){ this.sleep = sleep;}

    public void setEat(String eat){ this.eat = eat; }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumberOfMealsInDay(int numberOfMealsInDay) {
        this.numberOfMealsInDay = numberOfMealsInDay;
    }

    public Logger getLog() {
        return log;
    }

    public Integer getId() { return  id; }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMove() { return move; }

    public String getSleep() { return sleep; }

    public String getEat() { return eat; }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfMealsInDay() {
        return numberOfMealsInDay;
    }

    public Food getFood() {
        return food;
    }

    public String getVetAction() {
        return vetAction;
    }

    public String getSound() { return  sound;}

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public String getSpecies() {
        return species;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setVetAction(String vetAction) {
        this.vetAction = vetAction;
    }

    public void setSound(String sound) { this.sound = sound;}

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}