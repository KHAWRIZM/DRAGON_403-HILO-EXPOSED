package com.qiahao.nextvideo.utilities;

import com.qiahao.nextvideo.utilities.userproxy.Protocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import userProxy.UserProxy;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/h0;", "", "printf", "(Lcom/google/protobuf/h0;)Ljava/lang/String;", "Lcom/qiahao/nextvideo/utilities/userproxy/Protocol;", "toString", "(Lcom/qiahao/nextvideo/utilities/userproxy/Protocol;)Ljava/lang/String;", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PrintUtilityKt {
    @NotNull
    public static final String printf(@NotNull com.google.protobuf.h0 h0Var) {
        Intrinsics.checkNotNullParameter(h0Var, "<this>");
        if (h0Var instanceof UserProxy.LoginRsp) {
            return "status: " + ((UserProxy.LoginRsp) h0Var).getStatus();
        }
        if (h0Var instanceof UserProxy.HeartBeatRsp) {
            return "status: " + ((UserProxy.HeartBeatRsp) h0Var).getStatus();
        }
        if (h0Var instanceof UserProxy.MatchSuccess) {
            UserProxy.MatchSuccess matchSuccess = (UserProxy.MatchSuccess) h0Var;
            return "channelId: " + matchSuccess.getLocalUserId() + ", myExtUserId: " + matchSuccess.getRemoteUserId() + ", otherExtUserId: " + matchSuccess.getMatchUniqueId() + ", waitDuration: " + matchSuccess.getWaitDuration() + ", status: " + matchSuccess.getStatus();
        }
        return "unkonwn message";
    }

    @NotNull
    public static final String toString(@NotNull Protocol protocol) {
        Intrinsics.checkNotNullParameter(protocol, "<this>");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        short version = protocol.getVersion();
        return stackTrace + ", version: " + ((int) version) + ", msgType: " + protocol.getMsgType() + ", msgID: " + protocol.getMsgID() + ", timestamp: " + protocol.getTimestamp() + ", dataSize: " + protocol.getDataSize() + ", data: " + protocol.getData() + "crc32: [remote: " + protocol.getRemoteCrc35() + ", local: " + protocol.getLocalCrc35() + "]}";
    }
}
