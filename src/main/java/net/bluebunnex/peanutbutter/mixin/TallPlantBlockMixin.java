package net.bluebunnex.peanutbutter.mixin;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(TallPlantBlock.class)
public class TallPlantBlockMixin {

    /**
     * @author BlueBunnex
     * @reason tall plants must drop every variety of seed
     */
    @Overwrite
    public int getDroppedItemId(int blockMeta, Random random) {

        if (random.nextInt(8) == 0) {

            switch (random.nextInt(2)) {
                case 0: return Item.SEEDS.id;
                // TODO need to replace with tomato seeds which can be planted
                case 1: return Peanutbutter.TOMATO.id;
            }
        }

        return -1;
    }
}
