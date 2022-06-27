package com.Gearsas.bots.Sato_woodcutting.leafs;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class ChopWoodFromBank extends LeafTask {
    private final Sato_Woodcutting main;
    public ChopWoodFromBank(Sato_Woodcutting main){
        this.main = main;
    }
    @Override
    public void execute() {
        if(Bank.isOpen()){
            Execution.delay(400,700);
            Bank.close();
            return;
        }
        if(main.player.getAnimationId() == 871 || main.player.getAnimationId() == 2846 ||
                main.player.getAnimationId() == 869 || main.player.getAnimationId() == 873||
                main.player.getAnimationId() == 875 || main.player.getAnimationId() == 877||
                main.player.getAnimationId() == 867){
            Execution.delay(700,850);
            return;
        }

        if(main.player.getAnimationId() != -1){
            Execution.delay(700,800);
            return;
        }
        GameObject tree = GameObjects.newQuery().names(main.Tree).within(main.mTree_area).visible().results().nearest();

        if(tree != null){
            main.currentTask = "Chopping " + main.Tree;
        }

        if(tree !=null && tree.isValid() && tree.isVisible()){
            while(main.player.getAnimationId() == -1 && !Inventory.isFull() && tree.isValid() && tree.isVisible()){
                if(tree.distanceTo(main.player) < 4){
                    tree.click();
                } else
                    tree.interact("Chop down");
                Execution.delay(1100,1400);
            }
            return;
        }else{
            tree = GameObjects.newQuery().names(main.Tree).within(main.mTree_area).results().nearest();
            Execution.delay(100,200);

            if (tree !=null && tree.isValid() && tree.isVisible()) {
                tree.interact("Chop down");
                Execution.delay(500);
                Execution.delayWhile(main.player::isMoving, 200, 800);
                return;
            }

            if(tree !=null && tree.isValid() && !tree.isVisible()){
                final BresenhamPath bp = BresenhamPath.buildTo(main.navTree);
                if(bp!=null){
                    if (bp.step(true)) {
                        main.currentTask = "Going to tree";
                    }
                }

                if(Camera.getZoom() > 0.4 || Camera.getZoom() < 0.19)
                    Camera.setZoom(0.3, 0.1);

                Camera.turnTo(tree);
                Execution.delay(300);

                if(tree.isVisible()){
                    while(main.player.getAnimationId() == -1 && !Inventory.isFull() && tree.isValid() && tree.isVisible()){
                        if(tree.distanceTo(main.player) < 4){
                            tree.click();
                        } else
                            tree.interact("Chop down");
                        Execution.delayWhile(main.player::isMoving, 200,900);
                        Execution.delay(1000);
                    }
                }
                return;
            }

            if(tree == null){
                final BresenhamPath bp = BresenhamPath.buildTo(main.navTree);
                if(bp!=null){
                    if (bp.step(true)) {
                        main.currentTask = "Going to tree";
                    }
                }
                Execution.delayWhile(main.player::isMoving, 200, main.delay);
            }
        }
        if(tree == null){
            main.currentTask = "No trees found";
        }
    }
}
