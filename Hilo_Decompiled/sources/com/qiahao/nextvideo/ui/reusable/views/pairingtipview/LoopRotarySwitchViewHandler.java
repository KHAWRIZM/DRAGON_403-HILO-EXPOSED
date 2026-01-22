package com.qiahao.nextvideo.ui.reusable.views.pairingtipview;

import android.os.Handler;
import android.os.Message;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u0006\u0010\u0015\u001a\u00020\u0007J\b\u0010\u0016\u001a\u00020\u0011H&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/LoopRotarySwitchViewHandler;", "Landroid/os/Handler;", AgooConstants.MESSAGE_TIME, "", "<init>", "(I)V", "loop", "", "loopTime", "", "getLoopTime", "()J", "setLoopTime", "(J)V", "msg", "Landroid/os/Message;", "handleMessage", "", "setLoop", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, "createMessage", "isLoop", "doScroll", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLoopRotarySwitchViewHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoopRotarySwitchViewHandler.kt\ncom/qiahao/nextvideo/ui/reusable/views/pairingtipview/LoopRotarySwitchViewHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1#2:63\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LoopRotarySwitchViewHandler extends Handler {
    public static final int msgid = 1000;
    private boolean loop;
    private long loopTime;

    @NotNull
    private Message msg = createMessage();

    public LoopRotarySwitchViewHandler(int i) {
        this.loopTime = i;
    }

    private final Message createMessage() {
        Message message = new Message();
        message.what = 1000;
        return message;
    }

    private final void sendMessage() {
        try {
            removeMessages(1000);
        } catch (Exception unused) {
        }
        Message createMessage = createMessage();
        this.msg = createMessage;
        sendMessageDelayed(createMessage, this.loopTime);
    }

    public abstract void doScroll();

    public final long getLoopTime() {
        return this.loopTime;
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        msg.what = 1000;
        if (this.loop) {
            doScroll();
            sendMessage();
        }
        super.handleMessage(msg);
    }

    /* renamed from: isLoop, reason: from getter */
    public final boolean getLoop() {
        return this.loop;
    }

    public final void setLoop(boolean loop) {
        this.loop = loop;
        if (loop) {
            sendMessage();
        } else {
            try {
                removeMessages(1000);
            } catch (Exception unused) {
            }
        }
    }

    public final void setLoopTime(long j) {
        this.loopTime = j;
    }
}
