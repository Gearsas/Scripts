package com.Gearsas.bots.Sato_woodcutting.branches;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.Gearsas.bots.Sato_woodcutting.leafs.ChopWood;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class ClosedBankCheck extends BranchTask {
    private Sato_Woodcutting main;
    private String[] anyAxe = new String[]{ "Bronze axe", "Iron axe", "Steel axe", "Black axe", "Mithril axe", "Adamant axe", "Rune axe", "Dragon axe"};


    public ClosedBankCheck(Sato_Woodcutting main){
        this.main = main;
    }
    @Override
    public boolean validate() {
        if(Inventory.getEmptySlots() < 20){
            return true;
        } else if (Inventory.containsAnyOf(anyAxe)) {
            return false;
        } else if (Equipment.containsAnyOf(anyAxe)) {
            return false;
        }
        return true;
    }

    @Override
    public TreeTask successTask() {
        //opn bank
        return main.openBank;
    }

    @Override
    public TreeTask failureTask() {
        //go to tree area
        return main.chopWood;
    }
}
