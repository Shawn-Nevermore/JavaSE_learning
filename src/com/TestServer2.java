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
	 * 案例：客户端向服务器上传文件
	 * 
	 * 步骤（服务器端）： 1.建立多线程的服务器 2.读取文件名 3.判断文件名是否存在，将结果发回客户端
	 * 4.从网络读取数据，定义FileOutputStream，存储到本地
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// 1.建立多线程的服务器
		ServerSocket server = new ServerSocket(10001);
		System.out.println("服务器启动，绑定端口号10001");

		while (true) {
			Socket socket = server.accept();

			new Thread() {
				public void run() {
					try {
						// 2.读取文件名
						InputStream is = socket.getInputStream();
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						String fileName = br.readLine();

						File dir = new File("update");
						dir.mkdir(); // 创建服务器端的本地文件库
						File file = new File(dir, fileName); // 封装成File对象

						// 3.判断文件名是否存在，将结果发回客户端
						if (file.exists()) {
							ps.println("yes");
							socket.close();
							return;
						} else {
							ps.println("no");

							// 4.从网络读取数据，定义FileOutputStream，存储到本地
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
