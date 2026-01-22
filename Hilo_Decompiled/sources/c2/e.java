package c2;

import c2.d;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import d2.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e {
    public static float U0 = 0.5f;
    int A0;
    int B0;
    boolean C0;
    boolean D0;
    boolean E0;
    public boolean F;
    boolean F0;
    public boolean G;
    boolean G0;
    boolean H0;
    boolean I0;
    int J0;
    int K0;
    boolean L0;
    private boolean M;
    boolean M0;
    public float[] N0;
    protected e[] O0;
    protected e[] P0;
    e Q0;
    e R0;
    public int S0;
    public int T0;
    public d X;
    public d[] Y;
    protected ArrayList Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean[] f٥٧٠٢a0;

    /* renamed from: b0, reason: collision with root package name */
    public b[] f٥٧٠٤b0;

    /* renamed from: c, reason: collision with root package name */
    public d2.c f٥٧٠٥c;

    /* renamed from: c0, reason: collision with root package name */
    public e f٥٧٠٦c0;

    /* renamed from: d, reason: collision with root package name */
    public d2.c f٥٧٠٧d;

    /* renamed from: d0, reason: collision with root package name */
    int f٥٧٠٨d0;

    /* renamed from: e0, reason: collision with root package name */
    int f٥٧١٠e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f٥٧١٢f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f٥٧١٤g0;

    /* renamed from: h0, reason: collision with root package name */
    protected int f٥٧١٦h0;

    /* renamed from: i0, reason: collision with root package name */
    protected int f٥٧١٨i0;

    /* renamed from: j0, reason: collision with root package name */
    int f٥٧٢٠j0;

    /* renamed from: k0, reason: collision with root package name */
    int f٥٧٢٢k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f٥٧٢٤l0;

    /* renamed from: m0, reason: collision with root package name */
    protected int f٥٧٢٦m0;

    /* renamed from: n0, reason: collision with root package name */
    int f٥٧٢٨n0;

    /* renamed from: o, reason: collision with root package name */
    public String f٥٧٢٩o;

    /* renamed from: o0, reason: collision with root package name */
    protected int f٥٧٣٠o0;

    /* renamed from: p0, reason: collision with root package name */
    protected int f٥٧٣٢p0;

    /* renamed from: q0, reason: collision with root package name */
    float f٥٧٣٤q0;

    /* renamed from: r0, reason: collision with root package name */
    float f٥٧٣٦r0;

    /* renamed from: s0, reason: collision with root package name */
    private Object f٥٧٣٨s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f٥٧٤٠t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f٥٧٤٢u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f٥٧٤٤v0;

    /* renamed from: w0, reason: collision with root package name */
    private String f٥٧٤٦w0;

    /* renamed from: x0, reason: collision with root package name */
    private String f٥٧٤٨x0;

    /* renamed from: y0, reason: collision with root package name */
    int f٥٧٥٠y0;

    /* renamed from: z0, reason: collision with root package name */
    int f٥٧٥٢z0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f٥٧٠١a = false;

    /* renamed from: b, reason: collision with root package name */
    public p[] f٥٧٠٣b = new p[2];

    /* renamed from: e, reason: collision with root package name */
    public d2.l f٥٧٠٩e = null;

    /* renamed from: f, reason: collision with root package name */
    public d2.n f٥٧١١f = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean[] f٥٧١٣g = {true, true};

    /* renamed from: h, reason: collision with root package name */
    boolean f٥٧١٥h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٥٧١٧i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f٥٧١٩j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f٥٧٢١k = true;

    /* renamed from: l, reason: collision with root package name */
    private int f٥٧٢٣l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f٥٧٢٥m = -1;

    /* renamed from: n, reason: collision with root package name */
    public b2.a f٥٧٢٧n = new b2.a(this);

    /* renamed from: p, reason: collision with root package name */
    private boolean f٥٧٣١p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٥٧٣٣q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٥٧٣٥r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٥٧٣٧s = false;

    /* renamed from: t, reason: collision with root package name */
    public int f٥٧٣٩t = -1;

    /* renamed from: u, reason: collision with root package name */
    public int f٥٧٤١u = -1;

    /* renamed from: v, reason: collision with root package name */
    private int f٥٧٤٣v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f٥٧٤٥w = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f٥٧٤٧x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int[] f٥٧٤٩y = new int[2];

    /* renamed from: z, reason: collision with root package name */
    public int f٥٧٥١z = 0;
    public int A = 0;

    /* renamed from: B, reason: collision with root package name */
    public float f٥٧٠٠B = 1.0f;
    public int C = 0;
    public int D = 0;
    public float E = 1.0f;
    int H = -1;
    float I = 1.0f;
    private int[] J = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float K = DownloadProgress.UNKNOWN_PROGRESS;
    private boolean L = false;
    private boolean N = false;
    private int O = 0;
    private int P = 0;
    public d Q = new d(this, d.b.LEFT);
    public d R = new d(this, d.b.TOP);
    public d S = new d(this, d.b.RIGHT);
    public d T = new d(this, d.b.BOTTOM);
    public d U = new d(this, d.b.BASELINE);
    d V = new d(this, d.b.CENTER_X);
    d W = new d(this, d.b.CENTER_Y);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٥٧٥٣a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f٥٧٥٤b;

        static {
            int[] iArr = new int[b.values().length];
            f٥٧٥٤b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f٥٧٥٤b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f٥٧٥٤b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f٥٧٥٤b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f٥٧٥٣a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f٥٧٥٣a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f٥٧٥٣a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f٥٧٥٣a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f٥٧٥٣a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f٥٧٥٣a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f٥٧٥٣a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f٥٧٥٣a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f٥٧٥٣a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.X = dVar;
        this.Y = new d[]{this.Q, this.S, this.R, this.T, this.U, dVar};
        this.Z = new ArrayList();
        this.f٥٧٠٢a0 = new boolean[2];
        b bVar = b.FIXED;
        this.f٥٧٠٤b0 = new b[]{bVar, bVar};
        this.f٥٧٠٦c0 = null;
        this.f٥٧٠٨d0 = 0;
        this.f٥٧١٠e0 = 0;
        this.f٥٧١٢f0 = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٥٧١٤g0 = -1;
        this.f٥٧١٦h0 = 0;
        this.f٥٧١٨i0 = 0;
        this.f٥٧٢٠j0 = 0;
        this.f٥٧٢٢k0 = 0;
        this.f٥٧٢٤l0 = 0;
        this.f٥٧٢٦m0 = 0;
        this.f٥٧٢٨n0 = 0;
        float f10 = U0;
        this.f٥٧٣٤q0 = f10;
        this.f٥٧٣٦r0 = f10;
        this.f٥٧٤٠t0 = 0;
        this.f٥٧٤٢u0 = 0;
        this.f٥٧٤٤v0 = false;
        this.f٥٧٤٦w0 = null;
        this.f٥٧٤٨x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new e[]{null, null};
        this.P0 = new e[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
    }

    private void A0(StringBuilder sb, String str, float f10, float f11) {
        if (f10 == f11) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f10);
        sb.append(",\n");
    }

    private void B0(StringBuilder sb, String str, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i10);
        sb.append(",\n");
    }

    private void C0(StringBuilder sb, String str, float f10, int i10) {
        if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f10);
        sb.append(",");
        sb.append(i10);
        sb.append("");
        sb.append("],\n");
    }

    private void R(StringBuilder sb, String str, int i10, int i11, int i12, int i13, int i14, int i15, float f10, float f11) {
        sb.append(str);
        sb.append(" :  {\n");
        B0(sb, "      size", i10, 0);
        B0(sb, "      min", i11, 0);
        B0(sb, "      max", i12, Integer.MAX_VALUE);
        B0(sb, "      matchMin", i14, 0);
        B0(sb, "      matchDef", i15, 0);
        A0(sb, "      matchPercent", f10, 1.0f);
        sb.append("    },\n");
    }

    private void S(StringBuilder sb, String str, d dVar) {
        if (dVar.f٥٦٨٥f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(dVar.f٥٦٨٥f);
        sb.append("'");
        if (dVar.f٥٦٨٧h != Integer.MIN_VALUE || dVar.f٥٦٨٦g != 0) {
            sb.append(",");
            sb.append(dVar.f٥٦٨٦g);
            if (dVar.f٥٦٨٧h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(dVar.f٥٦٨٧h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    private void d() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    private boolean h0(int i10) {
        d dVar;
        d dVar2;
        int i11 = i10 * 2;
        d[] dVarArr = this.Y;
        d dVar3 = dVarArr[i11];
        d dVar4 = dVar3.f٥٦٨٥f;
        if (dVar4 != null && dVar4.f٥٦٨٥f != dVar3 && (dVar2 = (dVar = dVarArr[i11 + 1]).f٥٦٨٥f) != null && dVar2.f٥٦٨٥f == dVar) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:153:0x0462, code lost:
    
        if ((r4 instanceof c2.a) != false) goto L٢٦٧;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0500 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0548 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:319:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x051a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i(z1.d dVar, boolean z10, boolean z11, boolean z12, boolean z13, z1.i iVar, z1.i iVar2, b bVar, boolean z14, d dVar2, d dVar3, int i10, int i11, int i12, int i13, float f10, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, int i14, int i15, int i16, int i17, float f11, boolean z20) {
        int i18;
        boolean z21;
        int i19;
        int i20;
        int i21;
        z1.i iVar3;
        int i22;
        z1.i iVar4;
        z1.i iVar5;
        z1.i iVar6;
        int i23;
        boolean z22;
        boolean z23;
        z1.i q10;
        z1.i q11;
        d dVar4;
        z1.i iVar7;
        z1.i iVar8;
        int i24;
        int i25;
        int i26;
        boolean z24;
        boolean z25;
        int i27;
        boolean z26;
        boolean z27;
        z1.i iVar9;
        e eVar;
        e eVar2;
        e eVar3;
        z1.i iVar10;
        int i28;
        boolean z28;
        boolean z29;
        e eVar4;
        e eVar5;
        z1.i iVar11;
        e eVar6;
        int i29;
        int i30;
        int i31;
        z1.i iVar12;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        boolean z30;
        boolean z31;
        boolean z32;
        e eVar7;
        e eVar8;
        int i40 = i17;
        z1.i q12 = dVar.q(dVar2);
        z1.i q13 = dVar.q(dVar3);
        z1.i q14 = dVar.q(dVar2.j());
        z1.i q15 = dVar.q(dVar3.j());
        z1.d.x();
        boolean o10 = dVar2.o();
        boolean o11 = dVar3.o();
        boolean o12 = this.X.o();
        int i41 = o11 ? (o10 ? 1 : 0) + 1 : o10 ? 1 : 0;
        if (o12) {
            i41++;
        }
        int i42 = z15 ? 3 : i14;
        int i43 = a.f٥٧٥٤b[bVar.ordinal()];
        if (i43 == 1 || i43 == 2 || i43 == 3 || i43 != 4) {
            i18 = i42;
        } else {
            i18 = i42;
            if (i18 != 4) {
                z21 = true;
                i19 = this.f٥٧٢٣l;
                if (i19 != -1 && z10) {
                    this.f٥٧٢٣l = -1;
                    i11 = i19;
                    z21 = false;
                }
                i20 = this.f٥٧٢٥m;
                if (i20 != -1 || z10) {
                    i20 = i11;
                } else {
                    this.f٥٧٢٥m = -1;
                    z21 = false;
                }
                int i44 = i20;
                if (this.f٥٧٤٢u0 != 8) {
                    i21 = 0;
                    z21 = false;
                } else {
                    i21 = i44;
                }
                if (z20) {
                    if (!o10 && !o11 && !o12) {
                        dVar.f(q12, i10);
                    } else if (o10 && !o11) {
                        iVar3 = q15;
                        dVar.e(q12, q14, dVar2.f(), 8);
                        if (!z21) {
                            if (z14) {
                                dVar.e(q13, q12, 0, 3);
                                if (i12 > 0) {
                                    dVar.h(q13, q12, i12, 8);
                                }
                                if (i13 < Integer.MAX_VALUE) {
                                    dVar.j(q13, q12, i13, 8);
                                }
                            } else {
                                dVar.e(q13, q12, i21, 8);
                            }
                            i22 = i41;
                            iVar4 = q14;
                            iVar5 = q13;
                            z22 = z21;
                            iVar6 = iVar3;
                            z23 = z13;
                        } else if (i41 == 2 || z15 || !(i18 == 1 || i18 == 0)) {
                            int i45 = i16 == -2 ? i21 : i16;
                            int i46 = i40 == -2 ? i21 : i40;
                            if (i21 > 0 && i18 != 1) {
                                i21 = 0;
                            }
                            if (i45 > 0) {
                                dVar.h(q13, q12, i45, 8);
                                i21 = Math.max(i21, i45);
                            }
                            if (i46 > 0) {
                                if (!z11 || i18 != 1) {
                                    dVar.j(q13, q12, i46, 8);
                                }
                                i21 = Math.min(i21, i46);
                            }
                            if (i18 == 1) {
                                if (z11) {
                                    dVar.e(q13, q12, i21, 8);
                                } else if (z17) {
                                    dVar.e(q13, q12, i21, 5);
                                    dVar.j(q13, q12, i21, 8);
                                } else {
                                    dVar.e(q13, q12, i21, 5);
                                    dVar.j(q13, q12, i21, 8);
                                }
                                i40 = i46;
                                i22 = i41;
                                iVar5 = q13;
                                z22 = z21;
                                iVar6 = iVar3;
                                z23 = z13;
                                i23 = i45;
                                iVar4 = q14;
                            } else if (i18 == 2) {
                                d.b k10 = dVar2.k();
                                d.b bVar2 = d.b.TOP;
                                if (k10 != bVar2 && dVar2.k() != d.b.BOTTOM) {
                                    q10 = dVar.q(this.f٥٧٠٦c0.q(d.b.LEFT));
                                    q11 = dVar.q(this.f٥٧٠٦c0.q(d.b.RIGHT));
                                } else {
                                    q10 = dVar.q(this.f٥٧٠٦c0.q(bVar2));
                                    q11 = dVar.q(this.f٥٧٠٦c0.q(d.b.BOTTOM));
                                }
                                int i47 = i46;
                                i22 = i41;
                                iVar6 = iVar3;
                                int i48 = i45;
                                iVar4 = q14;
                                iVar5 = q13;
                                dVar.d(dVar.r().k(q13, q12, q11, q10, f11));
                                if (z11) {
                                    z21 = false;
                                }
                                i40 = i47;
                                i23 = i48;
                                z22 = z21;
                                z23 = z13;
                            } else {
                                int i49 = i46;
                                int i50 = i45;
                                i22 = i41;
                                iVar4 = q14;
                                iVar5 = q13;
                                iVar6 = iVar3;
                                i40 = i49;
                                i23 = i50;
                                z22 = z21;
                                z23 = true;
                            }
                            if (z20 || z17) {
                                if (i22 >= 2 && z11 && z23) {
                                    dVar.h(q12, iVar, 0, 8);
                                    boolean z33 = z10 || this.U.f٥٦٨٥f == null;
                                    if (!z10 && (dVar4 = this.U.f٥٦٨٥f) != null) {
                                        e eVar9 = dVar4.f٥٦٨٣d;
                                        if (eVar9.f٥٧١٢f0 != DownloadProgress.UNKNOWN_PROGRESS) {
                                            b[] bVarArr = eVar9.f٥٧٠٤b0;
                                            b bVar3 = bVarArr[0];
                                            b bVar4 = b.MATCH_CONSTRAINT;
                                            if (bVar3 == bVar4 && bVarArr[1] == bVar4) {
                                                z33 = true;
                                            }
                                        }
                                        z33 = false;
                                    }
                                    if (z33) {
                                        dVar.h(iVar2, iVar5, 0, 8);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (o10 || o11 || o12) {
                                if (o10 && !o11) {
                                    z28 = z11;
                                    i31 = (z11 && (dVar2.f٥٦٨٥f.f٥٦٨٣d instanceof c2.a)) ? 8 : 5;
                                } else if (!o10 && o11) {
                                    dVar.e(iVar5, iVar6, -dVar3.f(), 8);
                                    if (z11) {
                                        if (this.f٥٧١٩j && q12.f١٩٤٠٢g && (eVar7 = this.f٥٧٠٦c0) != null) {
                                            f fVar = (f) eVar7;
                                            if (z10) {
                                                fVar.D1(dVar2);
                                            } else {
                                                fVar.I1(dVar2);
                                            }
                                        } else {
                                            dVar.h(q12, iVar, 0, 5);
                                        }
                                    }
                                } else if (o10 && o11) {
                                    e eVar10 = dVar2.f٥٦٨٥f.f٥٦٨٣d;
                                    e eVar11 = dVar3.f٥٦٨٥f.f٥٦٨٣d;
                                    e M = M();
                                    if (!z22) {
                                        if (iVar4.f١٩٤٠٢g && iVar6.f١٩٤٠٢g) {
                                            dVar.c(q12, iVar4, dVar2.f(), f10, iVar6, iVar5, dVar3.f(), 8);
                                            if (z11 && z23) {
                                                if (dVar3.f٥٦٨٥f != null) {
                                                    i24 = dVar3.f();
                                                    iVar8 = iVar2;
                                                } else {
                                                    iVar8 = iVar2;
                                                    i24 = 0;
                                                }
                                                if (iVar6 != iVar8) {
                                                    dVar.h(iVar8, iVar5, i24, 5);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        iVar7 = iVar2;
                                    } else {
                                        if (i18 == 0) {
                                            if (i40 != 0 || i23 != 0) {
                                                i38 = 5;
                                                i39 = 5;
                                                z30 = true;
                                                z31 = false;
                                                z32 = true;
                                            } else if (iVar4.f١٩٤٠٢g && iVar6.f١٩٤٠٢g) {
                                                dVar.e(q12, iVar4, dVar2.f(), 8);
                                                dVar.e(iVar5, iVar6, -dVar3.f(), 8);
                                                return;
                                            } else {
                                                i38 = 8;
                                                i39 = 8;
                                                z30 = false;
                                                z31 = true;
                                                z32 = false;
                                            }
                                            if ((eVar10 instanceof c2.a) || (eVar11 instanceof c2.a)) {
                                                iVar7 = iVar2;
                                                z24 = z30;
                                                z26 = z31;
                                                z25 = z32;
                                                i25 = 6;
                                                i26 = 4;
                                            } else {
                                                iVar7 = iVar2;
                                                i26 = i39;
                                                z24 = z30;
                                                z26 = z31;
                                                z25 = z32;
                                                i25 = 6;
                                            }
                                            i27 = i38;
                                        } else if (i18 == 2) {
                                            if ((eVar10 instanceof c2.a) || (eVar11 instanceof c2.a)) {
                                                iVar7 = iVar2;
                                            } else {
                                                iVar7 = iVar2;
                                                i25 = 6;
                                                i26 = 5;
                                                i27 = 5;
                                                z25 = true;
                                                z24 = true;
                                                z26 = false;
                                            }
                                        } else if (i18 == 1) {
                                            iVar7 = iVar2;
                                            i25 = 6;
                                            i26 = 4;
                                            i27 = 8;
                                            z25 = true;
                                            z24 = true;
                                            z26 = false;
                                        } else if (i18 == 3) {
                                            if (this.H == -1) {
                                                if (z18) {
                                                    iVar7 = iVar2;
                                                    i25 = z11 ? 5 : 4;
                                                } else {
                                                    iVar7 = iVar2;
                                                    i25 = 8;
                                                }
                                                i26 = 5;
                                                i27 = 8;
                                            } else if (z15) {
                                                if (i15 != 2 && i15 != 1) {
                                                    i36 = 8;
                                                    i37 = 5;
                                                    i27 = i36;
                                                    i26 = i37;
                                                    i25 = 6;
                                                    z25 = true;
                                                    z24 = true;
                                                    z26 = true;
                                                    iVar7 = iVar2;
                                                }
                                                i36 = 5;
                                                i37 = 4;
                                                i27 = i36;
                                                i26 = i37;
                                                i25 = 6;
                                                z25 = true;
                                                z24 = true;
                                                z26 = true;
                                                iVar7 = iVar2;
                                            } else {
                                                if (i40 > 0) {
                                                    iVar7 = iVar2;
                                                    i25 = 6;
                                                    i26 = 5;
                                                } else if (i40 != 0 || i23 != 0) {
                                                    iVar7 = iVar2;
                                                    i25 = 6;
                                                    i26 = 4;
                                                } else if (z18) {
                                                    iVar7 = iVar2;
                                                    i27 = (eVar10 == M || eVar11 == M) ? 5 : 4;
                                                    i25 = 6;
                                                    i26 = 4;
                                                } else {
                                                    iVar7 = iVar2;
                                                    i25 = 6;
                                                    i26 = 8;
                                                }
                                                i27 = 5;
                                            }
                                            z25 = true;
                                            z24 = true;
                                            z26 = true;
                                        } else {
                                            iVar7 = iVar2;
                                            i25 = 6;
                                            i26 = 4;
                                            i27 = 5;
                                            z25 = false;
                                            z24 = false;
                                            z26 = false;
                                        }
                                        if (z25 || iVar4 != iVar6 || eVar10 == M) {
                                            z27 = true;
                                        } else {
                                            z25 = false;
                                            z27 = false;
                                        }
                                        if (z24) {
                                            iVar9 = iVar4;
                                            eVar = M;
                                            eVar2 = eVar11;
                                            eVar3 = eVar10;
                                            iVar10 = q12;
                                            i28 = 8;
                                            z28 = z11;
                                        } else {
                                            if (z22 || z16 || z18 || iVar4 != iVar || iVar6 != iVar7) {
                                                i35 = i25;
                                                z28 = z11;
                                            } else {
                                                z28 = false;
                                                i27 = 8;
                                                i35 = 8;
                                                z27 = false;
                                            }
                                            iVar9 = iVar4;
                                            i28 = 8;
                                            eVar = M;
                                            eVar2 = eVar11;
                                            eVar3 = eVar10;
                                            iVar10 = q12;
                                            dVar.c(q12, iVar9, dVar2.f(), f10, iVar6, iVar5, dVar3.f(), i35);
                                        }
                                        z29 = z27;
                                        if (this.f٥٧٤٢u0 != i28 && !dVar3.m()) {
                                            return;
                                        }
                                        z1.i iVar13 = iVar9;
                                        if (z25) {
                                            eVar4 = eVar2;
                                            eVar5 = eVar3;
                                            iVar11 = iVar10;
                                        } else {
                                            if (!z28 || iVar13 == iVar6 || z22) {
                                                eVar4 = eVar2;
                                                eVar5 = eVar3;
                                            } else {
                                                eVar5 = eVar3;
                                                if (eVar5 instanceof c2.a) {
                                                    eVar4 = eVar2;
                                                } else {
                                                    eVar4 = eVar2;
                                                }
                                                i34 = 6;
                                                iVar11 = iVar10;
                                                dVar.h(iVar11, iVar13, dVar2.f(), i34);
                                                dVar.j(iVar5, iVar6, -dVar3.f(), i34);
                                                i27 = i34;
                                            }
                                            i34 = i27;
                                            iVar11 = iVar10;
                                            dVar.h(iVar11, iVar13, dVar2.f(), i34);
                                            dVar.j(iVar5, iVar6, -dVar3.f(), i34);
                                            i27 = i34;
                                        }
                                        if (z28 || !z19 || (eVar5 instanceof c2.a) || (eVar4 instanceof c2.a)) {
                                            eVar6 = eVar;
                                        } else {
                                            eVar6 = eVar;
                                            if (eVar4 != eVar6) {
                                                z29 = true;
                                                i29 = 6;
                                                i30 = 6;
                                                if (z29) {
                                                    if (!z26 || (z18 && !z12)) {
                                                        i33 = i29;
                                                    } else {
                                                        int i51 = (eVar5 == eVar6 || eVar4 == eVar6) ? 6 : i29;
                                                        if ((eVar5 instanceof h) || (eVar4 instanceof h)) {
                                                            i51 = 5;
                                                        }
                                                        if ((eVar5 instanceof c2.a) || (eVar4 instanceof c2.a)) {
                                                            i51 = 5;
                                                        }
                                                        if (z18) {
                                                            i51 = 5;
                                                        }
                                                        i33 = Math.max(i51, i29);
                                                    }
                                                    if (z28) {
                                                        i33 = Math.min(i30, i33);
                                                        if (z15 && !z18 && (eVar5 == eVar6 || eVar4 == eVar6)) {
                                                            i33 = 4;
                                                        }
                                                    }
                                                    dVar.e(iVar11, iVar13, dVar2.f(), i33);
                                                    dVar.e(iVar5, iVar6, -dVar3.f(), i33);
                                                }
                                                if (z28) {
                                                    int f12 = iVar == iVar13 ? dVar2.f() : 0;
                                                    if (iVar13 != iVar) {
                                                        i31 = 5;
                                                        dVar.h(iVar11, iVar, f12, 5);
                                                        if (z28 && z22) {
                                                            iVar12 = iVar6;
                                                            if (i12 == 0 && i23 == 0) {
                                                                if (!z22 && i18 == 3) {
                                                                    i32 = 0;
                                                                    dVar.h(iVar5, iVar11, 0, i28);
                                                                } else {
                                                                    i32 = 0;
                                                                    dVar.h(iVar5, iVar11, 0, i31);
                                                                }
                                                                if (z28 || !z23) {
                                                                    return;
                                                                }
                                                                if (dVar3.f٥٦٨٥f != null) {
                                                                    i32 = dVar3.f();
                                                                }
                                                                if (iVar12 != iVar2) {
                                                                    if (this.f٥٧١٩j && iVar5.f١٩٤٠٢g && (eVar8 = this.f٥٧٠٦c0) != null) {
                                                                        f fVar2 = (f) eVar8;
                                                                        if (z10) {
                                                                            fVar2.C1(dVar3);
                                                                            return;
                                                                        } else {
                                                                            fVar2.H1(dVar3);
                                                                            return;
                                                                        }
                                                                    }
                                                                    dVar.h(iVar2, iVar5, i32, i31);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            i32 = 0;
                                                            if (z28) {
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                                i31 = 5;
                                                if (z28) {
                                                    iVar12 = iVar6;
                                                    if (i12 == 0) {
                                                        if (!z22) {
                                                        }
                                                        i32 = 0;
                                                        dVar.h(iVar5, iVar11, 0, i31);
                                                        if (z28) {
                                                        }
                                                    }
                                                    i32 = 0;
                                                    if (z28) {
                                                    }
                                                }
                                            }
                                        }
                                        i29 = i26;
                                        i30 = i27;
                                        if (z29) {
                                        }
                                        if (z28) {
                                        }
                                        i31 = 5;
                                        if (z28) {
                                        }
                                    }
                                    i25 = 6;
                                    i26 = 4;
                                    i27 = 5;
                                    z25 = true;
                                    z24 = true;
                                    z26 = false;
                                    if (z25) {
                                    }
                                    z27 = true;
                                    if (z24) {
                                    }
                                    z29 = z27;
                                    if (this.f٥٧٤٢u0 != i28) {
                                    }
                                    z1.i iVar132 = iVar9;
                                    if (z25) {
                                    }
                                    if (z28) {
                                    }
                                    eVar6 = eVar;
                                    i29 = i26;
                                    i30 = i27;
                                    if (z29) {
                                    }
                                    if (z28) {
                                    }
                                    i31 = 5;
                                    if (z28) {
                                    }
                                }
                                iVar12 = iVar6;
                                i32 = 0;
                                if (z28) {
                                }
                            }
                            iVar12 = iVar6;
                            i31 = 5;
                            i32 = 0;
                            z28 = z11;
                            if (z28) {
                            }
                        } else {
                            int max = Math.max(i16, i21);
                            if (i40 > 0) {
                                max = Math.min(i40, max);
                            }
                            dVar.e(q13, q12, max, 8);
                            z23 = z13;
                            i22 = i41;
                            iVar4 = q14;
                            iVar5 = q13;
                            iVar6 = iVar3;
                            z22 = false;
                        }
                        i23 = i16;
                        if (z20) {
                        }
                        if (i22 >= 2) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                iVar3 = q15;
                if (!z21) {
                }
                i23 = i16;
                if (z20) {
                }
                if (i22 >= 2) {
                }
            }
        }
        z21 = false;
        i19 = this.f٥٧٢٣l;
        if (i19 != -1) {
            this.f٥٧٢٣l = -1;
            i11 = i19;
            z21 = false;
        }
        i20 = this.f٥٧٢٥m;
        if (i20 != -1) {
        }
        i20 = i11;
        int i442 = i20;
        if (this.f٥٧٤٢u0 != 8) {
        }
        if (z20) {
        }
        iVar3 = q15;
        if (!z21) {
        }
        i23 = i16;
        if (z20) {
        }
        if (i22 >= 2) {
        }
    }

    public float A() {
        return this.f٥٧٣٤q0;
    }

    public int B() {
        return this.J0;
    }

    public b C() {
        return this.f٥٧٠٤b0[0];
    }

    public int D() {
        int i10;
        d dVar = this.Q;
        if (dVar != null) {
            i10 = dVar.f٥٦٨٦g;
        } else {
            i10 = 0;
        }
        d dVar2 = this.S;
        if (dVar2 != null) {
            return i10 + dVar2.f٥٦٨٦g;
        }
        return i10;
    }

    public void D0(boolean z10) {
        this.f٥٧٤٤v0 = z10;
    }

    public int E() {
        return this.O;
    }

    public void E0(int i10) {
        boolean z10;
        this.f٥٧٢٨n0 = i10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.L = z10;
    }

    public int F() {
        return this.P;
    }

    public void F0(Object obj) {
        this.f٥٧٣٨s0 = obj;
    }

    public int G(int i10) {
        if (i10 == 0) {
            return Y();
        }
        if (i10 == 1) {
            return z();
        }
        return 0;
    }

    public void G0(String str) {
        this.f٥٧٤٦w0 = str;
    }

    public int H() {
        return this.J[1];
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0087 -> B:31:0x0088). Please report as a decompilation issue!!! */
    public void H0(String str) {
        float f10;
        int i10 = 0;
        if (str != null && str.length() != 0) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i11 = 0;
            int i12 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    if (substring.equalsIgnoreCase("H")) {
                        i11 = 1;
                    } else {
                        i11 = -1;
                    }
                }
                i12 = i11;
                i11 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i11, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > DownloadProgress.UNKNOWN_PROGRESS && parseFloat2 > DownloadProgress.UNKNOWN_PROGRESS) {
                        if (i12 == 1) {
                            f10 = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f10 = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                String substring4 = str.substring(i11);
                if (substring4.length() > 0) {
                    f10 = Float.parseFloat(substring4);
                }
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            i10 = (f10 > i10 ? 1 : (f10 == i10 ? 0 : -1));
            if (i10 > 0) {
                this.f٥٧١٢f0 = f10;
                this.f٥٧١٤g0 = i12;
                return;
            }
            return;
        }
        this.f٥٧١٢f0 = DownloadProgress.UNKNOWN_PROGRESS;
    }

    public int I() {
        return this.J[0];
    }

    public void I0(int i10) {
        if (!this.L) {
            return;
        }
        int i11 = i10 - this.f٥٧٢٨n0;
        int i12 = this.f٥٧١٠e0 + i11;
        this.f٥٧١٨i0 = i11;
        this.R.t(i11);
        this.T.t(i12);
        this.U.t(i10);
        this.f٥٧٣٣q = true;
    }

    public int J() {
        return this.f٥٧٣٢p0;
    }

    public void J0(int i10, int i11) {
        if (this.f٥٧٣١p) {
            return;
        }
        this.Q.t(i10);
        this.S.t(i11);
        this.f٥٧١٦h0 = i10;
        this.f٥٧٠٨d0 = i11 - i10;
        this.f٥٧٣١p = true;
    }

    public int K() {
        return this.f٥٧٣٠o0;
    }

    public void K0(int i10) {
        this.Q.t(i10);
        this.f٥٧١٦h0 = i10;
    }

    public e L(int i10) {
        d dVar;
        d dVar2;
        if (i10 == 0) {
            d dVar3 = this.S;
            d dVar4 = dVar3.f٥٦٨٥f;
            if (dVar4 != null && dVar4.f٥٦٨٥f == dVar3) {
                return dVar4.f٥٦٨٣d;
            }
            return null;
        }
        if (i10 == 1 && (dVar2 = (dVar = this.T).f٥٦٨٥f) != null && dVar2.f٥٦٨٥f == dVar) {
            return dVar2.f٥٦٨٣d;
        }
        return null;
    }

    public void L0(int i10) {
        this.R.t(i10);
        this.f٥٧١٨i0 = i10;
    }

    public e M() {
        return this.f٥٧٠٦c0;
    }

    public void M0(int i10, int i11) {
        if (this.f٥٧٣٣q) {
            return;
        }
        this.R.t(i10);
        this.T.t(i11);
        this.f٥٧١٨i0 = i10;
        this.f٥٧١٠e0 = i11 - i10;
        if (this.L) {
            this.U.t(i10 + this.f٥٧٢٨n0);
        }
        this.f٥٧٣٣q = true;
    }

    public e N(int i10) {
        d dVar;
        d dVar2;
        if (i10 == 0) {
            d dVar3 = this.Q;
            d dVar4 = dVar3.f٥٦٨٥f;
            if (dVar4 != null && dVar4.f٥٦٨٥f == dVar3) {
                return dVar4.f٥٦٨٣d;
            }
            return null;
        }
        if (i10 == 1 && (dVar2 = (dVar = this.R).f٥٦٨٥f) != null && dVar2.f٥٦٨٥f == dVar) {
            return dVar2.f٥٦٨٣d;
        }
        return null;
    }

    public void N0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.f٥٧١٦h0 = i10;
        this.f٥٧١٨i0 = i11;
        if (this.f٥٧٤٢u0 == 8) {
            this.f٥٧٠٨d0 = 0;
            this.f٥٧١٠e0 = 0;
            return;
        }
        b[] bVarArr = this.f٥٧٠٤b0;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i16 < (i15 = this.f٥٧٠٨d0)) {
            i16 = i15;
        }
        if (bVarArr[1] == bVar2 && i17 < (i14 = this.f٥٧١٠e0)) {
            i17 = i14;
        }
        this.f٥٧٠٨d0 = i16;
        this.f٥٧١٠e0 = i17;
        int i18 = this.f٥٧٣٢p0;
        if (i17 < i18) {
            this.f٥٧١٠e0 = i18;
        }
        int i19 = this.f٥٧٣٠o0;
        if (i16 < i19) {
            this.f٥٧٠٨d0 = i19;
        }
        int i20 = this.A;
        if (i20 > 0 && bVar == b.MATCH_CONSTRAINT) {
            this.f٥٧٠٨d0 = Math.min(this.f٥٧٠٨d0, i20);
        }
        int i21 = this.D;
        if (i21 > 0 && this.f٥٧٠٤b0[1] == b.MATCH_CONSTRAINT) {
            this.f٥٧١٠e0 = Math.min(this.f٥٧١٠e0, i21);
        }
        int i22 = this.f٥٧٠٨d0;
        if (i16 != i22) {
            this.f٥٧٢٣l = i22;
        }
        int i23 = this.f٥٧١٠e0;
        if (i17 != i23) {
            this.f٥٧٢٥m = i23;
        }
    }

    public int O() {
        return Z() + this.f٥٧٠٨d0;
    }

    public void O0(boolean z10) {
        this.L = z10;
    }

    public p P(int i10) {
        if (i10 == 0) {
            return this.f٥٧٠٩e;
        }
        if (i10 == 1) {
            return this.f٥٧١١f;
        }
        return null;
    }

    public void P0(int i10) {
        this.f٥٧١٠e0 = i10;
        int i11 = this.f٥٧٣٢p0;
        if (i10 < i11) {
            this.f٥٧١٠e0 = i11;
        }
    }

    public void Q(StringBuilder sb) {
        sb.append("  " + this.f٥٧٢٩o + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.f٥٧٠٨d0);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.f٥٧١٠e0);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f٥٧١٦h0);
        sb.append("\n");
        sb.append("    actualTop:" + this.f٥٧١٨i0);
        sb.append("\n");
        S(sb, ViewHierarchyConstants.DIMENSION_LEFT_KEY, this.Q);
        S(sb, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.R);
        S(sb, "right", this.S);
        S(sb, "bottom", this.T);
        S(sb, "baseline", this.U);
        S(sb, "centerX", this.V);
        S(sb, "centerY", this.W);
        R(sb, "    width", this.f٥٧٠٨d0, this.f٥٧٣٠o0, this.J[0], this.f٥٧٢٣l, this.f٥٧٥١z, this.f٥٧٤٥w, this.f٥٧٠٠B, this.N0[0]);
        R(sb, "    height", this.f٥٧١٠e0, this.f٥٧٣٢p0, this.J[1], this.f٥٧٢٥m, this.C, this.f٥٧٤٧x, this.E, this.N0[1]);
        C0(sb, "    dimensionRatio", this.f٥٧١٢f0, this.f٥٧١٤g0);
        A0(sb, "    horizontalBias", this.f٥٧٣٤q0, U0);
        A0(sb, "    verticalBias", this.f٥٧٣٦r0, U0);
        B0(sb, "    horizontalChainStyle", this.J0, 0);
        B0(sb, "    verticalChainStyle", this.K0, 0);
        sb.append("  }");
    }

    public void Q0(float f10) {
        this.f٥٧٣٤q0 = f10;
    }

    public void R0(int i10) {
        this.J0 = i10;
    }

    public void S0(int i10, int i11) {
        this.f٥٧١٦h0 = i10;
        int i12 = i11 - i10;
        this.f٥٧٠٨d0 = i12;
        int i13 = this.f٥٧٣٠o0;
        if (i12 < i13) {
            this.f٥٧٠٨d0 = i13;
        }
    }

    public float T() {
        return this.f٥٧٣٦r0;
    }

    public void T0(b bVar) {
        this.f٥٧٠٤b0[0] = bVar;
    }

    public int U() {
        return this.K0;
    }

    public void U0(int i10, int i11, int i12, float f10) {
        this.f٥٧٤٥w = i10;
        this.f٥٧٥١z = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.A = i12;
        this.f٥٧٠٠B = f10;
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS && f10 < 1.0f && i10 == 0) {
            this.f٥٧٤٥w = 2;
        }
    }

    public b V() {
        return this.f٥٧٠٤b0[1];
    }

    public void V0(float f10) {
        this.N0[0] = f10;
    }

    public int W() {
        int i10;
        if (this.Q != null) {
            i10 = this.R.f٥٦٨٦g;
        } else {
            i10 = 0;
        }
        if (this.S != null) {
            return i10 + this.T.f٥٦٨٦g;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W0(int i10, boolean z10) {
        this.f٥٧٠٢a0[i10] = z10;
    }

    public int X() {
        return this.f٥٧٤٢u0;
    }

    public void X0(boolean z10) {
        this.M = z10;
    }

    public int Y() {
        if (this.f٥٧٤٢u0 == 8) {
            return 0;
        }
        return this.f٥٧٠٨d0;
    }

    public void Y0(boolean z10) {
        this.N = z10;
    }

    public int Z() {
        e eVar = this.f٥٧٠٦c0;
        if (eVar != null && (eVar instanceof f)) {
            return ((f) eVar).f٥٧٦٢c1 + this.f٥٧١٦h0;
        }
        return this.f٥٧١٦h0;
    }

    public void Z0(int i10, int i11) {
        this.O = i10;
        this.P = i11;
        c1(false);
    }

    public int a0() {
        e eVar = this.f٥٧٠٦c0;
        if (eVar != null && (eVar instanceof f)) {
            return ((f) eVar).f٥٧٦٣d1 + this.f٥٧١٨i0;
        }
        return this.f٥٧١٨i0;
    }

    public void a1(int i10) {
        this.J[1] = i10;
    }

    public boolean b0() {
        return this.L;
    }

    public void b1(int i10) {
        this.J[0] = i10;
    }

    public boolean c0(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        if (i10 == 0) {
            if (this.Q.f٥٦٨٥f != null) {
                i14 = 1;
            } else {
                i14 = 0;
            }
            if (this.S.f٥٦٨٥f != null) {
                i15 = 1;
            } else {
                i15 = 0;
            }
            if (i14 + i15 >= 2) {
                return false;
            }
            return true;
        }
        if (this.R.f٥٦٨٥f != null) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (this.T.f٥٦٨٥f != null) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        int i16 = i11 + i12;
        if (this.U.f٥٦٨٥f != null) {
            i13 = 1;
        } else {
            i13 = 0;
        }
        if (i16 + i13 >= 2) {
            return false;
        }
        return true;
    }

    public void c1(boolean z10) {
        this.f٥٧١٧i = z10;
    }

    public boolean d0() {
        int size = this.Z.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((d) this.Z.get(i10)).m()) {
                return true;
            }
        }
        return false;
    }

    public void d1(int i10) {
        if (i10 < 0) {
            this.f٥٧٣٢p0 = 0;
        } else {
            this.f٥٧٣٢p0 = i10;
        }
    }

    public void e(f fVar, z1.d dVar, HashSet hashSet, int i10, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            k.a(fVar, dVar, this);
            hashSet.remove(this);
            g(dVar, fVar.Y1(64));
        }
        if (i10 == 0) {
            HashSet d10 = this.Q.d();
            if (d10 != null) {
                Iterator it = d10.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f٥٦٨٣d.e(fVar, dVar, hashSet, i10, true);
                }
            }
            HashSet d11 = this.S.d();
            if (d11 != null) {
                Iterator it2 = d11.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).f٥٦٨٣d.e(fVar, dVar, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet d12 = this.R.d();
        if (d12 != null) {
            Iterator it3 = d12.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).f٥٦٨٣d.e(fVar, dVar, hashSet, i10, true);
            }
        }
        HashSet d13 = this.T.d();
        if (d13 != null) {
            Iterator it4 = d13.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).f٥٦٨٣d.e(fVar, dVar, hashSet, i10, true);
            }
        }
        HashSet d14 = this.U.d();
        if (d14 != null) {
            Iterator it5 = d14.iterator();
            while (it5.hasNext()) {
                ((d) it5.next()).f٥٦٨٣d.e(fVar, dVar, hashSet, i10, true);
            }
        }
    }

    public boolean e0() {
        if (this.f٥٧٢٣l == -1 && this.f٥٧٢٥m == -1) {
            return false;
        }
        return true;
    }

    public void e1(int i10) {
        if (i10 < 0) {
            this.f٥٧٣٠o0 = 0;
        } else {
            this.f٥٧٣٠o0 = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        if (!(this instanceof m) && !(this instanceof h)) {
            return false;
        }
        return true;
    }

    public boolean f0(int i10, int i11) {
        d dVar;
        d dVar2;
        if (i10 == 0) {
            d dVar3 = this.Q.f٥٦٨٥f;
            if (dVar3 != null && dVar3.n() && (dVar2 = this.S.f٥٦٨٥f) != null && dVar2.n() && (this.S.f٥٦٨٥f.e() - this.S.f()) - (this.Q.f٥٦٨٥f.e() + this.Q.f()) >= i11) {
                return true;
            }
            return false;
        }
        d dVar4 = this.R.f٥٦٨٥f;
        if (dVar4 != null && dVar4.n() && (dVar = this.T.f٥٦٨٥f) != null && dVar.n() && (this.T.f٥٦٨٥f.e() - this.T.f()) - (this.R.f٥٦٨٥f.e() + this.R.f()) >= i11) {
            return true;
        }
        return false;
        return false;
    }

    public void f1(int i10, int i11) {
        this.f٥٧١٦h0 = i10;
        this.f٥٧١٨i0 = i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(z1.d dVar, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        e eVar;
        e eVar2;
        boolean z14;
        boolean z15;
        int i10;
        int i11;
        int i12;
        int i13;
        b bVar;
        b bVar2;
        int i14;
        boolean z16;
        b bVar3;
        int i15;
        boolean z17;
        float f10;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z18;
        int i22;
        boolean z19;
        boolean z20;
        b bVar4;
        b bVar5;
        boolean z21;
        int i23;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        b bVar6;
        b bVar7;
        z1.i iVar;
        z1.i iVar2;
        z1.i iVar3;
        z1.i iVar4;
        z1.i iVar5;
        boolean z26;
        int i24;
        int i25;
        char c10;
        e eVar3;
        z1.d dVar2;
        z1.i iVar6;
        z1.i iVar7;
        z1.i iVar8;
        boolean z27;
        boolean z28;
        z1.i iVar9;
        z1.i iVar10;
        boolean z29;
        z1.i iVar11;
        z1.i iVar12;
        boolean z30;
        b[] bVarArr;
        boolean z31;
        e eVar4;
        z1.i iVar13;
        e eVar5;
        z1.i iVar14;
        b[] bVarArr2;
        boolean z32;
        d2.l lVar;
        d2.f fVar;
        int i26;
        int i27;
        boolean k02;
        boolean m02;
        d2.l lVar2;
        d2.n nVar;
        d2.f fVar2;
        boolean[] zArr;
        boolean z33;
        boolean z34;
        z1.i q10 = dVar.q(this.Q);
        z1.i q11 = dVar.q(this.S);
        z1.i q12 = dVar.q(this.R);
        z1.i q13 = dVar.q(this.T);
        z1.i q14 = dVar.q(this.U);
        e eVar6 = this.f٥٧٠٦c0;
        if (eVar6 != null) {
            if (eVar6 != null && eVar6.f٥٧٠٤b0[0] == b.WRAP_CONTENT) {
                z33 = true;
            } else {
                z33 = false;
            }
            if (eVar6 != null && eVar6.f٥٧٠٤b0[1] == b.WRAP_CONTENT) {
                z34 = true;
            } else {
                z34 = false;
            }
            int i28 = this.f٥٧٤٣v;
            if (i28 != 1) {
                if (i28 != 2) {
                    if (i28 != 3) {
                        z12 = z34;
                        z11 = z33;
                    }
                } else {
                    z12 = z34;
                    z11 = false;
                }
                if (this.f٥٧٤٢u0 == 8 && !this.f٥٧٤٤v0 && !d0()) {
                    zArr = this.f٥٧٠٢a0;
                    if (!zArr[0] && !zArr[1]) {
                        return;
                    }
                }
                z13 = this.f٥٧٣١p;
                if (!z13 || this.f٥٧٣٣q) {
                    if (z13) {
                        dVar.f(q10, this.f٥٧١٦h0);
                        dVar.f(q11, this.f٥٧١٦h0 + this.f٥٧٠٨d0);
                        if (z11 && (eVar2 = this.f٥٧٠٦c0) != null) {
                            if (this.f٥٧٢١k) {
                                f fVar3 = (f) eVar2;
                                fVar3.D1(this.Q);
                                fVar3.C1(this.S);
                            } else {
                                dVar.h(dVar.q(eVar2.S), q11, 0, 5);
                            }
                        }
                    }
                    if (this.f٥٧٣٣q) {
                        dVar.f(q12, this.f٥٧١٨i0);
                        dVar.f(q13, this.f٥٧١٨i0 + this.f٥٧١٠e0);
                        if (this.U.m()) {
                            dVar.f(q14, this.f٥٧١٨i0 + this.f٥٧٢٨n0);
                        }
                        if (z12 && (eVar = this.f٥٧٠٦c0) != null) {
                            if (this.f٥٧٢١k) {
                                f fVar4 = (f) eVar;
                                fVar4.I1(this.R);
                                fVar4.H1(this.T);
                            } else {
                                dVar.h(dVar.q(eVar.T), q13, 0, 5);
                            }
                        }
                    }
                    if (this.f٥٧٣١p && this.f٥٧٣٣q) {
                        this.f٥٧٣١p = false;
                        this.f٥٧٣٣q = false;
                        return;
                    }
                }
                boolean z35 = z1.d.f١٩٣٥٧r;
                if (z10 && (lVar2 = this.f٥٧٠٩e) != null && (nVar = this.f٥٧١١f) != null) {
                    fVar2 = lVar2.f١٣٦٢٨h;
                    if (fVar2.f١٣٥٧٧j && lVar2.f١٣٦٢٩i.f١٣٥٧٧j && nVar.f١٣٦٢٨h.f١٣٥٧٧j && nVar.f١٣٦٢٩i.f١٣٥٧٧j) {
                        dVar.f(q10, fVar2.f١٣٥٧٤g);
                        dVar.f(q11, this.f٥٧٠٩e.f١٣٦٢٩i.f١٣٥٧٤g);
                        dVar.f(q12, this.f٥٧١١f.f١٣٦٢٨h.f١٣٥٧٤g);
                        dVar.f(q13, this.f٥٧١١f.f١٣٦٢٩i.f١٣٥٧٤g);
                        dVar.f(q14, this.f٥٧١١f.f١٣٦٠٣k.f١٣٥٧٤g);
                        if (this.f٥٧٠٦c0 != null) {
                            if (z11 && this.f٥٧١٣g[0] && !k0()) {
                                dVar.h(dVar.q(this.f٥٧٠٦c0.S), q11, 0, 8);
                            }
                            if (z12 && this.f٥٧١٣g[1] && !m0()) {
                                dVar.h(dVar.q(this.f٥٧٠٦c0.T), q13, 0, 8);
                            }
                        }
                        this.f٥٧٣١p = false;
                        this.f٥٧٣٣q = false;
                        return;
                    }
                }
                if (this.f٥٧٠٦c0 != null) {
                    if (h0(0)) {
                        ((f) this.f٥٧٠٦c0).z1(this, 0);
                        k02 = true;
                    } else {
                        k02 = k0();
                    }
                    if (h0(1)) {
                        ((f) this.f٥٧٠٦c0).z1(this, 1);
                        m02 = true;
                    } else {
                        m02 = m0();
                    }
                    if (!k02 && z11 && this.f٥٧٤٢u0 != 8 && this.Q.f٥٦٨٥f == null && this.S.f٥٦٨٥f == null) {
                        dVar.h(dVar.q(this.f٥٧٠٦c0.S), q11, 0, 1);
                    }
                    if (!m02 && z12 && this.f٥٧٤٢u0 != 8 && this.R.f٥٦٨٥f == null && this.T.f٥٦٨٥f == null && this.U == null) {
                        dVar.h(dVar.q(this.f٥٧٠٦c0.T), q13, 0, 1);
                    }
                    z15 = k02;
                    z14 = m02;
                } else {
                    z14 = false;
                    z15 = false;
                }
                i10 = this.f٥٧٠٨d0;
                i11 = this.f٥٧٣٠o0;
                if (i10 >= i11) {
                    i11 = i10;
                }
                i12 = this.f٥٧١٠e0;
                i13 = this.f٥٧٣٢p0;
                if (i12 >= i13) {
                    i13 = i12;
                }
                b[] bVarArr3 = this.f٥٧٠٤b0;
                bVar = bVarArr3[0];
                bVar2 = b.MATCH_CONSTRAINT;
                i14 = i11;
                if (bVar != bVar2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar3 = bVarArr3[1];
                i15 = i13;
                if (bVar3 != bVar2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                int i29 = this.f٥٧١٤g0;
                this.H = i29;
                f10 = this.f٥٧١٢f0;
                this.I = f10;
                i16 = this.f٥٧٤٥w;
                i17 = this.f٥٧٤٧x;
                if (f10 <= DownloadProgress.UNKNOWN_PROGRESS && this.f٥٧٤٢u0 != 8) {
                    if (bVar == bVar2 && i16 == 0) {
                        i16 = 3;
                    }
                    if (bVar3 == bVar2 && i17 == 0) {
                        i17 = 3;
                    }
                    if (bVar == bVar2 && bVar3 == bVar2) {
                        i27 = 3;
                        if (i16 == 3 && i17 == 3) {
                            s1(z11, z12, z16, z17);
                            i18 = i16;
                            i19 = i17;
                            i20 = i14;
                            i21 = i15;
                            z18 = true;
                        }
                    } else {
                        i27 = 3;
                    }
                    if (bVar == bVar2 && i16 == i27) {
                        this.H = 0;
                        i20 = (int) (f10 * i12);
                        if (bVar3 != bVar2) {
                            i19 = i17;
                            i21 = i15;
                            z18 = false;
                            i18 = 4;
                        } else {
                            i18 = i16;
                            i19 = i17;
                            i21 = i15;
                            z18 = true;
                        }
                    } else {
                        if (bVar3 == bVar2 && i17 == i27) {
                            this.H = 1;
                            if (i29 == -1) {
                                this.I = 1.0f / f10;
                            }
                            i21 = (int) (this.I * i10);
                            i18 = i16;
                            if (bVar != bVar2) {
                                i20 = i14;
                                z18 = false;
                                i19 = 4;
                            } else {
                                i19 = i17;
                                i20 = i14;
                                z18 = true;
                            }
                        }
                        i18 = i16;
                        i19 = i17;
                        i20 = i14;
                        i21 = i15;
                        z18 = true;
                    }
                } else {
                    i18 = i16;
                    i19 = i17;
                    i20 = i14;
                    i21 = i15;
                    z18 = false;
                }
                int[] iArr = this.f٥٧٤٩y;
                iArr[0] = i18;
                iArr[1] = i19;
                this.f٥٧١٥h = z18;
                if (z18) {
                    int i30 = this.H;
                    i22 = -1;
                    if (i30 == 0 || i30 == -1) {
                        z19 = true;
                        if (!z18 && ((i26 = this.H) == 1 || i26 == i22)) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        bVar4 = this.f٥٧٠٤b0[0];
                        bVar5 = b.WRAP_CONTENT;
                        if (bVar4 != bVar5 && (this instanceof f)) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        if (!z21) {
                            i23 = 0;
                        } else {
                            i23 = i20;
                        }
                        z22 = !this.X.o();
                        boolean[] zArr2 = this.f٥٧٠٢a0;
                        z23 = zArr2[0];
                        boolean z36 = zArr2[1];
                        if (this.f٥٧٣٩t != 2 && !this.f٥٧٣١p) {
                            if (z10 && (lVar = this.f٥٧٠٩e) != null) {
                                fVar = lVar.f١٣٦٢٨h;
                                if (fVar.f١٣٥٧٧j && lVar.f١٣٦٢٩i.f١٣٥٧٧j) {
                                    if (!z10) {
                                        dVar.f(q10, fVar.f١٣٥٧٤g);
                                        dVar.f(q11, this.f٥٧٠٩e.f١٣٦٢٩i.f١٣٥٧٤g);
                                        if (this.f٥٧٠٦c0 != null && z11 && this.f٥٧١٣g[0] && !k0()) {
                                            dVar.h(dVar.q(this.f٥٧٠٦c0.S), q11, 0, 8);
                                        }
                                        z24 = z11;
                                        z25 = z12;
                                        bVar6 = bVar2;
                                        bVar7 = bVar5;
                                        z26 = z18;
                                        iVar = q14;
                                        iVar2 = q13;
                                        iVar3 = q12;
                                        iVar4 = q11;
                                        iVar5 = q10;
                                        if (z10) {
                                            eVar3 = this;
                                            d2.n nVar2 = eVar3.f٥٧١١f;
                                            if (nVar2 != null) {
                                                d2.f fVar5 = nVar2.f١٣٦٢٨h;
                                                if (fVar5.f١٣٥٧٧j && nVar2.f١٣٦٢٩i.f١٣٥٧٧j) {
                                                    dVar2 = dVar;
                                                    iVar8 = iVar3;
                                                    dVar2.f(iVar8, fVar5.f١٣٥٧٤g);
                                                    iVar7 = iVar2;
                                                    dVar2.f(iVar7, eVar3.f٥٧١١f.f١٣٦٢٩i.f١٣٥٧٤g);
                                                    iVar6 = iVar;
                                                    dVar2.f(iVar6, eVar3.f٥٧١١f.f١٣٦٠٣k.f١٣٥٧٤g);
                                                    e eVar7 = eVar3.f٥٧٠٦c0;
                                                    if (eVar7 != null && !z14 && z25) {
                                                        c10 = 1;
                                                        if (eVar3.f٥٧١٣g[1]) {
                                                            i24 = 8;
                                                            i25 = 0;
                                                            dVar2.h(dVar2.q(eVar7.T), iVar7, 0, 8);
                                                        } else {
                                                            i24 = 8;
                                                            i25 = 0;
                                                        }
                                                    } else {
                                                        i24 = 8;
                                                        i25 = 0;
                                                        c10 = 1;
                                                    }
                                                    z27 = false;
                                                    if (eVar3.f٥٧٤١u != 2) {
                                                        z28 = false;
                                                    } else {
                                                        z28 = z27;
                                                    }
                                                    if (!z28 && !eVar3.f٥٧٣٣q) {
                                                        if (eVar3.f٥٧٠٤b0[c10] == bVar7 && (eVar3 instanceof f)) {
                                                            z29 = true;
                                                        } else {
                                                            z29 = false;
                                                        }
                                                        if (z29) {
                                                            i21 = 0;
                                                        }
                                                        e eVar8 = eVar3.f٥٧٠٦c0;
                                                        if (eVar8 != null) {
                                                            iVar11 = dVar2.q(eVar8.T);
                                                        } else {
                                                            iVar11 = null;
                                                        }
                                                        e eVar9 = eVar3.f٥٧٠٦c0;
                                                        if (eVar9 != null) {
                                                            iVar12 = dVar2.q(eVar9.R);
                                                        } else {
                                                            iVar12 = null;
                                                        }
                                                        if (eVar3.f٥٧٢٨n0 > 0 || eVar3.f٥٧٤٢u0 == i24) {
                                                            d dVar3 = eVar3.U;
                                                            if (dVar3.f٥٦٨٥f != null) {
                                                                dVar2.e(iVar6, iVar8, r(), i24);
                                                                dVar2.e(iVar6, dVar2.q(eVar3.U.f٥٦٨٥f), eVar3.U.f(), i24);
                                                                if (z25) {
                                                                    dVar2.h(iVar11, dVar2.q(eVar3.T), i25, 5);
                                                                }
                                                                z30 = false;
                                                                boolean z37 = eVar3.f٥٧١٣g[c10];
                                                                bVarArr = eVar3.f٥٧٠٤b0;
                                                                b bVar8 = bVarArr[c10];
                                                                d dVar4 = eVar3.R;
                                                                d dVar5 = eVar3.T;
                                                                int i31 = eVar3.f٥٧١٨i0;
                                                                int i32 = eVar3.f٥٧٣٢p0;
                                                                int i33 = eVar3.J[c10];
                                                                float f11 = eVar3.f٥٧٣٦r0;
                                                                if (bVarArr[0] != bVar6) {
                                                                    z31 = true;
                                                                } else {
                                                                    z31 = false;
                                                                }
                                                                iVar9 = iVar7;
                                                                iVar10 = iVar8;
                                                                i(dVar, false, z25, z24, z37, iVar12, iVar11, bVar8, z29, dVar4, dVar5, i31, i21, i32, i33, f11, z20, z31, z14, z15, z36, i19, i18, eVar3.C, eVar3.D, eVar3.E, z30);
                                                            } else if (eVar3.f٥٧٤٢u0 == i24) {
                                                                dVar2.e(iVar6, iVar8, dVar3.f(), i24);
                                                            } else {
                                                                dVar2.e(iVar6, iVar8, r(), i24);
                                                            }
                                                        }
                                                        z30 = z22;
                                                        boolean z372 = eVar3.f٥٧١٣g[c10];
                                                        bVarArr = eVar3.f٥٧٠٤b0;
                                                        b bVar82 = bVarArr[c10];
                                                        d dVar42 = eVar3.R;
                                                        d dVar52 = eVar3.T;
                                                        int i312 = eVar3.f٥٧١٨i0;
                                                        int i322 = eVar3.f٥٧٣٢p0;
                                                        int i332 = eVar3.J[c10];
                                                        float f112 = eVar3.f٥٧٣٦r0;
                                                        if (bVarArr[0] != bVar6) {
                                                        }
                                                        iVar9 = iVar7;
                                                        iVar10 = iVar8;
                                                        i(dVar, false, z25, z24, z372, iVar12, iVar11, bVar82, z29, dVar42, dVar52, i312, i21, i322, i332, f112, z20, z31, z14, z15, z36, i19, i18, eVar3.C, eVar3.D, eVar3.E, z30);
                                                    } else {
                                                        iVar9 = iVar7;
                                                        iVar10 = iVar8;
                                                    }
                                                    if (z26) {
                                                        if (this.H == 1) {
                                                            dVar.k(iVar9, iVar10, iVar4, iVar5, this.I, 8);
                                                        } else {
                                                            dVar.k(iVar4, iVar5, iVar9, iVar10, this.I, 8);
                                                        }
                                                    }
                                                    if (this.X.o()) {
                                                        dVar.b(this, this.X.j().h(), (float) Math.toRadians(this.K + 90.0f), this.X.f());
                                                    }
                                                    this.f٥٧٣١p = false;
                                                    this.f٥٧٣٣q = false;
                                                }
                                            }
                                            dVar2 = dVar;
                                            iVar6 = iVar;
                                            iVar7 = iVar2;
                                            iVar8 = iVar3;
                                            i24 = 8;
                                            i25 = 0;
                                            c10 = 1;
                                        } else {
                                            i24 = 8;
                                            i25 = 0;
                                            c10 = 1;
                                            eVar3 = this;
                                            dVar2 = dVar;
                                            iVar6 = iVar;
                                            iVar7 = iVar2;
                                            iVar8 = iVar3;
                                        }
                                        z27 = true;
                                        if (eVar3.f٥٧٤١u != 2) {
                                        }
                                        if (!z28) {
                                        }
                                        iVar9 = iVar7;
                                        iVar10 = iVar8;
                                        if (z26) {
                                        }
                                        if (this.X.o()) {
                                        }
                                        this.f٥٧٣١p = false;
                                        this.f٥٧٣٣q = false;
                                    }
                                }
                            }
                            eVar4 = this.f٥٧٠٦c0;
                            if (eVar4 == null) {
                                iVar13 = dVar.q(eVar4.S);
                            } else {
                                iVar13 = null;
                            }
                            eVar5 = this.f٥٧٠٦c0;
                            if (eVar5 == null) {
                                iVar14 = dVar.q(eVar5.Q);
                            } else {
                                iVar14 = null;
                            }
                            boolean z38 = this.f٥٧١٣g[0];
                            bVarArr2 = this.f٥٧٠٤b0;
                            b bVar9 = bVarArr2[0];
                            d dVar6 = this.Q;
                            d dVar7 = this.S;
                            int i34 = this.f٥٧١٦h0;
                            int i35 = this.f٥٧٣٠o0;
                            int i36 = this.J[0];
                            float f12 = this.f٥٧٣٤q0;
                            if (bVarArr2[1] != bVar2) {
                                z32 = true;
                            } else {
                                z32 = false;
                            }
                            z24 = z11;
                            z25 = z12;
                            bVar6 = bVar2;
                            iVar = q14;
                            iVar2 = q13;
                            iVar3 = q12;
                            iVar4 = q11;
                            bVar7 = bVar5;
                            iVar5 = q10;
                            z26 = z18;
                            i(dVar, true, z11, z12, z38, iVar14, iVar13, bVar9, z21, dVar6, dVar7, i34, i23, i35, i36, f12, z19, z32, z15, z14, z23, i18, i19, this.f٥٧٥١z, this.A, this.f٥٧٠٠B, z22);
                            if (z10) {
                            }
                            z27 = true;
                            if (eVar3.f٥٧٤١u != 2) {
                            }
                            if (!z28) {
                            }
                            iVar9 = iVar7;
                            iVar10 = iVar8;
                            if (z26) {
                            }
                            if (this.X.o()) {
                            }
                            this.f٥٧٣١p = false;
                            this.f٥٧٣٣q = false;
                        }
                        z24 = z11;
                        z25 = z12;
                        bVar6 = bVar2;
                        bVar7 = bVar5;
                        iVar = q14;
                        iVar2 = q13;
                        iVar3 = q12;
                        iVar4 = q11;
                        iVar5 = q10;
                        z26 = z18;
                        if (z10) {
                        }
                        z27 = true;
                        if (eVar3.f٥٧٤١u != 2) {
                        }
                        if (!z28) {
                        }
                        iVar9 = iVar7;
                        iVar10 = iVar8;
                        if (z26) {
                        }
                        if (this.X.o()) {
                        }
                        this.f٥٧٣١p = false;
                        this.f٥٧٣٣q = false;
                    }
                } else {
                    i22 = -1;
                }
                z19 = false;
                if (!z18) {
                }
                z20 = false;
                bVar4 = this.f٥٧٠٤b0[0];
                bVar5 = b.WRAP_CONTENT;
                if (bVar4 != bVar5) {
                }
                z21 = false;
                if (!z21) {
                }
                z22 = !this.X.o();
                boolean[] zArr22 = this.f٥٧٠٢a0;
                z23 = zArr22[0];
                boolean z362 = zArr22[1];
                if (this.f٥٧٣٩t != 2) {
                    if (z10) {
                        fVar = lVar.f١٣٦٢٨h;
                        if (fVar.f١٣٥٧٧j) {
                            if (!z10) {
                            }
                        }
                    }
                    eVar4 = this.f٥٧٠٦c0;
                    if (eVar4 == null) {
                    }
                    eVar5 = this.f٥٧٠٦c0;
                    if (eVar5 == null) {
                    }
                    boolean z382 = this.f٥٧١٣g[0];
                    bVarArr2 = this.f٥٧٠٤b0;
                    b bVar92 = bVarArr2[0];
                    d dVar62 = this.Q;
                    d dVar72 = this.S;
                    int i342 = this.f٥٧١٦h0;
                    int i352 = this.f٥٧٣٠o0;
                    int i362 = this.J[0];
                    float f122 = this.f٥٧٣٤q0;
                    if (bVarArr2[1] != bVar2) {
                    }
                    z24 = z11;
                    z25 = z12;
                    bVar6 = bVar2;
                    iVar = q14;
                    iVar2 = q13;
                    iVar3 = q12;
                    iVar4 = q11;
                    bVar7 = bVar5;
                    iVar5 = q10;
                    z26 = z18;
                    i(dVar, true, z11, z12, z382, iVar14, iVar13, bVar92, z21, dVar62, dVar72, i342, i23, i352, i362, f122, z19, z32, z15, z14, z23, i18, i19, this.f٥٧٥١z, this.A, this.f٥٧٠٠B, z22);
                    if (z10) {
                    }
                    z27 = true;
                    if (eVar3.f٥٧٤١u != 2) {
                    }
                    if (!z28) {
                    }
                    iVar9 = iVar7;
                    iVar10 = iVar8;
                    if (z26) {
                    }
                    if (this.X.o()) {
                    }
                    this.f٥٧٣١p = false;
                    this.f٥٧٣٣q = false;
                }
                z24 = z11;
                z25 = z12;
                bVar6 = bVar2;
                bVar7 = bVar5;
                iVar = q14;
                iVar2 = q13;
                iVar3 = q12;
                iVar4 = q11;
                iVar5 = q10;
                z26 = z18;
                if (z10) {
                }
                z27 = true;
                if (eVar3.f٥٧٤١u != 2) {
                }
                if (!z28) {
                }
                iVar9 = iVar7;
                iVar10 = iVar8;
                if (z26) {
                }
                if (this.X.o()) {
                }
                this.f٥٧٣١p = false;
                this.f٥٧٣٣q = false;
            }
            z11 = z33;
            z12 = false;
            if (this.f٥٧٤٢u0 == 8) {
                zArr = this.f٥٧٠٢a0;
                if (!zArr[0]) {
                    return;
                }
            }
            z13 = this.f٥٧٣١p;
            if (!z13) {
            }
            if (z13) {
            }
            if (this.f٥٧٣٣q) {
            }
            if (this.f٥٧٣١p) {
                this.f٥٧٣١p = false;
                this.f٥٧٣٣q = false;
                return;
            }
            boolean z352 = z1.d.f١٩٣٥٧r;
            if (z10) {
                fVar2 = lVar2.f١٣٦٢٨h;
                if (fVar2.f١٣٥٧٧j) {
                    dVar.f(q10, fVar2.f١٣٥٧٤g);
                    dVar.f(q11, this.f٥٧٠٩e.f١٣٦٢٩i.f١٣٥٧٤g);
                    dVar.f(q12, this.f٥٧١١f.f١٣٦٢٨h.f١٣٥٧٤g);
                    dVar.f(q13, this.f٥٧١١f.f١٣٦٢٩i.f١٣٥٧٤g);
                    dVar.f(q14, this.f٥٧١١f.f١٣٦٠٣k.f١٣٥٧٤g);
                    if (this.f٥٧٠٦c0 != null) {
                    }
                    this.f٥٧٣١p = false;
                    this.f٥٧٣٣q = false;
                    return;
                }
            }
            if (this.f٥٧٠٦c0 != null) {
            }
            i10 = this.f٥٧٠٨d0;
            i11 = this.f٥٧٣٠o0;
            if (i10 >= i11) {
            }
            i12 = this.f٥٧١٠e0;
            i13 = this.f٥٧٣٢p0;
            if (i12 >= i13) {
            }
            b[] bVarArr32 = this.f٥٧٠٤b0;
            bVar = bVarArr32[0];
            bVar2 = b.MATCH_CONSTRAINT;
            i14 = i11;
            if (bVar != bVar2) {
            }
            bVar3 = bVarArr32[1];
            i15 = i13;
            if (bVar3 != bVar2) {
            }
            int i292 = this.f٥٧١٤g0;
            this.H = i292;
            f10 = this.f٥٧١٢f0;
            this.I = f10;
            i16 = this.f٥٧٤٥w;
            i17 = this.f٥٧٤٧x;
            if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
            }
            i18 = i16;
            i19 = i17;
            i20 = i14;
            i21 = i15;
            z18 = false;
            int[] iArr2 = this.f٥٧٤٩y;
            iArr2[0] = i18;
            iArr2[1] = i19;
            this.f٥٧١٥h = z18;
            if (z18) {
            }
            z19 = false;
            if (!z18) {
            }
            z20 = false;
            bVar4 = this.f٥٧٠٤b0[0];
            bVar5 = b.WRAP_CONTENT;
            if (bVar4 != bVar5) {
            }
            z21 = false;
            if (!z21) {
            }
            z22 = !this.X.o();
            boolean[] zArr222 = this.f٥٧٠٢a0;
            z23 = zArr222[0];
            boolean z3622 = zArr222[1];
            if (this.f٥٧٣٩t != 2) {
            }
            z24 = z11;
            z25 = z12;
            bVar6 = bVar2;
            bVar7 = bVar5;
            iVar = q14;
            iVar2 = q13;
            iVar3 = q12;
            iVar4 = q11;
            iVar5 = q10;
            z26 = z18;
            if (z10) {
            }
            z27 = true;
            if (eVar3.f٥٧٤١u != 2) {
            }
            if (!z28) {
            }
            iVar9 = iVar7;
            iVar10 = iVar8;
            if (z26) {
            }
            if (this.X.o()) {
            }
            this.f٥٧٣١p = false;
            this.f٥٧٣٣q = false;
        }
        z11 = false;
        z12 = false;
        if (this.f٥٧٤٢u0 == 8) {
        }
        z13 = this.f٥٧٣١p;
        if (!z13) {
        }
        if (z13) {
        }
        if (this.f٥٧٣٣q) {
        }
        if (this.f٥٧٣١p) {
        }
        boolean z3522 = z1.d.f١٩٣٥٧r;
        if (z10) {
        }
        if (this.f٥٧٠٦c0 != null) {
        }
        i10 = this.f٥٧٠٨d0;
        i11 = this.f٥٧٣٠o0;
        if (i10 >= i11) {
        }
        i12 = this.f٥٧١٠e0;
        i13 = this.f٥٧٣٢p0;
        if (i12 >= i13) {
        }
        b[] bVarArr322 = this.f٥٧٠٤b0;
        bVar = bVarArr322[0];
        bVar2 = b.MATCH_CONSTRAINT;
        i14 = i11;
        if (bVar != bVar2) {
        }
        bVar3 = bVarArr322[1];
        i15 = i13;
        if (bVar3 != bVar2) {
        }
        int i2922 = this.f٥٧١٤g0;
        this.H = i2922;
        f10 = this.f٥٧١٢f0;
        this.I = f10;
        i16 = this.f٥٧٤٥w;
        i17 = this.f٥٧٤٧x;
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
        }
        i18 = i16;
        i19 = i17;
        i20 = i14;
        i21 = i15;
        z18 = false;
        int[] iArr22 = this.f٥٧٤٩y;
        iArr22[0] = i18;
        iArr22[1] = i19;
        this.f٥٧١٥h = z18;
        if (z18) {
        }
        z19 = false;
        if (!z18) {
        }
        z20 = false;
        bVar4 = this.f٥٧٠٤b0[0];
        bVar5 = b.WRAP_CONTENT;
        if (bVar4 != bVar5) {
        }
        z21 = false;
        if (!z21) {
        }
        z22 = !this.X.o();
        boolean[] zArr2222 = this.f٥٧٠٢a0;
        z23 = zArr2222[0];
        boolean z36222 = zArr2222[1];
        if (this.f٥٧٣٩t != 2) {
        }
        z24 = z11;
        z25 = z12;
        bVar6 = bVar2;
        bVar7 = bVar5;
        iVar = q14;
        iVar2 = q13;
        iVar3 = q12;
        iVar4 = q11;
        iVar5 = q10;
        z26 = z18;
        if (z10) {
        }
        z27 = true;
        if (eVar3.f٥٧٤١u != 2) {
        }
        if (!z28) {
        }
        iVar9 = iVar7;
        iVar10 = iVar8;
        if (z26) {
        }
        if (this.X.o()) {
        }
        this.f٥٧٣١p = false;
        this.f٥٧٣٣q = false;
    }

    public void g0(d.b bVar, e eVar, d.b bVar2, int i10, int i11) {
        q(bVar).b(eVar.q(bVar2), i10, i11, true);
    }

    public void g1(e eVar) {
        this.f٥٧٠٦c0 = eVar;
    }

    public boolean h() {
        if (this.f٥٧٤٢u0 != 8) {
            return true;
        }
        return false;
    }

    public void h1(float f10) {
        this.f٥٧٣٦r0 = f10;
    }

    public boolean i0() {
        return this.f٥٧٣٥r;
    }

    public void i1(int i10) {
        this.K0 = i10;
    }

    public void j(d.b bVar, e eVar, d.b bVar2) {
        k(bVar, eVar, bVar2, 0);
    }

    public boolean j0(int i10) {
        return this.f٥٧٠٢a0[i10];
    }

    public void j1(int i10, int i11) {
        this.f٥٧١٨i0 = i10;
        int i12 = i11 - i10;
        this.f٥٧١٠e0 = i12;
        int i13 = this.f٥٧٣٢p0;
        if (i12 < i13) {
            this.f٥٧١٠e0 = i13;
        }
    }

    public void k(d.b bVar, e eVar, d.b bVar2, int i10) {
        d.b bVar3;
        d.b bVar4;
        boolean z10;
        d.b bVar5 = d.b.CENTER;
        if (bVar == bVar5) {
            if (bVar2 == bVar5) {
                d.b bVar6 = d.b.LEFT;
                d q10 = q(bVar6);
                d.b bVar7 = d.b.RIGHT;
                d q11 = q(bVar7);
                d.b bVar8 = d.b.TOP;
                d q12 = q(bVar8);
                d.b bVar9 = d.b.BOTTOM;
                d q13 = q(bVar9);
                boolean z11 = true;
                if ((q10 != null && q10.o()) || (q11 != null && q11.o())) {
                    z10 = false;
                } else {
                    k(bVar6, eVar, bVar6, 0);
                    k(bVar7, eVar, bVar7, 0);
                    z10 = true;
                }
                if ((q12 != null && q12.o()) || (q13 != null && q13.o())) {
                    z11 = false;
                } else {
                    k(bVar8, eVar, bVar8, 0);
                    k(bVar9, eVar, bVar9, 0);
                }
                if (z10 && z11) {
                    q(bVar5).a(eVar.q(bVar5), 0);
                    return;
                }
                if (z10) {
                    d.b bVar10 = d.b.CENTER_X;
                    q(bVar10).a(eVar.q(bVar10), 0);
                    return;
                } else {
                    if (z11) {
                        d.b bVar11 = d.b.CENTER_Y;
                        q(bVar11).a(eVar.q(bVar11), 0);
                        return;
                    }
                    return;
                }
            }
            d.b bVar12 = d.b.LEFT;
            if (bVar2 != bVar12 && bVar2 != d.b.RIGHT) {
                d.b bVar13 = d.b.TOP;
                if (bVar2 == bVar13 || bVar2 == d.b.BOTTOM) {
                    k(bVar13, eVar, bVar2, 0);
                    k(d.b.BOTTOM, eVar, bVar2, 0);
                    q(bVar5).a(eVar.q(bVar2), 0);
                    return;
                }
                return;
            }
            k(bVar12, eVar, bVar2, 0);
            k(d.b.RIGHT, eVar, bVar2, 0);
            q(bVar5).a(eVar.q(bVar2), 0);
            return;
        }
        d.b bVar14 = d.b.CENTER_X;
        if (bVar == bVar14 && (bVar2 == (bVar4 = d.b.LEFT) || bVar2 == d.b.RIGHT)) {
            d q14 = q(bVar4);
            d q15 = eVar.q(bVar2);
            d q16 = q(d.b.RIGHT);
            q14.a(q15, 0);
            q16.a(q15, 0);
            q(bVar14).a(q15, 0);
            return;
        }
        d.b bVar15 = d.b.CENTER_Y;
        if (bVar == bVar15 && (bVar2 == (bVar3 = d.b.TOP) || bVar2 == d.b.BOTTOM)) {
            d q17 = eVar.q(bVar2);
            q(bVar3).a(q17, 0);
            q(d.b.BOTTOM).a(q17, 0);
            q(bVar15).a(q17, 0);
            return;
        }
        if (bVar == bVar14 && bVar2 == bVar14) {
            d.b bVar16 = d.b.LEFT;
            q(bVar16).a(eVar.q(bVar16), 0);
            d.b bVar17 = d.b.RIGHT;
            q(bVar17).a(eVar.q(bVar17), 0);
            q(bVar14).a(eVar.q(bVar2), 0);
            return;
        }
        if (bVar == bVar15 && bVar2 == bVar15) {
            d.b bVar18 = d.b.TOP;
            q(bVar18).a(eVar.q(bVar18), 0);
            d.b bVar19 = d.b.BOTTOM;
            q(bVar19).a(eVar.q(bVar19), 0);
            q(bVar15).a(eVar.q(bVar2), 0);
            return;
        }
        d q18 = q(bVar);
        d q19 = eVar.q(bVar2);
        if (q18.p(q19)) {
            d.b bVar20 = d.b.BASELINE;
            if (bVar == bVar20) {
                d q20 = q(d.b.TOP);
                d q21 = q(d.b.BOTTOM);
                if (q20 != null) {
                    q20.q();
                }
                if (q21 != null) {
                    q21.q();
                }
            } else if (bVar != d.b.TOP && bVar != d.b.BOTTOM) {
                if (bVar == d.b.LEFT || bVar == d.b.RIGHT) {
                    d q22 = q(bVar5);
                    if (q22.j() != q19) {
                        q22.q();
                    }
                    d g10 = q(bVar).g();
                    d q23 = q(bVar14);
                    if (q23.o()) {
                        g10.q();
                        q23.q();
                    }
                }
            } else {
                d q24 = q(bVar20);
                if (q24 != null) {
                    q24.q();
                }
                d q25 = q(bVar5);
                if (q25.j() != q19) {
                    q25.q();
                }
                d g11 = q(bVar).g();
                d q26 = q(bVar15);
                if (q26.o()) {
                    g11.q();
                    q26.q();
                }
            }
            q18.a(q19, i10);
        }
    }

    public boolean k0() {
        d dVar = this.Q;
        d dVar2 = dVar.f٥٦٨٥f;
        if (dVar2 == null || dVar2.f٥٦٨٥f != dVar) {
            d dVar3 = this.S;
            d dVar4 = dVar3.f٥٦٨٥f;
            if (dVar4 != null && dVar4.f٥٦٨٥f == dVar3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public void k1(b bVar) {
        this.f٥٧٠٤b0[1] = bVar;
    }

    public void l(d dVar, d dVar2, int i10) {
        if (dVar.h() == this) {
            k(dVar.k(), dVar2.h(), dVar2.k(), i10);
        }
    }

    public boolean l0() {
        return this.M;
    }

    public void l1(int i10, int i11, int i12, float f10) {
        this.f٥٧٤٧x = i10;
        this.C = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.D = i12;
        this.E = f10;
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS && f10 < 1.0f && i10 == 0) {
            this.f٥٧٤٧x = 2;
        }
    }

    public void m(e eVar, float f10, int i10) {
        d.b bVar = d.b.CENTER;
        g0(bVar, eVar, bVar, i10, 0);
        this.K = f10;
    }

    public boolean m0() {
        d dVar = this.R;
        d dVar2 = dVar.f٥٦٨٥f;
        if (dVar2 == null || dVar2.f٥٦٨٥f != dVar) {
            d dVar3 = this.T;
            d dVar4 = dVar3.f٥٦٨٥f;
            if (dVar4 != null && dVar4.f٥٦٨٥f == dVar3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public void m1(float f10) {
        this.N0[1] = f10;
    }

    public void n(e eVar, HashMap hashMap) {
        e eVar2;
        e eVar3;
        this.f٥٧٣٩t = eVar.f٥٧٣٩t;
        this.f٥٧٤١u = eVar.f٥٧٤١u;
        this.f٥٧٤٥w = eVar.f٥٧٤٥w;
        this.f٥٧٤٧x = eVar.f٥٧٤٧x;
        int[] iArr = this.f٥٧٤٩y;
        int[] iArr2 = eVar.f٥٧٤٩y;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.f٥٧٥١z = eVar.f٥٧٥١z;
        this.A = eVar.A;
        this.C = eVar.C;
        this.D = eVar.D;
        this.E = eVar.E;
        this.F = eVar.F;
        this.G = eVar.G;
        this.H = eVar.H;
        this.I = eVar.I;
        int[] iArr3 = eVar.J;
        this.J = Arrays.copyOf(iArr3, iArr3.length);
        this.K = eVar.K;
        this.L = eVar.L;
        this.M = eVar.M;
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.f٥٧٠٤b0 = (b[]) Arrays.copyOf(this.f٥٧٠٤b0, 2);
        e eVar4 = null;
        if (this.f٥٧٠٦c0 == null) {
            eVar2 = null;
        } else {
            eVar2 = (e) hashMap.get(eVar.f٥٧٠٦c0);
        }
        this.f٥٧٠٦c0 = eVar2;
        this.f٥٧٠٨d0 = eVar.f٥٧٠٨d0;
        this.f٥٧١٠e0 = eVar.f٥٧١٠e0;
        this.f٥٧١٢f0 = eVar.f٥٧١٢f0;
        this.f٥٧١٤g0 = eVar.f٥٧١٤g0;
        this.f٥٧١٦h0 = eVar.f٥٧١٦h0;
        this.f٥٧١٨i0 = eVar.f٥٧١٨i0;
        this.f٥٧٢٠j0 = eVar.f٥٧٢٠j0;
        this.f٥٧٢٢k0 = eVar.f٥٧٢٢k0;
        this.f٥٧٢٤l0 = eVar.f٥٧٢٤l0;
        this.f٥٧٢٦m0 = eVar.f٥٧٢٦m0;
        this.f٥٧٢٨n0 = eVar.f٥٧٢٨n0;
        this.f٥٧٣٠o0 = eVar.f٥٧٣٠o0;
        this.f٥٧٣٢p0 = eVar.f٥٧٣٢p0;
        this.f٥٧٣٤q0 = eVar.f٥٧٣٤q0;
        this.f٥٧٣٦r0 = eVar.f٥٧٣٦r0;
        this.f٥٧٣٨s0 = eVar.f٥٧٣٨s0;
        this.f٥٧٤٠t0 = eVar.f٥٧٤٠t0;
        this.f٥٧٤٢u0 = eVar.f٥٧٤٢u0;
        this.f٥٧٤٤v0 = eVar.f٥٧٤٤v0;
        this.f٥٧٤٦w0 = eVar.f٥٧٤٦w0;
        this.f٥٧٤٨x0 = eVar.f٥٧٤٨x0;
        this.f٥٧٥٠y0 = eVar.f٥٧٥٠y0;
        this.f٥٧٥٢z0 = eVar.f٥٧٥٢z0;
        this.A0 = eVar.A0;
        this.B0 = eVar.B0;
        this.C0 = eVar.C0;
        this.D0 = eVar.D0;
        this.E0 = eVar.E0;
        this.F0 = eVar.F0;
        this.G0 = eVar.G0;
        this.H0 = eVar.H0;
        this.J0 = eVar.J0;
        this.K0 = eVar.K0;
        this.L0 = eVar.L0;
        this.M0 = eVar.M0;
        float[] fArr = this.N0;
        float[] fArr2 = eVar.N0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        e[] eVarArr = this.O0;
        e[] eVarArr2 = eVar.O0;
        eVarArr[0] = eVarArr2[0];
        eVarArr[1] = eVarArr2[1];
        e[] eVarArr3 = this.P0;
        e[] eVarArr4 = eVar.P0;
        eVarArr3[0] = eVarArr4[0];
        eVarArr3[1] = eVarArr4[1];
        e eVar5 = eVar.Q0;
        if (eVar5 == null) {
            eVar3 = null;
        } else {
            eVar3 = (e) hashMap.get(eVar5);
        }
        this.Q0 = eVar3;
        e eVar6 = eVar.R0;
        if (eVar6 != null) {
            eVar4 = (e) hashMap.get(eVar6);
        }
        this.R0 = eVar4;
    }

    public boolean n0() {
        return this.N;
    }

    public void n1(int i10) {
        this.f٥٧٤٢u0 = i10;
    }

    public void o(z1.d dVar) {
        dVar.q(this.Q);
        dVar.q(this.R);
        dVar.q(this.S);
        dVar.q(this.T);
        if (this.f٥٧٢٨n0 > 0) {
            dVar.q(this.U);
        }
    }

    public boolean o0() {
        if (this.f٥٧١٧i && this.f٥٧٤٢u0 != 8) {
            return true;
        }
        return false;
    }

    public void o1(int i10) {
        this.f٥٧٠٨d0 = i10;
        int i11 = this.f٥٧٣٠o0;
        if (i10 < i11) {
            this.f٥٧٠٨d0 = i11;
        }
    }

    public void p() {
        if (this.f٥٧٠٩e == null) {
            this.f٥٧٠٩e = new d2.l(this);
        }
        if (this.f٥٧١١f == null) {
            this.f٥٧١١f = new d2.n(this);
        }
    }

    public boolean p0() {
        if (!this.f٥٧٣١p && (!this.Q.n() || !this.S.n())) {
            return false;
        }
        return true;
    }

    public void p1(int i10) {
        if (i10 >= 0 && i10 <= 3) {
            this.f٥٧٤٣v = i10;
        }
    }

    public d q(d.b bVar) {
        switch (a.f٥٧٥٣a[bVar.ordinal()]) {
            case 1:
                return this.Q;
            case 2:
                return this.R;
            case 3:
                return this.S;
            case 4:
                return this.T;
            case 5:
                return this.U;
            case 6:
                return this.X;
            case 7:
                return this.V;
            case 8:
                return this.W;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public boolean q0() {
        if (!this.f٥٧٣٣q && (!this.R.n() || !this.T.n())) {
            return false;
        }
        return true;
    }

    public void q1(int i10) {
        this.f٥٧١٦h0 = i10;
    }

    public int r() {
        return this.f٥٧٢٨n0;
    }

    public boolean r0() {
        return this.f٥٧٣٧s;
    }

    public void r1(int i10) {
        this.f٥٧١٨i0 = i10;
    }

    public float s(int i10) {
        if (i10 == 0) {
            return this.f٥٧٣٤q0;
        }
        if (i10 == 1) {
            return this.f٥٧٣٦r0;
        }
        return -1.0f;
    }

    public void s0() {
        this.f٥٧٣٥r = true;
    }

    public void s1(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.H == -1) {
            if (z12 && !z13) {
                this.H = 0;
            } else if (!z12 && z13) {
                this.H = 1;
                if (this.f٥٧١٤g0 == -1) {
                    this.I = 1.0f / this.I;
                }
            }
        }
        if (this.H == 0 && (!this.R.o() || !this.T.o())) {
            this.H = 1;
        } else if (this.H == 1 && (!this.Q.o() || !this.S.o())) {
            this.H = 0;
        }
        if (this.H == -1 && (!this.R.o() || !this.T.o() || !this.Q.o() || !this.S.o())) {
            if (this.R.o() && this.T.o()) {
                this.H = 0;
            } else if (this.Q.o() && this.S.o()) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
        if (this.H == -1) {
            int i10 = this.f٥٧٥١z;
            if (i10 > 0 && this.C == 0) {
                this.H = 0;
            } else if (i10 == 0 && this.C > 0) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
    }

    public int t() {
        return a0() + this.f٥٧١٠e0;
    }

    public void t0() {
        this.f٥٧٣٧s = true;
    }

    public void t1(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean k10 = z10 & this.f٥٧٠٩e.k();
        boolean k11 = z11 & this.f٥٧١١f.k();
        d2.l lVar = this.f٥٧٠٩e;
        int i12 = lVar.f١٣٦٢٨h.f١٣٥٧٤g;
        d2.n nVar = this.f٥٧١١f;
        int i13 = nVar.f١٣٦٢٨h.f١٣٥٧٤g;
        int i14 = lVar.f١٣٦٢٩i.f١٣٥٧٤g;
        int i15 = nVar.f١٣٦٢٩i.f١٣٥٧٤g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (k10) {
            this.f٥٧١٦h0 = i12;
        }
        if (k11) {
            this.f٥٧١٨i0 = i13;
        }
        if (this.f٥٧٤٢u0 == 8) {
            this.f٥٧٠٨d0 = 0;
            this.f٥٧١٠e0 = 0;
            return;
        }
        if (k10) {
            if (this.f٥٧٠٤b0[0] == b.FIXED && i17 < (i11 = this.f٥٧٠٨d0)) {
                i17 = i11;
            }
            this.f٥٧٠٨d0 = i17;
            int i19 = this.f٥٧٣٠o0;
            if (i17 < i19) {
                this.f٥٧٠٨d0 = i19;
            }
        }
        if (k11) {
            if (this.f٥٧٠٤b0[1] == b.FIXED && i18 < (i10 = this.f٥٧١٠e0)) {
                i18 = i10;
            }
            this.f٥٧١٠e0 = i18;
            int i20 = this.f٥٧٣٢p0;
            if (i18 < i20) {
                this.f٥٧١٠e0 = i20;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f٥٧٤٨x0 == null) {
            str = "";
        } else {
            str = "type: " + this.f٥٧٤٨x0 + " ";
        }
        sb.append(str);
        if (this.f٥٧٤٦w0 != null) {
            str2 = "id: " + this.f٥٧٤٦w0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f٥٧١٦h0);
        sb.append(", ");
        sb.append(this.f٥٧١٨i0);
        sb.append(") - (");
        sb.append(this.f٥٧٠٨d0);
        sb.append(" x ");
        sb.append(this.f٥٧١٠e0);
        sb.append(")");
        return sb.toString();
    }

    public Object u() {
        return this.f٥٧٣٨s0;
    }

    public boolean u0() {
        b[] bVarArr = this.f٥٧٠٤b0;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        if (bVar != bVar2 || bVarArr[1] != bVar2) {
            return false;
        }
        return true;
    }

    public void u1(z1.d dVar, boolean z10) {
        d2.n nVar;
        d2.l lVar;
        int y10 = dVar.y(this.Q);
        int y11 = dVar.y(this.R);
        int y12 = dVar.y(this.S);
        int y13 = dVar.y(this.T);
        if (z10 && (lVar = this.f٥٧٠٩e) != null) {
            d2.f fVar = lVar.f١٣٦٢٨h;
            if (fVar.f١٣٥٧٧j) {
                d2.f fVar2 = lVar.f١٣٦٢٩i;
                if (fVar2.f١٣٥٧٧j) {
                    y10 = fVar.f١٣٥٧٤g;
                    y12 = fVar2.f١٣٥٧٤g;
                }
            }
        }
        if (z10 && (nVar = this.f٥٧١١f) != null) {
            d2.f fVar3 = nVar.f١٣٦٢٨h;
            if (fVar3.f١٣٥٧٧j) {
                d2.f fVar4 = nVar.f١٣٦٢٩i;
                if (fVar4.f١٣٥٧٧j) {
                    y11 = fVar3.f١٣٥٧٤g;
                    y13 = fVar4.f١٣٥٧٤g;
                }
            }
        }
        int i10 = y13 - y11;
        if (y12 - y10 < 0 || i10 < 0 || y10 == Integer.MIN_VALUE || y10 == Integer.MAX_VALUE || y11 == Integer.MIN_VALUE || y11 == Integer.MAX_VALUE || y12 == Integer.MIN_VALUE || y12 == Integer.MAX_VALUE || y13 == Integer.MIN_VALUE || y13 == Integer.MAX_VALUE) {
            y10 = 0;
            y13 = 0;
            y11 = 0;
            y12 = 0;
        }
        N0(y10, y11, y12, y13);
    }

    public String v() {
        return this.f٥٧٤٦w0;
    }

    public void v0() {
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.f٥٧٠٦c0 = null;
        this.K = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٥٧٠٨d0 = 0;
        this.f٥٧١٠e0 = 0;
        this.f٥٧١٢f0 = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٥٧١٤g0 = -1;
        this.f٥٧١٦h0 = 0;
        this.f٥٧١٨i0 = 0;
        this.f٥٧٢٤l0 = 0;
        this.f٥٧٢٦m0 = 0;
        this.f٥٧٢٨n0 = 0;
        this.f٥٧٣٠o0 = 0;
        this.f٥٧٣٢p0 = 0;
        float f10 = U0;
        this.f٥٧٣٤q0 = f10;
        this.f٥٧٣٦r0 = f10;
        b[] bVarArr = this.f٥٧٠٤b0;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f٥٧٣٨s0 = null;
        this.f٥٧٤٠t0 = 0;
        this.f٥٧٤٢u0 = 0;
        this.f٥٧٤٨x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] fArr = this.N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f٥٧٣٩t = -1;
        this.f٥٧٤١u = -1;
        int[] iArr = this.J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f٥٧٤٥w = 0;
        this.f٥٧٤٧x = 0;
        this.f٥٧٠٠B = 1.0f;
        this.E = 1.0f;
        this.A = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.f٥٧٥١z = 0;
        this.C = 0;
        this.f٥٧١٥h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] zArr = this.f٥٧١٣g;
        zArr[0] = true;
        zArr[1] = true;
        this.N = false;
        boolean[] zArr2 = this.f٥٧٠٢a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f٥٧١٧i = true;
        int[] iArr2 = this.f٥٧٤٩y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f٥٧٢٣l = -1;
        this.f٥٧٢٥m = -1;
    }

    public b w(int i10) {
        if (i10 == 0) {
            return C();
        }
        if (i10 == 1) {
            return V();
        }
        return null;
    }

    public void w0() {
        x0();
        h1(U0);
        Q0(U0);
    }

    public float x() {
        return this.f٥٧١٢f0;
    }

    public void x0() {
        e M = M();
        if (M != null && (M instanceof f) && ((f) M()).Q1()) {
            return;
        }
        int size = this.Z.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((d) this.Z.get(i10)).q();
        }
    }

    public int y() {
        return this.f٥٧١٤g0;
    }

    public void y0() {
        this.f٥٧٣١p = false;
        this.f٥٧٣٣q = false;
        this.f٥٧٣٥r = false;
        this.f٥٧٣٧s = false;
        int size = this.Z.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((d) this.Z.get(i10)).r();
        }
    }

    public int z() {
        if (this.f٥٧٤٢u0 == 8) {
            return 0;
        }
        return this.f٥٧١٠e0;
    }

    public void z0(z1.c cVar) {
        this.Q.s(cVar);
        this.R.s(cVar);
        this.S.s(cVar);
        this.T.s(cVar);
        this.U.s(cVar);
        this.X.s(cVar);
        this.V.s(cVar);
        this.W.s(cVar);
    }
}
