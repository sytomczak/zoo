package pl.sytomczak.zoo.animals.lagomorphs;

import pl.sytomczak.zoo.Food;

public class Tuptuś extends Rabbit {

    @Override
    public String eat() {
        return "Om om Carrot";
    }

    public Tuptuś(){
        setMove(move());
        setSleep(sleep());
        setEat(eat());
    }

    public Tuptuś(Integer id, String name, String species, Integer age, String move, String sleep, String eat, String vetAction, String sound, String color, Food food, Boolean male, Integer weight, Integer numberOfMeals, Integer locationXInCage, Integer locationYInCage)
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
