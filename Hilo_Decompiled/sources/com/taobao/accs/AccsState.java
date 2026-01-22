package com.taobao.accs;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AccsState {
    public static final String ALL = "all";
    public static final String BIND_APP_FROM_CACHE = "bfc";
    public static final String CONNECTION_CHANGE = "cc";
    public static final String LAST_MSG_RECEIVE_TIME = "lmrt";
    public static final String LAST_MSG_SEND_TIME = "lmst";
    public static final String RECENT_ERRORS = "re";
    public static final String SDK_VERSION = "sv";
    private HashMap<String, c> a = new HashMap<>();
    private long b = -1;
    private long c = -1;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class a {
        private static final AccsState a = new AccsState();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class b {
        public long a;
        public String b;
        public String c;

        public b(long j, String str, String str2) {
            this.a = j;
            this.b = str;
            this.c = str2;
        }

        public JSONArray a() {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.a);
            jSONArray.put(this.b);
            jSONArray.put(this.c);
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class c {
        public static final int MAX_HISTORY = 5;
        private HashMap<String, b> a;
        private HashMap<String, ArrayList<b>> b;

        private c() {
            this.a = new HashMap<>();
            this.b = new HashMap<>();
        }

        public void a(String str, Object obj, long j) {
            this.a.put(str, new b(j, str, a(obj)));
        }

        public void b(String str, Object obj, long j) {
            ArrayList<b> arrayList = this.b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.b.put(str, arrayList);
            }
            arrayList.add(new b(j, str, a(obj)));
            while (arrayList.size() > 5) {
                arrayList.remove(0);
            }
        }

        private static String a(Object obj) {
            if (obj == null) {
                return "null";
            }
            return obj.toString();
        }

        public boolean a(String str) {
            return this.a.keySet().contains(str) || this.b.keySet().contains(str);
        }

        public JSONArray a() {
            JSONArray jSONArray = new JSONArray();
            Iterator it = new ArrayList(this.a.values()).iterator();
            while (it.hasNext()) {
                jSONArray.put(((b) it.next()).a());
            }
            ArrayList arrayList = new ArrayList();
            Iterator<ArrayList<b>> it2 = this.b.values().iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next());
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                jSONArray.put(((b) it3.next()).a());
            }
            return jSONArray;
        }

        public JSONArray b(String str) {
            JSONArray jSONArray = new JSONArray();
            b bVar = this.a.get(str);
            if (bVar != null) {
                jSONArray.put(bVar.a());
            }
            ArrayList<b> arrayList = this.b.get(str);
            if (arrayList != null) {
                Iterator<b> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().a());
                }
            }
            return jSONArray;
        }
    }

    protected AccsState() {
    }

    public static AccsState getInstance() {
        return a.a;
    }

    public synchronized void a(String str, Object obj) {
        a("all").a(str, obj, b());
    }

    public synchronized void b(String str, Object obj) {
        a("all").b(str, obj, b());
    }

    public synchronized String getState() {
        if (!a(this.a)) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", this.c);
            Iterator it = new ArrayList(this.a.entrySet()).iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                jSONObject.put((String) entry.getKey(), ((c) entry.getValue()).a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    public synchronized String getStateByKey(String str) {
        if (!a(this.a, str)) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", this.c);
            Iterator it = new ArrayList(this.a.entrySet()).iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((c) entry.getValue()).a(str)) {
                    jSONObject.put((String) entry.getKey(), ((c) entry.getValue()).b(str));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    public synchronized void a(String str, String str2, Object obj) {
        a(str).a(str2, obj, b());
    }

    public synchronized void b(String str, String str2, Object obj) {
        a(str).b(str2, obj, b());
    }

    private c a(String str) {
        c cVar = this.a.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.a.put(str, cVar2);
        return cVar2;
    }

    private long b() {
        a();
        return SystemClock.elapsedRealtime() - this.b;
    }

    private void a() {
        if (this.c < 0 || this.b < 0) {
            this.c = System.currentTimeMillis();
            this.b = SystemClock.elapsedRealtime();
        }
    }

    private boolean a(HashMap<String, c> hashMap) {
        return hashMap.size() > 0;
    }

    private boolean a(HashMap<String, c> hashMap, String str) {
        Iterator it = new ArrayList(hashMap.values()).iterator();
        while (it.hasNext()) {
            if (((c) it.next()).a(str)) {
                return true;
            }
        }
        return false;
    }
}
