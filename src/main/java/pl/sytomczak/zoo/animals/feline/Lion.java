package pl.sytomczak.zoo.animals.feline;

public class Lion extends Feline {

    @Override
    public String sleep() {
        return  "Sleep very long";
    }

    @Override
    public String makeASound() {
        return "Raaaaaaaaawr";
    }
}
