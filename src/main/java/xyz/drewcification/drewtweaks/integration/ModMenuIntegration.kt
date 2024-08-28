package xyz.drewcification.drewtweaks.integration

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import me.shedaniel.autoconfig.AutoConfig
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import xyz.drewcification.drewtweaks.TweakConfig

@Environment(EnvType.CLIENT)
class ModMenuIntegration: ModMenuApi{

    public override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory {p -> AutoConfig.getConfigScreen(TweakConfig::class.java, p).get();}
    }
}