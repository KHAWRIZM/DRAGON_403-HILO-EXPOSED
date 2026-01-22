package com.qiahao.nextvideo.room.view;

import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/view/OnGroupInputLayoutListener;", "", "onStartGroupMemberSelectActivity", "", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, "msg", "", "mentionUsers", "", "LroomMessage/RoomMessage$TextElemContentAt;", "setShowSelectPicVideo", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface OnGroupInputLayoutListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void sendMessage$default(OnGroupInputLayoutListener onGroupInputLayoutListener, String str, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    list = null;
                }
                onGroupInputLayoutListener.sendMessage(str, list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMessage");
        }
    }

    void onStartGroupMemberSelectActivity();

    void sendMessage(@NotNull String msg, @Nullable List<RoomMessage.TextElemContentAt> mentionUsers);

    void setShowSelectPicVideo();
}
