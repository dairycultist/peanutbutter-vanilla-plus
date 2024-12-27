package net.bluebunnex.peanutbutter.mixin;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.OreFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(OreFeature.class)
public class OreFeatureMixin {

    @Shadow
    private int oreBlockId;

    @Shadow
    private int oreCount;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void oreCountMixin(int oreBlockId, int oreCount, CallbackInfo ci) {

        if (oreBlockId == Block.IRON_ORE.id)
            this.oreCount /= 2; // goes from 8 to 4
    }

    @Inject(method = "generate", at = @At("HEAD"), cancellable = true)
    public void generate(World world, Random random, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {

        // don't allow iron to generate above or at y=48
        if (oreBlockId == Block.IRON_ORE.id && y > 48)
            cir.setReturnValue(false);
    }
}
