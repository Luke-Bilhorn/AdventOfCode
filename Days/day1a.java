package Days;

import java.util.*;
import java.io.*;


public class day1a {
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		int high1 = 0;
		int high2 = 0;
		int high3 = 0;
		int[] high = {0, 0, 0};
		
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			String string = sc.nextLine();
			int w = 0;
			while(!string.equals("")&& sc.hasNextLine()) {
				w += Integer.parseInt(string);
				string = sc.nextLine();
			}

			System.out.print(w + "\n\n");
			if(true) count++;
			if(w > high1 && w != 71924 && w != 69893 && w != 68589) high1 = w;
		}
		count = high1;
		return count;
  	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.print("\n" + doo("day1.txt"));
		System.out.print("\n" + (71924 + 69893 + 68589));
	}
}
