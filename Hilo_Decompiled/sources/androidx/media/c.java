package androidx.media;

import android.content.Context;
import android.service.media.MediaBrowserService;
import androidx.media.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class c {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a extends b.C٠٠٤٨b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Context context, b bVar) {
            super(context, bVar);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String str, MediaBrowserService.Result result) {
            ((b) this.f٣٩٦٤a).a(str, new b.c(result));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b extends b.d {
        void a(String str, b.c cVar);
    }

    public static Object a(Context context, b bVar) {
        return new a(context, bVar);
    }
}
