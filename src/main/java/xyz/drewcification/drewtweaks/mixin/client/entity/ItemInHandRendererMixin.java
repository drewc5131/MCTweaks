package xyz.drewcification.drewtweaks.mixin.client.entity;


import net.minecraft.client.renderer.ItemInHandRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import xyz.drewcification.drewtweaks.TweakConfig;

@Mixin(ItemInHandRenderer.class)
public abstract class ItemInHandRendererMixin {
    @ModifyArg(
            method = "renderHandsWithItems",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/math/Axis;rotationDegrees(F)Lorg/joml/Quaternionf;"
            )
    )
    private float fpArm$adjustSway(float degrees){
        return Math.clamp(degrees * TweakConfig.armSwayIntensity, -TweakConfig.maxArmSwayDistance, TweakConfig.maxArmSwayDistance);
    }
}
