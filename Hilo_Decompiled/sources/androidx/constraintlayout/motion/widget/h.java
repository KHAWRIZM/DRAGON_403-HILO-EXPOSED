package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h extends i {

    /* renamed from: h, reason: collision with root package name */
    String f١٩٧٧h = null;

    /* renamed from: i, reason: collision with root package name */
    int f١٩٧٨i = d.f١٩٥١f;

    /* renamed from: j, reason: collision with root package name */
    int f١٩٧٩j = 0;

    /* renamed from: k, reason: collision with root package name */
    float f١٩٨٠k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    float f١٩٨١l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    float f١٩٨٢m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    float f١٩٨٣n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    float f١٩٨٤o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    float f١٩٨٥p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    int f١٩٨٦q = 0;

    /* renamed from: r, reason: collision with root package name */
    private float f١٩٨٧r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    private float f١٩٨٨s = Float.NaN;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static SparseIntArray f١٩٨٩a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f١٩٨٩a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            f١٩٨٩a.append(R.styleable.KeyPosition_framePosition, 2);
            f١٩٨٩a.append(R.styleable.KeyPosition_transitionEasing, 3);
            f١٩٨٩a.append(R.styleable.KeyPosition_curveFit, 4);
            f١٩٨٩a.append(R.styleable.KeyPosition_drawPath, 5);
            f١٩٨٩a.append(R.styleable.KeyPosition_percentX, 6);
            f١٩٨٩a.append(R.styleable.KeyPosition_percentY, 7);
            f١٩٨٩a.append(R.styleable.KeyPosition_keyPositionType, 9);
            f١٩٨٩a.append(R.styleable.KeyPosition_sizePercent, 8);
            f١٩٨٩a.append(R.styleable.KeyPosition_percentWidth, 11);
            f١٩٨٩a.append(R.styleable.KeyPosition_percentHeight, 12);
            f١٩٨٩a.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(h hVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f١٩٨٩a.get(index)) {
                    case 1:
                        if (MotionLayout.E0) {
                            int resourceId = typedArray.getResourceId(index, hVar.f١٩٥٣b);
                            hVar.f١٩٥٣b = resourceId;
                            if (resourceId == -1) {
                                hVar.f١٩٥٤c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            hVar.f١٩٥٤c = typedArray.getString(index);
                            break;
                        } else {
                            hVar.f١٩٥٣b = typedArray.getResourceId(index, hVar.f١٩٥٣b);
                            break;
                        }
                    case 2:
                        hVar.f١٩٥٢a = typedArray.getInt(index, hVar.f١٩٥٢a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            hVar.f١٩٧٧h = typedArray.getString(index);
                            break;
                        } else {
                            hVar.f١٩٧٧h = a2.c.f١٢١c[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        hVar.f١٩٩٠g = typedArray.getInteger(index, hVar.f١٩٩٠g);
                        break;
                    case 5:
                        hVar.f١٩٧٩j = typedArray.getInt(index, hVar.f١٩٧٩j);
                        break;
                    case 6:
                        hVar.f١٩٨٢m = typedArray.getFloat(index, hVar.f١٩٨٢m);
                        break;
                    case 7:
                        hVar.f١٩٨٣n = typedArray.getFloat(index, hVar.f١٩٨٣n);
                        break;
                    case 8:
                        float f10 = typedArray.getFloat(index, hVar.f١٩٨١l);
                        hVar.f١٩٨٠k = f10;
                        hVar.f١٩٨١l = f10;
                        break;
                    case 9:
                        hVar.f١٩٨٦q = typedArray.getInt(index, hVar.f١٩٨٦q);
                        break;
                    case 10:
                        hVar.f١٩٧٨i = typedArray.getInt(index, hVar.f١٩٧٨i);
                        break;
                    case 11:
                        hVar.f١٩٨٠k = typedArray.getFloat(index, hVar.f١٩٨٠k);
                        break;
                    case 12:
                        hVar.f١٩٨١l = typedArray.getFloat(index, hVar.f١٩٨١l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f١٩٨٩a.get(index));
                        break;
                }
            }
            if (hVar.f١٩٥٢a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public h() {
        this.f١٩٥٥d = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return new h().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        h hVar = (h) dVar;
        this.f١٩٧٧h = hVar.f١٩٧٧h;
        this.f١٩٧٨i = hVar.f١٩٧٨i;
        this.f١٩٧٩j = hVar.f١٩٧٩j;
        this.f١٩٨٠k = hVar.f١٩٨٠k;
        this.f١٩٨١l = Float.NaN;
        this.f١٩٨٢m = hVar.f١٩٨٢m;
        this.f١٩٨٣n = hVar.f١٩٨٣n;
        this.f١٩٨٤o = hVar.f١٩٨٤o;
        this.f١٩٨٥p = hVar.f١٩٨٥p;
        this.f١٩٨٧r = hVar.f١٩٨٧r;
        this.f١٩٨٨s = hVar.f١٩٨٨s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    public void m(int i10) {
        this.f١٩٨٦q = i10;
    }

    public void n(String str, Object obj) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c10 = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c10 = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c10 = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c10 = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c10 = 6;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                this.f١٩٧٧h = obj.toString();
                return;
            case 1:
                this.f١٩٨٠k = k(obj);
                return;
            case 2:
                this.f١٩٨١l = k(obj);
                return;
            case 3:
                this.f١٩٧٩j = l(obj);
                return;
            case 4:
                float k10 = k(obj);
                this.f١٩٨٠k = k10;
                this.f١٩٨١l = k10;
                return;
            case 5:
                this.f١٩٨٢m = k(obj);
                return;
            case 6:
                this.f١٩٨٣n = k(obj);
                return;
            default:
                return;
        }
    }
}
