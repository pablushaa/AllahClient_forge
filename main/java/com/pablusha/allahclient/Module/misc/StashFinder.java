package com.pablusha.allahclient.Module.misc;

import com.pablusha.allahclient.Module.Module;
import com.pablusha.allahclient.Module.RenderUtils;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class StashFinder extends Module {
    public StashFinder() {
        super("Stash Finder", Keyboard.KEY_NONE, Category.Misc);
    }

    public int counter = 0;
    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {
        for (Object c : mc.world.loadedTileEntityList) {
            if (c instanceof TileEntityChest) {
                counter++;
            }
            if (c instanceof TileEntityShulkerBox) {
                counter++;
            }
            if(counter > 5) {
                mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(
                        "Stash finded!"));
                return;
            }
        }
    }
}
