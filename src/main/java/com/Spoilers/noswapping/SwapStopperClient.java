package com.Spoilers.noswapping;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SwapStopperClient {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void StopSwappingClick(GuiScreenEvent.MouseClickedEvent.Pre event) {
        Minecraft mc = event.getGui().getMinecraft();
        if(mc.options.keySwapOffhand.matchesMouse(event.getButton())) {
            event.setCanceled(true);
            return;
        }
        for(int i = 0; i < 9; ++i) {
            if (mc.options.keyHotbarSlots[i].matchesMouse(event.getButton())) {
                event.setCanceled(true);
                return;
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void StopSwappingKey(GuiScreenEvent.KeyboardKeyPressedEvent.Pre event) {
        Minecraft mc = event.getGui().getMinecraft();
        if (mc.options.keySwapOffhand.isActiveAndMatches(InputMappings.getKey(event.getKeyCode(), event.getScanCode()))) {
            event.setCanceled(true);
            return;
         }
        for(int i = 0; i < 9; ++i) {
            if (mc.options.keyHotbarSlots[i].isActiveAndMatches(InputMappings.getKey(event.getKeyCode(), event.getScanCode()))) {
                event.setCanceled(true);
                return;
            }
        }
    }
}