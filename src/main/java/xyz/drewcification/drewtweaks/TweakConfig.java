package xyz.drewcification.drewtweaks;

import eu.midnightdust.lib.config.MidnightConfig;

public class TweakConfig extends MidnightConfig {
    @Comment(category = "Visual") public static Comment nameTagsHeader;
    @Entry(category = "Visual", min = 0.01, max = 0.05, isSlider = true, precision = 1000) public static float baseNameTagScale = 0.025f;
    @Entry(category = "Visual") public static boolean alphaNameTagScaling = true;

    @Comment(category = "Visual") public static Comment firstPersonHeader;
    @Entry(category = "Visual", min = 0.00, max = 10.0, isSlider = true, precision = 10) public static float armSwayIntensity = 1.0f;
    @Entry(category = "Visual", min = 0.00, max = 20.0, isSlider = true, precision = 1) public static float maxArmSwayDistance = 8.0f;

}
