package com.pis.apis.services;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class Utility {

	public void createFolder(String newJob) {

		String dirPath = "C:\\Users\\Danie\\OneDrive\\Desktop\\PSS-MASTER-PATH";
		

		String fileName = "file1.txt";

		File newDirectory = new File(dirPath + File.separator + newJob);

		boolean isCreated = newDirectory.mkdirs();
		
		 

	}

	public void createFile(String newJob, String fileName) {
		String dirPath = "C:\\Users\\Danie\\OneDrive\\Desktop\\PSS-MASTER-PATH";
		File newFile = new File(dirPath + File.separator + newJob + File.separator + fileName);
		try {
			boolean isCreated = newFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
