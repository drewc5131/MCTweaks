package xyz.drewcification.drewtweaks

import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config

@Config(name = "drewtweaks")
class TweakConfig : ConfigData {
    val alphaNameTagScaling: Boolean = true
    val baseNameTagScale = 0.025f;
}
