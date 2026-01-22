package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0080\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "Utf8")
@SourceDebugExtension({"SMAP\nUtf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utf8.kt\nokio/Utf8\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,559:1\n397#1,9:563\n127#1:572\n406#1,20:574\n440#1,4:595\n127#1:599\n446#1,10:601\n127#1:611\n456#1,5:612\n127#1:617\n461#1,24:618\n500#1,4:643\n127#1:647\n506#1,2:649\n127#1:651\n510#1,10:652\n127#1:662\n520#1,5:663\n127#1:668\n525#1,5:669\n127#1:674\n530#1,28:675\n397#1,9:704\n127#1:713\n406#1,20:715\n440#1,4:736\n127#1:740\n446#1,10:742\n127#1:752\n456#1,5:753\n127#1:758\n461#1,24:759\n500#1,4:784\n127#1:788\n506#1,2:790\n127#1:792\n510#1,10:793\n127#1:803\n520#1,5:804\n127#1:809\n525#1,5:810\n127#1:815\n530#1,28:816\n127#1:844\n127#1:846\n127#1:848\n127#1:850\n127#1:852\n127#1:854\n127#1:856\n127#1:858\n127#1:860\n1#2:560\n74#3:561\n68#3:562\n74#3:573\n68#3:594\n74#3:600\n68#3:642\n74#3:648\n68#3:703\n74#3:714\n68#3:735\n74#3:741\n68#3:783\n74#3:789\n74#3:845\n74#3:847\n74#3:849\n74#3:851\n74#3:853\n74#3:855\n74#3:857\n74#3:859\n74#3:861\n*S KotlinDebug\n*F\n+ 1 Utf8.kt\nokio/Utf8\n*L\n228#1:563,9\n228#1:572\n228#1:574,20\n232#1:595,4\n232#1:599\n232#1:601,10\n232#1:611\n232#1:612,5\n232#1:617\n232#1:618,24\n236#1:643,4\n236#1:647\n236#1:649,2\n236#1:651\n236#1:652,10\n236#1:662\n236#1:663,5\n236#1:668\n236#1:669,5\n236#1:674\n236#1:675,28\n277#1:704,9\n277#1:713\n277#1:715,20\n281#1:736,4\n281#1:740\n281#1:742,10\n281#1:752\n281#1:753,5\n281#1:758\n281#1:759,24\n285#1:784,4\n285#1:788\n285#1:790,2\n285#1:792\n285#1:793,10\n285#1:803\n285#1:804,5\n285#1:809\n285#1:810,5\n285#1:815\n285#1:816,28\n405#1:844\n443#1:846\n455#1:848\n460#1:850\n503#1:852\n507#1:854\n519#1:856\n524#1:858\n529#1:860\n127#1:561\n226#1:562\n228#1:573\n230#1:594\n232#1:600\n234#1:642\n236#1:648\n275#1:703\n277#1:714\n279#1:735\n281#1:741\n283#1:783\n285#1:789\n405#1:845\n443#1:847\n455#1:849\n460#1:851\n503#1:853\n507#1:855\n519#1:857\n524#1:859\n529#1:861\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i10) {
        return (i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160);
    }

    public static final boolean isUtf8Continuation(byte b10) {
        return (b10 & 192) == 128;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] bArr, int i10, int i11, @NotNull Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i12 = i10 + 1;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i11 <= i12) {
            yield.invoke(valueOf);
            return 1;
        }
        byte b10 = bArr[i10];
        byte b11 = bArr[i12];
        if ((b11 & 192) == 128) {
            int i13 = (b11 ^ ByteCompanionObject.MIN_VALUE) ^ (b10 << 6);
            if (i13 < 128) {
                yield.invoke(valueOf);
                return 2;
            }
            yield.invoke(Integer.valueOf(i13));
            return 2;
        }
        yield.invoke(valueOf);
        return 1;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] bArr, int i10, int i11, @NotNull Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i12 = i10 + 2;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i11 <= i12) {
            yield.invoke(valueOf);
            int i13 = i10 + 1;
            if (i11 <= i13 || (bArr[i13] & 192) != 128) {
                return 1;
            }
            return 2;
        }
        byte b10 = bArr[i10];
        byte b11 = bArr[i10 + 1];
        if ((b11 & 192) == 128) {
            byte b12 = bArr[i12];
            if ((b12 & 192) == 128) {
                int i14 = ((b12 ^ ByteCompanionObject.MIN_VALUE) ^ (b11 << 6)) ^ (b10 << 12);
                if (i14 < 2048) {
                    yield.invoke(valueOf);
                    return 3;
                }
                if (55296 <= i14 && i14 < 57344) {
                    yield.invoke(valueOf);
                    return 3;
                }
                yield.invoke(Integer.valueOf(i14));
                return 3;
            }
            yield.invoke(valueOf);
            return 2;
        }
        yield.invoke(valueOf);
        return 1;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] bArr, int i10, int i11, @NotNull Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i12 = i10 + 3;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i11 <= i12) {
            yield.invoke(valueOf);
            int i13 = i10 + 1;
            if (i11 <= i13 || (bArr[i13] & 192) != 128) {
                return 1;
            }
            int i14 = i10 + 2;
            if (i11 <= i14 || (bArr[i14] & 192) != 128) {
                return 2;
            }
            return 3;
        }
        byte b10 = bArr[i10];
        byte b11 = bArr[i10 + 1];
        if ((b11 & 192) == 128) {
            byte b12 = bArr[i10 + 2];
            if ((b12 & 192) == 128) {
                byte b13 = bArr[i12];
                if ((b13 & 192) == 128) {
                    int i15 = (((b13 ^ ByteCompanionObject.MIN_VALUE) ^ (b12 << 6)) ^ (b11 << 12)) ^ (b10 << 18);
                    if (i15 > 1114111) {
                        yield.invoke(valueOf);
                        return 4;
                    }
                    if (55296 <= i15 && i15 < 57344) {
                        yield.invoke(valueOf);
                        return 4;
                    }
                    if (i15 < 65536) {
                        yield.invoke(valueOf);
                        return 4;
                    }
                    yield.invoke(Integer.valueOf(i15));
                    return 4;
                }
                yield.invoke(valueOf);
                return 3;
            }
            yield.invoke(valueOf);
            return 2;
        }
        yield.invoke(valueOf);
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00fa, code lost:
    
        if ((r16[r8] & 192) == 128) goto L٦٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008d, code lost:
    
        if ((r16[r8] & 192) == 128) goto L٢٤;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void processUtf16Chars(@NotNull byte[] bArr, int i10, int i11, @NotNull Function1<? super Character, Unit> yield) {
        char c10;
        int i12;
        char c11;
        int i13;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i14 = i10;
        while (i14 < i11) {
            byte b10 = bArr[i14];
            if (b10 >= 0) {
                yield.invoke(Character.valueOf((char) b10));
                i14++;
                while (i14 < i11) {
                    byte b11 = bArr[i14];
                    if (b11 >= 0) {
                        i14++;
                        yield.invoke(Character.valueOf((char) b11));
                    }
                }
            } else {
                if ((b10 >> 5) == -2) {
                    int i15 = i14 + 1;
                    if (i11 > i15) {
                        byte b12 = bArr[i15];
                        if ((b12 & 192) == 128) {
                            int i16 = (b10 << 6) ^ (b12 ^ ByteCompanionObject.MIN_VALUE);
                            if (i16 < 128) {
                                c10 = (char) REPLACEMENT_CODE_POINT;
                            } else {
                                c10 = (char) i16;
                            }
                            yield.invoke(Character.valueOf(c10));
                            Unit unit = Unit.INSTANCE;
                            i12 = 2;
                        }
                    }
                    yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                    Unit unit2 = Unit.INSTANCE;
                    i12 = 1;
                } else if ((b10 >> 4) == -2) {
                    int i17 = i14 + 2;
                    if (i11 <= i17) {
                        yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        Unit unit3 = Unit.INSTANCE;
                        int i18 = i14 + 1;
                        if (i11 > i18) {
                        }
                        i12 = 1;
                    } else {
                        byte b13 = bArr[i14 + 1];
                        if ((b13 & 192) == 128) {
                            byte b14 = bArr[i17];
                            if ((b14 & 192) == 128) {
                                int i19 = (b10 << 12) ^ ((b14 ^ ByteCompanionObject.MIN_VALUE) ^ (b13 << 6));
                                if (i19 < 2048 || (55296 <= i19 && i19 < 57344)) {
                                    c11 = (char) REPLACEMENT_CODE_POINT;
                                } else {
                                    c11 = (char) i19;
                                }
                                yield.invoke(Character.valueOf(c11));
                                Unit unit4 = Unit.INSTANCE;
                                i12 = 3;
                            } else {
                                yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                Unit unit5 = Unit.INSTANCE;
                                i12 = 2;
                            }
                        } else {
                            yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            Unit unit6 = Unit.INSTANCE;
                            i12 = 1;
                        }
                    }
                } else if ((b10 >> 3) == -2) {
                    int i20 = i14 + 3;
                    if (i11 <= i20) {
                        yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                        Unit unit7 = Unit.INSTANCE;
                        int i21 = i14 + 1;
                        if (i11 > i21 && (bArr[i21] & 192) == 128) {
                            int i22 = i14 + 2;
                            if (i11 > i22) {
                            }
                            i13 = 2;
                        }
                        i13 = 1;
                    } else {
                        byte b15 = bArr[i14 + 1];
                        if ((b15 & 192) == 128) {
                            byte b16 = bArr[i14 + 2];
                            if ((b16 & 192) == 128) {
                                byte b17 = bArr[i20];
                                if ((b17 & 192) == 128) {
                                    int i23 = (((b17 ^ ByteCompanionObject.MIN_VALUE) ^ (b16 << 6)) ^ (b15 << 12)) ^ (b10 << 18);
                                    if (i23 > 1114111 || ((55296 <= i23 && i23 < 57344) || i23 < 65536 || i23 == 65533)) {
                                        yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    } else {
                                        yield.invoke(Character.valueOf((char) ((i23 >>> 10) + HIGH_SURROGATE_HEADER)));
                                        yield.invoke(Character.valueOf((char) ((i23 & 1023) + LOG_SURROGATE_HEADER)));
                                    }
                                    Unit unit8 = Unit.INSTANCE;
                                    i13 = 4;
                                } else {
                                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    Unit unit9 = Unit.INSTANCE;
                                    i13 = 3;
                                }
                            } else {
                                yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                Unit unit10 = Unit.INSTANCE;
                                i13 = 2;
                            }
                        } else {
                            yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            Unit unit11 = Unit.INSTANCE;
                            i13 = 1;
                        }
                    }
                    i14 += i13;
                } else {
                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                    i14++;
                }
                i14 += i12;
            }
        }
    }

    public static final void processUtf8Bytes(@NotNull String str, int i10, int i11, @NotNull Function1<? super Byte, Unit> yield) {
        int i12;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i10 < i11) {
            char charAt2 = str.charAt(i10);
            if (Intrinsics.compare((int) charAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) charAt2));
                i10++;
                while (i10 < i11 && Intrinsics.compare((int) str.charAt(i10), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) str.charAt(i10)));
                    i10++;
                }
            } else {
                if (Intrinsics.compare((int) charAt2, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> 6) | 192)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (55296 <= charAt2 && charAt2 < 57344) {
                    if (Intrinsics.compare((int) charAt2, 56319) <= 0 && i11 > (i12 = i10 + 1) && 56320 <= (charAt = str.charAt(i12)) && charAt < 57344) {
                        int charAt3 = ((charAt2 << '\n') + str.charAt(i12)) - 56613888;
                        yield.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                        yield.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                        i10 += 2;
                    } else {
                        yield.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                    }
                } else {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> '\f') | 224)));
                    yield.invoke(Byte.valueOf((byte) (((charAt2 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                }
                i10++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f8, code lost:
    
        if ((r16[r8] & 192) == 128) goto L٦٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x008b, code lost:
    
        if ((r16[r8] & 192) == 128) goto L٢٤;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void processUtf8CodePoints(@NotNull byte[] bArr, int i10, int i11, @NotNull Function1<? super Integer, Unit> yield) {
        Integer valueOf;
        int i12;
        Integer valueOf2;
        Integer valueOf3;
        int i13;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i14 = i10;
        while (i14 < i11) {
            byte b10 = bArr[i14];
            if (b10 >= 0) {
                yield.invoke(Integer.valueOf(b10));
                i14++;
                while (i14 < i11) {
                    byte b11 = bArr[i14];
                    if (b11 >= 0) {
                        i14++;
                        yield.invoke(Integer.valueOf(b11));
                    }
                }
            } else {
                if ((b10 >> 5) == -2) {
                    int i15 = i14 + 1;
                    if (i11 > i15) {
                        byte b12 = bArr[i15];
                        if ((b12 & 192) == 128) {
                            int i16 = (b10 << 6) ^ (b12 ^ ByteCompanionObject.MIN_VALUE);
                            if (i16 < 128) {
                                valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
                            } else {
                                valueOf = Integer.valueOf(i16);
                            }
                            yield.invoke(valueOf);
                            Unit unit = Unit.INSTANCE;
                            i12 = 2;
                        }
                    }
                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    Unit unit2 = Unit.INSTANCE;
                    i12 = 1;
                } else if ((b10 >> 4) == -2) {
                    int i17 = i14 + 2;
                    if (i11 <= i17) {
                        yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        Unit unit3 = Unit.INSTANCE;
                        int i18 = i14 + 1;
                        if (i11 > i18) {
                        }
                        i12 = 1;
                    } else {
                        byte b13 = bArr[i14 + 1];
                        if ((b13 & 192) == 128) {
                            byte b14 = bArr[i17];
                            if ((b14 & 192) == 128) {
                                int i19 = (b10 << 12) ^ ((b14 ^ ByteCompanionObject.MIN_VALUE) ^ (b13 << 6));
                                if (i19 < 2048 || (55296 <= i19 && i19 < 57344)) {
                                    valueOf2 = Integer.valueOf(REPLACEMENT_CODE_POINT);
                                } else {
                                    valueOf2 = Integer.valueOf(i19);
                                }
                                yield.invoke(valueOf2);
                                Unit unit4 = Unit.INSTANCE;
                                i12 = 3;
                            } else {
                                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                Unit unit5 = Unit.INSTANCE;
                                i12 = 2;
                            }
                        } else {
                            yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            Unit unit6 = Unit.INSTANCE;
                            i12 = 1;
                        }
                    }
                } else if ((b10 >> 3) == -2) {
                    int i20 = i14 + 3;
                    if (i11 <= i20) {
                        yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        Unit unit7 = Unit.INSTANCE;
                        int i21 = i14 + 1;
                        if (i11 > i21 && (bArr[i21] & 192) == 128) {
                            int i22 = i14 + 2;
                            if (i11 > i22) {
                            }
                            i13 = 2;
                        }
                        i13 = 1;
                    } else {
                        byte b15 = bArr[i14 + 1];
                        if ((b15 & 192) == 128) {
                            byte b16 = bArr[i14 + 2];
                            if ((b16 & 192) == 128) {
                                byte b17 = bArr[i20];
                                if ((b17 & 192) == 128) {
                                    int i23 = (((b17 ^ ByteCompanionObject.MIN_VALUE) ^ (b16 << 6)) ^ (b15 << 12)) ^ (b10 << 18);
                                    if (i23 > 1114111 || ((55296 <= i23 && i23 < 57344) || i23 < 65536)) {
                                        valueOf3 = Integer.valueOf(REPLACEMENT_CODE_POINT);
                                    } else {
                                        valueOf3 = Integer.valueOf(i23);
                                    }
                                    yield.invoke(valueOf3);
                                    Unit unit8 = Unit.INSTANCE;
                                    i13 = 4;
                                } else {
                                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    Unit unit9 = Unit.INSTANCE;
                                    i13 = 3;
                                }
                            } else {
                                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                Unit unit10 = Unit.INSTANCE;
                                i13 = 2;
                            }
                        } else {
                            yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            Unit unit11 = Unit.INSTANCE;
                            i13 = 1;
                        }
                    }
                    i14 += i13;
                } else {
                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i14++;
                }
                i14 += i12;
            }
        }
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, 0, 0, 3, null);
    }

    public static /* synthetic */ long size$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return size(str, i10, i11);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i10) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, i10, 0, 2, null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i10, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (i11 >= i10) {
            if (i11 > str.length()) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + str.length()).toString());
            }
            long j10 = 0;
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if (charAt < 128) {
                    j10++;
                } else {
                    if (charAt < 2048) {
                        i12 = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i12 = 3;
                    } else {
                        int i13 = i10 + 1;
                        char charAt2 = i13 < i11 ? str.charAt(i13) : (char) 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j10++;
                            i10 = i13;
                        } else {
                            j10 += 4;
                            i10 += 2;
                        }
                    }
                    j10 += i12;
                }
                i10++;
            }
            return j10;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
    }
}
