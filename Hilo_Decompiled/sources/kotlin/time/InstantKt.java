package kotlin.time;

import anet.channel.util.ErrorConstant;
import com.facebook.internal.NativeProtocol;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Typography;
import kotlin.time.InstantParseResult;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0006\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0003\u001a'\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a'\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a\u0010\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a\u0014\u0010'\u001a\u00020\u0015*\u00020\u00152\u0006\u0010%\u001a\u00020\u0001H\u0002\u001a\u0014\u0010-\u001a\u00020\u0012*\u00020\u00102\u0006\u0010.\u001a\u00020\u0015H\u0002\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"\u001f\u0010\u0006\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0015X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"isDistantPast", "", "Lkotlin/time/Instant;", "isDistantPast$annotations", "(Lkotlin/time/Instant;)V", "(Lkotlin/time/Instant;)Z", "isDistantFuture", "isDistantFuture$annotations", "DISTANT_PAST_SECONDS", "", "DISTANT_FUTURE_SECONDS", "MIN_SECOND", "MAX_SECOND", "parseIso", "Lkotlin/time/InstantParseResult;", "isoString", "", "formatIso", "", "instant", "DAYS_PER_CYCLE", "", "DAYS_0000_TO_1970", "safeAddOrElse", "a", "b", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function0;", "", "safeMultiplyOrElse", "SECONDS_PER_HOUR", "SECONDS_PER_MINUTE", "HOURS_PER_DAY", "SECONDS_PER_DAY", "NANOS_PER_SECOND", "NANOS_PER_MILLI", "MILLIS_PER_SECOND", "isLeapYear", "year", "monthLength", "POWERS_OF_TEN", "", "asciiDigitPositionsInIsoStringAfterYear", "colonsInIsoOffsetString", "asciiDigitsInIsoOffsetString", "truncateForErrorMessage", "maxLength", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlin/time/InstantKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Instant.kt\nkotlin/time/UnboundLocalDateTime\n*L\n1#1,864:1\n1#2:865\n479#3,28:866\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlin/time/InstantKt\n*L\n689#1:866,28\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class InstantKt {
    private static final int DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long DISTANT_FUTURE_SECONDS = 3093527980800L;
    private static final long DISTANT_PAST_SECONDS = -3217862419201L;
    private static final int HOURS_PER_DAY = 24;
    private static final long MAX_SECOND = 31556889864403199L;
    private static final int MILLIS_PER_SECOND = 1000;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MILLI = 1000000;
    public static final int NANOS_PER_SECOND = 1000000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;

    @NotNull
    private static final int[] POWERS_OF_TEN = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    @NotNull
    private static final int[] asciiDigitPositionsInIsoStringAfterYear = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};

    @NotNull
    private static final int[] colonsInIsoOffsetString = {3, 6};

    @NotNull
    private static final int[] asciiDigitsInIsoOffsetString = {1, 2, 4, 5, 7, 8};

    public static final /* synthetic */ String access$formatIso(Instant instant) {
        return formatIso(instant);
    }

    public static final /* synthetic */ InstantParseResult access$parseIso(CharSequence charSequence) {
        return parseIso(charSequence);
    }

    @ExperimentalTime
    public static final String formatIso(Instant instant) {
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        UnboundLocalDateTime fromInstant = UnboundLocalDateTime.INSTANCE.fromInstant(instant);
        int year = fromInstant.getYear();
        int i10 = 0;
        if (Math.abs(year) < 1000) {
            StringBuilder sb2 = new StringBuilder();
            if (year >= 0) {
                sb2.append(year + 10000);
                Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(0), "deleteCharAt(...)");
            } else {
                sb2.append(year - 10000);
                Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(1), "deleteCharAt(...)");
            }
            sb.append((CharSequence) sb2);
        } else {
            if (year >= 10000) {
                sb.append('+');
            }
            sb.append(year);
        }
        sb.append('-');
        formatIso$lambda$13$appendTwoDigits(sb, sb, fromInstant.getMonth());
        sb.append('-');
        formatIso$lambda$13$appendTwoDigits(sb, sb, fromInstant.getDay());
        sb.append('T');
        formatIso$lambda$13$appendTwoDigits(sb, sb, fromInstant.getHour());
        sb.append(':');
        formatIso$lambda$13$appendTwoDigits(sb, sb, fromInstant.getMinute());
        sb.append(':');
        formatIso$lambda$13$appendTwoDigits(sb, sb, fromInstant.getSecond());
        if (fromInstant.getNanosecond() != 0) {
            sb.append('.');
            while (true) {
                int nanosecond = fromInstant.getNanosecond();
                iArr = POWERS_OF_TEN;
                int i11 = i10 + 1;
                if (nanosecond % iArr[i11] != 0) {
                    break;
                }
                i10 = i11;
            }
            int i12 = i10 - (i10 % 3);
            String valueOf = String.valueOf((fromInstant.getNanosecond() / iArr[i12]) + iArr[9 - i12]);
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String substring = valueOf.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb.append(substring);
        }
        sb.append('Z');
        return sb.toString();
    }

    private static final void formatIso$lambda$13$appendTwoDigits(Appendable appendable, StringBuilder sb, int i10) {
        if (i10 < 10) {
            appendable.append('0');
        }
        sb.append(i10);
    }

    private static final boolean isDistantFuture(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        if (instant.compareTo(Instant.INSTANCE.getDISTANT_FUTURE()) >= 0) {
            return true;
        }
        return false;
    }

    @SinceKotlin(version = "2.1")
    @InlineOnly
    @ExperimentalTime
    public static /* synthetic */ void isDistantFuture$annotations(Instant instant) {
    }

    private static final boolean isDistantPast(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        if (instant.compareTo(Instant.INSTANCE.getDISTANT_PAST()) <= 0) {
            return true;
        }
        return false;
    }

    @SinceKotlin(version = "2.1")
    @InlineOnly
    @ExperimentalTime
    public static /* synthetic */ void isDistantPast$annotations(Instant instant) {
    }

    public static final boolean isLeapYear(int i10) {
        if ((i10 & 3) == 0 && (i10 % 100 != 0 || i10 % 400 == 0)) {
            return true;
        }
        return false;
    }

    private static final int monthLength(int i10, boolean z10) {
        return i10 != 2 ? (i10 == 4 || i10 == 6 || i10 == 9 || i10 == 11) ? 30 : 31 : z10 ? 29 : 28;
    }

    @ExperimentalTime
    public static final InstantParseResult parseIso(CharSequence charSequence) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        long j10;
        char charAt;
        char charAt2;
        if (charSequence.length() == 0) {
            return new InstantParseResult.Failure("An empty string is not a valid Instant", charSequence);
        }
        char charAt3 = charSequence.charAt(0);
        if (charAt3 != '+' && charAt3 != '-') {
            charAt3 = ' ';
            i10 = 0;
        } else {
            i10 = 1;
        }
        int i17 = i10;
        int i18 = 0;
        while (i17 < charSequence.length() && '0' <= (charAt2 = charSequence.charAt(i17)) && charAt2 < ':') {
            i18 = (i18 * 10) + (charSequence.charAt(i17) - '0');
            i17++;
        }
        int i19 = i17 - i10;
        if (i19 > 10) {
            return parseIso$parseFailure(charSequence, "Expected at most 10 digits for the year number, got " + i19 + " digits");
        }
        if (i19 == 10 && Intrinsics.compare((int) charSequence.charAt(i10), 50) >= 0) {
            return parseIso$parseFailure(charSequence, "Expected at most 9 digits for the year number or year 1000000000, got " + i19 + " digits");
        }
        if (i19 < 4) {
            return parseIso$parseFailure(charSequence, "The year number must be padded to 4 digits, got " + i19 + " digits");
        }
        if (charAt3 == '+' && i19 == 4) {
            return parseIso$parseFailure(charSequence, "The '+' sign at the start is only valid for year numbers longer than 4 digits");
        }
        if (charAt3 == ' ' && i19 != 4) {
            return parseIso$parseFailure(charSequence, "A '+' or '-' sign is required for year numbers longer than 4 digits");
        }
        if (charAt3 == '-') {
            i18 = -i18;
        }
        int i20 = i17 + 16;
        if (charSequence.length() < i20) {
            return parseIso$parseFailure(charSequence, "The input string is too short");
        }
        InstantParseResult.Failure parseIso$expect = parseIso$expect(charSequence, "'-'", i17, new Function1() { // from class: kotlin.time.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean parseIso$lambda$0;
                parseIso$lambda$0 = InstantKt.parseIso$lambda$0(((Character) obj).charValue());
                return Boolean.valueOf(parseIso$lambda$0);
            }
        });
        if (parseIso$expect != null) {
            return parseIso$expect;
        }
        InstantParseResult.Failure parseIso$expect2 = parseIso$expect(charSequence, "'-'", i17 + 3, new Function1() { // from class: kotlin.time.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean parseIso$lambda$2;
                parseIso$lambda$2 = InstantKt.parseIso$lambda$2(((Character) obj).charValue());
                return Boolean.valueOf(parseIso$lambda$2);
            }
        });
        if (parseIso$expect2 != null) {
            return parseIso$expect2;
        }
        InstantParseResult.Failure parseIso$expect3 = parseIso$expect(charSequence, "'T' or 't'", i17 + 6, new Function1() { // from class: kotlin.time.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean parseIso$lambda$4;
                parseIso$lambda$4 = InstantKt.parseIso$lambda$4(((Character) obj).charValue());
                return Boolean.valueOf(parseIso$lambda$4);
            }
        });
        if (parseIso$expect3 != null) {
            return parseIso$expect3;
        }
        InstantParseResult.Failure parseIso$expect4 = parseIso$expect(charSequence, "':'", i17 + 9, new Function1() { // from class: kotlin.time.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean parseIso$lambda$6;
                parseIso$lambda$6 = InstantKt.parseIso$lambda$6(((Character) obj).charValue());
                return Boolean.valueOf(parseIso$lambda$6);
            }
        });
        if (parseIso$expect4 != null) {
            return parseIso$expect4;
        }
        InstantParseResult.Failure parseIso$expect5 = parseIso$expect(charSequence, "':'", i17 + 12, new Function1() { // from class: kotlin.time.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean parseIso$lambda$8;
                parseIso$lambda$8 = InstantKt.parseIso$lambda$8(((Character) obj).charValue());
                return Boolean.valueOf(parseIso$lambda$8);
            }
        });
        if (parseIso$expect5 != null) {
            return parseIso$expect5;
        }
        for (int i21 : asciiDigitPositionsInIsoStringAfterYear) {
            InstantParseResult.Failure parseIso$expect6 = parseIso$expect(charSequence, "an ASCII digit", i17 + i21, new Function1() { // from class: kotlin.time.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean parseIso$lambda$10;
                    parseIso$lambda$10 = InstantKt.parseIso$lambda$10(((Character) obj).charValue());
                    return Boolean.valueOf(parseIso$lambda$10);
                }
            });
            if (parseIso$expect6 != null) {
                return parseIso$expect6;
            }
        }
        int parseIso$twoDigitNumber = parseIso$twoDigitNumber(charSequence, i17 + 1);
        int parseIso$twoDigitNumber2 = parseIso$twoDigitNumber(charSequence, i17 + 4);
        int parseIso$twoDigitNumber3 = parseIso$twoDigitNumber(charSequence, i17 + 7);
        int parseIso$twoDigitNumber4 = parseIso$twoDigitNumber(charSequence, i17 + 10);
        int parseIso$twoDigitNumber5 = parseIso$twoDigitNumber(charSequence, i17 + 13);
        int i22 = i17 + 15;
        if (charSequence.charAt(i22) == '.') {
            i22 = i20;
            int i23 = 0;
            while (i22 < charSequence.length() && '0' <= (charAt = charSequence.charAt(i22)) && charAt < ':') {
                i23 = (i23 * 10) + (charSequence.charAt(i22) - '0');
                i22++;
            }
            int i24 = i22 - i20;
            if (1 <= i24 && i24 < 10) {
                i11 = i23 * POWERS_OF_TEN[9 - i24];
            } else {
                return parseIso$parseFailure(charSequence, "1..9 digits are supported for the fraction of the second, got " + i24 + " digits");
            }
        } else {
            i11 = 0;
        }
        if (i22 >= charSequence.length()) {
            return parseIso$parseFailure(charSequence, "The UTC offset at the end of the string is missing");
        }
        char charAt4 = charSequence.charAt(i22);
        if (charAt4 != '+' && charAt4 != '-') {
            if (charAt4 != 'Z' && charAt4 != 'z') {
                return parseIso$parseFailure(charSequence, "Expected the UTC offset at position " + i22 + ", got '" + charAt4 + '\'');
            }
            int i25 = i22 + 1;
            if (charSequence.length() == i25) {
                i15 = 0;
                i16 = 1;
            } else {
                return parseIso$parseFailure(charSequence, "Extra text after the instant at position " + i25);
            }
        } else {
            int length = charSequence.length() - i22;
            if (length > 9) {
                return parseIso$parseFailure(charSequence, "The UTC offset string \"" + truncateForErrorMessage(charSequence.subSequence(i22, charSequence.length()).toString(), 16) + "\" is too long");
            }
            if (length % 3 != 0) {
                return parseIso$parseFailure(charSequence, "Invalid UTC offset string \"" + charSequence.subSequence(i22, charSequence.length()).toString() + Typography.quote);
            }
            int[] iArr = colonsInIsoOffsetString;
            int length2 = iArr.length;
            int i26 = 0;
            while (i26 < length2) {
                int i27 = i22 + iArr[i26];
                if (i27 >= charSequence.length()) {
                    break;
                }
                int i28 = length2;
                if (charSequence.charAt(i27) != ':') {
                    return parseIso$parseFailure(charSequence, "Expected ':' at index " + i27 + ", got '" + charSequence.charAt(i27) + '\'');
                }
                i26++;
                length2 = i28;
            }
            int[] iArr2 = asciiDigitsInIsoOffsetString;
            int length3 = iArr2.length;
            int i29 = 0;
            while (i29 < length3) {
                int i30 = iArr2[i29] + i22;
                if (i30 >= charSequence.length()) {
                    break;
                }
                char charAt5 = charSequence.charAt(i30);
                int[] iArr3 = iArr2;
                if ('0' <= charAt5 && charAt5 < ':') {
                    i29++;
                    iArr2 = iArr3;
                } else {
                    return parseIso$parseFailure(charSequence, "Expected an ASCII digit at index " + i30 + ", got '" + charSequence.charAt(i30) + '\'');
                }
            }
            int parseIso$twoDigitNumber6 = parseIso$twoDigitNumber(charSequence, i22 + 1);
            if (length > 3) {
                i12 = parseIso$twoDigitNumber(charSequence, i22 + 4);
            } else {
                i12 = 0;
            }
            if (length > 6) {
                i13 = parseIso$twoDigitNumber(charSequence, i22 + 7);
            } else {
                i13 = 0;
            }
            if (i12 > 59) {
                return parseIso$parseFailure(charSequence, "Expected offset-minute-of-hour in 0..59, got " + i12);
            }
            if (i13 > 59) {
                return parseIso$parseFailure(charSequence, "Expected offset-second-of-minute in 0..59, got " + i13);
            }
            if (parseIso$twoDigitNumber6 > 17 && (parseIso$twoDigitNumber6 != 18 || i12 != 0 || i13 != 0)) {
                return parseIso$parseFailure(charSequence, "Expected an offset in -18:00..+18:00, got " + charSequence.subSequence(i22, charSequence.length()).toString());
            }
            int i31 = (parseIso$twoDigitNumber6 * 3600) + (i12 * 60) + i13;
            if (charAt4 == '-') {
                i14 = -1;
            } else {
                i14 = 1;
            }
            i15 = i14 * i31;
            i16 = 1;
        }
        if (i16 <= parseIso$twoDigitNumber && parseIso$twoDigitNumber < 13) {
            if (i16 <= parseIso$twoDigitNumber2 && parseIso$twoDigitNumber2 <= monthLength(parseIso$twoDigitNumber, isLeapYear(i18))) {
                if (parseIso$twoDigitNumber3 > 23) {
                    return parseIso$parseFailure(charSequence, "Expected hour in 0..23, got " + parseIso$twoDigitNumber3);
                }
                if (parseIso$twoDigitNumber4 > 59) {
                    return parseIso$parseFailure(charSequence, "Expected minute-of-hour in 0..59, got " + parseIso$twoDigitNumber4);
                }
                if (parseIso$twoDigitNumber5 > 59) {
                    return parseIso$parseFailure(charSequence, "Expected second-of-minute in 0..59, got " + parseIso$twoDigitNumber5);
                }
                UnboundLocalDateTime unboundLocalDateTime = new UnboundLocalDateTime(i18, parseIso$twoDigitNumber, parseIso$twoDigitNumber2, parseIso$twoDigitNumber3, parseIso$twoDigitNumber4, parseIso$twoDigitNumber5, i11);
                long year = unboundLocalDateTime.getYear();
                long j11 = 365 * year;
                if (year >= 0) {
                    j10 = j11 + (((3 + year) / 4) - ((99 + year) / 100)) + ((year + 399) / 400);
                } else {
                    j10 = j11 - (((year / (-4)) - (year / (-100))) + (year / ErrorConstant.ERROR_CONN_TIME_OUT));
                }
                long month = j10 + (((unboundLocalDateTime.getMonth() * 367) - 362) / 12) + (unboundLocalDateTime.getDay() - 1);
                if (unboundLocalDateTime.getMonth() > 2) {
                    month = !isLeapYear(unboundLocalDateTime.getYear()) ? month - 2 : (-1) + month;
                }
                return new InstantParseResult.Success((((month - DAYS_0000_TO_1970) * 86400) + (((unboundLocalDateTime.getHour() * 3600) + (unboundLocalDateTime.getMinute() * 60)) + unboundLocalDateTime.getSecond())) - i15, unboundLocalDateTime.getNanosecond());
            }
            return parseIso$parseFailure(charSequence, "Expected a valid day-of-month for month " + parseIso$twoDigitNumber + " of year " + i18 + ", got " + parseIso$twoDigitNumber2);
        }
        return parseIso$parseFailure(charSequence, "Expected a month number in 1..12, got " + parseIso$twoDigitNumber);
    }

    private static final InstantParseResult.Failure parseIso$expect(CharSequence charSequence, String str, int i10, Function1<? super Character, Boolean> function1) {
        char charAt = charSequence.charAt(i10);
        if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
            return null;
        }
        return parseIso$parseFailure(charSequence, "Expected " + str + ", but got '" + charAt + "' at position " + i10);
    }

    public static final boolean parseIso$lambda$0(char c10) {
        return c10 == '-';
    }

    public static final boolean parseIso$lambda$10(char c10) {
        return '0' <= c10 && c10 < ':';
    }

    public static final boolean parseIso$lambda$2(char c10) {
        return c10 == '-';
    }

    public static final boolean parseIso$lambda$4(char c10) {
        return c10 == 'T' || c10 == 't';
    }

    public static final boolean parseIso$lambda$6(char c10) {
        return c10 == ':';
    }

    public static final boolean parseIso$lambda$8(char c10) {
        return c10 == ':';
    }

    private static final InstantParseResult.Failure parseIso$parseFailure(CharSequence charSequence, String str) {
        return new InstantParseResult.Failure(str + " when parsing an Instant from \"" + truncateForErrorMessage(charSequence, 64) + Typography.quote, charSequence);
    }

    private static final int parseIso$twoDigitNumber(CharSequence charSequence, int i10) {
        return ((charSequence.charAt(i10) - '0') * 10) + (charSequence.charAt(i10 + 1) - '0');
    }

    private static final long safeAddOrElse(long j10, long j11, Function0 function0) {
        long j12 = j10 + j11;
        if ((j10 ^ j12) < 0 && (j10 ^ j11) >= 0) {
            function0.invoke();
            throw new KotlinNothingValueException();
        }
        return j12;
    }

    private static final long safeMultiplyOrElse(long j10, long j11, Function0 function0) {
        if (j11 == 1) {
            return j10;
        }
        if (j10 == 1) {
            return j11;
        }
        if (j10 == 0 || j11 == 0) {
            return 0L;
        }
        long j12 = j10 * j11;
        if (j12 / j11 == j10 && ((j10 != Long.MIN_VALUE || j11 != -1) && (j11 != Long.MIN_VALUE || j10 != -1))) {
            return j12;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    public static final String truncateForErrorMessage(CharSequence charSequence, int i10) {
        if (charSequence.length() <= i10) {
            return charSequence.toString();
        }
        return charSequence.subSequence(0, i10).toString() + "...";
    }
}
