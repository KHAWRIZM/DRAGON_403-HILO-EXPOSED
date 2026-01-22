package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/qiahao/hilo_message/data/ImageElemContent;", "", "imageInfoArray", "", "Lcom/qiahao/hilo_message/data/ImageInfo;", "<init>", "(Ljava/util/List;)V", "getImageInfoArray", "()Ljava/util/List;", "setImageInfoArray", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ImageElemContent {

    @Nullable
    private List<ImageInfo> imageInfoArray;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageElemContent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageElemContent copy$default(ImageElemContent imageElemContent, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = imageElemContent.imageInfoArray;
        }
        return imageElemContent.copy(list);
    }

    @Nullable
    public final List<ImageInfo> component1() {
        return this.imageInfoArray;
    }

    @NotNull
    public final ImageElemContent copy(@Nullable List<ImageInfo> imageInfoArray) {
        return new ImageElemContent(imageInfoArray);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ImageElemContent) && Intrinsics.areEqual(this.imageInfoArray, ((ImageElemContent) other).imageInfoArray);
    }

    @Nullable
    public final List<ImageInfo> getImageInfoArray() {
        return this.imageInfoArray;
    }

    public int hashCode() {
        List<ImageInfo> list = this.imageInfoArray;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setImageInfoArray(@Nullable List<ImageInfo> list) {
        this.imageInfoArray = list;
    }

    @NotNull
    public String toString() {
        return "ImageElemContent(imageInfoArray=" + this.imageInfoArray + ")";
    }

    public ImageElemContent(@Nullable List<ImageInfo> list) {
        this.imageInfoArray = list;
    }

    public /* synthetic */ ImageElemContent(List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : list);
    }
}
