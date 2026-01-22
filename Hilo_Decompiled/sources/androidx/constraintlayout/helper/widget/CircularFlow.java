package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CircularFlow extends VirtualLayout {

    /* renamed from: v, reason: collision with root package name */
    private static int f١٧٩٦v;

    /* renamed from: w, reason: collision with root package name */
    private static float f١٧٩٧w;

    /* renamed from: l, reason: collision with root package name */
    ConstraintLayout f١٧٩٨l;

    /* renamed from: m, reason: collision with root package name */
    int f١٧٩٩m;

    /* renamed from: n, reason: collision with root package name */
    private float[] f١٨٠٠n;

    /* renamed from: o, reason: collision with root package name */
    private int[] f١٨٠١o;

    /* renamed from: p, reason: collision with root package name */
    private int f١٨٠٢p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٨٠٣q;

    /* renamed from: r, reason: collision with root package name */
    private String f١٨٠٤r;

    /* renamed from: s, reason: collision with root package name */
    private String f١٨٠٥s;

    /* renamed from: t, reason: collision with root package name */
    private Float f١٨٠٦t;

    /* renamed from: u, reason: collision with root package name */
    private Integer f١٨٠٧u;

    public CircularFlow(Context context) {
        super(context);
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f١٨٠٣q = 0;
        while (true) {
            int indexOf = str.indexOf(44, i10);
            if (indexOf == -1) {
                x(str.substring(i10).trim());
                return;
            } else {
                x(str.substring(i10, indexOf).trim());
                i10 = indexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f١٨٠٢p = 0;
        while (true) {
            int indexOf = str.indexOf(44, i10);
            if (indexOf == -1) {
                y(str.substring(i10).trim());
                return;
            } else {
                y(str.substring(i10, indexOf).trim());
                i10 = indexOf + 1;
            }
        }
    }

    private void x(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.f٢٢٩٠c == null || (fArr = this.f١٨٠٠n) == null) {
            return;
        }
        if (this.f١٨٠٣q + 1 > fArr.length) {
            this.f١٨٠٠n = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.f١٨٠٠n[this.f١٨٠٣q] = Integer.parseInt(str);
        this.f١٨٠٣q++;
    }

    private void y(String str) {
        int[] iArr;
        if (str == null || str.length() == 0 || this.f٢٢٩٠c == null || (iArr = this.f١٨٠١o) == null) {
            return;
        }
        if (this.f١٨٠٢p + 1 > iArr.length) {
            this.f١٨٠١o = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.f١٨٠١o[this.f١٨٠٢p] = (int) (Integer.parseInt(str) * this.f٢٢٩٠c.getResources().getDisplayMetrics().density);
        this.f١٨٠٢p++;
    }

    private void z() {
        this.f١٧٩٨l = (ConstraintLayout) getParent();
        for (int i10 = 0; i10 < this.f٢٢٨٩b; i10++) {
            View viewById = this.f١٧٩٨l.getViewById(this.f٢٢٨٨a[i10]);
            if (viewById != null) {
                int i11 = f١٧٩٦v;
                float f10 = f١٧٩٧w;
                int[] iArr = this.f١٨٠١o;
                if (iArr != null && i10 < iArr.length) {
                    i11 = iArr[i10];
                } else {
                    Integer num = this.f١٨٠٧u;
                    if (num != null && num.intValue() != -1) {
                        this.f١٨٠٢p++;
                        if (this.f١٨٠١o == null) {
                            this.f١٨٠١o = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f١٨٠١o = radius;
                        radius[this.f١٨٠٢p - 1] = i11;
                    } else {
                        Log.e("CircularFlow", "Added radius to view with id: " + ((String) this.f٢٢٩٦i.get(Integer.valueOf(viewById.getId()))));
                    }
                }
                float[] fArr = this.f١٨٠٠n;
                if (fArr != null && i10 < fArr.length) {
                    f10 = fArr[i10];
                } else {
                    Float f11 = this.f١٨٠٦t;
                    if (f11 != null && f11.floatValue() != -1.0f) {
                        this.f١٨٠٣q++;
                        if (this.f١٨٠٠n == null) {
                            this.f١٨٠٠n = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f١٨٠٠n = angles;
                        angles[this.f١٨٠٣q - 1] = f10;
                    } else {
                        Log.e("CircularFlow", "Added angle to view with id: " + ((String) this.f٢٢٩٦i.get(Integer.valueOf(viewById.getId()))));
                    }
                }
                ConstraintLayout.b bVar = (ConstraintLayout.b) viewById.getLayoutParams();
                bVar.f٢٣٣٣r = f10;
                bVar.f٢٣٢٩p = this.f١٧٩٩m;
                bVar.f٢٣٣١q = i11;
                viewById.setLayoutParams(bVar);
            }
        }
        g();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f١٨٠٠n, this.f١٨٠٣q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f١٨٠١o, this.f١٨٠٢p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f١٧٩٩m = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f١٨٠٤r = string;
                    setAngles(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f١٨٠٥s = string2;
                    setRadius(string2);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, f١٧٩٧w));
                    this.f١٨٠٦t = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, f١٧٩٦v));
                    this.f١٨٠٧u = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f١٨٠٤r;
        if (str != null) {
            this.f١٨٠٠n = new float[1];
            setAngles(str);
        }
        String str2 = this.f١٨٠٥s;
        if (str2 != null) {
            this.f١٨٠١o = new int[1];
            setRadius(str2);
        }
        Float f10 = this.f١٨٠٦t;
        if (f10 != null) {
            setDefaultAngle(f10.floatValue());
        }
        Integer num = this.f١٨٠٧u;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        z();
    }

    public void setDefaultAngle(float f10) {
        f١٧٩٧w = f10;
    }

    public void setDefaultRadius(int i10) {
        f١٧٩٦v = i10;
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
