package pl.mareksowa.items;

import pl.mareksowa.controllers.HeroCreatorController;

import java.util.Arrays;
import java.util.Random;

public class Weapon extends Item{
//Random rnd = new Random();
    String[] itemNamesPrefix = {"Fine", "Rusted", "Fluffy", "Magic", "Normal", "Shiny", "Broken", "Great"};
    String[] itemNameSuffix = {"Sword", "Axe", "Bow", "Dagger"};


    public Weapon(){
        setName(nameGenerator());
        setDamage(random.nextInt(10)+ HeroCreatorController.player.getLevel());
        setPrice(getDamage()*2);
    }

    public Weapon(String name, int damage){
        setName(name);
        setDamage(damage);
    }

    public String nameGenerator(){
        String pre = itemNamesPrefix[random.nextInt(itemNamesPrefix.length-1)]; //generuje prefix
        String suf = itemNameSuffix[random.nextInt(itemNameSuffix.length-1)]; // generuje suffix
        return pre + " " + suf; //mozna zapisac w jednej lini ale jest widoczniej bardziej
    }

    @Override
    public String toString() {
        return getName()+", Dmg="+getDamage()+", $=" + getPrice();
    }
}
