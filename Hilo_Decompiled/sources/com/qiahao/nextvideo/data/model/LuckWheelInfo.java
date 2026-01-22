package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u001d\u00109\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\fHÆ\u0003J\u0093\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0005HÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR.\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u001a\u0010\u0013\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010%\"\u0004\b5\u0010'¨\u0006G"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "", "creator", "", "entranceFee", "", "losersNum", "participants", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/Participant;", "Lkotlin/collections/ArrayList;", "playTimeStamp", "", "seatNum", "sequence", "", "status", "wheelId", "totalFee", "winnerAmount", "<init>", "(Ljava/lang/String;IILjava/util/ArrayList;JILjava/util/List;IIIJ)V", "getCreator", "()Ljava/lang/String;", "setCreator", "(Ljava/lang/String;)V", "getEntranceFee", "()I", "setEntranceFee", "(I)V", "getLosersNum", "setLosersNum", "getParticipants", "()Ljava/util/ArrayList;", "setParticipants", "(Ljava/util/ArrayList;)V", "getPlayTimeStamp", "()J", "setPlayTimeStamp", "(J)V", "getSeatNum", "setSeatNum", "getSequence", "()Ljava/util/List;", "setSequence", "(Ljava/util/List;)V", "getStatus", "setStatus", "getWheelId", "setWheelId", "getTotalFee", "setTotalFee", "getWinnerAmount", "setWinnerAmount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckWheelInfo {

    @NotNull
    private String creator;
    private int entranceFee;
    private int losersNum;

    @Nullable
    private ArrayList<Participant> participants;
    private long playTimeStamp;
    private int seatNum;

    @Nullable
    private List<String> sequence;
    private int status;
    private int totalFee;
    private int wheelId;
    private long winnerAmount;

    public LuckWheelInfo(@NotNull String str, int i, int i2, @Nullable ArrayList<Participant> arrayList, long j, int i3, @Nullable List<String> list, int i4, int i5, int i6, long j2) {
        Intrinsics.checkNotNullParameter(str, "creator");
        this.creator = str;
        this.entranceFee = i;
        this.losersNum = i2;
        this.participants = arrayList;
        this.playTimeStamp = j;
        this.seatNum = i3;
        this.sequence = list;
        this.status = i4;
        this.wheelId = i5;
        this.totalFee = i6;
        this.winnerAmount = j2;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCreator() {
        return this.creator;
    }

    /* renamed from: component10, reason: from getter */
    public final int getTotalFee() {
        return this.totalFee;
    }

    /* renamed from: component11, reason: from getter */
    public final long getWinnerAmount() {
        return this.winnerAmount;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEntranceFee() {
        return this.entranceFee;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLosersNum() {
        return this.losersNum;
    }

    @Nullable
    public final ArrayList<Participant> component4() {
        return this.participants;
    }

    /* renamed from: component5, reason: from getter */
    public final long getPlayTimeStamp() {
        return this.playTimeStamp;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSeatNum() {
        return this.seatNum;
    }

    @Nullable
    public final List<String> component7() {
        return this.sequence;
    }

    /* renamed from: component8, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component9, reason: from getter */
    public final int getWheelId() {
        return this.wheelId;
    }

    @NotNull
    public final LuckWheelInfo copy(@NotNull String creator, int entranceFee, int losersNum, @Nullable ArrayList<Participant> participants, long playTimeStamp, int seatNum, @Nullable List<String> sequence, int status, int wheelId, int totalFee, long winnerAmount) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        return new LuckWheelInfo(creator, entranceFee, losersNum, participants, playTimeStamp, seatNum, sequence, status, wheelId, totalFee, winnerAmount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckWheelInfo)) {
            return false;
        }
        LuckWheelInfo luckWheelInfo = (LuckWheelInfo) other;
        return Intrinsics.areEqual(this.creator, luckWheelInfo.creator) && this.entranceFee == luckWheelInfo.entranceFee && this.losersNum == luckWheelInfo.losersNum && Intrinsics.areEqual(this.participants, luckWheelInfo.participants) && this.playTimeStamp == luckWheelInfo.playTimeStamp && this.seatNum == luckWheelInfo.seatNum && Intrinsics.areEqual(this.sequence, luckWheelInfo.sequence) && this.status == luckWheelInfo.status && this.wheelId == luckWheelInfo.wheelId && this.totalFee == luckWheelInfo.totalFee && this.winnerAmount == luckWheelInfo.winnerAmount;
    }

    @NotNull
    public final String getCreator() {
        return this.creator;
    }

    public final int getEntranceFee() {
        return this.entranceFee;
    }

    public final int getLosersNum() {
        return this.losersNum;
    }

    @Nullable
    public final ArrayList<Participant> getParticipants() {
        return this.participants;
    }

    public final long getPlayTimeStamp() {
        return this.playTimeStamp;
    }

    public final int getSeatNum() {
        return this.seatNum;
    }

    @Nullable
    public final List<String> getSequence() {
        return this.sequence;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getTotalFee() {
        return this.totalFee;
    }

    public final int getWheelId() {
        return this.wheelId;
    }

    public final long getWinnerAmount() {
        return this.winnerAmount;
    }

    public int hashCode() {
        int hashCode = ((((this.creator.hashCode() * 31) + this.entranceFee) * 31) + this.losersNum) * 31;
        ArrayList<Participant> arrayList = this.participants;
        int hashCode2 = (((((hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31) + c.a(this.playTimeStamp)) * 31) + this.seatNum) * 31;
        List<String> list = this.sequence;
        return ((((((((hashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.status) * 31) + this.wheelId) * 31) + this.totalFee) * 31) + c.a(this.winnerAmount);
    }

    public final void setCreator(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.creator = str;
    }

    public final void setEntranceFee(int i) {
        this.entranceFee = i;
    }

    public final void setLosersNum(int i) {
        this.losersNum = i;
    }

    public final void setParticipants(@Nullable ArrayList<Participant> arrayList) {
        this.participants = arrayList;
    }

    public final void setPlayTimeStamp(long j) {
        this.playTimeStamp = j;
    }

    public final void setSeatNum(int i) {
        this.seatNum = i;
    }

    public final void setSequence(@Nullable List<String> list) {
        this.sequence = list;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTotalFee(int i) {
        this.totalFee = i;
    }

    public final void setWheelId(int i) {
        this.wheelId = i;
    }

    public final void setWinnerAmount(long j) {
        this.winnerAmount = j;
    }

    @NotNull
    public String toString() {
        return "LuckWheelInfo(creator=" + this.creator + ", entranceFee=" + this.entranceFee + ", losersNum=" + this.losersNum + ", participants=" + this.participants + ", playTimeStamp=" + this.playTimeStamp + ", seatNum=" + this.seatNum + ", sequence=" + this.sequence + ", status=" + this.status + ", wheelId=" + this.wheelId + ", totalFee=" + this.totalFee + ", winnerAmount=" + this.winnerAmount + ")";
    }

    public /* synthetic */ LuckWheelInfo(String str, int i, int i2, ArrayList arrayList, long j, int i3, List list, int i4, int i5, int i6, long j2, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i7 & 8) != 0 ? null : arrayList, j, i3, (i7 & 64) != 0 ? null : list, i4, i5, i6, j2);
    }
}
