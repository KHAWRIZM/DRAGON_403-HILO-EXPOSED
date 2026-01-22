package com.alibaba.sdk.android.push.channel;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;

@TargetApi(21)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class KeepChannelService extends JobService {

    /* renamed from: a, reason: collision with root package name */
    private static final AmsLogger f٦٥٦٧a = AmsLogger.getLogger("MPS:KeepChannelService");

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        f٦٥٦٧a.d("keepScheduleService start");
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        f٦٥٦٧a.d("keepScheduleService stoped");
        return false;
    }
}
