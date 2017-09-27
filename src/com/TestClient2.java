package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient2 {

	/**
	 * 步骤： 1.提示要上传的文件路径，验证文件路径是否存在以及是否是文件夹 2.发送文件名到服务器端 3.接收结果，如果已存在，给予提示，直接退出
	 * 4.如果不存在，定义FileInputStream读取文件，写出到网络
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		// 1.提示要上传的文件路径，验证文件路径是否存在以及是否是文件夹
		File file = getFile();

		// 2.发送文件名到服务器端
		Socket socket = new Socket("127.0.0.1", 10001);

		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());

		ps.println(file.getName());

		// 3.接收结果，如果已存在，给予提示，直接退出
		String isExist = br.readLine();

		if ("yes".equals(isExist)) {
			System.out.println("您上传的文件已存在。");
			socket.close();
			return;
		}
		
		// 4.如果不存在，定义FileInputStream读取文件，写出到网络
		FileInputStream fis = new FileInputStream(file);
		byte[] arr = new byte[1024 * 4];
		int len;
		while((len = fis.read(arr)) != -1) {
			ps.write(arr, 0, len);
		}
		fis.close();
		socket.close();
	}

	private static File getFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("您要上传的文件路径是：");

		while (true) {
			String str = sc.nextLine();
			File file = new File(str);
			if (!file.exists() || file.isDirectory()) {
				System.out.println("文件路径不正确，请重新输入");
			} else {
				return file;
			}
		}
	}
}
