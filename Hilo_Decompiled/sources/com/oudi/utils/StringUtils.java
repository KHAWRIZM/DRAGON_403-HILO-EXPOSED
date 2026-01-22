package com.oudi.utils;

import android.text.TextUtils;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.math.BigDecimal;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\nJ \u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bJ(\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nJ\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\nJ\"\u0010\u001a\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u0005J>\u0010\u001d\u001a\u00020\u001e2&\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010 j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n¨\u0006$"}, d2 = {"Lcom/oudi/utils/StringUtils;", "", "<init>", "()V", "maxLengthSuffix", "", ViewHierarchyConstants.TEXT_KEY, "maxLength", "", DynamicLink.Builder.KEY_SUFFIX, "", "toW", "count", "", "scale", "toShortCount", "threshold", "showCenterStarPhone", "phone", "showCenterStarCard", "card", "showCenterIdCard", "interceptByteToString", "value", "long", "getStringToByte", "formatUnreadCount", "maxCount", "postfix", "disposeString", "", "hashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", TransferTable.COLUMN_KEY, "disposeContent", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class StringUtils {
    public static final StringUtils INSTANCE = new StringUtils();

    private StringUtils() {
    }

    public static /* synthetic */ String formatUnreadCount$default(StringUtils stringUtils, long j10, long j11, CharSequence charSequence, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = 99;
        }
        long j12 = j11;
        if ((i10 & 4) != 0) {
            charSequence = "+";
        }
        return stringUtils.formatUnreadCount(j10, j12, charSequence);
    }

    public static /* synthetic */ String toShortCount$default(StringUtils stringUtils, long j10, long j11, String str, int i10, int i11, Object obj) {
        int i12;
        if ((i11 & 8) != 0) {
            i12 = 1;
        } else {
            i12 = i10;
        }
        return stringUtils.toShortCount(j10, j11, str, i12);
    }

    public static /* synthetic */ String toW$default(StringUtils stringUtils, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "w";
        }
        return stringUtils.toW(i10, str);
    }

    public final void disposeString(HashMap<String, Object> hashMap, String key, String disposeContent) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(disposeContent, "disposeContent");
        if (hashMap != null && !TextUtils.isEmpty(disposeContent)) {
            int i10 = 0;
            int i11 = 0;
            while (i10 < disposeContent.length()) {
                i10 += 100;
                if (i10 > disposeContent.length()) {
                    String substring = disposeContent.substring(i11 * 100);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    hashMap.put(key + (i11 + 1), substring);
                    i10 = disposeContent.length();
                } else {
                    int i12 = i11 + 1;
                    String str = key + i12;
                    String substring2 = disposeContent.substring(i11 * 100, i12 * 100);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    hashMap.put(str, substring2);
                }
                i11++;
            }
        }
    }

    public final String formatUnreadCount(long count, long maxCount, CharSequence postfix) {
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        if (count <= 0) {
            return "";
        }
        if (count > maxCount) {
            StringBuilder sb = new StringBuilder();
            sb.append(maxCount);
            sb.append((Object) postfix);
            return sb.toString();
        }
        return String.valueOf(count);
    }

    public final int getStringToByte(String value) {
        int i10;
        Intrinsics.checkNotNullParameter(value, "value");
        int length = value.length();
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = i11 + 1;
            String substring = value.substring(i11, i13);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            if (new Regex("[一-龥]").matches(substring)) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            i12 += i10;
            i11 = i13;
        }
        return i12;
    }

    public final String interceptByteToString(String value, long r10) {
        int i10;
        Intrinsics.checkNotNullParameter(value, "value");
        int length = value.length();
        int i11 = 0;
        String str = "";
        int i12 = 0;
        while (i11 < length) {
            int i13 = i11 + 1;
            String substring = value.substring(i11, i13);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            if (new Regex("[一-龥]").matches(substring)) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            i12 += i10;
            if (i12 <= r10) {
                str = str + substring;
                i11 = i13;
            } else {
                return str + "...";
            }
        }
        return str;
    }

    public final CharSequence maxLengthSuffix(CharSequence text, int maxLength, String suffix) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (text.length() > maxLength) {
            return ((Object) text.subSequence(0, maxLength)) + suffix;
        }
        return text;
    }

    public final String showCenterIdCard(String card) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (card.length() != 18) {
            return card;
        }
        String substring = card.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String substring2 = card.substring(14);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring + "***********" + substring2;
    }

    public final String showCenterStarCard(String card) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (card.length() - 8 > 1) {
            return new Regex("(\\d{4})(\\d{1,})(\\d{4})").replace(card, "$1****$3");
        }
        return card;
    }

    public final String showCenterStarPhone(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        if (StringsKt.trim((CharSequence) phone).toString().length() > 7) {
            String substring = phone.substring(0, 3);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = phone.substring(7, phone.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            return substring + "****" + substring2;
        }
        String substring3 = phone.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
        return substring3 + "****";
    }

    public final String toShortCount(long count, long threshold, String suffix, int scale) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (count > threshold) {
            return new BigDecimal(count).divide(new BigDecimal(threshold + 1), scale, 1) + suffix;
        }
        return String.valueOf(count);
    }

    public final String toW(int count, String suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return toW(count, suffix);
    }

    public static /* synthetic */ String toW$default(StringUtils stringUtils, long j10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "w";
        }
        return stringUtils.toW(j10, str);
    }

    public final String toW(long count, String suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return toShortCount(count, 9999L, suffix, 1);
    }

    public static /* synthetic */ String toW$default(StringUtils stringUtils, long j10, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "w";
        }
        return stringUtils.toW(j10, str, i10);
    }

    public final String toW(long count, String suffix, int scale) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return toShortCount(count, 9999L, suffix, scale);
    }
}
