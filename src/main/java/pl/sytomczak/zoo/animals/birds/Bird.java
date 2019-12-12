package pl.sytomczak.zoo.animals.birds;

import pl.sytomczak.zoo.actions.Flyable;
import pl.sytomczak.zoo.actions.Soundable;
import pl.sytomczak.zoo.animals.Animal;

public abstract class Bird extends Animal implements Flyable, Soundable {

    @Override
    public String eat() {
        return  "Eat like bird";
    }

    @Override
    public String fly() {
        return "Fly like bird";
    }

    @Override
    public String sleep() {
        return  "sleep like bird";
    }

}
