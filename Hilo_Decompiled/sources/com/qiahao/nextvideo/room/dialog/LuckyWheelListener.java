package com.qiahao.nextvideo.room.dialog;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/LuckyWheelListener;", "", "smallLuckyWheelView", "", "playLuckyWheelView", "closeLuckyWheelView", "joinLuckyWheelGame", "winSvgaStartPlay", "luckyWheelGameWinSvgaFinish", "hasNextTime", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface LuckyWheelListener {
    void closeLuckyWheelView();

    void joinLuckyWheelGame();

    void luckyWheelGameWinSvgaFinish(boolean hasNextTime);

    void playLuckyWheelView();

    void smallLuckyWheelView();

    void winSvgaStartPlay();
}
