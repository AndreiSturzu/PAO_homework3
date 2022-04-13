package ro.unibuc;

import java.util.List;
import java.util.Scanner;

public class WordCounting {
    public static void main(String[] args) {
        FileWordCounter fileWordCounter = new FileWordCounter();

        Scanner in = new Scanner(System.in);

        System.out.println("Entern word size: ");
        int k = in.nextInt();

        List<String> s1 = fileWordCounter.getSizeK("src/test/resources/poezie1.txt", k);
        List<String> s2 = fileWordCounter.getSizeLessThanK("src/test/resources/poezie1.txt", k);

    }
}
