import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



//import java.awt.*;

/**
 * Created by Ω≈¡ﬂ»∆ on 2015-09-11.
 */

public class Main extends Application {

    private AnchorPane anchorPane;
    private BorderPane root;
    private Stage stage;
    private Scene scene;



    public static void main(String[] args) {
            launch(args);
        }


    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Movie");
      //  Group root = new Group();



        System.out.println(System.getProperty("user.dir"));

        Media media = new Media("file:////Users/Joongji/IdeaProjects/woiefjo/src/Vid/Rain.mp4");
        MediaPlayer player = new MediaPlayer(media);
        MediaView view = new MediaView(player);


        root = new BorderPane();
        scene = new Scene(root, 1300, 700); //width and height of application
        stage.setScene(scene);
        stage.setTitle("Joongji");  //text for the title bar of the window

        Text title = new Text("This is a Lecture~") ;
        anchorPane = new AnchorPane();
        root.setCenter(anchorPane);

        Image image = new Image("/Img/Rain.jpg");
        ImageView vidImage = new ImageView(image);
        Image image2 = new Image("/Img/Rain.jpg");
        ImageView vidImage2 = new ImageView(image2);


        HBox hbox = new HBox();
        hbox.getChildren().addAll(vidImage,vidImage2);
        hbox.setSpacing(100);
        anchorPane.getChildren().addAll(title,hbox);

        stage.show();

     /* final VBox vBox = new VBox();
        final Slider slider = new Slider();
        vBox.getChildren().add(slider);



        root.getChildren().add(view);
        root.getChildren().add(vBox);
        int s = media.getWidth();
        int q = media.getHeight();
        Scene scene = new Scene(root, s, q, Color.BLACK);
        stage.setScene(scene);
        stage.show();

        player.play();
        player.setOnReady(new Runnable() {
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();

                stage.setMinWidth(w);
                stage.setMinHeight(h);

                vBox.setMinSize(w, 10);
                vBox.setTranslateY(h - 10);

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
        });*/


    }
}
