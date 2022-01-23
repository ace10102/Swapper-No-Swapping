package com.Spoilers.noswapping.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;

@Mixin(Container.class)
public class ContainerMixin {
    //filter container?
    @Inject(at = @At("HEAD"), method = "doClick", cancellable = true)
    private void doClick(int pSlotId, int pDragType, ClickType pClickType, PlayerEntity pPlayer, CallbackInfoReturnable<ItemStack> callback) {
        if(pClickType == ClickType.SWAP) {
            callback.setReturnValue(ItemStack.EMPTY);
        }
    }
}
