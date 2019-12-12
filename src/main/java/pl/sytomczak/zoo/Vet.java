package pl.sytomczak.zoo;

import pl.sytomczak.zoo.animals.Animal;

import java.util.logging.Logger;

public class Vet {

    public Logger log = Logger.getLogger(this.getClass().getName());

    public String doVetActionOn(Animal animal, VetAction vetAction) {
        return String.format("Doing the %s on %s", vetAction, animal.getClass().getSimpleName());
    }
}
