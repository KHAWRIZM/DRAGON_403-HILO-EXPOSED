package com.taobao.accs;

import android.app.Notification;
import android.content.Context;
import com.taobao.accs.ChannelService;
import com.taobao.accs.utl.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class b implements Runnable {
    final /* synthetic */ ChannelService.KernelService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChannelService.KernelService kernelService) {
        this.a = kernelService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        ChannelService.KernelService kernelService;
        Context context2;
        Context context3;
        ChannelService.KernelService kernelService2;
        ChannelService.KernelService kernelService3;
        try {
            ChannelService channelService = ChannelService.getInstance();
            context = this.a.b;
            int i = context.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).applicationInfo.icon;
            if (i != 0) {
                context2 = this.a.b;
                Notification.Builder builder = new Notification.Builder(context2);
                builder.setSmallIcon(i);
                channelService.startForeground(9371, builder.build());
                context3 = this.a.b;
                Notification.Builder builder2 = new Notification.Builder(context3);
                builder2.setSmallIcon(i);
                kernelService2 = ChannelService.KernelService.a;
                kernelService2.startForeground(9371, builder2.build());
                kernelService3 = ChannelService.KernelService.a;
                kernelService3.stopForeground(true);
            }
            kernelService = ChannelService.KernelService.a;
            kernelService.stopSelf();
        } catch (Throwable th) {
            ALog.e("ChannelService", " onStartCommand run", th, new Object[0]);
        }
    }
}
