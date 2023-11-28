package com.pablusha.allahclient.Module.misc;

import com.pablusha.allahclient.AllahClient;
import com.pablusha.allahclient.Module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class SWAT extends Module {
    public static boolean swatted = false; // Eblusha ezz swatted
    public SWAT() {
        super("SWAT ALLAH CLIENT", Keyboard.KEY_F10, Category.Misc);
    }

    @Override
    public void onEnable() {
        swatted = true;
        for(Module m : AllahClient.modules) {
            if(m != this) {
                m.setToggled(false);
            }
        }

        Display.setTitle("Minecraft 1.12.2");
    }

    @Override
    public void onDisable() {
        Display.setTitle(AllahClient.clientname);
        swatted = false;
    }

}
