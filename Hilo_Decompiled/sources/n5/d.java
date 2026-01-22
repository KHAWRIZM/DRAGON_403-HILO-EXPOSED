package n5;

import androidx.appcompat.app.a0;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private a f١٦٣٦٣a;

    /* renamed from: b, reason: collision with root package name */
    private a6.b f١٦٣٦٤b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, a6.b bVar) {
        this.f١٦٣٦٣a = aVar;
        this.f١٦٣٦٤b = bVar;
    }

    private void d(int i10, String str) {
        String str2;
        String str3;
        String str4;
        String sb;
        a aVar = this.f١٦٣٦٣a;
        String str5 = aVar.f١٦٣٢٩b;
        if (aVar.f١٦٣٣٠c) {
            str2 = aVar.f١٦٣٣٨k.format(Thread.currentThread());
        } else {
            str2 = null;
        }
        a aVar2 = this.f١٦٣٦٣a;
        if (aVar2.f١٦٣٣١d) {
            v5.b bVar = aVar2.f١٦٣٣٩l;
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            a aVar3 = this.f١٦٣٦٣a;
            str3 = bVar.format(z5.a.b(stackTrace, aVar3.f١٦٣٣٢e, aVar3.f١٦٣٣٣f));
        } else {
            str3 = null;
        }
        if (this.f١٦٣٦٣a.f١٦٣٤٢o != null) {
            b bVar2 = new b(i10, str5, str2, str3, str);
            Iterator it = this.f١٦٣٦٣a.f١٦٣٤٢o.iterator();
            if (!it.hasNext()) {
                i10 = bVar2.f١٦٣٥٨a;
                str5 = bVar2.f١٦٣٥٩b;
                str2 = bVar2.f١٦٣٦١d;
                str3 = bVar2.f١٦٣٦٢e;
                str = bVar2.f١٦٣٦٠c;
            } else {
                a0.a(it.next());
                throw null;
            }
        }
        a6.b bVar3 = this.f١٦٣٦٤b;
        a aVar4 = this.f١٦٣٦٣a;
        if (aVar4.f١٦٣٣٤g) {
            sb = aVar4.f١٦٣٤٠m.format(new String[]{str2, str3, str});
        } else {
            StringBuilder sb2 = new StringBuilder();
            String str6 = "";
            if (str2 == null) {
                str4 = "";
            } else {
                str4 = str2 + x5.c.f١٨٩٣٠a;
            }
            sb2.append(str4);
            if (str3 != null) {
                str6 = str3 + x5.c.f١٨٩٣٠a;
            }
            sb2.append(str6);
            sb2.append(str);
            sb = sb2.toString();
        }
        bVar3.println(i10, str5, sb);
    }

    public void a(String str) {
        c(6, str);
    }

    public void b(String str) {
        c(4, str);
    }

    void c(int i10, String str) {
        if (i10 < this.f١٦٣٦٣a.f١٦٣٢٨a) {
            return;
        }
        if (str == null) {
            str = "";
        }
        d(i10, str);
    }
}
