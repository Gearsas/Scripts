package com.Gearsas.bots.Sato_woodcutting.leafs;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class GoToBank extends LeafTask {

    private final Sato_Woodcutting main;

    public GoToBank(Sato_Woodcutting main){
        this.main= main;
    }
    @Override
    public void execute() {

        if(main.player.getAnimationId() == 871 || main.player.getAnimationId() == 2846){
            Execution.delay(400,600);
            return;
        }

        GameObject bank = GameObjects.newQuery().names(main.bank).within(main.bankArea).visible().results().nearest();

        main.currentTask = "Going to bank";

        if(bank !=null && bank.isVisible()  && bank.distanceTo(main.player) < 15){
            bank.interact(main.bankingtype);
            Execution.delay(500);
            Execution.delayWhile(main.player::isMoving, 500, 1000);
        } else if (bank !=null && !bank.isVisible()  && bank.distanceTo(main.player) < 15) {
            Camera.turnTo(bank);
        } else {
            final BresenhamPath bp = BresenhamPath.buildTo(main.bankArea);
            if(bp!=null){
                if (bp.step(true)) {
                    main.currentTask = "Going to tree";
                }
            }

            if(Camera.getZoom() > 0.4 || Camera.getZoom() < 0.19)
                Camera.setZoom(0.3, 0.1);

            Camera.turnTo(main.bankArea);

            Execution.delay(350,450);
        }
    }
}
