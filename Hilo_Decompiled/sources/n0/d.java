package n0;

import android.database.Cursor;
import android.net.Uri;
import com.liulishuo.okdownload.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f١٦٠٩٨a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f١٦٠٩٩b;

    /* renamed from: c, reason: collision with root package name */
    public volatile HashMap f١٦١٠٠c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f١٦١٠١d;

    /* renamed from: e, reason: collision with root package name */
    public int f١٦١٠٢e;

    /* renamed from: f, reason: collision with root package name */
    public int f١٦١٠٣f;

    /* renamed from: g, reason: collision with root package name */
    public int f١٦١٠٤g;

    /* renamed from: h, reason: collision with root package name */
    public int f١٦١٠٥h;

    /* renamed from: i, reason: collision with root package name */
    public int f١٦١٠٦i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f١٦١٠٧j;

    /* renamed from: k, reason: collision with root package name */
    public int f١٦١٠٨k;

    /* renamed from: l, reason: collision with root package name */
    public final String f١٦١٠٩l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f١٦١١٠m;

    /* renamed from: n, reason: collision with root package name */
    public final Boolean f١٦١١١n;

    /* renamed from: o, reason: collision with root package name */
    public Integer f١٦١١٢o;

    public d(String str, String str2, String str3) {
        String string;
        Uri fromFile = Uri.fromFile(new File(str2));
        this.f١٦١٠٣f = 4096;
        this.f١٦١٠٤g = DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE;
        this.f١٦١٠٥h = 65536;
        this.f١٦١٠٦i = 2000;
        this.f١٦١٠٧j = true;
        this.f١٦١٠٨k = 3000;
        this.f١٦١١٠m = true;
        this.f١٦٠٩٨a = str;
        this.f١٦٠٩٩b = fromFile;
        if (fromFile.getScheme().equals("content")) {
            Cursor query = f.a().f١٦١٤٤h.getContentResolver().query(fromFile, null, null, null, null);
            if (query != null) {
                try {
                    query.moveToFirst();
                    string = query.getString(query.getColumnIndex("_display_name"));
                } finally {
                    query.close();
                }
            } else {
                string = null;
            }
            this.f١٦١٠٩l = string;
        }
        if (l0.d.d(str3)) {
            this.f١٦١١١n = Boolean.TRUE;
        } else {
            this.f١٦١٠٩l = str3;
        }
    }

    public final synchronized void a(String str, String str2) {
        try {
            if (this.f١٦١٠٠c == null) {
                this.f١٦١٠٠c = new HashMap();
            }
            List list = (List) this.f١٦١٠٠c.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f١٦١٠٠c.put(str, list);
            }
            list.add(str2);
        } catch (Throwable th) {
            throw th;
        }
    }
}
