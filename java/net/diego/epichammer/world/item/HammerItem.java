package net.diego.epichammer.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import yesman.epicfight.world.item.WeaponItem;

public class HammerItem extends WeaponItem {
    public HammerItem(Item.Properties build, Tier materialIn) {
        super(materialIn, 9, -3.0F, build);
    }
}
