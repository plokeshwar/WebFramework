package com.overture.npc.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZipper {
	
	
	 static public String zipFolder(String basepath, String fileName, String browserName){
		fileName=browserName+"_"+fileName;
		 String srcFolder =basepath+"test-output/"+browserName+"/html";
		
		 String destZipFile=basepath+"/Results_"+fileName+".zip";
		 
		 System.out.println(" Started Zipping : "+destZipFile);
		 
		 ZipOutputStream zip = null;
		    FileOutputStream fileWriter = null;

		    try {
				fileWriter = new FileOutputStream(destZipFile);
			
		    zip = new ZipOutputStream(fileWriter);
		    
		    addFolderToZip("", srcFolder, zip);
		    zip.flush();
		    zip.close();
		 
		  System.out.println("File Zipping Done Successfully. :) ");
		    } catch (Exception e) {
				// TODO Auto-generated catch block
		    	System.out.println("File Zipping Failed. :( ");
		    	//e.printStackTrace();
			}
		  return "Results_"+fileName+".zip";  
	}

	 
	static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
    throws Exception {
  File folder = new File(srcFolder);

  for (String fileName : folder.list()) {
    if (path.equals("")) {
      addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
    } else {
      addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
    }
  }
  }
  
  static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
  throws Exception {

File folder = new File(srcFile);
if (folder.isDirectory()) {
  addFolderToZip(path, srcFile, zip);
} else {
  byte[] buf = new byte[1024];
  int len;
  FileInputStream in = new FileInputStream(srcFile);
  zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
  while ((len = in.read(buf)) > 0) {
    zip.write(buf, 0, len);
  }
}
}

}
