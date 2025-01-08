package Days;

import java.util.*;
import java.io.*;

public class day8a {
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		
		ArrayList<int[]> b = new ArrayList<int[]>();
		while (sc.hasNextLine()) {

			String string = sc.nextLine();

			int[] a = new int[string.length()];
			for(int i = 0; i < string.length(); i++) {
				a[i] = Integer.parseInt(string.substring(i, i+1));
			}

			b.add(a);
		}
		
		int[][] c = new int[b.size()][b.get(0).length];
		for(int i = 0; i < c.length; i++) {
			c[i] = b.get(i);
		}
		//System.out.print(c.length + "\n" + c[0].length + "\n");
	
		
		/*for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i].length; j++) {
				
				boolean isVisibleA = true;
				boolean isVisibleB = true;
				boolean isVisibleC = true;
				boolean isVisibleD = true;
				
				for(int k = j + 1; k < c.length; k++) {
					if(c[i][j] <= c[i][k]) isVisibleA = false;
				}
				
				for(int k = 0; k < j; k++) {
					if(c[i][j] <= c[i][k]) isVisibleB = false;
				}
				
				for(int k = i + 1; k < c[0].length; k++) {
					if(c[i][j] <= c[k][j]) isVisibleC = false;
				}
				
				for(int k = 0; k < i; k++) {
					if(c[i][j] <= c[k][j]) isVisibleD = false;
				}
				
				boolean isVisible = isVisibleA || isVisibleB || isVisibleC || isVisibleD;
				if(isVisible) count++;
				System.out.print(e(isVisible) + "");
				
			}
			System.out.print("\n");
			
			
		}*/
		
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i].length; j++) {
				
				int visA = 0;
				int visB = 0;
				int visC = 0;
				int visD = 0;
				
				for(int k = j + 1; k < c.length; k++) {
					if(c[i][j] <= c[i][k]) {
						k = c.length;
					}
					visA++;
				}
				
				for(int k = j-1; k >= 0; k--) {
					if(c[i][j] <= c[i][k]) {
						k = -1;
					}
					visB++;
				}
				
				for(int k = i + 1; k < c[0].length; k++) {
					if(c[i][j] <= c[k][j]) {
						k = c[0].length;
					}
					visC++;
				}
				
				for(int k = i-1; k >= 0; k--) {
					if(c[i][j] <= c[k][j]) {
						//visD = Math.abs(j - k);
						k = -1;
					}
					visD++;
				}
				
				int visScore = visA*visB*visC*visD;
				if(visScore > count) {
					count = visScore;
					System.out.print(i + ":" + j + "  " + visA + " " + visB + " " + visC + " " + visD + "   " + visScore + "\n" );
				}
				
				
				
			}
			System.out.print("\n");
			
			
		}
		
		
		/*System.out.print("\n\n\n\n");
		
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j] + "  ");
			}
			System.out.print("\n\n");
		}*/
		
		
		
		
		
		return count;
  	}
	
	
	
	public static String e(boolean a) {
		if(a) return "X";
		return ".";
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day8.txt"));
	}
}
