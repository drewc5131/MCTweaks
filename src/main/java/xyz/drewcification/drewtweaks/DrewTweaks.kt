package xyz.drewcification.drewtweaks

import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.serializer.ConfigSerializer
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer
import net.fabricmc.api.ModInitializer

class DrewTweaks : ModInitializer {
    override fun onInitialize() {
        AutoConfig.register<TweakConfig?>(TweakConfig::class.java,
            ConfigSerializer.Factory {
                definition: Config?, configClass: Class<TweakConfig?>? -> Toml4jConfigSerializer(definition, configClass) }
        )
    }
}
