package com.qiahao.nextvideo.data.room;

import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.apache.commons.sudcompress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b<\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u00102\u001a\u00020\bJ\u0006\u00103\u001a\u00020\bJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009e\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001e\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\n\u0010\u001f\"\u0004\b%\u0010!R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001aR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016¨\u0006G"}, d2 = {"Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "", "avatar", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "end", "hasLeft", "", "luckyBagId", "isWorld", "myDiamond", "nick", "start", "balance", "leftDiamond", Constants.KEY_HTTP_CODE, "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getDiamond", "()Ljava/lang/Long;", "setDiamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEnd", "setEnd", "getHasLeft", "()Ljava/lang/Boolean;", "setHasLeft", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLuckyBagId", "setLuckyBagId", "setWorld", "getMyDiamond", "setMyDiamond", "getNick", "setNick", "getStart", "setStart", "getBalance", "setBalance", "getLeftDiamond", "setLeftDiamond", "getCode", "setCode", "checkEnvelopeExpired", "canGetWorld", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class EnvelopeData {

    @Nullable
    private String avatar;

    @Nullable
    private Long balance;

    @Nullable
    private String code;

    @Nullable
    private Long diamond;

    @Nullable
    private Long end;

    @Nullable
    private Boolean hasLeft;

    @Nullable
    private Boolean isWorld;

    @Nullable
    private Long leftDiamond;

    @Nullable
    private Long luckyBagId;

    @Nullable
    private Long myDiamond;

    @Nullable
    private String nick;

    @Nullable
    private Long start;

    public EnvelopeData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public final boolean canGetWorld() {
        long j;
        if (!Intrinsics.areEqual(this.isWorld, Boolean.FALSE)) {
            if (Intrinsics.areEqual(this.isWorld, Boolean.TRUE)) {
                long serverTime = V2TIMManager.getInstance().getServerTime();
                Long l = this.start;
                if (l != null) {
                    j = l.longValue();
                } else {
                    j = 0;
                }
                if (serverTime >= j) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean checkEnvelopeExpired() {
        long j;
        if (!Intrinsics.areEqual(this.hasLeft, Boolean.FALSE)) {
            long serverTime = V2TIMManager.getInstance().getServerTime();
            Long l = this.end;
            if (l != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            if (serverTime < j) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Long getBalance() {
        return this.balance;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Long getLeftDiamond() {
        return this.leftDiamond;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getEnd() {
        return this.end;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getHasLeft() {
        return this.hasLeft;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getLuckyBagId() {
        return this.luckyBagId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Boolean getIsWorld() {
        return this.isWorld;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getMyDiamond() {
        return this.myDiamond;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Long getStart() {
        return this.start;
    }

    @NotNull
    public final EnvelopeData copy(@Nullable String avatar, @Nullable Long diamond, @Nullable Long end, @Nullable Boolean hasLeft, @Nullable Long luckyBagId, @Nullable Boolean isWorld, @Nullable Long myDiamond, @Nullable String nick, @Nullable Long start, @Nullable Long balance, @Nullable Long leftDiamond, @Nullable String code) {
        return new EnvelopeData(avatar, diamond, end, hasLeft, luckyBagId, isWorld, myDiamond, nick, start, balance, leftDiamond, code);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnvelopeData)) {
            return false;
        }
        EnvelopeData envelopeData = (EnvelopeData) other;
        return Intrinsics.areEqual(this.avatar, envelopeData.avatar) && Intrinsics.areEqual(this.diamond, envelopeData.diamond) && Intrinsics.areEqual(this.end, envelopeData.end) && Intrinsics.areEqual(this.hasLeft, envelopeData.hasLeft) && Intrinsics.areEqual(this.luckyBagId, envelopeData.luckyBagId) && Intrinsics.areEqual(this.isWorld, envelopeData.isWorld) && Intrinsics.areEqual(this.myDiamond, envelopeData.myDiamond) && Intrinsics.areEqual(this.nick, envelopeData.nick) && Intrinsics.areEqual(this.start, envelopeData.start) && Intrinsics.areEqual(this.balance, envelopeData.balance) && Intrinsics.areEqual(this.leftDiamond, envelopeData.leftDiamond) && Intrinsics.areEqual(this.code, envelopeData.code);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final Long getBalance() {
        return this.balance;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final Long getEnd() {
        return this.end;
    }

    @Nullable
    public final Boolean getHasLeft() {
        return this.hasLeft;
    }

    @Nullable
    public final Long getLeftDiamond() {
        return this.leftDiamond;
    }

    @Nullable
    public final Long getLuckyBagId() {
        return this.luckyBagId;
    }

    @Nullable
    public final Long getMyDiamond() {
        return this.myDiamond;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final Long getStart() {
        return this.start;
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.diamond;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.end;
        int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Boolean bool = this.hasLeft;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l3 = this.luckyBagId;
        int hashCode5 = (hashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Boolean bool2 = this.isWorld;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l4 = this.myDiamond;
        int hashCode7 = (hashCode6 + (l4 == null ? 0 : l4.hashCode())) * 31;
        String str2 = this.nick;
        int hashCode8 = (hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l5 = this.start;
        int hashCode9 = (hashCode8 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Long l6 = this.balance;
        int hashCode10 = (hashCode9 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.leftDiamond;
        int hashCode11 = (hashCode10 + (l7 == null ? 0 : l7.hashCode())) * 31;
        String str3 = this.code;
        return hashCode11 + (str3 != null ? str3.hashCode() : 0);
    }

    @Nullable
    public final Boolean isWorld() {
        return this.isWorld;
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setBalance(@Nullable Long l) {
        this.balance = l;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setDiamond(@Nullable Long l) {
        this.diamond = l;
    }

    public final void setEnd(@Nullable Long l) {
        this.end = l;
    }

    public final void setHasLeft(@Nullable Boolean bool) {
        this.hasLeft = bool;
    }

    public final void setLeftDiamond(@Nullable Long l) {
        this.leftDiamond = l;
    }

    public final void setLuckyBagId(@Nullable Long l) {
        this.luckyBagId = l;
    }

    public final void setMyDiamond(@Nullable Long l) {
        this.myDiamond = l;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    public final void setStart(@Nullable Long l) {
        this.start = l;
    }

    public final void setWorld(@Nullable Boolean bool) {
        this.isWorld = bool;
    }

    @NotNull
    public String toString() {
        return "EnvelopeData(avatar=" + this.avatar + ", diamond=" + this.diamond + ", end=" + this.end + ", hasLeft=" + this.hasLeft + ", luckyBagId=" + this.luckyBagId + ", isWorld=" + this.isWorld + ", myDiamond=" + this.myDiamond + ", nick=" + this.nick + ", start=" + this.start + ", balance=" + this.balance + ", leftDiamond=" + this.leftDiamond + ", code=" + this.code + ")";
    }

    public EnvelopeData(@Nullable String str, @Nullable Long l, @Nullable Long l2, @Nullable Boolean bool, @Nullable Long l3, @Nullable Boolean bool2, @Nullable Long l4, @Nullable String str2, @Nullable Long l5, @Nullable Long l6, @Nullable Long l7, @Nullable String str3) {
        this.avatar = str;
        this.diamond = l;
        this.end = l2;
        this.hasLeft = bool;
        this.luckyBagId = l3;
        this.isWorld = bool2;
        this.myDiamond = l4;
        this.nick = str2;
        this.start = l5;
        this.balance = l6;
        this.leftDiamond = l7;
        this.code = str3;
    }

    public /* synthetic */ EnvelopeData(String str, Long l, Long l2, Boolean bool, Long l3, Boolean bool2, Long l4, String str2, Long l5, Long l6, Long l7, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : l3, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : l4, (i & 128) != 0 ? null : str2, (i & 256) != 0 ? null : l5, (i & 512) != 0 ? null : l6, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : l7, (i & 2048) == 0 ? str3 : null);
    }
}
