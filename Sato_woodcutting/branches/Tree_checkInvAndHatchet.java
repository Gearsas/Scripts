package com.Gearsas.bots.Sato_woodcutting.branches;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.Gearsas.bots.Sato_woodcutting.leafs.ChopWood;
import com.Gearsas.bots.Sato_woodcutting.leafs.EmptyLeaf;
import com.runemate.game.api.hybrid.RuneScape;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Interfaces;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.osrs.local.hud.interfaces.ControlPanelTab;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class Tree_checkInvAndHatchet extends BranchTask {

    private Sato_Woodcutting main;
    private String[] anyAxe = new String[]{ "Bronze axe", "Iron axe", "Steel axe", "Black axe", "Mithril axe", "Adamant axe", "Rune axe", "Dragon axe"};

    public Tree_checkInvAndHatchet(Sato_Woodcutting main){
        this.main = main;
    }
    @Override
    public boolean validate() {
        if(Inventory.isFull()){
            return true;
        }

        if (Equipment.containsAnyOf(anyAxe)) {
            return  false;
        } else if (Inventory.containsAnyOf(anyAxe)) {
            if(!ControlPanelTab.INVENTORY.isOpen()) {
                ControlPanelTab.INVENTORY.open();
            }
            SpriteItem Axe = Inventory.newQuery().names(anyAxe).results().first();
            if(Axe !=null){
                if(Axe.interact("Wield")){
                    Execution.delayUntil(()-> Inventory.getSelectedItem() !=null, 500, 2000);
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public TreeTask successTask() {
        return main.gotobank;
    }

    @Override
    public TreeTask failureTask() {
        //System.out.println("Chopping wood");
        return main.chopWood;
    }
}
