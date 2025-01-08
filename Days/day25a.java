package Days;
import java.util.*;
import java.io.*;

public class day25a {
	public static long doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		long count = 0;
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			String string = sc.nextLine();
			
			System.out.print(string + "\t\t\t\t" + decimal(string) + "\n");
			count += decimal(string);
		}
		System.out.print("\n\n" + pental(count) + "\n" + pental2(count));
		return count;
  	}
	
	
	public static long decimal(String pental) {
		long decimal = 0;
		int l = pental.length();
		for(int i = 0; i < l; i++) {
			decimal += Math.pow(5, i) * val(pental.charAt(l - i - 1));
		}
		
		return decimal;
	}
	
	public static String pental2(long decimal) {
		String pental = "";
		while(true) {
			long b = decimal % 5;
			decimal = decimal - b;
			decimal /= 5;
			pental = b + pental; //+ b;
			if(decimal == 0) break;
		}
		
		
		return pental;
	}
	
	
	/* 
1200=1==-==1--1-0-02
12003421211432433331

33383508717511*/
	
	public static String pental(long decimal) {
		String pental = "";
		while(true) {
			long b = decimal % 5;
			decimal = decimal - b;
			if(b > 2) {
				b -= 5;
				decimal += 5;
			}
			decimal /= 5;
			pental = sym(b) + pental;	//+ sym(b);
			if(decimal == 0) break;
		}
		
		
		return pental;
	}
	
	public static String sym(long a) {
		if(a == -2) return "=";
		if(a == -1) return "-";
		return "" + a;
	}
	
	
	
	public static int val(char a) {
		if(a == '=') return -2;
		if(a == '-') return -1;
		if(a == '0') return 0;
		if(a == '1') return 1;
		if(a == '2') return 2;
		return -100000;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.print("\n\n" + doo("day25.txt"));
	}
}
