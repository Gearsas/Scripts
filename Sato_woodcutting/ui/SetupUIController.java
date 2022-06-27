package com.Gearsas.bots.Sato_woodcutting.ui;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class SetupUIController implements Initializable {

    private Sato_Woodcutting main;

    @FXML
    private ComboBox Location;

    @FXML
    private ComboBox<LogTypes> Tree;

    @FXML
    private Button Start_BT;

    @FXML
    private Text TreeText;

    @FXML
    private Text LocationText;

    private String img = "file:Willow.png";

    public SetupUIController(Sato_Woodcutting main){
        this.main = main;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Location.getItems().addAll("Arceuus", "Barbarian Assault", "Castle Wars", "Catherby","Corsair Cove", "Draynor", "Edgevile", "Falador", "Grand Exchange",
                "Hosidius", "Varrock Sawmill", "Seers Village", "Woodcutting guild");

        Start_BT.setOnAction(onButtonClick());
        Location.setOnAction(onLocationPicked());
        Tree.setOnAction(onTreePicked());
    }

    public EventHandler<ActionEvent> onButtonClick(){
        return actionEvent -> {
            try{
                main.initialization = false;

                switch (Location.getSelectionModel().getSelectedItem().toString()){
                    case "Draynor":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Willow"){
                            main.treeArea = main.draynor_Tree_Area;
                            main.bankArea = main.draynor_Bank_Area;
                            main.mTree_area = main.draynor_Willow_tree_area;
                            main.navTree = main.draynor_Willow_navTree;
                            main.Tree = "Willow";
                            main.Restricted = false;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if (Tree.getSelectionModel().getSelectedItem().toString() == "Oak") {
                            main.treeArea = main.draynor_Tree_Area;
                            main.bankArea = main.draynor_Bank_Area;
                            main.mTree_area = main.draynor_Oak_tree_area;
                            main.navTree = main.draynor_Oak_navTree;
                            main.Tree = "Oak";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if (Tree.getSelectionModel().getSelectedItem().toString() == "Tree") {
                            main.treeArea = main.draynor_Tree_Area;
                            main.bankArea = main.draynor_Bank_Area;
                            main.mTree_area = main.draynor_Tree_tree_area;
                            main.navTree = main.draynor_Tree_navTree;
                            main.Tree = "Tree";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }
                        break;
                    case "Arceuus":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Magic"){
                            main.treeArea = main.Arceuus_Tree_Area;
                            main.bankArea = main.Arceuus_Bank_Area;
                            main.mTree_area = main.Arceuus_Magic_tree_area;
                            main.navTree = main.Arceuus_Magic_navTree;
                            main.Tree = "Magic tree";
                            main.Restricted = false;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }
                        break;
                    case "Barbarian Assault":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Tree"){
                            main.treeArea = main.Barb_Tree_Area;
                            main.bankArea = main.Barb_Bank_Area;
                            main.mTree_area = main.Barb_Tree_tree_area;
                            main.navTree = main.Barb_Tree_navTree;
                            main.Tree = "Tree";
                            main.Restricted = true;
                            main.bank = "Bank chest";
                            main.bankingtype = "Use";
                        } else if (Tree.getSelectionModel().getSelectedItem().toString() == "Oak") {
                            main.treeArea = main.Barb_Tree_Area;
                            main.bankArea = main.Barb_Bank_Area;
                            main.mTree_area = main.Barb_Oak_tree_area;
                            main.navTree = main.Barb_Oak_navTree;
                            main.Tree = "Oak";
                            main.Restricted = true;
                            main.bank = "Bank chest";
                            main.bankingtype = "Use";
                        } else if (Tree.getSelectionModel().getSelectedItem().toString() == "Willow") {
                            main.treeArea = main.Barb_Tree_Area;
                            main.bankArea = main.Barb_Bank_Area;
                            main.mTree_area = main.Barb_Willow_tree_area;
                            main.navTree = main.Barb_Willow_navTree;
                            main.Tree = "Willow";
                            main.Restricted = true;
                            main.bank = "Bank chest";
                            main.bankingtype = "Use";
                        }
                        break;
                    case "Castle Wars":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Tree"){
                            main.treeArea = main.CastleWars_Tree_Area;
                            main.bankArea = main.CastleWars_Bank_Area;
                            main.mTree_area = main.CastleWars_Tree_tree_area;
                            main.navTree = main.CastleWars_Tree_navTree;
                            main.Tree = "Tree";
                            main.Restricted = true;
                            main.bank = "Bank chest";
                            main.bankingtype = "Use";
                        } else if (Tree.getSelectionModel().getSelectedItem().toString() == "Oak") {
                            main.treeArea = main.CastleWars_Tree_Area;
                            main.bankArea = main.CastleWars_Bank_Area;
                            main.mTree_area = main.CastleWars_Oak_tree_area;
                            main.navTree = main.CastleWars_Oak_navTree;
                            main.Tree = "Oak";
                            main.Restricted = true;
                            main.bank = "Bank chest";
                            main.bankingtype = "Use";
                        } else if (Tree.getSelectionModel().getSelectedItem().toString() == "Teak") {
                            main.treeArea = main.CastleWars_Tree_Area;
                            main.bankArea = main.CastleWars_Bank_Area;
                            main.mTree_area = main.CastleWars_Teak_tree_area;
                            main.navTree = main.CastleWars_Teak_navTree;
                            main.Tree = "Teak";
                            main.Restricted = true;
                            main.bank = "Bank chest";
                            main.bankingtype = "Use";
                            main.delay = 20000;
                        }
                        break;
                    case "Catherby":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Yew"){
                            main.treeArea =main.Catherby_Tree_Area;
                            main.bankArea = main.Catherby_Bank_Area;
                            main.mTree_area = main.Catherby_Yew_tree_area;
                            main.navTree = main.Catherby_Yew_navTree;
                            main.Tree = "Yew";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }  else if (Tree.getSelectionModel().getSelectedItem().toString() == "Oak") {
                            main.treeArea =main.Catherby_Tree_Area;
                            main.bankArea = main.Catherby_Bank_Area;
                            main.mTree_area = main.Catherby_Oak_tree_area;
                            main.navTree = main.Catherby_Oak_navTree;
                            main.Tree = "Oak";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }   else if (Tree.getSelectionModel().getSelectedItem().toString() == "Willow") {
                            main.treeArea = main.Catherby_Tree_Area;
                            main.bankArea = main.Catherby_Bank_Area;
                            main.mTree_area = main.Catherby_Willow_tree_area;
                            main.navTree = main.Catherby_Willow_navTree;
                            main.Tree = "Willow";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if (Tree.getSelectionModel().getSelectedItem().toString() == "Tree") {
                            main.treeArea = main.Catherby_Tree_Area;
                            main.bankArea = main.Catherby_Bank_Area;
                            main.mTree_area = main.Catherby_Tree_tree_area;
                            main.navTree = main.Catherby_Tree_navTree;
                            main.Tree = "Tree";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }
                        break;
                    case "Corsair Cove":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Yew"){
                            main.treeArea =main.CorsairCove_Tree_Area;
                            main.bankArea = main.CorsairCove_Bank_Area;
                            main.mTree_area = main.CorsairCove_Yew_tree_area;
                            main.navTree = main.CorsairCove_Yew_navTree;
                            main.Tree = "Yew";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Maple"){
                            main.treeArea =main.CorsairCove_Tree_Area;
                            main.bankArea = main.CorsairCove_Bank_Area;
                            main.mTree_area = main.CorsairCove_Maple_tree_area;
                            main.navTree = main.CorsairCove_Maple_navTree;
                            main.Tree = "Maple tree";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }
                        break;
                    case "Edgevile":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Tree"){
                            main.treeArea =main.Edgevile_Tree_Area;
                            main.bankArea = main.Edgevile_Bank_Area;
                            main.mTree_area = main.Edgevile_Tree_tree_area;
                            main.navTree = main.Edgevile_Tree_navTree;
                            main.Tree = "Tree";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Willow"){
                            main.treeArea =main.Edgevile_Tree_Area;
                            main.bankArea = main.Edgevile_Bank_Area;
                            main.mTree_area = main.Edgevile_Willow_tree_area;
                            main.navTree = main.Edgevile_Willow_navTree;
                            main.Tree = "Willow";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Yew"){
                            main.treeArea =main.Edgevile_Tree_Area;
                            main.bankArea = main.Edgevile_Bank_Area;
                            main.mTree_area = main.Edgevile_Yew_tree_area;
                            main.navTree = main.Edgevile_Yew_navTree;
                            main.Tree = "Yew";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }
                        break;
                    case "Falador":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Tree"){
                            main.treeArea =main.Falador_Tree_Area;
                            main.bankArea = main.Falador_Bank_Area;
                            main.mTree_area = main.Falador_Tree_tree_area;
                            main.navTree = main.Falador_Tree_navTree;
                            main.Tree = "Tree";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Oak"){
                            main.treeArea =main.Falador_Tree_Area;
                            main.bankArea = main.Falador_Bank_Area;
                            main.mTree_area = main.Falador_Oak_tree_area;
                            main.navTree = main.Falador_Oak_navTree;
                            main.Tree = "Oak";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Yew"){
                            main.treeArea =main.Falador_Tree_Area;
                            main.bankArea = main.Falador_Bank_Area;
                            main.mTree_area = main.Falador_Yew_tree_area;
                            main.navTree = main.Falador_Yew_navTree;
                            main.Tree = "Yew";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }
                        break;
                    case "Grand Exchange":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Tree"){
                            main.treeArea =main.GE_Tree_Area;
                            main.bankArea = main.GE_Bank_Area;
                            main.mTree_area = main.GE_Tree_tree_area;
                            main.navTree = main.GE_Tree_navTree;
                            main.Tree = "Tree";
                            main.Restricted = true;
                            main.bank = "Grand Exchange Booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Yew"){
                            main.treeArea =main.GE_Tree_Area;
                            main.bankArea = main.GE_Bank_Area;
                            main.mTree_area = main.GE_Yew_tree_area;
                            main.navTree = main.GE_Yew_navTree;
                            main.Tree = "Yew";
                            main.Restricted = true;
                            main.bank = "Grand Exchange Booth";
                            main.bankingtype = "Bank";
                        }
                        break;
                    case "Hosidius":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Tree"){
                            main.treeArea =main.Hosidius_Tree_Area;
                            main.bankArea = main.Hosidius_Bank_Area;
                            main.mTree_area = main.Hosidius_Tree_tree_area;
                            main.navTree = main.Hosidius_Tree_navTree;
                            main.Tree = "Tree";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }else if(Tree.getSelectionModel().getSelectedItem().toString() == "Oak"){
                            main.treeArea =main.Hosidius_Tree_Area;
                            main.bankArea = main.Hosidius_Bank_Area;
                            main.mTree_area = main.Hosidius_Tree_tree_area;
                            main.navTree = main.Hosidius_Tree_navTree;
                            main.Tree = "Oak";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }
                        break;
                    case "Varrock Sawmill":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Tree"){
                            main.treeArea =main.Sawmill_Tree_Area;
                            main.bankArea = main.Sawmill_Bank_Area;
                            main.mTree_area = main.Sawmill_Tree_tree_area;
                            main.navTree = main.Sawmill_Tree_navTree;
                            main.Tree = "Tree";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Oak"){
                            main.treeArea =main.Sawmill_Tree_Area;
                            main.bankArea = main.Sawmill_Bank_Area;
                            main.mTree_area = main.Sawmill_Oak_tree_area;
                            main.navTree = main.Sawmill_Oak_navTree;
                            main.Tree = "Oak";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Yew"){
                            main.treeArea =main.Sawmill_Tree_Area;
                            main.bankArea = main.Sawmill_Bank_Area;
                            main.mTree_area = main.Sawmill_Yew_tree_area;
                            main.navTree = main.Sawmill_Yew_navTree;
                            main.Tree = "Yew";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }
                        break;
                    case "Seers Village":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Tree"){
                            main.treeArea =main.Seers_Tree_Area;
                            main.bankArea = main.Seers_Bank_Area;
                            main.mTree_area = main.Seers_Tree_tree_area;
                            main.navTree = main.Seers_Tree_navTree;
                            main.Tree = "Tree";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Oak"){
                            main.treeArea =main.Seers_Tree_Area;
                            main.bankArea = main.Seers_Bank_Area;
                            main.mTree_area = main.Seers_Oak_tree_area;
                            main.navTree = main.Seers_Oak_navTree;
                            main.Tree = "Oak";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Willow"){
                            main.treeArea =main.Seers_Tree_Area;
                            main.bankArea = main.Seers_Bank_Area;
                            main.mTree_area = main.Seers_Willow_tree_area;
                            main.navTree = main.Seers_Willow_navTree;
                            main.Tree = "Willow";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Maple"){
                            main.treeArea =main.Seers_Tree_Area;
                            main.bankArea = main.Seers_Bank_Area;
                            main.mTree_area = main.Seers_Maple_tree_area;
                            main.navTree = main.Seers_Maple_navTree;
                            main.Tree = "Maple tree";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        } else if(Tree.getSelectionModel().getSelectedItem().toString() == "Yew"){
                            main.treeArea =main.Seers_Tree_Area;
                            main.bankArea = main.Seers_Bank_Area;
                            main.mTree_area = main.Seers_Yew_tree_area;
                            main.navTree = main.Seers_Yew_navTree;
                            main.Tree = "Yew";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }else if(Tree.getSelectionModel().getSelectedItem().toString() == "Magic"){
                            main.treeArea =main.Seers_Tree_Area;
                            main.bankArea = main.Seers_Bank_Area;
                            main.mTree_area = main.Seers_magic_tree_area;
                            main.navTree = main.Seers_Magic_navTree;
                            main.Tree = "Magic tree";
                            main.Restricted = true;
                            main.bank = "Bank booth";
                            main.bankingtype = "Bank";
                        }
                        break;
                    case "Woodcutting guild":
                        if(Tree.getSelectionModel().getSelectedItem().toString() == "Yew"){
                            main.treeArea =main.WC_Tree_Area;
                            main.bankArea = main.WC_Bank_Area;
                            main.mTree_area = main.WC_Yew_tree_area;
                            main.navTree = main.WC_Yew_navTree;
                            main.Tree = "Yew";
                            main.Restricted = false;
                            main.bank = "Bank chest";
                            main.bankingtype = "Use";
                        }else if(Tree.getSelectionModel().getSelectedItem().toString() == "Magic"){
                            main.treeArea =main.WC_Tree_Area;
                            main.bankArea = main.WC_Bank_Area;
                            main.mTree_area = main.WC_Magic_tree_area;
                            main.navTree = main.WC_Magic_navTree;
                            main.Tree = "Magic tree";
                            main.Restricted = false;
                            main.bank = "Bank chest";
                            main.bankingtype = "Use";
                        }
                        break;
                }

                Platform.runLater(() -> main.swapToInfoUI());
            } catch (Exception e){
                e.printStackTrace();
            }
        };
    }

    public EventHandler<ActionEvent> onLocationPicked(){
        return event ->{
           if(Location.getSelectionModel().getSelectedItem() !=null){
               Tree.setDisable(false);

               //Dont change to enhanced switch as SVN uses java 11 and will auto-deny the push
               switch (Location.getSelectionModel().getSelectedItem().toString()){
                   case "Arceuus":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Magic);
                       break;
                   case "Barbarian Assault":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Tree,LogTypes.Oak, LogTypes.Willow);
                       break;
                   case "Castle Wars":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Tree,LogTypes.Oak, LogTypes.Teak);
                       break;
                   case "Catherby":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Tree,LogTypes.Oak,LogTypes.Willow,LogTypes.Yew);
                       break;
                   case "Corsair Cove":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Yew,LogTypes.Maple);
                       break;
                   case "Draynor":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Tree,LogTypes.Oak, LogTypes.Willow);
                       break;
                   case "Edgevile":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Tree, LogTypes.Willow, LogTypes.Yew);
                       break;
                   case "Falador":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Tree, LogTypes.Oak, LogTypes.Yew);
                       break;
                   case "Grand Exchange":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Tree, LogTypes.Yew);
                       break;
                   case "Hosidius":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Tree, LogTypes.Oak);
                       break;
                   case "Varrock Sawmill":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Tree, LogTypes.Oak, LogTypes.Yew);
                       break;
                   case "Seers Village":
                   Tree.getItems().clear();
                   Tree.getItems().addAll(LogTypes.Tree,LogTypes.Oak, LogTypes.Willow, LogTypes.Maple, LogTypes.Yew, LogTypes.Magic);
                       break;
                   case "Woodcutting guild":
                       Tree.getItems().clear();
                       Tree.getItems().addAll(LogTypes.Yew, LogTypes.Magic);
                       break;
               }
               Tree.setButtonCell(new MonsterCell());
               Tree.setCellFactory(listview -> new MonsterCell());
               TreeText.setStyle("-fx-opacity: 1; -fx-fill: #f5f84f");
               LocationText.setStyle("-fx-fill: #27a131");
               System.out.println(Location.getSelectionModel().getSelectedItem().toString());

           }else{
               Start_BT.setDisable(true);
               Tree.setDisable(true);
           }
        };
    }

    public EventHandler<ActionEvent> onTreePicked(){
        return event ->{
            if(Tree.getSelectionModel().getSelectedItem() !=null){
                Start_BT.setDisable(false);
                Start_BT.setStyle("-fx-text-fill: #27a131");
                TreeText.setStyle("-fx-fill: #27a131");
                main.infoUIController.once = 0;
                switch (Tree.getSelectionModel().getSelectedItem().toString()){
                    case "Tree":
                        main.uiTrees = LogTypes.Tree;
                        break;
                    case "Oak":
                        main.uiTrees = LogTypes.Oak;
                        break;
                    case "Willow":
                        main.uiTrees = LogTypes.Willow;
                        break;
                    case "Teak":
                        main.uiTrees = LogTypes.Teak;
                        break;
                    case "Maple":
                        main.uiTrees = LogTypes.Maple;
                        break;
                    case "Yew":
                        main.uiTrees = LogTypes.Yew;
                        break;
                    case "Magic":
                        main.uiTrees = LogTypes.Magic;
                        break;
                }
            }else{
                Start_BT.setDisable(true);
            }
        };
    }

    private Map<LogTypes, Image> TreeImages = createTreeImages();

    private Map<LogTypes, Image> createTreeImages() {
        Map<LogTypes, Image> TreeImages = new HashMap<>();

        for (LogTypes logTypes : LogTypes.values()) {
            TreeImages.put(
                    logTypes,
                    new Image(
                            Objects.requireNonNull(
                                    SetupUIController.class.getClassLoader().getResource(
                                            "location to logs/" + logTypes + ".png")).toExternalForm()
                    )
            );
        }

        return TreeImages;
    }
}
