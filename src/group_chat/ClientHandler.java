
package group_chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;


public class ClientHandler implements Runnable{
    // ArrayList     
    // Responsible for us allowing to communicate or send messages.
    // or broadcast to multiple client instead of just one or just the server.
    // static -> belong to the Class not each Object of the class. (global not local)
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket; 
    private  BufferedReader bufferedReader; // read data from server
    private BufferedWriter bufferedWriter; // send data specific to our client
    private String clientUserName; 
    
    public ClientHandler(Socket socket){
        try{
            this.socket = socket;
            // this Stream to send thing
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // this Stream to read thing from
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // readline() so that the it read all the line 
            this.clientUserName = bufferedReader.readLine();
            clientHandlers.add(this); // this represent an Obj
            broadcastMessage("SERVER: " + clientUserName + " has enterd the chat!");
        }
        catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
            
        }
    }
    
    @Override 
    public void run(){
        String messageFromClient;
        
        // connected ifinite loop
        while (socket.isConnected()){
            // listen to a message
            try{
                // run on a seperate thread bc this is a blocking operation
                messageFromClient = bufferedReader.readLine();
                broadcastMessage(messageFromClient);
            } 
            catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }
    
    public void broadcastMessage(String messageToSend){
        // represent each clientHandler through each iteration
        for (ClientHandler clientHandler : clientHandlers){
            try {
                // is it doesn't equal -> send message to the client
                if (!clientHandler.clientUserName.equals(clientUserName)){
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine(); // like Enter Key
                    clientHandler.bufferedWriter.flush(); // manually flush it
                }
            }
            
            catch(IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter); 
            }
        } 
        
    }
    
    // when client left the chat
    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + clientUserName + " has left the chat !");
        
    }
    
    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
        try {
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (socket != null){
                socket.close(); //also close input/output stream
            }
        } catch (IOException e){
            e.printStackTrace();
        }      
    }
}
