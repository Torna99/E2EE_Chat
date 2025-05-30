import java.net.*;
import java.io.*;

public class Client {

    public static final String USAGE = "Usage: java Client serverAddr serverPort";
    public static final int SOCKET_TIMEOUT = 60000;

    public static void main(String[] args) {

        // Initialize the client application
        System.out.println("Client application started...");

        InetAddress addr = null;
        int port = -1;

        // Argument validation
        try{
            if(args.length == 2){
                addr = InetAddress.getByName(args[0]);
                port = Integer.parseInt(args[1]);
                if (port < 1024 || port > 65536){
                    System.out.println("Invalid port!\n" + USAGE);
                    System.out.println(1);
                }                
            }else{
                System.out.println(USAGE);                
                System.exit(1);
            }
        }catch (NumberFormatException e) {
			System.err.println("Server port not valid: ");
			e.printStackTrace();
			System.out.println(USAGE);
			System.exit(2);
		} catch (UnknownHostException e) {
			System.err.println("Server's IP address not valid: ");
			e.printStackTrace();
			System.out.println(USAGE);
			System.exit(2);
		} catch (SecurityException e) {
			System.err.println("Server's IP address not valid: ");
			e.printStackTrace();
			System.out.println(USAGE);
			System.exit(2);
		} 

        // Connection to the Server and socket creation
        Socket socket = null;
        DataInputStream inputSocket = null;
        DataOutputStream outputSocket = null;

        try{
            socket = new Socket(addr, port);
            socket.setSoTimeout(SOCKET_TIMEOUT);
            System.out.println("Connection created! Socket: " + socket);
        }catch (SocketException e) {
			System.err.println("Protocol problems in socket creation: ");
			e.printStackTrace();
			System.exit(3);
		} catch (IOException e) {
			System.err.println("Problems during socket creation: ");
			e.printStackTrace();
			System.exit(3);
		} catch (Exception e) {
			System.err.println("Problems during socket creation: ");
			e.printStackTrace();
			System.exit(3);
		}

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String message = null;

        try{
            inputSocket = new DataInputStream(socket.getInputStream());
            outputSocket = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e) {
            System.err.println("Problems during streams creation: ");
            e.printStackTrace();
            System.exit(2);
		}

        // Starting communication

        // TODO: 
        /*
         * mandare mex al server
         */
    }
}
