package net.diego.epichammer.skill;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.diego.epichammer.skill.weaponinnate.SlamSkill;
import yesman.epicfight.skill.BasicAttack;
import yesman.epicfight.skill.SkillDataKey;

public class HammerSkillDataKeys {
    public static final DeferredRegister<SkillDataKey<?>> DATA_KEYS = DeferredRegister.create(new ResourceLocation("epicfight", "skill_data_keys"), "epichammer");
    public static final RegistryObject<SkillDataKey<Integer>> COMBO_COUNTER;
    public static final RegistryObject<SkillDataKey<Integer>> LAST_HIT_COUNT;

    public HammerSkillDataKeys() {
    }

    static {
        COMBO_COUNTER = DATA_KEYS.register("combo_counter", () -> {
            return SkillDataKey.createIntKey(0, false, new Class[]{BasicAttack.class, SlamSkill.class});
        });
        LAST_HIT_COUNT = DATA_KEYS.register("last_hit_count", () -> {
            return SkillDataKey.createIntKey(0, false, new Class[]{SlamSkill.class});
        });
    }
}
