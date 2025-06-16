package me.recursiveg.compat;

import net.minecraft.client.gui.screens.Screen;
import net.neoforged.fml.ModList;

public class CompatManager {
    public static boolean isTypableScreen(Screen screen) {
        if(ModList.get().isLoaded("ars_nouveau")) {
            if(ArsNouveauCompat.isSpellBookScreen(screen)) {
                return true;
            }
        }

        return false;
    }
}
