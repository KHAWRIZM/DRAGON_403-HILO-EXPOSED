package com.taobao.accs.net;

import com.taobao.accs.data.Message;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class x implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ boolean b;
    final /* synthetic */ w c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, Message message, boolean z) {
        this.c = wVar;
        this.a = message;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.c.t) {
            try {
                this.c.a(this.a);
                if (this.c.t.size() == 0) {
                    this.c.t.add(this.a);
                } else {
                    Message message = (Message) this.c.t.getFirst();
                    if (this.a.a() != 1 && this.a.a() != 0) {
                        if (this.a.a() == 2 && message.a() == 2) {
                            if (!message.d && this.a.d) {
                                this.c.t.removeFirst();
                                this.c.t.addFirst(this.a);
                            }
                        } else {
                            this.c.t.addLast(this.a);
                        }
                    }
                    this.c.t.addLast(this.a);
                    if (message.a() == 2) {
                        this.c.t.removeFirst();
                    }
                }
                if (this.b || this.c.s == 3) {
                    try {
                        this.c.t.notifyAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
