package net.bluebunnex.peanutbutter.entity;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class CockatriceEntity extends ChickenEntity {

    public CockatriceEntity(World world) {
        super(world);

        this.texture = "/assets/peanutbutter/stationapi/textures/entity/cockatrice.png";

        this.fireImmune = true;
    }

    @Override
    protected void tickLiving() {

        // glimmer particle would maybe work better, but idk how to add custom particles
        if (this.random.nextInt(8) == 0) {

            world.addParticle(
                    "flame",
                    this.x + this.random.nextDouble(-0.5, 0.5),
                    this.y + 0.5,
                    this.z + this.random.nextDouble(-0.5, 0.5),
                    0.0,
                    0.05,
                    0.0
            );
        }

        super.tickLiving();
    }

    @Override
    public ItemEntity dropItem(int id, int amount) {

        if (id == Item.EGG.id)
            id = Peanutbutter.GOLDEN_EGG.id;

        return super.dropItem(id, amount);
    }

    @Override
    protected int getDroppedItemId() {
        return Peanutbutter.GOLDEN_FEATHER.id;
    }

    @Override
    public boolean canSpawn() {
        return this.world.canSpawnEntity(this.boundingBox) && this.world.getEntityCollisions(this, this.boundingBox).isEmpty() && !this.world.isBoxSubmergedInFluid(this.boundingBox);
    }

    @Override
    protected String getRandomSound() { return "peanutbutter:entity.cockatrice.coo"; }

    protected String getHurtSound() {
        return "peanutbutter:entity.cockatrice.hurt";
    }

    protected String getDeathSound() {
        return "peanutbutter:entity.cockatrice.hurt";
    }
}
