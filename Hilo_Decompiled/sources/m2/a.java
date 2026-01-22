package m2;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f١٥٩١٨a;

    /* renamed from: b, reason: collision with root package name */
    private final g0 f١٥٩١٩b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٥٩٢٠c;

    public a(int i10, g0 g0Var, int i11) {
        this.f١٥٩١٨a = i10;
        this.f١٥٩١٩b = g0Var;
        this.f١٥٩٢٠c = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f١٥٩١٨a);
        this.f١٥٩١٩b.d0(this.f١٥٩٢٠c, bundle);
    }
}
