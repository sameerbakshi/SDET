package JavaActivity1;

public class Activity1 {
	
	public static void main(String[] args) {
		Car carname = new Car("Black","Manual",2014);
		carname.displayCharacteristics();
		carname.accelarate();
		carname.brake();
	}
}
