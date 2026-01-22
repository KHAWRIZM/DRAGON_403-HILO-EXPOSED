package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CircularRevealCardView extends MaterialCardView implements c {

    /* renamed from: i, reason: collision with root package name */
    private final b f٨٨٠٣i;

    public CircularRevealCardView(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.c
    public void a() {
        this.f٨٨٠٣i.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void b() {
        this.f٨٨٠٣i.b();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        b bVar = this.f٨٨٠٣i;
        if (bVar != null) {
            bVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.b.a
    public void e(Canvas canvas) {
        super.draw(canvas);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f٨٨٠٣i.e();
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.f٨٨٠٣i.f();
    }

    @Override // com.google.android.material.circularreveal.c
    public c.e getRevealInfo() {
        return this.f٨٨٠٣i.h();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        b bVar = this.f٨٨٠٣i;
        if (bVar != null) {
            return bVar.j();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b.a
    public boolean l() {
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f٨٨٠٣i.k(drawable);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(int i10) {
        this.f٨٨٠٣i.l(i10);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(c.e eVar) {
        this.f٨٨٠٣i.m(eVar);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٨٨٠٣i = new b(this);
    }
}
