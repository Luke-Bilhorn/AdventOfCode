package Days;

import java.util.*;
import java.io.*;

public class day2a {
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			String string = sc.nextLine();
			String[] arr = string.split(" ", 2);
			
			int a = val(arr[0]);
			int b = val(arr[1]);
			
			int sub = 0;
			if(b == 2) sub = a + 3;
			else if(b == 1) sub = cycle(cycle(a));
			else sub = cycle(a) + 6;
			
		
		
			System.out.print(arr[0] + " " + arr[1] + " " + sub + "\n\n");
			count += sub;
		}
		return count;
  	}
	
	public static int val(String a) {
		if(a.equals("A") || a.equals("X")) return 1;
		if(a.equals("B") || a.equals("Y")) return 2;
		if(a.equals("C") || a.equals("Z")) return 3;
		return 0;
	}
	
	public static int cycle(int a) {
		if(a < 3) return ++a;
		return 1;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day2.txt"));
		//System.out.print(" " + cycle(1) + cycle(2)+ cycle(3) + " ");
	}
}
