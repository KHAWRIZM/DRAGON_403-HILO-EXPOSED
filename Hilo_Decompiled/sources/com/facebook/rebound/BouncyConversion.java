package com.facebook.rebound;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BouncyConversion {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final double mBounciness;
    private final double mBouncyFriction;
    private final double mBouncyTension;
    private final double mSpeed;

    public BouncyConversion(double d10, double d11) {
        this.mSpeed = d10;
        this.mBounciness = d11;
        double project_normal = project_normal(normalize(d11 / 1.7d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 20.0d), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0.8d);
        double project_normal2 = project_normal(normalize(d10 / 1.7d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 20.0d), 0.5d, 200.0d);
        this.mBouncyTension = project_normal2;
        this.mBouncyFriction = quadratic_out_interpolation(project_normal, b3_nobounce(project_normal2), 0.01d);
    }

    private double b3_friction1(double d10) {
        return ((Math.pow(d10, 3.0d) * 7.0E-4d) - (Math.pow(d10, 2.0d) * 0.031d)) + (d10 * 0.64d) + 1.28d;
    }

    private double b3_friction2(double d10) {
        return ((Math.pow(d10, 3.0d) * 4.4E-5d) - (Math.pow(d10, 2.0d) * 0.006d)) + (d10 * 0.36d) + 2.0d;
    }

    private double b3_friction3(double d10) {
        return ((Math.pow(d10, 3.0d) * 4.5E-7d) - (Math.pow(d10, 2.0d) * 3.32E-4d)) + (d10 * 0.1078d) + 5.84d;
    }

    private double b3_nobounce(double d10) {
        if (d10 <= 18.0d) {
            return b3_friction1(d10);
        }
        if (d10 > 18.0d && d10 <= 44.0d) {
            return b3_friction2(d10);
        }
        if (d10 > 44.0d) {
            return b3_friction3(d10);
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    private double linear_interpolation(double d10, double d11, double d12) {
        return (d12 * d10) + ((1.0d - d10) * d11);
    }

    private double normalize(double d10, double d11, double d12) {
        return (d10 - d11) / (d12 - d11);
    }

    private double project_normal(double d10, double d11, double d12) {
        return d11 + (d10 * (d12 - d11));
    }

    private double quadratic_out_interpolation(double d10, double d11, double d12) {
        return linear_interpolation((2.0d * d10) - (d10 * d10), d11, d12);
    }

    public double getBounciness() {
        return this.mBounciness;
    }

    public double getBouncyFriction() {
        return this.mBouncyFriction;
    }

    public double getBouncyTension() {
        return this.mBouncyTension;
    }

    public double getSpeed() {
        return this.mSpeed;
    }
}
