package com.pablusha.allahclient.Module.render;
import com.pablusha.allahclient.Module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Light extends Module {

    public Light() {
        super("Light", Keyboard.KEY_NONE, Category.Render);
    }

    float gamma;

    public void onEnable() {
        Minecraft mc = Minecraft.getMinecraft();
        gamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 1000000f;
    }

    public void onDisable() {
        Minecraft mc = Minecraft.getMinecraft();
        mc.gameSettings.gammaSetting = gamma;
    }
}
