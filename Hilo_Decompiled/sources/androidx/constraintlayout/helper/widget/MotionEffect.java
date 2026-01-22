package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.motion.widget.e;
import androidx.constraintlayout.motion.widget.h;
import androidx.constraintlayout.motion.widget.m;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MotionEffect extends MotionHelper {

    /* renamed from: n, reason: collision with root package name */
    private float f١٨٢٦n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٨٢٧o;

    /* renamed from: p, reason: collision with root package name */
    private int f١٨٢٨p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٨٢٩q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٨٣٠r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f١٨٣١s;

    /* renamed from: t, reason: collision with root package name */
    private int f١٨٣٢t;

    /* renamed from: u, reason: collision with root package name */
    private int f١٨٣٣u;

    public MotionEffect(Context context) {
        super(context);
        this.f١٨٢٦n = 0.1f;
        this.f١٨٢٧o = 49;
        this.f١٨٢٨p = 50;
        this.f١٨٢٩q = 0;
        this.f١٨٣٠r = 0;
        this.f١٨٣١s = true;
        this.f١٨٣٢t = -1;
        this.f١٨٣٣u = -1;
    }

    private void E(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i11 = obtainStyledAttributes.getInt(index, this.f١٨٢٧o);
                    this.f١٨٢٧o = i11;
                    this.f١٨٢٧o = Math.max(Math.min(i11, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i12 = obtainStyledAttributes.getInt(index, this.f١٨٢٨p);
                    this.f١٨٢٨p = i12;
                    this.f١٨٢٨p = Math.max(Math.min(i12, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.f١٨٢٩q = obtainStyledAttributes.getDimensionPixelOffset(index, this.f١٨٢٩q);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.f١٨٣٠r = obtainStyledAttributes.getDimensionPixelOffset(index, this.f١٨٣٠r);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.f١٨٢٦n = obtainStyledAttributes.getFloat(index, this.f١٨٢٦n);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.f١٨٣٣u = obtainStyledAttributes.getInt(index, this.f١٨٣٣u);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.f١٨٣١s = obtainStyledAttributes.getBoolean(index, this.f١٨٣١s);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.f١٨٣٢t = obtainStyledAttributes.getResourceId(index, this.f١٨٣٢t);
                }
            }
            int i13 = this.f١٨٢٧o;
            int i14 = this.f١٨٢٨p;
            if (i13 == i14) {
                if (i13 > 0) {
                    this.f١٨٢٧o = i13 - 1;
                } else {
                    this.f١٨٢٨p = i14 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0186, code lost:
    
        if (r14 == com.qiahao.base_common.download.okDownload.DownloadProgress.UNKNOWN_PROGRESS) goto L٥٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x019a, code lost:
    
        if (r14 == com.qiahao.base_common.download.okDownload.DownloadProgress.UNKNOWN_PROGRESS) goto L٥٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01aa, code lost:
    
        if (r15 == com.qiahao.base_common.download.okDownload.DownloadProgress.UNKNOWN_PROGRESS) goto L٥٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ba, code lost:
    
        if (r15 == com.qiahao.base_common.download.okDownload.DownloadProgress.UNKNOWN_PROGRESS) goto L٤٦;
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e5  */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C(MotionLayout motionLayout, HashMap hashMap) {
        e eVar;
        e eVar2;
        e eVar3;
        int i10;
        HashMap hashMap2 = hashMap;
        View[] m10 = m((ConstraintLayout) getParent());
        if (m10 == null) {
            Log.v("FadeMove", a.a() + " views = null");
            return;
        }
        e eVar4 = new e();
        e eVar5 = new e();
        eVar4.R("alpha", Float.valueOf(this.f١٨٢٦n));
        eVar5.R("alpha", Float.valueOf(this.f١٨٢٦n));
        eVar4.g(this.f١٨٢٧o);
        eVar5.g(this.f١٨٢٨p);
        h hVar = new h();
        hVar.g(this.f١٨٢٧o);
        hVar.m(0);
        hVar.n("percentX", 0);
        hVar.n("percentY", 0);
        h hVar2 = new h();
        hVar2.g(this.f١٨٢٨p);
        hVar2.m(0);
        int i11 = 1;
        hVar2.n("percentX", 1);
        hVar2.n("percentY", 1);
        e eVar6 = null;
        if (this.f١٨٢٩q > 0) {
            eVar = new e();
            eVar2 = new e();
            eVar.R("translationX", Integer.valueOf(this.f١٨٢٩q));
            eVar.g(this.f١٨٢٨p);
            eVar2.R("translationX", 0);
            eVar2.g(this.f١٨٢٨p - 1);
        } else {
            eVar = null;
            eVar2 = null;
        }
        if (this.f١٨٣٠r > 0) {
            eVar6 = new e();
            eVar3 = new e();
            eVar6.R("translationY", Integer.valueOf(this.f١٨٣٠r));
            eVar6.g(this.f١٨٢٨p);
            eVar3.R("translationY", 0);
            eVar3.g(this.f١٨٢٨p - 1);
        } else {
            eVar3 = null;
        }
        int i12 = this.f١٨٣٣u;
        if (i12 == -1) {
            int[] iArr = new int[4];
            for (View view : m10) {
                m mVar = (m) hashMap2.get(view);
                if (mVar != null) {
                    float n10 = mVar.n() - mVar.t();
                    float o10 = mVar.o() - mVar.u();
                    if (o10 < DownloadProgress.UNKNOWN_PROGRESS) {
                        iArr[1] = iArr[1] + 1;
                    }
                    if (o10 > DownloadProgress.UNKNOWN_PROGRESS) {
                        iArr[0] = iArr[0] + 1;
                    }
                    if (n10 > DownloadProgress.UNKNOWN_PROGRESS) {
                        iArr[3] = iArr[3] + 1;
                    }
                    if (n10 < DownloadProgress.UNKNOWN_PROGRESS) {
                        iArr[2] = iArr[2] + 1;
                    }
                }
            }
            int i13 = iArr[0];
            i12 = 0;
            for (int i14 = 4; i11 < i14; i14 = 4) {
                int i15 = iArr[i11];
                if (i13 < i15) {
                    i13 = i15;
                    i12 = i11;
                }
                i11++;
            }
        }
        int i16 = 0;
        while (i16 < m10.length) {
            m mVar2 = (m) hashMap2.get(m10[i16]);
            if (mVar2 != null) {
                float n11 = mVar2.n() - mVar2.t();
                float o11 = mVar2.o() - mVar2.u();
                if (i12 == 0) {
                    if (o11 > DownloadProgress.UNKNOWN_PROGRESS) {
                        if (this.f١٨٣١s) {
                        }
                    }
                    i10 = this.f١٨٣٢t;
                    if (i10 != -1) {
                        mVar2.a(eVar4);
                        mVar2.a(eVar5);
                        mVar2.a(hVar);
                        mVar2.a(hVar2);
                        if (this.f١٨٢٩q > 0) {
                            mVar2.a(eVar);
                            mVar2.a(eVar2);
                        }
                        if (this.f١٨٣٠r > 0) {
                            mVar2.a(eVar6);
                            mVar2.a(eVar3);
                        }
                    } else {
                        motionLayout.L(i10, mVar2);
                    }
                } else if (i12 == 1) {
                    if (o11 < DownloadProgress.UNKNOWN_PROGRESS) {
                        if (this.f١٨٣١s) {
                        }
                    }
                    i10 = this.f١٨٣٢t;
                    if (i10 != -1) {
                    }
                } else if (i12 == 2) {
                    if (n11 < DownloadProgress.UNKNOWN_PROGRESS) {
                        if (this.f١٨٣١s) {
                        }
                    }
                    i10 = this.f١٨٣٢t;
                    if (i10 != -1) {
                    }
                } else {
                    if (i12 == 3) {
                        if (n11 > DownloadProgress.UNKNOWN_PROGRESS) {
                            if (this.f١٨٣١s) {
                            }
                        }
                    }
                    i10 = this.f١٨٣٢t;
                    if (i10 != -1) {
                    }
                }
                i16++;
                hashMap2 = hashMap;
            }
            i16++;
            hashMap2 = hashMap;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    public boolean w() {
        return true;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٨٢٦n = 0.1f;
        this.f١٨٢٧o = 49;
        this.f١٨٢٨p = 50;
        this.f١٨٢٩q = 0;
        this.f١٨٣٠r = 0;
        this.f١٨٣١s = true;
        this.f١٨٣٢t = -1;
        this.f١٨٣٣u = -1;
        E(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٨٢٦n = 0.1f;
        this.f١٨٢٧o = 49;
        this.f١٨٢٨p = 50;
        this.f١٨٢٩q = 0;
        this.f١٨٣٠r = 0;
        this.f١٨٣١s = true;
        this.f١٨٣٢t = -1;
        this.f١٨٣٣u = -1;
        E(context, attributeSet);
    }
}
