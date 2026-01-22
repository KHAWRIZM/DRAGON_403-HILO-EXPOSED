package com.google.protobuf;

import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class k0 extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    /* renamed from: a, reason: collision with root package name */
    private e1 f١١١٨٣a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١١١٨٤b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends k0 {
        private static final long serialVersionUID = 3283890091615336259L;

        public a(String str) {
            super(str);
        }
    }

    public k0(String str) {
        super(str);
        this.f١١١٨٣a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 a() {
        return new k0("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 b() {
        return new k0("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 c() {
        return new k0("Protocol message had invalid UTF-8.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a d() {
        return new a("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 e() {
        return new k0("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 f() {
        return new k0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 g() {
        return new k0("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 h() {
        return new k0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 k() {
        return new k0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 l() {
        return new k0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.f١١١٨٤b = true;
    }

    public k0 j(e1 e1Var) {
        this.f١١١٨٣a = e1Var;
        return this;
    }

    public IOException m() {
        if (getCause() instanceof IOException) {
            return (IOException) getCause();
        }
        return this;
    }

    public k0(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f١١١٨٣a = null;
    }
}
