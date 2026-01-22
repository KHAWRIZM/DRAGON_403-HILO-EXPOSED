package n9;

import android.content.Context;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import i9.d;
import p9.g;
import p9.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements c {

    /* renamed from: n9.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class RunnableC٠١٩٦a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l9.b f١٦٣٧٥a;

        RunnableC٠١٩٦a(l9.b bVar) {
            this.f١٦٣٧٥a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c(this.f١٦٣٧٥a, d.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(l9.b bVar, d dVar) {
        if (bVar == null) {
            p9.d.b("message is null , please check param of parseCommandMessage(2)");
            return;
        }
        if (dVar == null) {
            p9.d.b("pushService is null , please check param of parseCommandMessage(2)");
            return;
        }
        if (dVar.n() == null) {
            p9.d.b("pushService.getPushCallback() is null , please check param of parseCommandMessage(2)");
            return;
        }
        int b10 = bVar.b();
        if (b10 != 12287) {
            if (b10 != 12298) {
                if (b10 != 12306) {
                    if (b10 != 12309) {
                        if (b10 != 12289) {
                            if (b10 != 12290) {
                                switch (b10) {
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                                        dVar.p();
                                        return;
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                                        try {
                                            Integer.parseInt(bVar.c());
                                        } catch (Exception unused) {
                                        }
                                        dVar.o();
                                        return;
                                    default:
                                        return;
                                }
                            }
                            dVar.n().onUnRegister(bVar.d());
                            return;
                        }
                        if (bVar.d() == 0) {
                            dVar.x(bVar.c());
                        }
                        dVar.n().onRegister(bVar.d(), bVar.c());
                        return;
                    }
                    dVar.n().onGetNotificationStatus(bVar.d(), h.i(bVar.c()));
                    return;
                }
                dVar.n().onGetPushStatus(bVar.d(), h.i(bVar.c()));
                return;
            }
            dVar.n().onSetPushTime(bVar.d(), bVar.c());
            return;
        }
        r9.a n10 = dVar.n();
        if (n10 != null) {
            n10.onError(bVar.d(), bVar.c());
        }
    }

    @Override // n9.c
    public void a(Context context, t9.a aVar, r9.b bVar) {
        if (aVar != null && aVar.a() == 4105) {
            l9.b bVar2 = (l9.b) aVar;
            p9.d.a("mcssdk-CallBackResultProcessor:" + bVar2.toString());
            g.b(new RunnableC٠١٩٦a(bVar2));
        }
    }
}
