package pl.sytomczak.zoo.animals.canine;


import pl.sytomczak.zoo.Food;

public class Wolf extends Canine {

    @Override
    public String makeASound() {
        return  "Auuuu";
    }

    @Override
    public String move() {
        return  "Move like dog";
    }

    public Wolf(){
        setMove(move());
        setSleep(sleep());
        setSound(makeASound());
        setEat(eat());
    }

    public Wolf(Integer id, String name, String species, Integer age, String move, String sleep, String eat, String vetAction, String sound, String color, Food food, Boolean male, Integer weight, Integer numberOfMeals, Integer locationXInCage, Integer locationYInCage)
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

