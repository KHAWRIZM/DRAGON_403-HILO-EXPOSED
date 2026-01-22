package com.alibaba.sdk.android.push;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface PushControlService {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface ConnectionChangeListener {
        void onConnect();

        void onDisconnect(String str, String str2);
    }

    void disconnect();

    boolean isConnected();

    void reconnect();

    void reset();

    void setConnectionChangeListener(ConnectionChangeListener connectionChangeListener);
}
