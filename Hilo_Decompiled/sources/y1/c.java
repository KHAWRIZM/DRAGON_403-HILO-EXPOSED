package y1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.g;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f١٩١٠٠a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f١٩١٠١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Intent f١٩١٠٢a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList f١٩١٠٣b;

        /* renamed from: c, reason: collision with root package name */
        private Bundle f١٩١٠٤c;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList f١٩١٠٥d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f١٩١٠٦e;

        public a(e eVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.f١٩١٠٢a = intent;
            this.f١٩١٠٣b = null;
            this.f١٩١٠٤c = null;
            this.f١٩١٠٥d = null;
            this.f١٩١٠٦e = true;
            if (eVar != null) {
                intent.setPackage(eVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            g.b(bundle, "android.support.customtabs.extra.SESSION", eVar != null ? eVar.a() : null);
            intent.putExtras(bundle);
        }

        public c a() {
            ArrayList<? extends Parcelable> arrayList = this.f١٩١٠٣b;
            if (arrayList != null) {
                this.f١٩١٠٢a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = this.f١٩١٠٥d;
            if (arrayList2 != null) {
                this.f١٩١٠٢a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f١٩١٠٢a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f١٩١٠٦e);
            return new c(this.f١٩١٠٢a, this.f١٩١٠٤c);
        }
    }

    c(Intent intent, Bundle bundle) {
        this.f١٩١٠٠a = intent;
        this.f١٩١٠١b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f١٩١٠٠a.setData(uri);
        androidx.core.content.a.startActivity(context, this.f١٩١٠٠a, this.f١٩١٠١b);
    }
}
