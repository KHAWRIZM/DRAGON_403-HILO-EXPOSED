package a1;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e extends c {

    /* renamed from: a, reason: collision with root package name */
    public int f٩٢a;

    /* renamed from: b, reason: collision with root package name */
    public final f.a f٩٣b = new f.a("matchASRInfo");

    /* renamed from: c, reason: collision with root package name */
    public final String f٩٤c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f٩٥d;

    public e() {
        this.f٩٥d = Boolean.FALSE;
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        this.f٩٤c = format;
        String string = d0.a.a("TechSudMGPGlobal.sp").f١٣٥٣٩a.getString("key_sud_mgp_match_asr_last_date", "");
        if (!TextUtils.isEmpty(string) && format.equals(string)) {
            this.f٩٥d = Boolean.TRUE;
        }
    }
}
