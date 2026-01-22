package com.facebook.rebound;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class OrigamiValueConverter {
    public static double frictionFromOrigamiValue(double d10) {
        return d10 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : 25.0d + ((d10 - 8.0d) * 3.0d);
    }

    public static double origamiValueFromFriction(double d10) {
        return d10 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : 8.0d + ((d10 - 25.0d) / 3.0d);
    }

    public static double origamiValueFromTension(double d10) {
        return d10 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : 30.0d + ((d10 - 194.0d) / 3.62d);
    }

    public static double tensionFromOrigamiValue(double d10) {
        return d10 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : 194.0d + ((d10 - 30.0d) * 3.62d);
    }
}
