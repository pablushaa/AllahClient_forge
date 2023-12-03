package com.pablusha.allahclient.Module.misc;

import com.pablusha.allahclient.ExampleMod;
import com.pablusha.allahclient.Module.Module;
import com.pablusha.allahclient.clickgui.Setting;
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

        ExampleMod.instance.settingsManager.rSetting(new Setting("Range", this, 16, 8, 32, true));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Timer", this, 500, 50, 1000, true));
    }

    public int counter = 0;
    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        double range = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Range").getValDouble();
        double timer = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Timer").getValDouble();

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
