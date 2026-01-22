package k9;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.pushsdk.R;
import p9.e;
import p9.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k9.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class RunnableC٠١٨٠a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f١٥٥٥٧a;

        RunnableC٠١٨٠a(Context context) {
            this.f١٥٥٥٧a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.b().e()) {
                return;
            }
            String string = this.f١٥٥٥٧a.getString(R.string.system_default_channel);
            if (TextUtils.isEmpty(string)) {
                string = "System Default Channel";
            }
            e.b().g(a.this.b(this.f١٥٥٥٧a, "Heytap PUSH", string, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Context context, String str, String str2, int i10) {
        NotificationManager notificationManager;
        if (context != null && (notificationManager = (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION)) != null) {
            notificationManager.createNotificationChannel(com.google.android.gms.common.e.a(str, str2, i10));
            return true;
        }
        return false;
    }

    public void c(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        g.a(new RunnableC٠١٨٠a(context));
    }
}
