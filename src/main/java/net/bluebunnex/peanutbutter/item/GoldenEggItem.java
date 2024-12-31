package net.bluebunnex.peanutbutter.item;

import net.bluebunnex.peanutbutter.entity.GoldenEggEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateEggItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class GoldenEggItem extends TemplateEggItem {

    public GoldenEggItem(Identifier identifier) {
        super(identifier);
    }

    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {

        --stack.count;

        // would be cute if it made a glistening sound like modern amethyst
        // and the entity left a sparkling trail
        world.playSound(user, "random.bow", 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote)
            world.spawnEntity(new GoldenEggEntity(world, user));

        return stack;
    }
}
