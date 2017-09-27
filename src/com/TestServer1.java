package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer1 {

	/**
	 * �ͻ����������д�ַ���������¼�룩�������������̣߳����ַ�����ת��д�أ��ͻ����ٴζ�ȡ�����Ƿ�ת����ַ���
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12121);
		System.out.println("�������������󶨵�12121�˿�");

		while (true) {
			Socket socket = server.accept();
			new Thread() {
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						String strFromClient = br.readLine();
						System.out.println("����ǰ���û���Ϣ��" + strFromClient);
						strFromClient = new StringBuilder(strFromClient).reverse().toString();
						System.out.println("�������û���Ϣ��" + strFromClient);
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
