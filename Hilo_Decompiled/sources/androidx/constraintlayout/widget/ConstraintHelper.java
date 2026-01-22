package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.c;
import c2.i;
import c2.j;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a, reason: collision with root package name */
    protected int[] f٢٢٨٨a;

    /* renamed from: b, reason: collision with root package name */
    protected int f٢٢٨٩b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f٢٢٩٠c;

    /* renamed from: d, reason: collision with root package name */
    protected i f٢٢٩١d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f٢٢٩٢e;

    /* renamed from: f, reason: collision with root package name */
    protected String f٢٢٩٣f;

    /* renamed from: g, reason: collision with root package name */
    protected String f٢٢٩٤g;

    /* renamed from: h, reason: collision with root package name */
    private View[] f٢٢٩٥h;

    /* renamed from: i, reason: collision with root package name */
    protected HashMap f٢٢٩٦i;

    public ConstraintHelper(Context context) {
        super(context);
        this.f٢٢٨٨a = new int[32];
        this.f٢٢٩٢e = false;
        this.f٢٢٩٥h = null;
        this.f٢٢٩٦i = new HashMap();
        this.f٢٢٩٠c = context;
        n(null);
    }

    private void d(String str) {
        if (str == null || str.length() == 0 || this.f٢٢٩٠c == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int l10 = l(trim);
        if (l10 != 0) {
            this.f٢٢٩٦i.put(Integer.valueOf(l10), trim);
            e(l10);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void e(int i10) {
        if (i10 == getId()) {
            return;
        }
        int i11 = this.f٢٢٨٩b + 1;
        int[] iArr = this.f٢٢٨٨a;
        if (i11 > iArr.length) {
            this.f٢٢٨٨a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f٢٢٨٨a;
        int i12 = this.f٢٢٨٩b;
        iArr2[i12] = i10;
        this.f٢٢٨٩b = i12 + 1;
    }

    private void f(String str) {
        ConstraintLayout constraintLayout;
        if (str == null || str.length() == 0 || this.f٢٢٩٠c == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        } else {
            constraintLayout = null;
        }
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && trim.equals(((ConstraintLayout.b) layoutParams).f٢٣٠٤c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    e(childAt.getId());
                }
            }
        }
    }

    private int[] j(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i10 = 0;
        for (String str2 : split) {
            int l10 = l(str2.trim());
            if (l10 != 0) {
                iArr[i10] = l10;
                i10++;
            }
        }
        if (i10 != split.length) {
            return Arrays.copyOf(iArr, i10);
        }
        return iArr;
    }

    private int k(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.f٢٢٩٠c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int l(String str) {
        ConstraintLayout constraintLayout;
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        } else {
            constraintLayout = null;
        }
        int i10 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i10 = ((Integer) designInformation).intValue();
            }
        }
        if (i10 == 0 && constraintLayout != null) {
            i10 = k(constraintLayout, str);
        }
        if (i10 == 0) {
            try {
                i10 = R.id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (i10 == 0) {
            return this.f٢٢٩٠c.getResources().getIdentifier(str, "id", this.f٢٢٩٠c.getPackageName());
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            h((ConstraintLayout) parent);
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f٢٢٨٨a, this.f٢٢٨٩b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i10 = 0; i10 < this.f٢٢٨٩b; i10++) {
            View viewById = constraintLayout.getViewById(this.f٢٢٨٨a[i10]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > DownloadProgress.UNKNOWN_PROGRESS) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(ConstraintLayout constraintLayout) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] m(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f٢٢٩٥h;
        if (viewArr == null || viewArr.length != this.f٢٢٨٩b) {
            this.f٢٢٩٥h = new View[this.f٢٢٨٩b];
        }
        for (int i10 = 0; i10 < this.f٢٢٨٩b; i10++) {
            this.f٢٢٩٥h[i10] = constraintLayout.getViewById(this.f٢٢٨٨a[i10]);
        }
        return this.f٢٢٩٥h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f٢٢٩٣f = string;
                    setIds(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f٢٢٩٤g = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void o(c.a aVar, j jVar, ConstraintLayout.b bVar, SparseArray sparseArray) {
        c.b bVar2 = aVar.f٢٤١٩e;
        int[] iArr = bVar2.f٢٤٥٨k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = bVar2.f٢٤٦٠l0;
            if (str != null) {
                if (str.length() > 0) {
                    c.b bVar3 = aVar.f٢٤١٩e;
                    bVar3.f٢٤٥٨k0 = j(this, bVar3.f٢٤٦٠l0);
                } else {
                    aVar.f٢٤١٩e.f٢٤٥٨k0 = null;
                }
            }
        }
        if (jVar != null) {
            jVar.c();
            if (aVar.f٢٤١٩e.f٢٤٥٨k0 != null) {
                int i10 = 0;
                while (true) {
                    int[] iArr2 = aVar.f٢٤١٩e.f٢٤٥٨k0;
                    if (i10 < iArr2.length) {
                        c2.e eVar = (c2.e) sparseArray.get(iArr2[i10]);
                        if (eVar != null) {
                            jVar.a(eVar);
                        }
                        i10++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f٢٢٩٣f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f٢٢٩٤g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f٢٢٩٢e) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void q(ConstraintLayout constraintLayout) {
    }

    public void r(ConstraintLayout constraintLayout) {
    }

    public void s(ConstraintLayout constraintLayout) {
    }

    protected void setIds(String str) {
        this.f٢٢٩٣f = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f٢٢٨٩b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i10);
            if (indexOf == -1) {
                d(str.substring(i10));
                return;
            } else {
                d(str.substring(i10, indexOf));
                i10 = indexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.f٢٢٩٤g = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f٢٢٨٩b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i10);
            if (indexOf == -1) {
                f(str.substring(i10));
                return;
            } else {
                f(str.substring(i10, indexOf));
                i10 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f٢٢٩٣f = null;
        this.f٢٢٨٩b = 0;
        for (int i10 : iArr) {
            e(i10);
        }
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        super.setTag(i10, obj);
        if (obj == null && this.f٢٢٩٣f == null) {
            e(i10);
        }
    }

    public void t(ConstraintLayout constraintLayout) {
        String str;
        int k10;
        if (isInEditMode()) {
            setIds(this.f٢٢٩٣f);
        }
        i iVar = this.f٢٢٩١d;
        if (iVar == null) {
            return;
        }
        iVar.c();
        for (int i10 = 0; i10 < this.f٢٢٨٩b; i10++) {
            int i11 = this.f٢٢٨٨a[i10];
            View viewById = constraintLayout.getViewById(i11);
            if (viewById == null && (k10 = k(constraintLayout, (str = (String) this.f٢٢٩٦i.get(Integer.valueOf(i11))))) != 0) {
                this.f٢٢٨٨a[i10] = k10;
                this.f٢٢٩٦i.put(Integer.valueOf(k10), str);
                viewById = constraintLayout.getViewById(k10);
            }
            if (viewById != null) {
                this.f٢٢٩١d.a(constraintLayout.getViewWidget(viewById));
            }
        }
        this.f٢٢٩١d.b(constraintLayout.mLayoutWidget);
    }

    public void u(c2.f fVar, i iVar, SparseArray sparseArray) {
        iVar.c();
        for (int i10 = 0; i10 < this.f٢٢٨٩b; i10++) {
            iVar.a((c2.e) sparseArray.get(this.f٢٢٨٨a[i10]));
        }
    }

    public void v() {
        if (this.f٢٢٩١d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f٢٣٤٢v0 = (c2.e) this.f٢٢٩١d;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٢٢٨٨a = new int[32];
        this.f٢٢٩٢e = false;
        this.f٢٢٩٥h = null;
        this.f٢٢٩٦i = new HashMap();
        this.f٢٢٩٠c = context;
        n(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٢٢٨٨a = new int[32];
        this.f٢٢٩٢e = false;
        this.f٢٢٩٥h = null;
        this.f٢٢٩٦i = new HashMap();
        this.f٢٢٩٠c = context;
        n(attributeSet);
    }

    public void p(c2.e eVar, boolean z10) {
    }
}
