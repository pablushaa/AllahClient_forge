package com.pablusha.allahclient.keys;

import com.pablusha.allahclient.AllahClient;
import com.pablusha.allahclient.Module.misc.SWAT;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class key {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        if (Keyboard.isKeyDown(Keyboard.getEventKey())) {
            if(Keyboard.getEventKey() != Keyboard.KEY_NONE) {
                AllahClient.keyPress(Keyboard.getEventKey());
                if (Keyboard.getEventKey() == Keyboard.KEY_R && !SWAT.swatted) {
                    Minecraft.getMinecraft().displayGuiScreen(AllahClient.clickGui);
                }
            }
        }
    }
}
