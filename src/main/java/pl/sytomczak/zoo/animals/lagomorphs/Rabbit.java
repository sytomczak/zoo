package pl.sytomczak.zoo.animals.lagomorphs;

import pl.sytomczak.zoo.Food;
import pl.sytomczak.zoo.animals.Animal;

public class Rabbit extends Animal {

    @Override
    public String move() {
        return  "kic kic";
    }

    public Rabbit(){
        setMove(move());
        setSleep(sleep());
        setEat(eat());
    }

    public Rabbit(Integer id, String name, String species, Integer age, String move, String sleep, String eat, String vetAction, String sound, String color, Food food, Boolean male, Integer weight, Integer numberOfMeals, Integer locationXInCage, Integer locationYInCage)
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
