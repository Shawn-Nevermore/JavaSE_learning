package com.shawn.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1_Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);

		while (true) {
			Socket socket = server.accept();// 接受客户端的请求

			new Thread() {
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						ps.println("春暖花开，知乎有你");
						String infoFromClient = br.readLine();
						System.out.println(getName() + "..." + infoFromClient);
						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}.start();

		}

	}
}
