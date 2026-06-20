package com.fmi.iris.init;

import com.fmi.iris.FromMyIris;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jline.utils.DiffHelper;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FromMyIris.MODID);

    public static final RegistryObject<CreativeModeTab> FMI_TAB = CREATIVE_MODE_TAB.register("fmi_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItemsInit.QUALIA_GLASS.get()))
                    .title(Component.translatable("creativetab.fmi_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItemsInit.QUALIA_GLASS.get()); // Add your items here
                    })
                    .build());
}
