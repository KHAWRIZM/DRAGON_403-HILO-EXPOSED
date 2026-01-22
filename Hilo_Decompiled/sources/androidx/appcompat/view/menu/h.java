package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, l.a {

    /* renamed from: a, reason: collision with root package name */
    private g f١٠٤٢a;

    /* renamed from: b, reason: collision with root package name */
    private AlertDialog f١٠٤٣b;

    /* renamed from: c, reason: collision with root package name */
    e f١٠٤٤c;

    /* renamed from: d, reason: collision with root package name */
    private l.a f١٠٤٥d;

    public h(g gVar) {
        this.f١٠٤٢a = gVar;
    }

    @Override // androidx.appcompat.view.menu.l.a
    public void a(g gVar, boolean z10) {
        if (z10 || gVar == this.f١٠٤٢a) {
            c();
        }
        l.a aVar = this.f١٠٤٥d;
        if (aVar != null) {
            aVar.a(gVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l.a
    public boolean b(g gVar) {
        l.a aVar = this.f١٠٤٥d;
        if (aVar != null) {
            return aVar.b(gVar);
        }
        return false;
    }

    public void c() {
        AlertDialog alertDialog = this.f١٠٤٣b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        g gVar = this.f١٠٤٢a;
        AlertDialog.a aVar = new AlertDialog.a(gVar.w());
        e eVar = new e(aVar.b(), R.layout.abc_list_menu_item_layout);
        this.f١٠٤٤c = eVar;
        eVar.c(this);
        this.f١٠٤٢a.b(this.f١٠٤٤c);
        aVar.c(this.f١٠٤٤c.f(), this);
        View A = gVar.A();
        if (A != null) {
            aVar.d(A);
        } else {
            aVar.e(gVar.y()).h(gVar.z());
        }
        aVar.f(this);
        AlertDialog a10 = aVar.a();
        this.f١٠٤٣b = a10;
        a10.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f١٠٤٣b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH;
        this.f١٠٤٣b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f١٠٤٢a.O((i) this.f١٠٤٤c.f().getItem(i10), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f١٠٤٤c.a(this.f١٠٤٢a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f١٠٤٣b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f١٠٤٣b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f١٠٤٢a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f١٠٤٢a.performShortcut(i10, keyEvent, 0);
    }
}
