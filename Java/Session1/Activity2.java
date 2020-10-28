package JavaActivity2;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] =  {10,77,10,54,-11,10};
		int sum=0;
		for (int i:a) {
			if (i==10) {
				sum += i;
				System.out.println("Element is 10");
			}
			if (sum==30) {
				System.out.println("Sum is 30");
			}
		}

	}

}
