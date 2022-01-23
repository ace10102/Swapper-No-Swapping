package com.Spoilers.noswapping;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod("noswapping")
public class NoSwapping {

    public static final String MOD_ID = "noswapping";
    
    public NoSwapping() {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            //MinecraftForge.EVENT_BUS.register(new SwapStopperClient()); make visual feedback
        });
    }
}
