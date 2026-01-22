package com.oudi.utils.ktx;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.oudi.utils.AppUtils;
import com.qiahao.base_common.utils.PathHelper;
import java.io.File;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u001a&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0011\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0017\u001a\u00020\u0002*\u0004\u0018\u00010\u0002\u001a\u0016\u0010\u0018\u001a\u00020\u000b*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u001a\f\u0010\u0019\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u001a\u001a\u00020\u0002*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002¨\u0006\u001c"}, d2 = {"copyToClipboard", "", "", "isMobileNumber", "isNotMobileNumber", "encryptMobileNumber", "default", "splitToMap", "", "name", "itemLength", "", "checkSuffixType", "type", "checkUrl", "checkEndMP4", "checkDefaultMP4", "urlMP4", "checkEndSVGA", "checkEndGif", "checkEndWebp", "checkEndJpg", "checkEndPng", "decode", "toDefaultInt", "isUrl", "urlName", "parentFile", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class StringKtxKt {
    public static final boolean checkDefaultMP4(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) ".mp4", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) str, (CharSequence) "is_custom_video=1", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    public static final boolean checkEndGif(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (checkSuffixType(str, ".gif") && checkUrl(str)) {
            return true;
        }
        return false;
    }

    public static final boolean checkEndJpg(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return checkSuffixType(str, PictureMimeType.JPG);
    }

    public static final boolean checkEndMP4(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return checkSuffixType(str, ".mp4");
    }

    public static final boolean checkEndPng(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return checkSuffixType(str, ".png");
    }

    public static final boolean checkEndSVGA(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (checkSuffixType(str, PathHelper.SUFFIX_TYPE_SVGA) && checkUrl(str)) {
            return true;
        }
        return false;
    }

    public static final boolean checkEndWebp(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (checkSuffixType(str, ".webp") && checkUrl(str)) {
            return true;
        }
        return false;
    }

    public static final boolean checkSuffixType(String str, String type) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return StringsKt.endsWith(str, type, true);
    }

    public static final boolean checkUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return StringsKt.startsWith(str, "Http", true);
    }

    public static final boolean copyToClipboard(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Object systemService = AppUtils.getApp().getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Label", str));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final String decode(String str) {
        if (str == null) {
            return "";
        }
        String decode = URLDecoder.decode(str, "UTF-8");
        Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
        return decode;
    }

    public static final String encryptMobileNumber(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (isMobileNumber(str)) {
            String substring = str.substring(0, 3);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = str.substring(7, str.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            return substring + "****" + substring2;
        }
        return str2;
    }

    public static /* synthetic */ String encryptMobileNumber$default(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = str;
        }
        return encryptMobileNumber(str, str2);
    }

    public static final boolean isMobileNumber(String str) {
        if (str == null || str.length() < 7 || str.length() > 11) {
            return false;
        }
        return true;
    }

    public static final boolean isNotMobileNumber(String str) {
        return !isMobileNumber(str);
    }

    public static final boolean isUrl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (!StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    public static final String parentFile(String str) {
        File parentFile;
        if (str == null || str.length() == 0 || (parentFile = new File(str).getParentFile()) == null) {
            return null;
        }
        return parentFile.getName();
    }

    public static final Map<String, String> splitToMap(String str, String name, int i10) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str.length() == 0) {
            return linkedHashMap;
        }
        if (i10 < 1) {
            linkedHashMap.put(name + "1", str);
            return linkedHashMap;
        }
        int length = ((str.length() + i10) - 1) / i10;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 * i10;
            String substring = str.substring(i12, RangesKt.coerceAtMost(i12 + i10, str.length()));
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            i11++;
            linkedHashMap.put(name + i11, substring);
        }
        return linkedHashMap;
    }

    public static final int toDefaultInt(String str, int i10) {
        if (str != null && str.length() != 0) {
            return Integer.parseInt(str);
        }
        return i10;
    }

    public static /* synthetic */ int toDefaultInt$default(String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return toDefaultInt(str, i10);
    }

    public static final String urlMP4(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return "";
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '?', 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            String substring = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    public static final String urlName(String str) {
        if (str != null && str.length() != 0) {
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, '/', 0, false, 6, (Object) null);
            int lastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
            if (lastIndexOf$default > 0 && lastIndexOf$default2 > lastIndexOf$default) {
                String substring = str.substring(lastIndexOf$default + 1, lastIndexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                return substring;
            }
        }
        return "";
    }
}
