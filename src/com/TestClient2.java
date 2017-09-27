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
	 * ���裺 1.��ʾҪ�ϴ����ļ�·������֤�ļ�·���Ƿ�����Լ��Ƿ����ļ��� 2.�����ļ������������� 3.���ս��������Ѵ��ڣ�������ʾ��ֱ���˳�
	 * 4.��������ڣ�����FileInputStream��ȡ�ļ���д��������
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		// 1.��ʾҪ�ϴ����ļ�·������֤�ļ�·���Ƿ�����Լ��Ƿ����ļ���
		File file = getFile();

		// 2.�����ļ�������������
		Socket socket = new Socket("127.0.0.1", 10001);

		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());

		ps.println(file.getName());

		// 3.���ս��������Ѵ��ڣ�������ʾ��ֱ���˳�
		String isExist = br.readLine();

		if ("yes".equals(isExist)) {
			System.out.println("���ϴ����ļ��Ѵ��ڡ�");
			socket.close();
			return;
		}
		
		// 4.��������ڣ�����FileInputStream��ȡ�ļ���д��������
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
		System.out.println("��Ҫ�ϴ����ļ�·���ǣ�");

		while (true) {
			String str = sc.nextLine();
			File file = new File(str);
			if (!file.exists() || file.isDirectory()) {
				System.out.println("�ļ�·������ȷ������������");
			} else {
				return file;
			}
		}
	}
}
