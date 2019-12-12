package pl.sytomczak.zoo.animals.feline;

public class Cat extends Feline {

    @Override
    public String makeASound() {
        return  "Miau Miau";
    }

    @Override
    public String move() {
        return  "Move like cat";
    }
}
