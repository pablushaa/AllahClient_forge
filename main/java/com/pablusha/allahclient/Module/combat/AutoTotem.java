package com.pablusha.allahclient.Module.combat;

import com.pablusha.allahclient.Module.Module;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class AutoTotem extends Module {
    public AutoTotem() {
        super("Auto Totem", Keyboard.KEY_NONE, Category.Combat);
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        if (mc.currentScreen == null || mc.currentScreen instanceof GuiInventory) {
            Item offhand = mc.player.getHeldItemOffhand().getItem();
            if(getItemCount(mc.player.inventoryContainer, Items.TOTEM_OF_UNDYING) > 0 && !offhand.equals(Items.TOTEM_OF_UNDYING)) {
                swap(getItemSlot(mc.player.inventoryContainer, Items.TOTEM_OF_UNDYING), 45);
            }
        }
    }

    int getItemCount(Container container, Item item) {
        int itemCount = 0;
        for (int i = 0; i < 45; ++i) {
            if (container.getSlot(i).getHasStack()) {
                final ItemStack is = container.getSlot(i).getStack();
                if (is.getItem() == item) {
                    itemCount += is.getCount();
                }
            }
        }
        return itemCount;
    }

    int getItemSlot(Container container, Item item) {
        int slot = 0;
        for (int i = 9; i < 45; ++i) {
            if (container.getSlot(i).getHasStack()) {
                ItemStack is = container.getSlot(i).getStack();
                if (is.getItem() == item)
                    slot = i;
            }
        }
        return slot;
    }

    void swap(int slot, int hotbarNum) {
        mc.playerController.windowClick(mc.player.inventoryContainer.windowId, slot, 0, ClickType.PICKUP, mc.player);
        mc.playerController.windowClick(mc.player.inventoryContainer.windowId, hotbarNum, 0, ClickType.PICKUP, mc.player);
        mc.playerController.windowClick(mc.player.inventoryContainer.windowId, slot, 0, ClickType.PICKUP, mc.player);
        mc.playerController.updateController();
    }
}
