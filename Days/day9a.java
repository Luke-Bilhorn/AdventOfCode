package Days;

import java.util.*;
import java.io.*;

public class day9a {


	
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);
	
		int[] X = new int[10];
		int[] Y = new int[10];
		boolean[][] been = new boolean[1000][1000];
		
		while (sc.hasNextLine()) {
			String string = sc.nextLine();
			String[] arr = string.split(" ", 2);
			String d = arr[0];	
			int w = Integer.parseInt(arr[1]);

			for(int i = 0; i < w; i++) {
				if(d.equals("U")) {
					Y[0]++;
				} else if(d.equals("D")) {
					Y[0]--;
				} else if(d.equals("L")) {
					X[0]--;
				} else if(d.equals("R")) {
					X[0]++;
				} 
				for(int l = 1; l < 10; l++) {
					if(Math.abs(X[l] - X[l - 1]) > 1 || Math.abs(Y[l] - Y[l - 1]) > 1) {			//(!(Math.abs(X) <= 1 && Math.abs(Y) <= 1)) {
						if(X[l] - X[l - 1] > 0) {
							X[l]--;
						} else if(X[l] - X[l - 1] < 0) {
							X[l]++;
						} 
						
						if(Y[l] - Y[l - 1] > 0) {
							Y[l]--;
						} else if(Y[l] - Y[l - 1] < 0) {
							Y[l]++;
						}
					}
				}
				
				been[500 + X[9]][500 + Y[9]] = true;
			}
		}
		
		for(int i = 450; i < 520; i++) {
			for(int j = 200; j < 510; j++) {
				if(i == 500 && j == 500) System.out.print("0 ");
				else System.out.print(e(been[i][j]) + " ");
			}
			System.out.print("\n");
		}
		
		int count = 0;
		for(int i = 0; i < been.length; i++) {
			for(int j = 0; j < been[0].length; j++) {
				if(been[i][j]) count++;
				
			}

		}
		return count;
  	}
	
	public static String e(boolean a) {
		if(a) return "X";
		return ".";
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day9.txt"));
	}
	
	
}
