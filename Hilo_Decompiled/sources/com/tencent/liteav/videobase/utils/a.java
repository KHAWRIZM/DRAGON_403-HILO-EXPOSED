package com.tencent.liteav.videobase.utils;

import java.util.LinkedList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class a {
    public final LinkedList<Runnable> a = new LinkedList<>();

    public final void a() {
        LinkedList linkedList;
        synchronized (this.a) {
            try {
                if (!this.a.isEmpty()) {
                    linkedList = new LinkedList(this.a);
                    this.a.clear();
                } else {
                    linkedList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        while (linkedList != null && !linkedList.isEmpty()) {
            ((Runnable) linkedList.removeFirst()).run();
        }
    }
}
