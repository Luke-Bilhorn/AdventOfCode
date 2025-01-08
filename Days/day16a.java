package Days;
import java.util.*;
import java.io.*;


public class day16a {
	
	public static ArrayList<Valve> valves = new ArrayList<Valve>();
	public static boolean toOpen = false;
	
	public static ArrayList<Valve> parse(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);	
		ArrayList<Valve> tempValves = new ArrayList<Valve>();
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			String string = sc.nextLine();
			int w, x, y, z;
			String[] arr = string.split(";", 2);
			String[] arr0 = arr[0].split(" ", 5);
			String[] arr1 = arr[1].split(" ", 6);
			String a = arr0[1];
			String b = arr0[4];
			String[] arr2 = b.split("=", 2);
			int c = Integer.parseInt(arr2[1]);
			String d = arr1[5];
			String[] arr3 = d.split(", ");
			tempValves.add(new Valve(a, c, arr3));	
		}
		/*for(int i = 0; i < tempValves.size(); i++) {
			System.out.print(tempValves.get(i).name + "\n" + tempValves.get(i).value  + "\n");
			for(int j = 0; j < tempValves.get(i).connections.length; j++) {
				System.out.print(tempValves.get(i).connections[j] + " ");
			}
			System.out.print("\n\n");
		}*/
		return tempValves;
  	}
	
	public static int bigMethod(int duration, int depth) throws Exception {
		int minutes = duration;
		Valve current = valves.get(0);
		
		int totalPressure = 0;
		System.out.print("\n\n\n\n");
		System.out.print("\n" + (30 - minutes) + " " + current.name + " " + current.value);
		while(minutes > 0){
			minutes--;
			//current = highestForNextValve(current);
			current = bestPathForDepth(current, minutes, depth);
			System.out.print("\n" + (30 - minutes) + " " + current.name + " " + current.value);
			if(current.value != 0) {
				minutes--;
				totalPressure += (current.value * minutes);
				current.value = 0;
				System.out.print("\n" + (30 - minutes) + " " + current.name + " " + current.value);
				System.out.print(" (opened)");
			}
			
		}
		
		return totalPressure;
	}
	
	
	public static Valve bestPathForDepth(Valve start, int minutes, int depth) {
		if(depth > minutes) depth = minutes;
		int[] a = new int[start.connections.length];
		for(int i = 0; i < a.length; i++) {
			a[i] = comp(search(start.connections[i]), minutes, depth);
		}
		int hi = -1;
		int ind = -1;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > hi) {
				hi = a[i];
				ind = i;
			}
			else if(a[i] == hi && depth < minutes) {
				System.out.print(".");
				return bestPathForDepth(start, minutes, depth + 1);// this line right depth < minutes?
				
			}
			else if(a[i] == hi) return search(start.connections[0]); //should not matter at this point since the tie is confirmed
		}
		return search(start.connections[ind]);
	}
	
	
	public static int comp(Valve valve, int minutes, int depth) {
		ArrayList<Thing> list = new ArrayList<Thing>();
		ArrayList<Integer> listt = new ArrayList<Integer>();
		Score(valve, minutes, depth, listt, 0);
		int high = 0;
		for(int i : listt) {
			if(i > high) high = i;
		}
		//////System.out.print("\n" + high + "\n");
		return high;
	}
	
	
	
	public static void Score(Valve valve, int minutes, int depth, ArrayList<Integer> list, int score) {
		score += (minutes * valve.value);
		
		
		if(depth == 0) {
			list.add(score);
		} else {
			for(String a : valve.connections) {
				Valve b = search(a);
				Score(b, minutes - 1, depth - 1, list, score);
			}
		}
		//////System.out.print("\n" + score);
	}
	
	public static Valve highestForNextValve(Valve start) throws Exception {
		Valve end = new Valve();
		Valve check = end;
		//System.out.print(start.name + "\n " + start.connections + "\n");
		//Thread.sleep(3000);
		for(int i = 0; i < start.connections.length; i++){
			Valve current = search(start.connections[i]);
			if(current.value > end.value) end = current; 
		}
		if(check == end) end = search(start.connections[(int)(Math.random() * start.connections.length)]);
		return end;
	}
	
	public static Valve search(String name) {
		for(Valve i : valves) {
			if(i.name.equals(name)) return i;
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		//System.out.print("" + parse("day16.txt"));
		//valves = parse("day16.txt");
		int high = 0;
		for(int i = 2; i < 5; i++) {
			valves = parse("day16example.txt");
			//System.out.print("Started, thinking...\n");
			int current = bigMethod(30, i);
			//System.out.print("\n\nCOMPLETE: " + current + "\n\n");
			System.out.print("\n\nDepth: " + i + "\nPressure: " + current);
			if(current > high) {
				high = current;
				//System.out.print(high + "\n");
			}
		}
		System.out.print("\n\n\nHigh: " + high);
		
	}
		
}
