package com.qiahao.nextvideo.room.rank;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u000e\u0010!R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010\u0013\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001b¨\u0006,"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/GroupCommonRankEntity;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", SupportGiftRankActivity.EXTERNAL_ID, "", TUIConstants.TUIChat.FACE_URL, "name", "sex", "", AgooConstants.MESSAGE_ID, ExchangeDetailActivity.TYPE_DIAMOND, "", "isVip", "", "birthday", "isShowAge", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "itemType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JZJLjava/lang/Integer;Lcom/qiahao/base_common/model/common/NobleInfo;Lcom/qiahao/base_common/model/svip/SvipData;I)V", "getExternalId", "()Ljava/lang/String;", "getFaceUrl", "getName", "getSex", "()I", "getId", "getDiamond", "()J", "()Z", "getBirthday", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getItemType", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupCommonRankEntity implements MultiItemEntity {
    private final long birthday;
    private final long diamond;

    @NotNull
    private final String externalId;

    @Nullable
    private final String faceUrl;

    @NotNull
    private final String id;

    @Nullable
    private final Integer isShowAge;
    private final boolean isVip;
    private final int itemType;

    @NotNull
    private final String name;

    @Nullable
    private NobleInfo noble;
    private final int sex;

    @Nullable
    private SvipData svip;

    public GroupCommonRankEntity(@NotNull String str, @Nullable String str2, @NotNull String str3, int i, @NotNull String str4, long j, boolean z, long j2, @Nullable Integer num, @Nullable NobleInfo nobleInfo, @Nullable SvipData svipData, int i2) {
        Intrinsics.checkNotNullParameter(str, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, AgooConstants.MESSAGE_ID);
        this.externalId = str;
        this.faceUrl = str2;
        this.name = str3;
        this.sex = i;
        this.id = str4;
        this.diamond = j;
        this.isVip = z;
        this.birthday = j2;
        this.isShowAge = num;
        this.noble = nobleInfo;
        this.svip = svipData;
        this.itemType = i2;
    }

    public final long getBirthday() {
        return this.birthday;
    }

    public final long getDiamond() {
        return this.diamond;
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public int getItemType() {
        return this.itemType;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    public final int getSex() {
        return this.sex;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: isShowAge, reason: from getter */
    public final Integer getIsShowAge() {
        return this.isShowAge;
    }

    /* renamed from: isVip, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public /* synthetic */ GroupCommonRankEntity(String str, String str2, String str3, int i, String str4, long j, boolean z, long j2, Integer num, NobleInfo nobleInfo, SvipData svipData, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, str4, j, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? 0L : j2, (i3 & 256) != 0 ? null : num, (i3 & 512) != 0 ? null : nobleInfo, (i3 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : svipData, i2);
    }
}
