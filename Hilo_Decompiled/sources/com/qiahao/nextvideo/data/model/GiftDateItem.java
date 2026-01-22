package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.cp.TextStyles;
import com.qiahao.base_common.model.svip.SvipData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 U2\u00020\u0001:\u0001UBµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00101J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¾\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u000fHÖ\u0001J\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u0010\u001bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001b¨\u0006V"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GiftDateItem;", "", "effectSvga", "", "sendUserAvatar", "receiverAvatar", "sendUserId", "receiverId", "type", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "receiveSvip", "giftSendAvatar", "giftReceiverAvatar", "giftType", "", "textStyleList", "", "Lcom/qiahao/base_common/model/cp/TextStyles;", "receiveUserNick", "sendUserNick", "giftText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEffectSvga", "()Ljava/lang/String;", "setEffectSvga", "(Ljava/lang/String;)V", "getSendUserAvatar", "setSendUserAvatar", "getReceiverAvatar", "setReceiverAvatar", "getSendUserId", "setSendUserId", "getReceiverId", "setReceiverId", "getType", "setType", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getReceiveSvip", "setReceiveSvip", "getGiftSendAvatar", "setGiftSendAvatar", "getGiftReceiverAvatar", "setGiftReceiverAvatar", "getGiftType", "()Ljava/lang/Integer;", "setGiftType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTextStyleList", "()Ljava/util/List;", "setTextStyleList", "(Ljava/util/List;)V", "getReceiveUserNick", "setReceiveUserNick", "getSendUserNick", "setSendUserNick", "getGiftText", "setGiftText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/GiftDateItem;", "equals", "", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GiftDateItem {

    @NotNull
    public static final String TYPE_ENTER_ANIMATION = "enter_animation";

    @NotNull
    public static final String TYPE_GIFT = "gift";

    @NotNull
    private String effectSvga;

    @NotNull
    private String giftReceiverAvatar;

    @NotNull
    private String giftSendAvatar;

    @Nullable
    private String giftText;

    @Nullable
    private Integer giftType;

    @Nullable
    private SvipData receiveSvip;

    @Nullable
    private String receiveUserNick;

    @NotNull
    private String receiverAvatar;

    @Nullable
    private String receiverId;

    @NotNull
    private String sendUserAvatar;

    @Nullable
    private String sendUserId;

    @Nullable
    private String sendUserNick;

    @Nullable
    private SvipData svip;

    @Nullable
    private List<TextStyles> textStyleList;

    @Nullable
    private String type;

    public GiftDateItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable SvipData svipData, @Nullable SvipData svipData2, @NotNull String str7, @NotNull String str8, @Nullable Integer num, @Nullable List<TextStyles> list, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        Intrinsics.checkNotNullParameter(str, "effectSvga");
        Intrinsics.checkNotNullParameter(str2, "sendUserAvatar");
        Intrinsics.checkNotNullParameter(str3, "receiverAvatar");
        Intrinsics.checkNotNullParameter(str7, "giftSendAvatar");
        Intrinsics.checkNotNullParameter(str8, "giftReceiverAvatar");
        this.effectSvga = str;
        this.sendUserAvatar = str2;
        this.receiverAvatar = str3;
        this.sendUserId = str4;
        this.receiverId = str5;
        this.type = str6;
        this.svip = svipData;
        this.receiveSvip = svipData2;
        this.giftSendAvatar = str7;
        this.giftReceiverAvatar = str8;
        this.giftType = num;
        this.textStyleList = list;
        this.receiveUserNick = str9;
        this.sendUserNick = str10;
        this.giftText = str11;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getEffectSvga() {
        return this.effectSvga;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getGiftReceiverAvatar() {
        return this.giftReceiverAvatar;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Integer getGiftType() {
        return this.giftType;
    }

    @Nullable
    public final List<TextStyles> component12() {
        return this.textStyleList;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getReceiveUserNick() {
        return this.receiveUserNick;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getSendUserNick() {
        return this.sendUserNick;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getGiftText() {
        return this.giftText;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSendUserAvatar() {
        return this.sendUserAvatar;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getSendUserId() {
        return this.sendUserId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getReceiverId() {
        return this.receiverId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final SvipData getReceiveSvip() {
        return this.receiveSvip;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getGiftSendAvatar() {
        return this.giftSendAvatar;
    }

    @NotNull
    public final GiftDateItem copy(@NotNull String effectSvga, @NotNull String sendUserAvatar, @NotNull String receiverAvatar, @Nullable String sendUserId, @Nullable String receiverId, @Nullable String type, @Nullable SvipData svip, @Nullable SvipData receiveSvip, @NotNull String giftSendAvatar, @NotNull String giftReceiverAvatar, @Nullable Integer giftType, @Nullable List<TextStyles> textStyleList, @Nullable String receiveUserNick, @Nullable String sendUserNick, @Nullable String giftText) {
        Intrinsics.checkNotNullParameter(effectSvga, "effectSvga");
        Intrinsics.checkNotNullParameter(sendUserAvatar, "sendUserAvatar");
        Intrinsics.checkNotNullParameter(receiverAvatar, "receiverAvatar");
        Intrinsics.checkNotNullParameter(giftSendAvatar, "giftSendAvatar");
        Intrinsics.checkNotNullParameter(giftReceiverAvatar, "giftReceiverAvatar");
        return new GiftDateItem(effectSvga, sendUserAvatar, receiverAvatar, sendUserId, receiverId, type, svip, receiveSvip, giftSendAvatar, giftReceiverAvatar, giftType, textStyleList, receiveUserNick, sendUserNick, giftText);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftDateItem)) {
            return false;
        }
        GiftDateItem giftDateItem = (GiftDateItem) other;
        return Intrinsics.areEqual(this.effectSvga, giftDateItem.effectSvga) && Intrinsics.areEqual(this.sendUserAvatar, giftDateItem.sendUserAvatar) && Intrinsics.areEqual(this.receiverAvatar, giftDateItem.receiverAvatar) && Intrinsics.areEqual(this.sendUserId, giftDateItem.sendUserId) && Intrinsics.areEqual(this.receiverId, giftDateItem.receiverId) && Intrinsics.areEqual(this.type, giftDateItem.type) && Intrinsics.areEqual(this.svip, giftDateItem.svip) && Intrinsics.areEqual(this.receiveSvip, giftDateItem.receiveSvip) && Intrinsics.areEqual(this.giftSendAvatar, giftDateItem.giftSendAvatar) && Intrinsics.areEqual(this.giftReceiverAvatar, giftDateItem.giftReceiverAvatar) && Intrinsics.areEqual(this.giftType, giftDateItem.giftType) && Intrinsics.areEqual(this.textStyleList, giftDateItem.textStyleList) && Intrinsics.areEqual(this.receiveUserNick, giftDateItem.receiveUserNick) && Intrinsics.areEqual(this.sendUserNick, giftDateItem.sendUserNick) && Intrinsics.areEqual(this.giftText, giftDateItem.giftText);
    }

    @NotNull
    public final String getEffectSvga() {
        return this.effectSvga;
    }

    @NotNull
    public final String getGiftReceiverAvatar() {
        return this.giftReceiverAvatar;
    }

    @NotNull
    public final String getGiftSendAvatar() {
        return this.giftSendAvatar;
    }

    @Nullable
    public final String getGiftText() {
        return this.giftText;
    }

    @Nullable
    public final Integer getGiftType() {
        return this.giftType;
    }

    @Nullable
    public final SvipData getReceiveSvip() {
        return this.receiveSvip;
    }

    @Nullable
    public final String getReceiveUserNick() {
        return this.receiveUserNick;
    }

    @NotNull
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @Nullable
    public final String getReceiverId() {
        return this.receiverId;
    }

    @NotNull
    public final String getSendUserAvatar() {
        return this.sendUserAvatar;
    }

    @Nullable
    public final String getSendUserId() {
        return this.sendUserId;
    }

    @Nullable
    public final String getSendUserNick() {
        return this.sendUserNick;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    public final List<TextStyles> getTextStyleList() {
        return this.textStyleList;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((this.effectSvga.hashCode() * 31) + this.sendUserAvatar.hashCode()) * 31) + this.receiverAvatar.hashCode()) * 31;
        String str = this.sendUserId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.receiverId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        SvipData svipData = this.svip;
        int hashCode5 = (hashCode4 + (svipData == null ? 0 : svipData.hashCode())) * 31;
        SvipData svipData2 = this.receiveSvip;
        int hashCode6 = (((((hashCode5 + (svipData2 == null ? 0 : svipData2.hashCode())) * 31) + this.giftSendAvatar.hashCode()) * 31) + this.giftReceiverAvatar.hashCode()) * 31;
        Integer num = this.giftType;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        List<TextStyles> list = this.textStyleList;
        int hashCode8 = (hashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.receiveUserNick;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sendUserNick;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.giftText;
        return hashCode10 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setEffectSvga(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.effectSvga = str;
    }

    public final void setGiftReceiverAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.giftReceiverAvatar = str;
    }

    public final void setGiftSendAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.giftSendAvatar = str;
    }

    public final void setGiftText(@Nullable String str) {
        this.giftText = str;
    }

    public final void setGiftType(@Nullable Integer num) {
        this.giftType = num;
    }

    public final void setReceiveSvip(@Nullable SvipData svipData) {
        this.receiveSvip = svipData;
    }

    public final void setReceiveUserNick(@Nullable String str) {
        this.receiveUserNick = str;
    }

    public final void setReceiverAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.receiverAvatar = str;
    }

    public final void setReceiverId(@Nullable String str) {
        this.receiverId = str;
    }

    public final void setSendUserAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sendUserAvatar = str;
    }

    public final void setSendUserId(@Nullable String str) {
        this.sendUserId = str;
    }

    public final void setSendUserNick(@Nullable String str) {
        this.sendUserNick = str;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setTextStyleList(@Nullable List<TextStyles> list) {
        this.textStyleList = list;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    @NotNull
    public String toString() {
        return "GiftDateItem(effectSvga=" + this.effectSvga + ", sendUserAvatar=" + this.sendUserAvatar + ", receiverAvatar=" + this.receiverAvatar + ", sendUserId=" + this.sendUserId + ", receiverId=" + this.receiverId + ", type=" + this.type + ", svip=" + this.svip + ", receiveSvip=" + this.receiveSvip + ", giftSendAvatar=" + this.giftSendAvatar + ", giftReceiverAvatar=" + this.giftReceiverAvatar + ", giftType=" + this.giftType + ", textStyleList=" + this.textStyleList + ", receiveUserNick=" + this.receiveUserNick + ", sendUserNick=" + this.sendUserNick + ", giftText=" + this.giftText + ")";
    }

    public /* synthetic */ GiftDateItem(String str, String str2, String str3, String str4, String str5, String str6, SvipData svipData, SvipData svipData2, String str7, String str8, Integer num, List list, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? null : svipData, (i & 128) != 0 ? null : svipData2, (i & 256) != 0 ? "" : str7, (i & 512) == 0 ? str8 : "", (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? 0 : num, (i & 2048) != 0 ? null : list, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & 16384) == 0 ? str11 : null);
    }
}
