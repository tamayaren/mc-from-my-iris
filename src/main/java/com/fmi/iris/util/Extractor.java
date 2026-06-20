package com.fmi.iris.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class Extractor {
    public static ServerPlayer GetServerPlayer(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            return serverPlayer;
        }

        return null;
    }
}
