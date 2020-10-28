package JavaActivity3;

public class Activity1_3 {
	double earthyears,mercuryyears,venusyears,marsyears,jupiteryears,saturnyears,uranusyears,neptuneyears;
	public void years(double seconds) {
		earthyears= seconds/31557600;
		mercuryyears= earthyears/0.2408467;
		venusyears= earthyears/0.61519726;
		marsyears= earthyears/1.8808158;
		jupiteryears= earthyears/11.862615;
		saturnyears= earthyears/29.447498;
		uranusyears= earthyears/84.016846;
		neptuneyears= earthyears/164.79132;
		System.out.println("Age on Mercury is "+mercuryyears+" years");
		System.out.println("Age on Venus is "+venusyears+" years");
		System.out.println("Age on Earth is "+earthyears+" years");
		System.out.println("Age on Mars is "+marsyears+" years");
		System.out.println("Age on Jupiter is "+jupiteryears+" years");
		System.out.println("Age on Saturn is:"+saturnyears+" years");
		System.out.println("Age on Uranus is:"+uranusyears+" years");
		System.out.println("Age on Neptune is:"+neptuneyears+" years");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activity1_3 print = new Activity1_3();
		print.years(1000000000);
	}
}