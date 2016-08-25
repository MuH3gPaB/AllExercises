package SimpleFileReader;

import java.io.FileInputStream;
import java.io.IOException;

public class SimpleFileReader {

    public static void main(String[] args) throws Exception{

        if(args.length != 1){
            System.out.println("Error: Wrong argument!");
            throw new IllegalArgumentException();
        }

        FileInputStream fileInputStream;
        int theByte;

        try{
            fileInputStream = new FileInputStream(args[0]);
        }catch (IOException ex){
            System.out.println("Error: Couldn't open the file!");
            throw ex;
        }

        try{
            do{
                theByte = fileInputStream.read();
                System.out.print((char) theByte);
            }while (theByte != -1);
            System.out.println("<<< End of file >>>");
        }catch (IOException ex){
            System.out.println("Error: File read error!");
            throw ex;
        }
        finally {
            try{
                fileInputStream.close();
            }catch (IOException ex){
                System.out.println("Error: Couldn't close the file!");
                throw ex;
            }
        }
    }
}
