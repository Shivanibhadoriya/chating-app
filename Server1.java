import java.net.*;
import java.io.*;
import java.util.*;
public class Server1{
    public static void main(String[] args)throws Exception{
        ServerSocket ss= new ServerSocket(1000);
        System.out.println("request send");
        Socket s=ss.accept();
        System.out.println("accept request");
        InputStream in = s.getInputStream();
        Scanner sc= new Scanner(in);
        try{
            System.out.print(sc.nextLine());
        }
        catch(Exception e){
            System.out.println("read Successfully");
        }
        in.close();
        sc.close();
        s.close();
        ss.close();
        
    }
}
