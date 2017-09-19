package pl.mareksowa.items;

import pl.mareksowa.controllers.HeroCreatorController;

import java.util.Arrays;

public class Armor extends Item{

    String[] armorNamesPrefix = {"Broken", "Rusted", "Fine", "Typical", "Shiny", "Magic", "Great", "Legendary"};
    String[] armorNameSuffix = {"Cape", "Quilted Armor", "Leather-Armor", "Ring-Mail", "Scale-Mail",
            "Breast-Plate", "Plate-Mail"};
    int preArm;
    int sufArm;

    public Armor(){
        setName(nameGenerator());
        setDef(random.nextInt(3)+ HeroCreatorController.player.getLevel()+sufArm+preArm);
        setPrice(getDef()*2);
    }

    public Armor(String name, int damage){
        setName(name);
        setDamage(damage);
    }

    public String nameGenerator(){
        preArm = HeroCreatorController.player.getLevel()-1;
        preArm = HeroCreatorController.player.getLevel()>8 ? 8
                : HeroCreatorController.player.getLevel();
        String pre = armorNamesPrefix[preArm].toString(); //generuje prefix
        sufArm = HeroCreatorController.player.getLevel()>7 ? armorNameSuffix.length-1
                : HeroCreatorController.player.getLevel();
        String suf = armorNameSuffix[sufArm]; // generuje suffix
        return pre + " " + suf; //mozna zapisac w jednej lini ale jest widoczniej bardziej
    }


    @Override
    public String toString() {
        return getName() + ", Def=" + getDef()+", $" + getPrice();
    }

}
