package net.bluebunnex.peanutbutter.mixin;

import net.bluebunnex.peanutbutter.entity.CockatriceEntity;
import net.minecraft.world.biome.EntitySpawnGroup;
import net.minecraft.world.biome.HellBiome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HellBiome.class)
public class HellBiomeMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    public void cat(CallbackInfo ci) {

        ((BiomeAccessor) this).getSpawnablePassive().add(new EntitySpawnGroup(CockatriceEntity.class, 10));
    }
}
