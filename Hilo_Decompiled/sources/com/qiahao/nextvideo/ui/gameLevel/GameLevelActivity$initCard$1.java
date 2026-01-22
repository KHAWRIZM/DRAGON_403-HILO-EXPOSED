package com.qiahao.nextvideo.ui.gameLevel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.data.model.gameLevel.GameLevelCard;
import com.qiahao.nextvideo.data.model.gameLevel.GameLevelData;
import com.qiahao.nextvideo.data.model.gameLevel.GameLevelPrivilege;
import com.qiahao.nextvideo.databinding.ActivityGameLevelBinding;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/qiahao/nextvideo/ui/gameLevel/GameLevelActivity$initCard$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameLevelActivity$initCard$1 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ GameLevelActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameLevelActivity$initCard$1(GameLevelActivity gameLevelActivity) {
        this.this$0 = gameLevelActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageSelected$lambda$0(GameLevelActivity gameLevelActivity) {
        GameLevelPrivilegesAdapter mPrivilegesAdapter;
        GameLevelViewModel viewModel;
        ArrayList<GameLevelPrivilege> arrayList;
        ArrayList<GameLevelCard> cards;
        int i;
        mPrivilegesAdapter = gameLevelActivity.getMPrivilegesAdapter();
        viewModel = gameLevelActivity.getViewModel();
        GameLevelData gameLevelData = (GameLevelData) viewModel.getGameLevel().getValue();
        if (gameLevelData != null && (cards = gameLevelData.getCards()) != null) {
            i = gameLevelActivity.mSelectPosition;
            GameLevelCard gameLevelCard = cards.get(i);
            if (gameLevelCard != null) {
                arrayList = gameLevelCard.getPrivileges();
                mPrivilegesAdapter.setList(arrayList);
            }
        }
        arrayList = null;
        mPrivilegesAdapter.setList(arrayList);
    }

    public void onPageSelected(int position) {
        ActivityGameLevelBinding binding;
        ActivityGameLevelBinding binding2;
        GameLevelViewModel viewModel;
        String str;
        ArrayList<GameLevelCard> cards;
        int i;
        super.onPageSelected(position);
        this.this$0.mSelectPosition = position;
        binding = this.this$0.getBinding();
        RecyclerView recyclerView = binding.recyclerView;
        final GameLevelActivity gameLevelActivity = this.this$0;
        recyclerView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.gameLevel.i
            @Override // java.lang.Runnable
            public final void run() {
                GameLevelActivity$initCard$1.onPageSelected$lambda$0(GameLevelActivity.this);
            }
        });
        binding2 = this.this$0.getBinding();
        ImageView imageView = binding2.topBg;
        Intrinsics.checkNotNullExpressionValue(imageView, "topBg");
        viewModel = this.this$0.getViewModel();
        GameLevelData gameLevelData = (GameLevelData) viewModel.getGameLevel().getValue();
        if (gameLevelData != null && (cards = gameLevelData.getCards()) != null) {
            i = this.this$0.mSelectPosition;
            GameLevelCard gameLevelCard = cards.get(i);
            if (gameLevelCard != null) {
                str = gameLevelCard.getBgUrl();
                ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
        }
        str = null;
        ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
    }
}
