package computer;

import interfaces.Computer_interface;

public class Desktop extends Computer implements Computer_interface {

	public Desktop(int cpu_number, String model, String manufacturer) {
		super(cpu_number, model, manufacturer);
	}

	@Override
	public void checkPower() {
		if(this.powerAtta) {
			System.out.println("Der Computer ist am Strom angeschlossen");
		}
		else {
			System.out.println("Der Computer ist nicht am Strom angeschlossen");
		}
		
	}

}
