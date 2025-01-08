package Days;
import java.util.*;
import java.io.*;


public class day7a {
	public static int doo(String fileName) throws Exception {
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
		return count;
  	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day4.txt"));
	}
}
