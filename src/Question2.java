import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Joongji on 3/11/16.
 */
public class Question2 {

    public String questionText;
    public String questionChoice1;
    public String questionChoice2;
    public String questionChoice3;
    public int correct;

    public Question2(int i){
        List<String> boji = null;
        try {
            boji = Files.readAllLines(Paths.get("/Users/Joongji/IdeaProjects/woiefjo/out/production/woiefjo/Vid/2.txt"));
        } catch (IOException w) {
            w.printStackTrace();
            System.exit(0);
        }

        String[] hoongJoon = boji.get(i).split(",");
        questionText = hoongJoon[0];
        questionChoice1 = hoongJoon[1];
        questionChoice2 = hoongJoon[2];
        questionChoice3 = hoongJoon[3];
        correct = Integer.parseInt(hoongJoon[4].substring(1));


    }

    public int getCorrect() {
        return correct;
    }

    public String getQuestionText(){
        return questionText;
    }

    public String getQuestionChoice1() {
        return questionChoice1;
    }

    public String getQuestionChoice2() {
        return questionChoice2;
    }

    public String getQuestionChoice3() {
        return questionChoice3;
    }
}
