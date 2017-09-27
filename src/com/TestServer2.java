package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer2 {

	/**
	 * �������ͻ�����������ϴ��ļ�
	 * 
	 * ���裨�������ˣ��� 1.�������̵߳ķ����� 2.��ȡ�ļ��� 3.�ж��ļ����Ƿ���ڣ���������ؿͻ���
	 * 4.�������ȡ���ݣ�����FileOutputStream���洢������
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// 1.�������̵߳ķ�����
		ServerSocket server = new ServerSocket(10001);
		System.out.println("�������������󶨶˿ں�10001");

		while (true) {
			Socket socket = server.accept();

			new Thread() {
				public void run() {
					try {
						// 2.��ȡ�ļ���
						InputStream is = socket.getInputStream();
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						String fileName = br.readLine();

						File dir = new File("update");
						dir.mkdir(); // �����������˵ı����ļ���
						File file = new File(dir, fileName); // ��װ��File����

						// 3.�ж��ļ����Ƿ���ڣ���������ؿͻ���
						if (file.exists()) {
							ps.println("yes");
							socket.close();
							return;
						} else {
							ps.println("no");

							// 4.�������ȡ���ݣ�����FileOutputStream���洢������
							FileOutputStream fos = new FileOutputStream(file);
							
							byte[] arr= new byte[4 * 1024];
							int len;
							
							while((len = is.read(arr)) != -1) {
								fos.write(arr, 0, len);
			
							}
							
							fos.close();
							socket.close();
						}

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}
			}.start();

			
		}
	}
}
