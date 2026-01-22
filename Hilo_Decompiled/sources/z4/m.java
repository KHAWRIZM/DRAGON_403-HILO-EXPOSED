package z4;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bumptech.glide.Glide;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import z4.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    final Map f١٩٤٤٨a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final o.b f١٩٤٤٩b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public final class b implements p {

        /* renamed from: a, reason: collision with root package name */
        private final FragmentManager f١٩٤٥٢a;

        b(FragmentManager fragmentManager) {
            this.f١٩٤٥٢a = fragmentManager;
        }

        private void b(FragmentManager fragmentManager, Set set) {
            List<Fragment> fragments = fragmentManager.getFragments();
            int size = fragments.size();
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = fragments.get(i10);
                b(fragment.getChildFragmentManager(), set);
                com.bumptech.glide.j a10 = m.this.a(fragment.getLifecycle());
                if (a10 != null) {
                    set.add(a10);
                }
            }
        }

        @Override // z4.p
        public Set a() {
            HashSet hashSet = new HashSet();
            b(this.f١٩٤٥٢a, hashSet);
            return hashSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(o.b bVar) {
        this.f١٩٤٤٩b = bVar;
    }

    com.bumptech.glide.j a(Lifecycle lifecycle) {
        f5.l.b();
        return (com.bumptech.glide.j) this.f١٩٤٤٨a.get(lifecycle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.j b(Context context, Glide glide, Lifecycle lifecycle, FragmentManager fragmentManager, boolean z10) {
        f5.l.b();
        com.bumptech.glide.j a10 = a(lifecycle);
        if (a10 == null) {
            k kVar = new k(lifecycle);
            com.bumptech.glide.j a11 = this.f١٩٤٤٩b.a(glide, kVar, new b(fragmentManager), context);
            this.f١٩٤٤٨a.put(lifecycle, a11);
            kVar.b(new a(lifecycle));
            if (z10) {
                a11.onStart();
            }
            return a11;
        }
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Lifecycle f١٩٤٥٠a;

        a(Lifecycle lifecycle) {
            this.f١٩٤٥٠a = lifecycle;
        }

        @Override // z4.l
        public void onDestroy() {
            m.this.f١٩٤٤٨a.remove(this.f١٩٤٥٠a);
        }

        @Override // z4.l
        public void onStart() {
        }

        @Override // z4.l
        public void onStop() {
        }
    }
}
