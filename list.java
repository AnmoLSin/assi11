package javaapplication4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class list {
        ArrayList<File> list1=new ArrayList<>();
	File f1 = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\TCS\\src\\abc.txt");
                list() throws IOException
                {
		FileWriter w=new FileWriter(f1);
		BufferedWriter buf=new BufferedWriter(w);
                System.out.println("<------- Creating abc.txt having 2 paths -------->");
		String path;
                Scanner sc=new Scanner(System.in);
                for(int i=1;i<=2;i++)
                {
                    path=JOptionPane.showInputDialog("Path "+i+" :"+" ");
                    buf.write(path);
                    buf.newLine();
                }
		buf.close();
                createcsv();
	}
	
        public void createcsv() throws IOException
	{
		FileReader r=new FileReader(f1);
		BufferedReader bufr=new BufferedReader(r);
		String path=bufr.readLine();
		while(path!=null)
		{
			File folder=new File(path);
			checking(folder);
			path=bufr.readLine();
		}
		bufr.close();
                finalinfo();
	}
        
	public void checking(File folder)
	{
		File files[]=folder.listFiles();
		if(files==null)
			return;
		for(File check:files)
		{
			if(check.isDirectory())
			{
				checking(check);
			}
			else
			{
				list1.add(check);
			}
		}	
	}
	
	
	public void finalinfo() throws IOException
	{
		File f2=new File("E:\\f.csv");
		FileWriter fw=new FileWriter(f2);
		BufferedWriter bufw=new BufferedWriter(fw);
		for(File files:list1)
		{
			bufw.write("File: "+files.getName()+","+"Path: "+files.getPath());
			bufw.newLine();
		}
                JOptionPane.showMessageDialog(null,"Succesfully written to csv file.");
		bufw.close();
	}
	
	public static void main(String[] args) throws IOException {   
            list p=new list();
	}
}