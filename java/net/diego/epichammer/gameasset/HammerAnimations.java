package net.diego.epichammer.gameasset;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.MoveCoordFunctions;
import yesman.epicfight.api.animation.property.AnimationProperty.ActionAnimationProperty;
import yesman.epicfight.api.animation.property.AnimationProperty.AttackAnimationProperty;
import yesman.epicfight.api.animation.property.AnimationProperty.AttackPhaseProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.api.utils.HitEntityList.Priority;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.damagesource.EpicFightDamageType;
import yesman.epicfight.world.damagesource.StunType;
import java.util.Set;

public class HammerAnimations {
    public static StaticAnimation HAMMER_GUARD_HIT;
    public static StaticAnimation HAMMER_GUARD;
    public static StaticAnimation HAMMER_AIRSLAM;
    public static StaticAnimation HAMMER_AUTO1;
    public static StaticAnimation HAMMER_AUTO2;
    public static StaticAnimation HAMMER_AUTO3;
    public static StaticAnimation HAMMER_DASH;
    public static StaticAnimation BIPED_HAMMER_IDLE;
    public static StaticAnimation BIPED_HAMMER_WALK;
    public static StaticAnimation BIPED_HAMMER_RUN;
    public static StaticAnimation SLAP_FIRST;
    public static StaticAnimation SLAP_SECOND;

    public HammerAnimations() {
    }

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put("epichammer", HammerAnimations::build);
    }

    private static void build() {
        HumanoidArmature biped = Armatures.BIPED;
        HAMMER_AIRSLAM = new AirSlashAnimation(0.1F, 0.2F, 0.5F, 0.9F, (Collider)null, biped.toolR, "biped/combat/hammer_air_attack", biped).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN);
        HAMMER_AUTO1 = (new BasicAttackAnimation(0.1F, 0.4F, 0.5F, 0.8F, (Collider)null, biped.toolR, "biped/combat/hammer_auto1", biped)).addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.SHORT);
        HAMMER_AUTO2 = (new BasicAttackAnimation(0.15F, "biped/combat/hammer_auto2", biped, new AttackAnimation.Phase[]{new AttackAnimation.Phase(0.0F, 0.7F, 0.7F, 0.7F, 0.8F, 1.4F, biped.toolR, (Collider)null), new AttackAnimation.Phase(0.2F, 0.4F, 0.5F, 0.8F, 0.8F, biped.toolR, (Collider)null)})).addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.6F).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.LONG);
        HAMMER_AUTO3 = (new BasicAttackAnimation(0.1F, 0.8F, 0.4F, 1.1F, (Collider)null, biped.toolR, "biped/combat/hammer_auto3", biped)).addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.0F).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN);
        HAMMER_DASH = (new DashAttackAnimation(0.1F, 0.1F, 0.35F, 0.4F, 1.7F, (Collider)null, biped.toolR, "biped/combat/hammer_dash", biped, false)).addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageType.FINISHER)).addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F).addProperty(ActionAnimationProperty.MOVE_VERTICAL, false).addEvents(new AnimationEvent.TimeStampedEvent[]{AnimationEvent.TimeStampedEvent.create(0.2F, Animations.ReusableSources.FRACTURE_METEOR_STRIKE, AnimationEvent.Side.SERVER).params(new Object[]{new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.toolR, 1.1, 0.55F})});
        HAMMER_GUARD = new GuardAnimation(0.05F,"biped/skill/hammer_guard", biped);
        HAMMER_GUARD_HIT = new GuardAnimation(0.05F,"biped/skill/hammer_guard_hit", biped);
        BIPED_HAMMER_IDLE = new StaticAnimation(true, "biped/living/hammer_idle", biped);
        BIPED_HAMMER_WALK = new MovementAnimation(true, "biped/living/hammer_walk", biped);
        BIPED_HAMMER_RUN = new MovementAnimation(true, "biped/living/hammer_run", biped);
        SLAP_FIRST = (new AttackAnimation(0.1F, 0.25F, 0.3F, 0.4F, 0.8F, (Collider)null, biped.torso, "biped/skill/slap_first", biped)).addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AttackPhaseProperty.HIT_PRIORITY, Priority.TARGET).addProperty(ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_LOCROT_TARGET).addProperty(ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_LOCROT_TARGET).addProperty(ActionAnimationProperty.CANCELABLE_MOVE, false).addState(EntityState.MOVEMENT_LOCKED, true);
        SLAP_SECOND = (new AttackAnimation(0.1F, 0.0F, 0.5F, 1.2F, 0.95F, (Collider)null, biped.toolR, "biped/skill/slap_second", biped)).addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addProperty(AttackPhaseProperty.HIT_SOUND, (SoundEvent)EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(ActionAnimationProperty.CANCELABLE_MOVE, false).addState(EntityState.MOVEMENT_LOCKED, true);
    }
}
