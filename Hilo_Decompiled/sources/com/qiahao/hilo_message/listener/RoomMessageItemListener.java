package com.qiahao.hilo_message.listener;

import com.qiahao.hilo_message.data.RoomMessageMulti;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\u0019"}, d2 = {"Lcom/qiahao/hilo_message/listener/RoomMessageItemListener;", "", "onMessageLongClick", "", "messageInfo", "Lcom/qiahao/hilo_message/data/RoomMessageMulti;", "onMessageClick", "onUserIconClick", "onUserIconLongClick", "onResendMessage", "onReEditRevokeMessage", "onRecallClick", "onReplyDetailClick", "messageBean", "onReactOnClick", "emojiId", "", "onSendFailBtnClick", "onTextSelected", "onTranslationLongClick", "onTypeClick", "type", "", "onType", "data", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface RoomMessageItemListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void onMessageClick(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onMessageLongClick(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onReEditRevokeMessage(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onReactOnClick(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable String str, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onRecallClick(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onReplyDetailClick(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onResendMessage(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onSendFailBtnClick(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onTextSelected(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onTranslationLongClick(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onType(@NotNull RoomMessageItemListener roomMessageItemListener, int i10, @Nullable Object obj) {
        }

        public static void onTypeClick(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti, int i10) {
        }

        public static void onUserIconClick(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }

        public static void onUserIconLongClick(@NotNull RoomMessageItemListener roomMessageItemListener, @Nullable RoomMessageMulti roomMessageMulti) {
        }
    }

    void onMessageClick(@Nullable RoomMessageMulti messageInfo);

    void onMessageLongClick(@Nullable RoomMessageMulti messageInfo);

    void onReEditRevokeMessage(@Nullable RoomMessageMulti messageInfo);

    void onReactOnClick(@Nullable String emojiId, @Nullable RoomMessageMulti messageBean);

    void onRecallClick(@Nullable RoomMessageMulti messageInfo);

    void onReplyDetailClick(@Nullable RoomMessageMulti messageBean);

    void onResendMessage(@Nullable RoomMessageMulti messageInfo);

    void onSendFailBtnClick(@Nullable RoomMessageMulti messageInfo);

    void onTextSelected(@Nullable RoomMessageMulti messageInfo);

    void onTranslationLongClick(@Nullable RoomMessageMulti messageInfo);

    void onType(int type, @Nullable Object data);

    void onTypeClick(@Nullable RoomMessageMulti messageInfo, int type);

    void onUserIconClick(@Nullable RoomMessageMulti messageInfo);

    void onUserIconLongClick(@Nullable RoomMessageMulti messageInfo);
}
