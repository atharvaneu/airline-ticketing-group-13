package edu.neu.csye7374.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler implements FileHandlerAPI {
    /*
     * implementation of FileHandlerAPI that stores and loads data locally in .csv file format
     */
    @Override
    public File getFile(String fileName) {
        File csvFile = new File(fileName);
        try {
            boolean isCreated = csvFile.createNewFile();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return csvFile;
    }

    @Override
    public List<String> readFile(String fileName) {
        List<String> fileContent = new ArrayList<>();
        if (getFile(fileName) != null) {
            try {
                FileReader reader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    fileContent.add(line);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return fileContent;
    }

    public static FileWriter initializeFileWriter(String fileName) {
        try {
            return new FileWriter(fileName);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

    public void addLineData(List<String> dataLines, String fileName) {
        FileWriter writer = initializeFileWriter(fileName);
        if (writer != null) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                for (String line : dataLines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
