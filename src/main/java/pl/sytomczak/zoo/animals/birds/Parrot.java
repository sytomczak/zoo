package pl.sytomczak.zoo.animals.birds;

public class Parrot extends Bird {

    @Override
    public String makeASound() {
        return "Kłi kłi";
    }

    public Parrot(Integer id, String name, String species, Integer age, String move, String sleep, String eat, String vetAction, String sound, String color, String food, Boolean male, Integer weight, Integer numberOfMeals, Integer locationXInCage, Integer locationYInCage)
    {
        this.setNumberOfMealsInDay(id);
    }
}
