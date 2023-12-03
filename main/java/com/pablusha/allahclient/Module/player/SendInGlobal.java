package com.pablusha.allahclient.Module.player;

import com.pablusha.allahclient.Module.Module;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class SendInGlobal extends Module {

    public SendInGlobal() {
        super("Send Global", Keyboard.KEY_NONE, Category.Player);
    }

    @SubscribeEvent
    public void onChatMessage(ClientChatEvent e) {
        if(!e.getOriginalMessage().startsWith("/") && !e.getOriginalMessage().startsWith("!")) {
            e.setMessage("!" + e.getOriginalMessage());
        }
    }
}
