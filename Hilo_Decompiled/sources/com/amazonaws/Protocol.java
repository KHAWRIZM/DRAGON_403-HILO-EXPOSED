package com.amazonaws;

import anet.channel.util.HttpConstant;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum Protocol {
    HTTP(HttpConstant.HTTP),
    HTTPS(HttpConstant.HTTPS);

    private final String protocol;

    Protocol(String str) {
        this.protocol = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
