package i7;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.facebook.bolts.AppLinks;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d implements x {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٤٦٢٢a;

    /* renamed from: b, reason: collision with root package name */
    private final j7.d f١٤٦٢٣b;

    /* renamed from: c, reason: collision with root package name */
    private final f f١٤٦٢٤c;

    public d(Context context, j7.d dVar, f fVar) {
        this.f١٤٦٢٢a = context;
        this.f١٤٦٢٣b = dVar;
        this.f١٤٦٢٤c = fVar;
    }

    private boolean d(JobScheduler jobScheduler, int i10, int i11) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i12 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i10) {
                if (i12 < i11) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override // i7.x
    public void a(b7.p pVar, int i10, boolean z10) {
        ComponentName componentName = new ComponentName(this.f١٤٦٢٢a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f١٤٦٢٢a.getSystemService("jobscheduler");
        int c10 = c(pVar);
        if (!z10 && d(jobScheduler, c10, i10)) {
            f7.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
            return;
        }
        long B2 = this.f١٤٦٢٣b.B(pVar);
        JobInfo.Builder c11 = this.f١٤٦٢٤c.c(new JobInfo.Builder(c10, componentName), pVar.d(), B2, i10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i10);
        persistableBundle.putString("backendName", pVar.b());
        persistableBundle.putInt("priority", m7.a.a(pVar.d()));
        if (pVar.c() != null) {
            persistableBundle.putString(AppLinks.KEY_NAME_EXTRAS, Base64.encodeToString(pVar.c(), 0));
        }
        c11.setExtras(persistableBundle);
        f7.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(c10), Long.valueOf(this.f١٤٦٢٤c.g(pVar.d(), B2, i10)), Long.valueOf(B2), Integer.valueOf(i10));
        jobScheduler.schedule(c11.build());
    }

    @Override // i7.x
    public void b(b7.p pVar, int i10) {
        a(pVar, i10, false);
    }

    int c(b7.p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f١٤٦٢٢a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(pVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(m7.a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }
}
