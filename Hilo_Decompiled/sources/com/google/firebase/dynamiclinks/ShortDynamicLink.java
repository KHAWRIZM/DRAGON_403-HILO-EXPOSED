package com.google.firebase.dynamiclinks;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface ShortDynamicLink {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public @interface Suffix {
        public static final int SHORT = 2;
        public static final int UNGUESSABLE = 1;
    }

    @Deprecated
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface Warning {
        @Deprecated
        String getCode();

        @Deprecated
        String getMessage();
    }

    @Deprecated
    Uri getPreviewLink();

    @Deprecated
    Uri getShortLink();

    @Deprecated
    List<? extends Warning> getWarnings();
}
