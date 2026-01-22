package n9;

import android.app.NotificationManager;
import android.content.Context;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import java.util.ArrayList;
import java.util.HashMap;
import p9.d;
import p9.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b implements c {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t9.b f١٦٣٧٧a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f١٦٣٧٨b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ r9.b f١٦٣٧٩c;

        a(t9.b bVar, Context context, r9.b bVar2) {
            this.f١٦٣٧٧a = bVar;
            this.f١٦٣٧٨b = context;
            this.f١٦٣٧٩c = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f١٦٣٧٧a.h() == 1) {
                b.this.c(this.f١٦٣٧٨b, this.f١٦٣٧٧a);
            } else {
                this.f١٦٣٧٩c.a(this.f١٦٣٧٨b, this.f١٦٣٧٧a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, t9.b bVar) {
        if (context == null) {
            d.a("context is null");
            return;
        }
        d.a("Receive revokeMessage  extra : " + bVar.j() + "notifyId :" + bVar.i() + "messageId : " + bVar.k());
        ((NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION)).cancel(bVar.i());
        d(context, bVar);
    }

    private void d(Context context, t9.b bVar) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        hashMap.put(bVar.e(), arrayList);
        u9.a.a(context, hashMap);
    }

    @Override // n9.c
    public void a(Context context, t9.a aVar, r9.b bVar) {
        if (aVar != null && aVar.a() == 4103) {
            t9.b bVar2 = (t9.b) aVar;
            if (bVar != null) {
                g.b(new a(bVar2, context, bVar));
            }
        }
    }
}
