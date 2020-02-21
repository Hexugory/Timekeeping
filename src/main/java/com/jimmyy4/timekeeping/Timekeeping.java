package com.jimmyy4.timekeeping;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
        modid = Timekeeping.MOD_ID,
        name = Timekeeping.MOD_NAME,
        version = Timekeeping.VERSION,
        serverSideOnly = true,
        acceptableRemoteVersions = "*"
)
public class Timekeeping {

    public static final String MOD_ID = "timekeeping";
    public static final String MOD_NAME = "Timekeeping";
    public static final String VERSION = "2019.3-1.3.2";

    @Mod.EventHandler
    public void serverStartingEvent(FMLServerStartingEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
