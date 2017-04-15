package com.overture.npc.methods;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileEditor {

	public void editor(String filePath, String txtFinder1, String txtReplace1, String txtFinder2, String txtReplace2){
        File f=new File(filePath);
        
        FileInputStream fs = null;
        InputStreamReader in = null;
        BufferedReader br = null;
        
        StringBuffer sb = new StringBuffer();
        
        String textinLine;
        
        try {
             fs = new FileInputStream(f);
             in = new InputStreamReader(fs);
             br = new BufferedReader(in);
            
            while(true)
            {
                textinLine=br.readLine();
                if(textinLine==null)
                    break;
                sb.append(textinLine);
            }
              String textToEdit1 = txtFinder1;
              int cnt1 = sb.indexOf(textToEdit1);
              sb.replace(cnt1,cnt1+textToEdit1.length(),txtReplace1);
              
              String textToEdit2 =txtFinder2;
              int cnt2 = sb.indexOf(textToEdit2);
              sb.replace(cnt2,cnt2+textToEdit2.length(),txtReplace2);

              fs.close();
              in.close();
              br.close();

            } catch (FileNotFoundException e) {
              e.printStackTrace();
            } catch (IOException e) {
              e.printStackTrace();
            }
            
            try{
                FileWriter fstream = new FileWriter(f);
                BufferedWriter outobj = new BufferedWriter(fstream);
                outobj.write(sb.toString());
                outobj.close();
                
            }catch (Exception e){
              System.err.println("Error: " + e.getMessage());
            }
    }

}
	

