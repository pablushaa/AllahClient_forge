package com.pablusha.allahclient;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class Utils {
    public static void sendClientMessage(String msg) {
        String prefix = "[§6AllahClient§r] ";

        Minecraft mc = Minecraft.getMinecraft();
        mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(prefix + msg));
    }
}
