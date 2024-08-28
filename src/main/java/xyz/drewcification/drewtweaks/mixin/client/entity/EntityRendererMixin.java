package xyz.drewcification.drewtweaks.mixin.client.entity;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import xyz.drewcification.drewtweaks.TweakConfig;

@Mixin(EntityRenderer.class)
public abstract class EntityRendererMixin{
    @Shadow @Final
    protected EntityRenderDispatcher entityRenderDispatcher;

    /**
     * Overrides EntityRenderer.renderNameTag to implement scaling similar to
     * alpha versions of Minecraft
     */
    @WrapOperation(
            method = "renderNameTag",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V"
            )
    )

    private void nameTag$setScale(PoseStack poseStack, float x, float y, float z, Operation<Void> operation, Entity entity){
        TweakConfig conf = AutoConfig.getConfigHolder(TweakConfig.class).getConfig();
        float scale = conf.getBaseNameTagScale();
        if(conf.getAlphaNameTagScaling()) {
            double distance = this.entityRenderDispatcher.distanceToSqr(entity);
            scale *= (float) (Math.sqrt(Math.sqrt(distance)) / 2.0D);
        }
        operation.call(poseStack, scale, -scale, -scale);
    }
}
