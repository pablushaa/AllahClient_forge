package com.pablusha.allahclient.Module.combat;

import com.pablusha.allahclient.Module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class CrystalAura extends Module {
    public CrystalAura() {
        super("Crystal Aura", Keyboard.KEY_X, Category.Combat);
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        for(Entity ent: mc.world.loadedEntityList) {
            if(ent instanceof EntityEnderCrystal) {
                if (mc.player.getDistance(ent) <= 5) {
                    mc.playerController.attackEntity(mc.player, ent);
                    mc.player.swingArm(EnumHand.MAIN_HAND);
                }
            }
        }
    }
}
