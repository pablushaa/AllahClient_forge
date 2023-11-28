package com.pablusha.allahclient.Module.player;

import com.pablusha.allahclient.Module.Module;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Panic extends Module {
    public Panic() {
        super("Panic", Keyboard.KEY_NONE, Category.Player);
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        if(mc.player.getHealth() < 6) {
            mc.world.sendQuittingDisconnectingPacket();
        }
    }
}
