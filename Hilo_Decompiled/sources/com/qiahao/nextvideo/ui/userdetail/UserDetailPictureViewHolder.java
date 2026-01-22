package com.qiahao.nextvideo.ui.userdetail;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imgPic", "Lcom/qiahao/nextvideo/ui/reusable/views/CorneredImageView;", "getImgPic", "()Lcom/qiahao/nextvideo/ui/reusable/views/CorneredImageView;", "imgEmpty", "Landroidx/appcompat/widget/AppCompatImageView;", "getImgEmpty", "()Landroidx/appcompat/widget/AppCompatImageView;", "imgEditOrDelete", "getImgEditOrDelete", "bodyView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getBodyView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserDetailPictureViewHolder extends RecyclerView.ViewHolder {

    @NotNull
    private final ConstraintLayout bodyView;

    @NotNull
    private final AppCompatImageView imgEditOrDelete;

    @NotNull
    private final AppCompatImageView imgEmpty;

    @NotNull
    private final CorneredImageView imgPic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDetailPictureViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.imgPic = (CorneredImageView) view.findViewById(R.id.img_pic);
        this.imgEmpty = view.findViewById(R.id.img_empty);
        this.imgEditOrDelete = view.findViewById(R.id.img_pic_edit_or_delete);
        this.bodyView = view.findViewById(R.id.body_view);
    }

    @NotNull
    public final ConstraintLayout getBodyView() {
        return this.bodyView;
    }

    @NotNull
    public final AppCompatImageView getImgEditOrDelete() {
        return this.imgEditOrDelete;
    }

    @NotNull
    public final AppCompatImageView getImgEmpty() {
        return this.imgEmpty;
    }

    @NotNull
    public final CorneredImageView getImgPic() {
        return this.imgPic;
    }
}
