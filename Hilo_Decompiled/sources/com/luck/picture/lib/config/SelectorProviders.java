package com.luck.picture.lib.config;

import java.util.LinkedList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SelectorProviders {
    private static volatile SelectorProviders selectorProviders;
    private final LinkedList<SelectorConfig> selectionConfigsQueue = new LinkedList<>();

    public static SelectorProviders getInstance() {
        if (selectorProviders == null) {
            synchronized (SelectorProviders.class) {
                try {
                    if (selectorProviders == null) {
                        selectorProviders = new SelectorProviders();
                    }
                } finally {
                }
            }
        }
        return selectorProviders;
    }

    public void addSelectorConfigQueue(SelectorConfig selectorConfig) {
        this.selectionConfigsQueue.add(selectorConfig);
    }

    public void destroy() {
        SelectorConfig selectorConfig = getSelectorConfig();
        if (selectorConfig != null) {
            selectorConfig.destroy();
            this.selectionConfigsQueue.remove(selectorConfig);
        }
    }

    public SelectorConfig getSelectorConfig() {
        if (this.selectionConfigsQueue.size() > 0) {
            return this.selectionConfigsQueue.getLast();
        }
        return new SelectorConfig();
    }

    public void reset() {
        for (int i10 = 0; i10 < this.selectionConfigsQueue.size(); i10++) {
            SelectorConfig selectorConfig = this.selectionConfigsQueue.get(i10);
            if (selectorConfig != null) {
                selectorConfig.destroy();
            }
        }
        this.selectionConfigsQueue.clear();
    }
}
