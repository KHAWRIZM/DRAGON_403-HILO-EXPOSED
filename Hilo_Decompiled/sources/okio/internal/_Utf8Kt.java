package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\n-Utf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n+ 2 Utf8.kt\nokio/Utf8\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,60:1\n260#2,16:61\n277#2:78\n397#2,9:79\n127#2:88\n406#2,20:90\n279#2,3:110\n440#2,4:113\n127#2:117\n446#2,10:118\n127#2:128\n456#2,5:129\n127#2:134\n461#2,24:135\n283#2,3:159\n500#2,3:162\n286#2,12:165\n503#2:177\n127#2:178\n506#2,2:179\n127#2:181\n510#2,10:182\n127#2:192\n520#2,5:193\n127#2:198\n525#2,5:199\n127#2:204\n530#2,28:205\n302#2,6:233\n138#2,67:239\n68#3:77\n74#3:89\n*S KotlinDebug\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n*L\n34#1:61,16\n34#1:78\n34#1:79,9\n34#1:88\n34#1:90,20\n34#1:110,3\n34#1:113,4\n34#1:117\n34#1:118,10\n34#1:128\n34#1:129,5\n34#1:134\n34#1:135,24\n34#1:159,3\n34#1:162,3\n34#1:165,12\n34#1:177\n34#1:178\n34#1:179,2\n34#1:181\n34#1:182,10\n34#1:192\n34#1:193,5\n34#1:198\n34#1:199,5\n34#1:204\n34#1:205,28\n34#1:233,6\n50#1:239,67\n34#1:77\n34#1:89\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String str) {
        int i10;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            char charAt2 = str.charAt(i11);
            if (Intrinsics.compare((int) charAt2, 128) >= 0) {
                int length2 = str.length();
                int i12 = i11;
                while (i11 < length2) {
                    char charAt3 = str.charAt(i11);
                    if (Intrinsics.compare((int) charAt3, 128) < 0) {
                        int i13 = i12 + 1;
                        bArr[i12] = (byte) charAt3;
                        i11++;
                        while (true) {
                            i12 = i13;
                            if (i11 < length2 && Intrinsics.compare((int) str.charAt(i11), 128) < 0) {
                                i13 = i12 + 1;
                                bArr[i12] = (byte) str.charAt(i11);
                                i11++;
                            }
                        }
                    } else {
                        if (Intrinsics.compare((int) charAt3, 2048) < 0) {
                            bArr[i12] = (byte) ((charAt3 >> 6) | 192);
                            i12 += 2;
                            bArr[i12 + 1] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 <= charAt3 && charAt3 < 57344) {
                            if (Intrinsics.compare((int) charAt3, 56319) <= 0 && length2 > (i10 = i11 + 1) && 56320 <= (charAt = str.charAt(i10)) && charAt < 57344) {
                                int charAt4 = ((charAt3 << '\n') + str.charAt(i10)) - 56613888;
                                bArr[i12] = (byte) ((charAt4 >> 18) | 240);
                                bArr[i12 + 1] = (byte) (((charAt4 >> 12) & 63) | 128);
                                bArr[i12 + 2] = (byte) (((charAt4 >> 6) & 63) | 128);
                                i12 += 4;
                                bArr[i12 + 3] = (byte) ((charAt4 & 63) | 128);
                                i11 += 2;
                            } else {
                                bArr[i12] = Utf8.REPLACEMENT_BYTE;
                                i11++;
                                i12++;
                            }
                        } else {
                            bArr[i12] = (byte) ((charAt3 >> '\f') | 224);
                            bArr[i12 + 1] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i12 += 3;
                            bArr[i12 + 2] = (byte) ((charAt3 & '?') | 128);
                        }
                        i11++;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i12);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i11] = (byte) charAt2;
            i11++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        return copyOf2;
    }

    @NotNull
    public static final String commonToUtf8String(@NotNull byte[] bArr, int i10, int i11) {
        byte b10;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19 = i10;
        int i20 = 3;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i19 >= 0 && i11 <= bArr.length && i19 <= i11) {
            char[] cArr = new char[i11 - i19];
            int i21 = 0;
            while (i19 < i11) {
                byte b11 = bArr[i19];
                if (b11 >= 0) {
                    int i22 = i21 + 1;
                    cArr[i21] = (char) b11;
                    i19++;
                    while (true) {
                        i21 = i22;
                        if (i19 < i11 && (b10 = bArr[i19]) >= 0) {
                            i19++;
                            i22 = i21 + 1;
                            cArr[i21] = (char) b10;
                        }
                    }
                } else if ((b11 >> 5) == -2) {
                    int i23 = i19 + 1;
                    if (i11 <= i23) {
                        i12 = i21 + 1;
                        cArr[i21] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    } else {
                        byte b12 = bArr[i23];
                        if ((b12 & 192) == 128) {
                            int i24 = (b11 << 6) ^ (b12 ^ ByteCompanionObject.MIN_VALUE);
                            if (i24 < 128) {
                                i13 = i21 + 1;
                                cArr[i21] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else {
                                i13 = i21 + 1;
                                cArr[i21] = (char) i24;
                            }
                            Unit unit = Unit.INSTANCE;
                            i21 = i13;
                            i14 = 2;
                            i19 += i14;
                        } else {
                            i12 = i21 + 1;
                            cArr[i21] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    i21 = i12;
                    i14 = 1;
                    i19 += i14;
                } else if ((b11 >> 4) == -2) {
                    int i25 = i19 + 2;
                    if (i11 <= i25) {
                        int i26 = i21 + 1;
                        cArr[i21] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        Unit unit3 = Unit.INSTANCE;
                        int i27 = i19 + 1;
                        if (i11 > i27 && (bArr[i27] & 192) == 128) {
                            i21 = i26;
                            i16 = 2;
                        } else {
                            i21 = i26;
                            i16 = 1;
                        }
                    } else {
                        byte b13 = bArr[i19 + 1];
                        if ((b13 & 192) == 128) {
                            byte b14 = bArr[i25];
                            if ((b14 & 192) == 128) {
                                int i28 = ((b14 ^ ByteCompanionObject.MIN_VALUE) ^ (b13 << 6)) ^ (b11 << 12);
                                if (i28 < 2048) {
                                    i15 = i21 + 1;
                                    cArr[i21] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                } else if (55296 <= i28 && i28 < 57344) {
                                    i15 = i21 + 1;
                                    cArr[i21] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                } else {
                                    char c10 = (char) i28;
                                    i15 = i21 + 1;
                                    cArr[i21] = c10;
                                }
                                Unit unit4 = Unit.INSTANCE;
                                i21 = i15;
                                i16 = 3;
                            } else {
                                cArr[i21] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                Unit unit5 = Unit.INSTANCE;
                                i21++;
                                i16 = 2;
                            }
                        } else {
                            cArr[i21] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            Unit unit6 = Unit.INSTANCE;
                            i21++;
                            i16 = 1;
                        }
                    }
                    i19 += i16;
                } else {
                    if ((b11 >> 3) == -2) {
                        int i29 = i19 + 3;
                        if (i11 <= i29) {
                            i17 = i21 + 1;
                            cArr[i21] = Utf8.REPLACEMENT_CHARACTER;
                            Unit unit7 = Unit.INSTANCE;
                            int i30 = i19 + 1;
                            if (i11 > i30 && (bArr[i30] & 192) == 128) {
                                int i31 = i19 + 2;
                                if (i11 > i31 && (bArr[i31] & 192) == 128) {
                                    i21 = i17;
                                    i19 += i20;
                                }
                                i21 = i17;
                                i20 = 2;
                                i19 += i20;
                            }
                            i21 = i17;
                            i20 = 1;
                            i19 += i20;
                        } else {
                            byte b15 = bArr[i19 + 1];
                            if ((b15 & 192) == 128) {
                                byte b16 = bArr[i19 + 2];
                                if ((b16 & 192) == 128) {
                                    byte b17 = bArr[i29];
                                    if ((b17 & 192) == 128) {
                                        int i32 = (((b17 ^ ByteCompanionObject.MIN_VALUE) ^ (b16 << 6)) ^ (b15 << 12)) ^ (b11 << 18);
                                        if (i32 > 1114111) {
                                            i18 = i21 + 1;
                                            cArr[i21] = Utf8.REPLACEMENT_CHARACTER;
                                        } else if (55296 <= i32 && i32 < 57344) {
                                            i18 = i21 + 1;
                                            cArr[i21] = Utf8.REPLACEMENT_CHARACTER;
                                        } else if (i32 < 65536) {
                                            i18 = i21 + 1;
                                            cArr[i21] = Utf8.REPLACEMENT_CHARACTER;
                                        } else if (i32 != 65533) {
                                            cArr[i21] = (char) ((i32 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                            cArr[i21 + 1] = (char) ((i32 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                            i18 = i21 + 2;
                                        } else {
                                            i18 = i21 + 1;
                                            cArr[i21] = Utf8.REPLACEMENT_CHARACTER;
                                        }
                                        Unit unit8 = Unit.INSTANCE;
                                        i21 = i18;
                                        i20 = 4;
                                    } else {
                                        cArr[i21] = Utf8.REPLACEMENT_CHARACTER;
                                        Unit unit9 = Unit.INSTANCE;
                                        i21++;
                                        i20 = 3;
                                    }
                                    i19 += i20;
                                } else {
                                    i17 = i21 + 1;
                                    cArr[i21] = Utf8.REPLACEMENT_CHARACTER;
                                    Unit unit10 = Unit.INSTANCE;
                                    i21 = i17;
                                    i20 = 2;
                                    i19 += i20;
                                }
                            } else {
                                i17 = i21 + 1;
                                cArr[i21] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit11 = Unit.INSTANCE;
                                i21 = i17;
                                i20 = 1;
                                i19 += i20;
                            }
                        }
                    } else {
                        cArr[i21] = Utf8.REPLACEMENT_CHARACTER;
                        i19++;
                        i21++;
                    }
                    i20 = 3;
                }
            }
            return StringsKt.concatToString(cArr, 0, i21);
        }
        throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i19 + " endIndex=" + i11);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        return commonToUtf8String(bArr, i10, i11);
    }
}
