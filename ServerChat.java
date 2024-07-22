import java.net.*;
import java.util.*;
import java.io.*;
public class ServerChat{
   public static void main(String[] args)throws Exception{
     ServerSocket ss= new ServerSocket(2000);
     Socket s = ss.accept();
     
     OutputStream out = s.getOutputStream();
     PrintStream ps = new PrintStream(out);
     InputStream in = s.getInputStream();
     Scanner sc1 = new Scanner(in);
     
     Scanner sc2 = new Scanner(System.in);
     String replyReceived;
     String replySend;
     
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
     ss.close();
   }
}