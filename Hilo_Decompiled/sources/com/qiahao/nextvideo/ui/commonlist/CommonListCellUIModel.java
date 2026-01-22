package com.qiahao.nextvideo.ui.commonlist;

import android.graphics.Typeface;
import androidx.annotation.Keep;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 [2\u00020\u0001:\u0001[Bõ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010G\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010Q\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010R\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010S\u001a\u00020\u0019HÆ\u0003Jü\u0001\u0010T\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0019HÆ\u0001¢\u0006\u0002\u0010UJ\u0013\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020\nHÖ\u0001J\t\u0010Z\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010'\u001a\u0004\b(\u0010$R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010'\u001a\u0004\b)\u0010$R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010,R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b6\u0010$\"\u0004\b7\u0010&R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b8\u0010$\"\u0004\b9\u0010&R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?¨\u0006\\"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/CommonListCellUIModel;", "", "iconCircleDisplayImageUIModel", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "iconCircleR2TTagText", "", "itemId", "title", "titleRightTagText", "titleTextColor", "", "titleRightTagDrawable", "titleDrawableStart", "endTopText", "subtitle", "endText", "endTextColor", "endIconDisplayImageUIModel", "subtitleLeftIconImageUIModel", "titleRightTagBackgroundResID", "endIconClickTag", "subtitleTextColor", "endTextSize", "nextUIModel", "titleTextStyle", "Landroid/graphics/Typeface;", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Landroid/graphics/Typeface;)V", "getIconCircleDisplayImageUIModel", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "getIconCircleR2TTagText", "()Ljava/lang/String;", "getItemId", "getTitle", "getTitleRightTagText", "getTitleTextColor", "()Ljava/lang/Integer;", "setTitleTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitleRightTagDrawable", "getTitleDrawableStart", "getEndTopText", "setEndTopText", "(Ljava/lang/String;)V", "getSubtitle", "getEndText", "getEndTextColor", "setEndTextColor", "getEndIconDisplayImageUIModel", "getSubtitleLeftIconImageUIModel", "getTitleRightTagBackgroundResID", "setTitleRightTagBackgroundResID", "getEndIconClickTag", "getSubtitleTextColor", "setSubtitleTextColor", "getEndTextSize", "setEndTextSize", "getNextUIModel", "()Ljava/lang/Object;", "setNextUIModel", "(Ljava/lang/Object;)V", "getTitleTextStyle", "()Landroid/graphics/Typeface;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Landroid/graphics/Typeface;)Lcom/qiahao/nextvideo/ui/commonlist/CommonListCellUIModel;", "equals", "", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CommonListCellUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String endIconClickTag;

    @Nullable
    private final ImageUIModel endIconDisplayImageUIModel;

    @Nullable
    private final String endText;

    @Nullable
    private Integer endTextColor;

    @Nullable
    private Integer endTextSize;

    @Nullable
    private String endTopText;

    @Nullable
    private final ImageUIModel iconCircleDisplayImageUIModel;

    @Nullable
    private final String iconCircleR2TTagText;

    @Nullable
    private final String itemId;

    @Nullable
    private Object nextUIModel;

    @Nullable
    private final String subtitle;

    @Nullable
    private final ImageUIModel subtitleLeftIconImageUIModel;

    @Nullable
    private Integer subtitleTextColor;

    @Nullable
    private final String title;

    @Nullable
    private final Integer titleDrawableStart;

    @Nullable
    private Integer titleRightTagBackgroundResID;

    @Nullable
    private final Integer titleRightTagDrawable;

    @Nullable
    private final String titleRightTagText;

    @Nullable
    private Integer titleTextColor;

    @NotNull
    private final Typeface titleTextStyle;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/CommonListCellUIModel$Companion;", "", "<init>", "()V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CommonListCellUIModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final ImageUIModel getIconCircleDisplayImageUIModel() {
        return this.iconCircleDisplayImageUIModel;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getEndText() {
        return this.endText;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getEndTextColor() {
        return this.endTextColor;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final ImageUIModel getEndIconDisplayImageUIModel() {
        return this.endIconDisplayImageUIModel;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final ImageUIModel getSubtitleLeftIconImageUIModel() {
        return this.subtitleLeftIconImageUIModel;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Integer getTitleRightTagBackgroundResID() {
        return this.titleRightTagBackgroundResID;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getEndIconClickTag() {
        return this.endIconClickTag;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Integer getSubtitleTextColor() {
        return this.subtitleTextColor;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final Integer getEndTextSize() {
        return this.endTextSize;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final Object getNextUIModel() {
        return this.nextUIModel;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIconCircleR2TTagText() {
        return this.iconCircleR2TTagText;
    }

    @NotNull
    /* renamed from: component20, reason: from getter */
    public final Typeface getTitleTextStyle() {
        return this.titleTextStyle;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTitleRightTagText() {
        return this.titleRightTagText;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getTitleTextColor() {
        return this.titleTextColor;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getTitleRightTagDrawable() {
        return this.titleRightTagDrawable;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getTitleDrawableStart() {
        return this.titleDrawableStart;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getEndTopText() {
        return this.endTopText;
    }

    @NotNull
    public final CommonListCellUIModel copy(@Nullable ImageUIModel iconCircleDisplayImageUIModel, @Nullable String iconCircleR2TTagText, @Nullable String itemId, @Nullable String title, @Nullable String titleRightTagText, @Nullable Integer titleTextColor, @Nullable Integer titleRightTagDrawable, @Nullable Integer titleDrawableStart, @Nullable String endTopText, @Nullable String subtitle, @Nullable String endText, @Nullable Integer endTextColor, @Nullable ImageUIModel endIconDisplayImageUIModel, @Nullable ImageUIModel subtitleLeftIconImageUIModel, @Nullable Integer titleRightTagBackgroundResID, @Nullable String endIconClickTag, @Nullable Integer subtitleTextColor, @Nullable Integer endTextSize, @Nullable Object nextUIModel, @NotNull Typeface titleTextStyle) {
        Intrinsics.checkNotNullParameter(titleTextStyle, "titleTextStyle");
        return new CommonListCellUIModel(iconCircleDisplayImageUIModel, iconCircleR2TTagText, itemId, title, titleRightTagText, titleTextColor, titleRightTagDrawable, titleDrawableStart, endTopText, subtitle, endText, endTextColor, endIconDisplayImageUIModel, subtitleLeftIconImageUIModel, titleRightTagBackgroundResID, endIconClickTag, subtitleTextColor, endTextSize, nextUIModel, titleTextStyle);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonListCellUIModel)) {
            return false;
        }
        CommonListCellUIModel commonListCellUIModel = (CommonListCellUIModel) other;
        return Intrinsics.areEqual(this.iconCircleDisplayImageUIModel, commonListCellUIModel.iconCircleDisplayImageUIModel) && Intrinsics.areEqual(this.iconCircleR2TTagText, commonListCellUIModel.iconCircleR2TTagText) && Intrinsics.areEqual(this.itemId, commonListCellUIModel.itemId) && Intrinsics.areEqual(this.title, commonListCellUIModel.title) && Intrinsics.areEqual(this.titleRightTagText, commonListCellUIModel.titleRightTagText) && Intrinsics.areEqual(this.titleTextColor, commonListCellUIModel.titleTextColor) && Intrinsics.areEqual(this.titleRightTagDrawable, commonListCellUIModel.titleRightTagDrawable) && Intrinsics.areEqual(this.titleDrawableStart, commonListCellUIModel.titleDrawableStart) && Intrinsics.areEqual(this.endTopText, commonListCellUIModel.endTopText) && Intrinsics.areEqual(this.subtitle, commonListCellUIModel.subtitle) && Intrinsics.areEqual(this.endText, commonListCellUIModel.endText) && Intrinsics.areEqual(this.endTextColor, commonListCellUIModel.endTextColor) && Intrinsics.areEqual(this.endIconDisplayImageUIModel, commonListCellUIModel.endIconDisplayImageUIModel) && Intrinsics.areEqual(this.subtitleLeftIconImageUIModel, commonListCellUIModel.subtitleLeftIconImageUIModel) && Intrinsics.areEqual(this.titleRightTagBackgroundResID, commonListCellUIModel.titleRightTagBackgroundResID) && Intrinsics.areEqual(this.endIconClickTag, commonListCellUIModel.endIconClickTag) && Intrinsics.areEqual(this.subtitleTextColor, commonListCellUIModel.subtitleTextColor) && Intrinsics.areEqual(this.endTextSize, commonListCellUIModel.endTextSize) && Intrinsics.areEqual(this.nextUIModel, commonListCellUIModel.nextUIModel) && Intrinsics.areEqual(this.titleTextStyle, commonListCellUIModel.titleTextStyle);
    }

    @Nullable
    public final String getEndIconClickTag() {
        return this.endIconClickTag;
    }

    @Nullable
    public final ImageUIModel getEndIconDisplayImageUIModel() {
        return this.endIconDisplayImageUIModel;
    }

    @Nullable
    public final String getEndText() {
        return this.endText;
    }

    @Nullable
    public final Integer getEndTextColor() {
        return this.endTextColor;
    }

    @Nullable
    public final Integer getEndTextSize() {
        return this.endTextSize;
    }

    @Nullable
    public final String getEndTopText() {
        return this.endTopText;
    }

    @Nullable
    public final ImageUIModel getIconCircleDisplayImageUIModel() {
        return this.iconCircleDisplayImageUIModel;
    }

    @Nullable
    public final String getIconCircleR2TTagText() {
        return this.iconCircleR2TTagText;
    }

    @Nullable
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final Object getNextUIModel() {
        return this.nextUIModel;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final ImageUIModel getSubtitleLeftIconImageUIModel() {
        return this.subtitleLeftIconImageUIModel;
    }

    @Nullable
    public final Integer getSubtitleTextColor() {
        return this.subtitleTextColor;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getTitleDrawableStart() {
        return this.titleDrawableStart;
    }

    @Nullable
    public final Integer getTitleRightTagBackgroundResID() {
        return this.titleRightTagBackgroundResID;
    }

    @Nullable
    public final Integer getTitleRightTagDrawable() {
        return this.titleRightTagDrawable;
    }

    @Nullable
    public final String getTitleRightTagText() {
        return this.titleRightTagText;
    }

    @Nullable
    public final Integer getTitleTextColor() {
        return this.titleTextColor;
    }

    @NotNull
    public final Typeface getTitleTextStyle() {
        return this.titleTextStyle;
    }

    public int hashCode() {
        ImageUIModel imageUIModel = this.iconCircleDisplayImageUIModel;
        int hashCode = (imageUIModel == null ? 0 : imageUIModel.hashCode()) * 31;
        String str = this.iconCircleR2TTagText;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.itemId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.titleRightTagText;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.titleTextColor;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.titleRightTagDrawable;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.titleDrawableStart;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str5 = this.endTopText;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.subtitle;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.endText;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num4 = this.endTextColor;
        int hashCode12 = (hashCode11 + (num4 == null ? 0 : num4.hashCode())) * 31;
        ImageUIModel imageUIModel2 = this.endIconDisplayImageUIModel;
        int hashCode13 = (hashCode12 + (imageUIModel2 == null ? 0 : imageUIModel2.hashCode())) * 31;
        ImageUIModel imageUIModel3 = this.subtitleLeftIconImageUIModel;
        int hashCode14 = (hashCode13 + (imageUIModel3 == null ? 0 : imageUIModel3.hashCode())) * 31;
        Integer num5 = this.titleRightTagBackgroundResID;
        int hashCode15 = (hashCode14 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str8 = this.endIconClickTag;
        int hashCode16 = (hashCode15 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num6 = this.subtitleTextColor;
        int hashCode17 = (hashCode16 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.endTextSize;
        int hashCode18 = (hashCode17 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Object obj = this.nextUIModel;
        return ((hashCode18 + (obj != null ? obj.hashCode() : 0)) * 31) + this.titleTextStyle.hashCode();
    }

    public final void setEndTextColor(@Nullable Integer num) {
        this.endTextColor = num;
    }

    public final void setEndTextSize(@Nullable Integer num) {
        this.endTextSize = num;
    }

    public final void setEndTopText(@Nullable String str) {
        this.endTopText = str;
    }

    public final void setNextUIModel(@Nullable Object obj) {
        this.nextUIModel = obj;
    }

    public final void setSubtitleTextColor(@Nullable Integer num) {
        this.subtitleTextColor = num;
    }

    public final void setTitleRightTagBackgroundResID(@Nullable Integer num) {
        this.titleRightTagBackgroundResID = num;
    }

    public final void setTitleTextColor(@Nullable Integer num) {
        this.titleTextColor = num;
    }

    @NotNull
    public String toString() {
        return "CommonListCellUIModel(iconCircleDisplayImageUIModel=" + this.iconCircleDisplayImageUIModel + ", iconCircleR2TTagText=" + this.iconCircleR2TTagText + ", itemId=" + this.itemId + ", title=" + this.title + ", titleRightTagText=" + this.titleRightTagText + ", titleTextColor=" + this.titleTextColor + ", titleRightTagDrawable=" + this.titleRightTagDrawable + ", titleDrawableStart=" + this.titleDrawableStart + ", endTopText=" + this.endTopText + ", subtitle=" + this.subtitle + ", endText=" + this.endText + ", endTextColor=" + this.endTextColor + ", endIconDisplayImageUIModel=" + this.endIconDisplayImageUIModel + ", subtitleLeftIconImageUIModel=" + this.subtitleLeftIconImageUIModel + ", titleRightTagBackgroundResID=" + this.titleRightTagBackgroundResID + ", endIconClickTag=" + this.endIconClickTag + ", subtitleTextColor=" + this.subtitleTextColor + ", endTextSize=" + this.endTextSize + ", nextUIModel=" + this.nextUIModel + ", titleTextStyle=" + this.titleTextStyle + ")";
    }

    public CommonListCellUIModel(@Nullable ImageUIModel imageUIModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Integer num4, @Nullable ImageUIModel imageUIModel2, @Nullable ImageUIModel imageUIModel3, @Nullable Integer num5, @Nullable String str8, @Nullable Integer num6, @Nullable Integer num7, @Nullable Object obj, @NotNull Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "titleTextStyle");
        this.iconCircleDisplayImageUIModel = imageUIModel;
        this.iconCircleR2TTagText = str;
        this.itemId = str2;
        this.title = str3;
        this.titleRightTagText = str4;
        this.titleTextColor = num;
        this.titleRightTagDrawable = num2;
        this.titleDrawableStart = num3;
        this.endTopText = str5;
        this.subtitle = str6;
        this.endText = str7;
        this.endTextColor = num4;
        this.endIconDisplayImageUIModel = imageUIModel2;
        this.subtitleLeftIconImageUIModel = imageUIModel3;
        this.titleRightTagBackgroundResID = num5;
        this.endIconClickTag = str8;
        this.subtitleTextColor = num6;
        this.endTextSize = num7;
        this.nextUIModel = obj;
        this.titleTextStyle = typeface;
    }

    public /* synthetic */ CommonListCellUIModel(ImageUIModel imageUIModel, String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, String str5, String str6, String str7, Integer num4, ImageUIModel imageUIModel2, ImageUIModel imageUIModel3, Integer num5, String str8, Integer num6, Integer num7, Object obj, Typeface typeface, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imageUIModel, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : num3, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : str7, (i & 2048) != 0 ? null : num4, (i & 4096) != 0 ? null : imageUIModel2, (i & 8192) != 0 ? null : imageUIModel3, (i & 16384) != 0 ? null : num5, (i & 32768) != 0 ? null : str8, (i & 65536) != 0 ? null : num6, (i & 131072) != 0 ? null : num7, (i & 262144) != 0 ? null : obj, (i & 524288) != 0 ? Typeface.DEFAULT_BOLD : typeface);
    }
}
