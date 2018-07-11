import java.io.*;
public class TEST
{
  public static void main(String[] args) throws Exception
  {
    int i;
    // pass the path to the file as a parameter
    FileReader fr =
      new FileReader("./data/planets.txt");
 
    
    while ((i=fr.read()) != -1){
        System.out.print((char) i);
    }
      
  }
 
}