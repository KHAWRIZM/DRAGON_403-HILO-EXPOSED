package com.qiahao.nextvideo.room.interfaces;

import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH&¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/room/interfaces/UserInfoListener;", "", "kickDownMic", "", "micPosition", "", "downMic", "inviteUserUpMic", TUIConstants.TUILive.USER_ID, "", "unMuteMic", "muteMic", "isMyself", "", "giftShow", "extraId", "userName", "videoRequesPermiss", "callUser", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface UserInfoListener {
    void callUser(@NotNull String extraId, @NotNull String userName);

    void downMic(int micPosition);

    void giftShow(@NotNull String extraId, @NotNull String userName);

    void inviteUserUpMic(@NotNull String userId);

    void kickDownMic(int micPosition);

    void muteMic(int micPosition, boolean isMyself);

    void unMuteMic(int micPosition);

    void videoRequesPermiss();
}
