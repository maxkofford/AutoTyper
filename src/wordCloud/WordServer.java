package wordCloud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WordServer {

	static int portNumber =  6633;
	public static void main(String[] args) 
	{ 
		try 
		(ServerSocket serverSocket = new ServerSocket(portNumber))
		{

			while(true)
			{
				(new Thread(new ClientHandler(serverSocket.accept()))).start();
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

class ClientHandler implements Runnable {

	static Socket clientSocket;
	int threadNum = 0;
	
	public ClientHandler()
	{
		clientSocket = null;
	}
	public ClientHandler(Socket incon)
	{
		clientSocket = incon;
	}
	public ClientHandler(Socket incon , int innum)
	{
		clientSocket = incon;
		threadNum = innum;
	}

	
	public void run() 
	{

		try (
				
				PrintWriter out =
				new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				)
				{
			//stuff
			String message = "";
			while ((message = in.readLine()) != null) {
				
				String[] messArr = message.split("  *");
				String type = messArr[0];
				double inlat = Double.parseDouble(messArr[1]);
				double inlon = Double.parseDouble(messArr[2]);
				double inhei = 0;
				if(type == "map");
					inhei = Double.parseDouble(messArr[3]);
				
				
				
			    out.println("server: " + message);
			    //System.out.println("echo: " + in.readLine());
			}
			
			
				} catch(Exception e) {
					e.printStackTrace();
				}

		try {
			clientSocket.close();
			System.out.println("Connection Closed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
