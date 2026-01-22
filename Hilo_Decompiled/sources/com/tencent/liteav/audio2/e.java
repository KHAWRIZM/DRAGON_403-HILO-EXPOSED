package com.tencent.liteav.audio2;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.liteav.audio2.c;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class e extends PhoneStateListener implements c.a {
    static c c;
    Class<?> d;
    Object e;
    private b h;
    int g = 0;
    private boolean i = false;
    TelephonyManager a = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
    AudioManager b = (AudioManager) ContextUtils.getApplicationContext().getSystemService(TUIConstants.TUICalling.TYPE_AUDIO);
    com.tencent.liteav.base.util.l f = new com.tencent.liteav.base.util.l("PhoneStateManager");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class a implements InvocationHandler {
        private final WeakReference<e> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(e eVar) {
            this.a = new WeakReference<>(eVar);
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            b bVar;
            try {
                if ("onModeChanged".equals(method.getName())) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    e eVar = this.a.get();
                    if (eVar != null && (bVar = eVar.h) != null) {
                        if (intValue == 2) {
                            eVar.i = true;
                            bVar.onInterruptedByPhoneCall();
                        } else if (eVar.i) {
                            eVar.i = false;
                            bVar.onResumedByPhoneCall();
                        }
                    }
                }
            } catch (Throwable th) {
                Log.e("PhoneStateManager", "notify mode changed failed, " + th.getMessage(), new Object[0]);
            }
            return obj;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface b {
        void onInterruptedByPhoneCall();

        void onResumedByPhoneCall();
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            c = new c();
        }
    }

    public e(b bVar) {
        this.h = bVar;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i, String str) {
        b bVar = this.h;
        if (bVar == null || this.g == i) {
            return;
        }
        this.g = i;
        if (i == 2) {
            bVar.onInterruptedByPhoneCall();
        } else if (i == 0) {
            bVar.onResumedByPhoneCall();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        try {
            return applicationContext.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th) {
            Log.e("PhoneStateManager", "check permission exception, " + th.getMessage(), new Object[0]);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        if (Build.VERSION.SDK_INT >= 26 && c != null) {
            Log.i("PhoneStateManager", "unregister audio playback callback.", new Object[0]);
            c.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        b bVar = this.h;
        if (bVar == null) {
            return;
        }
        try {
            if (this.b.getMode() == 2) {
                this.i = true;
                bVar.onInterruptedByPhoneCall();
            } else if (this.i) {
                this.i = false;
                bVar.onResumedByPhoneCall();
            }
        } catch (Throwable th) {
            Log.e("PhoneStateManager", "get Mode exception, " + th.getMessage(), new Object[0]);
        }
    }

    @Override // com.tencent.liteav.audio2.c.a
    public final void a() {
        this.f.a(g.a(this), 500L);
    }
}
