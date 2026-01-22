package com.qiahao.nextvideo.ui.userdetail;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import c5.g;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.userdetail.UserDetailPictureAdapter;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.therouter.inject.DebugOnlyKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u000bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureViewHolder;", "userDetailPictureAdapterListener", "Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureAdapterListener;", "<init>", "(Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureAdapterListener;)V", "getUserDetailPictureAdapterListener", "()Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureAdapterListener;", "setUserDetailPictureAdapterListener", "sex", "", "getSex", "()I", "setSex", "(I)V", "arrayList", "", "", "getArrayList", "()Ljava/util/List;", "setData", "", DebugOnlyKt.PACKAGE, "Ljava/util/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserDetailPictureAdapter extends RecyclerView.Adapter<UserDetailPictureViewHolder> {

    @NotNull
    private final List<String> arrayList;
    private int sex;

    @NotNull
    private UserDetailPictureAdapterListener userDetailPictureAdapterListener;

    public UserDetailPictureAdapter(@NotNull UserDetailPictureAdapterListener userDetailPictureAdapterListener) {
        Intrinsics.checkNotNullParameter(userDetailPictureAdapterListener, "userDetailPictureAdapterListener");
        this.userDetailPictureAdapterListener = userDetailPictureAdapterListener;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 9; i++) {
            arrayList.add("");
        }
        this.arrayList = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(int i, UserDetailPictureAdapter userDetailPictureAdapter, View view) {
        if (i == 0) {
            userDetailPictureAdapter.userDetailPictureAdapterListener.editUserHead();
        } else {
            userDetailPictureAdapter.userDetailPictureAdapterListener.deleteUserDetailPhoto(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5(UserDetailPictureAdapter userDetailPictureAdapter, int i, View view) {
        userDetailPictureAdapter.userDetailPictureAdapterListener.addUserDetailPhoto(i);
    }

    @NotNull
    public final List<String> getArrayList() {
        return this.arrayList;
    }

    public int getItemCount() {
        return 9;
    }

    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final UserDetailPictureAdapterListener getUserDetailPictureAdapterListener() {
        return this.userDetailPictureAdapterListener;
    }

    public final void setData(@NotNull ArrayList<String> a) {
        Intrinsics.checkNotNullParameter(a, DebugOnlyKt.PACKAGE);
        int size = this.arrayList.size();
        for (int i = 0; i < size; i++) {
            this.arrayList.set(i, "");
        }
        int size2 = a.size();
        for (int i2 = 0; i2 < size2; i2++) {
            List<String> list = this.arrayList;
            String str = a.get(i2);
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            list.set(i2, str);
        }
        notifyDataSetChanged();
    }

    public final void setSex(int i) {
        this.sex = i;
    }

    public final void setUserDetailPictureAdapterListener(@NotNull UserDetailPictureAdapterListener userDetailPictureAdapterListener) {
        Intrinsics.checkNotNullParameter(userDetailPictureAdapterListener, "<set-?>");
        this.userDetailPictureAdapterListener = userDetailPictureAdapterListener;
    }

    public void onBindViewHolder(@NotNull UserDetailPictureViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Dimens dimens = Dimens.INSTANCE;
        int screenWidth = (dimens.getScreenWidth() - dimens.dpToPx(36)) / 3;
        ConstraintLayout bodyView = holder.getBodyView();
        ViewGroup.LayoutParams layoutParams = holder.getBodyView().getLayoutParams();
        int i = (int) (screenWidth * 1.5d);
        layoutParams.height = dimens.dpToPx(5) + i;
        layoutParams.width = screenWidth;
        bodyView.setLayoutParams(layoutParams);
        AppCompatImageView imgPic = holder.getImgPic();
        ViewGroup.LayoutParams layoutParams2 = holder.getImgPic().getLayoutParams();
        layoutParams2.height = i - dimens.dpToPx(5);
        layoutParams2.width = screenWidth - dimens.dpToPx(5);
        imgPic.setLayoutParams(layoutParams2);
        if (!TextUtils.isEmpty(this.arrayList.get(position))) {
            holder.getImgEditOrDelete().setVisibility(0);
            if (position == 0) {
                ImageKtxKt.loadImage$default(holder.getImgEditOrDelete(), (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_picture_editor), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
            } else {
                ImageKtxKt.loadImage$default(holder.getImgEditOrDelete(), (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_picture_delete), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
            }
            holder.getImgEmpty().setVisibility(8);
            ViewUtilitiesKt.bind$default(holder.getImgPic(), ImageUIModel.Companion.UserDetailPicUIModel$default(ImageUIModel.INSTANCE, this.arrayList.get(position), false, 0, 0, 0, null, 62, null), null, 2, null);
        } else if (position == 0) {
            ViewUtilitiesKt.bind$default(holder.getImgPic(), ImageUIModel.Companion.UserDetailPicUIModel$default(ImageUIModel.INSTANCE, "", true, this.sex, 0, 0, null, 56, null), null, 2, null);
            holder.getImgEmpty().setVisibility(8);
            holder.getImgEditOrDelete().setVisibility(0);
        } else {
            ImageKtxKt.loadImage$default(holder.getImgPic(), (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.shape_user_detail_picture_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
            holder.getImgEmpty().setVisibility(0);
            holder.getImgEditOrDelete().setVisibility(8);
        }
        holder.getImgEditOrDelete().setOnClickListener(new View.OnClickListener() { // from class: ub.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserDetailPictureAdapter.onBindViewHolder$lambda$4(position, this, view);
            }
        });
        holder.getImgEmpty().setOnClickListener(new View.OnClickListener() { // from class: ub.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserDetailPictureAdapter.onBindViewHolder$lambda$5(UserDetailPictureAdapter.this, position, view);
            }
        });
    }

    @NotNull
    public UserDetailPictureViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_detail_picture, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new UserDetailPictureViewHolder(inflate);
    }
}
