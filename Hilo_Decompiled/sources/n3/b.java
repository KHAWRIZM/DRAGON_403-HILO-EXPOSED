package n3;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final List f١٦١٨١a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(u uVar) {
        this.f١٦١٨١a.add(uVar);
    }

    public void b(Path path) {
        for (int size = this.f١٦١٨١a.size() - 1; size >= 0; size--) {
            x3.l.b(path, (u) this.f١٦١٨١a.get(size));
        }
    }
}
