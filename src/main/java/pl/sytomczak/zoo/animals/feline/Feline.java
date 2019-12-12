package pl.sytomczak.zoo.animals.feline;

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
}
