package net.diego.epichammer;

import com.mojang.logging.LogUtils;
import net.diego.epichammer.gameasset.HammerAnimations;
import net.diego.epichammer.skill.weaponinnate.SlamSkill;
import net.diego.epichammer.skill.HammerSkillDataKeys;
import net.diego.epichammer.world.capabilities.item.HammerWeaponCategories;
import net.diego.epichammer.world.item.HammerAddonItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import yesman.epicfight.world.capabilities.item.WeaponCategory;


@Mod("epichammer")
public class HammerForEpicFight {
    public static final String MOD_ID = "epichammer";
    public static final Logger LOGGER = LogUtils.getLogger();

    public HammerForEpicFight() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        WeaponCategory.ENUM_MANAGER.registerEnumCls("epichammer", HammerWeaponCategories.class);
        SlamSkill.createBuilder();
        HammerAddonItem.ITEMS.register(bus);
        HammerSkillDataKeys.DATA_KEYS.register(bus);
        bus.addListener(HammerAnimations::registerAnimations);
        bus.addListener(this::addCreative);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void clientSetup(Event event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.COMBAT){
            event.accept(HammerAddonItem.DIAMOND_HAMMER);
            event.accept(HammerAddonItem.NETHERITE_HAMMER);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}

