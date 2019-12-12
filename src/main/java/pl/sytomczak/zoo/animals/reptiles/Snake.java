package pl.sytomczak.zoo.animals.reptiles;

import pl.sytomczak.zoo.actions.Soundable;
import pl.sytomczak.zoo.animals.Animal;

public class Snake extends Animal implements Soundable {

    @Override
    public String eat() {
        return "Eat like snake";
    }

    @Override
    public String makeASound() {
       return  "SSsss";
    }
}
