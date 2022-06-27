package com.Gearsas.bots.Sato_woodcutting.leafs;

import com.Gearsas.bots.Sato_woodcutting.Sato_Woodcutting;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WithdrawAxe extends LeafTask {
    private final Sato_Woodcutting main;
    //  private String[] anyAxe = new String[]{ "Bronze axe", "Iron axe", "Steel axe", "Black axe", "Mithril axe", "Adamant axe", "Rune axe", "Dragon axe"};


    public WithdrawAxe(Sato_Woodcutting main){
        this.main = main;
    }
    @Override
    public void execute() {
        main.currentTask = "Withdrawing axe";
        if(Bank.contains("Dragon axe")  && main.lvl >=61 && main.cmbtlvl >=60){
            Bank.withdraw("Dragon axe", 1);
        } else if (Bank.contains("Rune axe")  && main.lvl >=41 && main.cmbtlvl >=40) {
            Bank.withdraw("Rune axe", 1);
        }else if (Bank.contains("Adamant axe")  && main.lvl >=31 && main.cmbtlvl >=30) {
            Bank.withdraw("Adamant axe", 1);
        }else if (Bank.contains("Mithril axe")  && main.lvl >=21 && main.cmbtlvl >=20) {
            Bank.withdraw("Mithril axe", 1);
        }else if (Bank.contains("Black axe")  && main.lvl >=11 && main.cmbtlvl >=10) {
            Bank.withdraw("Black axe", 1);
        }else if (Bank.contains("Steel axe")  && main.lvl >=6 && main.cmbtlvl >=5) {
            Bank.withdraw("Steel axe", 1);
        }else if (Bank.contains("Iron axe")) {
            Bank.withdraw("Iron axe", 1);
        }else if (Bank.contains("Bronze axe")) {
            Bank.withdraw("Bronze axe", 1);
        }else{
            main.currentTask = "No axe found!";
            Execution.delay(2000);
        }
    }
}
