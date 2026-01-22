package com.qiahao.nextvideo.data.foodie;

import com.qiahao.nextvideo.sheep.GameMatchActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/FoodieCreateBean;", "", "<init>", "()V", "round", "", "getRound", "()I", "setRound", "(I)V", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "endTime", "getEndTime", "setEndTime", "createTime", "getCreateTime", "setCreateTime", GameMatchActivity.GAME_ID, "", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieCreateBean {

    @c("create_time")
    private long createTime;

    @c("end_time")
    private long endTime;

    @Nullable
    @c("game_id")
    private String gameId = "";
    private int round;

    @c("start_time")
    private long startTime;

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final String getGameId() {
        return this.gameId;
    }

    public final int getRound() {
        return this.round;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void setGameId(@Nullable String str) {
        this.gameId = str;
    }

    public final void setRound(int i) {
        this.round = i;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }
}
