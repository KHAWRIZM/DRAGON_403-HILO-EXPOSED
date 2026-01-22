package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ReadNoAll;", "", "iLike", "", "likeEach", "likeMe", "matchHistory", "visitor", "<init>", "(IIIII)V", "getILike", "()I", "getLikeEach", "getLikeMe", "getMatchHistory", "getVisitor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ReadNoAll {

    @c("iLike")
    private final int iLike;

    @c("likeEach")
    private final int likeEach;

    @c("likeMe")
    private final int likeMe;

    @c("matchHistory")
    private final int matchHistory;

    @c("visitor")
    private final int visitor;

    public ReadNoAll() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ ReadNoAll copy$default(ReadNoAll readNoAll, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = readNoAll.iLike;
        }
        if ((i6 & 2) != 0) {
            i2 = readNoAll.likeEach;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = readNoAll.likeMe;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = readNoAll.matchHistory;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = readNoAll.visitor;
        }
        return readNoAll.copy(i, i7, i8, i9, i5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getILike() {
        return this.iLike;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLikeEach() {
        return this.likeEach;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLikeMe() {
        return this.likeMe;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMatchHistory() {
        return this.matchHistory;
    }

    /* renamed from: component5, reason: from getter */
    public final int getVisitor() {
        return this.visitor;
    }

    @NotNull
    public final ReadNoAll copy(int iLike, int likeEach, int likeMe, int matchHistory, int visitor) {
        return new ReadNoAll(iLike, likeEach, likeMe, matchHistory, visitor);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReadNoAll)) {
            return false;
        }
        ReadNoAll readNoAll = (ReadNoAll) other;
        return this.iLike == readNoAll.iLike && this.likeEach == readNoAll.likeEach && this.likeMe == readNoAll.likeMe && this.matchHistory == readNoAll.matchHistory && this.visitor == readNoAll.visitor;
    }

    public final int getILike() {
        return this.iLike;
    }

    public final int getLikeEach() {
        return this.likeEach;
    }

    public final int getLikeMe() {
        return this.likeMe;
    }

    public final int getMatchHistory() {
        return this.matchHistory;
    }

    public final int getVisitor() {
        return this.visitor;
    }

    public int hashCode() {
        return (((((((this.iLike * 31) + this.likeEach) * 31) + this.likeMe) * 31) + this.matchHistory) * 31) + this.visitor;
    }

    @NotNull
    public String toString() {
        return "ReadNoAll(iLike=" + this.iLike + ", likeEach=" + this.likeEach + ", likeMe=" + this.likeMe + ", matchHistory=" + this.matchHistory + ", visitor=" + this.visitor + ")";
    }

    public ReadNoAll(int i, int i2, int i3, int i4, int i5) {
        this.iLike = i;
        this.likeEach = i2;
        this.likeMe = i3;
        this.matchHistory = i4;
        this.visitor = i5;
    }

    public /* synthetic */ ReadNoAll(int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5);
    }
}
