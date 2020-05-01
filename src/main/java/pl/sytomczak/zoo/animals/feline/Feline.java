package pl.sytomczak.zoo.animals.feline;

import pl.sytomczak.zoo.Food;
import pl.sytomczak.zoo.actions.Soundable;
import pl.sytomczak.zoo.animals.Animal;

public abstract class Feline extends Animal implements Soundable {

    @Override
    public String eat() {
        return  "Eat like feline";
    }

    @Override
    public String move() {
        return  "Move like feline";
    }

    public Feline(){
        setMove(move());
        setSleep(sleep());
        setSound(makeASound());
        setEat(eat());
    }

    public Feline(Integer id, String name, String species, Integer age, String move, String sleep, String eat, String vetAction, String sound, String color, Food food, Boolean male, Integer weight, Integer numberOfMeals, Integer locationXInCage, Integer locationYInCage)
    {
        this.setNumberOfMealsInDay(id);
        this.setName(name);
        this.setSpecies(species);
        this.setAge(age);
        this.setMove(move);
        this.setSleep(sleep);
        this.setEat(eat);
        this.setVetAction(vetAction);
        this.setSound(sound);
        this.setColor(color);
        this.setFood(food);
        this.setMale(male);
        this.setWeight(weight);
        this.setNumberOfMealsInDay(numberOfMeals);
        this.setLocationX(locationXInCage);
        this.setLocationY(locationYInCage);
    }
}
