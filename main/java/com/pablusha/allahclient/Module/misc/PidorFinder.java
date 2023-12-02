package com.pablusha.allahclient.Module.misc;

import com.pablusha.allahclient.Module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class PidorFinder extends Module {
    public PidorFinder() {
        super("Pidor Finder", Keyboard.KEY_NONE, Category.Misc);
    }

    public int counter = 0;

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        for(Entity ent: mc.world.loadedEntityList) {
            if(ent instanceof EntityPlayer) {
                if (mc.player.getDistance(ent) <= 16 && ent != mc.player) {
                    if(counter == 1000) {
                        mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(
                                "Пидорас обнаружен: " + ent.getName()));
                        counter = 0;
                    }
                    counter++;
                }
            }
        }
    }
}
