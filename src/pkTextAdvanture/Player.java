package pkTextAdvanture;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<Item> pocket; 
	public Player() {
		pocket = new ArrayList<Item>();
	}
	public ArrayList<Item> getPocket() {
		return pocket;
	}
	public void setPocket(ArrayList<Item> pocket) {
		this.pocket = pocket;
	}
	
	public String lookPocketItem(String n){
		String s = null;
		for (int i = 0; i < pocket.size(); i++) {
			if (pocket.get(i).getName().equalsIgnoreCase(n)) {
				s = pocket.get(i).getDescription();
				return s;
			}
		}
		return s;
	}
	
	public Item dropPocketItem(String n){
		Item itm = null;
		for (int i = 0; i < pocket.size(); i++) {
			if (pocket.get(i).getName().equalsIgnoreCase(n)) {
				itm = pocket.get(i);
				pocket.remove(i);
				return itm;
			}
		}
		return itm;
	}
	
	public void addPocketItem(Item i){
		pocket.add(i);
	}
}
