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
}
