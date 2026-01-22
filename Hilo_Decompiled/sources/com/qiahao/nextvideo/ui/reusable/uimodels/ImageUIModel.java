package com.qiahao.nextvideo.ui.reusable.uimodels;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.utilities.Debug;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0001=BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rBe\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\f\u0010\u0010J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003J^\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0005J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006>"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "Landroid/os/Parcelable;", "imageUrl", "", "imageRes", "", ImageSelectActivity.PLACEHOLDER, "errorholder", "targetWidth", "targetHeight", "scaleType", "Landroid/widget/ImageView$ScaleType;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILandroid/widget/ImageView$ScaleType;)V", "resizeMode", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILandroid/widget/ImageView$ScaleType;Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode;)V", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "getImageRes", "()Ljava/lang/Integer;", "setImageRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPlaceholder", "setPlaceholder", "getErrorholder", "setErrorholder", "getTargetWidth", "()I", "setTargetWidth", "(I)V", "getTargetHeight", "setTargetHeight", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILandroid/widget/ImageView$ScaleType;)Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ImageUIModel implements Parcelable {
    private static final int chatThumbnailMaximumWidth;
    private static final int displayImageLength;
    private static final int feedThumbnailMaximumWidth;

    @Nullable
    private Integer errorholder;

    @Nullable
    private Integer imageRes;

    @Nullable
    private String imageUrl;

    @Nullable
    private Integer placeholder;

    @Nullable
    private ImageView.ScaleType scaleType;
    private int targetHeight;
    private int targetWidth;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<ImageUIModel> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0007J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001c\u0010\u0015\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0016\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0017\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0018\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0019\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u001a\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u0005J\u001c\u0010\u0019\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014JD\u0010\u001c\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel$Companion;", "", "<init>", "()V", "displayImageLength", "", "feedThumbnailMaximumWidth", "chatThumbnailMaximumWidth", "fake", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "fakeList", "", ImageSelectActivity.PLACEHOLDER, "imageRes", "scaleType", "Landroid/widget/ImageView$ScaleType;", "displayImage", "imageUrl", "", "resizeMode", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode;", "displayUserAvatarImage", "onlineThumbnail", "chatThumbnail", "countryTag", "full", "roomBackGroupFull", "drawableId", "UserDetailPicUIModel", "isShowHeadImg", "", "sex", "targetWidth", "targetHeight", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nImageUIModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageUIModel.kt\ncom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1563#2:195\n1634#2,3:196\n*S KotlinDebug\n*F\n+ 1 ImageUIModel.kt\ncom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel$Companion\n*L\n60#1:195\n60#1:196,3\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ImageUIModel UserDetailPicUIModel$default(Companion companion, String str, boolean z, int i, int i2, int i3, ResizeMode resizeMode, int i4, Object obj) {
            boolean z2;
            int i5;
            int i6;
            ResizeMode resizeMode2;
            int i7 = 0;
            if ((i4 & 2) != 0) {
                z2 = false;
            } else {
                z2 = z;
            }
            if ((i4 & 4) != 0) {
                i5 = 0;
            } else {
                i5 = i;
            }
            if ((i4 & 8) != 0) {
                i6 = 0;
            } else {
                i6 = i2;
            }
            if ((i4 & 16) == 0) {
                i7 = i3;
            }
            if ((i4 & 32) != 0) {
                resizeMode2 = null;
            } else {
                resizeMode2 = resizeMode;
            }
            return companion.UserDetailPicUIModel(str, z2, i5, i6, i7, resizeMode2);
        }

        public static /* synthetic */ ImageUIModel displayImage$default(Companion companion, String str, ResizeMode resizeMode, int i, Object obj) {
            if ((i & 2) != 0) {
                resizeMode = null;
            }
            return companion.displayImage(str, resizeMode);
        }

        public static /* synthetic */ ImageUIModel displayUserAvatarImage$default(Companion companion, String str, ResizeMode resizeMode, int i, Object obj) {
            if ((i & 2) != 0) {
                resizeMode = null;
            }
            return companion.displayUserAvatarImage(str, resizeMode);
        }

        public static /* synthetic */ ImageUIModel full$default(Companion companion, String str, ResizeMode resizeMode, int i, Object obj) {
            if ((i & 2) != 0) {
                resizeMode = null;
            }
            return companion.full(str, resizeMode);
        }

        public static /* synthetic */ ImageUIModel placeholder$default(Companion companion, int i, ImageView.ScaleType scaleType, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                scaleType = ImageView.ScaleType.FIT_CENTER;
            }
            return companion.placeholder(i, scaleType);
        }

        @NotNull
        public final ImageUIModel UserDetailPicUIModel(@Nullable String imageUrl, boolean isShowHeadImg, int sex, int targetWidth, int targetHeight, @Nullable ResizeMode resizeMode) {
            int i;
            if (isShowHeadImg) {
                if (sex != 1) {
                    i = R.drawable.bg_default_online_list_female_placeholder;
                } else {
                    i = R.drawable.bg_default_online_list_male_placeholder;
                }
            } else {
                i = R.drawable.normal_placeholder_image;
            }
            return new ImageUIModel(imageUrl, null, Integer.valueOf(i), null, targetWidth, targetHeight, null, resizeMode, 74, null);
        }

        @NotNull
        public final ImageUIModel chatThumbnail(@Nullable String imageUrl) {
            return new ImageUIModel(imageUrl, null, 2131232548, null, ImageUIModel.chatThumbnailMaximumWidth, 0, null, 106, null);
        }

        @NotNull
        public final ImageUIModel countryTag(@Nullable String imageUrl) {
            Dimens dimens = Dimens.INSTANCE;
            return new ImageUIModel(imageUrl, null, 2131232548, null, dimens.dpToPx(23), dimens.dpToPx(13), null, 74, null);
        }

        @NotNull
        public final ImageUIModel displayImage(@Nullable String imageUrl, @Nullable ResizeMode resizeMode) {
            return new ImageUIModel(imageUrl, null, 2131231930, null, 0, 0, ImageView.ScaleType.CENTER_CROP, resizeMode, 58, null);
        }

        @NotNull
        public final ImageUIModel displayUserAvatarImage(@Nullable String imageUrl, @Nullable ResizeMode resizeMode) {
            return new ImageUIModel(imageUrl, null, 2131232429, 2131232432, 0, 0, ImageView.ScaleType.CENTER_CROP, resizeMode, 50, null);
        }

        @NotNull
        public final ImageUIModel fake() {
            return new ImageUIModel((String) CollectionsKt.random(Debug.INSTANCE.getImages(), Random.Default), null, 2131232548, null, 0, 0, null, 122, null);
        }

        @JvmStatic
        @NotNull
        public final List<ImageUIModel> fakeList() {
            IntRange intRange = new IntRange(0, RangesKt.random(new IntRange(5, 10), Random.Default));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            IntIterator it = intRange.iterator();
            while (it.hasNext()) {
                it.nextInt();
                arrayList.add(new ImageUIModel((String) CollectionsKt.random(Debug.INSTANCE.getImages(), Random.Default), null, 2131232548, null, 0, 0, null, 122, null));
            }
            return arrayList;
        }

        @NotNull
        public final ImageUIModel full(@Nullable String imageUrl) {
            return new ImageUIModel(imageUrl, null, 2131232548, null, 0, 0, null, 122, null);
        }

        @NotNull
        public final ImageUIModel onlineThumbnail(@Nullable String imageUrl) {
            return new ImageUIModel(imageUrl, null, 2131232548, null, ImageUIModel.feedThumbnailMaximumWidth, 0, null, 106, null);
        }

        @NotNull
        public final ImageUIModel placeholder(int imageRes, @NotNull ImageView.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            return new ImageUIModel(null, Integer.valueOf(imageRes), null, null, 0, 0, scaleType, 61, null);
        }

        @NotNull
        public final ImageUIModel roomBackGroupFull(@Nullable String imageUrl, int drawableId) {
            return new ImageUIModel(imageUrl, null, Integer.valueOf(drawableId), null, 0, 0, null, 122, null);
        }

        private Companion() {
        }

        @NotNull
        public final ImageUIModel full(@Nullable String imageUrl, @Nullable ResizeMode resizeMode) {
            return new ImageUIModel(imageUrl, null, 2131232548, null, 0, 0, null, resizeMode, 122, null);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<ImageUIModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ImageUIModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageUIModel(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? null : ImageView.ScaleType.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ImageUIModel[] newArray(int i) {
            return new ImageUIModel[i];
        }
    }

    static {
        Dimens dimens = Dimens.INSTANCE;
        displayImageLength = dimens.dpToPx(40);
        feedThumbnailMaximumWidth = dimens.getScreenWidth() / 2;
        chatThumbnailMaximumWidth = (int) (dimens.getScreenWidth() * 0.75d);
    }

    public ImageUIModel() {
        this(null, null, null, null, 0, 0, null, 127, null);
    }

    public static /* synthetic */ ImageUIModel copy$default(ImageUIModel imageUIModel, String str, Integer num, Integer num2, Integer num3, int i, int i2, ImageView.ScaleType scaleType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = imageUIModel.imageUrl;
        }
        if ((i3 & 2) != 0) {
            num = imageUIModel.imageRes;
        }
        Integer num4 = num;
        if ((i3 & 4) != 0) {
            num2 = imageUIModel.placeholder;
        }
        Integer num5 = num2;
        if ((i3 & 8) != 0) {
            num3 = imageUIModel.errorholder;
        }
        Integer num6 = num3;
        if ((i3 & 16) != 0) {
            i = imageUIModel.targetWidth;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = imageUIModel.targetHeight;
        }
        int i5 = i2;
        if ((i3 & 64) != 0) {
            scaleType = imageUIModel.scaleType;
        }
        return imageUIModel.copy(str, num4, num5, num6, i4, i5, scaleType);
    }

    @JvmStatic
    @NotNull
    public static final List<ImageUIModel> fakeList() {
        return INSTANCE.fakeList();
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getImageRes() {
        return this.imageRes;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getPlaceholder() {
        return this.placeholder;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getErrorholder() {
        return this.errorholder;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTargetWidth() {
        return this.targetWidth;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTargetHeight() {
        return this.targetHeight;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final ImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    @NotNull
    public final ImageUIModel copy(@Nullable String imageUrl, @Nullable Integer imageRes, @Nullable Integer placeholder, @Nullable Integer errorholder, int targetWidth, int targetHeight, @Nullable ImageView.ScaleType scaleType) {
        return new ImageUIModel(imageUrl, imageRes, placeholder, errorholder, targetWidth, targetHeight, scaleType);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageUIModel)) {
            return false;
        }
        ImageUIModel imageUIModel = (ImageUIModel) other;
        return Intrinsics.areEqual(this.imageUrl, imageUIModel.imageUrl) && Intrinsics.areEqual(this.imageRes, imageUIModel.imageRes) && Intrinsics.areEqual(this.placeholder, imageUIModel.placeholder) && Intrinsics.areEqual(this.errorholder, imageUIModel.errorholder) && this.targetWidth == imageUIModel.targetWidth && this.targetHeight == imageUIModel.targetHeight && this.scaleType == imageUIModel.scaleType;
    }

    @Nullable
    public final Integer getErrorholder() {
        return this.errorholder;
    }

    @Nullable
    public final Integer getImageRes() {
        return this.imageRes;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final Integer getPlaceholder() {
        return this.placeholder;
    }

    @Nullable
    public final ImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    public final int getTargetHeight() {
        return this.targetHeight;
    }

    public final int getTargetWidth() {
        return this.targetWidth;
    }

    public int hashCode() {
        String str = this.imageUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.imageRes;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.placeholder;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.errorholder;
        int hashCode4 = (((((hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31) + this.targetWidth) * 31) + this.targetHeight) * 31;
        ImageView.ScaleType scaleType = this.scaleType;
        return hashCode4 + (scaleType != null ? scaleType.hashCode() : 0);
    }

    public final void setErrorholder(@Nullable Integer num) {
        this.errorholder = num;
    }

    public final void setImageRes(@Nullable Integer num) {
        this.imageRes = num;
    }

    public final void setImageUrl(@Nullable String str) {
        this.imageUrl = str;
    }

    public final void setPlaceholder(@Nullable Integer num) {
        this.placeholder = num;
    }

    public final void setScaleType(@Nullable ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public final void setTargetHeight(int i) {
        this.targetHeight = i;
    }

    public final void setTargetWidth(int i) {
        this.targetWidth = i;
    }

    @NotNull
    public String toString() {
        return "ImageUIModel(imageUrl=" + this.imageUrl + ", imageRes=" + this.imageRes + ", placeholder=" + this.placeholder + ", errorholder=" + this.errorholder + ", targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", scaleType=" + this.scaleType + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.imageUrl);
        Integer num = this.imageRes;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.placeholder;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Integer num3 = this.errorholder;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        dest.writeInt(this.targetWidth);
        dest.writeInt(this.targetHeight);
        ImageView.ScaleType scaleType = this.scaleType;
        if (scaleType == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(scaleType.name());
        }
    }

    public ImageUIModel(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, int i, int i2, @Nullable ImageView.ScaleType scaleType) {
        this.imageUrl = str;
        this.imageRes = num;
        this.placeholder = num2;
        this.errorholder = num3;
        this.targetWidth = i;
        this.targetHeight = i2;
        this.scaleType = scaleType;
    }

    public /* synthetic */ ImageUIModel(String str, Integer num, Integer num2, Integer num3, int i, int i2, ImageView.ScaleType scaleType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : num2, (i3 & 8) == 0 ? num3 : null, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 0 : i2, (i3 & 64) != 0 ? ImageView.ScaleType.FIT_CENTER : scaleType);
    }

    public /* synthetic */ ImageUIModel(String str, Integer num, Integer num2, Integer num3, int i, int i2, ImageView.ScaleType scaleType, ResizeMode resizeMode, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : num3, (i3 & 16) != 0 ? 0 : i, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? ImageView.ScaleType.FIT_CENTER : scaleType, (i3 & 128) == 0 ? resizeMode : null);
    }

    public ImageUIModel(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, int i, int i2, @Nullable ImageView.ScaleType scaleType, @Nullable ResizeMode resizeMode) {
        this(ImageSizeKt.imageSize(str, resizeMode != null ? resizeMode.getWidth() : 0), num, num2, num3, i, i2, scaleType);
    }
}
