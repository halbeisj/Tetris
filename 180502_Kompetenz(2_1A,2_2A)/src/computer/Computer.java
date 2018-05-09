package computer;

public class Computer {

	protected int cpu_number;
	protected String model;
	protected String manufacturer;
	protected boolean started;
	protected String mac_address;
	protected boolean powerAtta = false;
	
	public Computer(int cpu_number, String model, String manufacturer) {
		this.cpu_number = cpu_number;
		this.model = model;
		this.manufacturer = manufacturer;
	}
	
	public void switchState(boolean started) {
		this.started = started;
	}
	
	public void changeMac() {
		this.mac_address = null;
	}
	
	public void changeMac(String mac_address) {
		this.mac_address = mac_address;
	}
	
	public void getMac() {
		System.out.println(this.mac_address);
	}
	
}
