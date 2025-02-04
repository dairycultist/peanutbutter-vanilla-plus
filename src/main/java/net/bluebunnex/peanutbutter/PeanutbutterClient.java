package net.bluebunnex.peanutbutter;

import net.bluebunnex.peanutbutter.entity.CockatriceEntity;
import net.bluebunnex.peanutbutter.entity.GoldenEggEntity;
import net.bluebunnex.peanutbutter.entity.SwampMonsterEntity;
import net.bluebunnex.peanutbutter.mixin.ProjectileEntityRendererAccessor;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.render.entity.ChickenEntityRenderer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;
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

        Peanutbutter.TOMATO_CROP.textureId = Atlases.getTerrain().addTexture(Identifier.of(Peanutbutter.NAMESPACE, "block/tomato_crop0")).index;
        for (int i=1; i<8; i++)
            Atlases.getTerrain().addTexture(Identifier.of(Peanutbutter.NAMESPACE, "block/tomato_crop" + i));
    }

    @EventListener
    public void registerEntityRenderer(EntityRendererRegisterEvent event) {

        event.renderers.put(CockatriceEntity.class, new ChickenEntityRenderer(new ChickenEntityModel(), 0.3f));
        event.renderers.put(GoldenEggEntity.class, PeanutbutterClient.GOLDEN_EGG_RENDERER);

        event.renderers.put(SwampMonsterEntity.class, new LivingEntityRenderer(new BipedEntityModel(), 0.5f));
    }
}
