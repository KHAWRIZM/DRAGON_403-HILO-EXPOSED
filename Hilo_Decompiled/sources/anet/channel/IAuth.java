package anet.channel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface IAuth {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface AuthCallback {
        void onAuthFail(int i10, String str);

        void onAuthSuccess();
    }

    void auth(Session session, AuthCallback authCallback);
}
