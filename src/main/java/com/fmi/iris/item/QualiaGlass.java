package com.fmi.iris.item;

import com.fmi.iris.init.ModSounds;
import com.fmi.iris.util.Extractor;
import com.fmi.iris.util.GUIManipulation;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetSubtitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag; // Import CompoundTag
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class QualiaGlass extends Item {
    private static final String TAG_TOGGLED_STATE = "QualiaGlassToggled";

    public QualiaGlass(Properties itemProperties) {
        super(itemProperties);
    }

    public static boolean getToggledState(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.getBoolean(TAG_TOGGLED_STATE);
    }

    public static void setToggledState(ItemStack stack, boolean toggled) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putBoolean(TAG_TOGGLED_STATE, toggled);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (!level.isClientSide()) {
            player.getCooldowns().addCooldown(this, 40);

            boolean currentState = getToggledState(itemStack);
            setToggledState(itemStack, !currentState);

            SoundEvent sound = ModSounds.get(currentState ? "qualia_glass_toggle_on" : "qualia_glass_toggle_off");
            level.playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundSource.AMBIENT, 1.0F, 1.0F);

            player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 10, 0));
            player.sendSystemMessage(Component.literal("QGLASS_STATE_" + Boolean.toString(currentState).toUpperCase()));

            if (currentState) {
                Minecraft.getInstance().getMusicManager().stopPlaying();
            }
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}
