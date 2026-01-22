package com.qiahao.nextvideo.ui.hiloassistant;

import androidx.annotation.Keep;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.data.model.HiloAssistantItem;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0001@B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u001d\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u0094\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\bHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u001bR\u001e\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u001bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b+\u0010%\"\u0004\b,\u0010'R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b-\u0010%\"\u0004\b.\u0010'¨\u0006A"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCellUIModel;", "", "content", "", "user", "Lcom/qiahao/base_common/model/common/User;", "createTimeInDate", "type", "", "contentIcons", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "actionUrl", "actionType", "picUrl", "picWidth", "picHeight", "<init>", "(Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Ljava/lang/String;ILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getCreateTimeInDate", "setCreateTimeInDate", "(Ljava/lang/String;)V", "getType", "()I", "getContentIcons", "()Ljava/util/ArrayList;", "setContentIcons", "(Ljava/util/ArrayList;)V", "getActionUrl", "setActionUrl", "getActionType", "()Ljava/lang/Integer;", "setActionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPicUrl", "setPicUrl", "getPicWidth", "setPicWidth", "getPicHeight", "setPicHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Ljava/lang/String;ILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCellUIModel;", "equals", "", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class HiloAssistantCellUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String regexTimestamp = "{timestamp}";

    @Nullable
    private Integer actionType;

    @Nullable
    private String actionUrl;

    @NotNull
    private final String content;

    @Nullable
    private ArrayList<String> contentIcons;

    @Nullable
    private String createTimeInDate;

    @Nullable
    private Integer picHeight;

    @Nullable
    private String picUrl;

    @Nullable
    private Integer picWidth;
    private final int type;

    @Nullable
    private User user;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCellUIModel$Companion;", "", "<init>", "()V", "regexTimestamp", "", "init", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCellUIModel;", "hiloAssistantItem", "Lcom/qiahao/nextvideo/data/model/HiloAssistantItem;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HiloAssistantCellUIModel init(@NotNull HiloAssistantItem hiloAssistantItem) {
            Intrinsics.checkNotNullParameter(hiloAssistantItem, "hiloAssistantItem");
            String dateInSecs$default = DateTimeUtilityKt.getDateInSecs$default(hiloAssistantItem.getCreateTime(), (Locale) null, "yyyy-MM-dd HH:mm:ss", 2, (Object) null);
            String content = hiloAssistantItem.getContent();
            if (content == null) {
                content = "";
            }
            return new HiloAssistantCellUIModel(StringsKt.replace$default(content, HiloAssistantCellUIModel.regexTimestamp, dateInSecs$default, false, 4, (Object) null), hiloAssistantItem.getUser(), DateTimeUtilityKt.getDateHmsInSecond$default(hiloAssistantItem.getCreateTime(), (Locale) null, "MM-dd HH:mm", 2, (Object) null), hiloAssistantItem.getType(), hiloAssistantItem.getContentIcons(), hiloAssistantItem.getActionUrl(), hiloAssistantItem.getActionType(), hiloAssistantItem.getPicUrl(), hiloAssistantItem.getPicWidth(), hiloAssistantItem.getPicHeight());
        }

        private Companion() {
        }
    }

    public HiloAssistantCellUIModel(@NotNull String str, @Nullable User user, @Nullable String str2, int i, @Nullable ArrayList<String> arrayList, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable Integer num2, @Nullable Integer num3) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.content = str;
        this.user = user;
        this.createTimeInDate = str2;
        this.type = i;
        this.contentIcons = arrayList;
        this.actionUrl = str3;
        this.actionType = num;
        this.picUrl = str4;
        this.picWidth = num2;
        this.picHeight = num3;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getPicHeight() {
        return this.picHeight;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getCreateTimeInDate() {
        return this.createTimeInDate;
    }

    /* renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Nullable
    public final ArrayList<String> component5() {
        return this.contentIcons;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getActionUrl() {
        return this.actionUrl;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getActionType() {
        return this.actionType;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getPicWidth() {
        return this.picWidth;
    }

    @NotNull
    public final HiloAssistantCellUIModel copy(@NotNull String content, @Nullable User user, @Nullable String createTimeInDate, int type, @Nullable ArrayList<String> contentIcons, @Nullable String actionUrl, @Nullable Integer actionType, @Nullable String picUrl, @Nullable Integer picWidth, @Nullable Integer picHeight) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new HiloAssistantCellUIModel(content, user, createTimeInDate, type, contentIcons, actionUrl, actionType, picUrl, picWidth, picHeight);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiloAssistantCellUIModel)) {
            return false;
        }
        HiloAssistantCellUIModel hiloAssistantCellUIModel = (HiloAssistantCellUIModel) other;
        return Intrinsics.areEqual(this.content, hiloAssistantCellUIModel.content) && Intrinsics.areEqual(this.user, hiloAssistantCellUIModel.user) && Intrinsics.areEqual(this.createTimeInDate, hiloAssistantCellUIModel.createTimeInDate) && this.type == hiloAssistantCellUIModel.type && Intrinsics.areEqual(this.contentIcons, hiloAssistantCellUIModel.contentIcons) && Intrinsics.areEqual(this.actionUrl, hiloAssistantCellUIModel.actionUrl) && Intrinsics.areEqual(this.actionType, hiloAssistantCellUIModel.actionType) && Intrinsics.areEqual(this.picUrl, hiloAssistantCellUIModel.picUrl) && Intrinsics.areEqual(this.picWidth, hiloAssistantCellUIModel.picWidth) && Intrinsics.areEqual(this.picHeight, hiloAssistantCellUIModel.picHeight);
    }

    @Nullable
    public final Integer getActionType() {
        return this.actionType;
    }

    @Nullable
    public final String getActionUrl() {
        return this.actionUrl;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final ArrayList<String> getContentIcons() {
        return this.contentIcons;
    }

    @Nullable
    public final String getCreateTimeInDate() {
        return this.createTimeInDate;
    }

    @Nullable
    public final Integer getPicHeight() {
        return this.picHeight;
    }

    @Nullable
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final Integer getPicWidth() {
        return this.picWidth;
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.content.hashCode() * 31;
        User user = this.user;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        String str = this.createTimeInDate;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.type) * 31;
        ArrayList<String> arrayList = this.contentIcons;
        int hashCode4 = (hashCode3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str2 = this.actionUrl;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.actionType;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.picUrl;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.picWidth;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.picHeight;
        return hashCode8 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setActionType(@Nullable Integer num) {
        this.actionType = num;
    }

    public final void setActionUrl(@Nullable String str) {
        this.actionUrl = str;
    }

    public final void setContentIcons(@Nullable ArrayList<String> arrayList) {
        this.contentIcons = arrayList;
    }

    public final void setCreateTimeInDate(@Nullable String str) {
        this.createTimeInDate = str;
    }

    public final void setPicHeight(@Nullable Integer num) {
        this.picHeight = num;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setPicWidth(@Nullable Integer num) {
        this.picWidth = num;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "HiloAssistantCellUIModel(content=" + this.content + ", user=" + this.user + ", createTimeInDate=" + this.createTimeInDate + ", type=" + this.type + ", contentIcons=" + this.contentIcons + ", actionUrl=" + this.actionUrl + ", actionType=" + this.actionType + ", picUrl=" + this.picUrl + ", picWidth=" + this.picWidth + ", picHeight=" + this.picHeight + ")";
    }

    public /* synthetic */ HiloAssistantCellUIModel(String str, User user, String str2, int i, ArrayList arrayList, String str3, Integer num, String str4, Integer num2, Integer num3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : user, str2, i, arrayList, str3, num, str4, (i2 & 256) != 0 ? null : num2, (i2 & 512) != 0 ? null : num3);
    }
}
