package Days;
import java.util.*;
import java.io.*;

public class day10a {
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		
		
		//int past2 = 0;
		//int past1 = 0;
		//int cur = 0;
		int valX = 1;
		int i = 0;
		boolean[] set = new boolean[240];
		while (sc.hasNextLine()) {
			i++;
			if((i + 20)%40 == 0) {
				count+=(valX * i);
				System.out.print(valX + " " + i + "\n\n");
			}
			//System.out.println(sc.nextLine());
			String string = sc.nextLine();
			int w = 0;
			if(string.charAt(0) == 'a') {
				String[] arr = string.split(" ", 2);
				w = Integer.parseInt(arr[1]);
				i++;
				valX+=w;
				
				if((i + 20)%40 == 0) {
					count+=(valX * i);
					System.out.print(valX + " " + i + "\n\n");
				}
			}
			
			//read here
			
			
			
			//valX += past1;
			//past2 = past1;
			//past1 = w;
			
			
			
			
			System.out.print(w + "\n\n");
			//if(true) count++;
		}
		return count;
  	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day10.txt"));
	}
}
