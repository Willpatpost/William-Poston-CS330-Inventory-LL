package items;

import containers.LinkedList;

/**
 * An Inventory is composed of n slots. Each slot may store only
 * one type of item--specified by *slots*.
 * <p>
 * Once all slots are filled, no additional Item types may be
 * stored. Individual slots may contain any number of the same
 * Item--if the Item is stackable.
 */
public class Inventory
{
    /**
     * This is the Default Inventory size.
     */
    public static final int DEFAULT_SIZE = 10;

    /**
     * This is utility function that takes two ItemStacks and adds the
     * number of items in the right-hand side stack to the left-hand side stack.
     *
     * @param lhs stack whose size will be increased
     * @param rhs stack whose size we need to examine
     */
    public static void mergeStacks(ItemStack lhs, ItemStack rhs)
    {
        lhs.increaseSize(rhs.getSize());
    }

    /**
     * Individual item slots--each ItemStack occupies one slot.
     */
    private LinkedList<ItemStack> slots;

    /**
     * Total number of distinct Item types that can be stored.
     */
    private int capacity;

    /**
     * Default to an inventory with 10 slots.
     */
    public Inventory()
    {
        this(DEFAULT_SIZE);
    }

    /**
     * Create an inventory with n slots.
     *
     * @param desiredCapacity size of the new Inventory
     */
    public Inventory(int desiredCapacity)
    {
        this.slots    = new LinkedList<ItemStack>();
        this.capacity = desiredCapacity;
    }

    /**
     * Determine the number of slots currently in use.
     */
    public int utilizedSlots()
    {
        return this.slots.currentSize();
    }

    /**
     * Determine the number of empty (unused) slots.
     */
    public int emptySlots()
    {
        return this.totalSlots() - this.utilizedSlots();
    }

    /**
     * Retrieve the capacity (number of distinct types of items) that this
     * inventory can store.
     */
    public int totalSlots()
    {
        return this.capacity;
    }

    /**
     * Check if the inventory is full.
     *
     * @return true if the inventory is full, false otherwise
     */
    public boolean isFull()
    {
        return this.utilizedSlots() >= this.capacity;
    }

    /**
     * Find an ItemStack that matches the given Item.
     *
     * @param item Item to match
     * @return matching ItemStack or null if not found
     */
    public ItemStack findMatchingItemStack(Item item)
    {
        for (int i = 0; i < this.slots.currentSize(); i++)
        {
            ItemStack stack = this.slots.get(i);
            if (stack.getItem().equals(item))
            {
                return stack;
            }
        }
        return null;
    }

    /**
     * Add an ItemStack to the inventory without any checks.
     *
     * @param stack ItemStack to add
     */
    public void addItemStackNoCheck(ItemStack stack)
    {
        this.slots.add(stack);
    }
}
