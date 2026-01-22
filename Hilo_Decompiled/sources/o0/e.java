package o0;

import java.util.ArrayList;
import okhttp3.Call;
import tech.sud.gip.core.network.detection.INetworkDetectionFuture;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements INetworkDetectionFuture {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f١٦٤٢٢a;

    public e(j jVar) {
        this.f١٦٤٢٢a = jVar;
    }

    public final void cancel() {
        j jVar = this.f١٦٤٢٢a;
        if (!jVar.f١٦٤٣٦d) {
            jVar.f١٦٤٣٦d = true;
            jVar.f١٦٤٣٣a = null;
            jVar.f١٦٤٣٤b = null;
            ArrayList arrayList = jVar.f١٦٤٤٠h;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                qf.a aVar = (qf.a) obj;
                Call call = aVar.a;
                if (call != null && !call.isExecuted()) {
                    aVar.a.cancel();
                }
            }
        }
    }

    public final boolean isCanceled() {
        return this.f١٦٤٢٢a.f١٦٤٣٦d;
    }
}
