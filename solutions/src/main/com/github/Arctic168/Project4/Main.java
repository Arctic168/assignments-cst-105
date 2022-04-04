package com.github.Arctic168.Project4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("input.in");
        Scanner reader = new Scanner(file);

        double largest = Double.MIN_VALUE;
        double smallest = Double.MAX_VALUE;
        double average = 0.0;
        double total = 0.0;
        int count = 0;
        double contribution;

        while (total < 1_000_000) {
            if (reader.hasNextLine()) {
                contribution = reader.nextDouble();
                total += contribution;
                count += 1;
                if (smallest > contribution)
                    smallest = contribution;

                if (largest < contribution)
                    largest = contribution;
            }
        }

        reader.close();

        if (count > 0)
            average = total / count;

        FileWriter fileWriter = new FileWriter("result.out");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("Contribution Results");
        printWriter.printf("The largest contribution %.2f\n", largest);
        printWriter.printf("The smallest contribution %.2f\n", smallest);
        printWriter.printf("The average contribution %.2f\n", average);
        printWriter.printf("The total number %d\n", count);
        printWriter.printf("The amount accepted %.2f\n", total);

        printWriter.close();
        fileWriter.close();
    }
}
