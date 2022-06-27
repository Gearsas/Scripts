package com.Gearsas.bots.Sato_woodcutting.branches;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class LocationCheck extends BranchTask {

    private final Sato_Woodcutting main;
    private GameObject obj;

    public LocationCheck(Sato_Woodcutting main){
        this.main = main;
    }

    @Override
    public boolean validate() {
        return main.treeArea.contains(main.player);
    }
    @Override
    public TreeTask successTask() {

        if(main.bankArea.contains(main.player)){
            if(Bank.isOpen()){
                return main.openBankCheck;
            }else {
                return main.closedBankCheck;
            }
        } else if (!main.bankArea.contains(main.player) && Bank.isOpen()) {
            return main.openBankCheck;
        } else {
            return main.tree_checkInvAndHatchet;
        }
    }

    @Override
    public TreeTask failureTask() {
        return main.navigateTo;
    }
}
