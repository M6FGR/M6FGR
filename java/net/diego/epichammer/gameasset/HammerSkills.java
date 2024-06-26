package net.diego.epichammer.gameasset;

import java.util.Set;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.diego.epichammer.skill.weaponinnate.SlamSkill;
import yesman.epicfight.api.animation.property.AnimationProperty.AttackPhaseProperty;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.damagesource.EpicFightDamageType;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;

@EventBusSubscriber(
        modid = "epichammer",
        bus = Bus.FORGE
)
public class HammerSkills {
    public static Skill SLAM;

    public HammerSkills() {
    }

    public static void registerSkills() {
        SkillManager.register(SlamSkill::new, WeaponInnateSkill.createWeaponInnateBuilder(), "epichammer", "slamskill");
    }

    public static void buildSkillEvent(SkillBuildEvent onBuild) {
        WeaponInnateSkill HammerSkill = (WeaponInnateSkill) onBuild.build("epichammer", "hammerslamskill");
        HammerSkill.newProperty().addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(1.0F)).addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(2.0F)).addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageType.WEAPON_INNATE)).newProperty().addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(2.0F)).addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(16.0F)).addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0]))).addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageType.WEAPON_INNATE)).addProperty(AttackPhaseProperty.HIT_SOUND, (SoundEvent)EpicFightSounds.WHOOSH_BIG.get());
        SLAM = HammerSkill;}}


