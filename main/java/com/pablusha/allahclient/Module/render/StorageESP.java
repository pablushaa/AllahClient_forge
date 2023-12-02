package com.pablusha.allahclient.Module.render;

import com.pablusha.allahclient.Module.Module;
import com.pablusha.allahclient.Module.RenderUtils;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class StorageESP extends Module {
    public StorageESP() {
        super("Storage ESP", Keyboard.KEY_NONE, Category.Render);
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {
        for (Object c : mc.world.loadedTileEntityList) {
            if (c instanceof TileEntityChest) {
                RenderUtils.blockESP(((TileEntityChest) c).getPos());
            }
            if (c instanceof TileEntityEnderChest) {
                RenderUtils.blockESP(((TileEntityEnderChest) c).getPos());
            }
            if (c instanceof TileEntityShulkerBox) {
                RenderUtils.blockESP(((TileEntityShulkerBox) c).getPos());
            }
        }
    }
}
