package com.qiahao.nextvideo.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.qiahao.base_common.utils.HiloToasty;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class r {
    private Activity a;
    private String b;
    private final String c;
    private final String d;
    private String e;
    private String f;
    private String g;
    private Bitmap h;
    private q i;
    private d j;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    class a extends d {
        a() {
            super();
        }

        @Override // com.qiahao.nextvideo.share.r.d
        void a(String str) {
            super.a(str);
            if (r.this.i != null && r.this.a != null) {
                int i = b.a[r.this.i.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        intent.setType("text/plain");
                        intent.setPackage("com.whatsapp");
                        List<ResolveInfo> queryIntentActivities = r.this.a.getPackageManager().queryIntentActivities(intent, 65536);
                        if (queryIntentActivities.isEmpty()) {
                            HiloToasty.Companion.normal(r.this.a, r.this.a.getString(2131953680), false).show();
                            return;
                        }
                        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                        while (it.hasNext()) {
                            ActivityInfo activityInfo = it.next().activityInfo;
                            String str2 = activityInfo.packageName;
                            if (str2 != null && str2.equals("com.whatsapp")) {
                                try {
                                    intent.setPackage(activityInfo.packageName);
                                    intent.setClassName(activityInfo.packageName, activityInfo.name);
                                    intent.putExtra("android.intent.extra.TEXT", r.this.d + "\n" + str);
                                    if (!TextUtils.isEmpty(r.this.f)) {
                                        intent.setType("image/*");
                                        intent.putExtra("android.intent.extra.STREAM", Uri.parse(r.this.f));
                                    } else {
                                        intent.setType("text/plain");
                                    }
                                    intent.addFlags(1);
                                    r.this.a.startActivity(intent);
                                    return;
                                } catch (Exception unused) {
                                    return;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                r.this.f(r.this.d + "\n" + str);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[q.values().length];
            a = iArr;
            try {
                iArr[q.COPYURL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[q.WHATSAPP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static class c {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private Bitmap g;

        public r h(Activity activity) {
            return new r(activity, this);
        }

        public c i(String str) {
            this.c = str;
            return this;
        }

        public c j(String str) {
            this.e = str;
            return this;
        }

        public c k(String str) {
            this.d = str;
            return this;
        }

        public c l(String str) {
            this.a = str;
            return this;
        }

        public c m(String str) {
            this.b = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class d {
        void a(String str) {
        }

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        ClipboardManager clipboardManager = (ClipboardManager) this.a.getSystemService("clipboard");
        if (str == null) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Activity activity = this.a;
            companion.normal(activity, activity.getString(2131952667), false).show();
        } else {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Label", str));
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            Activity activity2 = this.a;
            companion2.normal(activity2, activity2.getString(2131952377), false).show();
        }
    }

    private void g() {
        if (this.j != null && !TextUtils.isEmpty(this.b)) {
            this.j.a(this.b);
        }
    }

    public void h(q qVar) {
        this.i = qVar;
        g();
    }

    private r(Activity activity, c cVar) {
        this.b = "https://www.hiloconn.com";
        this.g = "https://www.hiloconn.com";
        this.j = new a();
        this.a = activity;
        this.c = cVar.b;
        this.d = cVar.c;
        this.e = cVar.d;
        this.b = cVar.a;
        this.g = cVar.e;
        this.f = cVar.f;
        this.h = cVar.g;
    }
}
