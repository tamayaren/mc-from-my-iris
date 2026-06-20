package com.fmi.iris.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, "frommyiris");

    private static final Map<String, RegistryObject<SoundEvent>> SOUND_MAP = new HashMap<String, RegistryObject<SoundEvent>>();

    static {
        String[] soundNames = {
                "qualia_glass_toggle_on",
                "qualia_glass_toggle_off"
        };

        for (String name : soundNames) {
            RegistryObject<SoundEvent> sound = SOUND_EVENTS.register(
                    name,
                    () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("frommyiris", name))
            );
            SOUND_MAP.put(name, sound);
        }
    }

    public static SoundEvent get(String name) {
        return SOUND_MAP.get(name).get();
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
