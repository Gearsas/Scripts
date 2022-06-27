package com.Gearsas.bots.Sato_woodcutting.leafs;

import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class EmptyLeaf extends LeafTask {
    @Override
    public void execute() {
        Execution.delay(1000);
    }
}
