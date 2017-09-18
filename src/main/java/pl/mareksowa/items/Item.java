package pl.mareksowa.items;

import java.util.Random;

public class Item {

    public static int day = 1;

    private String name;
    private int damage;
    private int weight;
    private int price;
    private int def;

    public static Random random =new Random();


    public Item() {
    }

    public static Item itemGenerator() {
        int t = random.nextInt(3);
        Item item  = null;
        switch (t) {
            case 0: {
                item = new Potion();
                break;
            }
            case 1: {
                item = new Weapon();
                break;
            }
            case 2: {
                item = new Armor();
                break;
            }
        }
        return item;
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", weight=" + weight +
                ", def=" + def +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (damage != item.damage) return false;
        if (weight != item.weight) return false;
        if (price != item.price) return false;
        if (def != item.def) return false;
        return name != null ? name.equals(item.name) : item.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + damage;
        result = 31 * result + weight;
        result = 31 * result + price;
        result = 31 * result + def;
        return result;
    }
}
