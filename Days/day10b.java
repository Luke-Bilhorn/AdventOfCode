package Days;
import java.util.*;
import java.io.*;

public class day10b {
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		
		int valX = 1;
		int i = 0;
		boolean[] set = new boolean[240];
		while (sc.hasNextLine()) {
			i++;
			if(Math.abs(i - valX) <= 1) 
				set[i] = true;
			
			String string = sc.nextLine();
			int w = 0;
			if(string.charAt(0) == 'a') {
				String[] arr = string.split(" ", 2);
				w = Integer.parseInt(arr[1]);
				i++;
				valX+=w;
				
				if(Math.abs(i - valX) <= 1) 
					set[i] = true;
				
			}
			//.XX..X.X..XXX
		}
		for(int c = 0; c < set.length; c+=40) {
			for(int k = 0; k < 40; k++) {
				System.out.print(e(set[c + k]));
				//if(c < set.length) c++; 
			}
			System.out.print("\n");
		}
		return count;
  	}
	
	public static String e(boolean a) {
		if(a) return "X";
		return ".";
	}
	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day10.txt"));
	}
}
