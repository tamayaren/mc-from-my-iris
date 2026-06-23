package com.fmi.iris.common;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerState {
    private boolean state = false;
    private String stateName;

    public void SetState(boolean state) {
        this.state = state;
    }

    public boolean GetState() {
        return this.state;
    }

    public void SetNBTtag(CompoundTag tag) {
        tag.putBoolean(this.stateName, this.state);
    }

    public void LoadNBTtag(CompoundTag tag) {
        this.state = tag.getBoolean(this.stateName);
    }

    @SubscribeEvent
    public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(ResourceLocation.fromNamespaceAndPath("frommyiris", this.stateName), new ICapabilitySerializable<CompoundTag>() {
                private final PlayerState capability = new PlayerState();

                @Override
                public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
                    return LazyOptional.of(() -> capability).cast();
                }

                @Override
                public CompoundTag serializeNBT() {
                    CompoundTag tag = new CompoundTag();

                    capability.SetNBTtag(tag);
                    return tag;
                }

                @Override
                public void deserializeNBT(CompoundTag nbt) {
                    capability.LoadNBTtag(nbt);
                }
            });
        }
    }
}
