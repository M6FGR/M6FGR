package net.diego.epichammer.world.capabilities.item;


import net.minecraft.world.item.Item;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.function.Function;

public enum HammerWeaponCategories implements WeaponCategory, Function<Item, CapabilityItem.Builder> {
    HAMMER;

    final int id;

    HammerWeaponCategories() {
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
    }

    @Override
    public int universalOrdinal() {
        return this.id;
    }

    @Override
    public CapabilityItem.Builder apply(Item item) {
        return WeaponCategoryMapper.apply(item, this);
    }

    public static class Builder {
    }
}