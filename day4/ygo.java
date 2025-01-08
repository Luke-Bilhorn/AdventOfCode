package day4;

import java.io.File;
import java.util.Scanner;
import java.util.*;

public class ygo {
	public static void main(String[] args) throws Exception {
		// pass the path to the file as a parameter
		File file = new File(System.getProperty("user.dir"), "day4.txt");
		Scanner sc = new Scanner(file);
    
    
    
    	
		int count = 0;
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			String stri = sc.nextLine();
			int w, x, y, z;
			String[] arr = stri.split(",", 2);
			String[] arr1 = arr[0].split("-", 2);
			String[] arr2 = arr[1].split("-", 2);
    	
			w = Integer.parseInt(arr1[0]);
			x = Integer.parseInt(arr1[1]);
			y = Integer.parseInt(arr2[0]);
			z = Integer.parseInt(arr2[1]);
			//System.out.print(x + "     " + y + "     " + z + "    " + w + "\n\n");
			if(comp2(w, x, y, z)) count++;
		}
		System.out.print(count);
  	}
	
	public static boolean comp(int a, int b, int c, int d) {
		int e = a - c;
		int f = b - d;
		if(e < 0 && f < 0 || e > 0 && f > 0) return false;
		return true;
	}
	
	public static boolean comp2(int a, int b, int c, int d) {
		if(c <= a && a <= d || c <= b && b <= d || a <= c && c <= b || a <= d && d <= b) return true;
		return false;
	}
	
	
	
}