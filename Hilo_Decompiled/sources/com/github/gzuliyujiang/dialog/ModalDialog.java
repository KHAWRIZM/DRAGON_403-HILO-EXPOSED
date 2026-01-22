package com.github.gzuliyujiang.dialog;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.x;
import q6.f;
import q6.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class ModalDialog extends BottomDialog implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    protected View f٧٩٤٤d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f٧٩٤٥e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f٧٩٤٦f;

    /* renamed from: g, reason: collision with root package name */
    protected TextView f٧٩٤٧g;

    /* renamed from: h, reason: collision with root package name */
    protected View f٧٩٤٨h;

    /* renamed from: i, reason: collision with root package name */
    protected View f٧٩٤٩i;

    /* renamed from: j, reason: collision with root package name */
    protected View f٧٩٥٠j;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f٧٩٥١a;

        a(CharSequence charSequence) {
            this.f٧٩٥١a = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            ModalDialog.this.f٧٩٤٦f.setText(this.f٧٩٥١a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f٧٩٥٣a;

        b(int i10) {
            this.f٧٩٥٣a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ModalDialog.this.f٧٩٤٦f.setText(this.f٧٩٥٣a);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ModalDialog(Activity activity) {
        super(activity, r0);
        int i10;
        if (f.b() == 3) {
            i10 = R.style.DialogTheme_Fade;
        } else {
            i10 = R.style.DialogTheme_Sheet;
        }
    }

    private void H() {
        if (f.b() != 1 && f.b() != 2) {
            return;
        }
        if (f.b() == 2) {
            Drawable background = this.f٧٩٤٥e.getBackground();
            if (background != null) {
                background.setColorFilter(new PorterDuffColorFilter(f.a().a(), PorterDuff.Mode.SRC_IN));
                this.f٧٩٤٥e.setBackground(background);
            } else {
                this.f٧٩٤٥e.setBackgroundResource(R.mipmap.dialog_close_icon);
            }
        } else {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.f٧٩٤٧g.getResources().getDisplayMetrics().density * 999.0f);
            gradientDrawable.setColor(f.a().a());
            this.f٧٩٤٥e.setBackground(gradientDrawable);
            if (x.d(f.a().a()) < 0.5d) {
                this.f٧٩٤٥e.setTextColor(-1);
            } else {
                this.f٧٩٤٥e.setTextColor(-10066330);
            }
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(this.f٧٩٤٧g.getResources().getDisplayMetrics().density * 999.0f);
        gradientDrawable2.setColor(f.a().d());
        this.f٧٩٤٧g.setBackground(gradientDrawable2);
        if (x.d(f.a().d()) < 0.5d) {
            this.f٧٩٤٧g.setTextColor(-1);
        } else {
            this.f٧٩٤٧g.setTextColor(-13421773);
        }
    }

    protected View A() {
        if (f.b() == 0) {
            View view = new View(this.f٧٩٤١a);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (this.f٧٩٤١a.getResources().getDisplayMetrics().density * 1.0f)));
            view.setBackgroundColor(f.a().g());
            return view;
        }
        return null;
    }

    public final View B() {
        return this.f٧٩٤٩i;
    }

    public final TextView C() {
        return this.f٧٩٤٥e;
    }

    public final View D() {
        if (this.f٧٩٤٤d == null) {
            this.f٧٩٤٤d = new View(this.f٧٩٤١a);
        }
        return this.f٧٩٤٤d;
    }

    public final TextView E() {
        return this.f٧٩٤٧g;
    }

    public final TextView F() {
        return this.f٧٩٤٦f;
    }

    public final View G() {
        return this.f٧٩٤٨h;
    }

    protected abstract void I();

    protected abstract void J();

    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    protected View c() {
        LinearLayout linearLayout = new LinearLayout(this.f٧٩٤١a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setPadding(0, 0, 0, 0);
        View z10 = z();
        this.f٧٩٤٤d = z10;
        if (z10 == null) {
            View view = new View(this.f٧٩٤١a);
            this.f٧٩٤٤d = view;
            view.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
        linearLayout.addView(this.f٧٩٤٤d);
        View A = A();
        this.f٧٩٤٨h = A;
        if (A == null) {
            View view2 = new View(this.f٧٩٤١a);
            this.f٧٩٤٨h = view2;
            view2.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
        linearLayout.addView(this.f٧٩٤٨h);
        View x10 = x();
        this.f٧٩٤٩i = x10;
        linearLayout.addView(x10, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        View y10 = y();
        this.f٧٩٥٠j = y10;
        if (y10 == null) {
            View view3 = new View(this.f٧٩٤١a);
            this.f٧٩٥٠j = view3;
            view3.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
        linearLayout.addView(this.f٧٩٥٠j);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    public void g() {
        super.g();
        int c10 = f.a().c();
        int b10 = f.b();
        if (b10 != 1 && b10 != 2) {
            if (b10 != 3) {
                n(0, c10);
            } else {
                n(2, c10);
            }
        } else {
            n(1, c10);
        }
        TextView textView = (TextView) this.f٧٩٤٢b.findViewById(R.id.dialog_modal_cancel);
        this.f٧٩٤٥e = textView;
        if (textView != null) {
            TextView textView2 = (TextView) this.f٧٩٤٢b.findViewById(R.id.dialog_modal_title);
            this.f٧٩٤٦f = textView2;
            if (textView2 != null) {
                TextView textView3 = (TextView) this.f٧٩٤٢b.findViewById(R.id.dialog_modal_ok);
                this.f٧٩٤٧g = textView3;
                if (textView3 != null) {
                    this.f٧٩٤٦f.setTextColor(f.a().f());
                    this.f٧٩٤٥e.setTextColor(f.a().b());
                    this.f٧٩٤٧g.setTextColor(f.a().e());
                    this.f٧٩٤٥e.setOnClickListener(this);
                    this.f٧٩٤٧g.setOnClickListener(this);
                    H();
                    return;
                }
                throw new IllegalArgumentException("Ok view id not found");
            }
            throw new IllegalArgumentException("Title view id not found");
        }
        throw new IllegalArgumentException("Cancel view id not found");
    }

    @Override // com.github.gzuliyujiang.dialog.BottomDialog, com.github.gzuliyujiang.dialog.BaseDialog
    public void l(Bundle bundle) {
        super.l(bundle);
        if (f.b() == 3) {
            q((int) (this.f٧٩٤١a.getResources().getDisplayMetrics().widthPixels * 0.8f));
            p(17);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.dialog_modal_cancel) {
            g.a("cancel clicked");
            I();
            dismiss();
        } else if (id == R.id.dialog_modal_ok) {
            g.a("ok clicked");
            J();
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f٧٩٤٦f;
        if (textView != null) {
            textView.post(new a(charSequence));
        } else {
            super.setTitle(charSequence);
        }
    }

    @Override // com.github.gzuliyujiang.dialog.BottomDialog
    protected boolean u() {
        if (f.b() != 3) {
            return true;
        }
        return false;
    }

    protected abstract View x();

    protected View y() {
        int b10 = f.b();
        if (b10 != 1) {
            if (b10 != 2) {
                if (b10 != 3) {
                    return null;
                }
                return View.inflate(this.f٧٩٤١a, R.layout.dialog_footer_style_3, null);
            }
            return View.inflate(this.f٧٩٤١a, R.layout.dialog_footer_style_2, null);
        }
        return View.inflate(this.f٧٩٤١a, R.layout.dialog_footer_style_1, null);
    }

    protected View z() {
        int b10 = f.b();
        if (b10 != 1) {
            if (b10 != 2) {
                if (b10 != 3) {
                    return View.inflate(this.f٧٩٤١a, R.layout.dialog_header_style_default, null);
                }
                return View.inflate(this.f٧٩٤١a, R.layout.dialog_header_style_3, null);
            }
            return View.inflate(this.f٧٩٤١a, R.layout.dialog_header_style_2, null);
        }
        return View.inflate(this.f٧٩٤١a, R.layout.dialog_header_style_1, null);
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        TextView textView = this.f٧٩٤٦f;
        if (textView != null) {
            textView.post(new b(i10));
        } else {
            super.setTitle(i10);
        }
    }
}
