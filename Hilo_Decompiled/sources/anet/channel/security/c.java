package anet.channel.security;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ISecurityFactory f٤٨٩٠a;

    public static ISecurityFactory a() {
        if (f٤٨٩٠a == null) {
            f٤٨٩٠a = new d();
        }
        return f٤٨٩٠a;
    }
}
