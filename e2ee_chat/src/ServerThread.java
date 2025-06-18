/*
 * TODO: ricevere/inviare struttura dati al posto della mera stringa,
 * contenente mittente, messaggio (criptato...), cambiare anche le varie 
 * stampe
 */

import java.io.*;
import java.net.*;

public class ServerThread extends Thread{
    
    private Socket clientSocket_input = null;
    private Socket clientSocket_output = null;
    private int seed = -1;

    public ServerThread(Socket to, Socket from, int seed){
        super();
        this.clientSocket_input = from;
        this.clientSocket_output = to;
        this.seed = seed;
    }

    public void run(){

        DataInputStream inSocket;
        DataOutputStream outSocket;

        try {
			inSocket = new DataInputStream(clientSocket_input.getInputStream());
			outSocket = new DataOutputStream(clientSocket_output.getOutputStream());
		} catch (IOException ioe) {
			System.err.println("Thread-" + getName() + " Error: Problems during i/o streams creation.");
			ioe.printStackTrace();
			return;
		}

        /*
         * Communication
         */
        String mex = "";

        try{

            // Sending seed
            outSocket.writeInt(seed);
            System.out.println("Sending seed: " + seed);

            while(true){
                mex = inSocket.readUTF();
                System.out.println("Received: " + mex);

                outSocket.writeUTF(mex);
                System.out.println("Sending: " + mex);
            }
		} catch (Exception e) {
			System.err.println("Thread-" + getName() + " Fatal Error!");
			e.printStackTrace();
		}


        /*
         * Child terminated => Closing sockets
         */
		try {
            clientSocket_input.shutdownInput();
            clientSocket_output.shutdownOutput();
			clientSocket_input.close();
            clientSocket_output.close();
		} catch (IOException ioe) {
			System.err.println("Thread-" + getName() + " Error: Problems occured during i/o streams closure.");
			ioe.printStackTrace();
			System.out.println("Ending...");
		}
    }
}
