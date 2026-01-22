package com.qiahao.nextvideo.room.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemMyMusicBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.music.MusicLoader;
import com.qiahao.nextvideo.room.music.MusicStatus;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/MyMusicAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/room/music/MusicLoader$MusicInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemMyMusicBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyMusicAdapter extends BaseQuickAdapter<MusicLoader.MusicInfo, BaseDataBindingHolder<ItemMyMusicBinding>> {
    public MyMusicAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemMyMusicBinding> holder, @Nullable MusicLoader.MusicInfo item) {
        String str;
        String a;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemMyMusicBinding");
        ItemMyMusicBinding itemMyMusicBinding = (ItemMyMusicBinding) dataBinding;
        TextView textView = itemMyMusicBinding.musicName;
        String str2 = "";
        if (item == null || (str = item.d()) == null) {
            str = "";
        }
        textView.setText(str);
        TextView textView2 = itemMyMusicBinding.musicAuthor;
        if (item != null && (a = item.a()) != null) {
            str2 = a;
        }
        textView2.setText(str2);
        if (MusicLoader.m() == null) {
            ImageView imageView = itemMyMusicBinding.playPauseMusic;
            Intrinsics.checkNotNullExpressionValue(imageView, "playPauseMusic");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_white_pause), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        } else {
            if (item != null && item.c() == MusicLoader.m().c()) {
                if (MeetingRoomManager.INSTANCE.getMusicManager().i() == MusicStatus.PLAY) {
                    ImageView imageView2 = itemMyMusicBinding.playPauseMusic;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "playPauseMusic");
                    ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_play), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                    return;
                } else {
                    ImageView imageView3 = itemMyMusicBinding.playPauseMusic;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "playPauseMusic");
                    ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_white_pause), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                    return;
                }
            }
            ImageView imageView4 = itemMyMusicBinding.playPauseMusic;
            Intrinsics.checkNotNullExpressionValue(imageView4, "playPauseMusic");
            ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_white_pause), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        }
    }
}
