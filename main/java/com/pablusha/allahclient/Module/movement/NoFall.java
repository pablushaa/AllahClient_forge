package com.pablusha.allahclient.Module.movement;
import com.pablusha.allahclient.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class NoFall extends Module {
    public Minecraft mc = Minecraft.getMinecraft();
    public NoFall() {
        super("No Fall", Keyboard.KEY_N, Category.Movement);
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        if (this.toggled) {
            if(mc.player.fallDistance > 5) {
                System.out.println("falling");
                mc.world.sendQuittingDisconnectingPacket();
                this.toggled = false;
            }
        }
    }
}
