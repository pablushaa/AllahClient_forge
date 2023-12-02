package com.pablusha.allahclient;

import com.pablusha.allahclient.Module.Module;
import com.pablusha.allahclient.Module.combat.*;
import com.pablusha.allahclient.Module.misc.PidorFinder;
import com.pablusha.allahclient.Module.misc.SWAT;
import com.pablusha.allahclient.Module.misc.StashFinder;
import com.pablusha.allahclient.Module.movement.*;
import com.pablusha.allahclient.Module.player.Panic;
import com.pablusha.allahclient.Module.render.PlayerESP;
import com.pablusha.allahclient.Module.render.Light;
import com.pablusha.allahclient.Module.render.StorageESP;
import com.pablusha.allahclient.Module.render.ViewModel;
import com.pablusha.allahclient.clickgui.ClickGuiManager;
import com.pablusha.allahclient.clickgui.ClickGuiScreen;
import com.pablusha.allahclient.Module.movement.Fly;
import com.pablusha.allahclient.Module.movement.Sprint;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class AllahClient {
    public static String version = "1.2";
    public static String clientname = "AllahClient " + version;
    public static ClickGuiManager clickGuiManager;
    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
    public static void startup() {
        Display.setTitle(clientname);

        modules.add(new Fly()); // 1.0
        modules.add(new Sprint()); // 1.0
        modules.add(new NoFall()); // 1.0
        modules.add(new Speed()); // 1.0
        modules.add(new BunnyHop()); // 1.2
        modules.add(new KillAura()); // 1.0
        modules.add(new CrystalAura()); // 1.0
        modules.add(new AutoTotem()); // 1.1
        modules.add(new Velocity()); // 1.1
        modules.add(new Criticals()); // 1.1
        modules.add(new Panic()); // 1.0
        modules.add(new ViewModel()); // 1.2
        modules.add(new PlayerESP()); // 1.0
        modules.add(new StorageESP());
        modules.add(new Light()); // 1.0

        modules.add(new SWAT()); // 1.0
        modules.add(new PidorFinder()); // 1.2
        modules.add(new StashFinder()); // 1.2

        clickGuiManager = new ClickGuiManager();
    }

    public static void keyPress(int key) {
        for (Module m : modules) {
            if(m.getKey() == key) {
                m.toggle();
            }
        }
    }

    public static ArrayList<Module> getModulesInCategory(Module.Category c) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module m : modules) {
            if (m.getCategory().name().equalsIgnoreCase(c.name())) {
                mods.add(m);
            }
        }
        return mods;
    }
}
