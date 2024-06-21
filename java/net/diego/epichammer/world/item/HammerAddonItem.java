package net.diego.epichammer.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HammerAddonItem {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> DIAMOND_HAMMER;
    public static final RegistryObject<Item> NETHERITE_HAMMER;

    public HammerAddonItem() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "epichammer");

        DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () -> {
            return new HammerItem(new Item.Properties(), Tiers.DIAMOND);
        });
        NETHERITE_HAMMER = ITEMS.register("netherite_hammer", () -> {
            return new HammerItem((new Item.Properties()).requiredFeatures(), Tiers.NETHERITE);
        });
    }
}

