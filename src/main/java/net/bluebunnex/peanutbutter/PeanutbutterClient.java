package net.bluebunnex.peanutbutter;

import net.bluebunnex.peanutbutter.mixin.ProjectileEntityRendererAccessor;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.util.Identifier;

public class PeanutbutterClient {

    public static ProjectileEntityRenderer GOLDEN_EGG_RENDERER = new ProjectileEntityRenderer(0);

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {

        Item.STONE_SWORD.setTextureId(
                Atlases.getGuiItems().addTexture(Identifier.of(Peanutbutter.NAMESPACE, "item/copper_sword")).index
        );

        Item.STONE_PICKAXE.setTextureId(
                Atlases.getGuiItems().addTexture(Identifier.of(Peanutbutter.NAMESPACE, "item/copper_pickaxe")).index
        );

        Item.STONE_AXE.setTextureId(
                Atlases.getGuiItems().addTexture(Identifier.of(Peanutbutter.NAMESPACE, "item/copper_axe")).index
        );

        Item.STONE_SHOVEL.setTextureId(
                Atlases.getGuiItems().addTexture(Identifier.of(Peanutbutter.NAMESPACE, "item/copper_shovel")).index
        );

        Item.STONE_HOE.setTextureId(
                Atlases.getGuiItems().addTexture(Identifier.of(Peanutbutter.NAMESPACE, "item/copper_hoe")).index
        );

        ((ProjectileEntityRendererAccessor) GOLDEN_EGG_RENDERER).setItemTextureId(
                Atlases.getGuiItems().addTexture(Identifier.of(Peanutbutter.NAMESPACE, "item/golden_egg")).index
        );
    }
}
