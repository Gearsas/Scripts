package com.Gearsas.bots.Sato_woodcutting;

import com.Gearsas.bots.Sato_woodcutting.branches.*;
import com.Gearsas.bots.Sato_woodcutting.leafs.*;
import com.Gearsas.bots.Sato_woodcutting.ui.InfoUI;
import com.Gearsas.bots.Sato_woodcutting.ui.InfoUIController;
import com.Gearsas.bots.Sato_woodcutting.ui.SetupUI;
import com.Gearsas.bots.Sato_woodcutting.ui.SetupUIController;
import com.runemate.game.api.client.embeddable.EmbeddableUI;
import com.runemate.game.api.hybrid.RuneScape;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.entities.definitions.ItemDefinition;
import com.runemate.game.api.hybrid.input.Mouse;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.util.StopWatch;
import com.runemate.game.api.script.framework.listeners.InventoryListener;
import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import com.runemate.game.api.script.framework.listeners.events.*;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sato_Woodcutting extends TreeBot implements EmbeddableUI, InventoryListener {

    //variables
    private SimpleObjectProperty<Node> Interface;
    private SetupUI setupUI;
    private InfoUI infoUI;
    public String currentTask;
    public StopWatch stopWatch = new StopWatch();
    public Boolean initialization;
    public Date date = new Date();
    Calendar calendar = GregorianCalendar.getInstance();

    //TODO: swap ints to bools where needed
    public Area treeArea, bankArea, mTree_area, navTree;
    private int i = 0, j=0;
    public int woodcount;
    public int totalwood;
    public int xptolvl;
    public Player player;
    public int xp, currentxp, lvl, lvlp, startlvl,cmbtlvl;

    public String Tree = "";
    public String bank = "";
    public String bankingtype = "";
    public boolean Restricted = false;
    public int delay = 2000;
    public int delay1 = 500;
    public boolean spec = false;


    //initializing branches
    public Root root = new Root(this);
    public LocationCheck LocationCheck= new LocationCheck(this);
    public NavigateTo navigateTo = new NavigateTo(this);
    public GoToBank gotobank = new GoToBank(this);

    public OpenBank openBank = new OpenBank(this);
    public DepositInv depositInv = new DepositInv(this);
    public WithdrawAxe withdrawAxe = new WithdrawAxe(this);
    public ChopWoodFromBank chopWoodFromBank = new ChopWoodFromBank(this);
    public Tree_checkInvAndHatchet tree_checkInvAndHatchet = new Tree_checkInvAndHatchet(this);

    public SetupUIController.LogTypes uiTrees;

    public ChopWood chopWood = new ChopWood(this);
    public OpenBankCheck openBankCheck = new OpenBankCheck(this);
    public ClosedBankCheck closedBankCheck = new ClosedBankCheck(this);

    //initializing controllers
    public InfoUIController infoUIController = new InfoUIController(this);
    public SetupUIController setupUIController = new SetupUIController(this);

    //locations
    public final Area Arceuus_Tree_Area = new Area.Rectangular(new Coordinate(1618,3762,0), new Coordinate(1696,3729,0)),
                      Arceuus_Bank_Area = new Area.Rectangular(new Coordinate(1635,3743,0), new Coordinate(1636,3740,0)),
                      Arceuus_Magic_tree_area = new Area.Rectangular(new Coordinate(1678,3753,0), new Coordinate(1682,3739,0)),
                      Arceuus_Magic_navTree = new Area.Rectangular(new Coordinate(1680,3742,0),new Coordinate(1681,3742,0)),
                      Barb_Tree_Area = new Area.Rectangular(new Coordinate(2507,3552,0), new Coordinate(2540,3587,0)),
                      Barb_Bank_Area = new Area.Rectangular(new Coordinate(2536,3573,0), new Coordinate(2537,3572,0)),
                      Barb_Willow_tree_area = new Area.Rectangular(new Coordinate(2515,3583,0), new Coordinate(2522,3576,0)),
                      Barb_Willow_navTree = new Area.Rectangular(new Coordinate(2519,3576,0),new Coordinate(2518,3576,0)),
                      Barb_Tree_tree_area = new Area.Rectangular(new Coordinate(2515,3565,0), new Coordinate(2524,3554,0)),
                      Barb_Tree_navTree = new Area.Rectangular(new Coordinate(2520,3564,0),new Coordinate(2519,3564,0)),
                      Barb_Oak_tree_area = new Area.Rectangular(new Coordinate(2515,3565,0), new Coordinate(2524,3554,0)),
                      Barb_Oak_navTree = new Area.Rectangular(new Coordinate(2517,3560,0),new Coordinate(2519,3560,0)),
                      CastleWars_Tree_Area = new Area.Rectangular(new Coordinate(2331,3039,0), new Coordinate(2474,3418,0)),
                      CastleWars_Bank_Area = new Area.Rectangular(new Coordinate(2443,3084,0), new Coordinate(2444,3083,0)),
                      CastleWars_Tree_tree_area = new Area.Rectangular(new Coordinate(2471,3108,0), new Coordinate(2459,3081,0)),
                      CastleWars_Tree_navTree = new Area.Rectangular(new Coordinate(2459,3085,0),new Coordinate(2459,3084,0)),
                      CastleWars_Oak_tree_area = new Area.Rectangular(new Coordinate(2471,3108,0), new Coordinate(2459,3081,0)),
                      CastleWars_Oak_navTree = new Area.Rectangular(new Coordinate(2461,3091,0),new Coordinate(2469,3084,0)),
                      CastleWars_Teak_tree_area = new Area.Rectangular(new Coordinate(2334,3049,0), new Coordinate(2335,3047,0)),
                      CastleWars_Teak_navTree = new Area.Rectangular(new Coordinate(2334,3049,0),new Coordinate(2334,3048,0)),
                      Catherby_Tree_Area = new Area.Rectangular(new Coordinate(2814,3456,0), new Coordinate(2753,3421,0)),
                      Catherby_Bank_Area = new Area.Rectangular(new Coordinate(2809,3441,0), new Coordinate(2810,3442,0)),
                      Catherby_Yew_tree_area = new Area.Rectangular(new Coordinate(2773,3439,0), new Coordinate(2754,3426,0)),
                      Catherby_Yew_navTree = new Area.Rectangular(new Coordinate(2773,3437,0),new Coordinate(2773,3438,0)),
                      Catherby_Oak_tree_area = new Area.Rectangular(new Coordinate(2767,3455,0), new Coordinate(2789,3432,0)),
                      Catherby_Oak_navTree = new Area.Rectangular(new Coordinate(2789,3433,0),new Coordinate(2789,3434,0)),
                      Catherby_Willow_tree_area = new Area.Rectangular(new Coordinate(2788,3431,0), new Coordinate(2767,3424,0)),
                      Catherby_Willow_navTree = new Area.Rectangular(new Coordinate(2788,3429,0),new Coordinate(2788,3430,0)),
                      Catherby_Tree_tree_area = new Area.Rectangular(new Coordinate(2785,3434,0), new Coordinate(2770,3453,0)),
                      Catherby_Tree_navTree = new Area.Rectangular(new Coordinate(2785,3436,0),new Coordinate(2785,3435,0)),
                      CorsairCove_Tree_Area = new Area.Rectangular(new Coordinate(2579,2840,0), new Coordinate(2467,2902,0)),
                      CorsairCove_Bank_Area = new Area.Rectangular(new Coordinate(2569,2864,0), new Coordinate(2569,2865,0)),
                      CorsairCove_Yew_tree_area = new Area.Rectangular(new Coordinate(2480,2886,0), new Coordinate(2471,2893,0)),
                      CorsairCove_Yew_navTree = new Area.Rectangular(new Coordinate(2478,2886,0),new Coordinate(2477,2886,0)),
                      CorsairCove_Maple_tree_area = new Area.Rectangular(new Coordinate(2484,2900,0), new Coordinate(2477,2894,0)),
                      CorsairCove_Maple_navTree = new Area.Rectangular(new Coordinate(2477,2894,0),new Coordinate(2478,2894,0)),
                      draynor_Tree_Area = new Area.Rectangular(new Coordinate(3081,3251,0), new Coordinate(3115,3220,0)),
                      draynor_Bank_Area = new Area.Rectangular(new Coordinate(3091,3245,0), new Coordinate(3092,3243,0)),
                      draynor_Willow_tree_area = new Area.Rectangular(new Coordinate(3082,3239,0), new Coordinate(3087,3234,0)),
                      draynor_Willow_navTree = new Area.Rectangular(new Coordinate(3085,3238,0),new Coordinate(3085,3237,0)),
                      draynor_Oak_tree_area = new Area.Rectangular(new Coordinate(3102,3250,0), new Coordinate(3109,3241,0)),
                      draynor_Oak_navTree = new Area.Rectangular(new Coordinate(3101,3244,0),new Coordinate(3101,3244,0)),
                      draynor_Tree_tree_area = new Area.Rectangular(new Coordinate(3115,3220,0), new Coordinate(3103,3234,0)),
                      draynor_Tree_navTree = new Area.Rectangular(new Coordinate(3104,3234,0),new Coordinate(3105,3234,0)),
                      Edgevile_Tree_Area = new Area.Rectangular(new Coordinate(3081,3465,0), new Coordinate(3129,3519,0)),
                      Edgevile_Bank_Area = new Area.Rectangular(new Coordinate(3094,3489,0), new Coordinate(3095,3491,0)),
                      Edgevile_Tree_tree_area = new Area.Rectangular(new Coordinate(3111,3495,0), new Coordinate(3127,3514,0)),
                      Edgevile_Tree_navTree = new Area.Rectangular(new Coordinate(3112,3502,0),new Coordinate(3112,3503,0)),
                      Edgevile_Willow_tree_area = new Area.Rectangular(new Coordinate(3119,3502,0), new Coordinate(3114,3494,0)),
                      Edgevile_Willow_navTree = new Area.Rectangular(new Coordinate(3115,3498,0),new Coordinate(3115,3497,0)),
                      Edgevile_Yew_tree_area = new Area.Rectangular(new Coordinate(3088,3483,0), new Coordinate(3084,3467,0)),
                      Edgevile_Yew_navTree = new Area.Rectangular(new Coordinate(3088,3470,0),new Coordinate(3088,3470,0)),
                      Falador_Tree_Area = new Area.Rectangular(new Coordinate(2983,3376,0), new Coordinate(3032,3299,0)),
                      Falador_Bank_Area = new Area.Rectangular(new Coordinate(3010,3355,0), new Coordinate(3012,3354,0)),
                      Falador_Tree_tree_area = new Area.Rectangular(new Coordinate(3007,3355,0), new Coordinate(2995,3370,0)),
                      Falador_Tree_navTree = new Area.Rectangular(new Coordinate(3004,3360,0),new Coordinate(3004,3360,0)),
                      Falador_Oak_tree_area = new Area.Rectangular(new Coordinate(3014,3319,0), new Coordinate(2997,3302,0)),
                      Falador_Oak_navTree = new Area.Rectangular(new Coordinate(3004,3316,0),new Coordinate(3004,3316,0)),
                      Falador_Yew_tree_area = new Area.Rectangular(new Coordinate(2995,3310,0), new Coordinate(3023,3319,0)),
                      Falador_Yew_navTree = new Area.Rectangular(new Coordinate(3004,3316,0),new Coordinate(3004,3316,0)),
                      GE_Tree_Area = new Area.Rectangular(new Coordinate(3135,3520,0), new Coordinate(3227,3449,0)),
                      GE_Bank_Area = new Area.Rectangular(new Coordinate(3167,3490,0), new Coordinate(3166,3489,0)),
                      GE_Tree_tree_area = new Area.Rectangular(new Coordinate(3166,3465,0), new Coordinate(3143,3443,0)),
                      GE_Tree_navTree = new Area.Rectangular(new Coordinate(3164,3459,0),new Coordinate(3164,3459,0)),
                      GE_Yew_tree_area = new Area.Rectangular(new Coordinate(3202,3506,0), new Coordinate(3224,3499,0)),
                      GE_Yew_navTree = new Area.Rectangular(new Coordinate(3200,3500,0),new Coordinate(3200,3500,0)),
                      Hosidius_Tree_Area = new Area.Rectangular(new Coordinate(1757,3591,0), new Coordinate(1713,3626,0)),
                      Hosidius_Bank_Area = new Area.Rectangular(new Coordinate(1748,3598,0), new Coordinate(1747,3599,0)),
                      Hosidius_Tree_tree_area = new Area.Rectangular(new Coordinate(1738,3593,0), new Coordinate(1715,3624,0)),
                      Hosidius_Tree_navTree = new Area.Rectangular(new Coordinate(1735,3606,0),new Coordinate(1735,3606,0)),
                      Sawmill_Tree_Area = new Area.Rectangular(new Coordinate(3310,3492,0), new Coordinate(3247,3411,0)),
                      Sawmill_Bank_Area = new Area.Rectangular(new Coordinate(3253,3420,0), new Coordinate(3254,3419,0)),
                      Sawmill_Tree_tree_area = new Area.Rectangular(new Coordinate(3271,3437,0), new Coordinate(3283,3457,0)),
                      Sawmill_Tree_navTree = new Area.Rectangular(new Coordinate(3276,3439,0),new Coordinate(3276,3439,0)),
                      Sawmill_Oak_tree_area = new Area.Rectangular(new Coordinate(3275,3440,0), new Coordinate(3285,3414,0)),
                      Sawmill_Oak_navTree = new Area.Rectangular(new Coordinate(3279,3429,0),new Coordinate(3279,3429,0)),
                      Sawmill_Yew_tree_area = new Area.Rectangular(new Coordinate(3300,3468,0), new Coordinate(3307,3472,0)),
                      Sawmill_Yew_navTree = new Area.Rectangular(new Coordinate(3303,3470,0),new Coordinate(3303,3470,0)),
                      Seers_Tree_Area = new Area.Rectangular(new Coordinate(2671,3519,0), new Coordinate(2752,3404,0)),
                      Seers_Bank_Area = new Area.Rectangular(new Coordinate(2727,3493,0), new Coordinate(2728,3494,0)),
                      Seers_Maple_tree_area = new Area.Rectangular(new Coordinate(2735,3498,0), new Coordinate(2719,3504,0)),
                      Seers_Maple_navTree = new Area.Rectangular(new Coordinate(2732,3498,0),new Coordinate(2732,3498,0)),
                      Seers_Willow_tree_area = new Area.Rectangular(new Coordinate(2721,3503,0), new Coordinate(2706,3514,0)),
                      Seers_Willow_navTree = new Area.Rectangular(new Coordinate(2719,3504,0),new Coordinate(2719,3504,0)),
                      Seers_Tree_tree_area = new Area.Rectangular(new Coordinate(2743,3474,0), new Coordinate(2717,3490,0)),
                      Seers_Tree_navTree = new Area.Rectangular(new Coordinate(2724,3482,0),new Coordinate(2724,3482,0)),
                      Seers_Oak_tree_area =  new Area.Rectangular(new Coordinate(2743,3474,0), new Coordinate(2717,3490,0)),
                      Seers_Oak_navTree = new Area.Rectangular(new Coordinate(2720,3484,0),new Coordinate(2720,3484,0)),
                      Seers_magic_tree_area = new Area.Rectangular(new Coordinate(2700,3422,0), new Coordinate(2688,3429,0)),
                      Seers_Magic_navTree = new Area.Rectangular(new Coordinate(2698,3425,0),new Coordinate(2698,3425,0)),
                      Seers_Yew_tree_area = new Area.Rectangular(new Coordinate(2718,3458,0), new Coordinate(2703,3468,0)),
                      Seers_Yew_navTree = new Area.Rectangular(new Coordinate(2715,3462,0),new Coordinate(2715,3462,0)),
                      WC_Tree_Area = new Area.Rectangular(new Coordinate(1609,3513,0), new Coordinate(1574,3470,0)),
                      WC_Bank_Area = new Area.Rectangular(new Coordinate(1592,3476,0), new Coordinate(1592,3475,0)),
                      WC_Yew_tree_area = new Area.Rectangular(new Coordinate(1598,3483,0), new Coordinate(1588,3497,0)),
                      WC_Yew_navTree = new Area.Rectangular(new Coordinate(1595,3483,0),new Coordinate(1595,3483,0)),
                      WC_Magic_tree_area = new Area.Rectangular(new Coordinate(1583,3480,0), new Coordinate(1576,3495,0)),
                      WC_Magic_navTree = new Area.Rectangular(new Coordinate(1582,3483,0),new Coordinate(1582,3483,0));

    //BotsConstructor
    public Sato_Woodcutting(){
        initialization = true;
        setEmbeddableUI(this);
        calendar.setTime(date);
        woodcount = 0;
        totalwood = 0;
    }

    //main root task
    @Override
    public TreeTask createRootTask() {
        return new Root(this);
    }

    //UI setup
    @Override
    public ObjectProperty<? extends Node> botInterfaceProperty() {
        if(Interface == null){
             Interface = new SimpleObjectProperty<>(setupUI = new SetupUI(this));
             infoUI = new InfoUI(this);
        }
        return Interface;
    }

    @Override
    public void onStart(String... arguments) {
        setLoopDelay(400, 500);
        Mouse.setSpeedMultiplier(1);
        stopWatch.start();
        currentTask = "Setup";
        getEventDispatcher().addListener(this);

    }

    public void swapToInfoUI(){
        Interface.set(infoUI);
    }

    public void swapToSetupUI(){Interface.set(setupUI);}

    public void updateInfo(){
        if(RuneScape.isLoggedIn()) {
            if (j == 0) {
                xp = Skill.WOODCUTTING.getExperience();
                startlvl = Skill.WOODCUTTING.getCurrentLevel();
                j++;
            }
            date = new Date();
            calendar.setTime(date);
            currentxp = Skill.WOODCUTTING.getExperience() - xp;
            lvl = Skill.WOODCUTTING.getCurrentLevel();
            cmbtlvl = Skill.ATTACK.getCurrentLevel();
            lvlp = Skill.WOODCUTTING.getExperienceAsPercent();
            xptolvl = Skill.WOODCUTTING.getExperienceToNextLevel();
            Platform.runLater(() -> infoUIController.update(stopWatch.getRuntimeAsString(), currentTask, currentxp, lvl, lvlp, xptolvl));
            if (i == 2) {
                Platform.runLater(() -> infoUIController.updateGraphs(calendar.get(Calendar.MINUTE), calendar.get(Calendar.HOUR_OF_DAY), woodcount));
                i = 1;
            } else {
                i++;
            }
        }
    }

    @Override
    public void onItemAdded(ItemEvent event) {
        ItemDefinition definition = event.getItem().getDefinition();
        if (definition != null) {
            if (definition.getName().contains("ogs")) {
                woodcount++;
                totalwood++;
            }
        }
    }

}
