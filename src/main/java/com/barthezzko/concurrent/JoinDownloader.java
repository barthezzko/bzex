package com.barthezzko.concurrent;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.NoSuchAlgorithmException;

import com.barthezzko.common.FileHashChecker;

public class JoinDownloader {

	public static final String URL = "";

	public static void main(String[] args) {
		Runnable downloader = new Runnable() {
			public void run() {
				URL website;
				try {
					website = new URL("http://example.org/");
					ReadableByteChannel rbc;
					try {
						rbc = Channels.newChannel(website.openStream());
						FileOutputStream fos;
						try {
							fos = new FileOutputStream("result.file");
							try {
								fos.getChannel().transferFrom(rbc, 0,
										Long.MAX_VALUE);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("DOWNLOADED");
			}
		};
		final Thread down = new Thread(downloader);
		down.start();
		Runnable hashCounter = new Runnable() {
			public void run() {
				try {
					System.out.println("JOIN");
					down.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					System.out.println(FileHashChecker.calcSha1("result.file"));
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		
		Thread checker = new Thread(hashCounter);
		checker.start();
	}

}
