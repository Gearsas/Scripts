package com.Gearsas.bots.Sato_woodcutting.branches;

import com.Gearsas.bots.Sato_woodcutting.leafs.ChopWood;
import com.Gearsas.bots.Sato_woodcutting.leafs.EmptyLeaf;
import com.Gearsas.bots.Sato_woodcutting.leafs.GoToBank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsInvFull extends BranchTask{

    //private GoToBank goToBank = new GoToBank();


    @Override
    public boolean validate() {
        return Inventory.getEmptySlots() > 0;
    }



    @Override
    public TreeTask successTask() {
        return new EmptyLeaf();
    }

    @Override
    public TreeTask failureTask() {
       return new EmptyLeaf();
    }
}
