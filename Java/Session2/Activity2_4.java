package JavaActivity4;

public class Activity2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            Activity2_4.exceptionTest("Will print to console");
            Activity2_4.exceptionTest(null);
            Activity2_4.exceptionTest("Won't execute");
        } catch(CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }
    }

    static void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
	}

}
