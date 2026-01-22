package com.qiahao.nextvideo.data.model;

import android.text.TextUtils;
import androidx.collection.c;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\b\u0086\b\u0018\u0000 M2\u00020\u0001:\u0001MBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u00109\u001a\u00020\u0003J\u000e\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u0000J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\t\u0010@\u001a\u00020\bHÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\fHÆ\u0003J\t\u0010C\u001a\u00020\bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010E\u001a\u00020\bHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0084\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020\b2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u0005HÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010%\"\u0004\b4\u0010'R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006N"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MicroBean;", "", "groupId", "", "i", "", SupportGiftRankActivity.EXTERNAL_ID, "forbid", "", "lock", "agoraId", "timestamp", "", "micForbid", "user", "Lcom/qiahao/nextvideo/data/model/MicroUserBean;", "isRed", "roomBanner", "Lcom/qiahao/nextvideo/data/model/MicBanner;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;ZIJZLcom/qiahao/nextvideo/data/model/MicroUserBean;ZLcom/qiahao/nextvideo/data/model/MicBanner;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getI", "()I", "setI", "(I)V", "getExternalId", "setExternalId", "getForbid", "()Ljava/lang/Boolean;", "setForbid", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLock", "()Z", "setLock", "(Z)V", "getAgoraId", "setAgoraId", "getTimestamp", "()J", "setTimestamp", "(J)V", "getMicForbid", "setMicForbid", "getUser", "()Lcom/qiahao/nextvideo/data/model/MicroUserBean;", "setUser", "(Lcom/qiahao/nextvideo/data/model/MicroUserBean;)V", "setRed", "getRoomBanner", "()Lcom/qiahao/nextvideo/data/model/MicBanner;", "setRoomBanner", "(Lcom/qiahao/nextvideo/data/model/MicBanner;)V", "getEffectUrl", "checkDataIsEqual", "microBean", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;ZIJZLcom/qiahao/nextvideo/data/model/MicroUserBean;ZLcom/qiahao/nextvideo/data/model/MicBanner;)Lcom/qiahao/nextvideo/data/model/MicroBean;", "equals", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MicroBean {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int agoraId;

    @Nullable
    private String externalId;

    @Nullable
    private Boolean forbid;

    @NotNull
    private String groupId;
    private int i;
    private boolean isRed;
    private boolean lock;
    private boolean micForbid;

    @Nullable
    private MicBanner roomBanner;
    private long timestamp;

    @Nullable
    private MicroUserBean user;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MicroBean$Companion;", "", "<init>", "()V", "emptyMicroBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "i", "", "isRed", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MicroBean emptyMicroBean$default(Companion companion, int i, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            return companion.emptyMicroBean(i, z);
        }

        @NotNull
        public final MicroBean emptyMicroBean(int i, boolean isRed) {
            return new MicroBean("", i, "", Boolean.FALSE, false, 0, 0L, false, null, isRed, null, LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY, null);
        }

        private Companion() {
        }
    }

    public MicroBean(@NotNull String str, int i, @Nullable String str2, @Nullable Boolean bool, boolean z, int i2, long j, boolean z2, @Nullable MicroUserBean microUserBean, boolean z3, @Nullable MicBanner micBanner) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        this.groupId = str;
        this.i = i;
        this.externalId = str2;
        this.forbid = bool;
        this.lock = z;
        this.agoraId = i2;
        this.timestamp = j;
        this.micForbid = z2;
        this.user = microUserBean;
        this.isRed = z3;
        this.roomBanner = micBanner;
    }

    public final boolean checkDataIsEqual(@NotNull MicroBean microBean) {
        Integer num;
        Integer num2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Integer num3;
        Integer num4;
        String str7;
        String str8;
        Boolean bool;
        Boolean bool2;
        Integer num5;
        Integer num6;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        Boolean bool3;
        Intrinsics.checkNotNullParameter(microBean, "microBean");
        if (this.i != microBean.i || this.lock != microBean.lock || !Intrinsics.areEqual(this.forbid, microBean.forbid) || this.micForbid != microBean.micForbid || this.agoraId != microBean.agoraId || !Intrinsics.areEqual(this.externalId, microBean.externalId) || !Intrinsics.areEqual(this.groupId, microBean.groupId)) {
            return false;
        }
        MicroUserBean microUserBean = this.user;
        if (microUserBean == null) {
            if (microBean.user != null) {
                return false;
            }
            return true;
        }
        if (microBean.user == null) {
            return false;
        }
        Boolean bool4 = null;
        if (microUserBean != null) {
            num = Integer.valueOf(microUserBean.getTag());
        } else {
            num = null;
        }
        MicroUserBean microUserBean2 = microBean.user;
        if (microUserBean2 != null) {
            num2 = Integer.valueOf(microUserBean2.getTag());
        } else {
            num2 = null;
        }
        if (!Intrinsics.areEqual(num, num2)) {
            return false;
        }
        MicroUserBean microUserBean3 = this.user;
        if (microUserBean3 != null) {
            str = microUserBean3.getExternalId();
        } else {
            str = null;
        }
        MicroUserBean microUserBean4 = microBean.user;
        if (microUserBean4 != null) {
            str2 = microUserBean4.getExternalId();
        } else {
            str2 = null;
        }
        if (!Intrinsics.areEqual(str, str2)) {
            return false;
        }
        MicroUserBean microUserBean5 = this.user;
        if (microUserBean5 != null) {
            str3 = microUserBean5.getAvatar();
        } else {
            str3 = null;
        }
        MicroUserBean microUserBean6 = microBean.user;
        if (microUserBean6 != null) {
            str4 = microUserBean6.getAvatar();
        } else {
            str4 = null;
        }
        if (!Intrinsics.areEqual(str3, str4)) {
            return false;
        }
        MicroUserBean microUserBean7 = this.user;
        if (microUserBean7 != null) {
            str5 = microUserBean7.getNick();
        } else {
            str5 = null;
        }
        MicroUserBean microUserBean8 = microBean.user;
        if (microUserBean8 != null) {
            str6 = microUserBean8.getNick();
        } else {
            str6 = null;
        }
        if (!Intrinsics.areEqual(str5, str6)) {
            return false;
        }
        MicroUserBean microUserBean9 = this.user;
        if (microUserBean9 != null) {
            num3 = Integer.valueOf(microUserBean9.getSex());
        } else {
            num3 = null;
        }
        MicroUserBean microUserBean10 = microBean.user;
        if (microUserBean10 != null) {
            num4 = Integer.valueOf(microUserBean10.getSex());
        } else {
            num4 = null;
        }
        if (!Intrinsics.areEqual(num3, num4)) {
            return false;
        }
        MicroUserBean microUserBean11 = this.user;
        if (microUserBean11 != null) {
            str7 = microUserBean11.getCode();
        } else {
            str7 = null;
        }
        MicroUserBean microUserBean12 = microBean.user;
        if (microUserBean12 != null) {
            str8 = microUserBean12.getCode();
        } else {
            str8 = null;
        }
        if (!Intrinsics.areEqual(str7, str8)) {
            return false;
        }
        MicroUserBean microUserBean13 = this.user;
        if (microUserBean13 != null) {
            bool = Boolean.valueOf(microUserBean13.isVip());
        } else {
            bool = null;
        }
        MicroUserBean microUserBean14 = microBean.user;
        if (microUserBean14 != null) {
            bool2 = Boolean.valueOf(microUserBean14.isVip());
        } else {
            bool2 = null;
        }
        if (!Intrinsics.areEqual(bool, bool2)) {
            return false;
        }
        MicroUserBean microUserBean15 = this.user;
        if (microUserBean15 != null) {
            num5 = Integer.valueOf(microUserBean15.getNoble());
        } else {
            num5 = null;
        }
        MicroUserBean microUserBean16 = microBean.user;
        if (microUserBean16 != null) {
            num6 = Integer.valueOf(microUserBean16.getNoble());
        } else {
            num6 = null;
        }
        if (!Intrinsics.areEqual(num5, num6)) {
            return false;
        }
        MicroUserBean microUserBean17 = this.user;
        if (microUserBean17 != null) {
            str9 = microUserBean17.getHeadwearPicUrl();
        } else {
            str9 = null;
        }
        MicroUserBean microUserBean18 = microBean.user;
        if (microUserBean18 != null) {
            str10 = microUserBean18.getHeadwearPicUrl();
        } else {
            str10 = null;
        }
        if (!Intrinsics.areEqual(str9, str10)) {
            return false;
        }
        MicroUserBean microUserBean19 = this.user;
        if (microUserBean19 != null) {
            str11 = microUserBean19.getHeadwearEffectUrl();
        } else {
            str11 = null;
        }
        MicroUserBean microUserBean20 = microBean.user;
        if (microUserBean20 != null) {
            str12 = microUserBean20.getHeadwearEffectUrl();
        } else {
            str12 = null;
        }
        if (!Intrinsics.areEqual(str11, str12)) {
            return false;
        }
        MicroUserBean microUserBean21 = this.user;
        if (microUserBean21 != null) {
            str13 = microUserBean21.getMicEffect();
        } else {
            str13 = null;
        }
        MicroUserBean microUserBean22 = microBean.user;
        if (microUserBean22 != null) {
            str14 = microUserBean22.getMicEffect();
        } else {
            str14 = null;
        }
        if (!Intrinsics.areEqual(str13, str14)) {
            return false;
        }
        MicroUserBean microUserBean23 = this.user;
        if (microUserBean23 != null) {
            str15 = microUserBean23.getHeadwearIcon();
        } else {
            str15 = null;
        }
        MicroUserBean microUserBean24 = microBean.user;
        if (microUserBean24 != null) {
            str16 = microUserBean24.getHeadwearIcon();
        } else {
            str16 = null;
        }
        if (!Intrinsics.areEqual(str15, str16)) {
            return false;
        }
        MicroUserBean microUserBean25 = this.user;
        if (microUserBean25 != null) {
            str17 = microUserBean25.getHeadwearReverseEffectUrl();
        } else {
            str17 = null;
        }
        MicroUserBean microUserBean26 = microBean.user;
        if (microUserBean26 != null) {
            str18 = microUserBean26.getHeadwearReverseEffectUrl();
        } else {
            str18 = null;
        }
        if (!Intrinsics.areEqual(str17, str18)) {
            return false;
        }
        MicroUserBean microUserBean27 = this.user;
        if (microUserBean27 != null) {
            bool3 = microUserBean27.getMusic();
        } else {
            bool3 = null;
        }
        MicroUserBean microUserBean28 = microBean.user;
        if (microUserBean28 != null) {
            bool4 = microUserBean28.getMusic();
        }
        if (!Intrinsics.areEqual(bool3, bool4)) {
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsRed() {
        return this.isRed;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final MicBanner getRoomBanner() {
        return this.roomBanner;
    }

    /* renamed from: component2, reason: from getter */
    public final int getI() {
        return this.i;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getForbid() {
        return this.forbid;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getLock() {
        return this.lock;
    }

    /* renamed from: component6, reason: from getter */
    public final int getAgoraId() {
        return this.agoraId;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getMicForbid() {
        return this.micForbid;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final MicroUserBean getUser() {
        return this.user;
    }

    @NotNull
    public final MicroBean copy(@NotNull String groupId, int i, @Nullable String externalId, @Nullable Boolean forbid, boolean lock, int agoraId, long timestamp, boolean micForbid, @Nullable MicroUserBean user, boolean isRed, @Nullable MicBanner roomBanner) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return new MicroBean(groupId, i, externalId, forbid, lock, agoraId, timestamp, micForbid, user, isRed, roomBanner);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MicroBean)) {
            return false;
        }
        MicroBean microBean = (MicroBean) other;
        return Intrinsics.areEqual(this.groupId, microBean.groupId) && this.i == microBean.i && Intrinsics.areEqual(this.externalId, microBean.externalId) && Intrinsics.areEqual(this.forbid, microBean.forbid) && this.lock == microBean.lock && this.agoraId == microBean.agoraId && this.timestamp == microBean.timestamp && this.micForbid == microBean.micForbid && Intrinsics.areEqual(this.user, microBean.user) && this.isRed == microBean.isRed && Intrinsics.areEqual(this.roomBanner, microBean.roomBanner);
    }

    public final int getAgoraId() {
        return this.agoraId;
    }

    @NotNull
    public final String getEffectUrl() {
        String headwearEffectUrl;
        String str;
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            MicroUserBean microUserBean = this.user;
            if (microUserBean == null || (str = microUserBean.getHeadwearReverseEffectUrl()) == null) {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                MicroUserBean microUserBean2 = this.user;
                if (microUserBean2 == null || (headwearEffectUrl = microUserBean2.getHeadwearReverseEffectUrl()) == null) {
                    return "";
                }
            } else {
                MicroUserBean microUserBean3 = this.user;
                if (microUserBean3 == null || (headwearEffectUrl = microUserBean3.getHeadwearEffectUrl()) == null) {
                    return "";
                }
            }
        } else {
            MicroUserBean microUserBean4 = this.user;
            if (microUserBean4 == null || (headwearEffectUrl = microUserBean4.getHeadwearEffectUrl()) == null) {
                return "";
            }
        }
        return headwearEffectUrl;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final Boolean getForbid() {
        return this.forbid;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    public final int getI() {
        return this.i;
    }

    public final boolean getLock() {
        return this.lock;
    }

    public final boolean getMicForbid() {
        return this.micForbid;
    }

    @Nullable
    public final MicBanner getRoomBanner() {
        return this.roomBanner;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public final MicroUserBean getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = ((this.groupId.hashCode() * 31) + this.i) * 31;
        String str = this.externalId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.forbid;
        int hashCode3 = (((((((((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + a.a(this.lock)) * 31) + this.agoraId) * 31) + c.a(this.timestamp)) * 31) + a.a(this.micForbid)) * 31;
        MicroUserBean microUserBean = this.user;
        int hashCode4 = (((hashCode3 + (microUserBean == null ? 0 : microUserBean.hashCode())) * 31) + a.a(this.isRed)) * 31;
        MicBanner micBanner = this.roomBanner;
        return hashCode4 + (micBanner != null ? micBanner.hashCode() : 0);
    }

    public final boolean isRed() {
        return this.isRed;
    }

    public final void setAgoraId(int i) {
        this.agoraId = i;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setForbid(@Nullable Boolean bool) {
        this.forbid = bool;
    }

    public final void setGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void setI(int i) {
        this.i = i;
    }

    public final void setLock(boolean z) {
        this.lock = z;
    }

    public final void setMicForbid(boolean z) {
        this.micForbid = z;
    }

    public final void setRed(boolean z) {
        this.isRed = z;
    }

    public final void setRoomBanner(@Nullable MicBanner micBanner) {
        this.roomBanner = micBanner;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final void setUser(@Nullable MicroUserBean microUserBean) {
        this.user = microUserBean;
    }

    @NotNull
    public String toString() {
        return "MicroBean(groupId=" + this.groupId + ", i=" + this.i + ", externalId=" + this.externalId + ", forbid=" + this.forbid + ", lock=" + this.lock + ", agoraId=" + this.agoraId + ", timestamp=" + this.timestamp + ", micForbid=" + this.micForbid + ", user=" + this.user + ", isRed=" + this.isRed + ", roomBanner=" + this.roomBanner + ")";
    }

    public /* synthetic */ MicroBean(String str, int i, String str2, Boolean bool, boolean z, int i2, long j, boolean z2, MicroUserBean microUserBean, boolean z3, MicBanner micBanner, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, bool, z, i2, j, (i3 & 128) != 0 ? false : z2, (i3 & 256) != 0 ? null : microUserBean, (i3 & 512) != 0 ? false : z3, (i3 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : micBanner);
    }
}
