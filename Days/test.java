package Days;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<String> oeu = new ArrayList<String>();
		oeu.add("This thing");
		foo(oeu);
		for(String a : oeu) {
			System.out.print(a + "\n");
		}
	}
	
	public static void foo(ArrayList<String> uuu) {
		uuu.add("That thing");
	}
	
	
	
	
}
