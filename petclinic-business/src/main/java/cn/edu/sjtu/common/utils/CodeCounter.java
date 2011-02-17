package cn.edu.sjtu.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeCounter {

	private static int whiteLine = 0;
    private static int commentLine = 0;
    private static int normalLine = 0;
    private static boolean comment = false;
    
    public static void main(String[] args) {
        String filepath = "E:/MyResources/my-mse-project/branches/20101227_petclinic/petclinic-business/src/main/java";
        File directory = new File(filepath);
        recrusive(directory);
        System.out.println("whiteLine: " + whiteLine);
        System.out.println("commentLine: " + commentLine);
        System.out.println("normalLine: " + normalLine);
    }
    
    public static void recrusive(File rootFile) {
    	if (rootFile.isDirectory()) {
    		File[] files = rootFile.listFiles();
    		for (File f : files) {
    			recrusive(f);
            }
    	} else {
    		if (rootFile.getName().matches(".*\\.java$")) {
                fileToString(rootFile);
            }
    	}
    }
    
    public static void fileToString(File f) {
        try {
            
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                parse(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void parse(String line) {
        if (line.matches("[\\s]*")) {
            whiteLine ++;
        } else if (line.matches("^/\\*.*") && line.matches(".*\\*/$")) {
            commentLine ++;
        } else if (line.matches("^/\\*.*") && !line.matches(".*\\*/$")) {
            commentLine ++;
            comment = true;
        } else if (comment) {
            commentLine ++;
            if (line.matches(".*\\*/$") && !line.matches("^/\\*.*")) {
                comment = false;
            }
        } else if (line.matches("^//.*")) {
            commentLine ++;
        } else {
            normalLine ++;
        }
    }
	
}
