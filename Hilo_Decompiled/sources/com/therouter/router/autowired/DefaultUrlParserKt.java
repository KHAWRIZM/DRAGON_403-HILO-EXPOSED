package com.therouter.router.autowired;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¨\u0006\f"}, d2 = {"foundClass", "Ljava/lang/Class;", "type", "", "javaTypeEqualsKotlinType", "", "type1", "type2", "primitive2Kotlin", "transform", "", "value", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class DefaultUrlParserKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Class<?> foundClass(String str) {
        if (!StringsKt.contains$default(str, '.', false, 2, (Object) null)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            int lastIndexOf$default = StringsKt.lastIndexOf$default(str, '.', 0, false, 6, (Object) null);
            String sb2 = new StringBuilder(str).replace(lastIndexOf$default, lastIndexOf$default + 1, "$").toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return foundClass(sb2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean javaTypeEqualsKotlinType(String str, String str2) {
        return Intrinsics.areEqual(primitive2Kotlin(str), primitive2Kotlin(str2));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0014. Please report as an issue. */
    private static final String primitive2Kotlin(String str) {
        switch (str.hashCode()) {
            case -2056817302:
                if (!str.equals("java.lang.Integer")) {
                    return str;
                }
                return "kotlin.Int";
            case -1325958191:
                if (!str.equals("double")) {
                    return str;
                }
                return "kotlin.Double";
            case -527879800:
                if (!str.equals("java.lang.Float")) {
                    return str;
                }
                return "kotlin.Float";
            case -515992664:
                if (!str.equals("java.lang.Short")) {
                    return str;
                }
                return "kotlin.Short";
            case 104431:
                if (!str.equals("int")) {
                    return str;
                }
                return "kotlin.Int";
            case 3039496:
                if (!str.equals("byte")) {
                    return str;
                }
                return "kotlin.Byte";
            case 3052374:
                if (!str.equals("char")) {
                    return str;
                }
                return "kotlin.Char";
            case 3327612:
                if (!str.equals("long")) {
                    return str;
                }
                return "kotlin.Long";
            case 64711720:
                if (!str.equals("boolean")) {
                    return str;
                }
                return "kotlin.Boolean";
            case 97526364:
                if (!str.equals("float")) {
                    return str;
                }
                return "kotlin.Float";
            case 109413500:
                if (!str.equals("short")) {
                    return str;
                }
                return "kotlin.Short";
            case 155276373:
                if (!str.equals("java.lang.Character")) {
                    return str;
                }
                return "kotlin.Char";
            case 344809556:
                if (!str.equals("java.lang.Boolean")) {
                    return str;
                }
                return "kotlin.Boolean";
            case 398507100:
                if (!str.equals("java.lang.Byte")) {
                    return str;
                }
                return "kotlin.Byte";
            case 398795216:
                if (!str.equals("java.lang.Long")) {
                    return str;
                }
                return "kotlin.Long";
            case 761287205:
                if (!str.equals("java.lang.Double")) {
                    return str;
                }
                return "kotlin.Double";
            case 1195259493:
                if (str.equals("java.lang.String")) {
                    return "kotlin.String";
                }
                return str;
            default:
                return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object transform(String str, String str2) {
        switch (str.hashCode()) {
            case -2133280414:
                if (!str.equals("kotlin.Int")) {
                    return null;
                }
                return Integer.valueOf(Integer.parseInt(str2));
            case -2056817302:
                if (!str.equals("java.lang.Integer")) {
                    return null;
                }
                return Integer.valueOf(Integer.parseInt(str2));
            case -1707381259:
                if (!str.equals("kotlin.Byte")) {
                    return null;
                }
                return Byte.valueOf(Byte.parseByte(str2));
            case -1707368381:
                if (!str.equals("kotlin.Char") || str2.length() <= 0) {
                    return null;
                }
                return Character.valueOf(str2.charAt(0));
            case -1707093143:
                if (!str.equals("kotlin.Long")) {
                    return null;
                }
                return Long.valueOf(Long.parseLong(str2));
            case -1385909489:
                if (!str.equals("kotlin.Float")) {
                    return null;
                }
                return Float.valueOf(Float.parseFloat(str2));
            case -1374022353:
                if (!str.equals("kotlin.Short")) {
                    return null;
                }
                return Short.valueOf(Short.parseShort(str2));
            case -1325958191:
                if (!str.equals("double")) {
                    return null;
                }
                return Double.valueOf(Double.parseDouble(str2));
            case -527879800:
                if (!str.equals("java.lang.Float")) {
                    return null;
                }
                return Float.valueOf(Float.parseFloat(str2));
            case -515992664:
                if (!str.equals("java.lang.Short")) {
                    return null;
                }
                return Short.valueOf(Short.parseShort(str2));
            case -67829378:
                if (!str.equals("kotlin.Double")) {
                    return null;
                }
                return Double.valueOf(Double.parseDouble(str2));
            case 104431:
                if (!str.equals("int")) {
                    return null;
                }
                return Integer.valueOf(Integer.parseInt(str2));
            case 3039496:
                if (!str.equals("byte")) {
                    return null;
                }
                return Byte.valueOf(Byte.parseByte(str2));
            case 3052374:
                if (!str.equals("char") || str2.length() <= 0) {
                    return null;
                }
                return Character.valueOf(str2.charAt(0));
            case 3327612:
                if (!str.equals("long")) {
                    return null;
                }
                return Long.valueOf(Long.parseLong(str2));
            case 64711720:
                if (!str.equals("boolean")) {
                    return null;
                }
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            case 97526364:
                if (!str.equals("float")) {
                    return null;
                }
                return Float.valueOf(Float.parseFloat(str2));
            case 109413500:
                if (!str.equals("short")) {
                    return null;
                }
                return Short.valueOf(Short.parseShort(str2));
            case 155276373:
                if (!str.equals("java.lang.Character") || str2.length() <= 0) {
                    return null;
                }
                return Character.valueOf(str2.charAt(0));
            case 344809556:
                if (!str.equals("java.lang.Boolean")) {
                    return null;
                }
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            case 398507100:
                if (!str.equals("java.lang.Byte")) {
                    return null;
                }
                return Byte.valueOf(Byte.parseByte(str2));
            case 398795216:
                if (!str.equals("java.lang.Long")) {
                    return null;
                }
                return Long.valueOf(Long.parseLong(str2));
            case 411999259:
                if (!str.equals("kotlin.Boolean")) {
                    return null;
                }
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            case 761287205:
                if (!str.equals("java.lang.Double")) {
                    return null;
                }
                return Double.valueOf(Double.parseDouble(str2));
            default:
                return null;
        }
    }
}
