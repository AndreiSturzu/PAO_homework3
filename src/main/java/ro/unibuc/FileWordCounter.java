package ro.unibuc;

import java.util.Collections;
import java.util.List;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
    TODO:
    scrieti o clasa java care sa returneze toate cuvinetele de lungime > n dintr-un fisier text
    Lungimea n trebuie introdusa de la tastatura.

    In plus fata de lungime, care trebuie introdusa de la tastatura, putem filtra si dupa alte conditii(vedeti testele)
 */
public class FileWordCounter {
    //HINT: you could make one generic method to reuse for all three methods above
    //HINT2: think about functional interfaces, one that verifies things in particular

    public static List<String> readFileInList(String fileName)
    {
        List<String> lines = Collections.emptyList();
        try
        {
            lines  = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

            return lines;
    }

    public static List<String> getWordsOfSizeN(String fileName, Predicate<String> sizeOfWord) {
        List<String> lines = FileWordCounter.readFileInList(fileName);
        List<String> result = new ArrayList<>(Collections.emptyList());

        for (String row : (Iterable<String>) lines) {
            List<String> words = Arrays.asList(row.replaceAll("\\p{Punct}", "").split(" "));
            result.addAll(words.stream().filter(sizeOfWord).collect(Collectors.toList()));
        }

        for(String w: result) {
            System.out.println(w);
        }
        return result;
    }

    public List<String> getSizeK(String fileName, int k) {
        List<String> lines = FileWordCounter.readFileInList(fileName);
        List<String> result = new ArrayList<>(Collections.emptyList());

        for (String row : (Iterable<String>) lines) {
            List<String> words = Arrays.asList(row.replaceAll("\\p{Punct}", "").split(" "));
            result.addAll(words.stream().filter(w -> w.length() == k).collect(Collectors.toList()));
        }

        for(String w: result) {
            System.out.println(w);
        }

        return result;
    }


    public List<String> getSizeOne(String fileName) {
        //TODO: add code here
        return FileWordCounter.getWordsOfSizeN(fileName, word -> word.length() == 1);
    }

    public List<String> getSizeLessThan3(String fileName) {
        //TODO: add code here
        return FileWordCounter.getWordsOfSizeN(fileName, word -> word.length() < 3);
    }

    public List<String> getSizeLessThanK(String fileName, int k) {
        //TODO: add code here
        return FileWordCounter.getWordsOfSizeN(fileName, word -> word.length() < k);
    }

    public List<String> countWordAppearances(String fileName, String word) {
        //TODO: add code here

        List<String> lines = FileWordCounter.readFileInList(fileName);
        List<String> words = new ArrayList<>(Collections.emptyList());

        for (String row : (Iterable<String>) lines) {
            words.addAll(Arrays.asList(row.replaceAll("\\p{Punct}", " ").split(" ")));
        }

        return words.stream().filter(w -> Objects.equals(w, word)).collect(Collectors.toList());
    }

}
