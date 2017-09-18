package pl.mareksowa.items;

public class Potion extends Item {


    public Potion (){
        setName(nameGenerator());
        setPrice(getName().equals("Mana potion")? 15 : 10);
    }

    public String nameGenerator(){
        if (1 > random.nextInt(2)) { // generujemy randomowo tru/false
            return "Mana potion";
        } else {
            return "Healing potion";
        }
    }

    @Override
    public String toString() {
        return getName() + ", $=" + getPrice();
    }
}
