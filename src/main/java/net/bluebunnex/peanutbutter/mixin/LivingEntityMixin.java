package net.bluebunnex.peanutbutter.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.GhastEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @ModifyVariable(
            method = "dropItems",
            at = @At(value = "INVOKE_ASSIGN", target = "Ljava/util/Random;nextInt(I)I"),
            index = 2
    )
    private int increaseDropCountForGhast(int original) {

        return (Object) this instanceof GhastEntity ? ((int) (Math.random() * 21) + 12) : original + 1;
    }
}
