package h2;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class k extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    int f١٤٥٠١a;

    /* renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f١٤٥٠٢b;

    /* renamed from: c, reason: collision with root package name */
    ColorStateList f١٤٥٠٣c;

    /* renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f١٤٥٠٤d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(k kVar) {
        this.f١٤٥٠٣c = null;
        this.f١٤٥٠٤d = i.f١٤٤٩٣g;
        if (kVar != null) {
            this.f١٤٥٠١a = kVar.f١٤٥٠١a;
            this.f١٤٥٠٢b = kVar.f١٤٥٠٢b;
            this.f١٤٥٠٣c = kVar.f١٤٥٠٣c;
            this.f١٤٥٠٤d = kVar.f١٤٥٠٤d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.f١٤٥٠٢b != null) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i10;
        int i11 = this.f١٤٥٠١a;
        Drawable.ConstantState constantState = this.f١٤٥٠٢b;
        if (constantState != null) {
            i10 = constantState.getChangingConfigurations();
        } else {
            i10 = 0;
        }
        return i11 | i10;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new j(this, resources);
    }
}
