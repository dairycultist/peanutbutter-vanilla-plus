package net.bluebunnex.peanutbutter.entity;

import net.minecraft.entity.mob.MonsterEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class SwampMonsterEntity extends MonsterEntity {

    // TODO have warden-like ears
    // TODO custom sounds, basically zombie sounds with gurgling?

    // maybe override canSpawn() to make it spawn in daylight...?

    public SwampMonsterEntity(World world) {
        super(world);

        // https://www.minecraftskins.com/skin/22880727/swampy-creature/
        this.texture = "/assets/peanutbutter/stationapi/textures/entity/swamp_monster.png";
        
        // much stronger than a zombie, mid-game enemy
        this.attackDamage = 6;

        this.maxHealth = 40;
        this.health    = 40;
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
