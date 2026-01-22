package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.l;
import androidx.core.view.l1;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface x {
    boolean a();

    boolean b();

    boolean c();

    void collapseActionView();

    void d(Menu menu, l.a aVar);

    boolean e();

    void f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    boolean h();

    void i(int i10);

    Menu j();

    int k();

    l1 l(int i10, long j10);

    ViewGroup m();

    void n(boolean z10);

    void o();

    void p(boolean z10);

    void q();

    void r(ScrollingTabContainerView scrollingTabContainerView);

    void s(int i10);

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(l.a aVar, g.a aVar2);

    void u(int i10);

    int v();

    void w();
}
