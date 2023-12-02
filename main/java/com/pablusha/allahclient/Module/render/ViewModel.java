package com.pablusha.allahclient.Module.render;

import com.pablusha.allahclient.ExampleMod;
import com.pablusha.allahclient.Module.Module;
import com.pablusha.allahclient.clickgui.Setting;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class ViewModel extends Module {
    public ViewModel() {
        super("ViewModel", Keyboard.KEY_NONE, Category.Render);

        ExampleMod.instance.settingsManager.rSetting(new Setting("X", this, 1.7, -5, 5, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Y", this, -0.8, -5, 5, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Z", this, -1.8, -5, 5, false));
    }

    @SubscribeEvent
    public void onRender(RenderSpecificHandEvent e) {
        double x = ExampleMod.instance.settingsManager.getSettingByName(this.name, "X").getValDouble();
        double y = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Y").getValDouble();
        double z = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Z").getValDouble();

        GL11.glTranslated(x, y, z);
    }
}
