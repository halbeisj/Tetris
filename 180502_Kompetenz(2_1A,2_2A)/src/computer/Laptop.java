package computer;

import interfaces.Computer_interface;

public class Laptop extends Computer implements Computer_interface {
	
	protected boolean opened;
	protected boolean hasBatt = true;

	public Laptop(int cpu_number, String model, String manufacturer) {
		super(cpu_number, model, manufacturer);
	}
	
	public void switchState(boolean started) {
		if(this.started) {
			this.opened = false;
			this.started = started;
		}
		else {
			this.opened = true;
			this.started = started;
		}
	}

	@Override
	public void checkPower() {
		if(this.hasBatt && this.powerAtta) {
			System.out.println("Der Computer ist an Strom und Akku angeschlossen");
		}
		else if(!this.hasBatt && this.powerAtta) {
			System.out.println("Der Computer lädt");
		}
		else if(this.hasBatt && !this.powerAtta) {
			System.out.println("Der Computer läuft mit Batterie");
		}
		else {
			System.out.println("Der Computer hat keinen Strom");
		}
	}
	
	public void getState() {
		System.out.println(this.started);
		System.out.println(this.opened);
	}

}
