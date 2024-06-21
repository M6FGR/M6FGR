package net.diego.epichammer.skill.Guard;

import java.util.UUID;

import net.diego.epichammer.HammerForEpicFight;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.diego.epichammer.world.capabilities.item.HammerWeaponCategories;
import net.diego.epichammer.gameasset.HammerAnimations;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.guard.GuardSkill;
import static net.diego.epichammer.world.capabilities.item.WeaponCapabilityPresets.HAMMER;

@Mod.EventBusSubscriber(modid = HammerForEpicFight.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)

public class HammerGuard extends Skill {
    public static final UUID EVENT_UUID = UUID.fromString("b422f7a0-f378-11eb-9a03-0242ac703459");
    public HammerGuard(Builder<? extends Skill> builder) {
        super(builder);
    }

    public static Builder createGuardBuilder() {
        return (new GuardSkill.Builder()).setCategory(SkillCategories.GUARD).setActivateType(ActivateType.ONE_SHOT).setResource(Resource.STAMINA)
                .addGuardMotion(HammerWeaponCategories.HAMMER, (item, player) -> {
                    return HammerAnimations.HAMMER_GUARD_HIT;
                })
                .addGuardBreakMotion(HammerWeaponCategories.HAMMER, (item, player) -> {
                    return Animations.BIPED_COMMON_NEUTRALIZED;
                });
    }
    public static void registerGuard(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(new ResourceLocation(HammerForEpicFight.MOD_ID,"epichammer"), HAMMER);
    }
}
