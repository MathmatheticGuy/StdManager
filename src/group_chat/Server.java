package group_chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public ServerSocket serverSocket;
    
    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }
    
    public void startServer(){
        
        try{
            // while the server is not close
            while (!serverSocket.isClosed())
            {   
                // notify when someone connected
                Socket socket = serverSocket.accept(); // programm will be haulted here until a client connect.
                System.out.println("A new client have connected !");
                
                // each obj will be responsible for communicating with the client.
                // make the interface runnable
                // is implemented on a class whose instances will each executed by a separate thread.
                ClientHandler clientHandler = new ClientHandler(socket);
                // help client to run independently
                Thread thread = new Thread(clientHandler);
                thread.start(); // run thread
            }
            
        }
        catch (IOException e){
            
        }
    }
    
    // close server
    public void closeServerSocket(){
        try{
            if (serverSocket != null){
                serverSocket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException{

        ServerSocket serverSocket = new ServerSocket(1111); // create Server ip
        Server server =  new Server(serverSocket);
        server.startServer();
        
        
    }
}
