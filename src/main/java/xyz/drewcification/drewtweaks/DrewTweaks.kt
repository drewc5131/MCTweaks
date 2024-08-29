package xyz.drewcification.drewtweaks

import eu.midnightdust.lib.config.MidnightConfig
import net.fabricmc.api.ModInitializer

class DrewTweaks : ModInitializer {
    override fun onInitialize() {
        MidnightConfig.init("drewtweaks", TweakConfig::class.java)
    }
}
