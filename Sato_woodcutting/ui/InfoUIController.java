package com.Gearsas.bots.Sato_woodcutting.ui;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.runemate.game.api.hybrid.util.calculations.CommonMath;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class InfoUIController implements Initializable {

    private final Sato_Woodcutting main;

    @FXML
    private Button Setup_btn;

    @FXML
    private Label timer;

    @FXML
    private Label currentTask;

    @FXML
    private LineChart dataChart;

    @FXML
    private Text totalwood;

    @FXML
    private Text woodph;
    @FXML
    private Text xpgained;
    @FXML
    private Text xpph;
    @FXML
    private Text lvltxt;
    @FXML
    private Text lvlperc;
    @FXML
    private Text Logslvlup;
    @FXML
    private Text xptolvltxt;
    @FXML
    private Text timetolvl;

    @FXML
    private Text plus;

    @FXML
    private ImageView woodimg;

    @FXML
    private ImageView statsImg;

    @FXML
    private ImageView SkillImg;

    @FXML
    private ProgressBar lvlProgress;
    XYChart.Series series = new XYChart.Series();

    int currenttime = -1;
    int count =0;
    int first = 0;
    int once = 0;
    double progress = 0;
    int htolvl= 0;
    int mtolvl= 0;
    int lvlup=0;

    public InfoUIController(Sato_Woodcutting main){
        this.main = main;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Setup_btn.setOnAction(onButtonClick());
    }

    public EventHandler<ActionEvent> onButtonClick() {
        return actionEvent -> {
            try {
                main.initialization = true;

                Platform.runLater(main::swapToSetupUI);
            } catch (Exception e){
                e.printStackTrace();
            }
        };
    }

    public void update(String time, String task, int xp, int lvl, int lvlp, int xptolvl){
        try {
                timer.setText(time);
                currentTask.setText(task);
                totalwood.setText("Logs choppped: " + main.totalwood);
                woodph.setText("Logs/hour: " + (int) CommonMath.rate(TimeUnit.HOURS, main.stopWatch.getRuntime(),main.totalwood));
                xpgained.setText("Xp gained: "+ xp);
                xpph.setText("xp/h: "+ (int) CommonMath.rate(TimeUnit.HOURS, main.stopWatch.getRuntime(),xp));
                if(main.startlvl < lvl) {
                    lvlup++;
                    main.startlvl++;
                }
                if(lvlup >0){
                    plus.setText("(+" + lvlup+ ")");
                }
                lvltxt.setText("Level " + lvl);
                lvlperc.setText(lvlp + "%");
                progress = lvlp;
                progress= progress/100;
                lvlProgress.setProgress(progress);
                xptolvltxt.setText("Xp to lvlup: "+xptolvl);
                if(xptolvl !=0 && xp !=0) {
                    htolvl = xptolvl / (int) CommonMath.rate(TimeUnit.HOURS, main.stopWatch.getRuntime(), xp);
                    mtolvl = (int) Math.ceil(xptolvl / (int) CommonMath.rate(TimeUnit.MINUTES, main.stopWatch.getRuntime(), xp) - htolvl*60);
                    if(mtolvl< 10)
                        timetolvl.setText("" + htolvl + ":0" +mtolvl);
                    else
                        timetolvl.setText("" + htolvl + ":" +mtolvl);

                }
                if(progress <= 0.2){
                    lvlProgress.setStyle("-fx-accent: #FF0000;");
                } else if (progress > 0.2 && progress <= 0.4){
                    lvlProgress.setStyle("-fx-accent: #FF4500;");
                } else if (progress > 0.4 && progress <= 0.6) {
                    lvlProgress.setStyle("-fx-accent: #BCC100;");
                } else if (progress > 0.6 && progress <= 0.8) {
                    lvlProgress.setStyle("-fx-accent: #709C00;");
                } else{
                    lvlProgress.setStyle("-fx-accent: #00DA00;");
                }

            switch (main.uiTrees.name()) {
                case "Tree":
                    Logslvlup.setText("Logs to lvlup: " + (int) Math.ceil(xptolvl / 25));
                    break;
                case "Oak":
                    Logslvlup.setText("Logs to lvlup: " + (int) Math.ceil(xptolvl / 37.5));
                    break;
                case "Willow":
                    Logslvlup.setText("Logs to lvlup: " + (int) Math.ceil(xptolvl / 67.5));
                    break;
                case "Teak":
                    Logslvlup.setText("Logs to lvlup: " + (int) Math.ceil(xptolvl / 85));
                    break;
                case "Yew":
                    Logslvlup.setText("Logs to lvlup: " + (int) Math.ceil(xptolvl / 175));
                    break;
                case "Maple":
                    Logslvlup.setText("Logs to lvlup: " + (int) Math.ceil(xptolvl / 100));
                    break;
                case "Magic":
                    Logslvlup.setText("Logs to lvlup: " + (int) Math.ceil(xptolvl / 250));
                    break;
            }
            if(once == 0){
                    String img = main.uiTrees.name() + ".png";
                    woodimg.setImage(new Image(
                            Objects.requireNonNull(
                                    InfoUIController.class.getClassLoader().getResource(
                                            "com/Gearsas/bots/Sato_woodcutting/ui/" +img)).toExternalForm()));
                    //woodimg.setImage(new Image(getClass().getResourceAsStream(img)));
                    statsImg.setImage(new Image(
                            Objects.requireNonNull(
                                    InfoUIController.class.getClassLoader().getResource(
                                            "com/Gearsas/bots/Sato_woodcutting/ui/" + "Stats.png")).toExternalForm()));
                 //   statsImg.setImage(new Image(getClass().getResourceAsStream("Stats.png")));
                   // SkillImg.setImage(new Image(getClass().getResourceAsStream("Skill.png")));
                    SkillImg.setImage(new Image(
                            Objects.requireNonNull(
                                    InfoUIController.class.getClassLoader().getResource(
                                            "com/Gearsas/bots/Sato_woodcutting/ui/" + "Skill.png")).toExternalForm()));
                    once++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateGraphs(int time,int hours, int woodcount){
            if(currenttime != time && ((((double)time)-1) % 5.0 ==0) || first == 0){
                main.woodcount = 0;
                woodcount = 0;
                if(time < 10) {
                    series.getData().add(new XYChart.Data(hours + ":0" + time, woodcount));
                }
                else {
                    series.getData().add(new XYChart.Data(hours + ":" + time, woodcount));
                }
                currenttime = time;
                count ++;
                first++;
            }else{
                series.getData().remove(series.getData().size()-1);
                if(time < 10) {
                    series.getData().add(new XYChart.Data(hours + ":0" + time, woodcount));
                }
                else {
                    series.getData().add(new XYChart.Data(hours + ":" + time, woodcount));
                }
            }
            dataChart.getData().clear();
            dataChart.getData().add(series);
    }
}
