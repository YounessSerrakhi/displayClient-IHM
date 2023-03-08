package files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class init {
    public static void main(String[] args) {



    try {
        FileWriter writer = new FileWriter("C:\\Users\\asus\\Desktop\\file.txt");
        writer.write("1,youness,18000\n" +
                "3,mohammed,14500\n" +
                "4,asame,7900\n" +
                "5,ali,5000\n" +
                "6,imane,9700\n" +
                "7,omar,11000");
        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
        FileReader reader = new FileReader("C:\\Users\\asus\\Desktop\\file.txt");
        int data = reader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }


                try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asus\\Desktop\\file.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }
}
