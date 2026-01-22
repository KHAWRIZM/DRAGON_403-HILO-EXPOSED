package com.qhqc.core.basic.aws;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001\u001a\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\b"}, d2 = {"imageResizeAvatar", "", "imageResizeH", "h", "", "imageResizeW", "w", "imageResizeWH", "basic_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ImageResizeKtKt {
    @Nullable
    public static final String imageResizeAvatar(@Nullable String str) {
        return imageResizeWH(str, 150, 150);
    }

    @Nullable
    public static final String imageResizeH(@Nullable String str, int i10) {
        if (str != null && str.length() != 0 && !StringsKt.contains$default((CharSequence) str, (CharSequence) "?", false, 2, (Object) null)) {
            return str + "?x-oss-process=image/resize,h_" + i10 + "/format,webp";
        }
        return str;
    }

    @Nullable
    public static final String imageResizeW(@Nullable String str, int i10, int i11) {
        if (str != null && str.length() != 0 && !StringsKt.contains$default((CharSequence) str, (CharSequence) "?", false, 2, (Object) null)) {
            return str + "?x-oss-process=image/resize,w_" + i10 + "/format,webp";
        }
        return str;
    }

    @Nullable
    public static final String imageResizeWH(@Nullable String str, int i10, int i11) {
        if (str != null && str.length() != 0 && !StringsKt.contains$default((CharSequence) str, (CharSequence) "?", false, 2, (Object) null)) {
            return str + "?x-oss-process=image/resize,m_fill,w_" + i10 + ",h_" + i11 + "/format,webp";
        }
        return str;
    }
}
