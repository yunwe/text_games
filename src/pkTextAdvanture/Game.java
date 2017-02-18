package pkTextAdvanture;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Game {
	private Player p;
	private Room rom[];
	private int currentRoom;

	public static void main(String[] args){
//		Game g = new Game();
//		g.startGame();
	}
	public Game() {
		currentRoom = (int) (4*Math.random());
		p = new Player();

		rom = new Room[4];
		rom[0] = new Room();
		rom[0].setName("Living Room");		
		rom[0].addRoomItem(new PersistentItem("Sofa", "Modern Chair, colorful and stylish!"));
		rom[0].addRoomItem(new PersistentItem("Glass Table", "Decorated Table in the center of room."));
		rom[0].addRoomItem(new PickableItem("Flower", "White Rose which is very fragnant."));
		int nr[] = {3, 1};
		ArrayList<String> e = new ArrayList<String>();
		e.add("West");
		e.add("South");
		rom[0].setExits(e);
		rom[0].setNearByRoomNo(nr);

		rom[1]  = new Room();
		rom[1].setName("Dinning Room");
		rom[1].addRoomItem(new PersistentItem("Chairs", "Some chairs are dirty!"));
		rom[1].addRoomItem(new PersistentItem("Table", "Circular table with many dishes on it."));
		rom[1].addRoomItem(new PickableItem("Spoon", "A steel spoon which is clean and bright."));
		ArrayList<String> e1 = new ArrayList<String>();
		e1.add("North");
		e1.add("West");
		int nr1[] = {0,2};
		rom[1].setNearByRoomNo(nr1);
		rom[1].setExits(e1);

		rom[3]  = new Room();
		rom[3].setName("Bed Room");
		rom[3].addRoomItem(new PersistentItem("Bed", "A little bit mess up!"));
		rom[3].addRoomItem(new PersistentItem("Light House", "Glowing faintly."));
		rom[3].addRoomItem(new PickableItem("Pillow", "A pink pillow with a bear picture on it."));
		ArrayList<String> e3 = new ArrayList<String>();
		e3.add("East");
		e3.add("South");		
		int nr3[] = {0,2};
		rom[3].setNearByRoomNo(nr3);
		rom[3].setExits(e3);

		rom[2]  = new Room();
		rom[2].setName("Shower Room");
		rom[2].addRoomItem(new PersistentItem("Bath Tab", "Filled with water!"));
		rom[2].addRoomItem(new PersistentItem("Mirror", "A large mirror which is clean and clear."));
		rom[2].addRoomItem(new PickableItem("Towel", "A towel to clean up the water after bath."));
		ArrayList<String> e2 = new ArrayList<String>();
		e2.add("North");
		e2.add("East");		
		int nr2[] = {3,1};
		rom[2].setNearByRoomNo(nr2);
		rom[2].setExits(e2);
		
	}
	public void startGame(){
		System.out.println(rom[currentRoom].getDes());
		String command = "";
		Scanner input = new Scanner(System.in);
		while (true) {			
			command = input.nextLine();
			System.out.println(parser(command));
		}
	}

	public String Look(){
		return rom[currentRoom].getDes();
	}

	public String Look(String itm){
		String temp = null;
		temp = rom[currentRoom].lookRoomItem(itm);
		if (temp == null) {
			temp = p.lookPocketItem(itm);
		}
		if (temp == null) {
			temp = "There is no object named "+ itm + ".";
		}
		return temp;
	}

	public String move(String e){
		int i = rom[currentRoom].getRoonNo4Exit(e);
		if (i != -1) {
			currentRoom = i;
			return rom[currentRoom].getDes();
		}else{
			return "There is no exit in "+ e +" direction.";
		}
	}

	public String pick(String itm){
		Item i = rom[currentRoom].giveRoomItem(itm);
		if (i != null) {
			p.addPocketItem(i);
			return "You pick up the " + i.getName() + " and put it in the pocket.";
		}else if (rom[currentRoom].lookRoomItem(itm) == null){
			return "There is no item as " + itm + ".";
		}else{
			return "You cannot pick up " + itm + ".";
		}
	}

	public String drop(String itm){
		Item i = p.dropPocketItem(itm);
		if(i != null){
			rom[currentRoom].addRoomItem(i);
			return "You droped " +  i.getName() + ".";
		}else{
			return "There is no item as " + itm + " to drop.";
		}
	}

	public String help() {
		return "Help!\n"
				+ "- command must be used with the format <command> <object name>\n"
				+ "- but command are not case sensitive\n"
				+ "- For Example type 'look towel' to look the towel.\n"
				+ "- Availabel command are:\n"
				+ "\t- move\n"
				+ "\t- look\n"
				+ "\t- pick\n"
				+ "\t- drop\n"
				+ "- Some can be use with single word such as :\n"
				+ "\t- look\n"
				+ "\t- help\n"
				+ "\t- End";
	}
	public String parser(String cmd){
		cmd = cmd.trim();
		String c = "";
		String obj = "";
		String output = "Invalid command. Please see help!";
		int mid = cmd.indexOf(" ");
		if(mid != -1){
			c = cmd.substring(0, mid).trim();
			obj = cmd.substring(mid +1).trim();			
			if (c.equalsIgnoreCase("look")) {
				output = Look(obj);
			}else if (c.equalsIgnoreCase("drop")) {
				output = drop(obj);
			}else if(c.equalsIgnoreCase("pick")){
				output = pick(obj);
			}else if (c.equalsIgnoreCase("move")) {
				output = move(obj);
			}
		}else if(cmd.equalsIgnoreCase("look")){
			output = Look();
		}else if(cmd.equalsIgnoreCase("help")){
			output = help();
		}else if (cmd.equals("end")) {
			System.exit(0);
		}
		return output;
	}
}
