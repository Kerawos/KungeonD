package pl.mareksowa.models;

import pl.mareksowa.items.Item;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel {
    private String nickname;
    private int maxHp;
    private int hp;
    private int str;
    private int exp;
    private List<Item> inventory;
    private Item weapon;
    private Item armor;
    private int level;
    public int gold;

//    public PlayerModel(){}

    public PlayerModel(String nickname, int maxHp, int str) {
        this.nickname = nickname;
        this.maxHp = maxHp;
        this.str = str;
        this.hp = maxHp;
        this.exp = 0;
        this.level = 1;
        this.gold = 500;
        this.weapon = null;
        this.armor = null;
        this.inventory = new ArrayList<>();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getExp() {
        return exp;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addInventory(Item itemToAdd){
        inventory.add(itemToAdd);
    }

    public void removeInventory(Item itemToRemove){
        inventory.remove(itemToRemove);
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Item getArmor() {
        return armor;
    }

    public void setArmor(Item armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return nickname + ", lvl="+ level+ "; str=" + str +",  Hp=" + hp + "/" + maxHp + ", exp=" + exp;
    }
}
