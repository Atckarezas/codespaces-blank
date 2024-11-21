import java.util.ArrayList;
import java.util.List;

/**
 * Represents a cargo box that can contain items for shipping.
 * Part 1
public class CargoBox {
    
    private List<Item> items;
    
    /**
     * Constructs an empty CargoBox.
     */
    public CargoBox() {
        items = new ArrayList<>();
    }
    
    /**
     * Constructs a CargoBox with initial items.
     *
     * @param initialItems The initial items to be added to the CargoBox.
     */
    public CargoBox(Item[] initialItems) {
        items = new ArrayList<>();
        for (Item item : initialItems) {
            if (item != null) {
                items.add(item);
            }
        }
    }
    
    /**
     * Adds an item to the CargoBox.
     *
     * @param item The item to add to the CargoBox.
     */
    public void add(Item item) {
        if (item != null) {
            items.add(item);
        }
    }
    
    /**
     * Returns the number of items in the CargoBox.
     *
     * @return The number of items in the CargoBox.
     */
    public int numberOfItems() {
        return items.size();
    }
    
    /**
     * Returns a string representation of the items in the CargoBox.
     *
     * @return A string representation of the items in the CargoBox.
     */
    @Override
    public String toString() {
        return items.toString();
    }
    
    /**
     * Returns the item with the greatest weight in the CargoBox.
     *
     * @return The item with the greatest weight in the CargoBox, or null if the CargoBox is empty.
     */
    public Item greatestItem() {
        if (items.isEmpty()) {
            return null;
        }
        
        Item greatest = items.get(0);
        for (Item item : items) {
            if (item.getWeightInGrammes() > greatest.getWeightInGrammes()) {
                greatest = item;
            }
        }
        
        return greatest;
    }
    
    /**
     * Creates a new CargoBox containing items with weight less than or equal to the specified weight.
     *
     * @param weight The weight threshold for the new CargoBox.
     * @return A new CargoBox containing items with weight less than or equal to the specified weight.
     */
    public CargoBox makeNewCargoBoxWith(int weight) {
        CargoBox newBox = new CargoBox();
        for (Item item : items) {
            if (item.getWeightInGrammes() <= weight) {
                newBox.add(item);
            }
        }
        return newBox;
    }
```
/**
 * Part 2
 */

public interface Headgear {
    double calculateValue();
}

/**
 * Represents a crown headgear with a number of jewels property.
 */
public class Crown implements Headgear {
    private int numberOfJewels;

    public Crown(int numberOfJewels) {
        if (numberOfJewels < 0) {
            throw new IllegalArgumentException("Number of jewels cannot be negative.");
        }
        this.numberOfJewels = numberOfJewels;
    }

    @Override
    public double calculateValue() {
        return numberOfJewels * 200000.0;
    }

    @Override
    public String toString() {
        return "Crown with " + numberOfJewels + " jewels";
    }
}

/**
 * Represents protective headgear with a protection factor.
 */
public abstract class ProtectiveHeadgear implements Headgear {
    protected double protectionFactor;

    public ProtectiveHeadgear(double protectionFactor) {
        if (protectionFactor < 0) {
            throw new IllegalArgumentException("Protection factor cannot be negative.");
        }
        this.protectionFactor = protectionFactor;
    }
}

/**
 * Represents a scooter helmet that is a type of protective headgear with an additional property for visor presence.
 */
public class ScooterHelmet extends ProtectiveHeadgear {
    private boolean hasVisor;

    public ScooterHelmet(double protectionFactor, boolean hasVisor) {
        super(protectionFactor);
        this.hasVisor = hasVisor;
    }

    @Override
    public double calculateValue() {
        double c1 = hasVisor ? 160 : 80;
        double c2 = 400;
        return c1 + protectionFactor * c2;
    }

    @Override
    public String toString() {
        return "ScooterHelmet with " + (hasVisor ? "visor" : "no visor") + " and protection factor " + protectionFactor;
    }
}

/**
 * Represents a bobble hat that is a type of protective headgear with bobble diameter as a distinguishing attribute.
 */
public class BobbleHat extends ProtectiveHeadgear {
    private int bobbleDiameter;

    public BobbleHat(double protectionFactor, int bobbleDiameter) {
        super(protectionFactor);
        if (bobbleDiameter < 0) {
            throw new IllegalArgumentException("Bobble diameter cannot be negative.");
        }
        this.bobbleDiameter = bobbleDiameter;
    }

    @Override
    public double calculateValue() {
        return bobbleDiameter * 4.0 * protectionFactor;
    }

    @Override
    public String toString() {
        return "BobbleHat with bobble diameter " + bobbleDiameter + "mm and protection factor " + protectionFactor;
    }
}

/**
 * Utility class for calculating total value of an array of headgear items.
 */
public class HeadgearUtility {
    public static double totalValue(Headgear[] headgearItems) {
        if (headgearItems == null) {
            throw new IllegalArgumentException("Array reference is null.");
        }

        double total = 0.0;
        for (Headgear item : headgearItems) {
            if (item != null) {
                total += item.calculateValue();
            } else {
                throw new IllegalArgumentException("Array contains null elements.");
            }
        }
        return total;
    }
}
```

