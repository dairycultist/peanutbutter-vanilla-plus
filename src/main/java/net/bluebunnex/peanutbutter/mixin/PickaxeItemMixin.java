package net.bluebunnex.peanutbutter.mixin;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.block.Block;
import net.minecraft.item.PickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PickaxeItem.class)
public class PickaxeItemMixin {

    @Inject(method = "isSuitableFor", at = @At("HEAD"), cancellable = true)
    public void isSuitableForMixin(Block block, CallbackInfoReturnable<Boolean> cir) {

        ToolItemAccessor access = (ToolItemAccessor) this;

        if (block == Peanutbutter.HEMATITE_ORE)
            cir.setReturnValue(access.getToolMaterial().getMiningLevel() == 3);
    }
}
