package com.fmi.iris.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetSubtitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

public class GUIManipulation {
    public static void Title(ServerPlayer player,
                             ClientboundSetTitlesAnimationPacket packet,
                             @Nullable ClientboundSetSubtitleTextPacket subtitleTextPacket,
                             @Nullable ClientboundSetTitleTextPacket titleTextPacket)
    {
        player.connection.send(packet);

        assert subtitleTextPacket != null;
        player.connection.send(subtitleTextPacket != null ? subtitleTextPacket : new ClientboundSetSubtitleTextPacket(Component.literal("")));

        assert titleTextPacket != null;
        player.connection.send(titleTextPacket != null ? titleTextPacket : new ClientboundSetTitleTextPacket(Component.literal("")));
    }
}
