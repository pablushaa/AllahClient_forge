package com.pablusha.allahclient.Module.movement;

import com.pablusha.allahclient.Module.Module;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class BunnyHop extends Module {
    public BunnyHop() {
        super("BunnyHop", Keyboard.KEY_NONE, Category.Movement);
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        if(mc.player.onGround) {
            mc.player.jump();
        }
    }
}
