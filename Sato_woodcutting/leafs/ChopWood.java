package com.Gearsas.bots.Sato_woodcutting.leafs;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class ChopWood extends LeafTask {
    private final Sato_Woodcutting main;
    private GameObject tree;
    int afk=0;
    public ChopWood(Sato_Woodcutting main){
        this.main = main;
    }
    @Override
    public void execute() {
        Execution.delay(300);

        //close bank if open
        if(Bank.isOpen()){
            Execution.delay(500,600);
            Bank.close();
            Execution.delay(500,700);
            return;
        }


        //check if not afking for too long
        if(afk > 250){
            if(tree !=null)
               tree.interact("Chop down");
        } else if(main.player.getAnimationId() == 871 || main.player.getAnimationId() == 2846 ||
                main.player.getAnimationId() == 869 || main.player.getAnimationId() == 873||
                main.player.getAnimationId() == 875 || main.player.getAnimationId() == 877||
                main.player.getAnimationId() == 867){
            Execution.delay(700,800);
            afk++;
            return;
        }


        if(!main.Restricted)
            tree = GameObjects.newQuery().names(main.Tree).results().nearest();
        else
            tree = GameObjects.newQuery().names(main.Tree).within(main.mTree_area).results().nearest();
/*
        if(main.spec){
            tree = GameObjects.newQuery().names(main.Tree).within(main.mTree_area).results().nearest();
        }*/

        if(tree != null){
            main.currentTask = "Chopping " + main.Tree;

        }

        afk=0;

        if(tree !=null && tree.isValid() && tree.isVisible()  && tree.distanceTo(main.player) < 18){
            while(main.player.getAnimationId() == -1 && !Inventory.isFull() && tree.isValid() && tree.isVisible() && !Bank.isOpen()){
                    tree.interact("Chop down");
                Execution.delayWhile(main.player::isMoving, 500,1500);
                Execution.delay(700,1000);
            }
        } else {
            if(main.spec) {
                final BresenhamPath bp = BresenhamPath.buildTo(main.navTree);

                if(bp!=null){
                    if (bp.step(true)) {
                        main.currentTask = "Going to tree";
                    }
                }
            }else{
                final RegionPath bp = RegionPath.buildTo(main.navTree);
                if(bp!=null){
                    if (bp.step(true)) {
                        main.currentTask = "Going to tree";
                    }
                }
            }



            if(Camera.getZoom() > 0.4 || Camera.getZoom() < 0.19)
                Camera.setZoom(0.3, 0.1);

            if(tree !=null){
                Camera.turnTo(tree);
            }else
                 Camera.turnTo(main.navTree);

            Execution.delay(350,450);
            if(main.spec) {
                Execution.delayWhile(main.player::isMoving, 1000,19000);
            }

            Execution.delayWhile(main.player::isMoving, 200,400);
        }
    }
}
