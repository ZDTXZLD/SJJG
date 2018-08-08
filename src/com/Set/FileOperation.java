package com.Set;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {
    //读取文件名称为filename中的内容,将其中包含的所有词语放进words中
    public static boolean readFile(String filename, ArrayList<String> words) {
        if (filename == null || words == null) {
            System.out.println("filename is null or words is null");
            return false;
        }

        //文件读取
        Scanner scanner;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "u");
                scanner.useLocale(Locale.ENGLISH);
            } else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        //简单分词  一行一行读取
        if (scanner.hasNextLine()) {
             String contents = scanner.useDelimiter("\\A").next();
             int start = firstCharacterIndex(contents, 0);
             for(int i=start+1;i<=contents.length();)
                 if(i==contents.length()||!Character.isLetter(contents.charAt(i))){
                 String word=contents.substring(start,i);
                 words.add(word);  //存放了所有单词
                 start=firstCharacterIndex(contents,i);
                 i=start+1;
                 }else
                     i++;
        }
        return  true;
    }

    private static int firstCharacterIndex(String s, int start) {
       for(int i=start;i<s.length();i++)
           if(Character.isLetter(s.charAt(i)))
                   return  i;
        return s.length();
    }

}