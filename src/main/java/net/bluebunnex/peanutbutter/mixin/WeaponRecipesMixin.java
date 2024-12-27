package net.bluebunnex.peanutbutter.mixin;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.recipe.WeaponRecipes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WeaponRecipes.class)
public class WeaponRecipesMixin {

    @Shadow
    private Object[][] items;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void registerRecipesMixin(CallbackInfo ci) {

        this.items[0][1] = Peanutbutter.COPPER_INGOT;
    }
}
