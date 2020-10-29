package JavaActivity3;

import java.util.LinkedList;
import java.util.Queue;

public class Activity3_3a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Queue<Integer> q = new LinkedList<>();
 
        for (int i=0;i<5;i++) {
            q.add(i);
        }
 
        System.out.println("Elements in queue: " + q);
 
        int removeEle = q.remove();
        System.out.println("removed element: " + removeEle);
 
        int headEle = q.peek();
        System.out.println("head of queue: " + headEle);
 
        int size = q.size();
        System.out.println("Size of queue: " + size);
	}

}
