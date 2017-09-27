package com.shawn.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Demo1_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 12345);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());	//PrintStream中有写出换行的方法
		
		String infoFromServer = br.readLine();
		System.out.println(infoFromServer);
		
		ps.println("我打开了新世界");
		
		socket.close();
		
		
	}
}
