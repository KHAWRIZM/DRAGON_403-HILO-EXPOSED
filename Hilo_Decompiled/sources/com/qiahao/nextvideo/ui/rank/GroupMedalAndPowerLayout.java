package com.qiahao.nextvideo.ui.rank;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupMedalDetailBean;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ8\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\nJ\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/GroupMedalAndPowerLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mGroupMedalBeanList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/GroupMedalDetailBean;", "Lkotlin/collections/ArrayList;", "getMGroupMedalBeanList", "()Ljava/util/ArrayList;", "mContext", "setDataAndLayoutView", "", "powerName", "", "groupMedalBeanList", "maxSize", "initOnlineView", "createPowerView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupMedalAndPowerLayout extends LinearLayout {

    @NotNull
    private Context mContext;

    @NotNull
    private final ArrayList<GroupMedalDetailBean> mGroupMedalBeanList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupMedalAndPowerLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initOnlineView() {
        if (this.mGroupMedalBeanList.size() > 0) {
            setVisibility(0);
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setOrientation(0);
            int size = this.mGroupMedalBeanList.size();
            for (int i = 0; i < size; i++) {
                ImageView imageView = new ImageView(this.mContext);
                Dimens dimens = Dimens.INSTANCE;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens.dpToPx(19), dimens.dpToPx(17));
                layoutParams.setMarginEnd(dimens.dpToPx(4));
                imageView.setLayoutParams(layoutParams);
                ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(this.mGroupMedalBeanList.get(i).getPicUrl(), UiKtxKt.toPX(30), UiKtxKt.toPX(25)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                linearLayout.addView(imageView);
            }
            addView(linearLayout);
        }
    }

    public static /* synthetic */ void setDataAndLayoutView$default(GroupMedalAndPowerLayout groupMedalAndPowerLayout, String str, ArrayList arrayList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            i = 6;
        }
        groupMedalAndPowerLayout.setDataAndLayoutView(str, arrayList, i);
    }

    public final void createPowerView(@NotNull String powerName) {
        Intrinsics.checkNotNullParameter(powerName, "powerName");
        setVisibility(0);
        TextView textView = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.view_power_layout, (ViewGroup) this, true).findViewById(R.id.tv_power_name);
        if (powerName.length() > 6) {
            String substring = powerName.substring(0, 6);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            textView.setText(substring);
            return;
        }
        textView.setText(powerName);
    }

    @NotNull
    public final ArrayList<GroupMedalDetailBean> getMGroupMedalBeanList() {
        return this.mGroupMedalBeanList;
    }

    public final void setDataAndLayoutView(@Nullable String powerName, @Nullable ArrayList<GroupMedalDetailBean> groupMedalBeanList, int maxSize) {
        removeAllViews();
        if ((groupMedalBeanList == null || groupMedalBeanList.isEmpty()) && TextUtils.isEmpty(powerName)) {
            setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(powerName)) {
            Intrinsics.checkNotNull(powerName);
            createPowerView(powerName);
        }
        this.mGroupMedalBeanList.clear();
        if (groupMedalBeanList != null && !groupMedalBeanList.isEmpty()) {
            if (groupMedalBeanList.size() > maxSize - 1) {
                this.mGroupMedalBeanList.addAll(groupMedalBeanList.subList(0, maxSize));
            } else {
                this.mGroupMedalBeanList.addAll(groupMedalBeanList);
            }
            initOnlineView();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupMedalAndPowerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupMedalAndPowerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mGroupMedalBeanList = new ArrayList<>();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mContext = context2;
        setGravity(16);
    }
}
