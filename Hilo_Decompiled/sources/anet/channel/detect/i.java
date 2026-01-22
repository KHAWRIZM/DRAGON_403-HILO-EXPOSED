package anet.channel.detect;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.HorseRaceStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class i implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f٤٧٣٠a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f٤٧٣٠a = hVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z10) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i10, String str, RequestStatistic requestStatistic) {
        int i11 = 0;
        ALog.i("anet.HorseRaceDetector", "LongLinkTask request finish", this.f٤٧٣٠a.f٤٧٢٦c, "statusCode", Integer.valueOf(i10), "msg", str);
        if (this.f٤٧٣٠a.f٤٧٢٤a.reqErrorCode == 0) {
            this.f٤٧٣٠a.f٤٧٢٤a.reqErrorCode = i10;
        } else {
            HorseRaceStat horseRaceStat = this.f٤٧٣٠a.f٤٧٢٤a;
            if (horseRaceStat.reqErrorCode == 200) {
                i11 = 1;
            }
            horseRaceStat.reqRet = i11;
        }
        HorseRaceStat horseRaceStat2 = this.f٤٧٣٠a.f٤٧٢٤a;
        long currentTimeMillis = System.currentTimeMillis();
        h hVar = this.f٤٧٣٠a;
        horseRaceStat2.reqTime = (currentTimeMillis - hVar.f٤٧٢٥b) + hVar.f٤٧٢٤a.connTime;
        synchronized (this.f٤٧٣٠a.f٤٧٢٤a) {
            this.f٤٧٣٠a.f٤٧٢٤a.notify();
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i10, Map<String, List<String>> map) {
        this.f٤٧٣٠a.f٤٧٢٤a.reqErrorCode = i10;
    }
}
