package com.google.firebase.remoteconfig;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CustomSignals {
    final Map<String, String> customSignals;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Builder {
        private Map<String, String> customSignals = new HashMap();

        public CustomSignals build() {
            return new CustomSignals(this);
        }

        public Builder put(String str, String str2) {
            this.customSignals.put(str, str2);
            return this;
        }

        public Builder put(String str, long j10) {
            this.customSignals.put(str, Long.toString(j10));
            return this;
        }

        public Builder put(String str, double d10) {
            this.customSignals.put(str, Double.toString(d10));
            return this;
        }
    }

    CustomSignals(Builder builder) {
        this.customSignals = builder.customSignals;
    }
}
