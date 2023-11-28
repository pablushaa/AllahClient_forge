package com.pablusha.allahclient.Module.movement;

import com.pablusha.allahclient.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.util.UUID;

public class Speed extends Module {
    public Speed() {
        super("Speed", Keyboard.KEY_V, Category.Movement);
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        if(this.toggled) {
            if(mc.player.onGround) {
                mc.player.motionX *= 1.15;
                mc.player.motionZ *= 1.15;
            }
        }
    }
}
