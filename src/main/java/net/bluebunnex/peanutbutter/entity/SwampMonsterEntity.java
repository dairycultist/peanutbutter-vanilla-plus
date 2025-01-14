package net.bluebunnex.peanutbutter.entity;

import net.minecraft.entity.mob.MonsterEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class SwampMonsterEntity extends MonsterEntity {

    // TODO spawn in swamps
    // TODO have warden-like ears
    // TODO much stronger than a zombie, mid-game enemy
    // TODO custom sounds, basically zombie sounds with gurgling?

    public SwampMonsterEntity(World world) {
        super(world);

        // https://www.minecraftskins.com/skin/22880727/swampy-creature/
        this.texture = "/assets/peanutbutter/stationapi/textures/entity/swamp_monster.png";
    }

    protected String getRandomSound() {
        return "mob.zombie";
    }

    protected String getHurtSound() {
        return "mob.zombiehurt";
    }

    protected String getDeathSound() {
        return "mob.zombiedeath";
    }

    protected int getDroppedItemId() {
        return Item.RAW_FISH.id;
    }
}
