package b5;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List f٥٤١٢a = new ArrayList();

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f٥٤١٢a.add(imageHeaderParser);
    }

    public synchronized List b() {
        return this.f٥٤١٢a;
    }
}
