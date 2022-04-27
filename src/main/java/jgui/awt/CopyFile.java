package jgui.awt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fin;
		FileOutputStream fout;
		Scanner scanner = new Scanner(System.in);
		try{
			try{
				fin = new FileInputStream(scanner.nextLine());
				
			}catch(FileNotFoundException e){
				System.err.println("Error opening output file");
				return;
			}
			
			try{
				fout = new FileOutputStream(scanner.nextLine());
			}catch(FileNotFoundException e){
				e.printStackTrace();
				return;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.err.println("Usage:CopyFile from To");
			return;
		}
		int i;
		try{
			do{
				i = fin.read();
				if (i != -1){
					fout.write(i);
				}
			}while( i != -1);
		}catch(IOException e){
			System.out.println("FileError");
		}
		
		fin.close();
		fout.close();

	}

}
