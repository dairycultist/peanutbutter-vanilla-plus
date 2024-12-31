package net.bluebunnex.peanutbutter.mixin;

import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ProjectileEntityRenderer.class)
public interface ProjectileEntityRendererAccessor {

    @Accessor
    void setItemTextureId(int value);
}
