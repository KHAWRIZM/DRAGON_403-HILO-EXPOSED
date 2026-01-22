package com.taobao.accs.utl;

import java.io.ByteArrayOutputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class g extends ByteArrayOutputStream {
    public g(int i) {
        super(i);
    }

    public g a(byte b) {
        write(b);
        return this;
    }

    public g() {
    }

    public g a(short s) {
        write(s >> 8);
        write(s);
        return this;
    }
}
