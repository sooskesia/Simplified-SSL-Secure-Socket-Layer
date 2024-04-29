import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    public static void main(String[] args) {
        // Retrieve system properties
        String privateKeyFile = System.getProperty("server.private_key");
        String usersFile = System.getProperty("server.users");
        String port = System.getProperty("server.port");

        // Print out retrieved properties for verification
        System.out.println("Private Key File: " + privateKeyFile);
        System.out.println("Users File: " + usersFile);
        System.out.println("Port: " + port);

        // Create a ServerSocket
        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port))) {
            System.out.println("Server started. Listening on port " + port);

            // Listen for incoming connections
            while (true) {
                // Accept incoming connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established with client " + clientSocket.getInetAddress());

                // Handle client communication
                // (You can implement your logic here)

                // Close the connection
                clientSocket.close();
                System.out.println("Client disconnected successfully");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
