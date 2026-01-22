package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.facebook.internal.security.CertificateUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class r {

    /* renamed from: d, reason: collision with root package name */
    private static String f٢٧٠٥d;

    /* renamed from: g, reason: collision with root package name */
    private static e f٢٧٠٨g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f٢٧٠٩a;

    /* renamed from: b, reason: collision with root package name */
    private final NotificationManager f٢٧١٠b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f٢٧٠٤c = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static Set f٢٧٠٦e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private static final Object f٢٧٠٧f = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b {
        static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c implements f {

        /* renamed from: a, reason: collision with root package name */
        final String f٢٧١١a;

        /* renamed from: b, reason: collision with root package name */
        final int f٢٧١٢b;

        /* renamed from: c, reason: collision with root package name */
        final String f٢٧١٣c;

        /* renamed from: d, reason: collision with root package name */
        final Notification f٢٧١٤d;

        c(String str, int i10, String str2, Notification notification) {
            this.f٢٧١١a = str;
            this.f٢٧١٢b = i10;
            this.f٢٧١٣c = str2;
            this.f٢٧١٤d = notification;
        }

        @Override // androidx.core.app.r.f
        public void a(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.notify(this.f٢٧١١a, this.f٢٧١٢b, this.f٢٧١٣c, this.f٢٧١٤d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f٢٧١١a + ", id:" + this.f٢٧١٢b + ", tag:" + this.f٢٧١٣c + "]";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class d {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f٢٧١٥a;

        /* renamed from: b, reason: collision with root package name */
        final IBinder f٢٧١٦b;

        d(ComponentName componentName, IBinder iBinder) {
            this.f٢٧١٥a = componentName;
            this.f٢٧١٦b = iBinder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e implements Handler.Callback, ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final Context f٢٧١٧a;

        /* renamed from: b, reason: collision with root package name */
        private final HandlerThread f٢٧١٨b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f٢٧١٩c;

        /* renamed from: d, reason: collision with root package name */
        private final Map f٢٧٢٠d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private Set f٢٧٢١e = new HashSet();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            final ComponentName f٢٧٢٢a;

            /* renamed from: c, reason: collision with root package name */
            INotificationSideChannel f٢٧٢٤c;

            /* renamed from: b, reason: collision with root package name */
            boolean f٢٧٢٣b = false;

            /* renamed from: d, reason: collision with root package name */
            ArrayDeque f٢٧٢٥d = new ArrayDeque();

            /* renamed from: e, reason: collision with root package name */
            int f٢٧٢٦e = 0;

            a(ComponentName componentName) {
                this.f٢٧٢٢a = componentName;
            }
        }

        e(Context context) {
            this.f٢٧١٧a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f٢٧١٨b = handlerThread;
            handlerThread.start();
            this.f٢٧١٩c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f٢٧٢٣b) {
                return true;
            }
            boolean bindService = this.f٢٧١٧a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f٢٧٢٢a), this, 33);
            aVar.f٢٧٢٣b = bindService;
            if (bindService) {
                aVar.f٢٧٢٦e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f٢٧٢٢a);
                this.f٢٧١٧a.unbindService(this);
            }
            return aVar.f٢٧٢٣b;
        }

        private void b(a aVar) {
            if (aVar.f٢٧٢٣b) {
                this.f٢٧١٧a.unbindService(this);
                aVar.f٢٧٢٣b = false;
            }
            aVar.f٢٧٢٤c = null;
        }

        private void c(f fVar) {
            j();
            for (a aVar : this.f٢٧٢٠d.values()) {
                aVar.f٢٧٢٥d.add(fVar);
                g(aVar);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = (a) this.f٢٧٢٠d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.f٢٧٢٠d.get(componentName);
            if (aVar != null) {
                aVar.f٢٧٢٤c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f٢٧٢٦e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = (a) this.f٢٧٢٠d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f٢٧٢٢a + ", " + aVar.f٢٧٢٥d.size() + " queued tasks");
            }
            if (aVar.f٢٧٢٥d.isEmpty()) {
                return;
            }
            if (a(aVar) && aVar.f٢٧٢٤c != null) {
                while (true) {
                    f fVar = (f) aVar.f٢٧٢٥d.peek();
                    if (fVar == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + fVar);
                        }
                        fVar.a(aVar.f٢٧٢٤c);
                        aVar.f٢٧٢٥d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.f٢٧٢٢a);
                        }
                    } catch (RemoteException e10) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f٢٧٢٢a, e10);
                    }
                }
                if (!aVar.f٢٧٢٥d.isEmpty()) {
                    i(aVar);
                    return;
                }
                return;
            }
            i(aVar);
        }

        private void i(a aVar) {
            if (this.f٢٧١٩c.hasMessages(3, aVar.f٢٧٢٢a)) {
                return;
            }
            int i10 = aVar.f٢٧٢٦e;
            int i11 = i10 + 1;
            aVar.f٢٧٢٦e = i11;
            if (i11 > 6) {
                Log.w("NotifManCompat", "Giving up on delivering " + aVar.f٢٧٢٥d.size() + " tasks to " + aVar.f٢٧٢٢a + " after " + aVar.f٢٧٢٦e + " retries");
                aVar.f٢٧٢٥d.clear();
                return;
            }
            int i12 = (1 << i10) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i12 + " ms");
            }
            this.f٢٧١٩c.sendMessageDelayed(this.f٢٧١٩c.obtainMessage(3, aVar.f٢٧٢٢a), i12);
        }

        private void j() {
            Set e10 = r.e(this.f٢٧١٧a);
            if (e10.equals(this.f٢٧٢١e)) {
                return;
            }
            this.f٢٧٢١e = e10;
            List<ResolveInfo> queryIntentServices = this.f٢٧١٧a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (e10.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f٢٧٢٠d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f٢٧٢٠d.put(componentName2, new a(componentName2));
                }
            }
            Iterator it = this.f٢٧٢٠d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!hashSet.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    b((a) entry.getValue());
                    it.remove();
                }
            }
        }

        public void h(f fVar) {
            this.f٢٧١٩c.obtainMessage(0, fVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return false;
                        }
                        d((ComponentName) message.obj);
                        return true;
                    }
                    f((ComponentName) message.obj);
                    return true;
                }
                d dVar = (d) message.obj;
                e(dVar.f٢٧١٥a, dVar.f٢٧١٦b);
                return true;
            }
            c((f) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f٢٧١٩c.obtainMessage(1, new d(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f٢٧١٩c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface f {
        void a(INotificationSideChannel iNotificationSideChannel);
    }

    private r(Context context) {
        this.f٢٧٠٩a = context;
        this.f٢٧١٠b = (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
    }

    public static r d(Context context) {
        return new r(context);
    }

    public static Set e(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f٢٧٠٤c) {
            if (string != null) {
                try {
                    if (!string.equals(f٢٧٠٥d)) {
                        String[] split = string.split(CertificateUtil.DELIMITER, -1);
                        HashSet hashSet = new HashSet(split.length);
                        for (String str : split) {
                            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                            if (unflattenFromString != null) {
                                hashSet.add(unflattenFromString.getPackageName());
                            }
                        }
                        f٢٧٠٦e = hashSet;
                        f٢٧٠٥d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f٢٧٠٦e;
        }
        return set;
    }

    private void h(f fVar) {
        synchronized (f٢٧٠٧f) {
            try {
                if (f٢٧٠٨g == null) {
                    f٢٧٠٨g = new e(this.f٢٧٠٩a.getApplicationContext());
                }
                f٢٧٠٨g.h(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean i(Notification notification) {
        Bundle a10 = o.a(notification);
        if (a10 != null && a10.getBoolean("android.support.useSideChannel")) {
            return true;
        }
        return false;
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(this.f٢٧١٠b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f٢٧٠٩a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f٢٧٠٩a.getApplicationInfo();
        String packageName = this.f٢٧٠٩a.getApplicationContext().getPackageName();
        int i10 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            if (((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i10), packageName)).intValue() != 0) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b() {
        this.f٢٧١٠b.cancelAll();
    }

    public void c(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.a(this.f٢٧١٠b, notificationChannel);
        }
    }

    public void f(int i10, Notification notification) {
        g(null, i10, notification);
    }

    public void g(String str, int i10, Notification notification) {
        if (i(notification)) {
            h(new c(this.f٢٧٠٩a.getPackageName(), i10, str, notification));
            this.f٢٧١٠b.cancel(str, i10);
        } else {
            this.f٢٧١٠b.notify(str, i10, notification);
        }
    }
}
