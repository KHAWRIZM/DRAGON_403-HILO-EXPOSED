package com.qiahao.nextvideo.view.youtube;

import kotlin.Metadata;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/view/youtube/YouTuListener;", "", "onClickAddVideo", "", "onClickVideoList", "playOrPause", "isPlay", "", "playPosition", AgooConstants.MESSAGE_TIME, "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface YouTuListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        public static void onClickAddVideo(@NotNull YouTuListener youTuListener) {
        }

        public static void onClickVideoList(@NotNull YouTuListener youTuListener) {
        }

        public static void playOrPause(@NotNull YouTuListener youTuListener, boolean z) {
        }

        public static void playPosition(@NotNull YouTuListener youTuListener, float f) {
        }
    }

    void onClickAddVideo();

    void onClickVideoList();

    void playOrPause(boolean isPlay);

    void playPosition(float time);
}
