package net.bluebunnex.peanutbutter.mixin;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.entity.mob.GhastEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GhastEntity.class)
public class GhastEntityMixin {

    @Inject(method = "getDroppedItemId", at = @At("HEAD"), cancellable = true)
    protected void getDroppedItemId(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(Peanutbutter.ECTOGEL.asItem().id);
    }
}
