package tech.sud.runtime.core;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class i extends FrameLayout {
    private View a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private final Window g;
    private final View h;
    private boolean i;
    private int j;
    private final AtomicInteger k;
    private final g l;
    private tech.sud.runtime.component.e.d m;
    private final a n;
    private final ViewTreeObserver.OnGlobalLayoutListener o;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface a {
        void a();
    }

    public i(g gVar, Context context, a aVar) {
        super(context);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.j = 0;
        this.k = new AtomicInteger(0);
        this.o = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tech.sud.runtime.core.i.2
            final Rect a = new Rect();

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if ((i.this.g.getAttributes().flags & 512) == 0) {
                    this.a.setEmpty();
                    i.this.h.getWindowVisibleDisplayFrame(this.a);
                    int height = this.a.height();
                    if (i.this.j == 0) {
                        i.this.j = height;
                        i iVar = i.this;
                        iVar.i = tech.sud.runtime.component.c.h.b(iVar.getContext());
                        return;
                    }
                    if (i.this.j == height) {
                        return;
                    }
                    boolean b = tech.sud.runtime.component.c.h.b(i.this.getContext());
                    if (b != i.this.i) {
                        i.this.j = height;
                        i.this.i = b;
                        if (i.this.m != null) {
                            i.this.m.b();
                        }
                        i.this.b(false);
                        return;
                    }
                    if (i.this.j - height > 200) {
                        i.this.b(true);
                    } else if (height - i.this.j > 200) {
                        i.this.b(false);
                        i.this.n.a();
                    }
                    i.this.j = height;
                }
            }
        };
        this.l = gVar;
        Window window = tech.sud.runtime.component.h.c.a(context).getWindow();
        this.g = window;
        this.h = window.getDecorView();
        this.n = aVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.e = i;
        this.f = i2;
        b();
    }

    private void d() {
        if ((this.e == this.c && this.f == this.d) || this.a == null) {
            return;
        }
        post(new Runnable() { // from class: tech.sud.runtime.core.i.1
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.c()) {
                    if ((i.this.e != i.this.c || i.this.f != i.this.d) && i.this.a != null) {
                        i.this.a.setLayoutParams(new FrameLayout.LayoutParams(i.this.e, i.this.f));
                        i iVar = i.this;
                        iVar.c = iVar.e;
                        i iVar2 = i.this;
                        iVar2.d = iVar2.f;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return (this.b || this.m.c() || this.k.get() != 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.b = z;
        b();
    }

    public void a(tech.sud.runtime.component.e.d dVar) {
        this.m = dVar;
    }

    public void a(View view) {
        this.a = view;
        addView(view);
        getViewTreeObserver().addOnGlobalLayoutListener(this.o);
    }

    public void b() {
        if (c()) {
            d();
        }
    }

    public void a() {
        removeView(this.a);
        this.a = null;
    }

    public void a(boolean z) {
        this.k.addAndGet(z ? 1 : -1);
    }
}
