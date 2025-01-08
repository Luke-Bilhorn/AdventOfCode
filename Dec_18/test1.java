package Dec_18;

import java.io.*;

public class test1 {
	public static void main(String[] args) throws Exception
    {
 
        // Passing the path to the file as a parameter
        FileReader fr = new FileReader("C:/Users/lukebilhorn/eclipse-workspace/Advent/src/Dec_18/data.txt");
 
        // Declaring loop variable
        int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1)
 
            // Print all the content of a file
            System.out.print((char)i);
    }
}



