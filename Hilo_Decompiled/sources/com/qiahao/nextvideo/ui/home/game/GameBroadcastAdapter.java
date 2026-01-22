package com.qiahao.nextvideo.ui.home.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.game.GameBroadcast;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/game/GameBroadcastAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/game/GameBroadcast;", "<init>", "()V", "Lcom/zhpan/bannerview/f;", "holder", "data", "", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/game/GameBroadcast;II)V", "viewType", "getLayoutId", "(I)I", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameBroadcastAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameBroadcastAdapter.kt\ncom/qiahao/nextvideo/ui/home/game/GameBroadcastAdapter\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,52:1\n61#2,9:53\n*S KotlinDebug\n*F\n+ 1 GameBroadcastAdapter.kt\ncom/qiahao/nextvideo/ui/home/game/GameBroadcastAdapter\n*L\n34#1:53,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameBroadcastAdapter extends com.zhpan.bannerview.e {
    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_game_broadcast;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@Nullable com.zhpan.bannerview.f holder, @Nullable final GameBroadcast data, int position, int pageSize) {
        String str;
        User user;
        String str2 = null;
        ImageView a = holder != null ? holder.a(2131363201) : null;
        TextView textView = holder != null ? (TextView) holder.a(2131365189) : null;
        final ConstraintLayout a2 = holder != null ? holder.a(R.id.roomLayout) : null;
        if (a != null) {
            if (data != null && (user = data.getUser()) != null) {
                str2 = user.getAvatar();
            }
            String image100 = ImageSizeKt.image100(str2);
            ImageKtxKt.loadImage$default(a, image100 == null ? "" : image100, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        if (textView != null) {
            if (data == null || (str = data.getText()) == null) {
                str = "";
            }
            textView.setText(str);
        }
        if (a2 != null) {
            final long j = 800;
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.game.GameBroadcastAdapter$bindData$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i;
                    int i2;
                    int i3;
                    Integer gameType;
                    Integer gameMode;
                    Integer gameId;
                    Integer gameType2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(a2) > j || (a2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(a2, currentTimeMillis);
                        ConstraintLayout constraintLayout = a2;
                        GameBroadcast gameBroadcast = data;
                        if (gameBroadcast != null && (gameType2 = gameBroadcast.getGameType()) != null && gameType2.intValue() == 0) {
                            DefaultWebActivity.Companion companion = DefaultWebActivity.Companion;
                            Context context = constraintLayout.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                            String h5Url = data.getH5Url();
                            if (h5Url == null) {
                                h5Url = "";
                            }
                            DefaultWebActivity.Companion.start$default(companion, context, h5Url, null, 4, null);
                            return;
                        }
                        GameJum gameJum = GameJum.INSTANCE;
                        GameBroadcast gameBroadcast2 = data;
                        if (gameBroadcast2 != null && (gameId = gameBroadcast2.getGameId()) != null) {
                            i = gameId.intValue();
                        } else {
                            i = 0;
                        }
                        GameBroadcast gameBroadcast3 = data;
                        if (gameBroadcast3 != null && (gameMode = gameBroadcast3.getGameMode()) != null) {
                            i2 = gameMode.intValue();
                        } else {
                            i2 = 0;
                        }
                        GameBroadcast gameBroadcast4 = data;
                        if (gameBroadcast4 != null && (gameType = gameBroadcast4.getGameType()) != null) {
                            i3 = gameType.intValue();
                        } else {
                            i3 = 0;
                        }
                        GameJum.matchGame$default(gameJum, 0, i, i2, i3, null, 17, null);
                    }
                }
            });
        }
        if (textView != null) {
            textView.setTextColor(Color.parseColor("#333333"));
        }
    }
}
