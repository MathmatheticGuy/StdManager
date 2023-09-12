package group_chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;
    
    
    
    public Client(Socket socket, String username){
        try{
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
            
        }
        catch(IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    
    // identifier
    public void sendMessage(){
        try {
            bufferedWriter.write(username);
            bufferedWriter.newLine(); 
            bufferedWriter.flush();
            
            // get what the user type in the Console then scan that
            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()){
                String messageToSend = scanner.nextLine();
                bufferedWriter.write(username + ": " + messageToSend);
                
                bufferedWriter.newLine();
                bufferedWriter.flush();
                
            }
            
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    
    
    public void litenForMessage(){
        // use a new thread
        new Thread(new Runnable() {
            // each client whill have a seperated thread waiting for new message
            @Override
            public void run(){
                String msgFromGroupChat;
                
                while (socket.isConnected()){
                    try {
                        msgFromGroupChat = bufferedReader.readLine();
                        System.out.println(msgFromGroupChat);                        
                    }
                    catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }
    
    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        
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
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Enter your name for group chat: ");
        String username = scanner.nextLine(); 
        Socket socket = new Socket("localhost", 1111);
        Client client = new Client(socket, username);
        client.litenForMessage();
        client.sendMessage();
    } 
}
