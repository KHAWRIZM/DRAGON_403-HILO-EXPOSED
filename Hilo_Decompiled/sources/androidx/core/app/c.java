package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private final ActivityOptions f٢٦٢٣a;

        a(ActivityOptions activityOptions) {
            this.f٢٦٢٣a = activityOptions;
        }

        @Override // androidx.core.app.c
        public Bundle b() {
            return this.f٢٦٢٣a.toBundle();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b {
        static ActivityOptions a(Activity activity, View view, String str) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
        }
    }

    protected c() {
    }

    public static c a(Activity activity, View view, String str) {
        return new a(b.a(activity, view, str));
    }

    public abstract Bundle b();
}
