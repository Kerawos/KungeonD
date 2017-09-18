package pl.mareksowa.models;

import pl.mareksowa.controllers.HeroCreatorController;
import pl.mareksowa.items.Item;

public class MonsterModel {


    private String name;
    private int maxHp;
    private int hp;
    private int str;
    private int prePower;
    private int sufPower;

    public MonsterModel(String name, int maxHp, int str) {
        this.name = name;
        this.maxHp = maxHp;
        this.str = str;
        this.hp = maxHp;
    }

    public MonsterModel(){
        setName(nameGenerator());
        setStr(Item.random.nextInt(5)+ HeroCreatorController.player.getLevel() + prePower + sufPower);
        setMaxHp(Item.random.nextInt(5)+ HeroCreatorController.player.getLevel() + prePower + sufPower);
        this.hp = maxHp;
    }


    String[] monsterNamesPrefix = {"Sick", "Blind", "Weak", "", "Ugly", "Terror", "Deadly", "Godly"};
    String[] monsterNameSuffix = {"Spider", "Goblin", "Orc", "Terror", "Hydra", "Dragon"};


    public String nameGenerator(){
        prePower = Item.random.nextInt(monsterNamesPrefix.length-1);
        String pre = monsterNamesPrefix[prePower]; //generuje prefix
        sufPower = Item.random.nextInt(monsterNameSuffix.length-1);
        String suf = monsterNameSuffix[sufPower]; // generuje suffix
        return pre + " " + suf; //mozna zapisac w jednej lini ale jest widoczniej bardziej
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return name + ", str=" + str +",  Hp=" + hp + "/" + maxHp;
    }
}
