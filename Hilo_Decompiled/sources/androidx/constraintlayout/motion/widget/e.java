package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import e2.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e extends d {

    /* renamed from: g, reason: collision with root package name */
    private String f١٩٥٧g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٩٥٨h = -1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٩٥٩i = false;

    /* renamed from: j, reason: collision with root package name */
    private float f١٩٦٠j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    private float f١٩٦١k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    private float f١٩٦٢l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    private float f١٩٦٣m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    private float f١٩٦٤n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    private float f١٩٦٥o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    private float f١٩٦٦p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    private float f١٩٦٧q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    private float f١٩٦٨r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    private float f١٩٦٩s = Float.NaN;

    /* renamed from: t, reason: collision with root package name */
    private float f١٩٧٠t = Float.NaN;

    /* renamed from: u, reason: collision with root package name */
    private float f١٩٧١u = Float.NaN;

    /* renamed from: v, reason: collision with root package name */
    private float f١٩٧٢v = Float.NaN;

    /* renamed from: w, reason: collision with root package name */
    private float f١٩٧٣w = Float.NaN;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static SparseIntArray f١٩٧٤a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f١٩٧٤a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_elevation, 2);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_rotation, 4);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_rotationX, 5);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_rotationY, 6);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_scaleX, 7);
            f١٩٧٤a.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            f١٩٧٤a.append(R.styleable.KeyAttribute_transitionEasing, 9);
            f١٩٧٤a.append(R.styleable.KeyAttribute_motionTarget, 10);
            f١٩٧٤a.append(R.styleable.KeyAttribute_framePosition, 12);
            f١٩٧٤a.append(R.styleable.KeyAttribute_curveFit, 13);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_scaleY, 14);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_translationX, 15);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_translationY, 16);
            f١٩٧٤a.append(R.styleable.KeyAttribute_android_translationZ, 17);
            f١٩٧٤a.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(e eVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f١٩٧٤a.get(index)) {
                    case 1:
                        eVar.f١٩٦٠j = typedArray.getFloat(index, eVar.f١٩٦٠j);
                        break;
                    case 2:
                        eVar.f١٩٦١k = typedArray.getDimension(index, eVar.f١٩٦١k);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f١٩٧٤a.get(index));
                        break;
                    case 4:
                        eVar.f١٩٦٢l = typedArray.getFloat(index, eVar.f١٩٦٢l);
                        break;
                    case 5:
                        eVar.f١٩٦٣m = typedArray.getFloat(index, eVar.f١٩٦٣m);
                        break;
                    case 6:
                        eVar.f١٩٦٤n = typedArray.getFloat(index, eVar.f١٩٦٤n);
                        break;
                    case 7:
                        eVar.f١٩٦٨r = typedArray.getFloat(index, eVar.f١٩٦٨r);
                        break;
                    case 8:
                        eVar.f١٩٦٧q = typedArray.getFloat(index, eVar.f١٩٦٧q);
                        break;
                    case 9:
                        eVar.f١٩٥٧g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.E0) {
                            int resourceId = typedArray.getResourceId(index, eVar.f١٩٥٣b);
                            eVar.f١٩٥٣b = resourceId;
                            if (resourceId == -1) {
                                eVar.f١٩٥٤c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            eVar.f١٩٥٤c = typedArray.getString(index);
                            break;
                        } else {
                            eVar.f١٩٥٣b = typedArray.getResourceId(index, eVar.f١٩٥٣b);
                            break;
                        }
                    case 12:
                        eVar.f١٩٥٢a = typedArray.getInt(index, eVar.f١٩٥٢a);
                        break;
                    case 13:
                        eVar.f١٩٥٨h = typedArray.getInteger(index, eVar.f١٩٥٨h);
                        break;
                    case 14:
                        eVar.f١٩٦٩s = typedArray.getFloat(index, eVar.f١٩٦٩s);
                        break;
                    case 15:
                        eVar.f١٩٧٠t = typedArray.getDimension(index, eVar.f١٩٧٠t);
                        break;
                    case 16:
                        eVar.f١٩٧١u = typedArray.getDimension(index, eVar.f١٩٧١u);
                        break;
                    case 17:
                        eVar.f١٩٧٢v = typedArray.getDimension(index, eVar.f١٩٧٢v);
                        break;
                    case 18:
                        eVar.f١٩٧٣w = typedArray.getFloat(index, eVar.f١٩٧٣w);
                        break;
                    case 19:
                        eVar.f١٩٦٥o = typedArray.getDimension(index, eVar.f١٩٦٥o);
                        break;
                    case 20:
                        eVar.f١٩٦٦p = typedArray.getDimension(index, eVar.f١٩٦٦p);
                        break;
                }
            }
        }
    }

    public e() {
        this.f١٩٥٥d = 1;
        this.f١٩٥٦e = new HashMap();
    }

    public void R(String str, Object obj) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c10 = 5;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c10 = 6;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c10 = 7;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c10 = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c10 = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c10 = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = '\r';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = 14;
                    break;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c10 = 15;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY)) {
                    c10 = 16;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                this.f١٩٧٣w = k(obj);
                return;
            case 1:
                this.f١٩٥٧g = obj.toString();
                return;
            case 2:
                this.f١٩٦٣m = k(obj);
                return;
            case 3:
                this.f١٩٦٤n = k(obj);
                return;
            case 4:
                this.f١٩٧٠t = k(obj);
                return;
            case 5:
                this.f١٩٧١u = k(obj);
                return;
            case 6:
                this.f١٩٧٢v = k(obj);
                return;
            case 7:
                this.f١٩٦٨r = k(obj);
                return;
            case '\b':
                this.f١٩٦٩s = k(obj);
                return;
            case '\t':
                this.f١٩٦٥o = k(obj);
                return;
            case '\n':
                this.f١٩٦٦p = k(obj);
                return;
            case 11:
                this.f١٩٦٢l = k(obj);
                return;
            case '\f':
                this.f١٩٦١k = k(obj);
                return;
            case '\r':
                this.f١٩٦٧q = k(obj);
                return;
            case 14:
                this.f١٩٦٠j = k(obj);
                return;
            case 15:
                this.f١٩٥٨h = l(obj);
                return;
            case 16:
                this.f١٩٥٩i = j(obj);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0041. Please report as an issue. */
    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap hashMap) {
        for (String str : hashMap.keySet()) {
            a2.j jVar = (a2.j) hashMap.get(str);
            if (jVar != null) {
                if (str.startsWith("CUSTOM")) {
                    androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) this.f١٩٥٦e.get(str.substring(7));
                    if (aVar != null) {
                        ((d.b) jVar).i(this.f١٩٥٢a, aVar);
                    }
                } else {
                    char c10 = 65535;
                    switch (str.hashCode()) {
                        case -1249320806:
                            if (str.equals("rotationX")) {
                                c10 = 0;
                                break;
                            }
                            break;
                        case -1249320805:
                            if (str.equals("rotationY")) {
                                c10 = 1;
                                break;
                            }
                            break;
                        case -1225497657:
                            if (str.equals("translationX")) {
                                c10 = 2;
                                break;
                            }
                            break;
                        case -1225497656:
                            if (str.equals("translationY")) {
                                c10 = 3;
                                break;
                            }
                            break;
                        case -1225497655:
                            if (str.equals("translationZ")) {
                                c10 = 4;
                                break;
                            }
                            break;
                        case -1001078227:
                            if (str.equals("progress")) {
                                c10 = 5;
                                break;
                            }
                            break;
                        case -908189618:
                            if (str.equals("scaleX")) {
                                c10 = 6;
                                break;
                            }
                            break;
                        case -908189617:
                            if (str.equals("scaleY")) {
                                c10 = 7;
                                break;
                            }
                            break;
                        case -760884510:
                            if (str.equals("transformPivotX")) {
                                c10 = '\b';
                                break;
                            }
                            break;
                        case -760884509:
                            if (str.equals("transformPivotY")) {
                                c10 = '\t';
                                break;
                            }
                            break;
                        case -40300674:
                            if (str.equals("rotation")) {
                                c10 = '\n';
                                break;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                c10 = 11;
                                break;
                            }
                            break;
                        case 37232917:
                            if (str.equals("transitionPathRotate")) {
                                c10 = '\f';
                                break;
                            }
                            break;
                        case 92909918:
                            if (str.equals("alpha")) {
                                c10 = '\r';
                                break;
                            }
                            break;
                    }
                    switch (c10) {
                        case 0:
                            if (Float.isNaN(this.f١٩٦٣m)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٦٣m);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.f١٩٦٤n)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٦٤n);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.f١٩٧٠t)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٧٠t);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.f١٩٧١u)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٧١u);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.f١٩٧٢v)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٧٢v);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.f١٩٧٣w)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٧٣w);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.f١٩٦٨r)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٦٨r);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.f١٩٦٩s)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٦٩s);
                                break;
                            }
                        case '\b':
                            if (Float.isNaN(this.f١٩٦٣m)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٦٥o);
                                break;
                            }
                        case '\t':
                            if (Float.isNaN(this.f١٩٦٤n)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٦٦p);
                                break;
                            }
                        case '\n':
                            if (Float.isNaN(this.f١٩٦٢l)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٦٢l);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.f١٩٦١k)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٦١k);
                                break;
                            }
                        case '\f':
                            if (Float.isNaN(this.f١٩٦٧q)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٦٧q);
                                break;
                            }
                        case '\r':
                            if (Float.isNaN(this.f١٩٦٠j)) {
                                break;
                            } else {
                                jVar.c(this.f١٩٥٢a, this.f١٩٦٠j);
                                break;
                            }
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new e().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        e eVar = (e) dVar;
        this.f١٩٥٨h = eVar.f١٩٥٨h;
        this.f١٩٥٩i = eVar.f١٩٥٩i;
        this.f١٩٦٠j = eVar.f١٩٦٠j;
        this.f١٩٦١k = eVar.f١٩٦١k;
        this.f١٩٦٢l = eVar.f١٩٦٢l;
        this.f١٩٦٣m = eVar.f١٩٦٣m;
        this.f١٩٦٤n = eVar.f١٩٦٤n;
        this.f١٩٦٥o = eVar.f١٩٦٥o;
        this.f١٩٦٦p = eVar.f١٩٦٦p;
        this.f١٩٦٧q = eVar.f١٩٦٧q;
        this.f١٩٦٨r = eVar.f١٩٦٨r;
        this.f١٩٦٩s = eVar.f١٩٦٩s;
        this.f١٩٧٠t = eVar.f١٩٧٠t;
        this.f١٩٧١u = eVar.f١٩٧١u;
        this.f١٩٧٢v = eVar.f١٩٧٢v;
        this.f١٩٧٣w = eVar.f١٩٧٣w;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.f١٩٦٠j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f١٩٦١k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f١٩٦٢l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f١٩٦٣m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f١٩٦٤n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f١٩٦٥o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f١٩٦٦p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f١٩٧٠t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f١٩٧١u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f١٩٧٢v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f١٩٦٧q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f١٩٦٨r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f١٩٦٩s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f١٩٧٣w)) {
            hashSet.add("progress");
        }
        if (this.f١٩٥٦e.size() > 0) {
            Iterator it = this.f١٩٥٦e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void h(HashMap hashMap) {
        if (this.f١٩٥٨h == -1) {
            return;
        }
        if (!Float.isNaN(this.f١٩٦٠j)) {
            hashMap.put("alpha", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٦١k)) {
            hashMap.put("elevation", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٦٢l)) {
            hashMap.put("rotation", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٦٣m)) {
            hashMap.put("rotationX", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٦٤n)) {
            hashMap.put("rotationY", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٦٥o)) {
            hashMap.put("transformPivotX", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٦٦p)) {
            hashMap.put("transformPivotY", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٧٠t)) {
            hashMap.put("translationX", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٧١u)) {
            hashMap.put("translationY", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٧٢v)) {
            hashMap.put("translationZ", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٦٧q)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٦٨r)) {
            hashMap.put("scaleX", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٦٩s)) {
            hashMap.put("scaleY", Integer.valueOf(this.f١٩٥٨h));
        }
        if (!Float.isNaN(this.f١٩٧٣w)) {
            hashMap.put("progress", Integer.valueOf(this.f١٩٥٨h));
        }
        if (this.f١٩٥٦e.size() > 0) {
            Iterator it = this.f١٩٥٦e.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + ((String) it.next()), Integer.valueOf(this.f١٩٥٨h));
            }
        }
    }
}
