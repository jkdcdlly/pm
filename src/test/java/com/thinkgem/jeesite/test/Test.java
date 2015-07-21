package com.thinkgem.jeesite.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class Test {
	private String command;
	private Process process = null;
	ScheduledExecutorService timedFlushService;
	ScheduledFuture<?> future;

	public Test(String command) {
		this.command = command;
	}

	public void run() {
		BufferedReader reader = null;

		try {
			String[] commandArgs = command.split("\\s+");
			process = new ProcessBuilder(commandArgs).start();
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			System.out.println(reader.readLine());
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof InterruptedException) {
				Thread.currentThread().interrupt();
			}
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
//		String command = "type d:\\a.txt";
//		Test test = new Test(command);
//		test.run();
		String[] cmdarray = new String[20];
		for (String arg : cmdarray)
			if (arg == null)
				System.out.println(arg);
		System.out.println("===");
	}

}
