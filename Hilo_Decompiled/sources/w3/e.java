package w3;

import anetwork.channel.util.RequestConstant;
import com.amazonaws.services.s3.internal.Constants;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import w3.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e extends c {

    /* renamed from: n, reason: collision with root package name */
    private static final ByteString f١٨٧٠٦n = ByteString.encodeUtf8("'\\");

    /* renamed from: o, reason: collision with root package name */
    private static final ByteString f١٨٧٠٧o = ByteString.encodeUtf8("\"\\");

    /* renamed from: p, reason: collision with root package name */
    private static final ByteString f١٨٧٠٨p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: q, reason: collision with root package name */
    private static final ByteString f١٨٧٠٩q = ByteString.encodeUtf8("\n\r");

    /* renamed from: r, reason: collision with root package name */
    private static final ByteString f١٨٧١٠r = ByteString.encodeUtf8("*/");

    /* renamed from: h, reason: collision with root package name */
    private final BufferedSource f١٨٧١١h;

    /* renamed from: i, reason: collision with root package name */
    private final Buffer f١٨٧١٢i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٨٧١٣j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f١٨٧١٤k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٨٧١٥l;

    /* renamed from: m, reason: collision with root package name */
    private String f١٨٧١٦m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.f١٨٧١١h = bufferedSource;
            this.f١٨٧١٢i = bufferedSource.getBufferField();
            w(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void E() {
        if (this.f١٨٦٩١e) {
        } else {
            throw D("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int F() {
        int[] iArr = this.f١٨٦٨٨b;
        int i10 = this.f١٨٦٨٧a;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int I = I(true);
            this.f١٨٧١٢i.readByte();
            if (I != 44) {
                if (I != 59) {
                    if (I == 93) {
                        this.f١٨٧١٣j = 4;
                        return 4;
                    }
                    throw D("Unterminated array");
                }
                E();
            }
        } else if (i11 != 3 && i11 != 5) {
            if (i11 == 4) {
                iArr[i10 - 1] = 5;
                int I2 = I(true);
                this.f١٨٧١٢i.readByte();
                if (I2 != 58) {
                    if (I2 == 61) {
                        E();
                        if (this.f١٨٧١١h.request(1L) && this.f١٨٧١٢i.getByte(0L) == 62) {
                            this.f١٨٧١٢i.readByte();
                        }
                    } else {
                        throw D("Expected ':'");
                    }
                }
            } else if (i11 == 6) {
                iArr[i10 - 1] = 7;
            } else if (i11 == 7) {
                if (I(false) == -1) {
                    this.f١٨٧١٣j = 18;
                    return 18;
                }
                E();
            } else if (i11 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        } else {
            iArr[i10 - 1] = 4;
            if (i11 == 5) {
                int I3 = I(true);
                this.f١٨٧١٢i.readByte();
                if (I3 != 44) {
                    if (I3 != 59) {
                        if (I3 == 125) {
                            this.f١٨٧١٣j = 2;
                            return 2;
                        }
                        throw D("Unterminated object");
                    }
                    E();
                }
            }
            int I4 = I(true);
            if (I4 != 34) {
                if (I4 != 39) {
                    if (I4 != 125) {
                        E();
                        if (H((char) I4)) {
                            this.f١٨٧١٣j = 14;
                            return 14;
                        }
                        throw D("Expected name");
                    }
                    if (i11 != 5) {
                        this.f١٨٧١٢i.readByte();
                        this.f١٨٧١٣j = 2;
                        return 2;
                    }
                    throw D("Expected name");
                }
                this.f١٨٧١٢i.readByte();
                E();
                this.f١٨٧١٣j = 12;
                return 12;
            }
            this.f١٨٧١٢i.readByte();
            this.f١٨٧١٣j = 13;
            return 13;
        }
        int I5 = I(true);
        if (I5 != 34) {
            if (I5 != 39) {
                if (I5 != 44 && I5 != 59) {
                    if (I5 != 91) {
                        if (I5 != 93) {
                            if (I5 != 123) {
                                int M = M();
                                if (M != 0) {
                                    return M;
                                }
                                int N = N();
                                if (N != 0) {
                                    return N;
                                }
                                if (H(this.f١٨٧١٢i.getByte(0L))) {
                                    E();
                                    this.f١٨٧١٣j = 10;
                                    return 10;
                                }
                                throw D("Expected value");
                            }
                            this.f١٨٧١٢i.readByte();
                            this.f١٨٧١٣j = 1;
                            return 1;
                        }
                        if (i11 == 1) {
                            this.f١٨٧١٢i.readByte();
                            this.f١٨٧١٣j = 4;
                            return 4;
                        }
                    } else {
                        this.f١٨٧١٢i.readByte();
                        this.f١٨٧١٣j = 3;
                        return 3;
                    }
                }
                if (i11 != 1 && i11 != 2) {
                    throw D("Unexpected value");
                }
                E();
                this.f١٨٧١٣j = 7;
                return 7;
            }
            E();
            this.f١٨٧١٢i.readByte();
            this.f١٨٧١٣j = 8;
            return 8;
        }
        this.f١٨٧١٢i.readByte();
        this.f١٨٧١٣j = 9;
        return 9;
    }

    private int G(String str, c.a aVar) {
        int length = aVar.f١٨٦٩٣a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(aVar.f١٨٦٩٣a[i10])) {
                this.f١٨٧١٣j = 0;
                this.f١٨٦٨٩c[this.f١٨٦٨٧a - 1] = str;
                return i10;
            }
        }
        return -1;
    }

    private boolean H(int i10) {
        if (i10 != 9 && i10 != 10 && i10 != 12 && i10 != 13 && i10 != 32) {
            if (i10 != 35) {
                if (i10 != 44) {
                    if (i10 != 47 && i10 != 61) {
                        if (i10 != 123 && i10 != 125 && i10 != 58) {
                            if (i10 != 59) {
                                switch (i10) {
                                    case 91:
                                    case 93:
                                        return false;
                                    case 92:
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            E();
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.f١٨٧١٢i.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r2 != 47) goto L٤٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        if (r2 != 35) goto L٤٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        E();
        R();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
    
        if (r6.f١٨٧١١h.request(2) != false) goto L٢٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        E();
        r3 = r6.f١٨٧١٢i.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r3 == 42) goto L٤٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r6.f١٨٧١٢i.readByte();
        r6.f١٨٧١٢i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (Q() == false) goto L٤٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        throw D("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0049, code lost:
    
        if (r3 == 47) goto L٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004c, code lost:
    
        r6.f١٨٧١٢i.readByte();
        r6.f١٨٧١٢i.readByte();
        R();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0039, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int I(boolean z10) {
        while (true) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (this.f١٨٧١١h.request(i11)) {
                    byte b10 = this.f١٨٧١٢i.getByte(i10);
                    if (b10 != 10 && b10 != 32 && b10 != 13 && b10 != 9) {
                        break;
                    }
                    i10 = i11;
                } else {
                    if (!z10) {
                        return -1;
                    }
                    throw new EOFException("End of input");
                }
            }
        }
    }

    private String K(ByteString byteString) {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.f١٨٧١١h.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.f١٨٧١٢i.getByte(indexOfElement) == 92) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(this.f١٨٧١٢i.readUtf8(indexOfElement));
                    this.f١٨٧١٢i.readByte();
                    sb.append(O());
                } else {
                    if (sb == null) {
                        String readUtf8 = this.f١٨٧١٢i.readUtf8(indexOfElement);
                        this.f١٨٧١٢i.readByte();
                        return readUtf8;
                    }
                    sb.append(this.f١٨٧١٢i.readUtf8(indexOfElement));
                    this.f١٨٧١٢i.readByte();
                    return sb.toString();
                }
            } else {
                throw D("Unterminated string");
            }
        }
    }

    private String L() {
        long indexOfElement = this.f١٨٧١١h.indexOfElement(f١٨٧٠٨p);
        if (indexOfElement != -1) {
            return this.f١٨٧١٢i.readUtf8(indexOfElement);
        }
        return this.f١٨٧١٢i.readUtf8();
    }

    private int M() {
        String str;
        String str2;
        int i10;
        byte b10 = this.f١٨٧١٢i.getByte(0L);
        if (b10 != 116 && b10 != 84) {
            if (b10 != 102 && b10 != 70) {
                if (b10 != 110 && b10 != 78) {
                    return 0;
                }
                str = Constants.NULL_VERSION_ID;
                str2 = "NULL";
                i10 = 7;
            } else {
                str = RequestConstant.FALSE;
                str2 = "FALSE";
                i10 = 6;
            }
        } else {
            str = "true";
            str2 = "TRUE";
            i10 = 5;
        }
        int length = str.length();
        int i11 = 1;
        while (i11 < length) {
            int i12 = i11 + 1;
            if (!this.f١٨٧١١h.request(i12)) {
                return 0;
            }
            byte b11 = this.f١٨٧١٢i.getByte(i11);
            if (b11 != str.charAt(i11) && b11 != str2.charAt(i11)) {
                return 0;
            }
            i11 = i12;
        }
        if (this.f١٨٧١١h.request(length + 1) && H(this.f١٨٧١٢i.getByte(length))) {
            return 0;
        }
        this.f١٨٧١٢i.skip(length);
        this.f١٨٧١٣j = i10;
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
    
        if (H(r11) != false) goto L٦٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r6 != 2) goto L٦٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        if (r7 == false) goto L٦٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:
    
        if (r10 == false) goto L٦٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
    
        if (r8 != 0) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0093, code lost:
    
        if (r10 != false) goto L٦٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r10 == false) goto L٥٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0099, code lost:
    
        r16.f١٨٧١٤k = r8;
        r16.f١٨٧١٢i.skip(r5);
        r16.f١٨٧١٣j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a6, code lost:
    
        if (r6 == 2) goto L٦٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
    
        if (r6 == 4) goto L٦٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:
    
        if (r6 != 7) goto L٦٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r16.f١٨٧١٥l = r5;
        r16.f١٨٧١٣j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int N() {
        boolean z10;
        boolean z11 = true;
        long j10 = 0;
        int i10 = 0;
        char c10 = 0;
        boolean z12 = true;
        boolean z13 = false;
        while (true) {
            int i11 = i10 + 1;
            if (!this.f١٨٧١١h.request(i11)) {
                break;
            }
            byte b10 = this.f١٨٧١٢i.getByte(i10);
            if (b10 != 43) {
                if (b10 != 69 && b10 != 101) {
                    if (b10 != 45) {
                        if (b10 != 46) {
                            if (b10 < 48 || b10 > 57) {
                                break;
                            }
                            if (c10 != z11 && c10 != 0) {
                                if (c10 == 2) {
                                    if (j10 == 0) {
                                        return 0;
                                    }
                                    long j11 = (10 * j10) - (b10 - 48);
                                    if (j10 <= okio.internal.Buffer.OVERFLOW_ZONE && (j10 != okio.internal.Buffer.OVERFLOW_ZONE || j11 >= j10)) {
                                        z10 = false;
                                    } else {
                                        z10 = true;
                                    }
                                    z12 &= z10;
                                    j10 = j11;
                                } else if (c10 == 3) {
                                    c10 = 4;
                                } else if (c10 == 5 || c10 == 6) {
                                    c10 = 7;
                                }
                            } else {
                                j10 = -(b10 - 48);
                                c10 = 2;
                            }
                        } else {
                            if (c10 != 2) {
                                return 0;
                            }
                            c10 = 3;
                        }
                    } else if (c10 == 0) {
                        c10 = 1;
                        z13 = true;
                    } else if (c10 != 5) {
                        return 0;
                    }
                } else {
                    if (c10 != 2 && c10 != 4) {
                        return 0;
                    }
                    c10 = 5;
                }
                i10 = i11;
                z11 = true;
            } else if (c10 != 5) {
                return 0;
            }
            c10 = 6;
            i10 = i11;
            z11 = true;
        }
    }

    private char O() {
        int i10;
        if (this.f١٨٧١١h.request(1L)) {
            byte readByte = this.f١٨٧١٢i.readByte();
            if (readByte != 10 && readByte != 34 && readByte != 39 && readByte != 47 && readByte != 92) {
                if (readByte != 98) {
                    if (readByte != 102) {
                        if (readByte == 110) {
                            return '\n';
                        }
                        if (readByte != 114) {
                            if (readByte != 116) {
                                if (readByte != 117) {
                                    if (this.f١٨٦٩١e) {
                                        return (char) readByte;
                                    }
                                    throw D("Invalid escape sequence: \\" + ((char) readByte));
                                }
                                if (this.f١٨٧١١h.request(4L)) {
                                    char c10 = 0;
                                    for (int i11 = 0; i11 < 4; i11++) {
                                        byte b10 = this.f١٨٧١٢i.getByte(i11);
                                        char c11 = (char) (c10 << 4);
                                        if (b10 >= 48 && b10 <= 57) {
                                            i10 = b10 - 48;
                                        } else if (b10 >= 97 && b10 <= 102) {
                                            i10 = b10 - 87;
                                        } else {
                                            if (b10 < 65 || b10 > 70) {
                                                throw D("\\u" + this.f١٨٧١٢i.readUtf8(4L));
                                            }
                                            i10 = b10 - 55;
                                        }
                                        c10 = (char) (c11 + i10);
                                    }
                                    this.f١٨٧١٢i.skip(4L);
                                    return c10;
                                }
                                throw new EOFException("Unterminated escape sequence at path " + getPath());
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
            return (char) readByte;
        }
        throw D("Unterminated escape sequence");
    }

    private void P(ByteString byteString) {
        while (true) {
            long indexOfElement = this.f١٨٧١١h.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.f١٨٧١٢i.getByte(indexOfElement) == 92) {
                    this.f١٨٧١٢i.skip(indexOfElement + 1);
                    O();
                } else {
                    this.f١٨٧١٢i.skip(indexOfElement + 1);
                    return;
                }
            } else {
                throw D("Unterminated string");
            }
        }
    }

    private boolean Q() {
        boolean z10;
        long size;
        long indexOf = this.f١٨٧١١h.indexOf(f١٨٧١٠r);
        if (indexOf != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Buffer buffer = this.f١٨٧١٢i;
        if (z10) {
            size = indexOf + r1.size();
        } else {
            size = buffer.size();
        }
        buffer.skip(size);
        return z10;
    }

    private void R() {
        long size;
        long indexOfElement = this.f١٨٧١١h.indexOfElement(f١٨٧٠٩q);
        Buffer buffer = this.f١٨٧١٢i;
        if (indexOfElement != -1) {
            size = indexOfElement + 1;
        } else {
            size = buffer.size();
        }
        buffer.skip(size);
    }

    private void S() {
        long indexOfElement = this.f١٨٧١١h.indexOfElement(f١٨٧٠٨p);
        Buffer buffer = this.f١٨٧١٢i;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    @Override // w3.c
    public void A() {
        if (!this.f١٨٦٩٢f) {
            int i10 = 0;
            do {
                int i11 = this.f١٨٧١٣j;
                if (i11 == 0) {
                    i11 = F();
                }
                if (i11 == 3) {
                    w(1);
                } else if (i11 == 1) {
                    w(3);
                } else {
                    if (i11 == 4) {
                        i10--;
                        if (i10 >= 0) {
                            this.f١٨٦٨٧a--;
                        } else {
                            throw new a("Expected a value but was " + u() + " at path " + getPath());
                        }
                    } else if (i11 == 2) {
                        i10--;
                        if (i10 >= 0) {
                            this.f١٨٦٨٧a--;
                        } else {
                            throw new a("Expected a value but was " + u() + " at path " + getPath());
                        }
                    } else if (i11 != 14 && i11 != 10) {
                        if (i11 != 9 && i11 != 13) {
                            if (i11 != 8 && i11 != 12) {
                                if (i11 == 17) {
                                    this.f١٨٧١٢i.skip(this.f١٨٧١٥l);
                                } else if (i11 == 18) {
                                    throw new a("Expected a value but was " + u() + " at path " + getPath());
                                }
                            } else {
                                P(f١٨٧٠٦n);
                            }
                        } else {
                            P(f١٨٧٠٧o);
                        }
                    } else {
                        S();
                    }
                    this.f١٨٧١٣j = 0;
                }
                i10++;
                this.f١٨٧١٣j = 0;
            } while (i10 != 0);
            int[] iArr = this.f١٨٦٩٠d;
            int i12 = this.f١٨٦٨٧a;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.f١٨٦٨٩c[i12 - 1] = Constants.NULL_VERSION_ID;
            return;
        }
        throw new a("Cannot skip unexpected " + u() + " at " + getPath());
    }

    @Override // w3.c
    public void b() {
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 == 3) {
            w(1);
            this.f١٨٦٩٠d[this.f١٨٦٨٧a - 1] = 0;
            this.f١٨٧١٣j = 0;
        } else {
            throw new a("Expected BEGIN_ARRAY but was " + u() + " at path " + getPath());
        }
    }

    @Override // w3.c
    public void c() {
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 == 1) {
            w(3);
            this.f١٨٧١٣j = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + u() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f١٨٧١٣j = 0;
        this.f١٨٦٨٨b[0] = 8;
        this.f١٨٦٨٧a = 1;
        this.f١٨٧١٢i.clear();
        this.f١٨٧١١h.close();
    }

    @Override // w3.c
    public void g() {
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 == 4) {
            int i11 = this.f١٨٦٨٧a;
            this.f١٨٦٨٧a = i11 - 1;
            int[] iArr = this.f١٨٦٩٠d;
            int i12 = i11 - 2;
            iArr[i12] = iArr[i12] + 1;
            this.f١٨٧١٣j = 0;
            return;
        }
        throw new a("Expected END_ARRAY but was " + u() + " at path " + getPath());
    }

    @Override // w3.c
    public void h() {
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 == 2) {
            int i11 = this.f١٨٦٨٧a;
            int i12 = i11 - 1;
            this.f١٨٦٨٧a = i12;
            this.f١٨٦٨٩c[i12] = null;
            int[] iArr = this.f١٨٦٩٠d;
            int i13 = i11 - 2;
            iArr[i13] = iArr[i13] + 1;
            this.f١٨٧١٣j = 0;
            return;
        }
        throw new a("Expected END_OBJECT but was " + u() + " at path " + getPath());
    }

    @Override // w3.c
    public boolean j() {
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 != 2 && i10 != 4 && i10 != 18) {
            return true;
        }
        return false;
    }

    @Override // w3.c
    public boolean k() {
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 == 5) {
            this.f١٨٧١٣j = 0;
            int[] iArr = this.f١٨٦٩٠d;
            int i11 = this.f١٨٦٨٧a - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        }
        if (i10 == 6) {
            this.f١٨٧١٣j = 0;
            int[] iArr2 = this.f١٨٦٩٠d;
            int i12 = this.f١٨٦٨٧a - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        }
        throw new a("Expected a boolean but was " + u() + " at path " + getPath());
    }

    @Override // w3.c
    public double m() {
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 == 16) {
            this.f١٨٧١٣j = 0;
            int[] iArr = this.f١٨٦٩٠d;
            int i11 = this.f١٨٦٨٧a - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f١٨٧١٤k;
        }
        if (i10 == 17) {
            this.f١٨٧١٦m = this.f١٨٧١٢i.readUtf8(this.f١٨٧١٥l);
        } else if (i10 == 9) {
            this.f١٨٧١٦m = K(f١٨٧٠٧o);
        } else if (i10 == 8) {
            this.f١٨٧١٦m = K(f١٨٧٠٦n);
        } else if (i10 == 10) {
            this.f١٨٧١٦m = L();
        } else if (i10 != 11) {
            throw new a("Expected a double but was " + u() + " at path " + getPath());
        }
        this.f١٨٧١٣j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f١٨٧١٦m);
            if (!this.f١٨٦٩١e && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new b("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.f١٨٧١٦m = null;
            this.f١٨٧١٣j = 0;
            int[] iArr2 = this.f١٨٦٩٠d;
            int i12 = this.f١٨٦٨٧a - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.f١٨٧١٦m + " at path " + getPath());
        }
    }

    @Override // w3.c
    public int o() {
        String K;
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 == 16) {
            long j10 = this.f١٨٧١٤k;
            int i11 = (int) j10;
            if (j10 == i11) {
                this.f١٨٧١٣j = 0;
                int[] iArr = this.f١٨٦٩٠d;
                int i12 = this.f١٨٦٨٧a - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new a("Expected an int but was " + this.f١٨٧١٤k + " at path " + getPath());
        }
        if (i10 == 17) {
            this.f١٨٧١٦m = this.f١٨٧١٢i.readUtf8(this.f١٨٧١٥l);
        } else if (i10 != 9 && i10 != 8) {
            if (i10 != 11) {
                throw new a("Expected an int but was " + u() + " at path " + getPath());
            }
        } else {
            if (i10 == 9) {
                K = K(f١٨٧٠٧o);
            } else {
                K = K(f١٨٧٠٦n);
            }
            this.f١٨٧١٦m = K;
            try {
                int parseInt = Integer.parseInt(K);
                this.f١٨٧١٣j = 0;
                int[] iArr2 = this.f١٨٦٩٠d;
                int i13 = this.f١٨٦٨٧a - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f١٨٧١٣j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f١٨٧١٦m);
            int i14 = (int) parseDouble;
            if (i14 == parseDouble) {
                this.f١٨٧١٦m = null;
                this.f١٨٧١٣j = 0;
                int[] iArr3 = this.f١٨٦٩٠d;
                int i15 = this.f١٨٦٨٧a - 1;
                iArr3[i15] = iArr3[i15] + 1;
                return i14;
            }
            throw new a("Expected an int but was " + this.f١٨٧١٦m + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.f١٨٧١٦m + " at path " + getPath());
        }
    }

    @Override // w3.c
    public String q() {
        String str;
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 == 14) {
            str = L();
        } else if (i10 == 13) {
            str = K(f١٨٧٠٧o);
        } else if (i10 == 12) {
            str = K(f١٨٧٠٦n);
        } else if (i10 == 15) {
            str = this.f١٨٧١٦m;
        } else {
            throw new a("Expected a name but was " + u() + " at path " + getPath());
        }
        this.f١٨٧١٣j = 0;
        this.f١٨٦٨٩c[this.f١٨٦٨٧a - 1] = str;
        return str;
    }

    @Override // w3.c
    public String s() {
        String readUtf8;
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 == 10) {
            readUtf8 = L();
        } else if (i10 == 9) {
            readUtf8 = K(f١٨٧٠٧o);
        } else if (i10 == 8) {
            readUtf8 = K(f١٨٧٠٦n);
        } else if (i10 == 11) {
            readUtf8 = this.f١٨٧١٦m;
            this.f١٨٧١٦m = null;
        } else if (i10 == 16) {
            readUtf8 = Long.toString(this.f١٨٧١٤k);
        } else if (i10 == 17) {
            readUtf8 = this.f١٨٧١٢i.readUtf8(this.f١٨٧١٥l);
        } else {
            throw new a("Expected a string but was " + u() + " at path " + getPath());
        }
        this.f١٨٧١٣j = 0;
        int[] iArr = this.f١٨٦٩٠d;
        int i11 = this.f١٨٦٨٧a - 1;
        iArr[i11] = iArr[i11] + 1;
        return readUtf8;
    }

    public String toString() {
        return "JsonReader(" + this.f١٨٧١١h + ")";
    }

    @Override // w3.c
    public c.b u() {
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        switch (i10) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // w3.c
    public int x(c.a aVar) {
        int i10 = this.f١٨٧١٣j;
        if (i10 == 0) {
            i10 = F();
        }
        if (i10 < 12 || i10 > 15) {
            return -1;
        }
        if (i10 == 15) {
            return G(this.f١٨٧١٦m, aVar);
        }
        int select = this.f١٨٧١١h.select(aVar.f١٨٦٩٤b);
        if (select != -1) {
            this.f١٨٧١٣j = 0;
            this.f١٨٦٨٩c[this.f١٨٦٨٧a - 1] = aVar.f١٨٦٩٣a[select];
            return select;
        }
        String str = this.f١٨٦٨٩c[this.f١٨٦٨٧a - 1];
        String q10 = q();
        int G = G(q10, aVar);
        if (G == -1) {
            this.f١٨٧١٣j = 15;
            this.f١٨٧١٦m = q10;
            this.f١٨٦٨٩c[this.f١٨٦٨٧a - 1] = str;
        }
        return G;
    }

    @Override // w3.c
    public void z() {
        if (!this.f١٨٦٩٢f) {
            int i10 = this.f١٨٧١٣j;
            if (i10 == 0) {
                i10 = F();
            }
            if (i10 == 14) {
                S();
            } else if (i10 == 13) {
                P(f١٨٧٠٧o);
            } else if (i10 == 12) {
                P(f١٨٧٠٦n);
            } else if (i10 != 15) {
                throw new a("Expected a name but was " + u() + " at path " + getPath());
            }
            this.f١٨٧١٣j = 0;
            this.f١٨٦٨٩c[this.f١٨٦٨٧a - 1] = Constants.NULL_VERSION_ID;
            return;
        }
        throw new a("Cannot skip unexpected " + u() + " at " + getPath());
    }
}
