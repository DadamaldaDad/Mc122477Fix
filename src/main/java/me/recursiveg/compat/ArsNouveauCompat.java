package me.recursiveg.compat;

import com.hollingsworth.arsnouveau.client.gui.book.GuiSpellBook;
import net.minecraft.client.gui.screens.Screen;

public class ArsNouveauCompat {
    public static boolean isSpellBookScreen(Screen screen) {
        return screen instanceof GuiSpellBook;
    }
}
