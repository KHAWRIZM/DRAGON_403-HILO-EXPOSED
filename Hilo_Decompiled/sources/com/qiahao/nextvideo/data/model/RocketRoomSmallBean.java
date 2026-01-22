package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/model/RocketRoomSmallBean;", "", "nextScore", "", "remainSecond", "score", "stage", "<init>", "(IIII)V", "getNextScore", "()I", "getRemainSecond", "getScore", "getStage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RocketRoomSmallBean {
    private final int nextScore;
    private final int remainSecond;
    private final int score;
    private final int stage;

    public RocketRoomSmallBean(int i, int i2, int i3, int i4) {
        this.nextScore = i;
        this.remainSecond = i2;
        this.score = i3;
        this.stage = i4;
    }

    public static /* synthetic */ RocketRoomSmallBean copy$default(RocketRoomSmallBean rocketRoomSmallBean, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = rocketRoomSmallBean.nextScore;
        }
        if ((i5 & 2) != 0) {
            i2 = rocketRoomSmallBean.remainSecond;
        }
        if ((i5 & 4) != 0) {
            i3 = rocketRoomSmallBean.score;
        }
        if ((i5 & 8) != 0) {
            i4 = rocketRoomSmallBean.stage;
        }
        return rocketRoomSmallBean.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getNextScore() {
        return this.nextScore;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRemainSecond() {
        return this.remainSecond;
    }

    /* renamed from: component3, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStage() {
        return this.stage;
    }

    @NotNull
    public final RocketRoomSmallBean copy(int nextScore, int remainSecond, int score, int stage) {
        return new RocketRoomSmallBean(nextScore, remainSecond, score, stage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RocketRoomSmallBean)) {
            return false;
        }
        RocketRoomSmallBean rocketRoomSmallBean = (RocketRoomSmallBean) other;
        return this.nextScore == rocketRoomSmallBean.nextScore && this.remainSecond == rocketRoomSmallBean.remainSecond && this.score == rocketRoomSmallBean.score && this.stage == rocketRoomSmallBean.stage;
    }

    public final int getNextScore() {
        return this.nextScore;
    }

    public final int getRemainSecond() {
        return this.remainSecond;
    }

    public final int getScore() {
        return this.score;
    }

    public final int getStage() {
        return this.stage;
    }

    public int hashCode() {
        return (((((this.nextScore * 31) + this.remainSecond) * 31) + this.score) * 31) + this.stage;
    }

    @NotNull
    public String toString() {
        return "RocketRoomSmallBean(nextScore=" + this.nextScore + ", remainSecond=" + this.remainSecond + ", score=" + this.score + ", stage=" + this.stage + ")";
    }
}
