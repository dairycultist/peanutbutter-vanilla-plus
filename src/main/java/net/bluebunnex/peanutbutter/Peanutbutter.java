package net.bluebunnex.peanutbutter;

import net.bluebunnex.peanutbutter.block.PlantTemplateBlock;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

import static net.minecraft.block.Block.STONE_SOUND_GROUP;

public class Peanutbutter {

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Block DAHLIA;
    public static Block STONE_BRICKS;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {

    }

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {

        DAHLIA = new PlantTemplateBlock(NAMESPACE.id("dahlia"))
                .setTranslationKey(NAMESPACE, "dahlia");

        STONE_BRICKS = new TemplateBlock(NAMESPACE.id("stone_bricks"), Material.STONE)
                .setHardness(1.5F / 10) // I think this function is bugged, its input is treated like x10
                .setResistance(10.0F)
                .setSoundGroup(STONE_SOUND_GROUP)
                .setTranslationKey(NAMESPACE, "stone_bricks");
    }
}
