package Days;
import java.util.*;
import java.io.*;

public class day6a {
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);
		String string = sc.nextLine();
		int count = 0;
		
		int n = 14; //4 yields answer to part 1, 14 yields answer to part 2.
		for(int i = 0; i < string.length() - n; i++) {
			if(diffCheck(string.substring(i, i + n), n)) return i + n;
		}
		return count;
  	}
	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day6.txt"));
	}
	
	public static boolean diffCheck(String s, int n) {
		char[] a = new char[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = s.charAt(i);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(a[i] == a[j]) return false;
			}
		}
		
		return true;
	}
}
