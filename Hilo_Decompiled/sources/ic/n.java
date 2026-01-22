package ic;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.b0;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import com.qmuiteam.qmui.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final i f١٤٩٠٥a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final i f١٤٩٠٦b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final i f١٤٩٠٧c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final i f١٤٩٠٨d = new d();

    /* renamed from: e, reason: collision with root package name */
    private static final j0 f١٤٩٠٩e = new e();

    /* renamed from: f, reason: collision with root package name */
    private static final j0 f١٤٩١٠f = new f();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements i {
        a() {
        }

        @Override // ic.n.i
        public void a(View view, b0 b0Var) {
            view.setPadding(b0Var.f٢٧٩٣a, b0Var.f٢٧٩٤b, b0Var.f٢٧٩٥c, b0Var.f٢٧٩٦d);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class b implements i {
        b() {
        }

        @Override // ic.n.i
        public void a(View view, b0 b0Var) {
            view.setPadding(b0Var.f٢٧٩٣a, b0Var.f٢٧٩٤b, b0Var.f٢٧٩٥c, 0);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class c implements i {
        c() {
        }

        @Override // ic.n.i
        public void a(View view, b0 b0Var) {
            view.setPadding(b0Var.f٢٧٩٣a, 0, b0Var.f٢٧٩٥c, b0Var.f٢٧٩٦d);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class d implements i {
        d() {
        }

        @Override // ic.n.i
        public void a(View view, b0 b0Var) {
            b0 b10 = n.b(view, b0Var);
            view.setPadding(b10.f٢٧٩٣a, b10.f٢٧٩٤b, b10.f٢٧٩٥c, b10.f٢٧٩٦d);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class e implements j0 {
        e() {
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            return d2.f٢٩٣٥b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class g implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f١٤٩١١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f١٤٩١٢b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f١٤٩١٣c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f١٤٩١٤d;

        g(boolean z10, int i10, i iVar, boolean z11) {
            this.f١٤٩١١a = z10;
            this.f١٤٩١٢b = i10;
            this.f١٤٩١٣c = iVar;
            this.f١٤٩١٤d = z11;
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            b0 f10;
            if (view.getFitsSystemWindows()) {
                if (this.f١٤٩١١a) {
                    f10 = d2Var.g(this.f١٤٩١٢b);
                } else {
                    f10 = d2Var.f(this.f١٤٩١٢b);
                }
                this.f١٤٩١٣c.a(view, f10);
                if (this.f١٤٩١٤d) {
                    return d2.f٢٩٣٥b;
                }
            }
            return d2Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class h implements View.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        d2 f١٤٩١٥a = null;

        /* renamed from: b, reason: collision with root package name */
        WindowInsets f١٤٩١٦b = null;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f١٤٩١٧c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f١٤٩١٨d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ j0 f١٤٩١٩e;

        h(View view, boolean z10, j0 j0Var) {
            this.f١٤٩١٧c = view;
            this.f١٤٩١٨d = z10;
            this.f١٤٩١٩e = j0Var;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            d2 y10 = d2.y(windowInsets, view);
            int i10 = Build.VERSION.SDK_INT;
            boolean z10 = true;
            if (i10 < 30) {
                n.c(windowInsets, this.f١٤٩١٧c);
                if (y10.equals(this.f١٤٩١٥a)) {
                    if (this.f١٤٩١٨d) {
                        return this.f١٤٩١٦b;
                    }
                    z10 = false;
                }
                this.f١٤٩١٥a = y10;
            }
            d2 onApplyWindowInsets = this.f١٤٩١٩e.onApplyWindowInsets(view, y10);
            if (i10 >= 30) {
                return onApplyWindowInsets.w();
            }
            if (z10) {
                d1.n0(view);
            }
            WindowInsets w10 = onApplyWindowInsets.w();
            this.f١٤٩١٦b = w10;
            return w10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface i {
        void a(View view, b0 b0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r8.f٢٣٢١l == 0) goto L٤٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005d, code lost:
    
        if (r8 != 80) goto L٤٤;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b0 b(View view, b0 b0Var) {
        int i10;
        int i11 = b0Var.f٢٧٩٣a;
        int i12 = b0Var.f٢٧٩٥c;
        int i13 = b0Var.f٢٧٩٤b;
        int i14 = b0Var.f٢٧٩٦d;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                if (bVar.f٢٣٠٧e == 0) {
                    i12 = 0;
                } else if (bVar.f٢٣١٣h == 0) {
                    i11 = 0;
                }
            }
            if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                if (bVar.f٢٣١٥i != 0) {
                }
                i14 = 0;
            }
        } else {
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                i10 = ((FrameLayout.LayoutParams) layoutParams).gravity;
            } else {
                i10 = -1;
            }
            if (i10 == -1) {
                i10 = 51;
            }
            if (layoutParams.width != -1) {
                int i15 = i10 & 7;
                if (i15 != 3) {
                    if (i15 == 5) {
                        i11 = 0;
                    }
                } else {
                    i12 = 0;
                }
            }
            if (layoutParams.height != -1) {
                int i16 = i10 & 112;
                if (i16 != 48) {
                }
                i14 = 0;
            }
        }
        return b0.b(i11, i13, i12, i14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static void d(View view, int i10) {
        f(view, i10, false);
    }

    public static void e(View view, int i10, i iVar, boolean z10, boolean z11, boolean z12) {
        i(view, new g(z11, i10, iVar, z12), z10);
    }

    public static void f(View view, int i10, boolean z10) {
        g(view, i10, z10, false);
    }

    public static void g(View view, int i10, boolean z10, boolean z11) {
        e(view, i10, f١٤٩٠٨d, z10, z11, false);
    }

    public static void h(View view) {
        i(view, f١٤٩١٠f, false);
    }

    public static void i(View view, j0 j0Var, boolean z10) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, j0Var);
        }
        if (j0Var == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new h(view, z10, j0Var));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class f implements j0 {
        f() {
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            return d2Var;
        }
    }
}
