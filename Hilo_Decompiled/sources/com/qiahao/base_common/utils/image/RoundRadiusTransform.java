package com.qiahao.base_common.utils.image;

import android.graphics.Bitmap;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f5.l;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p4.d;
import v4.g;
import v4.i0;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 (2\u00020\u0001:\u0001(B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u0005R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010$¨\u0006)"}, d2 = {"Lcom/qiahao/base_common/utils/image/RoundRadiusTransform;", "Lv4/g;", "", "roundingRadius", "<init>", "(I)V", "", "leftTop", "rightTop", "leftBottom", "rightBottom", "", "setNeedCorner", "(ZZZZ)V", "Lp4/d;", "pool", "Landroid/graphics/Bitmap;", "toTransform", "outWidth", "outHeight", "transform", "(Lp4/d;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/security/MessageDigest;", "messageDigest", "updateDiskCacheKey", "(Ljava/security/MessageDigest;)V", "I", "getRoundingRadius", "setRoundingRadius", "isLeftTop", "Z", "isRightTop", "isLeftBottom", "isRightBottom", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RoundRadiusTransform extends g {

    @NotNull
    private static final String ID = "com.qiahao.base_common.utils.image.RoundRadiusTransform";

    @NotNull
    private static final byte[] ID_BYTES;
    private boolean isLeftBottom;
    private boolean isLeftTop;
    private boolean isRightBottom;
    private boolean isRightTop;
    private int roundingRadius;

    static {
        Charset CHARSET = f.f١٥٩٧٢a;
        Intrinsics.checkNotNullExpressionValue(CHARSET, "CHARSET");
        byte[] bytes = ID.getBytes(CHARSET);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        ID_BYTES = bytes;
    }

    public RoundRadiusTransform() {
        this(0, 1, null);
    }

    @Override // m4.f
    public boolean equals(@Nullable Object other) {
        if (!(other instanceof RoundRadiusTransform) || this.roundingRadius != ((RoundRadiusTransform) other).roundingRadius) {
            return false;
        }
        return true;
    }

    public final int getRoundingRadius() {
        return this.roundingRadius;
    }

    @Override // m4.f
    public int hashCode() {
        return l.p(1264418213, l.o(this.roundingRadius));
    }

    public final void setNeedCorner(boolean leftTop, boolean rightTop, boolean leftBottom, boolean rightBottom) {
        this.isLeftTop = leftTop;
        this.isRightTop = rightTop;
        this.isLeftBottom = leftBottom;
        this.isRightBottom = rightBottom;
    }

    public final void setRoundingRadius(int i10) {
        this.roundingRadius = i10;
    }

    @Override // v4.g
    @NotNull
    protected Bitmap transform(@NotNull d pool, @NotNull Bitmap toTransform, int outWidth, int outHeight) {
        float f10;
        float f11;
        float f12;
        float f13;
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(toTransform, "toTransform");
        if (this.isLeftTop) {
            f10 = this.roundingRadius;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (this.isRightTop) {
            f11 = this.roundingRadius;
        } else {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (this.isRightBottom) {
            f12 = this.roundingRadius;
        } else {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (this.isLeftBottom) {
            f13 = this.roundingRadius;
        } else {
            f13 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        Bitmap o10 = i0.o(pool, toTransform, f10, f11, f12, f13);
        Intrinsics.checkNotNullExpressionValue(o10, "roundedCorners(...)");
        return o10;
    }

    @Override // m4.f
    public void updateDiskCacheKey(@NotNull MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }

    public RoundRadiusTransform(int i10) {
        this.roundingRadius = i10;
    }

    public /* synthetic */ RoundRadiusTransform(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
