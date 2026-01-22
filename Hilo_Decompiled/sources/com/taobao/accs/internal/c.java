package com.taobao.accs.internal;

import android.app.job.JobParameters;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class c implements Runnable {
    final /* synthetic */ JobParameters a;
    final /* synthetic */ AccsJobService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccsJobService accsJobService, JobParameters jobParameters) {
        this.b = accsJobService;
        this.a = jobParameters;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.jobFinished(this.a, false);
    }
}
