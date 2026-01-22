package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.f f٦٣٧a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٦٣٨b;

        public a(Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
        }

        public AlertDialog a() {
            AlertDialog alertDialog = new AlertDialog(this.f٦٣٧a.f٥٩٨a, this.f٦٣٨b);
            this.f٦٣٧a.a(alertDialog.mAlert);
            alertDialog.setCancelable(this.f٦٣٧a.f٦١٥r);
            if (this.f٦٣٧a.f٦١٥r) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f٦٣٧a.f٦١٦s);
            alertDialog.setOnDismissListener(this.f٦٣٧a.f٦١٧t);
            DialogInterface.OnKeyListener onKeyListener = this.f٦٣٧a.f٦١٨u;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        public Context b() {
            return this.f٦٣٧a.f٥٩٨a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f٦٣٧a;
            fVar.f٦٢٠w = listAdapter;
            fVar.f٦٢١x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f٦٣٧a.f٦٠٤g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f٦٣٧a.f٦٠١d = drawable;
            return this;
        }

        public a f(DialogInterface.OnKeyListener onKeyListener) {
            this.f٦٣٧a.f٦١٨u = onKeyListener;
            return this;
        }

        public a g(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f٦٣٧a;
            fVar.f٦٢٠w = listAdapter;
            fVar.f٦٢١x = onClickListener;
            fVar.I = i10;
            fVar.H = true;
            return this;
        }

        public a h(CharSequence charSequence) {
            this.f٦٣٧a.f٦٠٣f = charSequence;
            return this;
        }

        public a(Context context, int i10) {
            this.f٦٣٧a = new AlertController.f(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i10)));
            this.f٦٣٨b = i10;
        }
    }

    protected AlertDialog(Context context) {
        this(context, 0);
    }

    static int resolveDialogTheme(Context context, int i10) {
        if (((i10 >>> 24) & KotlinVersion.MAX_COMPONENT_VALUE) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i10) {
        return this.mAlert.c(i10);
    }

    public ListView getListView() {
        return this.mAlert.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.mAlert.h(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.mAlert.i(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public void setButton(int i10, CharSequence charSequence, Message message) {
        this.mAlert.l(i10, charSequence, null, message, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setButtonPanelLayoutHint(int i10) {
        this.mAlert.m(i10);
    }

    public void setCustomTitle(View view) {
        this.mAlert.n(view);
    }

    public void setIcon(int i10) {
        this.mAlert.o(i10);
    }

    public void setIconAttribute(int i10) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i10, typedValue, true);
        this.mAlert.o(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.q(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.s(charSequence);
    }

    public void setView(View view) {
        this.mAlert.u(view);
    }

    protected AlertDialog(Context context, int i10) {
        super(context, resolveDialogTheme(context, i10));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    public void setButton(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.l(i10, charSequence, onClickListener, null, null);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.p(drawable);
    }

    public void setView(View view, int i10, int i11, int i12, int i13) {
        this.mAlert.v(view, i10, i11, i12, i13);
    }

    public void setButton(int i10, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.l(i10, charSequence, onClickListener, null, drawable);
    }

    protected AlertDialog(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z10);
        setOnCancelListener(onCancelListener);
    }
}
