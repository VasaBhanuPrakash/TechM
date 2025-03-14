package org.bhanu;
import java.io.File;
public class ListOfFiles {
	public static void main(String arg[]) {
		File file=new File("C:\\Users\\HP\\05-02-2025");
		if(file.exists() && file.isDirectory()) {
			for(String i:file.list()) {
				System.out.println(i);
			}
		}
	}
}
