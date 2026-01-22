package g1;

import java.io.File;
import java.util.Locale;
import tech.sud.gip.logger.SudLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f١٤٣٧٨a;

    public c(h hVar) {
        this.f١٤٣٧٨a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Locale locale = Locale.US;
        h hVar = this.f١٤٣٧٨a;
        String str = hVar.f١٤٣٨٧c;
        long j10 = hVar.f١٤٣٨٨d;
        String str2 = "sud/mgp/user/" + str + "/" + j10 + "/data/" + str + "/" + j10 + "/tmp";
        h hVar2 = this.f١٤٣٧٨a;
        String str3 = "sud/mgp/user/" + hVar2.f١٤٣٨٧c + "/" + hVar2.f١٤٣٨٨d + "/data_clean_tmp";
        String str4 = str3 + "/" + System.currentTimeMillis();
        String absolutePath = new File(this.f١٤٣٧٨a.f١٤٣٨٥a.getFilesDir(), str3).getAbsolutePath();
        u.a.a(absolutePath);
        if (!new File(this.f١٤٣٧٨a.f١٤٣٨٥a.getFilesDir(), str2).renameTo(new File(this.f١٤٣٧٨a.f١٤٣٨٥a.getFilesDir(), str4))) {
            SudLogger.e(h.f١٤٣٨٢k, "renameTo tmp failed");
        }
        h.f١٤٣٨٣l.execute(new d(absolutePath));
    }
}
