package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/data/model/RelationSet;", "", "heartValueMax", "", "<init>", "(I)V", "getHeartValueMax", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RelationSet {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @c("heartValueMax")
    private final int heartValueMax;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/data/model/RelationSet$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/RelationSet;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RelationSet fake() {
            return new RelationSet(1000);
        }

        private Companion() {
        }
    }

    public RelationSet(int i) {
        this.heartValueMax = i;
    }

    public static /* synthetic */ RelationSet copy$default(RelationSet relationSet, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = relationSet.heartValueMax;
        }
        return relationSet.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHeartValueMax() {
        return this.heartValueMax;
    }

    @NotNull
    public final RelationSet copy(int heartValueMax) {
        return new RelationSet(heartValueMax);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RelationSet) && this.heartValueMax == ((RelationSet) other).heartValueMax;
    }

    public final int getHeartValueMax() {
        return this.heartValueMax;
    }

    public int hashCode() {
        return this.heartValueMax;
    }

    @NotNull
    public String toString() {
        return "RelationSet(heartValueMax=" + this.heartValueMax + ")";
    }
}
