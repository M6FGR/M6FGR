package net.diego.epichammer.gameasset;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;

public class HammerColliderPreset {
    private static final BiMap<ResourceLocation, Collider> PRESETS = HashBiMap.create();
    public static final Collider HAMMER = registerCollider(new ResourceLocation("epichammer", "hammer"), new MultiOBBCollider(4, 1.2, 0.9, 1.4, 0.7, 0.6, -1.0));

    public HammerColliderPreset() {
    }

    public static Collider registerCollider(ResourceLocation rl, Collider collider) {
        if (PRESETS.containsKey(rl)) {
            throw new IllegalStateException("Collider named " + rl + " already registered.");
        } else {
            PRESETS.put(rl, collider);
            return collider;
        }
    }
}