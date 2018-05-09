package start;

import java.util.ArrayList;

import computer.Desktop;
import computer.Laptop;
import interfaces.Computer_interface;

public class Start {

	public static void main(String[] args) {
		ArrayList<Computer_interface> a = new ArrayList<Computer_interface>();

		for(int i = 0; i < 20; i++) {
			a.add(new Laptop(1, "EliteBook", "HP"));
		}
		for(int i = 0; i < 20; i++) {
			a.add(new Desktop(2, "EliteDesk", "HP"));
		}
		
		for(Computer_interface comp : a) {
			comp.checkPower();
		}
		
		Desktop d = new Desktop(3, "EliteDesk", "HP");
		Laptop l = new Laptop(1, "EliteBook", "HP");
		
		d.changeMac("ABC");
		d.getMac();
		d.changeMac();
		d.getMac();
		
		l.switchState(true);
		l.getState();
		l.switchState(false);
		l.getState();
		
	}

}
