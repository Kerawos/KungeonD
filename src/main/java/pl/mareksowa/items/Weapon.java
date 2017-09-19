package pl.mareksowa.items;

import pl.mareksowa.controllers.HeroCreatorController;

import java.util.Arrays;
import java.util.Random;

public class Weapon extends Item{
//Random rnd = new Random();
    String[] itemNamesPrefix = {"Broken", "Rusted", "Fine", "Typical", "Shiny", "Magic", "Great", "Legendary"};
    String[] itemNameSuffix = {"Dagger", "Bow", "Sword", "Axe", "War-Hammer"};
    int preI;
    int sufI;

    public Weapon(){
        setName(nameGenerator());
        setDamage(random.nextInt(3)+ HeroCreatorController.player.getLevel()+preI+sufI);
        setPrice(getDamage()*2);
    }

    public Weapon(String name, int damage){
        setName(name);
        setDamage(damage);
    }

    public String nameGenerator(){
        preI = HeroCreatorController.player.getLevel()-1;
                preI = HeroCreatorController.player.getLevel()>7 ? 7
                : HeroCreatorController.player.getLevel();
        String pre = itemNamesPrefix[preI].toString(); //generuje prefix
        sufI = HeroCreatorController.player.getLevel()>4 ? itemNameSuffix.length-1
                : HeroCreatorController.player.getLevel();
        String suf = itemNameSuffix[sufI]; // generuje suffix
        return pre + " " + suf; //mozna zapisac w jednej lini ale jest widoczniej bardziej
    }

    @Override
    public String toString() {
        return getName()+", Dmg="+getDamage()+", $" + getPrice();
    }
}
