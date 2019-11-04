import java.io.*;
import java.util.*;

public class DuplicateCounter {

    HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
    FileWriter outFS = null;

    public void count(String dataFile) throws FileNotFoundException {
        String wordRead = null;
        Scanner in = new Scanner(new File(dataFile));

        while (in.hasNext()) {
            wordRead = in.next();
            if (!wordCounter.containsKey(wordRead)) {
                wordCounter.put(wordRead, 1);
            } else {
                int counter = wordCounter.get(wordRead);
                wordCounter.put(wordRead, counter + 1);
            }

        }
        in.close();
    }

    public void write(String outputFile) throws IOException {
        File output;
        output = new File(outputFile);

        if (output.exists()) {

            outFS = new FileWriter(output, false);

            for (String key : wordCounter.keySet()) {
                outFS.write(key + ": " + wordCounter.get(key) + "\n");
            }
            outFS.close();
        } else {
            output.createNewFile();
            outFS = new FileWriter(outputFile);

            for (String key : wordCounter.keySet()) {
                outFS.write(key + ": " + wordCounter.get(key) + "\n");
            }
        }
        outFS.close();
    }
}
