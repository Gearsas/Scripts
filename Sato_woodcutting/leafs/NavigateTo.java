package com.Gearsas.bots.Sato_woodcutting.leafs;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class NavigateTo extends LeafTask {
    private final Sato_Woodcutting main;

    public NavigateTo(Sato_Woodcutting main){
        this.main = main;
    }

    @Override
    public void execute() {
        main.currentTask ="Navigating to Location";
        final BresenhamPath bp = BresenhamPath.buildTo(main.bankArea.getRandomCoordinate());
        if(bp !=null){
            if (bp.step(true)) {
                Execution.delayWhile(main.player::isMoving, 500, 1000);
            }
        }
    }
}
