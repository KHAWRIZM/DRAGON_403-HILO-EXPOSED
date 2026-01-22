package i9;

import android.content.Context;
import android.content.Intent;
import java.util.List;
import p9.g;
import p9.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: i9.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class RunnableC٠١٦٨a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f١٤٧٩٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f١٤٧٩٥b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ r9.b f١٤٧٩٦c;

        RunnableC٠١٦٨a(Context context, Intent intent, r9.b bVar) {
            this.f١٤٧٩٤a = context;
            this.f١٤٧٩٥b = intent;
            this.f١٤٧٩٦c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<t9.a> b10 = m9.c.b(this.f١٤٧٩٤a, this.f١٤٧٩٥b);
            if (b10 == null) {
                return;
            }
            for (t9.a aVar : b10) {
                if (aVar != null) {
                    for (n9.c cVar : d.h().m()) {
                        if (cVar != null) {
                            cVar.a(this.f١٤٧٩٤a, aVar, this.f١٤٧٩٦c);
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, Intent intent, r9.b bVar) {
        if (context == null) {
            p9.d.b("context is null , please check param of parseIntent()");
            return;
        }
        if (intent == null) {
            p9.d.b("intent is null , please check param of parseIntent()");
            return;
        }
        if (bVar == null) {
            p9.d.b("callback is null , please check param of parseIntent()");
        } else if (!h.h(context)) {
            p9.d.b("push is null ,please check system has push");
        } else {
            g.a(new RunnableC٠١٦٨a(context, intent, bVar));
        }
    }
}
