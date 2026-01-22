package anetwork.channel.entity;

import anetwork.channel.Header;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class BasicHeader implements Header {
    private final String name;
    private final String value;

    public BasicHeader(String str, String str2) {
        if (str != null) {
            this.name = str;
            this.value = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    @Override // anetwork.channel.Header
    public String getName() {
        return this.name;
    }

    @Override // anetwork.channel.Header
    public String getValue() {
        return this.value;
    }
}
