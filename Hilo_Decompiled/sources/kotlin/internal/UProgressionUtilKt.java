package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.b;
import kotlin.c;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m١٧٤٩differenceModuloWZ9TVnA(int i10, int i11, int i12) {
        int compare;
        int a10 = b.a(i10, i12);
        int a11 = b.a(i11, i12);
        compare = Integer.compare(a10 ^ Integer.MIN_VALUE, a11 ^ Integer.MIN_VALUE);
        int i13 = UInt.m٦٣٩constructorimpl(a10 - a11);
        if (compare < 0) {
            return UInt.m٦٣٩constructorimpl(i13 + i12);
        }
        return i13;
    }

    /* renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m١٧٥٠differenceModulosambcqE(long j10, long j11, long j12) {
        int compare;
        long a10 = c.a(j10, j12);
        long a11 = c.a(j11, j12);
        compare = Long.compare(a10 ^ Long.MIN_VALUE, a11 ^ Long.MIN_VALUE);
        long j13 = ULong.m٧١٨constructorimpl(a10 - a11);
        if (compare < 0) {
            return ULong.m٧١٨constructorimpl(j13 + j12);
        }
        return j13;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m١٧٥١getProgressionLastElement7ftBX0g(long j10, long j11, long j12) {
        int compare;
        int compare2;
        if (j12 > 0) {
            compare2 = Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return ULong.m٧١٨constructorimpl(j11 - m١٧٥٠differenceModulosambcqE(j11, j10, ULong.m٧١٨constructorimpl(j12)));
            }
            return j11;
        }
        if (j12 < 0) {
            compare = Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
            if (compare > 0) {
                return ULong.m٧١٨constructorimpl(j11 + m١٧٥٠differenceModulosambcqE(j10, j11, ULong.m٧١٨constructorimpl(-j12)));
            }
            return j11;
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m١٧٥٢getProgressionLastElementNkh28Cs(int i10, int i11, int i12) {
        int compare;
        int compare2;
        if (i12 > 0) {
            compare2 = Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return UInt.m٦٣٩constructorimpl(i11 - m١٧٤٩differenceModuloWZ9TVnA(i11, i10, UInt.m٦٣٩constructorimpl(i12)));
            }
            return i11;
        }
        if (i12 < 0) {
            compare = Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return UInt.m٦٣٩constructorimpl(i11 + m١٧٤٩differenceModuloWZ9TVnA(i10, i11, UInt.m٦٣٩constructorimpl(-i12)));
            }
            return i11;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
