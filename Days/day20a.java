package Days;
import java.util.*;
import java.io.*;

public class day20a {
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			String string = sc.nextLine();
			Integer w;

			w = Integer.parseInt(string);
			list.add(w);
			
			//System.out.print(w + "\n\n");
			if(true) count++;
		}
		
		for(int i = 0; i < list.size(); i++) {
			Integer a = list.remove(i);
			System.out.print(a + " " + i + "\n");
			int b = (i + a + 10000)%5000;
			list.add(b, a);
			if(b < i) i--;
			//if(a > 0) i++;
			//System.out.print(list.get(i) + "\n");
		}
		
		int c = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == 0) {
				c = i;
				i = list.size();
			}
		}
		
		int ans = list.get((c + 1000) % list.size()) + list.get((c + 2000) % list.size()) + list.get((c + 3000) % list.size());
		System.out.print((c + 1000) % list.size() + " " + (c + 2000) % list.size() + " " + (c + 3000) % list.size() + " " + ans);
		
		
		
		return count;
  	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.print("\n" + doo("day20.txt"));
	}
}
