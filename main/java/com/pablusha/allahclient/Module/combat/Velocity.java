package com.pablusha.allahclient.Module.combat;

import com.pablusha.allahclient.Module.Module;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Velocity extends Module {
    public Velocity() {
        super("Velocity", Keyboard.KEY_NONE, Category.Combat);
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        if(mc.player.hurtTime > 0) {
            mc.player.motionX = 0;
            mc.player.motionY = 0;
            mc.player.motionX = 0;
        }
    }
}
