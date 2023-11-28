package com.pablusha.allahclient.UI;

import com.pablusha.allahclient.AllahClient;
import com.pablusha.allahclient.Module.Module;
import com.pablusha.allahclient.Module.misc.SWAT;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

public class ui {
    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post e) {
        if(!SWAT.swatted) {
            switch (e.getType()) {
                case TEXT:
                    int y = 5;
                    final int[] counter = {1};
                    Minecraft mc = Minecraft.getMinecraft();
                    FontRenderer fr = mc.fontRenderer;

                    ScaledResolution sr = new ScaledResolution(mc);


                    fr.drawStringWithShadow("Allah Client §6" + AllahClient.version + "§r | " +
                            Minecraft.getDebugFPS() + " FPS", 5, 5, -1);
                    fr.drawStringWithShadow("Salam, " + mc.getSession().getUsername(), 5,
                            mc.displayHeight / 2f - 10, 0xffffff);

                    for (Module module : AllahClient.modules) {
                        if(module.toggled) {
                            fr.drawStringWithShadow(module.name, sr.getScaledWidth() - 4 -
                                    fr.getStringWidth(module.name), y, rainbow(counter[0] * 300));

                            y += 10;
                            counter[0]++;
                        }
                    }
                default:
                    break;
            }
        }
    }

    public static int rainbow(int delay) {
        double rainbowState = Math.ceil(System.currentTimeMillis() + delay) / 20.0;
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}
