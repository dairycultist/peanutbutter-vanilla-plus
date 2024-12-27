package net.bluebunnex.peanutbutter;

import net.bluebunnex.peanutbutter.block.PlantTemplateBlock;
import net.bluebunnex.peanutbutter.item.SlimeHammer;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

import java.util.Random;

import static net.minecraft.block.Block.STONE_SOUND_GROUP;

public class Peanutbutter {

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Item COPPER_INGOT;
    public static Item SLIME_HAMMER;

    public static Block DAHLIA;
    public static Block STONE_BRICKS;
    public static Block COPPER_ORE;
    public static Block HEMATITE_ORE;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {

        SLIME_HAMMER = new SlimeHammer(NAMESPACE.id("slime_hammer"))
                .setTranslationKey(NAMESPACE, "slime_hammer");

        COPPER_INGOT = new TemplateItem(NAMESPACE.id("copper_ingot"))
                .setTranslationKey(NAMESPACE, "copper_ingot");

        // TODO either add copper armor or replace chainmail in ArmorRecipes
    }

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {

        DAHLIA = new PlantTemplateBlock(NAMESPACE.id("dahlia"))
                .setTranslationKey(NAMESPACE, "dahlia");

        STONE_BRICKS = new TemplateBlock(NAMESPACE.id("stone_bricks"), Material.STONE)
                .setHardness(1.5f) // copied from stone
                .setResistance(10.0f)
                .setSoundGroup(STONE_SOUND_GROUP)
                .setTranslationKey(NAMESPACE, "stone_bricks");

        COPPER_ORE = new TemplateBlock(NAMESPACE.id("copper_ore"), Material.STONE)
                .setHardness(2.0f) // iron is 3.0F
                .setResistance(10.0f)
                .setSoundGroup(STONE_SOUND_GROUP)
                .setTranslationKey(NAMESPACE, "copper_ore");

        HEMATITE_ORE = new TemplateBlock(NAMESPACE.id("hematite_ore"), Material.STONE)
                .setHardness(10.0f) // copied from obsidian
                .setResistance(2000.0f)
                .setSoundGroup(STONE_SOUND_GROUP)
                .setTranslationKey(NAMESPACE, "hematite_ore");
    }

    public static ItemStack getRareLoot(Random random) {

        return new ItemStack(SLIME_HAMMER);
    }
}
