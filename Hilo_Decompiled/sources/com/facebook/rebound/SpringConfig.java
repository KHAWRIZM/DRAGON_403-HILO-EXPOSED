package com.facebook.rebound;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SpringConfig {
    public static SpringConfig defaultConfig = fromOrigamiTensionAndFriction(40.0d, 7.0d);
    public double friction;
    public double tension;

    public SpringConfig(double d10, double d11) {
        this.tension = d10;
        this.friction = d11;
    }

    public static SpringConfig fromBouncinessAndSpeed(double d10, double d11) {
        BouncyConversion bouncyConversion = new BouncyConversion(d11, d10);
        return fromOrigamiTensionAndFriction(bouncyConversion.getBouncyTension(), bouncyConversion.getBouncyFriction());
    }

    public static SpringConfig fromOrigamiTensionAndFriction(double d10, double d11) {
        return new SpringConfig(OrigamiValueConverter.tensionFromOrigamiValue(d10), OrigamiValueConverter.frictionFromOrigamiValue(d11));
    }
}
