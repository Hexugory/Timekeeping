package com.jimmyy4.timekeeping;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventHandler {
    public void checkPlayers(MinecraftServer server, int playerCount){
        WorldServer world = server.getWorld(0);
        System.out.println("[Timekeeping] There are currently " + playerCount + " players online.");

        if(playerCount > 0){
            world.getGameRules().setOrCreateGameRule("doDaylightCycle", "true");
        }
        else{
            world.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
        }
    }



    @SubscribeEvent
    public void playerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        MinecraftServer server = event.player.getServer();
        checkPlayers(server, server.getCurrentPlayerCount());
    }

    @SubscribeEvent
    public void playerLeave(PlayerEvent.PlayerLoggedOutEvent event) {
        MinecraftServer server = event.player.getServer();
        checkPlayers(server, server.getCurrentPlayerCount()-1);
    }

    @SubscribeEvent
    public void worldLoad(WorldEvent.Load event) {
        MinecraftServer server = event.getWorld().getMinecraftServer();
        checkPlayers(server, server.getCurrentPlayerCount());
    }

    @SubscribeEvent
    public void worldUnload(WorldEvent.Unload event) {
        MinecraftServer server = event.getWorld().getMinecraftServer();
        checkPlayers(server, server.getCurrentPlayerCount());
    }
}
