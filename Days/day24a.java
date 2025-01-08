package Days;

import java.util.*;
import java.io.*;

public class day24a {
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		
		ArrayList<int[]> b = new ArrayList<int[]>();
		while (sc.hasNextLine()) {
			String string = sc.nextLine();

			int[] a = new int[string.length()];
			for(int i = 0; i < string.length(); i++) {
				a[i] = e(string.substring(i, i+1));
			}
			
			b.add(a);
		}
		int[][] c = new int[b.size()][b.get(0).length];
		for(int i = 0; i < c.length; i++) {
			c[i] = b.get(i);
		}
		
		
		
		
		printGrid(c);
		
		c = iterate(c);
		System.out.print("\n\n\n\n");
		
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i].length; j++) {
				System.out.print(cc(c[i][j]) + " ");
			} 
			System.out.print("\n");
		}
		
		return count;
  	}
	
	public static int numMoves(int[][] grid, int startx, int starty, int endx, int endy) {
		int count = 0;
		int x = startx;
		int y = starty;
		
		
		while(x != endx && y != endy) {
			
			
			
			
			
			
			
			
			
			count++;
		}
		
		
		
		
		
		return count;
	}
	
	
	
	
	
	
	
	public static void printGrid(int[][] a){
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(cc(a[i][j]) + " ");
			} 
			System.out.print("\n");
		}
	}
	
	public static int[][] iterate(int[][] a){
		int[][]b = new int[a.length][a[0].length];
		int[] c = {21, 22, 24, 27};
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(IsIn(21, a[i][j])) {
					b[(((i - 1 - 1) + (5*(a.length -2)))) % (a.length - 2) + 1][(((j - 1) + (5*(a[0].length -2)))) % (a[0].length - 2) + 1] += 21;
					//[((j - 1) + 5*(a[0].length -2)) % (a[0].length - 2) + 1]
				} 
				if(IsIn(22, a[i][j])) {
					//b[i][j + 1] += 22;
					b[(((i - 1) + (5*(a.length -2)))) % (a.length - 2) + 1][(((j + 1 - 1) + (5*(a[0].length -2)))) % (a[0].length - 2) + 1] += 22;
				} 
				if(IsIn(24, a[i][j])) {
					b[(((i + 1 - 1) + (5*(a.length -2)))) % (a.length - 2) + 1][(((j - 1) + (5*(a[0].length -2)))) % (a[0].length - 2) + 1] += 24;
				} 
				if(IsIn(27, a[i][j])) {
					//b[i][j - 1] += 27;
					b[(((i - 1) + (5*(a.length -2)))) % (a.length - 2) + 1][(((j - 1 - 1) + (5*(a[0].length -2)))) % (a[0].length - 2) + 1] += 27;
				}
				if(a[i][j] == 99) b[i][j] = 99;
			}
		}
		return b;
	}
	public static int[][] iterate(int[][] a, int n) {
		int[][] b = new int[a.length][a[0].length];
		
		for(int i = 0; i < n && n > 0; i++) {
			b = iterate(a);
		}
		
		return b;
	}
	
	
	
	
	public static boolean IsIn(int a, int b) {
		//int[] c = {21, 22, 24, 27};
		if(a != 21 && a != 22 && a != 24 && a != 27) {
			System.out.print("ISIN took wrong values");
			return false;
		}
		
		if(b == 94) return true;
		
		if(b > 60 && b < 80 && !(b == 94 - a)) return true;
		
		//if(b == 73 && ! (a == 21)) return true;
		//if(b == 72 && ! (a == 22)) return true;
		//if(b == 70 && ! (a == 24)) return true;
		//if(b == 67 && ! (a == 27)) return true;
		
		if(b == 43 && (a == 21 || a == 22)) return true;
		if(b == 45 && (a == 21 || a == 24)) return true;
		if(b == 48 && (a == 21 || a == 27)) return true;
		if(b == 46 && (a == 22 || a == 24)) return true;
		if(b == 49 && (a == 22 || a == 27)) return true;
		if(b == 51 && (a == 24 || a == 27)) return true;
		
		if(b == a) return true;
		
		return false;
	}

	public static int e(String string) {
		if(string.equals(".")) return 0;
		if(string.equals("^")) return 21;
		if(string.equals(">")) return 22;
		if(string.equals("v")) return 24;
		if(string.equals("<")) return 27;
		if(string.equals("#")) return 99;
		return -1000000;	
	}
	
	public static String cc(int a) {
		if(a == 0) return ".";
		if(a == 21) return "^"; 
		if(a == 22) return ">"; 
		if(a == 24) return "v"; 
		if(a == 27) return "<"; 
		if(a == 99) return "#";
		return "%";
		
	}

	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day24.txt"));

	}
}
