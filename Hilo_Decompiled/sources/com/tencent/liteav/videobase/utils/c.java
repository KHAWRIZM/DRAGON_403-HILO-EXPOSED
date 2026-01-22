package com.tencent.liteav.videobase.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class c {
    private static final Object f = new Object();
    private static c g;
    final Context a;
    private final Handler e;
    final HashMap<BroadcastReceiver, ArrayList<b>> b = new HashMap<>();
    private final HashMap<String, ArrayList<b>> d = new HashMap<>();
    final ArrayList<a> c = new ArrayList<>();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static final class a {
        final Intent a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static final class b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;

        public final String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.b);
            sb2.append(" filter=");
            sb2.append(this.a);
            if (this.d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    private c(Context context) {
        this.a = context;
        this.e = new Handler(context.getMainLooper()) { // from class: com.tencent.liteav.videobase.utils.c.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int size;
                a[] aVarArr;
                if (message.what == 1) {
                    c cVar = c.this;
                    while (true) {
                        synchronized (cVar.b) {
                            try {
                                size = cVar.c.size();
                                if (size <= 0) {
                                    return;
                                }
                                aVarArr = new a[size];
                                cVar.c.toArray(aVarArr);
                                cVar.c.clear();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        for (int i = 0; i < size; i++) {
                            a aVar = aVarArr[i];
                            int size2 = aVar.b.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                b bVar = aVar.b.get(i2);
                                if (!bVar.d) {
                                    bVar.b.onReceive(cVar.a, aVar.a);
                                }
                            }
                        }
                    }
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    public static c a() {
        c cVar;
        synchronized (f) {
            try {
                if (g == null) {
                    g = new c(ContextUtils.getApplicationContext());
                }
                cVar = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public final boolean a(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        String str3;
        synchronized (this.b) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z = (intent.getFlags() & 8) != 0;
                if (z) {
                    LiteavLog.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList<b> arrayList3 = this.d.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z) {
                        LiteavLog.v("LocalBroadcastManager", "Action list: ".concat(String.valueOf(arrayList3)));
                    }
                    ArrayList arrayList4 = null;
                    int i2 = 0;
                    while (i2 < arrayList3.size()) {
                        b bVar = arrayList3.get(i2);
                        if (z) {
                            LiteavLog.v("LocalBroadcastManager", "Matching against filter " + bVar.a);
                        }
                        if (bVar.c) {
                            if (z) {
                                LiteavLog.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            i = i2;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i = i2;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = resolveTypeIfNeeded;
                            int match = bVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (match >= 0) {
                                if (z) {
                                    LiteavLog.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                }
                                arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                arrayList4.add(bVar);
                                bVar.c = true;
                                i2 = i + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                resolveTypeIfNeeded = str2;
                            } else if (z) {
                                if (match == -4) {
                                    str3 = "category";
                                } else if (match == -3) {
                                    str3 = "action";
                                } else if (match == -2) {
                                    str3 = "data";
                                } else if (match != -1) {
                                    str3 = "unknown reason";
                                } else {
                                    str3 = "type";
                                }
                                LiteavLog.v("LocalBroadcastManager", "  Filter did not match: ".concat(str3));
                            }
                        }
                        arrayList4 = arrayList;
                        i2 = i + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        resolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                            ((b) arrayList5.get(i3)).c = false;
                        }
                        this.c.add(new a(intent, arrayList5));
                        if (!this.e.hasMessages(1)) {
                            this.e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
