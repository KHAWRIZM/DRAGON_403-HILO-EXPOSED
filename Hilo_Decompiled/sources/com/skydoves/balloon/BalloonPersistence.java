package com.skydoves.balloon;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/skydoves/balloon/BalloonPersistence;", "", "()V", "clearAllPersistedData", "", "getTimes", "", "name", "", "putIncrementedTimes", "putTimes", "times", "removePersistedData", "shouldShowUP", "", "Companion", "balloon_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class BalloonPersistence {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String SHOWED_UP = "SHOWED_UP";
    private static volatile BalloonPersistence instance;
    private static SharedPreferences sharedPreferenceManager;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/skydoves/balloon/BalloonPersistence$Companion;", "", "()V", BalloonPersistence.SHOWED_UP, "", "instance", "Lcom/skydoves/balloon/BalloonPersistence;", "sharedPreferenceManager", "Landroid/content/SharedPreferences;", "getInstance", "context", "Landroid/content/Context;", "getPersistName", "name", "balloon_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final BalloonPersistence getInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            BalloonPersistence balloonPersistence = BalloonPersistence.instance;
            if (balloonPersistence == null) {
                synchronized (this) {
                    balloonPersistence = BalloonPersistence.instance;
                    if (balloonPersistence == null) {
                        balloonPersistence = new BalloonPersistence();
                        BalloonPersistence.instance = balloonPersistence;
                        SharedPreferences sharedPreferences = context.getSharedPreferences("com.skydoves.balloon", 0);
                        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…n\", Context.MODE_PRIVATE)");
                        BalloonPersistence.sharedPreferenceManager = sharedPreferences;
                    }
                }
            }
            return balloonPersistence;
        }

        @NotNull
        public final String getPersistName(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return BalloonPersistence.SHOWED_UP + name;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    @NotNull
    public static final BalloonPersistence getInstance(@NotNull Context context) {
        return INSTANCE.getInstance(context);
    }

    public final void clearAllPersistedData() {
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
        }
        sharedPreferences.edit().clear().apply();
    }

    public final int getTimes(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
        }
        return sharedPreferences.getInt(INSTANCE.getPersistName(name), 0);
    }

    public final void putIncrementedTimes(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        putTimes(name, getTimes(name) + 1);
    }

    public final void putTimes(@NotNull String name, int times) {
        Intrinsics.checkNotNullParameter(name, "name");
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
        }
        sharedPreferences.edit().putInt(INSTANCE.getPersistName(name), times).apply();
    }

    public final void removePersistedData(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
        }
        sharedPreferences.edit().remove(SHOWED_UP + name).apply();
    }

    public final boolean shouldShowUP(@NotNull String name, int times) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (getTimes(name) < times) {
            return true;
        }
        return false;
    }
}
