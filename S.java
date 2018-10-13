

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


class S {

    public final static int DEFAULT_PORT = 5025; 
    
    public static void main(String[] args) 
    {
        int port = DEFAULT_PORT; 

        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {
                System.err.println("Error1");
            }
        }
        
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);

            Socket newSock    = null;
            Boolean stop = true;
            Boolean end = true;
            while(stop == true) {
                System.out.println("Server TCP ready at the port: " + port + "..." );

                //Waiting for the connection with the client
                newSock = serverSocket.accept(); 
                System.out.println("accept");
                while(end == true){
                System.out.println("qq");
                BufferedReader is = new BufferedReader(new InputStreamReader(newSock.getInputStream()));
                PrintWriter os = new PrintWriter(newSock.getOutputStream(), true); 
                String inputLine = is.readLine(); 
                System.out.println("Received -> " + inputLine);
                os.println(inputLine.toUpperCase());	
                os.flush(); 
                
                if(inputLine.equals("END")) {
                    System.out.println("ciclo uscita");
                    end = false;
                    is.close();
                    os.close();
                    newSock.close();               
                }
                
                if(inputLine.equals("STOP")) {
                    os.println( "Server aborted!");
                    is.close();
                    os.close();
                    newSock.close();
                    stop = false;
                    end = false;
                    }
      
                }
                }
                

                
                //Thread th = new HandleConnectionThread(newSock);
               // th.start();
            
        } 
        catch (IOException e) {
            System.err.println("Error2 " + e);
        }
    } // end main

}
