package pl.sytomczak.zoo.animals.canine;

import pl.sytomczak.zoo.actions.Soundable;
import pl.sytomczak.zoo.animals.Animal;

public abstract class Canine extends Animal implements Soundable {

    @Override
    public String eat() {
        return  "Eat like canine";
    }

    @Override
    public String move() {
        return  "Move like canine";
    }
}
