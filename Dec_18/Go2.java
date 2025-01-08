package Dec_18;


import java.io.File;
import java.util.Scanner;
import java.util.*;
public class Go2
{
  public static void main(String[] args) throws Exception
  {
    // pass the path to the file as a parameter
    File file = new File(System.getProperty("user.dir"), "data.txt");
    Scanner sc = new Scanner(file);
    
    
    int[][][] field = new int[22][22][22];
    
    for(int i = 0; i <= field.length; i+=21)
    	for(int j = 0; j <= field[i].length; j+=21) 
    		for(int k = 0; k <= field[i][j].length; k+=21) 
    			field[i][j][k] = 2;
    		
    	
    
    while (sc.hasNextLine()) {

    	String stri = sc.nextLine();
    	int x, y, z;
        String[] arrOfStr = stri.split(",", 3);
  
      
    	
    	x = Integer.parseInt(arrOfStr[0]);
    	y = Integer.parseInt(arrOfStr[1]);
    	z = Integer.parseInt(arrOfStr[2]);
    	field[x+1][y+1][z+1] = 1;
    }
    
    
    
    
    
    
    
    int count = 0;
    
    ArrayList<int[]> nextList = new ArrayList<int[]>();
    int[] a = {1, 1, 1};
    int[] q = {19, 19, 19};
    nextList.add(a);
    nextList.add(q);
    
    
    while(nextList.size() > 0) {
    	//ArrayList<int[]> nextList = new ArrayList<int[]>();
    	//for(int[] e : nextList) {
    	int[] e = nextList.get(0);
    		field[e[0]][e[1]][e[2]] = 2;
    		if(e[0] < 21) {
    			if(field[e[0] + 1][e[1]][e[2]] == 0) {
    				int[] b = e;//{e[0], e[1], e[2]};
    				b[0]++;
    				nextList.add(b);
    			}
    		}
    		
    		if(e[0] > 0) {
    			if(field[e[0] - 1][e[1]][e[2]] == 0) {
    				int[] b = e;//{e[0], e[1], e[2]};
    				b[0]--;
    				nextList.add(b);
    			}
    		}
    		
    		
    		
    		
    		if(e[1] < 21) {
    			if(field[e[0]][e[1] + 1][e[2]] == 0) {
    				int[] b = e;//{e[0], e[1], e[2]};
    				b[1]++;
    				nextList.add(b);
    			}
    		}
    		
    		if(e[1] > 0) {
    			if(field[e[0]][e[1] - 1][e[2]] == 0) {
    				int[] b = e;//{e[0], e[1], e[2]};
    				b[1]--;
    				nextList.add(b);
    			}
    		}
    		
    		
    		
    		
    		if(e[2] < 21) {
    			if(field[e[0]][e[1]][e[2] + 1] == 0) {
    				int[] b = e;//{e[0], e[1], e[2]};
    				b[2]++;
    				nextList.add(b);
    			}
    		}
    		
    		if(e[2] > 0) {
    			if(field[e[0]][e[1]][e[2] - 1] == 0) {
    				int[] b = e;//{e[0], e[1], e[2]};
    				b[2]--;
    				nextList.add(b);
    			}
    		}
    	nextList.remove(0);	
    	System.out.print(nextList + "\n" + nextList + "\n\n");
    	//checkList = Object.clone(nextList);
    	//if(nextList.size() <= 0) break;
    }
    
    
    for(int i = 1; i < field.length-1; i++) {
    	for(int j = 1; j < field[i].length-1; j++) {
    		for(int k = 1; k < field[i][j].length-1; k++) {
    			int subCount = 0;
    			if(field[i][j][k] == 1) {
    				if(field[i+1][j][k] == 2) subCount++;
    				if(field[i-1][j][k] == 2) subCount++;
    				if(field[i][j+1][k] == 2) subCount++;
    				if(field[i][j-1][k] == 2) subCount++;
    				if(field[i][j][k+1] == 2) subCount++;
    				if(field[i][j][k-1] == 2) subCount++;
    			}
    			System.out.print(E(field[i][j][k]) + " ");
    			count += subCount;
    		}
    		System.out.print("\n");
  		}
  		System.out.print("\n");
	}
    
    
    		
    	
    System.out.print(count);
    	
    
  }
  
  public static String E(int a) {
	  switch(a) {
	  case 0 :
		  return ".";
	  case 1 :
		  return "X";
	  case 2 :
		  return "l";
	  }
	  return null;
  }
}
