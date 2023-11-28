package com.pablusha.allahclient;

import com.pablusha.allahclient.Module.Module;
import com.pablusha.allahclient.Module.combat.CrystalAura;
import com.pablusha.allahclient.Module.combat.KillAura;
import com.pablusha.allahclient.Module.misc.SWAT;
import com.pablusha.allahclient.Module.movement.*;
import com.pablusha.allahclient.Module.player.Panic;
import com.pablusha.allahclient.Module.render.PlayerESP;
import com.pablusha.allahclient.Module.render.Light;
import com.pablusha.allahclient.Module.render.ViewModel;
import com.pablusha.allahclient.clickgui.ClickGuiScreen;
import com.pablusha.allahclient.Module.movement.Fly;
import com.pablusha.allahclient.Module.movement.Sprint;
import org.lwjgl.opengl.Display;

import java.util.concurrent.CopyOnWriteArrayList;

public class AllahClient {
    public static String version = "1.0";
    public static String clientname = "AllahClient " + version;
    public static ClickGuiScreen clickGui;
    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
    public static void startup() {
        Display.setTitle(clientname);

        modules.add(new Fly());
        modules.add(new Sprint());
        modules.add(new NoFall());
        modules.add(new Speed());
        modules.add(new KillAura());
        modules.add(new Panic());
        modules.add(new CrystalAura());
        modules.add(new PlayerESP());
        modules.add(new Light());

        modules.add(new SWAT());

        clickGui = new ClickGuiScreen();
    }

    public static void keyPress(int key) {
        for (Module m : modules) {
            if(m.getKey() == key) {
                m.toggle();
            }
        }
    }
}
