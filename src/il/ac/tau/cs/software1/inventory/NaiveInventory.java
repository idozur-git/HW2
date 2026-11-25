package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;
	private Collectible[] Backpack;
	private int counter = 0;

	public NaiveInventory() {
		Backpack = new Collectible[INITIAL_CAPACITY];
	}

	@Override
	public void collect(Collectible collectible) {
		if (counter < Backpack.length){
			Backpack[counter] = collectible;
			counter++;
		}
		else{
			Collectible[] BiggerBackpack = new Collectible[counter*2];
			for (int i = 0; i < counter; i++){
				BiggerBackpack[i] = Backpack[i];
			}
			Backpack = BiggerBackpack;
			Backpack[counter] = collectible;
			counter++;
		}
	}

	@Override
	public float getTotalWeight() {
		float weight = 0;
		for (int j = 0; j < counter; j++){
			float currWeight = Backpack[j].getWeight();
			weight = weight + currWeight;
		}
		return weight;
	}

	@Override
	public int getCurrentCount() {
		return counter;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return Backpack;
	}
}
