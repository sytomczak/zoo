package pl.sytomczak.zoo.animals.canine;


public class Wolf extends Canine {

    @Override
    public String makeASound() {
        return  "Auuuu";
    }

    @Override
    public String move() {
        return  "Move like dog";
    }
}

