package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zak extends Drawable implements Drawable.Callback {
    private int zaa;
    private long zab;
    private int zac;
    private int zad;
    private int zae;
    private int zaf;
    private boolean zag;
    private boolean zah;
    private zaj zai;
    private Drawable zaj;
    private Drawable zak;
    private boolean zal;
    private boolean zam;
    private boolean zan;
    private int zao;

    public zak(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zai.zaa : drawable;
        this.zaj = drawable;
        drawable.setCallback(this);
        zaj zajVar = this.zai;
        zajVar.zab = drawable.getChangingConfigurations() | zajVar.zab;
        drawable2 = drawable2 == null ? zai.zaa : drawable2;
        this.zak = drawable2;
        drawable2.setCallback(this);
        zaj zajVar2 = this.zai;
        zajVar2.zab = drawable2.getChangingConfigurations() | zajVar2.zab;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0050, code lost:
    
        if (r0 == 0) goto L٢٢;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void draw(Canvas canvas) {
        boolean z10;
        int i10 = this.zaa;
        int i11 = 0;
        if (i10 != 1) {
            if (i10 != 2 || this.zab < 0) {
                z10 = true;
            } else {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zab)) / this.zae;
                if (uptimeMillis >= 1.0f) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    this.zaa = 0;
                }
                this.zaf = (int) ((this.zac * Math.min(uptimeMillis, 1.0f)) + DownloadProgress.UNKNOWN_PROGRESS);
            }
        } else {
            this.zab = SystemClock.uptimeMillis();
            this.zaa = 2;
            z10 = false;
        }
        int i12 = this.zaf;
        boolean z11 = this.zag;
        Drawable drawable = this.zaj;
        Drawable drawable2 = this.zak;
        if (z10) {
            if (!z11) {
                i11 = i12;
            }
            drawable.draw(canvas);
            i12 = i11;
            int i13 = this.zad;
            if (i12 == i13) {
                drawable2.setAlpha(i13);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z11) {
            drawable.setAlpha(this.zad - i12);
            i11 = 1;
        }
        drawable.draw(canvas);
        if (i11 != 0) {
            drawable.setAlpha(this.zad);
        }
        if (i12 > 0) {
            drawable2.setAlpha(i12);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zad);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        zaj zajVar = this.zai;
        return changingConfigurations | zajVar.zaa | zajVar.zab;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (zac()) {
            this.zai.zaa = getChangingConfigurations();
            return this.zai;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.zaj.getIntrinsicHeight(), this.zak.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.zaj.getIntrinsicWidth(), this.zak.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.zan) {
            this.zao = Drawable.resolveOpacity(this.zaj.getOpacity(), this.zak.getOpacity());
            this.zan = true;
        }
        return this.zao;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.zah && super.mutate() == this) {
            if (zac()) {
                this.zaj.mutate();
                this.zak.mutate();
                this.zah = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        this.zaj.setBounds(rect);
        this.zak.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        if (this.zaf == this.zad) {
            this.zaf = i10;
        }
        this.zad = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.zaj.setColorFilter(colorFilter);
        this.zak.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final Drawable zaa() {
        return this.zak;
    }

    public final void zab(int i10) {
        this.zac = this.zad;
        this.zaf = 0;
        this.zae = 250;
        this.zaa = 1;
        invalidateSelf();
    }

    public final boolean zac() {
        if (!this.zal) {
            boolean z10 = false;
            if (this.zaj.getConstantState() != null && this.zak.getConstantState() != null) {
                z10 = true;
            }
            this.zam = z10;
            this.zal = true;
        }
        return this.zam;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zak(zaj zajVar) {
        this.zaa = 0;
        this.zad = KotlinVersion.MAX_COMPONENT_VALUE;
        this.zaf = 0;
        this.zag = true;
        this.zai = new zaj(zajVar);
    }
}
