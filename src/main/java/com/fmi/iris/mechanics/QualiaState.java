package com.fmi.iris.mechanics;

import com.fmi.iris.common.PlayerState;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class QualiaState extends PlayerState {
    private boolean state = false;
    private String stateName = "QualiaState";
}
