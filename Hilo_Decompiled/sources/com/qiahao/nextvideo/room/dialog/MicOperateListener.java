package com.qiahao.nextvideo.room.dialog;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/MicOperateListener;", "", "takeTheMic", "", "lockTheMic", "unlockTheMic", "micMute", "lockMic", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface MicOperateListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        public static void lockTheMic(@NotNull MicOperateListener micOperateListener) {
        }

        public static void takeTheMic(@NotNull MicOperateListener micOperateListener) {
        }

        public static void unlockTheMic(@NotNull MicOperateListener micOperateListener) {
        }
    }

    void lockTheMic();

    void micMute(boolean lockMic);

    void takeTheMic();

    void unlockTheMic();
}
