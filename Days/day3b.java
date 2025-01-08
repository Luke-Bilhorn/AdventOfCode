package Days;
import java.util.*;
import java.io.*;
public class day3b {
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			String s3 = sc.nextLine();
			
			
			
			//System.out.print(str1 + " " + str2 + "\n" + string + "\n\n");
			count+= value(common(s1, s2, s3));
		}
		return count;
  	}
	
	public static int value(char a) {
		char[] vals = {'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
				'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for(int i = 0; i < vals.length; i++) {
			if(a == vals[i]) return i;
		}
		return 0;
	}
	
	public static char common(String s1, String s2, String s3) {
		for(int i = 0; i < s1.length(); i++) {
			if(s2.contains(s1.subSequence(i, i+1)) && s3.contains(s1.subSequence(i, i+1))) return s1.charAt(i);
		}
		return '1';
	}
	
	public static void main(String[] args) throws Exception {
		System.out.print("" + doo("day3.txt"));
	}
}
