package com.pablusha.allahclient.events;

import com.pablusha.allahclient.Utils;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AllahEvents {
    @SubscribeEvent
    public void onChatMessage(ClientChatEvent e) {
        String message = e.getMessage();
        if(message.startsWith("#")) {
            switch (message) {
                case "#help":
                    Utils.sendClientMessage("пошел нахуй");
                    break;
                default:
                    Utils.sendClientMessage("Command not found");
                    break;
            }
            e.setCanceled(true);
        }
    }
}
