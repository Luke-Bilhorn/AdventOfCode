package Days;
import java.io.*;
import java.util.*;

public class Mastermind {
	public static Scanner sc = new Scanner(System.in);
	public static int size = 4;
	public static int diff = 6;
	
	public static void main(String args[]) {
		//int[] a = randomized(4, 6);
		//int[] b = randomized(4, 6);
		//printBoard(a);
		//printBoard(b);
		//System.out.print(compare(a, b) + "\n");
		Game();
	}
	
	
	public static void Game() {
		System.out.print("Welcome to Mastermind!\nPlease enter a difficulty level:\n> ");
		int difficulty = sc.nextInt();
		System.out.print("Please enter a game size\n> ");
		int size = sc.nextInt();
		int[] board = randomized(size, difficulty);
		System.out.print("\n");
		
		int count = 0;
		while(true) {
			int[] turn = turn(size);
			count++;
			System.out.print(compare(turn, board) + "\n");

			if(comp(turn, board)){
				System.out.print("You win. Score: " + count);
				break;
			}
		}
		
		
	}
	public static boolean comp(int[] a, int[] b) {
		if(a.length != b.length)return false;
		for(int i = 0; i < a.length; i++) {
			if(a[i] != b[i]) return false;
		}
		
		return true;
	}
	
	public static void printBoard(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\n");
	}
	
	public static String compare(int[] a, int[] b) {
		if(a.length != b.length) return "improper sizes error"; 
		String ret = "";
		HashSet<Integer> A = new HashSet<Integer>();
		HashSet<Integer> B = new HashSet<Integer>();
		for(int i = 0; i < a.length; i++) {
			if(a[i] == b[i]) ret += "A ";
			else {
				A.add(a[i]);
				B.add(b[i]);
			}
		}
		
		for(int i : A) {
			if(B.contains(i)) {
				ret += "B ";
				B.remove(i);
			}
		}
		
		
		return ret;
	}
	
	
	public static int[] turn(int size) {
		System.out.print("\nPlease enter a guess:\n> ");
		int[] b = new int[size];
		for(int i = 0; i < size; i++) {
			b[i] = sc.nextInt();
			System.out.print("\n");
		}
		return b;
		
		//String a = sc.next();
		//String[] arr = a.split(" ", size);
		//int[] iarr = new int[size];
		//for(int i = 0; i < size; i++) {
		//	iarr[i] = Integer.parseInt(arr[i]);
		//}
		//return iarr;
	}
	
	
	
	public static int[] randomized(int size, int difficulty) {
		int[] ret = new int[size];
		for(int i = 0; i < size; i++) {
			ret[i] = (int)(Math.random() * difficulty);
		}
		return ret;
		
	}
	
	
	
	
}
