package com.qiahao.nextvideo.room.adapter;

import com.qiahao.nextvideo.data.model.MicroBean;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/OnMicroItemClickListener;", "", "onAvatarBtnClick", "", "position", "", "micBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "onMicroClick", "onUnLockMic", "onUnMuteAvatarClick", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface OnMicroItemClickListener {
    void onAvatarBtnClick(int position, @Nullable MicroBean micBean);

    void onMicroClick(int position, @Nullable MicroBean micBean);

    void onUnLockMic(int position, @Nullable MicroBean micBean);

    void onUnMuteAvatarClick(int position, @Nullable MicroBean micBean);
}
