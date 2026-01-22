package androidx.credentials.provider.utils;

import android.app.slice.Slice;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.CredentialEntry;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract /* synthetic */ class k0 {
    public static /* synthetic */ CredentialEntry a(BeginGetCredentialOption beginGetCredentialOption, Slice slice) {
        return new CredentialEntry(beginGetCredentialOption, slice);
    }
}
