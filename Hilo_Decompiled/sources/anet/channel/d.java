package anet.channel;

import anet.channel.security.ISecurity;
import anet.channel.strategy.dispatch.IAmdcSign;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d implements IAmdcSign {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f٤٦٩٨a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ISecurity f٤٦٩٩b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionCenter f٤٧٠٠c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SessionCenter sessionCenter, String str, ISecurity iSecurity) {
        this.f٤٧٠٠c = sessionCenter;
        this.f٤٦٩٨a = str;
        this.f٤٦٩٩b = iSecurity;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String getAppkey() {
        return this.f٤٦٩٨a;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String sign(String str) {
        return this.f٤٦٩٩b.sign(this.f٤٧٠٠c.f٤٦٣٩b, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public boolean useSecurityGuard() {
        return !this.f٤٦٩٩b.isSecOff();
    }
}
