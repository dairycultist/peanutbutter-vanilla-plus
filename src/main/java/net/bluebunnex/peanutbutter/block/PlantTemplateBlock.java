package net.bluebunnex.peanutbutter.block;

import net.minecraft.block.PlantBlock;
import net.modificationstation.stationapi.api.template.block.BlockTemplate;
import net.modificationstation.stationapi.api.util.Identifier;

public class PlantTemplateBlock extends PlantBlock implements BlockTemplate {

    public PlantTemplateBlock(Identifier identifier) {
        super(BlockTemplate.getNextId(), 0);

        BlockTemplate.onConstructor(this, identifier); // important

        this.setSoundGroup(DIRT_SOUND_GROUP);

        this.setResistance(0.0f);
        this.setHardness(0.0f);
    }
}
