package Days;
import java.util.*;
import java.io.*;








public class day5a {
	
	
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		ArrayList<Character>[] stacks = get();
		
		int count = 0;
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			String string = sc.nextLine();
			int x, y, z;
			String[] arr = string.split(" ", 6);
			x = Integer.parseInt(arr[1]);
			y = Integer.parseInt(arr[3]);
			z = Integer.parseInt(arr[5]);
			//System.out.print(x + "     " + y + "     " + z + "\n\n");
			
			ArrayList<Character> temp = new ArrayList<Character>();
			
			for(int i = 0; i < x; i++) 
				temp.add(stacks[y].remove(stacks[y].size() - 1));
			
			for(int i = 0; i < x; i++) 
				stacks[z].add(temp.remove(temp.size() - 1));
			
			
			if(true) count++;
			
			
			
		}
		
		for(int i = 1; i < stacks.length; i++) {
			for(int j = 0; j < stacks[i].size(); j++) {
				System.out.print(stacks[i].get(j));
			}
			System.out.print("\n");
		}
		
		System.out.print("\n\n");
		for(int i = 1; i < stacks.length; i++) {
			System.out.print(stacks[i].get(stacks[i].size() - 1));
		}
		
		
		return count;
  	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day5b.txt"));
	}
	
	
	public static ArrayList<Character>[] get() {
		ArrayList<Character>[] a = (ArrayList<Character>[]) new ArrayList[10];
		for(int i = 0; i < 10; i++) {
			a[i] = new ArrayList<Character>();
		}
		
		a[1].add('T');
		a[1].add('D');
		a[1].add('W');
		a[1].add('Z');
		a[1].add('V');
		a[1].add('P');

		a[2].add('L');
		a[2].add('S');
		a[2].add('W');
		a[2].add('V');
		a[2].add('F');
		a[2].add('J');
		a[2].add('D');
		
		a[3].add('Z');
		a[3].add('M');
		a[3].add('L');
		a[3].add('S');
		a[3].add('V');
		a[3].add('T');
		a[3].add('B');
		a[3].add('H');
		
		a[4].add('R');
		a[4].add('S');
		a[4].add('J');
		
		a[5].add('C');
		a[5].add('Z');
		a[5].add('B');
		a[5].add('G');
		a[5].add('F');
		a[5].add('M');
		a[5].add('L');
		a[5].add('W');
		
		a[6].add('Q');
		a[6].add('W');
		a[6].add('V');
		a[6].add('H');
		a[6].add('Z');
		a[6].add('R');
		a[6].add('G');
		a[6].add('B');
		
		a[7].add('V');
		a[7].add('J');
		a[7].add('P');
		a[7].add('C');
		a[7].add('B');
		a[7].add('D');
		a[7].add('N');
		
		a[8].add('P');
		a[8].add('T');
		a[8].add('B');
		a[8].add('Q');
		
		a[9].add('H');
		a[9].add('G');
		a[9].add('Z');
		a[9].add('R');
		a[9].add('C');
		
		return a;
	}
}
