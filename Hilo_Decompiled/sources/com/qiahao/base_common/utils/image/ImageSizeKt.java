package com.qiahao.base_common.utils.image;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.utils.ktx.StringKtxKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\u001a\u001c\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\b"}, d2 = {"image100", "", "image200", "imageSize", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "imageCircle", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ImageSizeKt {
    @NotNull
    public static final String image100(@Nullable String str) {
        if (str == null) {
            return "";
        }
        if (!StringKtxKt.checkEndGif(str) && !StringKtxKt.checkEndWebp(str)) {
            String str2 = str + "?x-oss-process=image/resize,m_lfit,w_100,h_100/format,png";
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        String str3 = str + "?x-oss-process=image/resize,m_lfit,w_100,h_100/format,webp";
        Intrinsics.checkNotNull(str3);
        return str3;
    }

    @NotNull
    public static final String image200(@Nullable String str) {
        if (str == null) {
            return "";
        }
        if (!StringKtxKt.checkEndGif(str) && !StringKtxKt.checkEndWebp(str)) {
            String str2 = str + "?x-oss-process=image/resize,m_lfit,w_200,h_200/format,png";
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        String str3 = str + "?x-oss-process=image/resize,m_lfit,w_200,h_200/format,webp";
        Intrinsics.checkNotNull(str3);
        return str3;
    }

    @NotNull
    public static final String imageCircle(@Nullable String str, int i10) {
        if (str == null) {
            return "";
        }
        if (i10 <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append("?x-oss-process=image/resize,");
        sb.append("m_lfit");
        sb.append(",w_" + i10);
        sb.append(",h_" + i10);
        sb.append("/format,png/rounded-corners,r_" + (i10 / 2));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public static final String imageSize(@Nullable String str, int i10, int i11) {
        if (str == null) {
            return "";
        }
        if (!StringKtxKt.checkEndGif(str) && !StringKtxKt.checkEndWebp(str)) {
            StringBuilder sb = new StringBuilder(str);
            sb.append("?x-oss-process=image/resize,");
            sb.append("m_lfit");
            sb.append(",w_" + i10);
            sb.append(",h_" + i11);
            sb.append("/format,png");
            String sb2 = sb.toString();
            Intrinsics.checkNotNull(sb2);
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder(str);
        sb3.append("?x-oss-process=image/resize,");
        sb3.append("m_lfit");
        sb3.append(",w_" + i10);
        sb3.append(",h_" + i11);
        sb3.append("/format,webp");
        String sb4 = sb3.toString();
        Intrinsics.checkNotNull(sb4);
        return sb4;
    }

    @NotNull
    public static final String imageSize(@Nullable String str, int i10) {
        if (str == null) {
            return "";
        }
        if (i10 <= 0) {
            return str;
        }
        if (!StringKtxKt.checkEndGif(str) && !StringKtxKt.checkEndWebp(str)) {
            StringBuilder sb = new StringBuilder(str);
            sb.append("?x-oss-process=image/resize,");
            sb.append("m_lfit");
            sb.append(",w_" + i10);
            sb.append("/format,png");
            String sb2 = sb.toString();
            Intrinsics.checkNotNull(sb2);
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder(str);
        sb3.append("?x-oss-process=image/resize,");
        sb3.append("m_lfit");
        sb3.append(",w_" + i10);
        sb3.append("/format,webp");
        String sb4 = sb3.toString();
        Intrinsics.checkNotNull(sb4);
        return sb4;
    }
}
