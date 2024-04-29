import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Client {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: java Client <host> <port> <name>");
            System.exit(1);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        String username = args[2];

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("users.txt"));

            // Search for details corresponding to the specified username
            String userDetails = properties.getProperty(username + ".company");
            if (userDetails != null) {
                // Display user details
                System.out.println("User Details for " + username + ":");
                System.out.println("Company: " + userDetails);
                System.out.println("Data Bytes: " + properties.getProperty(username + ".ndatabytes"));
                System.out.println("Check Bytes: " + properties.getProperty(username + ".ncheckbytes"));
                System.out.println("K: " + properties.getProperty(username + ".k"));
                System.out.println("Pattern: " + properties.getProperty(username + ".pattern"));
                System.out.println("Public Key: " + properties.getProperty(username + ".public_key"));
            } else {
                System.out.println("User " + username + " not found.");
            }

            // Proceed with client logic using host, port, and other details if needed
            // Your client logic goes here...
        } catch (IOException e) {
            System.err.println("Error reading users.txt: " + e.getMessage());
            System.exit(1);
        }
    }
}
