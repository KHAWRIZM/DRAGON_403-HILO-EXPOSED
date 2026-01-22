package anet.channel.e;

import android.content.SharedPreferences;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class c implements IStrategyListener {
    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(l.d dVar) {
        String str;
        String str2;
        String str3;
        if (dVar != null && dVar.f٥٠٣٩b != null) {
            int i10 = 0;
            loop0: while (true) {
                l.b[] bVarArr = dVar.f٥٠٣٩b;
                if (i10 < bVarArr.length) {
                    l.b bVar = bVarArr[i10];
                    str = bVar.f٥٠٢٤a;
                    l.a[] aVarArr = bVar.f٥٠٣١h;
                    if (aVarArr != null && aVarArr.length > 0) {
                        for (l.a aVar : aVarArr) {
                            String str4 = aVar.f٥٠١٧b;
                            if (ConnType.HTTP3.equals(str4) || ConnType.HTTP3_PLAIN.equals(str4)) {
                                break loop0;
                            }
                        }
                    }
                    i10++;
                } else {
                    return;
                }
            }
            str2 = a.f٤٧٤٦b;
            if (!str.equals(str2)) {
                String unused = a.f٤٧٤٦b = str;
                SharedPreferences.Editor edit = a.f٤٧٥٠f.edit();
                str3 = a.f٤٧٤٦b;
                edit.putString("http3_detector_host", str3);
                edit.apply();
            }
            a.a(NetworkStatusHelper.getStatus());
        }
    }
}
