package com.pablusha.allahclient.Module.render;

import com.pablusha.allahclient.Module.Module;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class ViewModel extends Module {
    public ViewModel() {
        super("View Model", Keyboard.KEY_NONE, Category.Render);
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {
        GL11.glTranslated(0.5f, 0.5f, 0.5f);
    }
}
