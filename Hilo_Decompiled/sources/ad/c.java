package ad;

import com.taobao.accs.flowcontrol.FlowControl;
import com.zhpan.indicator.option.IndicatorOptions;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class c {
    private int b;
    private boolean c;
    private int e;
    private int l;
    private float[] m;
    private int n;
    private boolean q;
    private boolean r;
    private int a = -1;
    private boolean d = false;
    private int i = 0;
    private float j = 0.85f;
    private int k = 0;
    private boolean o = true;
    private int p = 0;
    private boolean s = true;
    private boolean t = true;
    private final IndicatorOptions u = new IndicatorOptions();
    private int f = dd.a.a(20.0f);
    private int g = FlowControl.DELAY_MAX_BRUSH;
    private int h = FlowControl.DELAY_MAX_BRUSH;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class a {
    }

    public void A(int i) {
        this.u.setSlideMode(i);
    }

    public void B(int i, int i2) {
        this.u.setSliderColor(i, i2);
    }

    public void C(int i, int i2) {
        this.u.setSliderWidth(i, i2);
    }

    public void D(int i) {
        this.u.setIndicatorStyle(i);
    }

    public void E(int i) {
        this.k = i;
    }

    public void F(int i) {
        this.b = i;
    }

    public void G(int i) {
        this.h = i;
    }

    public void H(int i) {
        this.p = i;
        this.u.setOrientation(i);
    }

    public void I(int i) {
        this.f = i;
    }

    public void J(float f) {
        this.j = f;
    }

    public void K(int i) {
        this.i = i;
    }

    public void L(int i) {
        this.g = i;
    }

    public void M(int i) {
        this.n = i;
    }

    public void N(boolean z) {
        int i;
        this.q = z;
        IndicatorOptions indicatorOptions = this.u;
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        indicatorOptions.setOrientation(i);
    }

    public void O(int i) {
        this.l = i;
    }

    public int a() {
        return this.e;
    }

    public a b() {
        return null;
    }

    public IndicatorOptions c() {
        return this.u;
    }

    public int d() {
        return this.k;
    }

    public int e() {
        return this.b;
    }

    public int f() {
        return this.h;
    }

    public int g() {
        return this.a;
    }

    public int h() {
        return this.p;
    }

    public int i() {
        return this.f;
    }

    public float j() {
        return this.j;
    }

    public int k() {
        return this.i;
    }

    public int l() {
        return this.g;
    }

    public int m() {
        return this.n;
    }

    public float[] n() {
        return this.m;
    }

    public int o() {
        return this.l;
    }

    public boolean p() {
        return this.d;
    }

    public boolean q() {
        return this.t;
    }

    public boolean r() {
        return this.c;
    }

    public boolean s() {
        return this.r;
    }

    public boolean t() {
        return this.s;
    }

    public void u() {
        this.u.setCurrentPosition(0);
        this.u.setSlideProgress(0.0f);
    }

    public void v(boolean z) {
        this.d = z;
    }

    public void w(boolean z) {
        this.c = z;
    }

    public void x(float f) {
        this.u.setSliderGap(f);
    }

    public void y(int i) {
        this.e = i;
    }

    public void z(int i) {
        this.u.setSliderHeight(i);
    }
}
