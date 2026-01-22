package com.qiahao.nextvideo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.g;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.planets.HiloPlanetsData;
import com.qiahao.nextvideo.databinding.ViewPlanetBinding;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.view.planet.PlanetAdapter;
import com.qiahao.nextvideo.view.planet.PlanetPortraitView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\u0016\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010 R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/view/HiloPlanetsAdapter;", "Lcom/qiahao/nextvideo/view/planet/PlanetAdapter;", "<init>", "()V", "mList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/planets/HiloPlanetsData;", "Lkotlin/collections/ArrayList;", "getMList", "()Ljava/util/ArrayList;", "setMList", "(Ljava/util/ArrayList;)V", "getView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "parent", "Landroid/view/ViewGroup;", "getCount", "getGetCount", "()I", "getItem", "", "getPopularity", "onThemeColorChanged", "", "view", "themeColor", "refreshData", "data", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHiloPlanetsAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HiloPlanetsAdapter.kt\ncom/qiahao/nextvideo/view/HiloPlanetsAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,80:1\n1#2:81\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloPlanetsAdapter extends PlanetAdapter {

    @NotNull
    private ArrayList<HiloPlanetsData> mList = new ArrayList<>();

    @Override // com.qiahao.nextvideo.view.planet.PlanetAdapter
    public int getGetCount() {
        return this.mList.size();
    }

    @Override // com.qiahao.nextvideo.view.planet.PlanetAdapter
    @NotNull
    public Object getItem(int position) {
        return 0;
    }

    @NotNull
    public final ArrayList<HiloPlanetsData> getMList() {
        return this.mList;
    }

    @Override // com.qiahao.nextvideo.view.planet.PlanetAdapter
    public int getPopularity(int position) {
        return position % 10;
    }

    @Override // com.qiahao.nextvideo.view.planet.PlanetAdapter
    @NotNull
    public View getView(@Nullable Context context, int position, @Nullable ViewGroup parent) {
        String str;
        int i;
        String nick;
        if (this.mList.size() <= position) {
            return new View(context);
        }
        HiloPlanetsData hiloPlanetsData = this.mList.get(position);
        Intrinsics.checkNotNullExpressionValue(hiloPlanetsData, "get(...)");
        HiloPlanetsData hiloPlanetsData2 = hiloPlanetsData;
        String str2 = null;
        ViewPlanetBinding viewPlanetBinding = (ViewPlanetBinding) g.h(LayoutInflater.from(context), R.layout.view_planet, (ViewGroup) null, false);
        QMUIRadiusImageView qMUIRadiusImageView = viewPlanetBinding.image;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "image");
        User user = hiloPlanetsData2.getUser();
        if (user != null) {
            str = user.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, Integer.valueOf(UiKtxKt.toPX(50)), Integer.valueOf(UiKtxKt.toPX(50)), (Boolean) null, 2131232429, 2131232429, (c5.g) null, 37886, (Object) null);
        TextView textView = viewPlanetBinding.nickName;
        User user2 = hiloPlanetsData2.getUser();
        if (user2 != null && (nick = user2.getNick()) != null) {
            str2 = DataExternalKt.maxLengthSuffix(nick, 8, "...");
        }
        textView.setText(str2);
        int i2 = 2131099987;
        if (TextUtils.isEmpty(hiloPlanetsData2.getCurrentRoom())) {
            viewPlanetBinding.speakWave.dismiss();
        } else {
            PlanetPortraitView planetPortraitView = viewPlanetBinding.speakWave;
            User user3 = hiloPlanetsData2.getUser();
            if (user3 != null && user3.getSex() == 1) {
                i = 2131099894;
            } else {
                i = 2131099987;
            }
            planetPortraitView.setColor(i);
            viewPlanetBinding.speakWave.show();
        }
        if (context != null) {
            User user4 = hiloPlanetsData2.getUser();
            if (user4 != null && user4.getSex() == 1) {
                i2 = 2131099894;
            }
            viewPlanetBinding.image.setBorderColor(androidx.core.content.a.getColor(context, i2));
        }
        View root = viewPlanetBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.qiahao.nextvideo.view.planet.PlanetAdapter
    public void onThemeColorChanged(@Nullable View view, int themeColor) {
    }

    public final void refreshData(@Nullable List<HiloPlanetsData> data) {
        if (data != null) {
            try {
                this.mList.clear();
                this.mList.addAll(data);
                notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void setMList(@NotNull ArrayList<HiloPlanetsData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mList = arrayList;
    }
}
