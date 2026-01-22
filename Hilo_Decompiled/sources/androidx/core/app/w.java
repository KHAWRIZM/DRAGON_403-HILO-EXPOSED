package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class w implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f٢٧٢٧a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Context f٢٧٢٨b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private w(Context context) {
        this.f٢٧٢٨b = context;
    }

    public static w h(Context context) {
        return new w(context);
    }

    public w d(Intent intent) {
        this.f٢٧٢٧a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w e(Activity activity) {
        Intent intent;
        if (activity instanceof a) {
            intent = ((a) activity).getSupportParentActivityIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = m.a(activity);
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(this.f٢٧٢٨b.getPackageManager());
            }
            f(component);
            d(intent);
        }
        return this;
    }

    public w f(ComponentName componentName) {
        int size = this.f٢٧٢٧a.size();
        try {
            Intent b10 = m.b(this.f٢٧٢٨b, componentName);
            while (b10 != null) {
                this.f٢٧٢٧a.add(size, b10);
                b10 = m.b(this.f٢٧٢٨b, b10.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e10);
        }
    }

    public void i() {
        k(null);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f٢٧٢٧a.iterator();
    }

    public void k(Bundle bundle) {
        if (!this.f٢٧٢٧a.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f٢٧٢٧a.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!androidx.core.content.a.startActivities(this.f٢٧٢٨b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f٢٧٢٨b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
