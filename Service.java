import java.net.*;
import java.util.*;

public class Service {

	public static void main(String args[]) {
		
		try {
			System.out.print("Starting server...");
			ServerSocket socket = new ServerSocket(55555);
			Socket s = socket.accept();
			System.out.print("Client connected.");
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = reader.readLine();
			System.out.print("Client Message: " + str);
			
			String sendMsg = "msg received";
			OutputStreamWriter writer = new OutputStreamWriter(s.getOutputStream());
            PrintWriter output = new PrintWriter(writer);
            writer.write(sendMsg);
            writer.flush();
		}catch(Exception e) {
			;
		}
		
	}
	
}
