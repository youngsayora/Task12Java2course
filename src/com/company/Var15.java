package com.company;
import java.io.*;
import java.util.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.*;
import java.nio.file.Paths;




public class Var15 {

     int deepestLevel = 0;

     String deepestItem = "";
         public String findDeepestItem(File folder) {
            int currentLevel = 0;


            String result = "";
            File[] folderEntries = folder.listFiles();
            for (File entry : folderEntries) {
                currentLevel = countMatches(entry.getPath(), "\\");
                if (entry.isDirectory()) {
                    findDeepestItem(entry);
                    if (deepestLevel < currentLevel) {
                        deepestLevel = currentLevel;
                        deepestItem = entry.getPath();
                    }
                    continue;
                } else {
                    if (deepestLevel < currentLevel) {
                        deepestLevel = currentLevel;
                        deepestItem = entry.getPath();
                    }
                }
            }
            result = "Глубина: " + String.valueOf(deepestLevel-2) + " Путь: " + deepestItem;
            return result;
        }



    ArrayList<String> answerList = new ArrayList<>();
     public ArrayList<String> findFilterItem(File folder , String mask) throws IOException {
        int currentLevel = 0;






        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            currentLevel = countMatches(entry.getPath(), "\\");
            if(entry.getPath().matches(mask)) {
                answerList.add(entry.getPath());
            }


            if (entry.isDirectory()) {
                findFilterItem(entry,mask);



                if (deepestLevel < currentLevel) {
                    deepestLevel = currentLevel;
                    if(entry.getPath().matches(mask)) {
                        answerList.add(entry.getPath());
                    }




                }
                continue;
            } else {



                if (deepestLevel < currentLevel) {
                    deepestLevel = currentLevel;
                    if(entry.getPath().matches(mask)) {
                        answerList.add(entry.getPath());
                    }



                }
            }
        }



        return answerList;
    }

        private static int countMatches(String path, String string) {
            int number = 0;
            String[] array = path.split("");
            for (int i = 0; i < path.length(); i++) {
                if (string.contentEquals(array[i])) {
                    number++;
                }
            }
            return number;
        }




}
