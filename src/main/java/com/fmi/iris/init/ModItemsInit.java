package com.fmi.iris.init;

import com.fmi.iris.FromMyIris;
import com.fmi.iris.item.QualiaGlass;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemsInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FromMyIris.MODID);

    public static final RegistryObject<Item> QUALIA_GLASS = ITEMS.register("qualia_glass", () -> new QualiaGlass(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}