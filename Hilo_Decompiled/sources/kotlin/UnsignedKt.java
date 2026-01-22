package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0001¢\u0006\u0004\b\r\u0010\u000b\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0001\u001a\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0001\u001a\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b¢\u0006\u0002\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0016\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0017H\u0081\b¢\u0006\u0002\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0001\u001a\u0015\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0010\u001d\u001a\u0011\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0011H\u0081\b\u001a\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0017H\u0081\b¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0001\u001a\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0010#\u001a\u0011\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0019\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0081\b\u001a\u0011\u0010'\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0011H\u0081\b\u001a\u0018\u0010'\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000fH\u0000¨\u0006("}, d2 = {"uintRemainder", "Lkotlin/UInt;", "v1", "v2", "uintRemainder-J1ME1BU", "(II)I", "uintDivide", "uintDivide-J1ME1BU", "ulongDivide", "Lkotlin/ULong;", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "uintCompare", "", "ulongCompare", "", "uintToULong", "value", "(I)J", "uintToLong", "uintToFloat", "", "floatToUInt", "(F)I", "uintToDouble", "", "doubleToUInt", "(D)I", "ulongToFloat", "floatToULong", "(F)J", "ulongToDouble", "doubleToULong", "(D)J", "uintToString", "", "base", "ulongToString", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
@JvmName(name = "UnsignedKt")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double d10) {
        if (Double.isNaN(d10) || d10 <= uintToDouble(0)) {
            return 0;
        }
        if (d10 >= uintToDouble(-1)) {
            return -1;
        }
        if (d10 <= 2.147483647E9d) {
            return UInt.m٦٣٩constructorimpl((int) d10);
        }
        return UInt.m٦٣٩constructorimpl(UInt.m٦٣٩constructorimpl((int) (d10 - Integer.MAX_VALUE)) + UInt.m٦٣٩constructorimpl(Integer.MAX_VALUE));
    }

    @PublishedApi
    public static final long doubleToULong(double d10) {
        if (Double.isNaN(d10) || d10 <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d10 >= ulongToDouble(-1L)) {
            return -1L;
        }
        if (d10 < 9.223372036854776E18d) {
            return ULong.m٧١٨constructorimpl((long) d10);
        }
        return ULong.m٧١٨constructorimpl(ULong.m٧١٨constructorimpl((long) (d10 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    @InlineOnly
    private static final int floatToUInt(float f10) {
        return doubleToUInt(f10);
    }

    @PublishedApi
    @InlineOnly
    private static final long floatToULong(float f10) {
        return doubleToULong(f10);
    }

    @PublishedApi
    public static final int uintCompare(int i10, int i11) {
        return Intrinsics.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m٨٩٥uintDivideJ1ME1BU(int i10, int i11) {
        return UInt.m٦٣٩constructorimpl((int) ((i10 & 4294967295L) / (i11 & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m٨٩٦uintRemainderJ1ME1BU(int i10, int i11) {
        return UInt.m٦٣٩constructorimpl((int) ((i10 & 4294967295L) % (i11 & 4294967295L)));
    }

    @PublishedApi
    public static final double uintToDouble(int i10) {
        return (Integer.MAX_VALUE & i10) + (((i10 >>> 31) << 30) * 2);
    }

    @PublishedApi
    @InlineOnly
    private static final float uintToFloat(int i10) {
        return (float) uintToDouble(i10);
    }

    @PublishedApi
    @InlineOnly
    private static final long uintToLong(int i10) {
        return i10 & 4294967295L;
    }

    @InlineOnly
    private static final String uintToString(int i10) {
        return String.valueOf(i10 & 4294967295L);
    }

    @PublishedApi
    @InlineOnly
    private static final long uintToULong(int i10) {
        return ULong.m٧١٨constructorimpl(i10 & 4294967295L);
    }

    @PublishedApi
    public static final int ulongCompare(long j10, long j11) {
        return Intrinsics.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m٨٩٧ulongDivideeb3DHEI(long j10, long j11) {
        int compare;
        int compare2;
        if (j11 < 0) {
            compare2 = Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return ULong.m٧١٨constructorimpl(0L);
            }
            return ULong.m٧١٨constructorimpl(1L);
        }
        if (j10 >= 0) {
            return ULong.m٧١٨constructorimpl(j10 / j11);
        }
        int i10 = 1;
        long j12 = ((j10 >>> 1) / j11) << 1;
        compare = Long.compare(ULong.m٧١٨constructorimpl(j10 - (j12 * j11)) ^ Long.MIN_VALUE, ULong.m٧١٨constructorimpl(j11) ^ Long.MIN_VALUE);
        if (compare < 0) {
            i10 = 0;
        }
        return ULong.m٧١٨constructorimpl(j12 + i10);
    }

    @PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m٨٩٨ulongRemaindereb3DHEI(long j10, long j11) {
        int compare;
        int compare2;
        if (j11 < 0) {
            compare2 = Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
            if (compare2 >= 0) {
                return ULong.m٧١٨constructorimpl(j10 - j11);
            }
            return j10;
        }
        if (j10 >= 0) {
            return ULong.m٧١٨constructorimpl(j10 % j11);
        }
        long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
        compare = Long.compare(ULong.m٧١٨constructorimpl(j12) ^ Long.MIN_VALUE, ULong.m٧١٨constructorimpl(j11) ^ Long.MIN_VALUE);
        if (compare < 0) {
            j11 = 0;
        }
        return ULong.m٧١٨constructorimpl(j12 - j11);
    }

    @PublishedApi
    public static final double ulongToDouble(long j10) {
        return ((j10 >>> 11) * 2048) + (j10 & 2047);
    }

    @PublishedApi
    @InlineOnly
    private static final float ulongToFloat(long j10) {
        return (float) ulongToDouble(j10);
    }

    @InlineOnly
    private static final String ulongToString(long j10) {
        return ulongToString(j10, 10);
    }

    @InlineOnly
    private static final String uintToString(int i10, int i11) {
        return ulongToString(i10 & 4294967295L, i11);
    }

    @NotNull
    public static final String ulongToString(long j10, int i10) {
        if (j10 >= 0) {
            String l10 = Long.toString(j10, CharsKt.checkRadix(i10));
            Intrinsics.checkNotNullExpressionValue(l10, "toString(...)");
            return l10;
        }
        long j11 = i10;
        long j12 = ((j10 >>> 1) / j11) << 1;
        long j13 = j10 - (j12 * j11);
        if (j13 >= j11) {
            j13 -= j11;
            j12++;
        }
        StringBuilder sb = new StringBuilder();
        String l11 = Long.toString(j12, CharsKt.checkRadix(i10));
        Intrinsics.checkNotNullExpressionValue(l11, "toString(...)");
        sb.append(l11);
        String l12 = Long.toString(j13, CharsKt.checkRadix(i10));
        Intrinsics.checkNotNullExpressionValue(l12, "toString(...)");
        sb.append(l12);
        return sb.toString();
    }
}
