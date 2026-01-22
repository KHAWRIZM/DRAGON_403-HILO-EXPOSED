package uf;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class c implements Callback {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    public static /* synthetic */ void a(d dVar, int i, String str, String str2) {
        if (dVar != null) {
            if (i == 0) {
                dVar.onCompleted(str);
            } else {
                dVar.onFailure(i, str2);
            }
        }
    }

    public static /* synthetic */ void b(d dVar, IOException iOException) {
        if (dVar != null) {
            dVar.onFailure(d.a.a(iOException), "request error:" + iOException.toString());
        }
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call call, final IOException iOException) {
        LogUtils.file("AiHttpService", "request error：" + LogUtils.getErrorInfo(iOException));
        final d dVar = this.a;
        ThreadUtils.postUITask(new Runnable() { // from class: uf.a
            @Override // java.lang.Runnable
            public final void run() {
                c.b(d.this, iOException);
            }
        });
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) {
        final String str;
        final int i;
        final String str2 = null;
        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            i = 0;
            str = com.taobao.agoo.a.a.b.JSON_SUCCESS;
            if (body != null) {
                str2 = response.body().string();
            }
        } else {
            str = "http error code：" + response.code();
            i = -1;
        }
        final d dVar = this.a;
        ThreadUtils.postUITask(new Runnable() { // from class: uf.b
            @Override // java.lang.Runnable
            public final void run() {
                c.a(d.this, i, str2, str);
            }
        });
    }
}
