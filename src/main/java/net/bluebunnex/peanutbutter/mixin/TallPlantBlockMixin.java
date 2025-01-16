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
                case 1: return Peanutbutter.TOMATO_SEEDS.id;
            }
        }

        return -1;
    }
}
