package net.bluebunnex.peanutbutter.mixin;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.block.Block;
import net.minecraft.item.PickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PickaxeItem.class)
public class PickaxeItemMixin {

    @Shadow
    private static Block[] pickaxeEffectiveBlocks;

    @Inject(method = "isSuitableFor", at = @At("HEAD"), cancellable = true)
    public void isSuitableForMixin(Block block, CallbackInfoReturnable<Boolean> cir) {

        ToolItemAccessor access = (ToolItemAccessor) this;

        if (block == Peanutbutter.HEMATITE_ORE)
            cir.setReturnValue(access.getToolMaterial().getMiningLevel() == 3);
    }

    static {
        // unsure how reliable this is but I'm gonna rely on it until told otherwise

        Block[] temp = new Block[pickaxeEffectiveBlocks.length + 3];

        int i = 0;
        for (; i < pickaxeEffectiveBlocks.length; i++) {
            temp[i] = pickaxeEffectiveBlocks[i];
        }

        temp[i++] = Peanutbutter.STONE_BRICKS;
        temp[i++] = Peanutbutter.COPPER_ORE;
        temp[i++] = Peanutbutter.HEMATITE_ORE;

        pickaxeEffectiveBlocks = temp;
    }
}
