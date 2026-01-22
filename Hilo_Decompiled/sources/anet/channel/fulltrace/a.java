package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile IFullTraceAnalysis f٤٧٧٧a = new C٠٠٦٢a(null);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f٤٧٧٨b = false;

    /* renamed from: anet.channel.fulltrace.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class C٠٠٦٢a implements IFullTraceAnalysis {

        /* renamed from: a, reason: collision with root package name */
        private IFullTraceAnalysis f٤٧٧٩a;

        C٠٠٦٢a(IFullTraceAnalysis iFullTraceAnalysis) {
            this.f٤٧٧٩a = iFullTraceAnalysis;
            boolean unused = a.f٤٧٧٨b = true;
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public void commitRequest(String str, RequestStatistic requestStatistic) {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (a.f٤٧٧٨b && (iFullTraceAnalysis = this.f٤٧٧٩a) != null) {
                try {
                    iFullTraceAnalysis.commitRequest(str, requestStatistic);
                } catch (Throwable th) {
                    boolean unused = a.f٤٧٧٨b = false;
                    ALog.e("anet.AnalysisFactory", "fulltrace commit fail.", null, th, new Object[0]);
                }
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public String createRequest() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.f٤٧٧٨b || (iFullTraceAnalysis = this.f٤٧٧٩a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.createRequest();
            } catch (Throwable th) {
                boolean unused = a.f٤٧٧٨b = false;
                ALog.e("anet.AnalysisFactory", "createRequest fail.", null, th, new Object[0]);
                return null;
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public b getSceneInfo() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.f٤٧٧٨b || (iFullTraceAnalysis = this.f٤٧٧٩a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.getSceneInfo();
            } catch (Throwable th) {
                boolean unused = a.f٤٧٧٨b = false;
                ALog.e("anet.AnalysisFactory", "getSceneInfo fail", null, th, new Object[0]);
                return null;
            }
        }
    }

    public static IFullTraceAnalysis a() {
        return f٤٧٧٧a;
    }

    public static void a(IFullTraceAnalysis iFullTraceAnalysis) {
        f٤٧٧٧a = new C٠٠٦٢a(iFullTraceAnalysis);
    }
}
