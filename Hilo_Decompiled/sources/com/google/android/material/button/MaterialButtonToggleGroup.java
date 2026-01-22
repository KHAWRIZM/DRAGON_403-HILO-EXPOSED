package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.core.view.d1;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import m2.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialButtonToggleGroup extends MaterialButtonGroup {

    /* renamed from: r, reason: collision with root package name */
    private static final int f٨٥٤٢r = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: l, reason: collision with root package name */
    private final LinkedHashSet f٨٥٤٣l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٨٥٤٤m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f٨٥٤٥n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٨٥٤٦o;

    /* renamed from: p, reason: collision with root package name */
    private final int f٨٥٤٧p;

    /* renamed from: q, reason: collision with root package name */
    private Set f٨٥٤٨q;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            g0Var.r0(g0.f.a(0, 1, MaterialButtonToggleGroup.this.u(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10);
    }

    public MaterialButtonToggleGroup(Context context) {
        this(context, null);
    }

    private String getChildrenA11yClassName() {
        Class cls;
        if (this.f٨٥٤٥n) {
            cls = RadioButton.class;
        } else {
            cls = ToggleButton.class;
        }
        return cls.getName();
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && j(i11)) {
                i10++;
            }
        }
        return i10;
    }

    private boolean j(int i10) {
        if (getChildAt(i10).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private void r(int i10, boolean z10) {
        if (i10 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i10);
            return;
        }
        HashSet hashSet = new HashSet(this.f٨٥٤٨q);
        if (z10 && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.f٨٥٤٥n && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else if (!z10 && hashSet.contains(Integer.valueOf(i10))) {
            if (!this.f٨٥٤٦o || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        } else {
            return;
        }
        y(hashSet);
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setA11yClassName(getChildrenA11yClassName());
    }

    private void t(int i10, boolean z10) {
        Iterator it = this.f٨٥٤٣l.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this, i10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == view) {
                return i10;
            }
            if ((getChildAt(i11) instanceof MaterialButton) && j(i11)) {
                i10++;
            }
        }
        return -1;
    }

    private void x(int i10, boolean z10) {
        View findViewById = findViewById(i10);
        if (findViewById instanceof MaterialButton) {
            this.f٨٥٤٤m = true;
            ((MaterialButton) findViewById).setChecked(z10);
            this.f٨٥٤٤m = false;
        }
    }

    private void y(Set set) {
        Set set2 = this.f٨٥٤٨q;
        this.f٨٥٤٨q = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id = f(i10).getId();
            x(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                t(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void z() {
        String childrenA11yClassName = getChildrenA11yClassName();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            f(i10).setA11yClassName(childrenA11yClassName);
        }
    }

    public void addOnButtonCheckedListener(b bVar) {
        this.f٨٥٤٣l.add(bVar);
    }

    @Override // com.google.android.material.button.MaterialButtonGroup, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setupButtonChild(materialButton);
        r(materialButton.getId(), materialButton.isChecked());
        d1.q0(materialButton, new a());
    }

    public int getCheckedButtonId() {
        if (this.f٨٥٤٥n && !this.f٨٥٤٨q.isEmpty()) {
            return ((Integer) this.f٨٥٤٨q.iterator().next()).intValue();
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id = f(i10).getId();
            if (this.f٨٥٤٨q.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f٨٥٤٧p;
        if (i10 != -1) {
            y(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        g0 V0 = g0.V0(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (v()) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        V0.q0(g0.e.b(1, visibleButtonCount, false, i10));
    }

    public void removeOnButtonCheckedListener(b bVar) {
        this.f٨٥٤٣l.remove(bVar);
    }

    public void s() {
        y(new HashSet());
    }

    public void setSelectionRequired(boolean z10) {
        this.f٨٥٤٦o = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.f٨٥٤٥n != z10) {
            this.f٨٥٤٥n = z10;
            s();
        }
        z();
    }

    public boolean v() {
        return this.f٨٥٤٥n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(MaterialButton materialButton, boolean z10) {
        if (this.f٨٥٤٤m) {
            return;
        }
        r(materialButton.getId(), z10);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f٨٥٤٢r;
        this.f٨٥٤٣l = new LinkedHashSet();
        this.f٨٥٤٤m = false;
        this.f٨٥٤٨q = new HashSet();
        TypedArray i12 = h0.i(getContext(), attributeSet, R.styleable.MaterialButtonToggleGroup, i10, i11, new int[0]);
        setSingleSelection(i12.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.f٨٥٤٧p = i12.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f٨٥٤٦o = i12.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        if (this.f٨٥٣٦f == null) {
            this.f٨٥٣٦f = v.c(new f8.a(DownloadProgress.UNKNOWN_PROGRESS));
        }
        setEnabled(i12.getBoolean(R.styleable.MaterialButtonToggleGroup_android_enabled, true));
        i12.recycle();
        setImportantForAccessibility(1);
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}
