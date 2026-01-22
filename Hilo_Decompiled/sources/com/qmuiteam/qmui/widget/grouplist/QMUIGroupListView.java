package com.qmuiteam.qmui.widget.grouplist;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.LinearLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIGroupListView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray f١٣١٧٥a;

    public QMUIGroupListView(Context context) {
        this(context, null);
    }

    public int getSectionCount() {
        return this.f١٣١٧٥a.size();
    }

    public QMUIGroupListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIGroupListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣١٧٥a = new SparseArray();
        setOrientation(1);
    }
}
