package com.qiahao.nextvideo.data;

import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.data.model.HiloInformationItem;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJj\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\nHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/data/HiloInformationCellUIModel;", "", "title", "", "imageUIModel", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "subtitle", "createTimeInDate", "actionUrl", "actionType", "", "picWidth", "picHeight", "<init>", "(Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "getImageUIModel", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "getSubtitle", "getCreateTimeInDate", "getActionUrl", "getActionType", "()I", "setActionType", "(I)V", "getPicWidth", "()Ljava/lang/Integer;", "setPicWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPicHeight", "setPicHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/HiloInformationCellUIModel;", "equals", "", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class HiloInformationCellUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int actionType;

    @Nullable
    private final String actionUrl;

    @Nullable
    private final String createTimeInDate;

    @NotNull
    private final ImageUIModel imageUIModel;

    @Nullable
    private Integer picHeight;

    @Nullable
    private Integer picWidth;

    @Nullable
    private final String subtitle;

    @Nullable
    private final String title;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/data/HiloInformationCellUIModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/data/HiloInformationCellUIModel;", "entity", "Lcom/qiahao/nextvideo/data/model/HiloInformationItem;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HiloInformationCellUIModel init(@NotNull HiloInformationItem entity) {
            long j;
            Intrinsics.checkNotNullParameter(entity, "entity");
            String title = entity.getTitle();
            ImageUIModel onlineThumbnail = ImageUIModel.INSTANCE.onlineThumbnail(entity.getPicUrl());
            String content = entity.getContent();
            Long createTime = entity.getCreateTime();
            if (createTime != null) {
                j = createTime.longValue();
            } else {
                j = 0;
            }
            return new HiloInformationCellUIModel(title, onlineThumbnail, content, DateTimeUtilityKt.getDateHmsInSecond$default(j, (Locale) null, "MM-dd HH:mm", 2, (Object) null), entity.getActionUrl(), entity.getActionType(), entity.getPicWidth(), entity.getPicHeight());
        }

        private Companion() {
        }
    }

    public HiloInformationCellUIModel(@Nullable String str, @NotNull ImageUIModel imageUIModel, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(imageUIModel, "imageUIModel");
        this.title = str;
        this.imageUIModel = imageUIModel;
        this.subtitle = str2;
        this.createTimeInDate = str3;
        this.actionUrl = str4;
        this.actionType = i;
        this.picWidth = num;
        this.picHeight = num2;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ImageUIModel getImageUIModel() {
        return this.imageUIModel;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCreateTimeInDate() {
        return this.createTimeInDate;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getActionUrl() {
        return this.actionUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getPicWidth() {
        return this.picWidth;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getPicHeight() {
        return this.picHeight;
    }

    @NotNull
    public final HiloInformationCellUIModel copy(@Nullable String title, @NotNull ImageUIModel imageUIModel, @Nullable String subtitle, @Nullable String createTimeInDate, @Nullable String actionUrl, int actionType, @Nullable Integer picWidth, @Nullable Integer picHeight) {
        Intrinsics.checkNotNullParameter(imageUIModel, "imageUIModel");
        return new HiloInformationCellUIModel(title, imageUIModel, subtitle, createTimeInDate, actionUrl, actionType, picWidth, picHeight);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiloInformationCellUIModel)) {
            return false;
        }
        HiloInformationCellUIModel hiloInformationCellUIModel = (HiloInformationCellUIModel) other;
        return Intrinsics.areEqual(this.title, hiloInformationCellUIModel.title) && Intrinsics.areEqual(this.imageUIModel, hiloInformationCellUIModel.imageUIModel) && Intrinsics.areEqual(this.subtitle, hiloInformationCellUIModel.subtitle) && Intrinsics.areEqual(this.createTimeInDate, hiloInformationCellUIModel.createTimeInDate) && Intrinsics.areEqual(this.actionUrl, hiloInformationCellUIModel.actionUrl) && this.actionType == hiloInformationCellUIModel.actionType && Intrinsics.areEqual(this.picWidth, hiloInformationCellUIModel.picWidth) && Intrinsics.areEqual(this.picHeight, hiloInformationCellUIModel.picHeight);
    }

    public final int getActionType() {
        return this.actionType;
    }

    @Nullable
    public final String getActionUrl() {
        return this.actionUrl;
    }

    @Nullable
    public final String getCreateTimeInDate() {
        return this.createTimeInDate;
    }

    @NotNull
    public final ImageUIModel getImageUIModel() {
        return this.imageUIModel;
    }

    @Nullable
    public final Integer getPicHeight() {
        return this.picHeight;
    }

    @Nullable
    public final Integer getPicWidth() {
        return this.picWidth;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.imageUIModel.hashCode()) * 31;
        String str2 = this.subtitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.createTimeInDate;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.actionUrl;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.actionType) * 31;
        Integer num = this.picWidth;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.picHeight;
        return hashCode5 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setActionType(int i) {
        this.actionType = i;
    }

    public final void setPicHeight(@Nullable Integer num) {
        this.picHeight = num;
    }

    public final void setPicWidth(@Nullable Integer num) {
        this.picWidth = num;
    }

    @NotNull
    public String toString() {
        return "HiloInformationCellUIModel(title=" + this.title + ", imageUIModel=" + this.imageUIModel + ", subtitle=" + this.subtitle + ", createTimeInDate=" + this.createTimeInDate + ", actionUrl=" + this.actionUrl + ", actionType=" + this.actionType + ", picWidth=" + this.picWidth + ", picHeight=" + this.picHeight + ")";
    }

    public /* synthetic */ HiloInformationCellUIModel(String str, ImageUIModel imageUIModel, String str2, String str3, String str4, int i, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, imageUIModel, str2, str3, str4, i, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : num2);
    }
}
