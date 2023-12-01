package com.pablusha.allahclient.Module.combat;

import com.pablusha.allahclient.Module.Module;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Criticals extends Module {
    public Criticals() {
        super("Criticals", Keyboard.KEY_NONE, Category.Combat);
    }

    @SubscribeEvent
    public void onAttack(AttackEntityEvent event) {
        if (event.isCanceled()) {
            return;
        }
        if (!mc.player.isInWater() && !mc.player.isInLava()) {
            if (mc.player.onGround) {
                mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.1625, mc.player.posZ, false));
                mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY, mc.player.posZ, false));
                mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 4.0E-6, mc.player.posZ, false));
                mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY, mc.player.posZ, false));
                mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.0E-6, mc.player.posZ, false));
                mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY, mc.player.posZ, false));
                mc.player.connection.sendPacket(new CPacketPlayer());
                mc.player.onCriticalHit(event.getTarget());
            }
        }
    }
}
