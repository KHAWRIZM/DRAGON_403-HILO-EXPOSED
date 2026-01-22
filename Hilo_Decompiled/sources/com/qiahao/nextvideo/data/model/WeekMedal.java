package com.qiahao.nextvideo.data.model;

import com.therouter.inject.DebugOnlyKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u009f\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u0006:"}, d2 = {"Lcom/qiahao/nextvideo/data/model/WeekMedal;", "", DebugOnlyKt.PACKAGE, "", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "<init>", "(IIIIIIIIIIIIIII)V", "getA", "()I", "getB", "getC", "getD", "getE", "getF", "getG", "getH", "getI", "getJ", "getK", "getL", "getM", "getN", "getO", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class WeekMedal {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;

    public WeekMedal(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
        this.i = i9;
        this.j = i10;
        this.k = i11;
        this.l = i12;
        this.m = i13;
        this.n = i14;
        this.o = i15;
    }

    /* renamed from: component1, reason: from getter */
    public final int getA() {
        return this.a;
    }

    /* renamed from: component10, reason: from getter */
    public final int getJ() {
        return this.j;
    }

    /* renamed from: component11, reason: from getter */
    public final int getK() {
        return this.k;
    }

    /* renamed from: component12, reason: from getter */
    public final int getL() {
        return this.l;
    }

    /* renamed from: component13, reason: from getter */
    public final int getM() {
        return this.m;
    }

    /* renamed from: component14, reason: from getter */
    public final int getN() {
        return this.n;
    }

    /* renamed from: component15, reason: from getter */
    public final int getO() {
        return this.o;
    }

    /* renamed from: component2, reason: from getter */
    public final int getB() {
        return this.b;
    }

    /* renamed from: component3, reason: from getter */
    public final int getC() {
        return this.c;
    }

    /* renamed from: component4, reason: from getter */
    public final int getD() {
        return this.d;
    }

    /* renamed from: component5, reason: from getter */
    public final int getE() {
        return this.e;
    }

    /* renamed from: component6, reason: from getter */
    public final int getF() {
        return this.f;
    }

    /* renamed from: component7, reason: from getter */
    public final int getG() {
        return this.g;
    }

    /* renamed from: component8, reason: from getter */
    public final int getH() {
        return this.h;
    }

    /* renamed from: component9, reason: from getter */
    public final int getI() {
        return this.i;
    }

    @NotNull
    public final WeekMedal copy(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n, int o) {
        return new WeekMedal(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeekMedal)) {
            return false;
        }
        WeekMedal weekMedal = (WeekMedal) other;
        return this.a == weekMedal.a && this.b == weekMedal.b && this.c == weekMedal.c && this.d == weekMedal.d && this.e == weekMedal.e && this.f == weekMedal.f && this.g == weekMedal.g && this.h == weekMedal.h && this.i == weekMedal.i && this.j == weekMedal.j && this.k == weekMedal.k && this.l == weekMedal.l && this.m == weekMedal.m && this.n == weekMedal.n && this.o == weekMedal.o;
    }

    public final int getA() {
        return this.a;
    }

    public final int getB() {
        return this.b;
    }

    public final int getC() {
        return this.c;
    }

    public final int getD() {
        return this.d;
    }

    public final int getE() {
        return this.e;
    }

    public final int getF() {
        return this.f;
    }

    public final int getG() {
        return this.g;
    }

    public final int getH() {
        return this.h;
    }

    public final int getI() {
        return this.i;
    }

    public final int getJ() {
        return this.j;
    }

    public final int getK() {
        return this.k;
    }

    public final int getL() {
        return this.l;
    }

    public final int getM() {
        return this.m;
    }

    public final int getN() {
        return this.n;
    }

    public final int getO() {
        return this.o;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o;
    }

    @NotNull
    public String toString() {
        return "WeekMedal(a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ", g=" + this.g + ", h=" + this.h + ", i=" + this.i + ", j=" + this.j + ", k=" + this.k + ", l=" + this.l + ", m=" + this.m + ", n=" + this.n + ", o=" + this.o + ")";
    }
}
