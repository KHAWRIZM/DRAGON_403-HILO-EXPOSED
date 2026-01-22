package com.qiahao.base_common.model.im;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/qiahao/base_common/model/im/PicBean;", "", "format", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "size", "url", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "<init>", "(Ljava/lang/String;IILjava/lang/String;I)V", "getFormat", "()Ljava/lang/String;", "getHeight", "()I", "getSize", "getUrl", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PicBean {

    @NotNull
    private final String format;
    private final int height;
    private final int size;

    @NotNull
    private final String url;
    private final int width;

    public PicBean(@NotNull String format, int i10, int i11, @NotNull String url, int i12) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(url, "url");
        this.format = format;
        this.height = i10;
        this.size = i11;
        this.url = url;
        this.width = i12;
    }

    public static /* synthetic */ PicBean copy$default(PicBean picBean, String str, int i10, int i11, String str2, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = picBean.format;
        }
        if ((i13 & 2) != 0) {
            i10 = picBean.height;
        }
        int i14 = i10;
        if ((i13 & 4) != 0) {
            i11 = picBean.size;
        }
        int i15 = i11;
        if ((i13 & 8) != 0) {
            str2 = picBean.url;
        }
        String str3 = str2;
        if ((i13 & 16) != 0) {
            i12 = picBean.width;
        }
        return picBean.copy(str, i14, i15, str3, i12);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component5, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    @NotNull
    public final PicBean copy(@NotNull String format, int height, int size, @NotNull String url, int width) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(url, "url");
        return new PicBean(format, height, size, url, width);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PicBean)) {
            return false;
        }
        PicBean picBean = (PicBean) other;
        return Intrinsics.areEqual(this.format, picBean.format) && this.height == picBean.height && this.size == picBean.size && Intrinsics.areEqual(this.url, picBean.url) && this.width == picBean.width;
    }

    @NotNull
    public final String getFormat() {
        return this.format;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((this.format.hashCode() * 31) + this.height) * 31) + this.size) * 31) + this.url.hashCode()) * 31) + this.width;
    }

    @NotNull
    public String toString() {
        return "PicBean(format=" + this.format + ", height=" + this.height + ", size=" + this.size + ", url=" + this.url + ", width=" + this.width + ")";
    }
}
