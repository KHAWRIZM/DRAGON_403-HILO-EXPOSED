package com.facebook.rebound;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Spring {
    private static int ID = 0;
    private static final double MAX_DELTA_TIME_SEC = 0.064d;
    private static final double SOLVER_TIMESTEP_SEC = 0.001d;
    private final PhysicsState mCurrentState;
    private double mEndValue;
    private final String mId;
    private boolean mOvershootClampingEnabled;
    private final PhysicsState mPreviousState;
    private SpringConfig mSpringConfig;
    private final BaseSpringSystem mSpringSystem;
    private double mStartValue;
    private final PhysicsState mTempState;
    private boolean mWasAtRest = true;
    private double mRestSpeedThreshold = 0.005d;
    private double mDisplacementFromRestThreshold = 0.005d;
    private CopyOnWriteArraySet<SpringListener> mListeners = new CopyOnWriteArraySet<>();
    private double mTimeAccumulator = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class PhysicsState {
        double position;
        double velocity;

        private PhysicsState() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Spring(BaseSpringSystem baseSpringSystem) {
        this.mCurrentState = new PhysicsState();
        this.mPreviousState = new PhysicsState();
        this.mTempState = new PhysicsState();
        if (baseSpringSystem != null) {
            this.mSpringSystem = baseSpringSystem;
            StringBuilder sb = new StringBuilder();
            sb.append("spring:");
            int i10 = ID;
            ID = i10 + 1;
            sb.append(i10);
            this.mId = sb.toString();
            setSpringConfig(SpringConfig.defaultConfig);
            return;
        }
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    private double getDisplacementDistanceForState(PhysicsState physicsState) {
        return Math.abs(this.mEndValue - physicsState.position);
    }

    private void interpolate(double d10) {
        PhysicsState physicsState = this.mCurrentState;
        double d11 = physicsState.position * d10;
        PhysicsState physicsState2 = this.mPreviousState;
        double d12 = 1.0d - d10;
        physicsState.position = d11 + (physicsState2.position * d12);
        physicsState.velocity = (physicsState.velocity * d10) + (physicsState2.velocity * d12);
    }

    public Spring addListener(SpringListener springListener) {
        if (springListener != null) {
            this.mListeners.add(springListener);
            return this;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void advance(double d10) {
        double d11;
        boolean z10;
        boolean z11;
        boolean isAtRest = isAtRest();
        if (isAtRest && this.mWasAtRest) {
            return;
        }
        double d12 = MAX_DELTA_TIME_SEC;
        if (d10 <= MAX_DELTA_TIME_SEC) {
            d12 = d10;
        }
        this.mTimeAccumulator += d12;
        SpringConfig springConfig = this.mSpringConfig;
        double d13 = springConfig.tension;
        double d14 = springConfig.friction;
        PhysicsState physicsState = this.mCurrentState;
        double d15 = physicsState.position;
        double d16 = physicsState.velocity;
        PhysicsState physicsState2 = this.mTempState;
        double d17 = physicsState2.position;
        double d18 = physicsState2.velocity;
        while (true) {
            d11 = this.mTimeAccumulator;
            if (d11 < SOLVER_TIMESTEP_SEC) {
                break;
            }
            double d19 = d11 - SOLVER_TIMESTEP_SEC;
            this.mTimeAccumulator = d19;
            if (d19 < SOLVER_TIMESTEP_SEC) {
                PhysicsState physicsState3 = this.mPreviousState;
                physicsState3.position = d15;
                physicsState3.velocity = d16;
            }
            double d20 = this.mEndValue;
            double d21 = ((d20 - d17) * d13) - (d14 * d16);
            double d22 = (d16 * SOLVER_TIMESTEP_SEC * 0.5d) + d15;
            double d23 = d16 + (d21 * SOLVER_TIMESTEP_SEC * 0.5d);
            double d24 = ((d20 - d22) * d13) - (d14 * d23);
            double d25 = d15 + (d23 * SOLVER_TIMESTEP_SEC * 0.5d);
            double d26 = d16 + (d24 * SOLVER_TIMESTEP_SEC * 0.5d);
            double d27 = ((d20 - d25) * d13) - (d14 * d26);
            double d28 = d15 + (d26 * SOLVER_TIMESTEP_SEC);
            double d29 = d16 + (d27 * SOLVER_TIMESTEP_SEC);
            d15 += (d16 + ((d23 + d26) * 2.0d) + d29) * 0.16666666666666666d * SOLVER_TIMESTEP_SEC;
            d16 += (d21 + ((d24 + d27) * 2.0d) + (((d20 - d28) * d13) - (d14 * d29))) * 0.16666666666666666d * SOLVER_TIMESTEP_SEC;
            d17 = d28;
            d18 = d29;
        }
        PhysicsState physicsState4 = this.mTempState;
        physicsState4.position = d17;
        physicsState4.velocity = d18;
        PhysicsState physicsState5 = this.mCurrentState;
        physicsState5.position = d15;
        physicsState5.velocity = d16;
        if (d11 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            interpolate(d11 / SOLVER_TIMESTEP_SEC);
        }
        boolean z12 = true;
        if (!isAtRest() && (!this.mOvershootClampingEnabled || !isOvershooting())) {
            z10 = isAtRest;
        } else {
            if (d13 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d30 = this.mEndValue;
                this.mStartValue = d30;
                this.mCurrentState.position = d30;
            } else {
                double d31 = this.mCurrentState.position;
                this.mEndValue = d31;
                this.mStartValue = d31;
            }
            setVelocity(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            z10 = true;
        }
        if (this.mWasAtRest) {
            this.mWasAtRest = false;
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10) {
            this.mWasAtRest = true;
        } else {
            z12 = false;
        }
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            SpringListener next = it.next();
            if (z11) {
                next.onSpringActivate(this);
            }
            next.onSpringUpdate(this);
            if (z12) {
                next.onSpringAtRest(this);
            }
        }
    }

    public boolean currentValueIsApproximately(double d10) {
        if (Math.abs(getCurrentValue() - d10) <= getRestDisplacementThreshold()) {
            return true;
        }
        return false;
    }

    public void destroy() {
        this.mListeners.clear();
        this.mSpringSystem.deregisterSpring(this);
    }

    public double getCurrentDisplacementDistance() {
        return getDisplacementDistanceForState(this.mCurrentState);
    }

    public double getCurrentValue() {
        return this.mCurrentState.position;
    }

    public double getEndValue() {
        return this.mEndValue;
    }

    public String getId() {
        return this.mId;
    }

    public double getRestDisplacementThreshold() {
        return this.mDisplacementFromRestThreshold;
    }

    public double getRestSpeedThreshold() {
        return this.mRestSpeedThreshold;
    }

    public SpringConfig getSpringConfig() {
        return this.mSpringConfig;
    }

    public double getStartValue() {
        return this.mStartValue;
    }

    public double getVelocity() {
        return this.mCurrentState.velocity;
    }

    public boolean isAtRest() {
        if (Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold && (getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold || this.mSpringConfig.tension == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
            return true;
        }
        return false;
    }

    public boolean isOvershootClampingEnabled() {
        return this.mOvershootClampingEnabled;
    }

    public boolean isOvershooting() {
        if (this.mSpringConfig.tension > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && ((this.mStartValue < this.mEndValue && getCurrentValue() > this.mEndValue) || (this.mStartValue > this.mEndValue && getCurrentValue() < this.mEndValue))) {
            return true;
        }
        return false;
    }

    public Spring removeAllListeners() {
        this.mListeners.clear();
        return this;
    }

    public Spring removeListener(SpringListener springListener) {
        if (springListener != null) {
            this.mListeners.remove(springListener);
            return this;
        }
        throw new IllegalArgumentException("listenerToRemove is required");
    }

    public Spring setAtRest() {
        PhysicsState physicsState = this.mCurrentState;
        double d10 = physicsState.position;
        this.mEndValue = d10;
        this.mTempState.position = d10;
        physicsState.velocity = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return this;
    }

    public Spring setCurrentValue(double d10) {
        return setCurrentValue(d10, true);
    }

    public Spring setEndValue(double d10) {
        if (this.mEndValue == d10 && isAtRest()) {
            return this;
        }
        this.mStartValue = getCurrentValue();
        this.mEndValue = d10;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onSpringEndStateChange(this);
        }
        return this;
    }

    public Spring setOvershootClampingEnabled(boolean z10) {
        this.mOvershootClampingEnabled = z10;
        return this;
    }

    public Spring setRestDisplacementThreshold(double d10) {
        this.mDisplacementFromRestThreshold = d10;
        return this;
    }

    public Spring setRestSpeedThreshold(double d10) {
        this.mRestSpeedThreshold = d10;
        return this;
    }

    public Spring setSpringConfig(SpringConfig springConfig) {
        if (springConfig != null) {
            this.mSpringConfig = springConfig;
            return this;
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public Spring setVelocity(double d10) {
        PhysicsState physicsState = this.mCurrentState;
        if (d10 == physicsState.velocity) {
            return this;
        }
        physicsState.velocity = d10;
        this.mSpringSystem.activateSpring(getId());
        return this;
    }

    public boolean systemShouldAdvance() {
        if (isAtRest() && wasAtRest()) {
            return false;
        }
        return true;
    }

    public boolean wasAtRest() {
        return this.mWasAtRest;
    }

    public Spring setCurrentValue(double d10, boolean z10) {
        this.mStartValue = d10;
        this.mCurrentState.position = d10;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onSpringUpdate(this);
        }
        if (z10) {
            setAtRest();
        }
        return this;
    }
}
