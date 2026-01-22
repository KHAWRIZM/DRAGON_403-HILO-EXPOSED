package kotlin.text;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.KotlinNothingValueException;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.HexFormat;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0019\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0001\n\u0000\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010\u000b\u001a\u00020\u0001*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a,\u0010\u0012\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a,\u0010\u0016\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a,\u0010\u0017\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a,\u0010\u0018\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a<\u0010\u0019\u001a\u00020\u0010*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002\u001a,\u0010\u0019\u001a\u00020\u0010*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002\u001a(\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0002\u001a@\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0000\u001a\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*H\u0002\u001a\u0016\u0010+\u001a\u00020\f*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010+\u001a\u00020\f*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a&\u0010,\u001a\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a&\u0010-\u001a\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a&\u0010.\u001a\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a$\u0010/\u001a\u00020\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0014\u00100\u001a\u000201*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0002\u001a@\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0000\u001a \u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010H\u0002\u001a \u00108\u001a\u00020*2\u0006\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*2\u0006\u00107\u001a\u00020\u0010H\u0002\u001a\u001c\u00109\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u0002012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010:\u001a\u000201*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010:\u001a\u000201*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020;2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010<\u001a\u00020;*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010<\u001a\u00020;*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010=\u001a\u00020\u0010*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010=\u001a\u00020\u0010*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020*2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010>\u001a\u00020**\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010>\u001a\u00020**\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a$\u0010?\u001a\u00020\u0001*\u00020*2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u0010H\u0002\u001a\u001c\u0010D\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002\u001a,\u0010E\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a,\u0010G\u001a\u00020**\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a<\u0010H\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020M2\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a$\u0010N\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a\u001c\u0010O\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u001c\u0010P\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u001c\u0010Q\u001a\u00020**\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a5\u0010R\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00012\u0006\u0010L\u001a\u00020M2\u0006\u0010T\u001a\u00020\u0001H\u0082\b\u001a\u0015\u0010U\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0082\b\u001a\u0015\u0010V\u001a\u00020**\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0082\b\u001a,\u0010W\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010X\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0010H\u0002\u001a,\u0010Z\u001a\u00020I*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\u0001H\u0002\u001a,\u0010[\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\\\u001a\u00020]*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "getBYTE_TO_LOWER_CASE_HEX_DIGITS", "()[I", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "toHexString", "", "format", "Lkotlin/text/HexFormat;", "startIndex", "", "endIndex", "toHexStringNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "byteToDigits", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringSlowPath", "formatByteAt", FirebaseAnalytics.Param.INDEX, "bytePrefix", "byteSuffix", "destination", "", "destinationOffset", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "checkFormatLength", "formatLength", "", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArraySlowPath", "parseByteAt", "", "parsedByteArrayMaxSize", "stringLength", "charsPerSet", "charsPerElement", "elementsPerSet", "elementSeparatorLength", "wholeElementsPerSet", "checkNewLineAt", "hexToByte", "", "hexToShort", "hexToInt", "hexToLong", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toCharArrayIfNotEmpty", "hexToIntImpl", "typeHexLength", "hexToLongImpl", "checkPrefixSuffixNumberOfDigits", "", "prefix", DynamicLink.Builder.KEY_SUFFIX, "ignoreCase", "", "checkNumberOfDigits", "checkZeroDigits", "parseInt", "parseLong", "checkContainsAt", "part", "partName", "decimalFromHexDigitAt", "longDecimalFromHexDigitAt", "throwInvalidNumberOfDigits", "specifier", "expected", "throwNotContainedAt", "throwInvalidPrefixSuffix", "throwInvalidDigitAt", "", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,1237:1\n1186#1,7:1239\n1186#1,7:1246\n1186#1,7:1253\n1186#1,7:1260\n1186#1,7:1267\n1186#1,7:1274\n1186#1,7:1281\n1186#1,7:1288\n1197#1,5:1295\n1197#1,5:1300\n1186#1,7:1305\n1186#1,7:1312\n1197#1,5:1319\n1206#1,5:1324\n1#2:1238\n1188#3,3:1329\n1188#3,3:1332\n1188#3,3:1335\n1188#3,3:1338\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n450#1:1239,7\n482#1:1246,7\n486#1:1253,7\n489#1:1260,7\n529#1:1267,7\n532#1:1274,7\n537#1:1281,7\n542#1:1288,7\n549#1:1295,5\n550#1:1300,5\n1141#1:1305,7\n1143#1:1312,7\n1171#1:1319,5\n1179#1:1324,5\n42#1:1329,3\n43#1:1332,3\n54#1:1335,3\n55#1:1338,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HexExtensionsKt {

    @NotNull
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;

    @NotNull
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS;

    @NotNull
    private static final int[] HEX_DIGITS_TO_DECIMAL;

    @NotNull
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL;

    @NotNull
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";

    @NotNull
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] iArr = new int[256];
        int i10 = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            iArr[i11] = LOWER_CASE_HEX_DIGITS.charAt(i11 & 15) | (LOWER_CASE_HEX_DIGITS.charAt(i11 >> 4) << '\b');
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[256];
        for (int i12 = 0; i12 < 256; i12++) {
            iArr2[i12] = UPPER_CASE_HEX_DIGITS.charAt(i12 & 15) | (UPPER_CASE_HEX_DIGITS.charAt(i12 >> 4) << '\b');
        }
        BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] iArr3 = new int[256];
        for (int i13 = 0; i13 < 256; i13++) {
            iArr3[i13] = -1;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < LOWER_CASE_HEX_DIGITS.length()) {
            iArr3[LOWER_CASE_HEX_DIGITS.charAt(i14)] = i15;
            i14++;
            i15++;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < UPPER_CASE_HEX_DIGITS.length()) {
            iArr3[UPPER_CASE_HEX_DIGITS.charAt(i16)] = i17;
            i16++;
            i17++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr3;
        long[] jArr = new long[256];
        for (int i18 = 0; i18 < 256; i18++) {
            jArr[i18] = -1;
        }
        int i19 = 0;
        int i20 = 0;
        while (i19 < LOWER_CASE_HEX_DIGITS.length()) {
            jArr[LOWER_CASE_HEX_DIGITS.charAt(i19)] = i20;
            i19++;
            i20++;
        }
        int i21 = 0;
        while (i10 < UPPER_CASE_HEX_DIGITS.length()) {
            jArr[UPPER_CASE_HEX_DIGITS.charAt(i10)] = i21;
            i10++;
            i21++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = jArr;
    }

    private static final long charsPerSet(long j10, int i10, int i11) {
        if (i10 > 0) {
            long j11 = i10;
            return (j10 * j11) + (i11 * (j11 - 1));
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final int checkContainsAt(String str, int i10, int i11, String str2, boolean z10, String str3) {
        if (str2.length() == 0) {
            return i10;
        }
        int length = str2.length();
        for (int i12 = 0; i12 < length; i12++) {
            if (!CharsKt__CharKt.equals(str2.charAt(i12), str.charAt(i10 + i12), z10)) {
                throwNotContainedAt(str, i10, i11, str2, str3);
            }
        }
        return i10 + str2.length();
    }

    private static final int checkFormatLength(long j10) {
        if (0 <= j10 && j10 <= 2147483647L) {
            return (int) j10;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) ULong.m٧٦٤toStringimpl(ULong.m٧١٨constructorimpl(j10))));
    }

    private static final int checkNewLineAt(String str, int i10, int i11) {
        if (str.charAt(i10) == '\r') {
            int i12 = i10 + 1;
            if (i12 < i11 && str.charAt(i12) == '\n') {
                return i10 + 2;
            }
            return i12;
        }
        if (str.charAt(i10) == '\n') {
            return i10 + 1;
        }
        throw new NumberFormatException("Expected a new line at index " + i10 + ", but was " + str.charAt(i10));
    }

    private static final void checkNumberOfDigits(String str, int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if (i13 < 1) {
            throwInvalidNumberOfDigits(str, i10, i11, "at least", 1);
        } else if (i13 > i12) {
            checkZeroDigits(str, i10, (i13 + i10) - i12);
        }
    }

    private static final void checkPrefixSuffixNumberOfDigits(String str, int i10, int i11, String str2, String str3, boolean z10, int i12) {
        if ((i11 - i10) - str2.length() <= str3.length()) {
            throwInvalidPrefixSuffix(str, i10, i11, str2, str3);
        }
        if (str2.length() != 0) {
            int length = str2.length();
            for (int i13 = 0; i13 < length; i13++) {
                if (!CharsKt__CharKt.equals(str2.charAt(i13), str.charAt(i10 + i13), z10)) {
                    throwNotContainedAt(str, i10, i11, str2, "prefix");
                }
            }
            i10 += str2.length();
        }
        int length2 = i11 - str3.length();
        if (str3.length() != 0) {
            int length3 = str3.length();
            for (int i14 = 0; i14 < length3; i14++) {
                if (!CharsKt__CharKt.equals(str3.charAt(i14), str.charAt(length2 + i14), z10)) {
                    throwNotContainedAt(str, length2, i11, str3, DynamicLink.Builder.KEY_SUFFIX);
                }
            }
        }
        checkNumberOfDigits(str, i10, length2, i12);
    }

    private static final void checkZeroDigits(String str, int i10, int i11) {
        while (i10 < i11) {
            if (str.charAt(i10) == '0') {
                i10++;
            } else {
                throw new NumberFormatException("Expected the hexadecimal digit '0' at index " + i10 + ", but was '" + str.charAt(i10) + "'.\nThe result won't fit the type being parsed.");
            }
        }
    }

    private static final int decimalFromHexDigitAt(String str, int i10) {
        int i11;
        char charAt = str.charAt(i10);
        if ((charAt >>> '\b') == 0 && (i11 = HEX_DIGITS_TO_DECIMAL[charAt]) >= 0) {
            return i11;
        }
        throwInvalidDigitAt(str, i10);
        throw new KotlinNothingValueException();
    }

    private static final int formatByteAt(byte[] bArr, int i10, String str, String str2, int[] iArr, char[] cArr, int i11) {
        return toCharArrayIfNotEmpty(str2, cArr, formatByteAt(bArr, i10, iArr, cArr, toCharArrayIfNotEmpty(str, cArr, i11)));
    }

    private static final int formattedStringLength(int i10, int i11, int i12, int i13) {
        if (i10 > 0) {
            long j10 = i11;
            return checkFormatLength((i10 * (((i12 + 2) + i13) + j10)) - j10);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @NotNull
    public static final int[] getBYTE_TO_LOWER_CASE_HEX_DIGITS() {
        return BYTE_TO_LOWER_CASE_HEX_DIGITS;
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte hexToByte(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByte(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte hexToByte$default(String str, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, hexFormat);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final byte[] hexToByteArray(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByteArray(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, hexFormat);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String str, int i10, int i11, HexFormat.BytesHexFormat bytesHexFormat) {
        if (bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix()) {
            return hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(str, i10, i11, bytesHexFormat);
        }
        return hexToByteArrayNoLineAndGroupSeparatorSlowPath(str, i10, i11, bytesHexFormat);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String str, int i10, int i11, HexFormat.BytesHexFormat bytesHexFormat) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        long length = byteSeparator.length();
        long length2 = bytePrefix.length() + 2 + byteSuffix.length() + length;
        long j10 = i11 - i10;
        int i12 = (int) ((j10 + length) / length2);
        if ((i12 * length2) - length != j10) {
            return null;
        }
        boolean ignoreCase = bytesHexFormat.getIgnoreCase();
        byte[] bArr = new byte[i12];
        if (bytePrefix.length() != 0) {
            int length3 = bytePrefix.length();
            for (int i13 = 0; i13 < length3; i13++) {
                if (!CharsKt__CharKt.equals(bytePrefix.charAt(i13), str.charAt(i10 + i13), ignoreCase)) {
                    throwNotContainedAt(str, i10, i11, bytePrefix, "byte prefix");
                }
            }
            i10 += bytePrefix.length();
        }
        String str2 = byteSuffix + byteSeparator + bytePrefix;
        int i14 = i12 - 1;
        for (int i15 = 0; i15 < i14; i15++) {
            bArr[i15] = parseByteAt(str, i10);
            i10 += 2;
            if (str2.length() != 0) {
                int length4 = str2.length();
                for (int i16 = 0; i16 < length4; i16++) {
                    if (!CharsKt__CharKt.equals(str2.charAt(i16), str.charAt(i10 + i16), ignoreCase)) {
                        throwNotContainedAt(str, i10, i11, str2, "byte suffix + byte separator + byte prefix");
                    }
                }
                i10 += str2.length();
            }
        }
        bArr[i14] = parseByteAt(str, i10);
        int i17 = i10 + 2;
        if (byteSuffix.length() != 0) {
            int length5 = byteSuffix.length();
            for (int i18 = 0; i18 < length5; i18++) {
                if (!CharsKt__CharKt.equals(byteSuffix.charAt(i18), str.charAt(i17 + i18), ignoreCase)) {
                    throwNotContainedAt(str, i17, i11, byteSuffix, "byte suffix");
                }
            }
        }
        return bArr;
    }

    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String str, int i10, int i11, HexFormat.BytesHexFormat bytesHexFormat) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length <= 1) {
            int i12 = i11 - i10;
            int i13 = 2;
            if (length == 0) {
                if ((i12 & 1) != 0) {
                    return null;
                }
                int i14 = i12 >> 1;
                byte[] bArr = new byte[i14];
                int i15 = 0;
                for (int i16 = 0; i16 < i14; i16++) {
                    bArr[i16] = parseByteAt(str, i15);
                    i15 += 2;
                }
                return bArr;
            }
            if (i12 % 3 != 2) {
                return null;
            }
            int i17 = (i12 / 3) + 1;
            byte[] bArr2 = new byte[i17];
            char charAt = bytesHexFormat.getByteSeparator().charAt(0);
            bArr2[0] = parseByteAt(str, 0);
            for (int i18 = 1; i18 < i17; i18++) {
                if (str.charAt(i13) != charAt) {
                    String byteSeparator = bytesHexFormat.getByteSeparator();
                    boolean ignoreCase = bytesHexFormat.getIgnoreCase();
                    if (byteSeparator.length() != 0) {
                        int length2 = byteSeparator.length();
                        for (int i19 = 0; i19 < length2; i19++) {
                            if (!CharsKt__CharKt.equals(byteSeparator.charAt(i19), str.charAt(i13 + i19), ignoreCase)) {
                                throwNotContainedAt(str, i13, i11, byteSeparator, "byte separator");
                            }
                        }
                        byteSeparator.length();
                    }
                }
                bArr2[i18] = parseByteAt(str, i13 + 1);
                i13 += 3;
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final byte[] hexToByteArraySlowPath(String str, int i10, int i11, HexFormat.BytesHexFormat bytesHexFormat) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        boolean ignoreCase = bytesHexFormat.getIgnoreCase();
        int parsedByteArrayMaxSize = parsedByteArrayMaxSize(i11 - i10, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        byte[] bArr = new byte[parsedByteArrayMaxSize];
        int i18 = i10;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i18 < i11) {
            if (i20 == bytesPerLine) {
                i18 = checkNewLineAt(str, i18, i11);
                i12 = 0;
            } else if (i21 == bytesPerGroup) {
                if (groupSeparator.length() == 0) {
                    i14 = i20;
                } else {
                    int length = groupSeparator.length();
                    int i22 = 0;
                    while (i22 < length) {
                        int i23 = i20;
                        int i24 = length;
                        if (!CharsKt__CharKt.equals(groupSeparator.charAt(i22), str.charAt(i18 + i22), ignoreCase)) {
                            throwNotContainedAt(str, i18, i11, groupSeparator, "group separator");
                        }
                        i22++;
                        i20 = i23;
                        length = i24;
                    }
                    i14 = i20;
                    i18 += groupSeparator.length();
                }
                i12 = i14;
            } else {
                int i25 = i20;
                if (i21 != 0) {
                    if (byteSeparator.length() == 0) {
                        i13 = i21;
                    } else {
                        int length2 = byteSeparator.length();
                        int i26 = 0;
                        while (i26 < length2) {
                            int i27 = length2;
                            int i28 = i21;
                            if (!CharsKt__CharKt.equals(byteSeparator.charAt(i26), str.charAt(i18 + i26), ignoreCase)) {
                                throwNotContainedAt(str, i18, i11, byteSeparator, "byte separator");
                            }
                            i26++;
                            length2 = i27;
                            i21 = i28;
                        }
                        i13 = i21;
                        i18 += byteSeparator.length();
                    }
                    i12 = i25;
                    i21 = i13;
                } else {
                    i12 = i25;
                }
                int i29 = i12 + 1;
                int i30 = i21 + 1;
                if (bytePrefix.length() != 0) {
                    i15 = i29;
                    i16 = i30;
                } else {
                    int length3 = bytePrefix.length();
                    i15 = i29;
                    int i31 = 0;
                    while (i31 < length3) {
                        int i32 = length3;
                        int i33 = i30;
                        if (!CharsKt__CharKt.equals(bytePrefix.charAt(i31), str.charAt(i18 + i31), ignoreCase)) {
                            throwNotContainedAt(str, i18, i11, bytePrefix, "byte prefix");
                        }
                        i31++;
                        length3 = i32;
                        i30 = i33;
                    }
                    i16 = i30;
                    i18 += bytePrefix.length();
                }
                if (i11 - 2 < i18) {
                    throwInvalidNumberOfDigits(str, i18, i11, "exactly", 2);
                }
                int i34 = i19 + 1;
                bArr[i19] = parseByteAt(str, i18);
                i18 += 2;
                if (byteSuffix.length() != 0) {
                    i17 = i34;
                } else {
                    int length4 = byteSuffix.length();
                    int i35 = 0;
                    while (i35 < length4) {
                        int i36 = i34;
                        if (!CharsKt__CharKt.equals(byteSuffix.charAt(i35), str.charAt(i18 + i35), ignoreCase)) {
                            throwNotContainedAt(str, i18, i11, byteSuffix, "byte suffix");
                        }
                        i35++;
                        i34 = i36;
                    }
                    i17 = i34;
                    i18 += byteSuffix.length();
                }
                i20 = i15;
                i19 = i17;
                i21 = i16;
            }
            i21 = 0;
            int i292 = i12 + 1;
            int i302 = i21 + 1;
            if (bytePrefix.length() != 0) {
            }
            if (i11 - 2 < i18) {
            }
            int i342 = i19 + 1;
            bArr[i19] = parseByteAt(str, i18);
            i18 += 2;
            if (byteSuffix.length() != 0) {
            }
            i20 = i15;
            i19 = i17;
            i21 = i16;
        }
        if (i19 != parsedByteArrayMaxSize) {
            byte[] copyOf = Arrays.copyOf(bArr, i19);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            return copyOf;
        }
        return bArr;
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int hexToInt(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToInt(str, 0, str.length(), format);
    }

    public static /* synthetic */ int hexToInt$default(String str, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, hexFormat);
    }

    private static final int hexToIntImpl(String str, int i10, int i11, HexFormat hexFormat, int i12) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i10, i11, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkNumberOfDigits(str, i10, i11, i12);
            return parseInt(str, i10, i11);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixNumberOfDigits(str, i10, i11, prefix, suffix, number.getIgnoreCase(), i12);
        return parseInt(str, i10 + prefix.length(), i11 - suffix.length());
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final long hexToLong(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLong(str, 0, str.length(), format);
    }

    public static /* synthetic */ long hexToLong$default(String str, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, hexFormat);
    }

    private static final long hexToLongImpl(String str, int i10, int i11, HexFormat hexFormat, int i12) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i10, i11, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkNumberOfDigits(str, i10, i11, i12);
            return parseLong(str, i10, i11);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixNumberOfDigits(str, i10, i11, prefix, suffix, number.getIgnoreCase(), i12);
        return parseLong(str, i10 + prefix.length(), i11 - suffix.length());
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final short hexToShort(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToShort(str, 0, str.length(), format);
    }

    public static /* synthetic */ short hexToShort$default(String str, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, hexFormat);
    }

    private static final long longDecimalFromHexDigitAt(String str, int i10) {
        char charAt = str.charAt(i10);
        if ((charAt >>> '\b') == 0) {
            long j10 = HEX_DIGITS_TO_LONG_DECIMAL[charAt];
            if (j10 >= 0) {
                return j10;
            }
        }
        throwInvalidDigitAt(str, i10);
        throw new KotlinNothingValueException();
    }

    private static final byte parseByteAt(String str, int i10) {
        int[] iArr;
        int i11;
        int i12;
        char charAt = str.charAt(i10);
        if ((charAt >>> '\b') == 0 && (i11 = (iArr = HEX_DIGITS_TO_DECIMAL)[charAt]) >= 0) {
            int i13 = i10 + 1;
            char charAt2 = str.charAt(i13);
            if ((charAt2 >>> '\b') == 0 && (i12 = iArr[charAt2]) >= 0) {
                return (byte) ((i11 << 4) | i12);
            }
            throwInvalidDigitAt(str, i13);
            throw new KotlinNothingValueException();
        }
        throwInvalidDigitAt(str, i10);
        throw new KotlinNothingValueException();
    }

    private static final int parseInt(String str, int i10, int i11) {
        int i12;
        int i13 = 0;
        while (i10 < i11) {
            int i14 = i13 << 4;
            char charAt = str.charAt(i10);
            if ((charAt >>> '\b') == 0 && (i12 = HEX_DIGITS_TO_DECIMAL[charAt]) >= 0) {
                i13 = i14 | i12;
                i10++;
            } else {
                throwInvalidDigitAt(str, i10);
                throw new KotlinNothingValueException();
            }
        }
        return i13;
    }

    private static final long parseLong(String str, int i10, int i11) {
        long j10 = 0;
        while (i10 < i11) {
            long j11 = j10 << 4;
            char charAt = str.charAt(i10);
            if ((charAt >>> '\b') == 0) {
                long j12 = HEX_DIGITS_TO_LONG_DECIMAL[charAt];
                if (j12 >= 0) {
                    j10 = j11 | j12;
                    i10++;
                }
            }
            throwInvalidDigitAt(str, i10);
            throw new KotlinNothingValueException();
        }
        return j10;
    }

    public static final int parsedByteArrayMaxSize(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        long charsPerSet;
        int i17;
        int i18;
        if (i10 > 0) {
            long j10 = i15 + 2 + i16;
            long charsPerSet2 = charsPerSet(j10, i12, i14);
            if (i11 <= i12) {
                charsPerSet = charsPerSet(j10, i11, i14);
            } else {
                charsPerSet = charsPerSet(charsPerSet2, i11 / i12, i13);
                int i19 = i11 % i12;
                if (i19 != 0) {
                    charsPerSet = charsPerSet + i13 + charsPerSet(j10, i19, i14);
                }
            }
            long j11 = i10;
            long wholeElementsPerSet = wholeElementsPerSet(j11, charsPerSet, 1);
            long j12 = j11 - ((charsPerSet + 1) * wholeElementsPerSet);
            long wholeElementsPerSet2 = wholeElementsPerSet(j12, charsPerSet2, i13);
            long j13 = j12 - ((charsPerSet2 + i13) * wholeElementsPerSet2);
            long wholeElementsPerSet3 = wholeElementsPerSet(j13, j10, i14);
            if (j13 - ((j10 + i14) * wholeElementsPerSet3) > 0) {
                i18 = i11;
                i17 = 1;
            } else {
                i17 = 0;
                i18 = i11;
            }
            return (int) ((wholeElementsPerSet * i18) + (wholeElementsPerSet2 * i12) + wholeElementsPerSet3 + i17);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final Void throwInvalidDigitAt(String str, int i10) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i10 + ", but was " + str.charAt(i10));
    }

    private static final void throwInvalidNumberOfDigits(String str, int i10, int i11, String str2, int i12) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i10, i11);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i12 + " hexadecimal digits at index " + i10 + ", but was \"" + substring + "\" of length " + (i11 - i10));
    }

    private static final void throwInvalidPrefixSuffix(String str, int i10, int i11, String str2, String str3) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i10, i11);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + str2 + "\" and suffix \"" + str3 + "\", but was " + substring);
    }

    private static final void throwNotContainedAt(String str, int i10, int i11, String str2, String str3) {
        int coerceAtMost = RangesKt.coerceAtMost(str2.length() + i10, i11);
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i10, coerceAtMost);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str3 + " \"" + str2 + "\" at index " + i10 + ", but was " + substring);
    }

    private static final int toCharArrayIfNotEmpty(String str, char[] cArr, int i10) {
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                int length2 = str.length();
                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                str.getChars(0, length2, cArr, i10);
            } else {
                cArr[i10] = str.charAt(0);
            }
        }
        return i10 + str.length();
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String toHexString(@NotNull byte[] bArr, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexString(bArr, 0, bArr.length, format);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    private static final String toHexStringImpl(long j10, HexFormat.NumberHexFormat numberHexFormat, String str, int i10) {
        if ((i10 & 3) == 0) {
            int i11 = i10 >> 2;
            int minLength = numberHexFormat.getMinLength();
            int coerceAtLeast = RangesKt.coerceAtLeast(minLength - i11, 0);
            String prefix = numberHexFormat.getPrefix();
            String suffix = numberHexFormat.getSuffix();
            boolean removeLeadingZeros = numberHexFormat.getRemoveLeadingZeros();
            int checkFormatLength = checkFormatLength(prefix.length() + coerceAtLeast + i11 + suffix.length());
            char[] cArr = new char[checkFormatLength];
            int charArrayIfNotEmpty = toCharArrayIfNotEmpty(prefix, cArr, 0);
            if (coerceAtLeast > 0) {
                int i12 = coerceAtLeast + charArrayIfNotEmpty;
                ArraysKt.fill(cArr, str.charAt(0), charArrayIfNotEmpty, i12);
                charArrayIfNotEmpty = i12;
            }
            int i13 = i10;
            for (int i14 = 0; i14 < i11; i14++) {
                i13 -= 4;
                int i15 = (int) ((j10 >> i13) & 15);
                if (removeLeadingZeros && i15 == 0 && (i13 >> 2) >= minLength) {
                    removeLeadingZeros = true;
                } else {
                    removeLeadingZeros = false;
                }
                if (!removeLeadingZeros) {
                    cArr[charArrayIfNotEmpty] = str.charAt(i15);
                    charArrayIfNotEmpty++;
                }
            }
            int charArrayIfNotEmpty2 = toCharArrayIfNotEmpty(suffix, cArr, charArrayIfNotEmpty);
            if (charArrayIfNotEmpty2 == checkFormatLength) {
                return StringsKt.concatToString(cArr);
            }
            return StringsKt__StringsJVMKt.concatToString$default(cArr, 0, charArrayIfNotEmpty2, 1, null);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] bArr, int i10, int i11, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        if (bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix()) {
            return toHexStringShortByteSeparatorNoPrefixAndSuffix(bArr, i10, i11, bytesHexFormat, iArr);
        }
        return toHexStringNoLineAndGroupSeparatorSlowPath(bArr, i10, i11, bytesHexFormat, iArr);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] bArr, int i10, int i11, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        char[] cArr = new char[formattedStringLength(i11 - i10, byteSeparator.length(), bytePrefix.length(), byteSuffix.length())];
        int formatByteAt = formatByteAt(bArr, i10, bytePrefix, byteSuffix, iArr, cArr, 0);
        while (true) {
            i10++;
            if (i10 < i11) {
                formatByteAt = formatByteAt(bArr, i10, bytePrefix, byteSuffix, iArr, cArr, toCharArrayIfNotEmpty(byteSeparator, cArr, formatByteAt));
            } else {
                return StringsKt.concatToString(cArr);
            }
        }
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] bArr, int i10, int i11, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length <= 1) {
            int i12 = i11 - i10;
            int i13 = 0;
            if (length == 0) {
                char[] cArr = new char[checkFormatLength(i12 * 2)];
                while (i10 < i11) {
                    i13 = formatByteAt(bArr, i10, iArr, cArr, i13);
                    i10++;
                }
                return StringsKt.concatToString(cArr);
            }
            char[] cArr2 = new char[checkFormatLength((i12 * 3) - 1)];
            char charAt = bytesHexFormat.getByteSeparator().charAt(0);
            int formatByteAt = formatByteAt(bArr, i10, iArr, cArr2, 0);
            for (int i14 = i10 + 1; i14 < i11; i14++) {
                cArr2[formatByteAt] = charAt;
                formatByteAt = formatByteAt(bArr, i14, iArr, cArr2, formatByteAt + 1);
            }
            return StringsKt.concatToString(cArr2);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final String toHexStringSlowPath(byte[] bArr, int i10, int i11, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int i12;
        int i13;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        int formattedStringLength = formattedStringLength(i11 - i10, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        char[] cArr = new char[formattedStringLength];
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = i10; i17 < i11; i17++) {
            if (i15 == bytesPerLine) {
                cArr[i14] = '\n';
                i14++;
                i12 = 0;
            } else if (i16 == bytesPerGroup) {
                i14 = toCharArrayIfNotEmpty(groupSeparator, cArr, i14);
                i12 = i15;
            } else {
                i12 = i15;
                i13 = i16;
                if (i13 == 0) {
                    i14 = toCharArrayIfNotEmpty(byteSeparator, cArr, i14);
                }
                i14 = formatByteAt(bArr, i17, bytePrefix, byteSuffix, iArr, cArr, i14);
                i16 = i13 + 1;
                i15 = i12 + 1;
            }
            i13 = 0;
            if (i13 == 0) {
            }
            i14 = formatByteAt(bArr, i17, bytePrefix, byteSuffix, iArr, cArr, i14);
            i16 = i13 + 1;
            i15 = i12 + 1;
        }
        if (i14 == formattedStringLength) {
            return StringsKt.concatToString(cArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    private static final long wholeElementsPerSet(long j10, long j11, int i10) {
        if (j10 <= 0 || j11 <= 0) {
            return 0L;
        }
        long j12 = i10;
        return (j10 + j12) / (j11 + j12);
    }

    private static final byte hexToByte(String str, int i10, int i11, HexFormat hexFormat) {
        return (byte) hexToIntImpl(str, i10, i11, hexFormat, 2);
    }

    private static final byte[] hexToByteArray(String str, int i10, int i11, HexFormat hexFormat) {
        byte[] hexToByteArrayNoLineAndGroupSeparator;
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i10, i11, str.length());
        if (i10 == i11) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat bytes = hexFormat.getBytes();
        return (!bytes.getNoLineAndGroupSeparator() || (hexToByteArrayNoLineAndGroupSeparator = hexToByteArrayNoLineAndGroupSeparator(str, i10, i11, bytes)) == null) ? hexToByteArraySlowPath(str, i10, i11, bytes) : hexToByteArrayNoLineAndGroupSeparator;
    }

    public static final int hexToInt(@NotNull String str, int i10, int i11, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToIntImpl(str, i10, i11, format, 8);
    }

    public static final long hexToLong(@NotNull String str, int i10, int i11, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLongImpl(str, i10, i11, format, 16);
    }

    private static final short hexToShort(String str, int i10, int i11, HexFormat hexFormat) {
        return (short) hexToIntImpl(str, i10, i11, hexFormat, 4);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String toHexString(@NotNull byte[] bArr, int i10, int i11, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i10, i11, bArr.length);
        if (i10 == i11) {
            return "";
        }
        int[] iArr = format.getUpperCase() ? BYTE_TO_UPPER_CASE_HEX_DIGITS : BYTE_TO_LOWER_CASE_HEX_DIGITS;
        HexFormat.BytesHexFormat bytes = format.getBytes();
        if (bytes.getNoLineAndGroupSeparator()) {
            return toHexStringNoLineAndGroupSeparator(bArr, i10, i11, bytes, iArr);
        }
        return toHexStringSlowPath(bArr, i10, i11, bytes, iArr);
    }

    public static final int formattedStringLength(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (i10 > 0) {
            int i17 = (i10 - 1) / i11;
            int i18 = (i11 - 1) / i12;
            int i19 = i10 % i11;
            if (i19 != 0) {
                i11 = i19;
            }
            return checkFormatLength(i17 + (((i18 * i17) + ((i11 - 1) / i12)) * i13) + (((r0 - i17) - r2) * i14) + (i10 * (i15 + 2 + i16)));
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    static /* synthetic */ byte hexToByte$default(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, i10, i11, hexFormat);
    }

    static /* synthetic */ byte[] hexToByteArray$default(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, i10, i11, hexFormat);
    }

    public static /* synthetic */ int hexToInt$default(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, i10, i11, hexFormat);
    }

    public static /* synthetic */ long hexToLong$default(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, i10, i11, hexFormat);
    }

    static /* synthetic */ short hexToShort$default(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, i10, i11, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, i10, i11, hexFormat);
    }

    private static final int formatByteAt(byte[] bArr, int i10, int[] iArr, char[] cArr, int i11) {
        int i12 = iArr[bArr[i10] & UByte.MAX_VALUE];
        cArr[i11] = (char) (i12 >> 8);
        cArr[i11 + 1] = (char) (i12 & KotlinVersion.MAX_COMPONENT_VALUE);
        return i11 + 2;
    }

    public static /* synthetic */ String toHexString$default(byte b10, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(b10, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(short s10, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(s10, hexFormat);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String toHexString(byte b10, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((b10 >> 4) & 15), str.charAt(b10 & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(b10 & UByte.MAX_VALUE) - 24) >> 2, 1), 0, 2, null);
            }
            return StringsKt.concatToString(cArr);
        }
        return toHexStringImpl(b10, number, str, 8);
    }

    public static /* synthetic */ String toHexString$default(int i10, HexFormat hexFormat, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(i10, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(long j10, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(j10, hexFormat);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String toHexString(short s10, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((s10 >> 12) & 15), str.charAt((s10 >> 8) & 15), str.charAt((s10 >> 4) & 15), str.charAt(s10 & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(s10 & UShort.MAX_VALUE) - 16) >> 2, 3), 0, 2, null);
            }
            return StringsKt.concatToString(cArr);
        }
        return toHexStringImpl(s10, number, str, 16);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String toHexString(int i10, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((i10 >> 28) & 15), str.charAt((i10 >> 24) & 15), str.charAt((i10 >> 20) & 15), str.charAt((i10 >> 16) & 15), str.charAt((i10 >> 12) & 15), str.charAt((i10 >> 8) & 15), str.charAt((i10 >> 4) & 15), str.charAt(i10 & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(i10) >> 2, 7), 0, 2, null);
            }
            return StringsKt.concatToString(cArr);
        }
        return toHexStringImpl(i10, number, str, 32);
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String toHexString(long j10, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((int) ((j10 >> 60) & 15)), str.charAt((int) ((j10 >> 56) & 15)), str.charAt((int) ((j10 >> 52) & 15)), str.charAt((int) ((j10 >> 48) & 15)), str.charAt((int) ((j10 >> 44) & 15)), str.charAt((int) ((j10 >> 40) & 15)), str.charAt((int) ((j10 >> 36) & 15)), str.charAt((int) ((j10 >> 32) & 15)), str.charAt((int) ((j10 >> 28) & 15)), str.charAt((int) ((j10 >> 24) & 15)), str.charAt((int) ((j10 >> 20) & 15)), str.charAt((int) ((j10 >> 16) & 15)), str.charAt((int) ((j10 >> 12) & 15)), str.charAt((int) ((j10 >> 8) & 15)), str.charAt((int) ((j10 >> 4) & 15)), str.charAt((int) (15 & j10))};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost(Long.numberOfLeadingZeros(j10) >> 2, 15), 0, 2, null);
            }
            return StringsKt.concatToString(cArr);
        }
        return toHexStringImpl(j10, number, str, 64);
    }
}
