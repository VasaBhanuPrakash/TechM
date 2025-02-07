package org.bhanu;
import java.io.File;
import java.util.*;

public class GetFile {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        File file = new File("C:\\Users\\HP");
        System.out.print("Enter file name to search: ");
        String s = sc.next();
        System.out.println("File to be chosen is:");
        
        if (file.exists()) {
            if (file.isDirectory()) {
                boolean found = false;
                for (String i : file.list()) {
                	 System.out.println("File found: " + i);
                     int dotIndex = i.lastIndexOf('.');
                     if (dotIndex != -1 && dotIndex < i.length() - 1) {
                         System.out.println("File extension: " + i.substring(dotIndex));
                     } else {
                         System.out.println("No extension found");
                     }
                     found = true;
                     break; 
                }
                if (!found) {
                    System.out.println("File not found");
                }
            } else {
                System.out.println("Given path is not a directory");
            }
        } else {
            System.out.println("File doesn't exist");
        }
    }
}
