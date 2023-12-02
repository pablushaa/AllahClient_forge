package com.pablusha.allahclient;
import Menu.onGuiOpenEvent;
import com.pablusha.allahclient.UI.ui;
import com.pablusha.allahclient.clickgui.ClickGuiManager;
import com.pablusha.allahclient.clickgui.SettingsManager;
import com.pablusha.allahclient.keys.key;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.Session;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import java.lang.reflect.Field;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "allahclient";
    public static final String NAME = "AllahClient";
    public static final String VERSION = "1.2";

    public static ExampleMod instance;
    public SettingsManager settingsManager;
    public ClickGuiManager clickGui;
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Display.setTitle("Loading " + AllahClient.clientname);
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        clickGui = new ClickGuiManager();
        instance = this;
        settingsManager = new SettingsManager();
        AllahClient.startup();
        MinecraftForge.EVENT_BUS.register(new key());
        MinecraftForge.EVENT_BUS.register(new ui());
        MinecraftForge.EVENT_BUS.register(new onGuiOpenEvent());
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    public static void setSession(Session s) {
        Class<? extends Minecraft> mc = Minecraft.getMinecraft().getClass();

        try {
            Field session = null;

            for(Field f : mc.getDeclaredFields()) {
                if(f.getType().isInstance(s)) {
                    session = f;
                }
            }

            if(session == null) {
                throw new IllegalStateException("Session null");
            }

            session.setAccessible(true);
            session.set(Minecraft.getMinecraft(), s);
            session.setAccessible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
