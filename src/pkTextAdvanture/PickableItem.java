package pkTextAdvanture;

public class PickableItem extends Item {

	public PickableItem(String n, String d) {
		super(n, d);
		
	}
	
	public boolean isPickable(){	
		return true;
	}

}
