package net.bluebunnex.peanutbutter.block;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.block.PlantBlock;
import net.modificationstation.stationapi.api.template.block.BlockTemplate;
import net.modificationstation.stationapi.api.util.Identifier;

public class FlowerBlock extends PlantBlock implements BlockTemplate {

    public FlowerBlock(Identifier identifier) {
        super(BlockTemplate.getNextId(), 0);
        BlockTemplate.onConstructor(this, identifier);

        this.setTranslationKey(Peanutbutter.NAMESPACE, identifier.path);

        this.setSoundGroup(DIRT_SOUND_GROUP);

        this.setResistance(0.0f);
        this.setHardness(0.0f);
    }
}
