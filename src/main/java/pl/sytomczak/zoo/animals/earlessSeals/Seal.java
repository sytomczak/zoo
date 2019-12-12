package pl.sytomczak.zoo.animals.earlessSeals;

import pl.sytomczak.zoo.actions.Soundable;
import pl.sytomczak.zoo.animals.Animal;

public class Seal extends Animal implements Soundable {

    @Override
    public String makeASound() {
        return  "Fok fok";
    }


    @Override
    public String move() {
        return  "swim";
    }
}
