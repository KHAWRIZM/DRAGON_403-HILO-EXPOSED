package j4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bigkoo.pickerview.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f١٥٢٠٦a;

    /* renamed from: b, reason: collision with root package name */
    protected ViewGroup f١٥٢٠٧b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f١٥٢٠٨c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f١٥٢٠٩d;

    /* renamed from: e, reason: collision with root package name */
    protected g4.a f١٥٢١٠e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٥٢١١f;

    /* renamed from: g, reason: collision with root package name */
    private Animation f١٥٢١٢g;

    /* renamed from: h, reason: collision with root package name */
    private Animation f١٥٢١٣h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٥٢١٤i;

    /* renamed from: k, reason: collision with root package name */
    private Dialog f١٥٢١٦k;

    /* renamed from: l, reason: collision with root package name */
    protected View f١٥٢١٧l;

    /* renamed from: j, reason: collision with root package name */
    protected int f١٥٢١٥j = 80;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٥٢١٨m = true;

    /* renamed from: n, reason: collision with root package name */
    private View.OnKeyListener f١٥٢١٩n = new d();

    /* renamed from: o, reason: collision with root package name */
    private final View.OnTouchListener f١٥٢٢٠o = new e();

    /* renamed from: j4.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class ViewOnClickListenerC٠١٧١a implements View.OnClickListener {
        ViewOnClickListenerC٠١٧١a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f١٥٢١٠e.D.removeView(aVar.f١٥٢٠٨c);
            a.this.f١٥٢١٤i = false;
            a.this.f١٥٢١١f = false;
            a.d(a.this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class d implements View.OnKeyListener {
        d() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (i10 == 4 && keyEvent.getAction() == 0 && a.this.o()) {
                a.this.f();
                return true;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.f();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class f implements DialogInterface.OnDismissListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.d(a.this);
        }
    }

    public a(Context context) {
        this.f١٥٢٠٦a = context;
    }

    static /* synthetic */ h4.c d(a aVar) {
        aVar.getClass();
        return null;
    }

    private void g() {
        Dialog dialog = this.f١٥٢١٦k;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private Animation j() {
        return AnimationUtils.loadAnimation(this.f١٥٢٠٦a, i4.c.a(this.f١٥٢١٥j, true));
    }

    private Animation k() {
        return AnimationUtils.loadAnimation(this.f١٥٢٠٦a, i4.c.a(this.f١٥٢١٥j, false));
    }

    private void p(View view) {
        this.f١٥٢١٠e.D.addView(view);
        if (this.f١٥٢١٨m) {
            this.f١٥٢٠٧b.startAnimation(this.f١٥٢١٣h);
        }
    }

    private void w() {
        Dialog dialog = this.f١٥٢١٦k;
        if (dialog != null) {
            dialog.show();
        }
    }

    public void e() {
        if (this.f١٥٢٠٩d != null) {
            Dialog dialog = new Dialog(this.f١٥٢٠٦a, R.style.custom_dialog2);
            this.f١٥٢١٦k = dialog;
            dialog.setCancelable(this.f١٥٢١٠e.X);
            this.f١٥٢١٦k.setContentView(this.f١٥٢٠٩d);
            Window window = this.f١٥٢١٦k.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.f١٥٢١٦k.setOnDismissListener(new f());
        }
    }

    public void f() {
        if (n()) {
            g();
            return;
        }
        if (this.f١٥٢١١f) {
            return;
        }
        if (this.f١٥٢١٨m) {
            this.f١٥٢١٢g.setAnimationListener(new b());
            this.f١٥٢٠٧b.startAnimation(this.f١٥٢١٢g);
        } else {
            h();
        }
        this.f١٥٢١١f = true;
    }

    public void h() {
        this.f١٥٢١٠e.D.post(new c());
    }

    public View i(int i10) {
        return this.f١٥٢٠٧b.findViewById(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        this.f١٥٢١٣h = j();
        this.f١٥٢١٢g = k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.f١٥٢٠٦a);
        if (n()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.f١٥٢٠٩d = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f١٥٢٠٩d.findViewById(R.id.content_container);
            this.f١٥٢٠٧b = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            e();
            this.f١٥٢٠٩d.setOnClickListener(new ViewOnClickListenerC٠١٧١a());
        } else {
            g4.a aVar = this.f١٥٢١٠e;
            if (aVar.D == null) {
                aVar.D = (ViewGroup) ((Activity) this.f١٥٢٠٦a).getWindow().getDecorView();
            }
            ViewGroup viewGroup3 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.f١٥٢١٠e.D, false);
            this.f١٥٢٠٨c = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int i10 = this.f١٥٢١٠e.U;
            if (i10 != -1) {
                this.f١٥٢٠٨c.setBackgroundColor(i10);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.f١٥٢٠٨c.findViewById(R.id.content_container);
            this.f١٥٢٠٧b = viewGroup4;
            viewGroup4.setLayoutParams(layoutParams);
        }
        r(true);
    }

    public abstract boolean n();

    public boolean o() {
        if (n()) {
            return false;
        }
        if (this.f١٥٢٠٨c.getParent() == null && !this.f١٥٢١٤i) {
            return false;
        }
        return true;
    }

    public void q() {
        Dialog dialog = this.f١٥٢١٦k;
        if (dialog != null) {
            dialog.setCancelable(this.f١٥٢١٠e.X);
        }
    }

    public void r(boolean z10) {
        ViewGroup viewGroup;
        if (n()) {
            viewGroup = this.f١٥٢٠٩d;
        } else {
            viewGroup = this.f١٥٢٠٨c;
        }
        viewGroup.setFocusable(z10);
        viewGroup.setFocusableInTouchMode(z10);
        if (z10) {
            viewGroup.setOnKeyListener(this.f١٥٢١٩n);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a s(boolean z10) {
        ViewGroup viewGroup = this.f١٥٢٠٨c;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z10) {
                findViewById.setOnTouchListener(this.f١٥٢٢٠o);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void t() {
        if (n()) {
            w();
        } else {
            if (o()) {
                return;
            }
            this.f١٥٢١٤i = true;
            p(this.f١٥٢٠٨c);
            this.f١٥٢٠٨c.requestFocus();
        }
    }

    public void u(View view, boolean z10) {
        this.f١٥٢١٧l = view;
        this.f١٥٢١٨m = z10;
        t();
    }

    public void v(boolean z10) {
        u(null, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
