package com.qiahao.nextvideo.ui.home.tab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.a;
import androidx.databinding.g;
import com.oudi.utils.ColorUtils;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.tab.MainTabData;
import com.qiahao.nextvideo.databinding.BaseLayoutCustomTabItemBinding;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/tab/MainTabView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/data/tab/MainTabData;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/tab/MainTabData;)V", "binding", "Lcom/qiahao/nextvideo/databinding/BaseLayoutCustomTabItemBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/BaseLayoutCustomTabItemBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/BaseLayoutCustomTabItemBinding;)V", "mSelectPosition", "", "getMSelectPosition", "()I", "setMSelectPosition", "(I)V", "initView", "", "setSelected", ImageSelectActivity.SELECTED, "", "setRedPoints", "count", "", "setRedPoint", "cancelRedPoint", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MainTabView extends FrameLayout {

    @Nullable
    private BaseLayoutCustomTabItemBinding binding;

    @Nullable
    private MainTabData data;
    private int mSelectPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainTabView(@NotNull Context context, @NotNull MainTabData mainTabData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainTabData, "data");
        this.data = mainTabData;
        initView();
    }

    private final void cancelRedPoint() {
        TextView textView;
        TextView textView2;
        BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding = this.binding;
        if (baseLayoutCustomTabItemBinding != null && (textView2 = baseLayoutCustomTabItemBinding.redNumber) != null) {
            textView2.setText("");
        }
        BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding2 = this.binding;
        if (baseLayoutCustomTabItemBinding2 != null && (textView = baseLayoutCustomTabItemBinding2.redNumber) != null) {
            textView.setVisibility(8);
        }
    }

    private final void initView() {
        this.binding = (BaseLayoutCustomTabItemBinding) g.h(LayoutInflater.from(getContext()), R.layout.base_layout_custom_tab_item, this, true);
    }

    private final MainTabView setRedPoint(String count) {
        TextView textView;
        TextView textView2;
        BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding = this.binding;
        if (baseLayoutCustomTabItemBinding != null && (textView2 = baseLayoutCustomTabItemBinding.redNumber) != null) {
            textView2.setVisibility(0);
        }
        BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding2 = this.binding;
        if (baseLayoutCustomTabItemBinding2 != null && (textView = baseLayoutCustomTabItemBinding2.redNumber) != null) {
            textView.setText(count);
        }
        return this;
    }

    @Nullable
    public final BaseLayoutCustomTabItemBinding getBinding() {
        return this.binding;
    }

    public final int getMSelectPosition() {
        return this.mSelectPosition;
    }

    public final void setBinding(@Nullable BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding) {
        this.binding = baseLayoutCustomTabItemBinding;
    }

    public final void setMSelectPosition(int i) {
        this.mSelectPosition = i;
    }

    public final void setRedPoints(@Nullable String count) {
        MainTabView mainTabView;
        if (count != null) {
            if (count.length() > 0) {
                mainTabView = setRedPoint(count);
            } else {
                cancelRedPoint();
                mainTabView = Unit.INSTANCE;
            }
            if (mainTabView != null) {
                return;
            }
        }
        cancelRedPoint();
        Unit unit = Unit.INSTANCE;
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        String str;
        ImageView imageView;
        Integer defaultDrawableId;
        TextView textView;
        ImageView imageView2;
        Integer specialDrawableId;
        TextView textView2;
        String defaultColor;
        TextView textView3;
        ImageView imageView3;
        ImageView imageView4;
        String str2;
        TextView textView4;
        ImageView imageView5;
        Integer selectDrawableId;
        TextView textView5;
        String selectColor;
        TextView textView6;
        ImageView imageView6;
        ImageView imageView7;
        TextView textView7;
        String str3;
        TextView textView8;
        ImageView imageView8;
        super.setSelected(selected);
        BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding = this.binding;
        Drawable drawable = null;
        if (baseLayoutCustomTabItemBinding != null && (imageView8 = baseLayoutCustomTabItemBinding.ivIcon) != null) {
            layoutParams = imageView8.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding2 = this.binding;
        if (baseLayoutCustomTabItemBinding2 != null && (textView8 = baseLayoutCustomTabItemBinding2.redNumber) != null) {
            layoutParams2 = textView8.getLayoutParams();
        } else {
            layoutParams2 = null;
        }
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding3 = this.binding;
        String str4 = "";
        if (baseLayoutCustomTabItemBinding3 != null && (textView7 = baseLayoutCustomTabItemBinding3.title) != null) {
            MainTabData mainTabData = this.data;
            if (mainTabData == null || (str3 = mainTabData.getTitle()) == null) {
                str3 = "";
            }
            textView7.setText(str3);
        }
        if (selected) {
            ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.toPX(44);
            ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.toPX(44);
            BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding4 = this.binding;
            if (baseLayoutCustomTabItemBinding4 != null && (imageView7 = baseLayoutCustomTabItemBinding4.ivIcon) != null) {
                imageView7.setLayoutParams(bVar);
            }
            MainTabData mainTabData2 = this.data;
            if (mainTabData2 == null || (str2 = mainTabData2.getSelectPath()) == null) {
                str2 = "";
            }
            File file = new File(str2);
            if (file.exists()) {
                BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding5 = this.binding;
                if (baseLayoutCustomTabItemBinding5 != null && (imageView6 = baseLayoutCustomTabItemBinding5.ivIcon) != null) {
                    ImageKtxKt.loadImage$default(imageView6, (String) null, (Uri) null, file, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65531, (Object) null);
                }
                bVar2.setMarginEnd(Dimens.INSTANCE.dpToPx(-2));
                BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding6 = this.binding;
                if (baseLayoutCustomTabItemBinding6 != null && (textView6 = baseLayoutCustomTabItemBinding6.redNumber) != null) {
                    textView6.setLayoutParams(bVar2);
                }
            } else {
                BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding7 = this.binding;
                if (baseLayoutCustomTabItemBinding7 != null && (imageView5 = baseLayoutCustomTabItemBinding7.ivIcon) != null) {
                    MainTabData mainTabData3 = this.data;
                    if (mainTabData3 != null && (selectDrawableId = mainTabData3.getSelectDrawableId()) != null) {
                        drawable = a.getDrawable(getContext(), selectDrawableId.intValue());
                    }
                    imageView5.setImageDrawable(drawable);
                }
                bVar2.setMarginEnd(Dimens.INSTANCE.dpToPx(-2));
                BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding8 = this.binding;
                if (baseLayoutCustomTabItemBinding8 != null && (textView4 = baseLayoutCustomTabItemBinding8.redNumber) != null) {
                    textView4.setLayoutParams(bVar2);
                }
            }
            BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding9 = this.binding;
            if (baseLayoutCustomTabItemBinding9 != null && (textView5 = baseLayoutCustomTabItemBinding9.title) != null) {
                MainTabData mainTabData4 = this.data;
                if (mainTabData4 != null && (selectColor = mainTabData4.getSelectColor()) != null) {
                    str4 = selectColor;
                }
                textView5.setTextColor(ColorUtils.string2Int(str4));
                return;
            }
            return;
        }
        ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.toPX(32);
        ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.toPX(32);
        BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding10 = this.binding;
        if (baseLayoutCustomTabItemBinding10 != null && (imageView4 = baseLayoutCustomTabItemBinding10.ivIcon) != null) {
            imageView4.setLayoutParams(bVar);
        }
        MainTabData mainTabData5 = this.data;
        if (mainTabData5 == null || (str = mainTabData5.getSelectPath()) == null) {
            str = "";
        }
        File file2 = new File(str);
        if (file2.exists()) {
            BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding11 = this.binding;
            if (baseLayoutCustomTabItemBinding11 != null && (imageView3 = baseLayoutCustomTabItemBinding11.ivIcon) != null) {
                ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, file2, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65531, (Object) null);
            }
            bVar2.setMarginEnd(Dimens.INSTANCE.dpToPx(-5));
            BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding12 = this.binding;
            if (baseLayoutCustomTabItemBinding12 != null && (textView3 = baseLayoutCustomTabItemBinding12.redNumber) != null) {
                textView3.setLayoutParams(bVar2);
            }
        } else {
            if (this.mSelectPosition == 0) {
                BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding13 = this.binding;
                if (baseLayoutCustomTabItemBinding13 != null && (imageView2 = baseLayoutCustomTabItemBinding13.ivIcon) != null) {
                    MainTabData mainTabData6 = this.data;
                    if (mainTabData6 != null && (specialDrawableId = mainTabData6.getSpecialDrawableId()) != null) {
                        drawable = a.getDrawable(getContext(), specialDrawableId.intValue());
                    }
                    imageView2.setImageDrawable(drawable);
                }
            } else {
                BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding14 = this.binding;
                if (baseLayoutCustomTabItemBinding14 != null && (imageView = baseLayoutCustomTabItemBinding14.ivIcon) != null) {
                    MainTabData mainTabData7 = this.data;
                    if (mainTabData7 != null && (defaultDrawableId = mainTabData7.getDefaultDrawableId()) != null) {
                        drawable = a.getDrawable(getContext(), defaultDrawableId.intValue());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
            bVar2.setMarginEnd(Dimens.INSTANCE.dpToPx(-5));
            BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding15 = this.binding;
            if (baseLayoutCustomTabItemBinding15 != null && (textView = baseLayoutCustomTabItemBinding15.redNumber) != null) {
                textView.setLayoutParams(bVar2);
            }
        }
        BaseLayoutCustomTabItemBinding baseLayoutCustomTabItemBinding16 = this.binding;
        if (baseLayoutCustomTabItemBinding16 != null && (textView2 = baseLayoutCustomTabItemBinding16.title) != null) {
            MainTabData mainTabData8 = this.data;
            if (mainTabData8 != null && (defaultColor = mainTabData8.getDefaultColor()) != null) {
                str4 = defaultColor;
            }
            textView2.setTextColor(ColorUtils.string2Int(str4));
        }
    }
}
