package wordCloud;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class WordClient {
	public static void main(String[] args) 
	{ 
		new WordClient();
	}
	static int portNumber =  6633;
	static String hostName =  "localhost";

	public WordClient()
	{
		try (
				Socket echoSocket = new Socket(hostName, portNumber);
				PrintWriter out =
						new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in =
						new BufferedReader(
								new InputStreamReader(echoSocket.getInputStream()));

				)
				{

			String message = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			

			out.println(message);
			if ((message = in.readLine()) != null) {
				System.out.println(message);

			}
			//stuff
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

	}

	static Socket serverConnection;

	public WordClient(double lat , double lon , double height) 
	{
		if(serverConnection == null)
			try {
				serverConnection = new Socket(hostName, portNumber);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		try (	PrintWriter out = new PrintWriter(serverConnection.getOutputStream(), true);
				BufferedReader in = new BufferedReader( new InputStreamReader(serverConnection.getInputStream()));)
				{
			
			
			String message = "map " + lat + " " + lon + " " + height;
			
			out.println(message);
			
			while ((message = in.readLine()) != null) {
				String[] messArr = message.split("  *");
				double inlat = Double.parseDouble(messArr[0]);
				double inlon = Double.parseDouble(messArr[1]);
				String inword = messArr[2];
				
				
				//need to add markers to map here
				//
				//
				System.out.println(message);  
			}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

	}
}
