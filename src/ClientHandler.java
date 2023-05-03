import java.io.*;
import java.net.*;
import java.util.*;

// Client class
class ClientHandler {
	
	// driver code
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{

		try (Socket socket = new Socket("localhost", 1234)) {
			
			// writing to server
	        // Input stream socket and output stream socket.
	        InputStream inputStream = socket.getInputStream();
	        OutputStream outputStream = socket.getOutputStream();

	        // Create object output and input stream to send and receive objects
	        ObjectOutputStream out = new ObjectOutputStream(outputStream);
	        ObjectInputStream in = new ObjectInputStream(inputStream);

			// object of scanner class
			Scanner sc = new Scanner(System.in);

			
			// Return message
			Message returnMessage;

	        // Create and send a login message
	        System.out.println("Attemping Connection...");
	        
        	Message customerLogin1 = new Message("CustomerLogin", "Customer1", "123");
        	out.writeObject(customerLogin1);
        	
        	returnMessage = (Message) in.readObject();
        	System.out.println(returnMessage.getMessageType());
        	
        	
        	Message withdraw1 = new Message("Withdraw", "1001", 5);
        	out.writeObject(withdraw1);
        	
        	returnMessage = (Message) in.readObject();
        	System.out.println(returnMessage.getMessageType());
        	
        	Message deposit1 = new Message("Deposit", "1001", 10);
        	out.writeObject(deposit1);
        	
        	returnMessage = (Message) in.readObject();
        	System.out.println(returnMessage.getMessageType());
	        
	        
	        sc.close();
	        System.out.println("Closing socket");
	        socket.close();
	    }
	}
}
