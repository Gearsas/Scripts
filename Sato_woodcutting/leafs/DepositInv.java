package com.Gearsas.bots.Sato_woodcutting.leafs;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class DepositInv extends LeafTask {
    private final Sato_Woodcutting main;

    public DepositInv(Sato_Woodcutting main){
        this.main = main;
    }
    @Override
    public void execute() {
        main.currentTask = "Depositing inventory";
        Bank.depositInventory();
    }
}
