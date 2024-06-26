package net.diego.epichammer.world.capabilities.item;

import java.util.Map;
import java.util.function.Function;
import com.google.common.collect.Maps;
import net.diego.epichammer.gameasset.HammerSkills;
import net.diego.epichammer.HammerForEpicFight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.diego.epichammer.gameasset.HammerColliderPreset;
import net.diego.epichammer.gameasset.HammerAnimations;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.CapabilityItem.Styles;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

@Mod.EventBusSubscriber(modid = HammerForEpicFight.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)
public class WeaponCapabilityPresets {
    public static final Function<Item, CapabilityItem.Builder> HAMMER = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .styleProvider((playerpatch) -> Styles.TWO_HAND)
                .category(CapabilityItem.WeaponCategories.GREATSWORD)
                .collider(HammerColliderPreset.HAMMER)
                .swingSound(EpicFightSounds.WHOOSH_BIG.get())
                .hitSound(EpicFightSounds.BLUNT_HIT.get())
                .canBePlacedOffhand(false)
                .newStyleCombo(Styles.TWO_HAND, HammerAnimations.HAMMER_AUTO1, HammerAnimations.HAMMER_AUTO2, HammerAnimations.HAMMER_AUTO3, HammerAnimations.HAMMER_DASH, HammerAnimations.HAMMER_AIRSLAM)
                .innateSkill(Styles.TWO_HAND, (itemstack) -> { return HammerSkills.SLAM;})
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.IDLE, HammerAnimations.BIPED_HAMMER_IDLE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.WALK, HammerAnimations.BIPED_HAMMER_WALK)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.CHASE, HammerAnimations.BIPED_HAMMER_WALK)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.RUN, HammerAnimations.BIPED_HAMMER_RUN)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.JUMP, HammerAnimations.BIPED_HAMMER_IDLE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.KNEEL, HammerAnimations.BIPED_HAMMER_WALK)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.SNEAK, HammerAnimations.BIPED_HAMMER_WALK)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.SWIM, HammerAnimations.BIPED_HAMMER_IDLE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.BLOCK, HammerAnimations.HAMMER_GUARD);

        return builder;
    };

    public WeaponCapabilityPresets() {
    }

    private static boolean CheckPlayer(LivingEntityPatch<?> playerPatch) {
        return playerPatch.getOriginal().getType() != EntityType.PLAYER;
    }

    private static final Map<String, Function<Item, CapabilityItem.Builder>> PRESETS = Maps.newHashMap();

    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(new ResourceLocation(HammerForEpicFight.MOD_ID,"epichammer"), HAMMER);
    }
}