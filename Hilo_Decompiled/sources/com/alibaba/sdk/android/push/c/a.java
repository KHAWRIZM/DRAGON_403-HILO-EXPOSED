package com.alibaba.sdk.android.push.c;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.push.channel.KeepChannelService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AmsLogger f٦٥٦٤a = AmsLogger.getLogger("MPS:KeepLiveManager");

    /* renamed from: b, reason: collision with root package name */
    private static Context f٦٥٦٥b = null;

    /* renamed from: c, reason: collision with root package name */
    private static a f٦٥٦٦c = null;

    private a() {
    }

    public static a a() {
        if (f٦٥٦٦c == null) {
            f٦٥٦٦c = new a();
        }
        return f٦٥٦٦c;
    }

    public void b() {
        if (f٦٥٦٥b != null) {
            f٦٥٦٤a.d("Check KeepChannelService");
            try {
                JobScheduler jobScheduler = (JobScheduler) f٦٥٦٥b.getSystemService("jobscheduler");
                for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
                    if (jobInfo.getId() == 900715 && jobInfo.getService().equals(new ComponentName(f٦٥٦٥b.getPackageName(), KeepChannelService.class.getName()))) {
                        f٦٥٦٤a.d("cancel Keep Channel Service");
                        jobScheduler.cancel(jobInfo.getId());
                        return;
                    }
                }
            } catch (Throwable th) {
                f٦٥٦٤a.e("start KeepChannelService failed.", th);
            }
        }
    }

    public static void a(Context context) {
        f٦٥٦٥b = context;
        if (f٦٥٦٦c == null) {
            f٦٥٦٦c = a();
        }
    }
}
