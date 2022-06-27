package com.Gearsas.bots.Sato_woodcutting.branches;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class OpenBankCheck extends BranchTask {

    private final Sato_Woodcutting main;
    private final String[] anyAxe = new String[]{ "Bronze axe", "Iron axe", "Steel axe", "Black axe", "Mithril axe", "Adamant axe", "Rune axe", "Dragon axe"};


    public OpenBankCheck(Sato_Woodcutting main){
        this.main = main;
    }
    @Override
    public boolean validate() {
        return Inventory.getEmptySlots() < 20;
    }

    @Override
    public TreeTask successTask() {
        return main.depositInv;
    }

    @Override
    public TreeTask failureTask() {
        if(Equipment.containsAnyOf(anyAxe) || Inventory.containsAnyOf(anyAxe)){
            return main.chopWoodFromBank;
        }
        return main.withdrawAxe;
    }
}
