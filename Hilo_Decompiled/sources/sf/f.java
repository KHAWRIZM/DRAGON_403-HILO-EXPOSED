package sf;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class f implements Handler.Callback {
    private String a;
    private boolean b;
    private boolean c;
    private int d;
    private i e;
    private List f;
    private Handler g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ e b;

        a(Context context, e eVar) {
            this.a = context;
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.g.sendMessage(f.this.g.obtainMessage(1));
                File d = f.this.d(this.a, this.b);
                Message obtainMessage = f.this.g.obtainMessage(0);
                obtainMessage.arg1 = this.b.getIndex();
                obtainMessage.obj = d;
                Bundle bundle = new Bundle();
                bundle.putString("source", this.b.getPath());
                obtainMessage.setData(bundle);
                f.this.g.sendMessage(obtainMessage);
            } catch (Exception unused) {
                Message obtainMessage2 = f.this.g.obtainMessage(2);
                obtainMessage2.arg1 = this.b.getIndex();
                Bundle bundle2 = new Bundle();
                bundle2.putString("source", this.b.getPath());
                obtainMessage2.setData(bundle2);
                f.this.g.sendMessage(obtainMessage2);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class b {
        private Context a;
        private String b;
        private boolean c;
        private i f;
        private boolean d = true;
        private int e = 100;
        private List g = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public class a extends d {
            final /* synthetic */ File a;
            final /* synthetic */ int b;

            a(File file, int i) {
                this.a = file;
                this.b = i;
            }

            @Override // sf.d
            public InputStream a() {
                return tf.b.d().f(this.a.getAbsolutePath());
            }

            @Override // sf.e
            public int getIndex() {
                return this.b;
            }

            @Override // sf.e
            public String getPath() {
                return this.a.getAbsolutePath();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: sf.f$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public class C٠٠٥٥b extends d {
            final /* synthetic */ String a;
            final /* synthetic */ int b;

            C٠٠٥٥b(String str, int i) {
                this.a = str;
                this.b = i;
            }

            @Override // sf.d
            public InputStream a() {
                return tf.b.d().f(this.a);
            }

            @Override // sf.e
            public int getIndex() {
                return this.b;
            }

            @Override // sf.e
            public String getPath() {
                return this.a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public class c extends d {
            final /* synthetic */ Uri a;
            final /* synthetic */ int b;

            c(Uri uri, int i) {
                this.a = uri;
                this.b = i;
            }

            @Override // sf.d
            public InputStream a() {
                if (b.this.d) {
                    return tf.b.d().e(b.this.a.getContentResolver(), this.a);
                }
                return b.this.a.getContentResolver().openInputStream(this.a);
            }

            @Override // sf.e
            public int getIndex() {
                return this.b;
            }

            @Override // sf.e
            public String getPath() {
                if (sf.a.f(this.a.toString())) {
                    return this.a.toString();
                }
                return this.a.getPath();
            }
        }

        b(Context context) {
            this.a = context;
        }

        static /* synthetic */ j e(b bVar) {
            bVar.getClass();
            return null;
        }

        static /* synthetic */ h g(b bVar) {
            bVar.getClass();
            return null;
        }

        static /* synthetic */ sf.b j(b bVar) {
            bVar.getClass();
            return null;
        }

        private f k() {
            return new f(this, null);
        }

        private b n(Uri uri, int i) {
            this.g.add(new c(uri, i));
            return this;
        }

        private b o(File file, int i) {
            this.g.add(new a(file, i));
            return this;
        }

        private b p(String str, int i) {
            this.g.add(new C٠٠٥٥b(str, i));
            return this;
        }

        public b l(int i) {
            this.e = i;
            return this;
        }

        public void m() {
            k().i(this.a);
        }

        public b q(List list) {
            int i = -1;
            for (Object obj : list) {
                i++;
                if (obj instanceof String) {
                    p((String) obj, i);
                } else if (obj instanceof File) {
                    o((File) obj, i);
                } else if (obj instanceof Uri) {
                    n((Uri) obj, i);
                } else {
                    throw new IllegalArgumentException("Incoming data type exception, it must be String, File, Uri or Bitmap");
                }
            }
            return this;
        }

        public b r(i iVar) {
            this.f = iVar;
            return this;
        }
    }

    /* synthetic */ f(b bVar, a aVar) {
        this(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File d(Context context, e eVar) {
        try {
            return e(context, eVar);
        } finally {
            eVar.close();
        }
    }

    private File e(Context context, e eVar) {
        String path;
        sf.a aVar = sf.a.SINGLE;
        File h = h(context, aVar.c(eVar));
        if (sf.a.f(eVar.getPath())) {
            path = g.b(context, Uri.parse(eVar.getPath()));
        } else {
            path = eVar.getPath();
        }
        if (aVar.i(this.d, path)) {
            return new c(eVar, h, this.b).a();
        }
        return new File(path);
    }

    private File f(Context context) {
        return g(context, "luban_disk_cache");
    }

    private static File g(Context context, String str) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(externalCacheDir, str);
            if (!file.mkdirs() && (!file.exists() || !file.isDirectory())) {
                return null;
            }
            return file;
        }
        if (Log.isLoggable("Luban", 6)) {
            Log.e("Luban", "default disk cache dir is null");
        }
        return null;
    }

    private File h(Context context, String str) {
        if (TextUtils.isEmpty(this.a)) {
            this.a = f(context).getAbsolutePath();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.a);
        sb2.append("/");
        sb2.append(System.currentTimeMillis());
        sb2.append((int) (Math.random() * 1000.0d));
        if (TextUtils.isEmpty(str)) {
            str = ".jpg";
        }
        sb2.append(str);
        return new File(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Context context) {
        List list = this.f;
        if (list != null && list.size() != 0) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                AsyncTask.SERIAL_EXECUTOR.execute(new a(context, (e) it.next()));
                it.remove();
            }
            return;
        }
        i iVar = this.e;
        if (iVar != null) {
            iVar.onError("", new NullPointerException("image file cannot be null"));
        }
    }

    public static b j(Context context) {
        return new b(context);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        i iVar;
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                if (i == 2 && (iVar = this.e) != null) {
                    iVar.onError(message.getData().getString("source"), (Throwable) message.obj);
                    return false;
                }
                return false;
            }
            i iVar2 = this.e;
            if (iVar2 != null) {
                iVar2.onStart();
                return false;
            }
            return false;
        }
        i iVar3 = this.e;
        if (iVar3 != null) {
            iVar3.onSuccess(message.getData().getString("source"), (File) message.obj);
            return false;
        }
        return false;
    }

    private f(b bVar) {
        this.a = bVar.b;
        this.b = bVar.c;
        this.c = bVar.d;
        b.e(bVar);
        this.f = bVar.g;
        b.g(bVar);
        this.e = bVar.f;
        this.d = bVar.e;
        b.j(bVar);
        this.g = new Handler(Looper.getMainLooper(), this);
    }
}
