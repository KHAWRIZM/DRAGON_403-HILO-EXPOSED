package com.tencent.imsdk.manager;

import com.tencent.imsdk.relationship.ReceiveMessageOptInfo;
import com.tencent.imsdk.relationship.UserInfo;
import com.tencent.imsdk.relationship.UserStatus;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface SDKListener {
    void onAllReceiveMessageOptChanged(ReceiveMessageOptInfo receiveMessageOptInfo);

    void onConnectFailed(int i, String str);

    void onConnectSuccess();

    void onConnecting();

    void onExperimentalNotify(String str, Object obj);

    void onKickedOffline();

    void onLog(int i, String str);

    void onSelfInfoUpdated(UserInfo userInfo);

    void onUserInfoChanged(List<UserInfo> list);

    void onUserSigExpired();

    void onUserStatusChanged(List<UserStatus> list);
}
