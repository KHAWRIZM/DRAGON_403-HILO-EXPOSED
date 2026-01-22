package com.qiahao.nextvideo.ui.home.onlinefeed;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/onlinefeed/AnimationEvent;", "", AgooConstants.MESSAGE_ID, "", "percent", "", "<init>", "(Ljava/lang/String;D)V", "getId", "()Ljava/lang/String;", "getPercent", "()D", "setPercent", "(D)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AnimationEvent {

    @NotNull
    private final String id;
    private double percent;

    public AnimationEvent(@NotNull String str, double d) {
        Intrinsics.checkNotNullParameter(str, AgooConstants.MESSAGE_ID);
        this.id = str;
        this.percent = d;
    }

    public static /* synthetic */ AnimationEvent copy$default(AnimationEvent animationEvent, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = animationEvent.id;
        }
        if ((i & 2) != 0) {
            d = animationEvent.percent;
        }
        return animationEvent.copy(str, d);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final double getPercent() {
        return this.percent;
    }

    @NotNull
    public final AnimationEvent copy(@NotNull String id2, double percent) {
        Intrinsics.checkNotNullParameter(id2, AgooConstants.MESSAGE_ID);
        return new AnimationEvent(id2, percent);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationEvent)) {
            return false;
        }
        AnimationEvent animationEvent = (AnimationEvent) other;
        return Intrinsics.areEqual(this.id, animationEvent.id) && Double.compare(this.percent, animationEvent.percent) == 0;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final double getPercent() {
        return this.percent;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + com.google.firebase.sessions.a.a(this.percent);
    }

    public final void setPercent(double d) {
        this.percent = d;
    }

    @NotNull
    public String toString() {
        return "AnimationEvent(id=" + this.id + ", percent=" + this.percent + ")";
    }

    public /* synthetic */ AnimationEvent(String str, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0.0d : d);
    }
}
