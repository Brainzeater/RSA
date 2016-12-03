package exchanges.rsa;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class FileHelper {
    private FileWriter myFileWriter;
    private BufferedWriter myBufferedWriter;
    private FileReader myFileReader;
    private BufferedReader myBufferedReader;
    private Charset encoding = Charset.defaultCharset();

    public void writeFile(ArrayList<Character> charArray, String fileName) {
        try {
            myFileWriter = new FileWriter(fileName);
            myBufferedWriter = new BufferedWriter(myFileWriter);
            for (char c : charArray) {
                myBufferedWriter.write(c);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                myBufferedWriter.flush();
                myBufferedWriter.close();
                myFileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void writeFileInt(ArrayList<Integer> intArray, String fileName) {
        try {
            myFileWriter = new FileWriter(fileName);
            myBufferedWriter = new BufferedWriter(myFileWriter);
            for (int i : intArray) {
                myBufferedWriter.write(i);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                myBufferedWriter.flush();
                myBufferedWriter.close();
                myFileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public ArrayList<Character> readFile(String fileName) {
        ArrayList<Character> tempArray = new ArrayList<Character>();
        try {
            myFileReader = new FileReader(fileName);
            myBufferedReader = new BufferedReader(myFileReader);
            int c;
            while ((c = myFileReader.read()) != -1) {
                tempArray.add((char)c);
            }
            return tempArray;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            /*Сообщение об ошибке*/
        } finally {
            try {
                myBufferedReader.close();
                myFileReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }
}
