package com.qiahao.nextvideo.ui.profile.report;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.utils.DateUtils;
import com.oudi.adapter.BaseMultiItemAdapter;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.SelectImageData;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/report/SuperReportAdapter;", "Lcom/oudi/adapter/BaseMultiItemAdapter;", "Lcom/qiahao/nextvideo/data/model/SelectImageData;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SuperReportAdapter extends BaseMultiItemAdapter<SelectImageData, BaseViewHolder> {
    public SuperReportAdapter() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        addItemType(1, R.layout.item_select_image);
        addItemType(2, R.layout.item_add_image);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseViewHolder holder, @NotNull SelectImageData item) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemType() != 1) {
            return;
        }
        QMUIRadiusImageView view = holder.getView(2131363201);
        TextView textView = (TextView) holder.getView(R.id.duration);
        LocalMedia media = item.getMedia();
        if (media == null) {
            str = "";
        } else if (media.isCut() && !media.isCompressed()) {
            str = media.getCutPath();
        } else if (!media.isCompressed() && (!media.isCut() || !media.isCompressed())) {
            if (!TextUtils.isEmpty(media.getRealPath())) {
                str = media.getRealPath();
            } else {
                str = media.getPath();
            }
        } else {
            str = media.getCompressPath();
        }
        if (str.length() > 0 && PictureMimeType.isContent(str)) {
            if (new File(str).exists()) {
                ImageKtxKt.loadImage$default(view, (String) null, Uri.parse(str), (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131101214, (Integer) null, (c5.g) null, 57341, (Object) null);
            }
        } else if (str.length() > 0) {
            File file = new File(str);
            if (file.exists()) {
                ImageKtxKt.loadImage$default(view, (String) null, (Uri) null, file, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131101214, (Integer) null, (c5.g) null, 57339, (Object) null);
            }
        }
        LocalMedia media2 = item.getMedia();
        if (media2 == null || (str2 = media2.getMimeType()) == null) {
            str2 = "";
        }
        if (StringsKt.contains$default(str2, "image", false, 2, (Object) null)) {
            textView.setVisibility(8);
            return;
        }
        LocalMedia media3 = item.getMedia();
        if (media3 == null || (str3 = media3.getMimeType()) == null) {
            str3 = "";
        }
        if (StringsKt.contains$default(str3, "video", false, 2, (Object) null)) {
            textView.setVisibility(0);
            LocalMedia media4 = item.getMedia();
            textView.setText(DateUtils.formatDurationTime(media4 != null ? media4.getDuration() : 0L));
        }
    }
}
