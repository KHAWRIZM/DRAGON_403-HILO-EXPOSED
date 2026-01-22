package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a(\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a\u001f\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b'\u0010\b\u001a\u001f\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b(\u0010\u000b\u001a\u001f\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b)\u0010\u000e\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a(\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b+\u0010\u0013\u001a(\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b,\u0010\u0015\u001a(\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b-\u0010\u0017\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b.\u0010\u001b\u001a#\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b/\u0010\u001e\u001a#\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lkotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lkotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "c", "maxOf-WZ9TVnA", "(III)I", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", "other", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-J1ME1BU", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = "1.5")
    /* renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m١٧٢٤maxOf5PvTz6A(short s10, short s11) {
        if (Intrinsics.compare(s10 & UShort.MAX_VALUE, 65535 & s11) < 0) {
            return s11;
        }
        return s10;
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static int m١٧٢٥maxOfJ1ME1BU(int i10, int i11) {
        int compare;
        compare = Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
        if (compare < 0) {
            return i11;
        }
        return i10;
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m١٧٢٦maxOfKr8caGY(byte b10, byte b11) {
        if (Intrinsics.compare(b10 & UByte.MAX_VALUE, b11 & UByte.MAX_VALUE) < 0) {
            return b11;
        }
        return b10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m١٧٢٧maxOfMd2H83M(int i10, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i11 = UIntArray.m٧٠٠getSizeimpl(other);
        for (int i12 = 0; i12 < i11; i12++) {
            i10 = UComparisonsKt.m١٧٢٥maxOfJ1ME1BU(i10, UIntArray.m٦٩٩getpVg5ArA(other, i12));
        }
        return i10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m١٧٢٨maxOfR03FKyM(long j10, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i10 = ULongArray.m٧٧٩getSizeimpl(other);
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = UComparisonsKt.m١٧٣٣maxOfeb3DHEI(j10, ULongArray.m٧٧٨getsVKNKU(other, i11));
        }
        return j10;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m١٧٢٩maxOfVKSA0NQ(short s10, short s11, short s12) {
        return m١٧٢٤maxOf5PvTz6A(s10, m١٧٢٤maxOf5PvTz6A(s11, s12));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m١٧٣٠maxOfWZ9TVnA(int i10, int i11, int i12) {
        return UComparisonsKt.m١٧٢٥maxOfJ1ME1BU(i10, UComparisonsKt.m١٧٢٥maxOfJ1ME1BU(i11, i12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m١٧٣١maxOfWr6uiD8(byte b10, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i10 = UByteArray.m٦٢١getSizeimpl(other);
        for (int i11 = 0; i11 < i10; i11++) {
            b10 = m١٧٢٦maxOfKr8caGY(b10, UByteArray.m٦٢٠getw2LRezQ(other, i11));
        }
        return b10;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m١٧٣٢maxOfb33U2AM(byte b10, byte b11, byte b12) {
        return m١٧٢٦maxOfKr8caGY(b10, m١٧٢٦maxOfKr8caGY(b11, b12));
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static long m١٧٣٣maxOfeb3DHEI(long j10, long j11) {
        int compare;
        compare = Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
        if (compare < 0) {
            return j11;
        }
        return j10;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m١٧٣٤maxOfsambcqE(long j10, long j11, long j12) {
        return UComparisonsKt.m١٧٣٣maxOfeb3DHEI(j10, UComparisonsKt.m١٧٣٣maxOfeb3DHEI(j11, j12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m١٧٣٥maxOft1qELG4(short s10, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i10 = UShortArray.m٨٨٤getSizeimpl(other);
        for (int i11 = 0; i11 < i10; i11++) {
            s10 = m١٧٢٤maxOf5PvTz6A(s10, UShortArray.m٨٨٣getMh2AYeg(other, i11));
        }
        return s10;
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m١٧٣٦minOf5PvTz6A(short s10, short s11) {
        if (Intrinsics.compare(s10 & UShort.MAX_VALUE, 65535 & s11) > 0) {
            return s11;
        }
        return s10;
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static int m١٧٣٧minOfJ1ME1BU(int i10, int i11) {
        int compare;
        compare = Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return i11;
        }
        return i10;
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m١٧٣٨minOfKr8caGY(byte b10, byte b11) {
        if (Intrinsics.compare(b10 & UByte.MAX_VALUE, b11 & UByte.MAX_VALUE) > 0) {
            return b11;
        }
        return b10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m١٧٣٩minOfMd2H83M(int i10, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i11 = UIntArray.m٧٠٠getSizeimpl(other);
        for (int i12 = 0; i12 < i11; i12++) {
            i10 = UComparisonsKt.m١٧٣٧minOfJ1ME1BU(i10, UIntArray.m٦٩٩getpVg5ArA(other, i12));
        }
        return i10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m١٧٤٠minOfR03FKyM(long j10, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i10 = ULongArray.m٧٧٩getSizeimpl(other);
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = UComparisonsKt.m١٧٤٥minOfeb3DHEI(j10, ULongArray.m٧٧٨getsVKNKU(other, i11));
        }
        return j10;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m١٧٤١minOfVKSA0NQ(short s10, short s11, short s12) {
        return m١٧٣٦minOf5PvTz6A(s10, m١٧٣٦minOf5PvTz6A(s11, s12));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m١٧٤٢minOfWZ9TVnA(int i10, int i11, int i12) {
        return UComparisonsKt.m١٧٣٧minOfJ1ME1BU(i10, UComparisonsKt.m١٧٣٧minOfJ1ME1BU(i11, i12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m١٧٤٣minOfWr6uiD8(byte b10, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i10 = UByteArray.m٦٢١getSizeimpl(other);
        for (int i11 = 0; i11 < i10; i11++) {
            b10 = m١٧٣٨minOfKr8caGY(b10, UByteArray.m٦٢٠getw2LRezQ(other, i11));
        }
        return b10;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m١٧٤٤minOfb33U2AM(byte b10, byte b11, byte b12) {
        return m١٧٣٨minOfKr8caGY(b10, m١٧٣٨minOfKr8caGY(b11, b12));
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static long m١٧٤٥minOfeb3DHEI(long j10, long j11) {
        int compare;
        compare = Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
        if (compare > 0) {
            return j11;
        }
        return j10;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m١٧٤٦minOfsambcqE(long j10, long j11, long j12) {
        return UComparisonsKt.m١٧٤٥minOfeb3DHEI(j10, UComparisonsKt.m١٧٤٥minOfeb3DHEI(j11, j12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m١٧٤٧minOft1qELG4(short s10, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i10 = UShortArray.m٨٨٤getSizeimpl(other);
        for (int i11 = 0; i11 < i10; i11++) {
            s10 = m١٧٣٦minOf5PvTz6A(s10, UShortArray.m٨٨٣getMh2AYeg(other, i11));
        }
        return s10;
    }
}
