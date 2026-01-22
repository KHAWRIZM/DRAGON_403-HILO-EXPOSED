package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import androidx.appcompat.app.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIObservableScrollView extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    private int f١٢٩٨٤a;

    /* renamed from: b, reason: collision with root package name */
    private List f١٢٩٨٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface a {
    }

    public QMUIObservableScrollView(Context context) {
        super(context);
        this.f١٢٩٨٤a = 0;
    }

    public void addOnScrollChangedListener(a aVar) {
        if (this.f١٢٩٨٥b == null) {
            this.f١٢٩٨٥b = new ArrayList();
        }
        if (this.f١٢٩٨٥b.contains(aVar)) {
            return;
        }
        this.f١٢٩٨٥b.add(aVar);
    }

    public int getScrollOffset() {
        return this.f١٢٩٨٤a;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        this.f١٢٩٨٤a = i11;
        List list = this.f١٢٩٨٥b;
        if (list != null && !list.isEmpty()) {
            Iterator it = this.f١٢٩٨٥b.iterator();
            if (it.hasNext()) {
                a0.a(it.next());
                throw null;
            }
        }
    }

    public void removeOnScrollChangedListener(a aVar) {
        List list = this.f١٢٩٨٥b;
        if (list == null) {
            return;
        }
        list.remove(aVar);
    }

    public QMUIObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٩٨٤a = 0;
    }

    public QMUIObservableScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٩٨٤a = 0;
    }
}
