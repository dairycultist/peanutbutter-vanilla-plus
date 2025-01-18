package net.bluebunnex.peanutbutter.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class EctogelBlock extends TemplateBlock {

    public EctogelBlock(Identifier identifier) {
        super(identifier, Material.SPONGE);

        this.setSoundGroup(EctogelBlock.GRAVEL_SOUND_GROUP);
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return EctogelBlock.SOUL_SAND.getCollisionShape(world, x, y, z);
    }

    @Override
    public void onEntityCollision(World world, int x, int y, int z, Entity entity) {

        double speed = MathHelper.sqrt(entity.velocityX * entity.velocityX + entity.velocityZ * entity.velocityZ);

        if (speed > 0.2 && speed < 0.4) {

            entity.velocityX *= 1.5;
            entity.velocityZ *= 1.5;
        }
    }
}
