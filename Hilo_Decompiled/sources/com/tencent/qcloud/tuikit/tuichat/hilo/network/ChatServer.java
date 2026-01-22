package com.tencent.qcloud.tuikit.tuichat.hilo.network;

import android.annotation.SuppressLint;
import com.qiahao.base_common.network.BaseServer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import md.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pd.g;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/network/ChatServer;", "", "<init>", "()V", "apis", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/network/ChatApi;", "getApis", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CheckResult"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ChatServer {

    @NotNull
    public static final ChatServer INSTANCE = new ChatServer();

    @Nullable
    private static ChatApi apis;

    static {
        BaseServer.INSTANCE.getSelectedServerChange().observeOn(b.c()).subscribe(new g() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatServer.1
            public final void accept(String str) {
                ChatServer.apis = null;
            }
        });
    }

    private ChatServer() {
    }

    @NotNull
    public final ChatApi getApis() {
        if (apis == null) {
            synchronized (ChatServer.class) {
                try {
                    if (apis == null) {
                        apis = (ChatApi) BaseServer.INSTANCE.createApis(ChatApi.class);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ChatApi chatApi = apis;
        Intrinsics.checkNotNull(chatApi);
        return chatApi;
    }
}
