package pl.mareksowa.items;

public class Armor extends Item{

    String[] armorNamesPrefix = {"Broken", "Rusted", "Fine", "Typical", "Shiny", "Magic", "Great", "Legendary"};
    String[] armorNameSuffix = {"Cape", "Quilted Armor", "Leather-Armor", "Ring-Mail", "Scale-Mail",
            "Breast-Plate", "Plate-Mail"};
    int preI;
    int sufI;

    public Armor(){
        int r = random.nextInt(3);
        switch (r){
            case 0: {
                setName("Light Armor");
                setPrice(random.nextInt(10) + 5);
                setWeight(random.nextInt(10 + 5));
                setDef(random.nextInt(10 + 5));
                break;
            }
            case 1:{
                setName("Medium Armor");
                setPrice(random.nextInt(20) + 5);
                setWeight(random.nextInt(20 + 5));
                setDef(random.nextInt(20 + 5));
                break;
            }
            case 2: {
                setName("Full Armor");
                setPrice(random.nextInt(30) + 5);
                setWeight(random.nextInt(30 + 5));
                setDef(random.nextInt(30 + 5));
                break;
            }
        }
    }

    @Override
    public String toString() {
        return getName() + ", Def=" + getDef()+", $" + getPrice();
    }
}
