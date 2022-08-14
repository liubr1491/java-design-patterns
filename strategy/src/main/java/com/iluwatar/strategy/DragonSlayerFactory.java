package com.iluwatar.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DragonSlayerFactory {
    private static Map<String, DragonSlayingStrategy> map = new HashMap<>();

    static {
        map.put(StrategyKey.MELEE, new MeleeStrategy());
        map.put(StrategyKey.PROJECTILE, new ProjectileStrategy());
        map.put(StrategyKey.SPELL, new SpellStrategy());
    }

    private DragonSlayerFactory() {
    }

    public static DragonSlayingStrategy getDragonSlayingStrategy(String strategyKey) {
        if (!map.containsKey(strategyKey)) {
            return null;
        }
        return map.get(strategyKey);
    }

    public static Set<String> getAllStrategy() {
        return map.keySet();
    }

    private interface StrategyKey {
        String MELEE = "melee";
        String PROJECTILE = "Projectile";
        String SPELL = "Spell";
    }
}