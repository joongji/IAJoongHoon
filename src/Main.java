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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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

        Image image = new Image("file:///Users/Joongji/IdeaProjects/woiefjo/src/Vid/1.jpg");
        ImageView vidImage = new ImageView(image);
        vidImage.setFitHeight(300);
        vidImage.setFitWidth(300);
        Image image2 = new Image("file:////Users/Joongji/IdeaProjects/woiefjo/src/Vid/2.jpg");
        ImageView vidImage2 = new ImageView(image2);
        vidImage2.setFitHeight(300);
        vidImage2.setFitWidth(300);


        Text t = new Text();

        t.setText("Math Lecture");
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        t.setFill(Color.RED);


        Button button = new Button("Basics");
        Button button2 = new Button("Trigonometric equations and identities");

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

        Button bt1 = new Button("Questions for Lecture 1");
        Button bt2 = new Button("Questions for Lecture 2");

        bt1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.setScene(displayQuestion("1"));
                btPress = 1;
                //Need to make questions appear;
            }
        });
        bt2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.setScene(displayQuestion("2"));
                btPress = 1;
                //Need to make questions appear;
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
        title.setTextAlignment(TextAlignment.CENTER);

        anchorPane.getChildren().addAll(title, vBox);


        // Scene scene = new Scene(grid, 300, 275);

        stage.show();

        return scene;


    }
    public Scene displayQuestion(String questions){
        int choice = new Integer(questions);

        int two = new Integer(2);

        Button save = new Button("Save Answer");
        Button n1 = new Button("Q1");
        Button n2 = new Button("Q2");
        Button n3 = new Button("Q3");
        Button n4 = new Button("Q4");
        Button n5 = new Button("Q5");
        Button n6 = new Button("Q6");
        Button n7 = new Button("Q7");
        Button n8 = new Button("Q8");
        Button n9 = new Button("Q9");
        Button n10 = new Button("Q10");
        Button exit = new Button("Exit to Main");

        Text q = new Text("Time to Quiz!");



        Group root = new Group();


        q.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        q.setFill(Color.GOLD);

        Text a = new Text();

        a.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        a.setFill(Color.GOLD);
        Text b = new Text();

        b.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        b.setFill(Color.GOLD);
        Text c = new Text();

        c.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        c.setFill(Color.GOLD);

        Image correct = new Image("file:///Users/Joongji/IdeaProjects/woiefjo/src/Vid/Correct.png");
        ImageView cor = new ImageView(correct);
        cor.setFitHeight(300);
        cor.setFitWidth(300);
        Image wrong = new Image("file:///Users/Joongji/IdeaProjects/woiefjo/src/Vid/Wrong.png");
        ImageView wron = new ImageView(wrong);
        wron.setFitHeight(300);
        wron.setFitWidth(300);
        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("1");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        rb1.setTextFill(Color.WHITE);

        RadioButton rb2 = new RadioButton("2");
        rb2.setToggleGroup(group);
        rb2.setTextFill(Color.WHITE);

        RadioButton rb3 = new RadioButton("3");
        rb3.setToggleGroup(group);
        rb3.setTextFill(Color.WHITE);

        //String chosenAnswer = group.getSelectedToggle().toString().substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);


        VBox vBox = new VBox();
        VBox vBox2 = new VBox();
        HBox hBoxqn = new HBox();
        HBox hboxq = new HBox();
        HBox hBoxa = new HBox();
        HBox hBoxrb = new HBox();
        HBox hBoxImg = new HBox();
        HBox hBoxExit = new HBox();
        hBoxExit.getChildren().addAll(exit);
          hBoxa.getChildren().addAll(save);
        hBoxqn.getChildren().addAll(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10);
        hboxq.getChildren().addAll(vBox2);
        hBoxrb.getChildren().addAll(rb1, rb2, rb3);

        vBox.getChildren().addAll(hboxq, hBoxqn,hBoxExit);
        vBox2.getChildren().addAll(q, a, b, c, hBoxrb, hBoxa, hBoxImg);
        vBox.setAlignment(Pos.CENTER);
        root.getChildren().add(vBox);
            Scene scene = new Scene(root, 1400, 900  , Color.BLACK);
        int one = new Integer(1);
        if (choice==one){
            n1.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(0);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });
            n2.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(1);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });
            n3.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(2);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });
            n4.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(3);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });
            n5.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(4);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });
            n5.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(4);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });
            n6.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(5);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });
            n7.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(6);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });
            n8.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(7);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });
            n9.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(8);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });
            n10.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question question = new Question(9);
                    q.setText(question.getQuestionText());
                    a.setText(question.getQuestionChoice1());
                    b.setText(question.getQuestionChoice2());
                    c.setText(question.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer) == question.getCorrect()) {

                                hBoxImg.getChildren().addAll(cor);
                            } else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }

                    });
                }
            });


        }else {
            n1.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    hBoxImg.getChildren().clear();
                    Question2 question2 = new Question2(0);
                    q.setText(question2.getQuestionText());
                    a.setText(question2.getQuestionChoice1());
                    b.setText(question2.getQuestionChoice2());
                    c.setText(question2.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer)==question2.getCorrect()){

                                hBoxImg.getChildren().addAll(cor);
                            }else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }


                    });
                }

                //Need to make questions appear;

            });

            n2.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    hBoxImg.getChildren().clear();
                    Question2 question2 = new Question2(1);
                    q.setText(question2.getQuestionText());
                    a.setText(question2.getQuestionChoice1());
                    b.setText(question2.getQuestionChoice2());
                    c.setText(question2.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer)==question2.getCorrect()){

                                hBoxImg.getChildren().addAll(cor);
                            }else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }


                    });
                }

                //Need to make questions appear;

            });
            n3.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question2 question2 = new Question2(2);
                    q.setText(question2.getQuestionText());
                    a.setText(question2.getQuestionChoice1());
                    b.setText(question2.getQuestionChoice2());
                    c.setText(question2.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer)==question2.getCorrect()){

                                hBoxImg.getChildren().addAll(cor);
                            }else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }


                    });
                }

                //Need to make questions appear;

            });
            n4.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question2 question2 = new Question2(3);
                    q.setText(question2.getQuestionText());
                    a.setText(question2.getQuestionChoice1());
                    b.setText(question2.getQuestionChoice2());
                    c.setText(question2.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer)==question2.getCorrect()){

                                hBoxImg.getChildren().addAll(cor);
                            }else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }


                    });


                    //Need to make questions appear;
                }
            });
            n5.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question2 question2 = new Question2(4);
                    q.setText(question2.getQuestionText());
                    a.setText(question2.getQuestionChoice1());
                    b.setText(question2.getQuestionChoice2());
                    c.setText(question2.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer)==question2.getCorrect()){

                                hBoxImg.getChildren().addAll(cor);
                            }else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }


                    });


                    //Need to make questions appear;
                }
            });
            n6.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question2 question2 = new Question2(5);
                    q.setText(question2.getQuestionText());
                    a.setText(question2.getQuestionChoice1());
                    b.setText(question2.getQuestionChoice2());
                    c.setText(question2.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer)==question2.getCorrect()){

                                hBoxImg.getChildren().addAll(cor);
                            }else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }


                    });


                    //Need to make questions appear;
                }
            });
            n7.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question2 question2 = new Question2(6);
                    q.setText(question2.getQuestionText());
                    a.setText(question2.getQuestionChoice1());
                    b.setText(question2.getQuestionChoice2());
                    c.setText(question2.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer)==question2.getCorrect()){

                                hBoxImg.getChildren().addAll(cor);
                            }else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }


                    });
                }

                //Need to make questions appear;

            });
            n8.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question2 question2 = new Question2(7);
                    q.setText(question2.getQuestionText());
                    a.setText(question2.getQuestionChoice1());
                    b.setText(question2.getQuestionChoice2());
                    c.setText(question2.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer)==question2.getCorrect()){

                                hBoxImg.getChildren().addAll(cor);
                            }else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }


                    });
                }

                //Need to make questions appear;

            });
            n9.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question2 question2 = new Question2(8);
                    q.setText(question2.getQuestionText());
                    a.setText(question2.getQuestionChoice1());
                    b.setText(question2.getQuestionChoice2());
                    c.setText(question2.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer)==question2.getCorrect()){

                                hBoxImg.getChildren().addAll(cor);
                            }else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }


                    });
                }

                //Need to make questions appear;

            });
            n10.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    hBoxImg.getChildren().clear();
                    Question2 question2 = new Question2(9);
                    q.setText(question2.getQuestionText());
                    a.setText(question2.getQuestionChoice1());
                    b.setText(question2.getQuestionChoice2());
                    c.setText(question2.getQuestionChoice3());

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String chosenAnswer = group.getSelectedToggle().toString().
                                    substring(group.getSelectedToggle().toString().indexOf("'") + 1, group.getSelectedToggle().toString().length() - 1);

                            if (Integer.parseInt(chosenAnswer)==question2.getCorrect()){

                                hBoxImg.getChildren().addAll(cor);
                            }else {
                                hBoxImg.getChildren().add(wron);
                            }

                        }


                    });
                }

                //Need to make questions appear;

            });
        }
        exit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                stage.setScene(displayMain());
            }
        });


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


}
