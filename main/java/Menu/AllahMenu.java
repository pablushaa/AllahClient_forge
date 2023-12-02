package Menu;

import com.pablusha.allahclient.AllahClient;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.IOException;

public class AllahMenu extends GuiScreen {
    public AllahMenu() {
        super();
    }

    @Override
    public void initGui() {
        int i = this.height / 4 + 48;
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, i + 72 + 12, 98, 20, "Options"));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(new ResourceLocation("background.jpg"));
        drawModalRectWithCustomSizedTexture(0, 0, 0, 0, width, height, this.width, this.height);

        this.drawGradientRect(0, height - 100, width, height, 0x00000000, 0xff000000);

        String[] buttons = {"Singleplayer", "Multiplayer", "Settings", "Author", "User", "Quit"};

        int count = 0;
        for (String name : buttons) {
            float x = (width/buttons.length) * count + (width/buttons.length) / 2 + 8 - mc.fontRenderer.getStringWidth(name)/2;

            float y = height - 20;

            boolean hovered = mouseX >= x && mouseY >= y && mouseX < x + mc.fontRenderer.getStringWidth(name) && mouseY < y + mc.fontRenderer.FONT_HEIGHT;
            this.drawCenteredString(mc.fontRenderer, name, (width/buttons.length) * count + (width/buttons.length) / 2 + 8, height - 20, hovered ? 0xf3b48b : -1);
            count++;
        }

        GlStateManager.pushMatrix();
        GlStateManager.translate(width/2f, height/2f, 0);
        GlStateManager.scale(3.5, 3.5, 1);
        GlStateManager.translate(-(width/2f), -(height/2f), 0);
        this.drawCenteredString(mc.fontRenderer, "AllahClient", width/2, height/2 - mc.fontRenderer.FONT_HEIGHT/2, -1);
        GlStateManager.popMatrix();
        this.drawCenteredString(mc.fontRenderer, "Version " + AllahClient.version, width/2, height/2 - mc.fontRenderer.FONT_HEIGHT/2 + 20, -1);
    }

    public void mouseClicked(int mouseX, int mouseY, int button) {
        String[] buttons = {"Singleplayer", "Multiplayer", "Settings", "Author", "User", "Quit"};

        int count = 0;
        for (String name : buttons) {
            float x = (width/buttons.length) * count + (width/buttons.length) / 2 + 8 - mc.fontRenderer.getStringWidth(name)/2;
            float y = height - 20;

            if(mouseX >= x && mouseY >= y && mouseX < x + mc.fontRenderer.getStringWidth(name) && mouseY < y + mc.fontRenderer.FONT_HEIGHT) {
                switch (name) {
                    case "Singleplayer":
                        mc.displayGuiScreen(new GuiWorldSelection(this));
                        break;
                    case "Author":
                        Desktop desktop = Desktop.getDesktop();
                        if (desktop.isSupported(Desktop.Action.OPEN)) {
                            try {
                                desktop.browse(java.net.URI.create("https://github.com/pablushaa"));
                                break;
                            } catch (IOException ex) {
                                System.out.println("sss");
                            }
                        }
                        break;
                    case "Multiplayer":
                        mc.displayGuiScreen(new GuiMultiplayer(this));
                        break;
                    case "Settings":
                        mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
                        break;
                    case "User":
                        mc.displayGuiScreen(new changeusername());
                        break;
                    case "Quit":
                        mc.shutdown();
                }
            }

            count++;
        }
    }
}
