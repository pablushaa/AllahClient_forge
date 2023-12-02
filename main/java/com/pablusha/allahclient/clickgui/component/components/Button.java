package com.pablusha.allahclient.clickgui.component.components;

import java.awt.*;
import java.util.ArrayList;

import com.pablusha.allahclient.ExampleMod;
import com.pablusha.allahclient.Module.Module;
import com.pablusha.allahclient.clickgui.Setting;
import com.pablusha.allahclient.clickgui.component.Component;
import com.pablusha.allahclient.clickgui.component.Frame;
import com.pablusha.allahclient.clickgui.component.components.sub.Checkbox;
import com.pablusha.allahclient.clickgui.component.components.sub.Keybind;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import com.pablusha.allahclient.clickgui.component.components.sub.ModeButton;
import com.pablusha.allahclient.clickgui.component.components.sub.Slider;

public class Button extends com.pablusha.allahclient.clickgui.component.Component {

	public Module mod;
	public Frame parent;
	public int offset;
	private boolean isHovered;
	private ArrayList<com.pablusha.allahclient.clickgui.component.Component> subcomponents;
	public boolean open;
	public int height;
	public FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
	public Button(Module mod, Frame parent, int offset) {
		this.mod = mod;
		this.parent = parent;
		this.offset = offset;
		this.height = 12;
		this.subcomponents = new ArrayList<com.pablusha.allahclient.clickgui.component.Component>();
		this.open = false;
		int opY = offset + 12;
		if(ExampleMod.instance.settingsManager.getSettingsByMod(mod) != null) {
			for(Setting s : ExampleMod.instance.settingsManager.getSettingsByMod(mod)){
				if(s.isCombo()){
					this.subcomponents.add(new ModeButton(s, this, mod, opY));
					opY += 12;
				}
				if(s.isSlider()){
					this.subcomponents.add(new Slider(s, this, opY));
					opY += 12;
				}
				if(s.isCheck()){
					this.subcomponents.add(new Checkbox(s, this, opY));
					opY += 12;
				}
			}
		}
		this.subcomponents.add(new Keybind(this, opY));
	}

	@Override
	public void setOff(int newOff) {
		offset = newOff;
		int opY = offset + 12;
		for(com.pablusha.allahclient.clickgui.component.Component comp : this.subcomponents) {
			comp.setOff(opY);
			opY += 12;
		}
	}

	@Override
	public void renderComponent() {
		Gui.drawRect(parent.getX(), this.parent.getY() + this.offset, parent.getX() + parent.getWidth(), this.parent.getY() + 12 + this.offset, this.isHovered ? 0x99222222 : 0x99111111);
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(this.mod.getName(), (parent.getX() + 5), (parent.getY() + offset + 2), this.mod.isToggled() ? new Color(0xf3b48b).hashCode() : 0xFFFFFF); //0x999999
		if(this.subcomponents.size() >= 2) {
			Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(this.open ? "§7-" : "§7+", (parent.getX()+parent.getWidth()-10), (parent.getY() + offset + 2), -1);
		}
		if(this.open) {
			if(!this.subcomponents.isEmpty()) {
				for(com.pablusha.allahclient.clickgui.component.Component comp : this.subcomponents) {
					comp.renderComponent();
				}
			}
		}
	}

	@Override
	public int getHeight() {
		if(this.open) {
			return (12 * (this.subcomponents.size() + 1));
		}
		return 12;
	}

	@Override
	public void updateComponent(int mouseX, int mouseY) {
		this.isHovered = isMouseOnButton(mouseX, mouseY);
		if(!this.subcomponents.isEmpty()) {
			for(com.pablusha.allahclient.clickgui.component.Component comp : this.subcomponents) {
				comp.updateComponent(mouseX, mouseY);
			}
		}
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int button) {
		if(isMouseOnButton(mouseX, mouseY) && button == 0) {
			this.mod.toggle();
		}
		if(isMouseOnButton(mouseX, mouseY) && button == 1) {
			this.open = !this.open;
			this.parent.refresh();
		}
		for(com.pablusha.allahclient.clickgui.component.Component comp : this.subcomponents) {
			comp.mouseClicked(mouseX, mouseY, button);
		}
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
		for(com.pablusha.allahclient.clickgui.component.Component comp : this.subcomponents) {
			comp.mouseReleased(mouseX, mouseY, mouseButton);
		}
	}

	@Override
	public void keyTyped(char typedChar, int key) {
		for(Component comp : this.subcomponents) {
			comp.keyTyped(typedChar, key);
		}
	}

	public boolean isMouseOnButton(int x, int y) {
		if(x > parent.getX() && x < parent.getX() + parent.getWidth() && y > this.parent.getY() + this.offset && y < this.parent.getY() + 12 + this.offset) {
			return true;
		}
		return false;
	}
}
