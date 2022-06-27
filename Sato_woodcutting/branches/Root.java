package com.Gearsas.bots.Sato_woodcutting.branches;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.Gearsas.bots.Sato_woodcutting.leafs.EmptyLeaf;
import com.runemate.game.api.hybrid.RuneScape;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.core.LoopingThread;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class Root extends BranchTask {

    private final Sato_Woodcutting main;
    //int first = 0;
    int start = 0;
    public Root(Sato_Woodcutting main){
        this.main = main;
    }
    @Override
    public boolean validate() {
        return main.initialization;
    }

    @Override
    public TreeTask successTask() {
        return new EmptyLeaf();
    }

    @Override
    public TreeTask failureTask() {

        if(start < 2 && RuneScape.isLoggedIn()) {
            start++;
        } else if (start == 2 && RuneScape.isLoggedIn()) {
            start++;
            new LoopingThread(main::updateInfo, 1000).start();
        } else{
            main.player = Players.getLocal();
            return main.LocationCheck;
        }
        return new EmptyLeaf();
    }
}
