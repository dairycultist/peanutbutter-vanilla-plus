package net.bluebunnex.peanutbutter.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class NetherCrownBlock extends TemplateBlock {

    public NetherCrownBlock(Identifier identifier) {
        super(identifier, Material.WOOL);

        this.setHardness(0.5f).setResistance(2000.0f).setSoundGroup(METAL_SOUND_GROUP);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public void onPlaced(World world, int x, int y, int z) {
        super.onPlaced(world, x, y, z);

        // check for T of gold underneath
        if (world.getBlockId(x, y-1, z) == Block.GOLD_BLOCK.id && world.getBlockId(x, y-2, z) == Block.GOLD_BLOCK.id) {

            boolean shouldSpawn = false;

            if (world.getBlockId(x+1, y-1, z) == Block.GOLD_BLOCK.id && world.getBlockId(x-1, y-1, z) == Block.GOLD_BLOCK.id) {

                world.setBlock(x+1, y-1, z, 0);
                world.setBlock(x-1, y-1, z, 0);

                shouldSpawn = true;

            } else if (world.getBlockId(x, y-1, z+1) == Block.GOLD_BLOCK.id && world.getBlockId(x, y-1, z-1) == Block.GOLD_BLOCK.id) {

                world.setBlock(x, y-1, z+1, 0);
                world.setBlock(x, y-1, z-1, 0);

                shouldSpawn = true;
            }

            if (shouldSpawn) {

                world.setBlock(x, y, z, 0);
                world.setBlock(x, y-1, z, 0);
                world.setBlock(x, y-2, z, 0);

                Entity entity = new PigEntity(world);
                entity.setPosition(x, y, z);
                world.spawnEntity(entity);
            }
        }
    }
}