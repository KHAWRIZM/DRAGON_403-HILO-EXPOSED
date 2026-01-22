package b3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f٥٣٧٢f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static a f٥٣٧٣g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f٥٣٧٤a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f٥٣٧٥b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f٥٣٧٦c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList f٥٣٧٧d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f٥٣٧٨e;

    /* renamed from: b3.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class HandlerC٠٠٦٥a extends Handler {
        HandlerC٠٠٦٥a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Intent f٥٣٨٠a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList f٥٣٨١b;

        b(Intent intent, ArrayList arrayList) {
            this.f٥٣٨٠a = intent;
            this.f٥٣٨١b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f٥٣٨٢a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f٥٣٨٣b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٥٣٨٤c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٥٣٨٥d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f٥٣٨٢a = intentFilter;
            this.f٥٣٨٣b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f٥٣٨٣b);
            sb.append(" filter=");
            sb.append(this.f٥٣٨٢a);
            if (this.f٥٣٨٥d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private a(Context context) {
        this.f٥٣٧٤a = context;
        this.f٥٣٧٨e = new HandlerC٠٠٦٥a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f٥٣٧٢f) {
            try {
                if (f٥٣٧٣g == null) {
                    f٥٣٧٣g = new a(context.getApplicationContext());
                }
                aVar = f٥٣٧٣g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f٥٣٧٥b) {
                try {
                    size = this.f٥٣٧٧d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f٥٣٧٧d.toArray(bVarArr);
                    this.f٥٣٧٧d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = bVarArr[i10];
                int size2 = bVar.f٥٣٨١b.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c cVar = (c) bVar.f٥٣٨١b.get(i11);
                    if (!cVar.f٥٣٨٥d) {
                        cVar.f٥٣٨٣b.onReceive(this.f٥٣٧٤a, bVar.f٥٣٨٠a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f٥٣٧٥b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) this.f٥٣٧٥b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f٥٣٧٥b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                    String action = intentFilter.getAction(i10);
                    ArrayList arrayList2 = (ArrayList) this.f٥٣٧٦c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f٥٣٧٦c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Intent intent) {
        boolean z10;
        int i10;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        String str3;
        synchronized (this.f٥٣٧٥b) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f٥٣٧٤a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                if ((intent.getFlags() & 8) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList3 = (ArrayList) this.f٥٣٧٦c.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z10) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                    }
                    ArrayList arrayList4 = null;
                    int i11 = 0;
                    while (i11 < arrayList3.size()) {
                        c cVar = (c) arrayList3.get(i11);
                        if (z10) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f٥٣٨٢a);
                        }
                        if (cVar.f٥٣٨٤c) {
                            if (z10) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            i10 = i11;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i10 = i11;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = resolveTypeIfNeeded;
                            int match = cVar.f٥٣٨٢a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (match >= 0) {
                                if (z10) {
                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                }
                                if (arrayList == null) {
                                    arrayList4 = new ArrayList();
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList4.add(cVar);
                                cVar.f٥٣٨٤c = true;
                                i11 = i10 + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                resolveTypeIfNeeded = str2;
                            } else if (z10) {
                                if (match != -4) {
                                    if (match != -3) {
                                        if (match != -2) {
                                            if (match != -1) {
                                                str3 = "unknown reason";
                                            } else {
                                                str3 = "type";
                                            }
                                        } else {
                                            str3 = "data";
                                        }
                                    } else {
                                        str3 = NativeProtocol.WEB_DIALOG_ACTION;
                                    }
                                } else {
                                    str3 = "category";
                                }
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str3);
                            }
                        }
                        arrayList4 = arrayList;
                        i11 = i10 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        resolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i12 = 0; i12 < arrayList5.size(); i12++) {
                            ((c) arrayList5.get(i12)).f٥٣٨٤c = false;
                        }
                        this.f٥٣٧٧d.add(new b(intent, arrayList5));
                        if (!this.f٥٣٧٨e.hasMessages(1)) {
                            this.f٥٣٧٨e.sendEmptyMessage(1);
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

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f٥٣٧٥b) {
            try {
                ArrayList arrayList = (ArrayList) this.f٥٣٧٥b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    c cVar = (c) arrayList.get(size);
                    cVar.f٥٣٨٥d = true;
                    for (int i10 = 0; i10 < cVar.f٥٣٨٢a.countActions(); i10++) {
                        String action = cVar.f٥٣٨٢a.getAction(i10);
                        ArrayList arrayList2 = (ArrayList) this.f٥٣٧٦c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = (c) arrayList2.get(size2);
                                if (cVar2.f٥٣٨٣b == broadcastReceiver) {
                                    cVar2.f٥٣٨٥d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f٥٣٧٦c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
