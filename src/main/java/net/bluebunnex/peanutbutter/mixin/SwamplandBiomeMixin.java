package net.bluebunnex.peanutbutter.mixin;

import net.bluebunnex.peanutbutter.entity.SwampMonsterEntity;
import net.minecraft.world.biome.EntitySpawnGroup;
import net.minecraft.world.biome.SwamplandBiome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SwamplandBiome.class)
public class SwamplandBiomeMixin {

    @SuppressWarnings("unchecked")
    @Inject(method = "<init>", at = @At("TAIL"))
    public void cat(CallbackInfo ci) {

        ((BiomeAccessor) this).getSpawnableMonsters().add(new EntitySpawnGroup(SwampMonsterEntity.class, 12));
    }
}
