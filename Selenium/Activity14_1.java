package selenium;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity14_1 {

	public static void main(String[] args) throws IOException, CsvException {
		// TODO Auto-generated method stub
		CSVReader reader = new CSVReader(new FileReader("src/test/java/tests/sample.csv"));
		
		List<String[]> list = reader.readAll();
        System.out.println("Total number of rows are: " + list.size());
        
        Iterator<String[]> itr = list.iterator();
        
        while(itr.hasNext()) {
            String[] str = itr.next();   
        System.out.print("Values are: ");
        for(int i=0;i<str.length;i++) {
            System.out.print(" " + str[i]);
        }
        System.out.println(" ");
       }
       reader.close();
	}

}