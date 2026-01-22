package o3;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Collections;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class q extends a {

    /* renamed from: i, reason: collision with root package name */
    private final Object f١٦٥٣٧i;

    public q(y3.c cVar) {
        this(cVar, null);
    }

    @Override // o3.a
    float c() {
        return 1.0f;
    }

    @Override // o3.a
    public Object h() {
        y3.c cVar = this.f١٦٤٧٥e;
        Object obj = this.f١٦٥٣٧i;
        return cVar.b(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, obj, obj, f(), f(), f());
    }

    @Override // o3.a
    Object i(y3.a aVar, float f10) {
        return h();
    }

    @Override // o3.a
    public void l() {
        if (this.f١٦٤٧٥e != null) {
            super.l();
        }
    }

    @Override // o3.a
    public void n(float f10) {
        this.f١٦٤٧٤d = f10;
    }

    public q(y3.c cVar, Object obj) {
        super(Collections.emptyList());
        o(cVar);
        this.f١٦٥٣٧i = obj;
    }
}
