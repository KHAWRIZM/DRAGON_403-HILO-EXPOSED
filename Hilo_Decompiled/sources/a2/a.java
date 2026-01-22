package a2;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private final double[] f٩٦a;

    /* renamed from: b, reason: collision with root package name */
    C٠٠٠٠a[] f٩٧b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٩٨c = true;

    /* renamed from: a2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class C٠٠٠٠a {

        /* renamed from: s, reason: collision with root package name */
        private static double[] f٩٩s = new double[91];

        /* renamed from: a, reason: collision with root package name */
        double[] f١٠٠a;

        /* renamed from: b, reason: collision with root package name */
        double f١٠١b;

        /* renamed from: c, reason: collision with root package name */
        double f١٠٢c;

        /* renamed from: d, reason: collision with root package name */
        double f١٠٣d;

        /* renamed from: e, reason: collision with root package name */
        double f١٠٤e;

        /* renamed from: f, reason: collision with root package name */
        double f١٠٥f;

        /* renamed from: g, reason: collision with root package name */
        double f١٠٦g;

        /* renamed from: h, reason: collision with root package name */
        double f١٠٧h;

        /* renamed from: i, reason: collision with root package name */
        double f١٠٨i;

        /* renamed from: j, reason: collision with root package name */
        double f١٠٩j;

        /* renamed from: k, reason: collision with root package name */
        double f١١٠k;

        /* renamed from: l, reason: collision with root package name */
        double f١١١l;

        /* renamed from: m, reason: collision with root package name */
        double f١١٢m;

        /* renamed from: n, reason: collision with root package name */
        double f١١٣n;

        /* renamed from: o, reason: collision with root package name */
        double f١١٤o;

        /* renamed from: p, reason: collision with root package name */
        double f١١٥p;

        /* renamed from: q, reason: collision with root package name */
        boolean f١١٦q;

        /* renamed from: r, reason: collision with root package name */
        boolean f١١٧r;

        C٠٠٠٠a(int i10, double d10, double d11, double d12, double d13, double d14, double d15) {
            int i11;
            double d16;
            double d17;
            this.f١١٧r = false;
            this.f١١٦q = i10 == 1;
            this.f١٠٢c = d10;
            this.f١٠٣d = d11;
            this.f١٠٨i = 1.0d / (d11 - d10);
            if (3 == i10) {
                this.f١١٧r = true;
            }
            double d18 = d14 - d12;
            double d19 = d15 - d13;
            if (!this.f١١٧r && Math.abs(d18) >= 0.001d && Math.abs(d19) >= 0.001d) {
                this.f١٠٠a = new double[101];
                boolean z10 = this.f١١٦q;
                if (z10) {
                    i11 = -1;
                } else {
                    i11 = 1;
                }
                this.f١٠٩j = d18 * i11;
                this.f١١٠k = d19 * (z10 ? 1 : -1);
                if (z10) {
                    d16 = d14;
                } else {
                    d16 = d12;
                }
                this.f١١١l = d16;
                if (z10) {
                    d17 = d13;
                } else {
                    d17 = d15;
                }
                this.f١١٢m = d17;
                a(d12, d13, d14, d15);
                this.f١١٣n = this.f١٠١b * this.f١٠٨i;
                return;
            }
            this.f١١٧r = true;
            this.f١٠٤e = d12;
            this.f١٠٥f = d14;
            this.f١٠٦g = d13;
            this.f١٠٧h = d15;
            double hypot = Math.hypot(d19, d18);
            this.f١٠١b = hypot;
            this.f١١٣n = hypot * this.f١٠٨i;
            double d20 = this.f١٠٣d;
            double d21 = this.f١٠٢c;
            this.f١١١l = d18 / (d20 - d21);
            this.f١١٢m = d19 / (d20 - d21);
        }

        private void a(double d10, double d11, double d12, double d13) {
            double d14;
            double d15 = d12 - d10;
            double d16 = d11 - d13;
            int i10 = 0;
            double d17 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            double d18 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            double d19 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            while (true) {
                if (i10 >= f٩٩s.length) {
                    break;
                }
                double d20 = d17;
                double radians = Math.toRadians((i10 * 90.0d) / (r15.length - 1));
                double sin = Math.sin(radians) * d15;
                double cos = Math.cos(radians) * d16;
                if (i10 > 0) {
                    d14 = Math.hypot(sin - d18, cos - d19) + d20;
                    f٩٩s[i10] = d14;
                } else {
                    d14 = d20;
                }
                i10++;
                d19 = cos;
                d17 = d14;
                d18 = sin;
            }
            double d21 = d17;
            this.f١٠١b = d21;
            int i11 = 0;
            while (true) {
                double[] dArr = f٩٩s;
                if (i11 >= dArr.length) {
                    break;
                }
                dArr[i11] = dArr[i11] / d21;
                i11++;
            }
            int i12 = 0;
            while (true) {
                if (i12 < this.f١٠٠a.length) {
                    double length = i12 / (r1.length - 1);
                    int binarySearch = Arrays.binarySearch(f٩٩s, length);
                    if (binarySearch >= 0) {
                        this.f١٠٠a[i12] = binarySearch / (f٩٩s.length - 1);
                    } else if (binarySearch == -1) {
                        this.f١٠٠a[i12] = 0.0d;
                    } else {
                        int i13 = -binarySearch;
                        int i14 = i13 - 2;
                        double[] dArr2 = f٩٩s;
                        double d22 = dArr2[i14];
                        this.f١٠٠a[i12] = (i14 + ((length - d22) / (dArr2[i13 - 1] - d22))) / (dArr2.length - 1);
                    }
                    i12++;
                } else {
                    return;
                }
            }
        }

        double b() {
            double d10 = this.f١٠٩j * this.f١١٥p;
            double hypot = this.f١١٣n / Math.hypot(d10, (-this.f١١٠k) * this.f١١٤o);
            if (this.f١١٦q) {
                d10 = -d10;
            }
            return d10 * hypot;
        }

        double c() {
            double d10 = this.f١٠٩j * this.f١١٥p;
            double d11 = (-this.f١١٠k) * this.f١١٤o;
            double hypot = this.f١١٣n / Math.hypot(d10, d11);
            if (this.f١١٦q) {
                return (-d11) * hypot;
            }
            return d11 * hypot;
        }

        public double d(double d10) {
            return this.f١١١l;
        }

        public double e(double d10) {
            return this.f١١٢m;
        }

        public double f(double d10) {
            double d11 = (d10 - this.f١٠٢c) * this.f١٠٨i;
            double d12 = this.f١٠٤e;
            return d12 + (d11 * (this.f١٠٥f - d12));
        }

        public double g(double d10) {
            double d11 = (d10 - this.f١٠٢c) * this.f١٠٨i;
            double d12 = this.f١٠٦g;
            return d12 + (d11 * (this.f١٠٧h - d12));
        }

        double h() {
            return this.f١١١l + (this.f١٠٩j * this.f١١٤o);
        }

        double i() {
            return this.f١١٢m + (this.f١١٠k * this.f١١٥p);
        }

        double j(double d10) {
            if (d10 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f١٠٠a;
            double length = d10 * (dArr.length - 1);
            int i10 = (int) length;
            double d11 = length - i10;
            double d12 = dArr[i10];
            return d12 + (d11 * (dArr[i10 + 1] - d12));
        }

        void k(double d10) {
            double d11;
            if (this.f١١٦q) {
                d11 = this.f١٠٣d - d10;
            } else {
                d11 = d10 - this.f١٠٢c;
            }
            double j10 = j(d11 * this.f١٠٨i) * 1.5707963267948966d;
            this.f١١٤o = Math.sin(j10);
            this.f١١٥p = Math.cos(j10);
        }
    }

    public a(int[] iArr, double[] dArr, double[][] dArr2) {
        this.f٩٦a = dArr;
        this.f٩٧b = new C٠٠٠٠a[dArr.length - 1];
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        while (true) {
            C٠٠٠٠a[] r72 = this.f٩٧b;
            if (i10 < r72.length) {
                int i13 = iArr[i10];
                if (i13 != 0) {
                    if (i13 != 1) {
                        if (i13 != 2) {
                            if (i13 == 3) {
                                if (i11 == 1) {
                                    i11 = 2;
                                } else {
                                    i11 = 1;
                                }
                                i12 = i11;
                            }
                        } else {
                            i11 = 2;
                            i12 = 2;
                        }
                    } else {
                        i11 = 1;
                        i12 = 1;
                    }
                } else {
                    i12 = 3;
                }
                double d10 = dArr[i10];
                int i14 = i10 + 1;
                double d11 = dArr[i14];
                double[] dArr3 = dArr2[i10];
                double d12 = dArr3[0];
                double d13 = dArr3[1];
                double[] dArr4 = dArr2[i14];
                r72[i10] = new C٠٠٠٠a(i12, d10, d11, d12, d13, dArr4[0], dArr4[1]);
                i10 = i14;
            } else {
                return;
            }
        }
    }

    @Override // a2.b
    public double c(double d10, int i10) {
        double g10;
        double e10;
        double i11;
        double c10;
        double g11;
        double e11;
        int i12 = 0;
        if (this.f٩٨c) {
            C٠٠٠٠a[] r02 = this.f٩٧b;
            C٠٠٠٠a r22 = r02[0];
            double d11 = r22.f١٠٢c;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (r22.f١١٧r) {
                    if (i10 == 0) {
                        g11 = r22.f(d11);
                        e11 = this.f٩٧b[0].d(d11);
                    } else {
                        g11 = r22.g(d11);
                        e11 = this.f٩٧b[0].e(d11);
                    }
                    return g11 + (d12 * e11);
                }
                r22.k(d11);
                if (i10 == 0) {
                    i11 = this.f٩٧b[0].h();
                    c10 = this.f٩٧b[0].b();
                } else {
                    i11 = this.f٩٧b[0].i();
                    c10 = this.f٩٧b[0].c();
                }
                return i11 + (d12 * c10);
            }
            if (d10 > r02[r02.length - 1].f١٠٣d) {
                double d13 = r02[r02.length - 1].f١٠٣d;
                double d14 = d10 - d13;
                int length = r02.length - 1;
                if (i10 == 0) {
                    g10 = r02[length].f(d13);
                    e10 = this.f٩٧b[length].d(d13);
                } else {
                    g10 = r02[length].g(d13);
                    e10 = this.f٩٧b[length].e(d13);
                }
                return g10 + (d14 * e10);
            }
        } else {
            C٠٠٠٠a[] r03 = this.f٩٧b;
            double d15 = r03[0].f١٠٢c;
            if (d10 < d15) {
                d10 = d15;
            } else if (d10 > r03[r03.length - 1].f١٠٣d) {
                d10 = r03[r03.length - 1].f١٠٣d;
            }
        }
        while (true) {
            C٠٠٠٠a[] r04 = this.f٩٧b;
            if (i12 < r04.length) {
                C٠٠٠٠a r05 = r04[i12];
                if (d10 <= r05.f١٠٣d) {
                    if (r05.f١١٧r) {
                        if (i10 == 0) {
                            return r05.f(d10);
                        }
                        return r05.g(d10);
                    }
                    r05.k(d10);
                    if (i10 == 0) {
                        return this.f٩٧b[i12].h();
                    }
                    return this.f٩٧b[i12].i();
                }
                i12++;
            } else {
                return Double.NaN;
            }
        }
    }

    @Override // a2.b
    public void d(double d10, double[] dArr) {
        if (this.f٩٨c) {
            C٠٠٠٠a[] r02 = this.f٩٧b;
            C٠٠٠٠a r32 = r02[0];
            double d11 = r32.f١٠٢c;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (r32.f١١٧r) {
                    dArr[0] = r32.f(d11) + (this.f٩٧b[0].d(d11) * d12);
                    dArr[1] = this.f٩٧b[0].g(d11) + (d12 * this.f٩٧b[0].e(d11));
                    return;
                } else {
                    r32.k(d11);
                    dArr[0] = this.f٩٧b[0].h() + (this.f٩٧b[0].b() * d12);
                    dArr[1] = this.f٩٧b[0].i() + (d12 * this.f٩٧b[0].c());
                    return;
                }
            }
            if (d10 > r02[r02.length - 1].f١٠٣d) {
                double d13 = r02[r02.length - 1].f١٠٣d;
                double d14 = d10 - d13;
                int length = r02.length - 1;
                C٠٠٠٠a r03 = r02[length];
                if (r03.f١١٧r) {
                    dArr[0] = r03.f(d13) + (this.f٩٧b[length].d(d13) * d14);
                    dArr[1] = this.f٩٧b[length].g(d13) + (d14 * this.f٩٧b[length].e(d13));
                    return;
                } else {
                    r03.k(d10);
                    dArr[0] = this.f٩٧b[length].h() + (this.f٩٧b[length].b() * d14);
                    dArr[1] = this.f٩٧b[length].i() + (d14 * this.f٩٧b[length].c());
                    return;
                }
            }
        } else {
            C٠٠٠٠a[] r04 = this.f٩٧b;
            double d15 = r04[0].f١٠٢c;
            if (d10 < d15) {
                d10 = d15;
            }
            if (d10 > r04[r04.length - 1].f١٠٣d) {
                d10 = r04[r04.length - 1].f١٠٣d;
            }
        }
        int i10 = 0;
        while (true) {
            C٠٠٠٠a[] r33 = this.f٩٧b;
            if (i10 < r33.length) {
                C٠٠٠٠a r34 = r33[i10];
                if (d10 <= r34.f١٠٣d) {
                    if (r34.f١١٧r) {
                        dArr[0] = r34.f(d10);
                        dArr[1] = this.f٩٧b[i10].g(d10);
                        return;
                    } else {
                        r34.k(d10);
                        dArr[0] = this.f٩٧b[i10].h();
                        dArr[1] = this.f٩٧b[i10].i();
                        return;
                    }
                }
                i10++;
            } else {
                return;
            }
        }
    }

    @Override // a2.b
    public void e(double d10, float[] fArr) {
        if (this.f٩٨c) {
            C٠٠٠٠a[] r02 = this.f٩٧b;
            C٠٠٠٠a r32 = r02[0];
            double d11 = r32.f١٠٢c;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (r32.f١١٧r) {
                    fArr[0] = (float) (r32.f(d11) + (this.f٩٧b[0].d(d11) * d12));
                    fArr[1] = (float) (this.f٩٧b[0].g(d11) + (d12 * this.f٩٧b[0].e(d11)));
                    return;
                } else {
                    r32.k(d11);
                    fArr[0] = (float) (this.f٩٧b[0].h() + (this.f٩٧b[0].b() * d12));
                    fArr[1] = (float) (this.f٩٧b[0].i() + (d12 * this.f٩٧b[0].c()));
                    return;
                }
            }
            if (d10 > r02[r02.length - 1].f١٠٣d) {
                double d13 = r02[r02.length - 1].f١٠٣d;
                double d14 = d10 - d13;
                int length = r02.length - 1;
                C٠٠٠٠a r03 = r02[length];
                if (r03.f١١٧r) {
                    fArr[0] = (float) (r03.f(d13) + (this.f٩٧b[length].d(d13) * d14));
                    fArr[1] = (float) (this.f٩٧b[length].g(d13) + (d14 * this.f٩٧b[length].e(d13)));
                    return;
                } else {
                    r03.k(d10);
                    fArr[0] = (float) this.f٩٧b[length].h();
                    fArr[1] = (float) this.f٩٧b[length].i();
                    return;
                }
            }
        } else {
            C٠٠٠٠a[] r04 = this.f٩٧b;
            double d15 = r04[0].f١٠٢c;
            if (d10 < d15) {
                d10 = d15;
            } else if (d10 > r04[r04.length - 1].f١٠٣d) {
                d10 = r04[r04.length - 1].f١٠٣d;
            }
        }
        int i10 = 0;
        while (true) {
            C٠٠٠٠a[] r33 = this.f٩٧b;
            if (i10 < r33.length) {
                C٠٠٠٠a r34 = r33[i10];
                if (d10 <= r34.f١٠٣d) {
                    if (r34.f١١٧r) {
                        fArr[0] = (float) r34.f(d10);
                        fArr[1] = (float) this.f٩٧b[i10].g(d10);
                        return;
                    } else {
                        r34.k(d10);
                        fArr[0] = (float) this.f٩٧b[i10].h();
                        fArr[1] = (float) this.f٩٧b[i10].i();
                        return;
                    }
                }
                i10++;
            } else {
                return;
            }
        }
    }

    @Override // a2.b
    public double f(double d10, int i10) {
        C٠٠٠٠a[] r02 = this.f٩٧b;
        int i11 = 0;
        double d11 = r02[0].f١٠٢c;
        if (d10 < d11) {
            d10 = d11;
        }
        if (d10 > r02[r02.length - 1].f١٠٣d) {
            d10 = r02[r02.length - 1].f١٠٣d;
        }
        while (true) {
            C٠٠٠٠a[] r03 = this.f٩٧b;
            if (i11 < r03.length) {
                C٠٠٠٠a r04 = r03[i11];
                if (d10 <= r04.f١٠٣d) {
                    if (r04.f١١٧r) {
                        if (i10 == 0) {
                            return r04.d(d10);
                        }
                        return r04.e(d10);
                    }
                    r04.k(d10);
                    if (i10 == 0) {
                        return this.f٩٧b[i11].b();
                    }
                    return this.f٩٧b[i11].c();
                }
                i11++;
            } else {
                return Double.NaN;
            }
        }
    }

    @Override // a2.b
    public void g(double d10, double[] dArr) {
        C٠٠٠٠a[] r02 = this.f٩٧b;
        double d11 = r02[0].f١٠٢c;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > r02[r02.length - 1].f١٠٣d) {
            d10 = r02[r02.length - 1].f١٠٣d;
        }
        int i10 = 0;
        while (true) {
            C٠٠٠٠a[] r22 = this.f٩٧b;
            if (i10 < r22.length) {
                C٠٠٠٠a r23 = r22[i10];
                if (d10 <= r23.f١٠٣d) {
                    if (r23.f١١٧r) {
                        dArr[0] = r23.d(d10);
                        dArr[1] = this.f٩٧b[i10].e(d10);
                        return;
                    } else {
                        r23.k(d10);
                        dArr[0] = this.f٩٧b[i10].b();
                        dArr[1] = this.f٩٧b[i10].c();
                        return;
                    }
                }
                i10++;
            } else {
                return;
            }
        }
    }

    @Override // a2.b
    public double[] h() {
        return this.f٩٦a;
    }
}
