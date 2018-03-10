import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class TheFuinder {

    public static void main(String[] args) throws Exception{


        Scanner sc = new Scanner(System.in);
        String webpage = sc.next();
        URL url = new URL(webpage);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        Pattern pattern = Pattern.compile("\\w+");




        HashSet<String> vocabulary = new HashSet<>(Arrays.asList("red", "orange", "yellow", "green", "blue", "purple", "brown", "white", "black"));
        String inputLine;
        BufferedWriter out = new BufferedWriter(new FileWriter("answer.out"));
        while ((inputLine = in.readLine()) != null) {
            Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find()) {
                if (vocabulary.contains(matcher.group())){
                    out.write(matcher.group());
                    out.newLine();
                }
            }
        }
        in.close();
    }



    public static void wordSearch(String text, HashSet<String> voc, BufferedWriter output) throws IOException {
        String[] words = text.split(" ");
        for (int i=0; i<words.length; i++) {
            if (voc.contains(words[i])){
                output.write(words[i]);
                output.newLine();
            }
        }
    }

    }
