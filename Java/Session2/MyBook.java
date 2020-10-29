package JavaActivity1;

public class MyBook extends Book{

	public void setTitle(String s) {
		title = s;
	}
	public static void main(String[] args) {
	Book mb = new MyBook();
	
	mb.setTitle("Title");
	System.out.println("Title is:"+mb.getTitle());
}
}