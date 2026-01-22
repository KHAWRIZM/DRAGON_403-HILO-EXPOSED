package com.google.android.gms.appinvite;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzb implements View.OnClickListener {
    private final /* synthetic */ PreviewActivity zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(PreviewActivity previewActivity) {
        this.zzi = previewActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzi.finish();
    }
}
