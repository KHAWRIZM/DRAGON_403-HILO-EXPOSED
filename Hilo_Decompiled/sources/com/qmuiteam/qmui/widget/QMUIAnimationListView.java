package com.qmuiteam.qmui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import yb.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIAnimationListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    protected final LongSparseArray f١٢٩٠٦a;

    /* renamed from: b, reason: collision with root package name */
    protected final LongSparseArray f١٢٩٠٧b;

    /* renamed from: c, reason: collision with root package name */
    protected final LongSparseArray f١٢٩٠٨c;

    /* renamed from: d, reason: collision with root package name */
    protected final Set f١٢٩٠٩d;

    /* renamed from: e, reason: collision with root package name */
    protected final Set f١٢٩١٠e;

    /* renamed from: f, reason: collision with root package name */
    private final List f١٢٩١١f;

    /* renamed from: g, reason: collision with root package name */
    private final List f١٢٩١٢g;

    /* renamed from: h, reason: collision with root package name */
    private long f١٢٩١٣h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f١٢٩١٤i;

    /* renamed from: j, reason: collision with root package name */
    private ListAdapter f١٢٩١٥j;

    /* renamed from: k, reason: collision with root package name */
    private a f١٢٩١٦k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f١٢٩١٧l;

    /* renamed from: m, reason: collision with root package name */
    private int f١٢٩١٨m;

    /* renamed from: n, reason: collision with root package name */
    private long f١٢٩١٩n;

    /* renamed from: o, reason: collision with root package name */
    private float f١٢٩٢٠o;

    /* renamed from: p, reason: collision with root package name */
    private Interpolator f١٢٩٢١p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٢٩٢٢q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ListAdapter f١٢٩٢٣a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f١٢٩٢٤b = true;

        /* renamed from: c, reason: collision with root package name */
        private final DataSetObserver f١٢٩٢٥c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١٢٩٢٦d;

        /* renamed from: com.qmuiteam.qmui.widget.QMUIAnimationListView$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        class C٠١٤٧a extends DataSetObserver {
            C٠١٤٧a() {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                if (a.this.f١٢٩٢٤b) {
                    a.this.notifyDataSetChanged();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                a.this.notifyDataSetInvalidated();
            }
        }

        public a(ListAdapter listAdapter) {
            C٠١٤٧a r02 = new C٠١٤٧a();
            this.f١٢٩٢٥c = r02;
            this.f١٢٩٢٦d = false;
            this.f١٢٩٢٣a = listAdapter;
            listAdapter.registerDataSetObserver(r02);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f١٢٩٢٣a.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return this.f١٢٩٢٣a.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return this.f١٢٩٢٣a.getItemId(i10);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i10) {
            return this.f١٢٩٢٣a.getItemViewType(i10);
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            return this.f١٢٩٢٣a.getView(i10, view, viewGroup);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.f١٢٩٢٣a.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            boolean hasStableIds = this.f١٢٩٢٣a.hasStableIds();
            this.f١٢٩٢٦d = hasStableIds;
            return hasStableIds;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                b.a("QMUIAnimationListView", "notifyDataSetChanged not in main Thread", new Object[0]);
            } else {
                super.notifyDataSetChanged();
            }
        }
    }

    public QMUIAnimationListView(Context context) {
        this(context, null);
    }

    private void b() {
        setWillNotDraw(false);
    }

    protected int a(long j10) {
        for (int i10 = 0; i10 < this.f١٢٩١٦k.getCount(); i10++) {
            if (this.f١٢٩١٦k.getItemId(i10) == j10) {
                return i10;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    protected long getChangeDisappearDuration() {
        return getHeight() * this.f١٢٩٢٠o;
    }

    public float getOffsetDurationUnit() {
        return this.f١٢٩٢٠o;
    }

    public ListAdapter getRealAdapter() {
        return this.f١٢٩١٥j;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ValueAnimator valueAnimator;
        int intValue;
        super.onDraw(canvas);
        if (this.f١٢٩٢٢q && (valueAnimator = this.f١٢٩١٤i) != null && valueAnimator.isStarted() && this.f١٢٩٠٨c.size() > 0 && this.f١٢٩١٧l) {
            for (int i10 = 0; i10 < this.f١٢٩٠٨c.size(); i10++) {
                long keyAt = this.f١٢٩٠٨c.keyAt(i10);
                View view = (View) this.f١٢٩٠٨c.valueAt(i10);
                int a10 = a(keyAt);
                int i11 = (int) (((float) this.f١٢٩١٣h) / this.f١٢٩٢٠o);
                if (a10 < getFirstVisiblePosition()) {
                    intValue = ((Integer) this.f١٢٩٠٦a.get(keyAt)).intValue() - i11;
                    if (intValue < (-view.getHeight())) {
                    }
                    view.layout(0, intValue, view.getWidth(), view.getHeight() + intValue);
                    view.setAlpha(1.0f - ((((float) this.f١٢٩١٣h) * 1.0f) / ((float) getChangeDisappearDuration())));
                    drawChild(canvas, view, getDrawingTime());
                } else {
                    intValue = ((Integer) this.f١٢٩٠٦a.get(keyAt)).intValue() + i11;
                    if (intValue > getHeight()) {
                    }
                    view.layout(0, intValue, view.getWidth(), view.getHeight() + intValue);
                    view.setAlpha(1.0f - ((((float) this.f١٢٩١٣h) * 1.0f) / ((float) getChangeDisappearDuration())));
                    drawChild(canvas, view, getDrawingTime());
                }
            }
        }
    }

    public void setAnimationManipulateDurationLimit(int i10) {
        this.f١٢٩١٨m = i10;
    }

    public void setOffsetDurationUnit(float f10) {
        this.f١٢٩٢٠o = f10;
    }

    public void setOffsetInterpolator(Interpolator interpolator) {
        this.f١٢٩٢١p = interpolator;
    }

    public void setOpenChangeDisappearAnimation(boolean z10) {
        this.f١٢٩٢٢q = z10;
    }

    public QMUIAnimationListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٩٠٦a = new LongSparseArray();
        this.f١٢٩٠٧b = new LongSparseArray();
        this.f١٢٩٠٨c = new LongSparseArray();
        this.f١٢٩٠٩d = new HashSet();
        this.f١٢٩١٠e = new HashSet();
        this.f١٢٩١١f = new ArrayList();
        this.f١٢٩١٢g = new ArrayList();
        this.f١٢٩١٣h = 0L;
        this.f١٢٩١٧l = false;
        this.f١٢٩١٨m = 0;
        this.f١٢٩١٩n = 0L;
        this.f١٢٩٢٠o = 0.5f;
        this.f١٢٩٢١p = new LinearInterpolator();
        this.f١٢٩٢٢q = false;
        b();
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        this.f١٢٩١٥j = listAdapter;
        a aVar = listAdapter != null ? new a(this.f١٢٩١٥j) : null;
        this.f١٢٩١٦k = aVar;
        super.setAdapter((ListAdapter) aVar);
    }

    public QMUIAnimationListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٩٠٦a = new LongSparseArray();
        this.f١٢٩٠٧b = new LongSparseArray();
        this.f١٢٩٠٨c = new LongSparseArray();
        this.f١٢٩٠٩d = new HashSet();
        this.f١٢٩١٠e = new HashSet();
        this.f١٢٩١١f = new ArrayList();
        this.f١٢٩١٢g = new ArrayList();
        this.f١٢٩١٣h = 0L;
        this.f١٢٩١٧l = false;
        this.f١٢٩١٨m = 0;
        this.f١٢٩١٩n = 0L;
        this.f١٢٩٢٠o = 0.5f;
        this.f١٢٩٢١p = new LinearInterpolator();
        this.f١٢٩٢٢q = false;
        b();
    }
}
