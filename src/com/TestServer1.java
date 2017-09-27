package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer1 {

	/**
	 * 客户端向服务器写字符串（键盘录入），服务器（多线程）将字符串反转后写回，客户端再次读取到的是反转后的字符串
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12121);
		System.out.println("服务器启动，绑定到12121端口");

		while (true) {
			Socket socket = server.accept();
			new Thread() {
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						String strFromClient = br.readLine();
						System.out.println("处理前的用户信息：" + strFromClient);
						strFromClient = new StringBuilder(strFromClient).reverse().toString();
						System.out.println("处理后的用户信息：" + strFromClient);
						ps.println(strFromClient);
						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}
