package lesson7.server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private final int PORT = 8189;
    private List<ClientHandler> clients;
    private AuthService authService;

    public Server() {
        clients = new CopyOnWriteArrayList<>();
        authService = new SimpleAuthService();
        try {
            server = new ServerSocket(PORT);
            System.out.println("server started!");

            while (true){
                socket = server.accept();
                System.out.println("client connected "+ socket.getRemoteSocketAddress());
                new ClientHandler(this,socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("server closed");
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(ClientHandler sender, String msg){
        String message = String.format("%s : %s",sender.getNickname(), msg );

        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }


    public void sendMsgToUser(ClientHandler sender, String receiver, String msg) {
        String message = String.format("%s : %s", sender.getNickname(), msg);
        boolean foundUser = false;
        for ( ClientHandler client : clients ) {
            if (client.getNickname().equals(receiver)) {
                client.sendMsg(message);
                foundUser = true;
            }
        }
            if (!foundUser){
                sender.sendMsg("from Admin - you are trying to send a secret message to a not existing user");
            }
        }


    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }
}
