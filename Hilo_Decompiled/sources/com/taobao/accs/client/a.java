package com.taobao.accs.client;

import android.text.TextUtils;
import com.taobao.accs.IAppReceiver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    private ConcurrentHashMap<String, HashSet<IAppReceiver>> a;

    /* renamed from: com.taobao.accs.client.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class C٠٠٠٦a {
        private static final a a = new a();

        private C٠٠٠٦a() {
        }
    }

    public static a a() {
        return C٠٠٠٦a.a;
    }

    public ArrayList<IAppReceiver> b() {
        HashSet hashSet = new HashSet();
        Iterator<HashSet<IAppReceiver>> it = this.a.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next());
        }
        return new ArrayList<>(hashSet);
    }

    private a() {
        this.a = new ConcurrentHashMap<>(2);
    }

    public void a(String str, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            HashSet<IAppReceiver> hashSet = this.a.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.a.put(str, hashSet);
            }
            if (hashSet.contains(iAppReceiver)) {
                return;
            }
            hashSet.add(iAppReceiver);
        }
    }

    public void b(String str) {
        try {
            this.a.remove(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ArrayList<IAppReceiver> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet<IAppReceiver> hashSet = this.a.get(str);
        if (hashSet == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(hashSet);
    }
}
