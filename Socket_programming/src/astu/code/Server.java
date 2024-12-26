package astu.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
   Socket socket = null;
   ServerSocket serverSocket = null;
   InputStreamReader inputStreamReader = null;
   OutputStreamWriter outputStreamWriter = null;
   BufferedReader bufferedReader = null;
   BufferedWriter bufferedWriter = null;
   // server socket to wait for client requests made on port 1234. this must be outside the while loop.
   while (true) {
	   try {
		   
		  //wait for a connection and when connected create socket object.
		   
		   serverSocket=new ServerSocket(1234);
		   
		   while(true) {
			   try {
				
				   
				   socket = serverSocket.accept();
				  
				   inputStreamReader = new InputStreamReader(socket.getInputStream());
				   outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
				   
				   
				   bufferedReader =  new BufferedReader(inputStreamReader);
				   bufferedWriter =  new BufferedWriter(outputStreamWriter);
				   
				   
				   
				   while(true) {
					   String mgsfromclient = bufferedReader.readLine();
					   
					   
					   System.out.println("client"+ mgsfromclient);
					   
					   bufferedWriter.write("Massage Received");
					   bufferedWriter.newLine();
					   bufferedWriter.flush();
					   
					   
					   if(mgsfromclient.equalsIgnoreCase("BYE"))
						   break;
					   
				   }
				   
				   socket.close();
				   inputStreamReader.close();
				   outputStreamWriter.close();
				   bufferedReader.close();
				   bufferedWriter.close();
				   
			} catch (Exception e) {
				 e.printStackTrace();
				// TODO: handle exception
			}
		   }
		   
		   
		   
		   
		 
		   
		    
		   
		   
		   
		   
		   
				   
	   }catch (Exception e) {
		// TODO: handle exception
	}
   }
	}

}
