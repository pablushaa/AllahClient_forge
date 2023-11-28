package com.pablusha.allahclient.Module.combat;

import com.pablusha.allahclient.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.util.Comparator;

public class KillAura extends Module {
    public Minecraft mc = Minecraft.getMinecraft();
    public KillAura() {
        super("KillAura", Keyboard.KEY_Z, Category.Combat);
    }
    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        double range = 4.6F;
        EntityPlayer target  = mc.world.playerEntities.stream().filter(entityPlayer -> entityPlayer != mc.player).min(Comparator.comparing(entityPlayer ->
                entityPlayer.getDistance(mc.player))).filter(entityPlayer -> entityPlayer.getDistance(mc.player) <= range).orElse(null);

        if (target != null && !target.isCreative() && !target.isSpectator()) {
            if (mc.player.getCooledAttackStrength(0) == 1) {
                mc.playerController.attackEntity(mc.player, target);
                mc.player.swingArm(EnumHand.MAIN_HAND);
                mc.player.resetCooldown();
            }
        }
    }
}
