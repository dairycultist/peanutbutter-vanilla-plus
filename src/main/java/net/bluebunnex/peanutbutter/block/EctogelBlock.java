package net.bluebunnex.peanutbutter.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.IceBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.template.block.TemplateTranslucentBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class EctogelBlock extends TemplateTranslucentBlock {

    public EctogelBlock(Identifier identifier) {
        super(identifier, 0, Material.SPONGE, false);

        this.setSoundGroup(EctogelBlock.GRAVEL_SOUND_GROUP);
    }

    // stolen from IceBlock
    @Environment(EnvType.CLIENT)
    public int getRenderLayer() { return 1; }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return EctogelBlock.SOUL_SAND.getCollisionShape(world, x, y, z);
    }

    @Override
    public void onEntityCollision(World world, int x, int y, int z, Entity entity) {

        if (entity.isSneaking())
            return;

        double speed = MathHelper.sqrt(entity.velocityX * entity.velocityX + entity.velocityZ * entity.velocityZ);

        if (speed > 0.2 && speed < 0.4) {

            entity.velocityX *= 1.5;
            entity.velocityZ *= 1.5;
        }
    }
}
