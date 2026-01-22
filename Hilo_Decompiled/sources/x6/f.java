package x6;

import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class f {

    /* renamed from: e, reason: collision with root package name */
    private static final double[] f١٨٩٤٤e = new double[128];

    /* renamed from: a, reason: collision with root package name */
    private char f١٨٩٤٥a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f١٨٩٤٦b;

    /* renamed from: c, reason: collision with root package name */
    public int f١٨٩٤٧c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٨٩٤٨d;

    static {
        int i10 = 0;
        while (true) {
            double[] dArr = f١٨٩٤٤e;
            if (i10 < dArr.length) {
                dArr[i10] = Math.pow(10.0d, i10);
                i10++;
            } else {
                return;
            }
        }
    }

    public f(CharSequence charSequence) {
        this.f١٨٩٤٦b = charSequence;
        this.f١٨٩٤٨d = charSequence.length();
        this.f١٨٩٤٥a = charSequence.charAt(this.f١٨٩٤٧c);
    }

    private static float b(int i10, int i11) {
        double d10;
        if (i11 >= -125 && i10 != 0) {
            if (i11 >= 128) {
                if (i10 > 0) {
                    return Float.POSITIVE_INFINITY;
                }
                return Float.NEGATIVE_INFINITY;
            }
            if (i11 == 0) {
                return i10;
            }
            if (i10 >= 67108864) {
                i10++;
            }
            double d11 = i10;
            double[] dArr = f١٨٩٤٤e;
            if (i11 > 0) {
                d10 = d11 * dArr[i11];
            } else {
                d10 = d11 / dArr[-i11];
            }
            return (float) d10;
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    private char e() {
        int i10 = this.f١٨٩٤٧c;
        int i11 = this.f١٨٩٤٨d;
        if (i10 < i11) {
            this.f١٨٩٤٧c = i10 + 1;
        }
        int i12 = this.f١٨٩٤٧c;
        if (i12 == i11) {
            return (char) 0;
        }
        return this.f١٨٩٤٦b.charAt(i12);
    }

    private void f(char c10) {
        throw new RuntimeException("Unexpected char '" + c10 + "'.");
    }

    public void a() {
        this.f١٨٩٤٥a = e();
    }

    public float c() {
        h();
        float d10 = d();
        g();
        return d10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        if (r5 == 0) goto L٣٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        r9 = e();
        r15.f١٨٩٤٥a = r9;
        r11 = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
    
        switch(r9) {
            case 48: goto L٨٧;
            case 49: goto L٨٦;
            case 50: goto L٨٦;
            case 51: goto L٨٦;
            case 52: goto L٨٦;
            case 53: goto L٨٦;
            case 54: goto L٨٦;
            case 55: goto L٨٦;
            case 56: goto L٨٦;
            case 57: goto L٨٦;
            default: goto L٨٥;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r13 != false) goto L٤٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        return com.qiahao.base_common.download.okDownload.DownloadProgress.UNKNOWN_PROGRESS;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0034. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0066. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x0092. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:62:0x00c7. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0022. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:71:0x00de. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:86:0x004f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bb A[PHI: r4
  0x00bb: PHI (r4v2 boolean) = (r4v1 boolean), (r4v0 boolean) binds: [B:77:0x00b4, B:56:0x00a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028 A[LOOP:0: B:9:0x0028->B:17:?, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    float d() {
        boolean z10;
        int i10;
        int i11;
        int i12;
        boolean z11;
        char c10;
        char e10;
        char e11;
        char c11 = this.f١٨٩٤٥a;
        int i13 = 0;
        boolean z12 = true;
        if (c11 != '+') {
            if (c11 != '-') {
                z10 = true;
                switch (this.f١٨٩٤٥a) {
                    case '.':
                        i10 = 0;
                        i11 = 0;
                        i12 = 0;
                        z11 = false;
                        if (this.f١٨٩٤٥a == '.') {
                            char e12 = e();
                            this.f١٨٩٤٥a = e12;
                            switch (e12) {
                                case '0':
                                    break;
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    while (true) {
                                        if (i10 < 9) {
                                            i10++;
                                            i12 = (i12 * 10) + (this.f١٨٩٤٥a - '0');
                                            i11--;
                                        }
                                        char e13 = e();
                                        this.f١٨٩٤٥a = e13;
                                        switch (e13) {
                                        }
                                        break;
                                    }
                                default:
                                    if (!z11) {
                                        f(e12);
                                        return DownloadProgress.UNKNOWN_PROGRESS;
                                    }
                                    break;
                            }
                        }
                        c10 = this.f١٨٩٤٥a;
                        if (c10 != 'E' || c10 == 'e') {
                            e10 = e();
                            this.f١٨٩٤٥a = e10;
                            if (e10 != '+') {
                                if (e10 == '-') {
                                    z12 = false;
                                } else {
                                    switch (e10) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            switch (this.f١٨٩٤٥a) {
                                                case '0':
                                                    while (true) {
                                                        char e14 = e();
                                                        this.f١٨٩٤٥a = e14;
                                                        switch (e14) {
                                                        }
                                                    }
                                                    break;
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    int i14 = 0;
                                                    while (true) {
                                                        if (i13 < 3) {
                                                            i13++;
                                                            i14 = (i14 * 10) + (this.f١٨٩٤٥a - '0');
                                                        }
                                                        char e15 = e();
                                                        this.f١٨٩٤٥a = e15;
                                                        switch (e15) {
                                                        }
                                                        i13 = i14;
                                                        break;
                                                    }
                                            }
                                        default:
                                            f(e10);
                                            return DownloadProgress.UNKNOWN_PROGRESS;
                                    }
                                }
                            }
                            e11 = e();
                            this.f١٨٩٤٥a = e11;
                            switch (e11) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    f(e11);
                                    return DownloadProgress.UNKNOWN_PROGRESS;
                            }
                        }
                        if (!z12) {
                            i13 = -i13;
                        }
                        int i15 = i13 + i11;
                        if (!z10) {
                            i12 = -i12;
                        }
                        return b(i12, i15);
                    case '/':
                    default:
                        return Float.NaN;
                    case '0':
                        while (true) {
                            char e16 = e();
                            this.f١٨٩٤٥a = e16;
                            if (e16 != '.' && e16 != 'E' && e16 != 'e') {
                                switch (e16) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                    default:
                                        return DownloadProgress.UNKNOWN_PROGRESS;
                                }
                            }
                        }
                        i10 = 0;
                        i11 = 0;
                        i12 = 0;
                        z11 = true;
                        if (this.f١٨٩٤٥a == '.') {
                        }
                        c10 = this.f١٨٩٤٥a;
                        if (c10 != 'E') {
                        }
                        e10 = e();
                        this.f١٨٩٤٥a = e10;
                        if (e10 != '+') {
                        }
                        e11 = e();
                        this.f١٨٩٤٥a = e11;
                        switch (e11) {
                        }
                        if (!z12) {
                        }
                        int i152 = i13 + i11;
                        if (!z10) {
                        }
                        return b(i12, i152);
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        i10 = 0;
                        i11 = 0;
                        i12 = 0;
                        while (true) {
                            if (i10 < 9) {
                                i10++;
                                i12 = (i12 * 10) + (this.f١٨٩٤٥a - '0');
                            } else {
                                i11++;
                            }
                            char e17 = e();
                            this.f١٨٩٤٥a = e17;
                            switch (e17) {
                            }
                            z11 = true;
                            if (this.f١٨٩٤٥a == '.') {
                            }
                            c10 = this.f١٨٩٤٥a;
                            if (c10 != 'E') {
                            }
                            e10 = e();
                            this.f١٨٩٤٥a = e10;
                            if (e10 != '+') {
                            }
                            e11 = e();
                            this.f١٨٩٤٥a = e11;
                            switch (e11) {
                            }
                            if (!z12) {
                            }
                            int i1522 = i13 + i11;
                            if (!z10) {
                            }
                            return b(i12, i1522);
                            break;
                        }
                        break;
                }
            } else {
                z10 = false;
            }
        } else {
            z10 = true;
        }
        this.f١٨٩٤٥a = e();
        switch (this.f١٨٩٤٥a) {
        }
    }

    void g() {
        while (true) {
            int i10 = this.f١٨٩٤٧c;
            if (i10 < this.f١٨٩٤٨d) {
                char charAt = this.f١٨٩٤٦b.charAt(i10);
                if (charAt != '\t' && charAt != '\n' && charAt != ' ' && charAt != ',') {
                    return;
                } else {
                    a();
                }
            } else {
                return;
            }
        }
    }

    public void h() {
        while (true) {
            int i10 = this.f١٨٩٤٧c;
            if (i10 < this.f١٨٩٤٨d && Character.isWhitespace(this.f١٨٩٤٦b.charAt(i10))) {
                a();
            } else {
                return;
            }
        }
    }
}
