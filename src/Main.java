import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


//import java.awt.*;

/**
 * Created by Ω≈¡ﬂ»∆ on 2015-09-11.
 */

public class Main extends Application {

//Stage stage;
private Stage stage;
    private Scene scene;
    private BorderPane root;
    private AnchorPane anchorPane;
    private int btPress;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("Movie");
        //
        stage.setScene(displayMain());
        stage.setTitle("Math Lecture");  //text for the title bar of the window


        System.out.println(System.getProperty("user.dir"));

stage.show();
    }

    public Scene displayMain() {


        stage = new Stage(); // was not here before
        root = new BorderPane();
        scene = new Scene(root, 1400, 900); //width and height of application

        Text title = new Text("This is a Lecture~");
        anchorPane = new AnchorPane();
        root.setCenter(anchorPane);

        Image image = new Image("file:////Users/Joongji/IdeaProjects/woiefjo/out/production/woiefjo/Vid/1.jpg");
        ImageView vidImage = new ImageView(image);
        vidImage.setFitHeight(300);
        vidImage.setFitWidth(300);
        Image image2 = new Image("file:////Users/Joongji/IdeaProjects/woiefjo/out/production/woiefjo/Vid/2.jpg");
        ImageView vidImage2 = new ImageView(image2);
        vidImage2.setFitHeight(300);
        vidImage2.setFitWidth(300);


        Text t = new Text();

        t.setText("Math Lecture");
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        t.setFill(Color.RED);


        Button button = new Button("Lecture 1");
        Button button2 = new Button("Lecture 2");

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.setScene(displayVideo("1.mp4"));
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                stage.setScene(displayVideo("2.mp4"));
            }
        });

        // button.setMaxWidth(Double.MAX_VALUE);
        //button2.setMaxWidth(Double.MAX_VALUE);


        /*button.setLayoutX(250);
        button.setLayoutY(800);
        button2.setLayoutX(1400 - 250);
        button2.setLayoutY(800);
*/


        HBox hBox2 = new HBox();
        hBox2.setSpacing(500);
        hBox2.getChildren().addAll(button, button2);

        Button bt1 = new Button("Questions");
        Button bt2 = new Button("Questions");

        bt1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               question1();
btPress=1;
                //Need to make questions appear;
            }
        });
        bt2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //Need to make questions appear
                btPress=2;
            }
        });

        HBox hbox4 = new HBox();
        hbox4.setSpacing(500);
        hbox4.getChildren().addAll(bt1, bt2);


        HBox hbox3 = new HBox();


        hbox3.getChildren().addAll(t);
        hbox3.setAlignment(Pos.CENTER);

       /* GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        GridPane gridpane = new GridPane();
        Button button = new Button();
        GridPane.setRowIndex(button, 1);
        GridPane.setColumnIndex(button, 2);
        gridpane.setRowIndex(button,1);
        gridpane.setColumnIndex(button,3);
*/


        HBox hbox = new HBox();
        hbox.getChildren().addAll(vidImage, vidImage2);
        hbox.setSpacing(100);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hbox3, hbox, hBox2, hbox4);
        vBox.setSpacing(100);

        anchorPane.getChildren().addAll(title, vBox);


        // Scene scene = new Scene(grid, 300, 275);

        stage.show();

        return scene;


    }

    public Scene displayVideo(String videoType) {

        final VBox vBox2 = new VBox();
        final Slider slider = new Slider();
        Media media = new Media("file:////Users/Joongji/IdeaProjects/woiefjo/src/Vid/" + videoType);
        MediaPlayer player = new MediaPlayer(media);
        MediaView view = new MediaView(player);
        Group root = new Group();
        Button button = new Button("Exit");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                stage.setScene(displayMain());
            }
        });

        vBox2.getChildren().add(slider);
        vBox2.getChildren().add(button);


        root.getChildren().add(view);
        root.getChildren().add(vBox2);
        int s = media.getWidth();
        int q = media.getHeight();
        Scene scene = new Scene(root, 700, 400  , Color.BLACK);
        //      stage.setScene(scene);
        //      stage.show();

        player.play();
        player.setOnReady(new Runnable() {
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();

                //  stage.setMinWidth(w);
                //stage.setMinHeight(h);

                vBox2.setMinSize(w, 10);
                vBox2.setTranslateY(h - 10);

                slider.setMin(0);
                slider.setValue(0);
                slider.setMax(player.getTotalDuration().toSeconds());
            }
        });
        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration current) {
                slider.setValue(current.toSeconds());
            }
        });
        slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                player.seek(Duration.seconds(slider.getValue()));

            }
        });
        return scene;



    }

    public void question1() {
        int questionNum1 = (int) (Math.random() * 2) + 1;
        int questionNum2 = (int) (Math.random() * 2) + 3;
        int questionNum3 = (int) (Math.random() * 2) + 5;
        int questionNum4 = (int) (Math.random() * 2) + 7;
        int questionNum5 = (int) (Math.random() * 2) + 9;

        List<String> content = new ArrayList<String>();
        File file = new File(Main.class.getResource("file:////Users/Joongji/IdeaProjects/woiefjo/src/Questions" + btPress + "/Q.rtf").toString());


        int count = 1;         // want to add counter



        Text q1 = new Text();
        q1.setFont(new Font(20));
        q1.setWrappingWidth(200);
        q1.setTextAlignment(TextAlignment.JUSTIFY);
        q1.setText("file:////Users/Joongji/IdeaProjects/woiefjo/src/Questions1/" + questionNum1 + "Q.rtf"); //maybe questionNum"num"
        Text a1 = new Text();
        a1.setFont(new Font(20));
        a1.setTextAlignment(TextAlignment.JUSTIFY);
        a1.setText("file:////Users/Joongji/IdeaProjects/woiefjo/src/Questions1/" + questionNum1 + "1.rtf");
        Text b1 = new Text();
        b1.setFont(new Font(20));
        b1.setTextAlignment(TextAlignment.JUSTIFY);
        b1.setText("file:////Users/Joongji/IdeaProjects/woiefjo/src/Questions1/" + questionNum1 + "2.rtf");
        Text c1 = new Text();
        c1.setFont(new Font(20));
        c1.setTextAlignment(TextAlignment.JUSTIFY);
        c1.setText("file:////Users/Joongji/IdeaProjects/woiefjo/src/Questions1/" + questionNum1 + "3.rtf");

        Text q2 = new Text();
        q2.setFont(new Font(20));
        q2.setTextAlignment(TextAlignment.JUSTIFY);
        q2.setText("file:////Users/Joongji/IdeaProjects/woiefjo/src/Questions1/" + questionNum2 + "Q.rtf");
        Text a2 = new Text();
        a2.setFont(new Font(20));
        a2.setTextAlignment(TextAlignment.JUSTIFY);
        a2.setText("file:////Users/Joongji/IdeaProjects/woiefjo/src/Questions1/" + questionNum2 + "1.rtf");
        Text b2 = new Text();
        b2.setFont(new Font(20));
        b2.setTextAlignment(TextAlignment.JUSTIFY);
        b2.setText("file:////Users/Joongji/IdeaProjects/woiefjo/src/Questions1/" + questionNum2 + "2.rtf");
        Text c2 = new Text();
        c2.setFont(new Font(20));
        c2.setTextAlignment(TextAlignment.JUSTIFY);
        c2.setText("file:////Users/Joongji/IdeaProjects/woiefjo/src/Questions1/" + questionNum2 + "3.rtf");


        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button buttonNext = new Button();

        HBox hbox = new HBox();
        //make it so that, if it is question1, display q1, if question2, display q2
        hbox.getChildren().addAll(q1);
        hbox.setSpacing(100);
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(a1,b1,c1);
        // need to make it display a1,b1,c1 for question1, a2,b2,c3 for question2
        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(button1, button2, button3, buttonNext);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hbox, hBox2, hBox3);
        vBox.setSpacing(100);

        anchorPane.getChildren().addAll(vBox);

    }
}
