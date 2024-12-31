package net.bluebunnex.peanutbutter.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GoldenEggEntity extends EggEntity {

    public GoldenEggEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    @Override
    public void tick() {

        Vec3d start = Vec3d.createCached(this.x, this.y, this.z);
        Vec3d end = Vec3d.createCached(this.x + this.velocityX, this.y + this.velocityY, this.z + this.velocityZ);
        HitResult hit = this.world.raycast(start, end);

        // TODO if you hit an entity it still spawns a normal chicken since that's only checked in the super call, not here

        if (hit != null) {

            if (!this.world.isRemote && this.random.nextInt(8) == 0) {

                CockatriceEntity entity = new CockatriceEntity(this.world);
                entity.setPositionAndAnglesKeepPrevAngles(this.x, this.y, this.z, this.yaw, 0.0F);
                this.world.spawnEntity(entity);
            }

            for (int i = 0; i < 8; i++) {
                this.world.addParticle("snowballpoof", this.x, this.y, this.z, 0.0, 0.0, 0.0);
            }

            this.markDead();

        } else {

            super.tick();
        }
    }


}
