package studio8;

import java.io.File;
import java.io.FileNotFoundException;
//import jssc.SerialPortException;
import java.util.Scanner;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.


public class CountSteps{

	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(new 
				File("/Users/jingzhou/git/studio-8-s8/data/d1.csv"));
		int count = 0;
		double z=1, z_prev=1,z_next=1;
		System.out.println(in.nextLine());
		String z_text=in.nextLine().split(",")[2];
		z = Double.parseDouble(z_text);
		
		while (in.hasNextLine()){
			
			z_text=in.nextLine().split(",")[2];
			z_next = Double.parseDouble(z_text);
			if (z<z_prev&&z<z_next){
				count +=1;
			}
			
			z_prev = z;
			z = z_next;
			
		}
		in.close();
		System.out.println(count);
		
	}
}