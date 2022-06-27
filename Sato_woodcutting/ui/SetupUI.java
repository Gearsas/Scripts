package com.Gearsas.bots.Sato_woodcutting.ui;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.runemate.game.api.hybrid.util.Resources;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SetupUI extends GridPane implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setVisible(true);
    }

    public SetupUI(Sato_Woodcutting main){
        FXMLLoader loader = new FXMLLoader();
        Future<InputStream> stream = main.getPlatform().invokeLater(()-> Resources.getAsStream("com/Gearsas/bots/Sato_woodcutting/ui/Setup.fxml"));

        loader.setController(main.setupUIController);
        loader.setRoot(this);

        try{
            loader.load(stream.get());

        } catch (IOException | InterruptedException | ExecutionException e){
            System.err.println("Error Loading SetupUI");
            e.printStackTrace();
        }
    }
}
