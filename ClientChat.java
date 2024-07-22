import java.net.*;
import java.util.*;
import java.io.*;
public class ClientChat{
   public static void main(String[] args)throws Exception{
     Socket s= new Socket("localhost",2000);
     System.out.println("request sending");
     
     OutputStream out = s.getOutputStream();
     PrintStream ps = new PrintStream(out);

     InputStream in = s.getInputStream();
     Scanner sc1 = new Scanner(in);
     
     Scanner sc2 = new Scanner(System.in);
     String replyReceived;
     String replySend;
     
     ps.println("request sending");
     try{
        replyReceived = sc1.nextLine();
        while(replyReceived.indexOf("bye") == -1){
            System.out.println("                      " + replyReceived);
            replySend = sc2.nextLine();
            ps.println(replySend);
            replyReceived = sc1.nextLine();
        }
        System.out.print("                      "+replyReceived);
        ps.println("bye..!");
     }
     catch(Exception e){
       System.out.println("disconnected.....");
     }
     s.close();
   }
}