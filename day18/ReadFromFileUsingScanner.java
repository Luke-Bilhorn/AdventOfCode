package Dec_18;

import java.io.File;
import java.util.Scanner;
public class ReadFromFileUsingScanner
{
  public static void main(String[] args) throws Exception
  {
    // pass the path to the file as a parameter
    File file = new File(System.getProperty("user.dir"), "data.txt");
    Scanner sc = new Scanner(file);
 
    while (sc.hasNextLine())
      System.out.println(sc.nextLine());
  }
}
