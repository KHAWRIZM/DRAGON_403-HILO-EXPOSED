package com.tencent.liteav.sdkcommon;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class g {
    final Context c;
    final ArrayAdapter<String> e;
    WindowManager f;
    View g;
    TextView h;
    TextView i;
    Spinner j;
    ScrollView k;
    String l;
    final a o;
    final DisplayMetrics a = new DisplayMetrics();
    final WindowManager.LayoutParams b = new WindowManager.LayoutParams();
    private final int p = -65536;
    private boolean q = false;
    boolean m = false;
    int n = 1920;
    final Handler d = new Handler(Looper.getMainLooper());

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface a {
        void a(int i);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class b implements View.OnTouchListener {
        private int b;
        private int c;

        private b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    int i = rawX - this.b;
                    int i2 = rawY - this.c;
                    WindowManager.LayoutParams layoutParams = g.this.b;
                    int i3 = layoutParams.x + i;
                    layoutParams.x = i3;
                    layoutParams.y += i2;
                    this.b = rawX;
                    this.c = rawY;
                    layoutParams.x = Math.max(i3, 0);
                    WindowManager.LayoutParams layoutParams2 = g.this.b;
                    layoutParams2.y = Math.max(layoutParams2.y, 0);
                    g gVar = g.this;
                    WindowManager.LayoutParams layoutParams3 = gVar.b;
                    int i4 = layoutParams3.x;
                    DisplayMetrics displayMetrics = gVar.a;
                    int i5 = displayMetrics.widthPixels;
                    if (i4 + i5 > i5) {
                        layoutParams3.width = i5 - i4;
                    } else {
                        layoutParams3.width = i5;
                    }
                    int i6 = gVar.n;
                    layoutParams3.height = i6;
                    if (gVar.m) {
                        layoutParams3.height = i6 / 2;
                    }
                    int i7 = layoutParams3.y;
                    int i8 = layoutParams3.height + i7;
                    int i9 = displayMetrics.heightPixels;
                    if (i8 > i9) {
                        layoutParams3.height = i9 - i7;
                    }
                    ViewGroup.LayoutParams layoutParams4 = gVar.k.getLayoutParams();
                    layoutParams4.height = g.this.b();
                    g.this.k.setLayoutParams(layoutParams4);
                    g gVar2 = g.this;
                    gVar2.f.updateViewLayout(view, gVar2.b);
                }
            } else {
                this.b = (int) motionEvent.getRawX();
                this.c = (int) motionEvent.getRawY();
            }
            view.performClick();
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(g gVar, byte b) {
            this();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class c implements AdapterView.OnItemSelectedListener {
        private c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (view == null) {
                return;
            }
            ((TextView) view).setTextColor(-65536);
            g gVar = g.this;
            gVar.l = gVar.e.getItem(i);
            g.this.o.a(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(g gVar, byte b) {
            this();
        }
    }

    public g(Context context, a aVar) {
        this.c = context;
        this.o = aVar;
        this.e = new ArrayAdapter<>(context, R.layout.simple_spinner_item);
    }

    public final void a(boolean z) {
        if (z == this.q) {
            return;
        }
        if (z) {
            this.f.addView(this.g, this.b);
        } else {
            this.f.removeView(this.g);
        }
        this.q = z;
    }

    public final void b(String str) {
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return Math.max((this.b.height - a(230)) - a(20), 0);
    }

    public final void a(String str) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(str);
        }
        this.d.post(h.a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        TextView textView;
        Spinner spinner = this.j;
        if (spinner == null || (textView = (TextView) spinner.getChildAt(spinner.getSelectedItemPosition())) == null) {
            return;
        }
        textView.setTextColor(-65536);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(int i) {
        return (int) ((i * this.c.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
