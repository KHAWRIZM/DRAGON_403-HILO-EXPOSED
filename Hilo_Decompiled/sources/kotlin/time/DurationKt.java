package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0015\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a)\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a)\u0010\u001c\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002\u001a\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u001a\u0015\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u001d\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010-\u001a\u0015\u0010.\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010/\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\"\u000e\u0010\u001d\u001a\u00020\u0002X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"toDuration", "Lkotlin/time/Duration;", "", "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "times", "duration", "times-mvk6XK0", "(IJ)J", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "substringWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "skipWhile", "NANOS_IN_MILLIS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1062:1\n1015#1,6:1064\n1018#1,3:1070\n1015#1,6:1073\n1015#1,6:1079\n1018#1,3:1085\n1#2:1063\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n930#1:1064,6\n964#1:1070,3\n967#1:1073,6\n970#1:1079,6\n1015#1:1085,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final long durationOf(long j10, int i10) {
        return Duration.m١٩٩٥constructorimpl((j10 << 1) + i10);
    }

    public static final long durationOfMillis(long j10) {
        return Duration.m١٩٩٥constructorimpl((j10 << 1) + 1);
    }

    public static final long durationOfMillisNormalized(long j10) {
        if (-4611686018426L <= j10 && j10 < 4611686018427L) {
            return durationOfNanos(millisToNanos(j10));
        }
        return durationOfMillis(RangesKt.coerceIn(j10, -4611686018427387903L, MAX_MILLIS));
    }

    public static final long durationOfNanos(long j10) {
        return Duration.m١٩٩٥constructorimpl(j10 << 1);
    }

    public static final long durationOfNanosNormalized(long j10) {
        if (-4611686018426999999L <= j10 && j10 < 4611686018427000000L) {
            return durationOfNanos(j10);
        }
        return durationOfMillis(nanosToMillis(j10));
    }

    public static final long millisToNanos(long j10) {
        return j10 * 1000000;
    }

    public static final long nanosToMillis(long j10) {
        return j10 / 1000000;
    }

    public static final long parseDuration(String str, boolean z10) {
        int i10;
        boolean z11;
        boolean z12;
        long j10;
        char charAt;
        char charAt2;
        int i11;
        char charAt3;
        int length = str.length();
        if (length != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            long j11 = companion.m٢٠٨٦getZEROUwyO8pc();
            char charAt4 = str.charAt(0);
            if (charAt4 != '+' && charAt4 != '-') {
                i10 = 0;
            } else {
                i10 = 1;
            }
            if (i10 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && StringsKt.startsWith$default((CharSequence) str, '-', false, 2, (Object) null)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (length > i10) {
                char c10 = ':';
                char c11 = '0';
                if (str.charAt(i10) == 'P') {
                    int i12 = i10 + 1;
                    if (i12 != length) {
                        DurationUnit durationUnit = null;
                        boolean z13 = false;
                        while (i12 < length) {
                            if (str.charAt(i12) == 'T') {
                                if (!z13 && (i12 = i12 + 1) != length) {
                                    z13 = true;
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            } else {
                                int i13 = i12;
                                while (i13 < str.length() && ((c11 <= (charAt3 = str.charAt(i13)) && charAt3 < c10) || StringsKt.contains$default((CharSequence) "+-.", charAt3, false, 2, (Object) null))) {
                                    i13++;
                                    c10 = ':';
                                    c11 = '0';
                                }
                                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                                String substring = str.substring(i12, i13);
                                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                if (substring.length() != 0) {
                                    int length2 = i12 + substring.length();
                                    if (length2 >= 0 && length2 < str.length()) {
                                        char charAt5 = str.charAt(length2);
                                        int i14 = length2 + 1;
                                        DurationUnit durationUnitByIsoChar = DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(charAt5, z13);
                                        if (durationUnit != null && durationUnit.compareTo(durationUnitByIsoChar) <= 0) {
                                            throw new IllegalArgumentException("Unexpected order of duration components");
                                        }
                                        int indexOf$default = StringsKt.indexOf$default((CharSequence) substring, '.', 0, false, 6, (Object) null);
                                        if (durationUnitByIsoChar == DurationUnit.SECONDS && indexOf$default > 0) {
                                            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                                            String substring2 = substring.substring(0, indexOf$default);
                                            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                            i11 = i14;
                                            long j12 = Duration.m٢٠٢٤plusLRDsOJo(j11, toDuration(parseOverLongIsoComponent(substring2), durationUnitByIsoChar));
                                            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                                            String substring3 = substring.substring(indexOf$default);
                                            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                                            j11 = Duration.m٢٠٢٤plusLRDsOJo(j12, toDuration(Double.parseDouble(substring3), durationUnitByIsoChar));
                                        } else {
                                            i11 = i14;
                                            j11 = Duration.m٢٠٢٤plusLRDsOJo(j11, toDuration(parseOverLongIsoComponent(substring), durationUnitByIsoChar));
                                        }
                                        i12 = i11;
                                        durationUnit = durationUnitByIsoChar;
                                        c10 = ':';
                                        c11 = '0';
                                    } else {
                                        throw new IllegalArgumentException("Missing unit for value " + substring);
                                    }
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (!z10) {
                    String str2 = "Unexpected order of duration components";
                    if (StringsKt.regionMatches(str, i10, "Infinity", 0, Math.max(length - i10, 8), true)) {
                        j11 = companion.m٢٠٨٤getINFINITEUwyO8pc();
                    } else {
                        boolean z14 = !z11;
                        if (z11 && str.charAt(i10) == '(' && StringsKt.last(str) == ')') {
                            i10++;
                            length--;
                            if (i10 != length) {
                                j10 = j11;
                                z14 = true;
                            } else {
                                throw new IllegalArgumentException("No components");
                            }
                        } else {
                            j10 = j11;
                        }
                        DurationUnit durationUnit2 = null;
                        boolean z15 = false;
                        while (i10 < length) {
                            if (z15 && z14) {
                                while (i10 < str.length() && str.charAt(i10) == ' ') {
                                    i10++;
                                }
                            }
                            int i15 = i10;
                            while (i15 < str.length() && (('0' <= (charAt2 = str.charAt(i15)) && charAt2 < ':') || charAt2 == '.')) {
                                i15++;
                            }
                            Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                            String substring4 = str.substring(i10, i15);
                            Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                            if (substring4.length() != 0) {
                                int length3 = i10 + substring4.length();
                                int i16 = length3;
                                while (i16 < str.length() && 'a' <= (charAt = str.charAt(i16)) && charAt < '{') {
                                    i16++;
                                }
                                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                                String substring5 = str.substring(length3, i16);
                                Intrinsics.checkNotNullExpressionValue(substring5, "substring(...)");
                                i10 = length3 + substring5.length();
                                DurationUnit durationUnitByShortName = DurationUnitKt__DurationUnitKt.durationUnitByShortName(substring5);
                                if (durationUnit2 == null || durationUnit2.compareTo(durationUnitByShortName) > 0) {
                                    String str3 = str2;
                                    int indexOf$default2 = StringsKt.indexOf$default((CharSequence) substring4, '.', 0, false, 6, (Object) null);
                                    if (indexOf$default2 > 0) {
                                        Intrinsics.checkNotNull(substring4, "null cannot be cast to non-null type java.lang.String");
                                        String substring6 = substring4.substring(0, indexOf$default2);
                                        Intrinsics.checkNotNullExpressionValue(substring6, "substring(...)");
                                        long j13 = Duration.m٢٠٢٤plusLRDsOJo(j10, toDuration(Long.parseLong(substring6), durationUnitByShortName));
                                        Intrinsics.checkNotNull(substring4, "null cannot be cast to non-null type java.lang.String");
                                        String substring7 = substring4.substring(indexOf$default2);
                                        Intrinsics.checkNotNullExpressionValue(substring7, "substring(...)");
                                        j10 = Duration.m٢٠٢٤plusLRDsOJo(j13, toDuration(Double.parseDouble(substring7), durationUnitByShortName));
                                        i10 = i10;
                                        if (i10 < length) {
                                            throw new IllegalArgumentException("Fractional component must be last");
                                        }
                                    } else {
                                        j10 = Duration.m٢٠٢٤plusLRDsOJo(j10, toDuration(Long.parseLong(substring4), durationUnitByShortName));
                                    }
                                    str2 = str3;
                                    durationUnit2 = durationUnitByShortName;
                                    z15 = true;
                                } else {
                                    throw new IllegalArgumentException(str2);
                                }
                            } else {
                                throw new IllegalArgumentException();
                            }
                        }
                        j11 = j10;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
                if (z12) {
                    return Duration.m٢٠٣٩unaryMinusUwyO8pc(j11);
                }
                return j11;
            }
            throw new IllegalArgumentException("No components");
        }
        throw new IllegalArgumentException("The string is empty");
    }

    private static final long parseOverLongIsoComponent(String str) {
        int i10;
        char charAt;
        int length = str.length();
        if (length > 0 && StringsKt.contains$default((CharSequence) "+-", str.charAt(0), false, 2, (Object) null)) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (length - i10 > 16) {
            int i11 = i10;
            while (true) {
                if (i10 < length) {
                    char charAt2 = str.charAt(i10);
                    if (charAt2 == '0') {
                        if (i11 == i10) {
                            i11++;
                        }
                    } else if ('1' > charAt2 || charAt2 >= ':') {
                        break;
                    }
                    i10++;
                } else if (length - i11 > 16) {
                    if (str.charAt(0) == '-') {
                        return Long.MIN_VALUE;
                    }
                    return LongCompanionObject.MAX_VALUE;
                }
            }
        }
        if (StringsKt.startsWith$default(str, "+", false, 2, (Object) null) && length > 1 && '0' <= (charAt = str.charAt(1)) && charAt < ':') {
            str = StringsKt.drop(str, 1);
        }
        return Long.parseLong(str);
    }

    private static final int skipWhile(String str, int i10, Function1<? super Character, Boolean> function1) {
        while (i10 < str.length() && function1.invoke(Character.valueOf(str.charAt(i10))).booleanValue()) {
            i10++;
        }
        return i10;
    }

    private static final String substringWhile(String str, int i10, Function1<? super Character, Boolean> function1) {
        int i11 = i10;
        while (i11 < str.length() && function1.invoke(Character.valueOf(str.charAt(i11))).booleanValue()) {
            i11++;
        }
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i10, i11);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    /* renamed from: times-kIfJnKk */
    private static final long m٢٠٩١timeskIfJnKk(double d10, long j10) {
        return Duration.m٢٠٢٥timesUwyO8pc(j10, d10);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    /* renamed from: times-mvk6XK0 */
    private static final long m٢٠٩٢timesmvk6XK0(int i10, long j10) {
        return Duration.m٢٠٢٦timesUwyO8pc(j10, i10);
    }

    @SinceKotlin(version = "1.6")
    public static final long toDuration(int i10, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(i10, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration(i10, unit);
    }

    @SinceKotlin(version = "1.6")
    public static final long toDuration(long j10, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long convertDurationUnitOverflow = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, durationUnit, unit);
        if ((-convertDurationUnitOverflow) <= j10 && j10 <= convertDurationUnitOverflow) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j10, unit, durationUnit));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j10, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    }

    @SinceKotlin(version = "1.6")
    public static final long toDuration(double d10, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double convertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d10, unit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(convertDurationUnit)) {
            long roundToLong = MathKt.roundToLong(convertDurationUnit);
            if (-4611686018426999999L <= roundToLong && roundToLong < 4611686018427000000L) {
                return durationOfNanos(roundToLong);
            }
            return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d10, unit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.");
    }
}
