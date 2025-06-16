package me.recursiveg;

import me.recursiveg.compat.CompatManager;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod("mc122477fix")
public class Mc122477Fix {
    public Mc122477Fix(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);
    }

    long renderTicksSinceScreenOpen = 0;

    @SubscribeEvent
    public void onScreenOpen(ScreenEvent.Opening ev) {
        if (ev.getNewScreen() instanceof ChatScreen || ev.getNewScreen() instanceof CreativeModeInventoryScreen || CompatManager.isTypableScreen(ev.getNewScreen())) {
            renderTicksSinceScreenOpen = 0;
        }
    }

    @SubscribeEvent
    public void onKeyPressed(ScreenEvent.KeyPressed.Pre ev) {
        if (renderTicksSinceScreenOpen < 2) {
            ev.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onCharTyped(ScreenEvent.CharacterTyped.Pre ev) {
        if (renderTicksSinceScreenOpen < 2) {
            ev.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPostClientTick(ClientTickEvent.Post ev) {
        renderTicksSinceScreenOpen++;
    }
}
