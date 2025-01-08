package Days;
import java.util.*;
import java.io.*;


public class Testinggggg {
	
	
	
	public static int doo(String fileName) throws Exception {
		System.out.print(name(rand(3)) + " first, then " + name(rand(3)) + ", then " + name(rand(3)) + ". Luke is a hippo.");
		
		
		System.out.print("\n\nThe box drops on (" + (rand(5) + 1) + ", " + (rand(5) + 1) + ").\n\n");
		/*
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			String string = sc.nextLine();
			int w, x, y, z;
			String[] arr = string.split(",", 2);
			
			
			String[] arr1 = arr[0].split("-", 2);
			String[] arr2 = arr[1].split("-", 2);
    	
			w = Integer.parseInt(arr1[0]);
			x = Integer.parseInt(arr1[1]);
			y = Integer.parseInt(arr2[0]);
			z = Integer.parseInt(arr2[1]);
			System.out.print(x + "     " + y + "     " + z + "    " + w + "\n\n");
			if(true) count++;
		}
		return count;*/
		return 0;
  	}
	
	public static int rand(int i) {
		return (int)(Math.random() * i);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day4.txt"));
	}
		

	public static int[] randList(int n) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int[] b = new int[n];
		for(int i = 0; i < n; i++) {
			a.add(i);
		}
		
		
		return null;//{0};
	}
	
	public static String name(int n) {
		switch(n) {
		case 0:
			return "Luke";
		case 1:
			return "Caleb";
		case 2:
			return "Eli";
		case -1:
			return "Hershey";
		}
		return "NaN";
	}
}
