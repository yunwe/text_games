package pkTextAdvanture;

public class PersistentItem extends Item{

	public PersistentItem(String n, String d) {
		super(n, d);
	}
	
	public boolean isPickable(){
		return false;
	}

	

}
