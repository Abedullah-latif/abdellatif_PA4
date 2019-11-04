import java.io.*;
import java.util.*;

public class DuplicateRemover {

        Set<String> uniqueWords;
        FileWriter outFS = null;

        public DuplicateRemover () {

            uniqueWords = new HashSet<>();
        }

        public void remove(String dataFile) throws FileNotFoundException {

            String wordRead = null;
            Scanner in = new Scanner(new File(dataFile));

            while (in.hasNext()) {
                    wordRead = in.next();
                    uniqueWords.add(wordRead);
            }

            in.close();


        }

        public void write(String outputFile) throws IOException {

            File output;

            output = new File(outputFile);

            if (output.exists()) {

                outFS = new FileWriter(output,false);
                Iterator ITR = uniqueWords.iterator();

                while(ITR.hasNext()) {
                    String word = (String) ITR.next();
                    outFS.write(word + "\n");
                }
                outFS.close();
            } else {
                output.createNewFile();
                outFS = new FileWriter(outputFile);
                Iterator ITR = uniqueWords.iterator();

                while(ITR.hasNext()) {
                    String word = (String) ITR.next();
                    outFS.write(word + "\n");
                }
                outFS.close();
            }
     }
}

