package astu.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Clinet {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		   Socket socket = null;
		   InputStreamReader inputStreamReader = null;
		   OutputStreamWriter outputStreamWriter = null;
		   BufferedReader bufferedReader = null;
		   BufferedWriter bufferedWriter = null;
		   try {
			   //IP address of the server,TCP port.
			   socket =new Socket("localhost",1234);
			   
			   //read from the sever and out put to the server.
			   inputStreamReader=new InputStreamReader(socket.getInputStream());
			   outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
			   
			   
			   //make more efficient by reading more than one  at once.
			   bufferedReader = new BufferedReader(inputStreamReader);
			   bufferedWriter = new BufferedWriter(outputStreamWriter);
			   
			   
			   // read  from the keyboard.
			   Scanner scanner = new Scanner(System.in);
			   
			    while (true) {
			    	
			    	String messtosend = scanner.nextLine();
			    	bufferedWriter.write(messtosend);
			    	bufferedWriter.newLine();
			    	bufferedWriter.flush();
			    	
		
			     System.out.println ( "server:"+ bufferedReader.readLine());
			    	
			     
			     if(messtosend.equalsIgnoreCase("BYE"))
			    	 break;
			     
			     
			    	
			    }
		   }catch (Exception e) {
			   e.printStackTrace();
			// TODO: handle exception
		} finally {
			
			try {
				if(socket!=null)
					socket.close();
				if(inputStreamReader != null)
					inputStreamReader.close();
				if(outputStreamWriter !=null)
					outputStreamWriter.close();
				if(bufferedReader!=null)
					bufferedReader.close();
				if(bufferedWriter != null)
					bufferedWriter.close();
			}catch (Exception e) {
				// Te.ODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
	

}
