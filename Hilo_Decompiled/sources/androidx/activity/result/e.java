package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.random.Random;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private final Map f٥٣٤a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    final Map f٥٣٥b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map f٥٣٦c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    ArrayList f٥٣٧d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    final transient Map f٥٣٨e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    final Map f٥٣٩f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    final Bundle f٥٤٠g = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements LifecycleEventObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f٥٤١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActivityResultCallback f٥٤٢b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ActivityResultContract f٥٤٣c;

        a(String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
            this.f٥٤١a = str;
            this.f٥٤٢b = activityResultCallback;
            this.f٥٤٣c = activityResultContract;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (Lifecycle.Event.ON_START.equals(event)) {
                e.this.f٥٣٨e.put(this.f٥٤١a, new d(this.f٥٤٢b, this.f٥٤٣c));
                if (e.this.f٥٣٩f.containsKey(this.f٥٤١a)) {
                    Object obj = e.this.f٥٣٩f.get(this.f٥٤١a);
                    e.this.f٥٣٩f.remove(this.f٥٤١a);
                    this.f٥٤٢b.onActivityResult(obj);
                }
                ActivityResult activityResult = (ActivityResult) e.this.f٥٤٠g.getParcelable(this.f٥٤١a);
                if (activityResult != null) {
                    e.this.f٥٤٠g.remove(this.f٥٤١a);
                    this.f٥٤٢b.onActivityResult(this.f٥٤٣c.parseResult(activityResult.b(), activityResult.a()));
                    return;
                }
                return;
            }
            if (Lifecycle.Event.ON_STOP.equals(event)) {
                e.this.f٥٣٨e.remove(this.f٥٤١a);
            } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                e.this.l(this.f٥٤١a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends androidx.activity.result.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f٥٤٥a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActivityResultContract f٥٤٦b;

        b(String str, ActivityResultContract activityResultContract) {
            this.f٥٤٥a = str;
            this.f٥٤٦b = activityResultContract;
        }

        @Override // androidx.activity.result.d
        public ActivityResultContract getContract() {
            return this.f٥٤٦b;
        }

        @Override // androidx.activity.result.d
        public void launch(Object obj, androidx.core.app.c cVar) {
            Integer num = (Integer) e.this.f٥٣٥b.get(this.f٥٤٥a);
            if (num != null) {
                e.this.f٥٣٧d.add(this.f٥٤٥a);
                try {
                    e.this.f(num.intValue(), this.f٥٤٦b, obj, cVar);
                    return;
                } catch (Exception e10) {
                    e.this.f٥٣٧d.remove(this.f٥٤٥a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f٥٤٦b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.d
        public void unregister() {
            e.this.l(this.f٥٤٥a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c extends androidx.activity.result.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f٥٤٨a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActivityResultContract f٥٤٩b;

        c(String str, ActivityResultContract activityResultContract) {
            this.f٥٤٨a = str;
            this.f٥٤٩b = activityResultContract;
        }

        @Override // androidx.activity.result.d
        public ActivityResultContract getContract() {
            return this.f٥٤٩b;
        }

        @Override // androidx.activity.result.d
        public void launch(Object obj, androidx.core.app.c cVar) {
            Integer num = (Integer) e.this.f٥٣٥b.get(this.f٥٤٨a);
            if (num != null) {
                e.this.f٥٣٧d.add(this.f٥٤٨a);
                try {
                    e.this.f(num.intValue(), this.f٥٤٩b, obj, cVar);
                    return;
                } catch (Exception e10) {
                    e.this.f٥٣٧d.remove(this.f٥٤٨a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f٥٤٩b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.d
        public void unregister() {
            e.this.l(this.f٥٤٨a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        final ActivityResultCallback f٥٥١a;

        /* renamed from: b, reason: collision with root package name */
        final ActivityResultContract f٥٥٢b;

        d(ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
            this.f٥٥١a = activityResultCallback;
            this.f٥٥٢b = activityResultContract;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.activity.result.e$e, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٠٠٦e {

        /* renamed from: a, reason: collision with root package name */
        final Lifecycle f٥٥٣a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList f٥٥٤b = new ArrayList();

        C٠٠٠٦e(Lifecycle lifecycle) {
            this.f٥٥٣a = lifecycle;
        }

        void a(LifecycleEventObserver lifecycleEventObserver) {
            this.f٥٥٣a.addObserver(lifecycleEventObserver);
            this.f٥٥٤b.add(lifecycleEventObserver);
        }

        void b() {
            Iterator it = this.f٥٥٤b.iterator();
            while (it.hasNext()) {
                this.f٥٥٣a.removeObserver((LifecycleEventObserver) it.next());
            }
            this.f٥٥٤b.clear();
        }
    }

    private void a(int i10, String str) {
        this.f٥٣٤a.put(Integer.valueOf(i10), str);
        this.f٥٣٥b.put(str, Integer.valueOf(i10));
    }

    private void d(String str, int i10, Intent intent, d dVar) {
        if (dVar != null && dVar.f٥٥١a != null && this.f٥٣٧d.contains(str)) {
            dVar.f٥٥١a.onActivityResult(dVar.f٥٥٢b.parseResult(i10, intent));
            this.f٥٣٧d.remove(str);
        } else {
            this.f٥٣٩f.remove(str);
            this.f٥٤٠g.putParcelable(str, new ActivityResult(i10, intent));
        }
    }

    private int e() {
        int nextInt = Random.INSTANCE.nextInt(2147418112);
        while (true) {
            int i10 = nextInt + 65536;
            if (this.f٥٣٤a.containsKey(Integer.valueOf(i10))) {
                nextInt = Random.INSTANCE.nextInt(2147418112);
            } else {
                return i10;
            }
        }
    }

    private void k(String str) {
        if (((Integer) this.f٥٣٥b.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = (String) this.f٥٣٤a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        d(str, i11, intent, (d) this.f٥٣٨e.get(str));
        return true;
    }

    public final boolean c(int i10, Object obj) {
        ActivityResultCallback activityResultCallback;
        String str = (String) this.f٥٣٤a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        d dVar = (d) this.f٥٣٨e.get(str);
        if (dVar != null && (activityResultCallback = dVar.f٥٥١a) != null) {
            if (this.f٥٣٧d.remove(str)) {
                activityResultCallback.onActivityResult(obj);
                return true;
            }
            return true;
        }
        this.f٥٤٠g.remove(str);
        this.f٥٣٩f.put(str, obj);
        return true;
    }

    public abstract void f(int i10, ActivityResultContract activityResultContract, Object obj, androidx.core.app.c cVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList != null && integerArrayList != null) {
            this.f٥٣٧d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            this.f٥٤٠g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                String str = stringArrayList.get(i10);
                if (this.f٥٣٥b.containsKey(str)) {
                    Integer num = (Integer) this.f٥٣٥b.remove(str);
                    if (!this.f٥٤٠g.containsKey(str)) {
                        this.f٥٣٤a.remove(num);
                    }
                }
                a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
            }
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f٥٣٥b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f٥٣٥b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f٥٣٧d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f٥٤٠g.clone());
    }

    public final androidx.activity.result.d i(String str, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        k(str);
        this.f٥٣٨e.put(str, new d(activityResultCallback, activityResultContract));
        if (this.f٥٣٩f.containsKey(str)) {
            Object obj = this.f٥٣٩f.get(str);
            this.f٥٣٩f.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f٥٤٠g.getParcelable(str);
        if (activityResult != null) {
            this.f٥٤٠g.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.b(), activityResult.a()));
        }
        return new c(str, activityResultContract);
    }

    public final androidx.activity.result.d j(String str, LifecycleOwner lifecycleOwner, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            k(str);
            C٠٠٠٦e r52 = (C٠٠٠٦e) this.f٥٣٦c.get(str);
            if (r52 == null) {
                r52 = new C٠٠٠٦e(lifecycle);
            }
            r52.a(new a(str, activityResultCallback, activityResultContract));
            this.f٥٣٦c.put(str, r52);
            return new b(str, activityResultContract);
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
    }

    final void l(String str) {
        Integer num;
        if (!this.f٥٣٧d.contains(str) && (num = (Integer) this.f٥٣٥b.remove(str)) != null) {
            this.f٥٣٤a.remove(num);
        }
        this.f٥٣٨e.remove(str);
        if (this.f٥٣٩f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f٥٣٩f.get(str));
            this.f٥٣٩f.remove(str);
        }
        if (this.f٥٤٠g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f٥٤٠g.getParcelable(str));
            this.f٥٤٠g.remove(str);
        }
        C٠٠٠٦e r02 = (C٠٠٠٦e) this.f٥٣٦c.get(str);
        if (r02 != null) {
            r02.b();
            this.f٥٣٦c.remove(str);
        }
    }
}
