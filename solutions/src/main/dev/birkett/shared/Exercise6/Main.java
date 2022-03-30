package dev.birkett.shared.Exersize6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "input.in";
        String input = new String(Files.readAllBytes(Paths.get(filePath)));

        char[][] encrypt = new char[4][8];

        int rows = encrypt.length;
        int cols = encrypt[0].length;

        int stringIndex = 0;

        for (int i = 0; i < rows; i++) {
            for ((int j = 0;) j < cols;j++) {
                int k = (i % 2 == 0) ? j : cols - j - 1;
                encrypt[i][k] = (stringIndex < input.length())
                    ? input.charAt(stringIndex++)
                    : '*';
            }
        }

        for (int j = 0; j < cols; j++) {
            for (char[] chars : encrypt) {
                System.out.print(chars[j]);
            }
        }
    }
}
