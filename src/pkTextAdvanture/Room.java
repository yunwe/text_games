package pkTextAdvanture;

import java.util.ArrayList;


public class Room {

	private String name;
	private ArrayList<Item> roomItm;
	private ArrayList<String> exits;
	private int nearByRoomNo[];
	private String des;
	public Room( ) {
		roomItm = new ArrayList<Item>();
		exits = new ArrayList<String>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Item> getRoomItm() {
		return roomItm;
	}
	public void setRoomItm(ArrayList<Item> roomItm) {
		this.roomItm = roomItm;
	}
	public ArrayList<String> getExits() {
		return exits;
	}
	public void setExits(ArrayList<String> exits) {
		this.exits = exits;
	}
	public String getDes() {
		generateDescription();
		return des;
	}
	public void setDes(String des) {		
		this.des = des;
	}
	public void generateDescription(){
		des = "You are in " + name + ".\nThere are ";
		des+= roomItm.get(0).getName();
		for (int i = 1; i < roomItm.size()-1; i++) {
			des+= ", " + roomItm.get(i).getName() ;
		}
		des+= " and " + roomItm.get(roomItm.size()-1).getName() + ".";
		des+= "\nThere are "+ exits.size() + " exits : " ;
		for (int i = 0; i < exits.size(); i++) {
			des+= exits.get(i) + "; ";
		}
		
	}
	
	public String lookRoomItem(String n){
		String s = null;
		for (int i = 0; i < roomItm.size(); i++) {
			if (roomItm.get(i).getName().equalsIgnoreCase(n)) {
				s = roomItm.get(i).getDescription();
				return s;
			}
		}
		return s;
	}
	public Item giveRoomItem(String n){
		Item itm = null;
		for (int i = 0; i < roomItm.size(); i++) {
			if (roomItm.get(i).getName().equalsIgnoreCase(n) && roomItm.get(i).isPickable()) {
				itm = roomItm.get(i);
				roomItm.remove(i);				
				return itm;
			}
		}
		return itm;
	}
	
	public void addRoomItem(Item i){
		roomItm.add(i);
	}
	public int[] getNearByRoomNo() {
		return nearByRoomNo;
	}
	public void setNearByRoomNo(int[] nearByRoomNo) {
		this.nearByRoomNo = nearByRoomNo;
	}
	
	public int getRoonNo4Exit(String e){
		for (int i = 0; i < exits.size(); i++) {
			if (e.equalsIgnoreCase(exits.get(i))) {
				return nearByRoomNo[i];
			}
		}
		return -1;
	}

}
