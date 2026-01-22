package com.qiahao.nextvideo.ui.privilegesynopsis;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewpager.widget.a;
import c5.g;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001bj\b\u0012\u0004\u0012\u00020\b`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001bj\b\u0012\u0004\u0012\u00020\b`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001bj\b\u0012\u0004\u0012\u00020\b`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001eR&\u0010%\u001a\u0012\u0012\u0004\u0012\u00020!0\u001bj\b\u0012\u0004\u0012\u00020!`\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001e¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/privilegesynopsis/CardsPagerAdapter;", "Landroidx/viewpager/widget/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/ViewGroup;", "container", "", "position", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "object", "", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Landroid/view/View;", "view", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "getCount", "()I", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "drawableResIds", "Ljava/util/ArrayList;", "titleResIds", "", "", "subtitleResIdArgs", "[[Ljava/lang/String;", "subtitleResIds", "subtitleTexts", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCardsPagerAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CardsPagerAdapter.kt\ncom/qiahao/nextvideo/ui/privilegesynopsis/CardsPagerAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,159:1\n1573#2:160\n1604#2,4:161\n*S KotlinDebug\n*F\n+ 1 CardsPagerAdapter.kt\ncom/qiahao/nextvideo/ui/privilegesynopsis/CardsPagerAdapter\n*L\n64#1:160\n64#1:161,4\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CardsPagerAdapter extends a {

    @NotNull
    private final Context context;

    @NotNull
    private final ArrayList<Integer> drawableResIds;

    @NotNull
    private final String[][] subtitleResIdArgs;

    @NotNull
    private final ArrayList<Integer> subtitleResIds;

    @NotNull
    private ArrayList<String> subtitleTexts;

    @NotNull
    private final ArrayList<Integer> titleResIds;

    public CardsPagerAdapter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        int i = 0;
        this.drawableResIds = CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(R.drawable.bg_privilege_synopsis1), Integer.valueOf(R.drawable.bg_privilege_synopsis2), Integer.valueOf(R.drawable.bg_privilege_synopsis3), Integer.valueOf(R.drawable.bg_privilege_synopsis4), Integer.valueOf(R.drawable.bg_privilege_synopsis5), Integer.valueOf(R.drawable.bg_privilege_synopsis8), Integer.valueOf(R.drawable.bg_privilege_synopsis6), Integer.valueOf(R.drawable.bg_privilege_synopsis7)});
        this.titleResIds = CollectionsKt.arrayListOf(new Integer[]{2131954116, 2131952565, 2131953230, 2131952250, 2131954216, 2131953403, 2131952195, 2131953052});
        this.subtitleResIdArgs = new String[][]{new String[0], new String[]{"9000", MessageService.MSG_DB_COMPLETE}, new String[0], new String[0], new String[]{"5"}, new String[]{"5"}, new String[]{"5"}, new String[0]};
        ArrayList<Integer> arrayListOf = CollectionsKt.arrayListOf(new Integer[]{2131952880, 2131952875, 2131954038, 2131954537, 2131954532, 2131954534, 2131954533, 2131954531});
        this.subtitleResIds = arrayListOf;
        this.subtitleTexts = new ArrayList<>();
        try {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayListOf, 10));
            for (Object obj : arrayListOf) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int intValue = ((Number) obj).intValue();
                ArrayList<String> arrayList2 = this.subtitleTexts;
                Context context2 = this.context;
                String[] strArr = this.subtitleResIdArgs[i];
                arrayList.add(Boolean.valueOf(arrayList2.add(context2.getString(intValue, Arrays.copyOf(strArr, strArr.length)))));
                i = i2;
            }
        } catch (Exception unused) {
        }
    }

    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        View view;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        if (object instanceof View) {
            view = (View) object;
        } else {
            view = null;
        }
        if (view != null) {
            container.removeView(view);
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public int getCount() {
        return this.drawableResIds.size();
    }

    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        FrameLayout frameLayout = new FrameLayout(container.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        AppCompatImageView appCompatImageView = new AppCompatImageView(container.getContext());
        appCompatImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, this.drawableResIds.get(position), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(frameLayout.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        Dimens dimens = Dimens.INSTANCE;
        layoutParams.setMarginStart(dimens.getMarginXLarge());
        layoutParams.setMarginEnd(layoutParams.getMarginStart());
        layoutParams.gravity = 17;
        linearLayoutCompat.setLayoutParams(layoutParams);
        linearLayoutCompat.setGravity(1);
        linearLayoutCompat.setOrientation(1);
        AppCompatTextView appCompatTextView = new AppCompatTextView(container.getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart(dimens.getMarginXLarge());
        layoutParams2.setMarginEnd(layoutParams2.getMarginStart());
        layoutParams2.gravity = 1;
        appCompatTextView.setLayoutParams(layoutParams2);
        appCompatTextView.setTextSize(16.0f);
        appCompatTextView.setTextColor(-1);
        Resources resources = container.getResources();
        Integer num = this.titleResIds.get(position);
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        appCompatTextView.setText(resources.getText(num.intValue()));
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(container.getContext());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(dimens.getMarginXLarge(), dimens.getMarginXXLarge(), dimens.getMarginXLarge(), 0);
        layoutParams3.gravity = 1;
        appCompatTextView2.setLayoutParams(layoutParams3);
        appCompatTextView2.setTextSize(12.0f);
        appCompatTextView2.setTextColor(-1);
        appCompatTextView2.setText(this.subtitleTexts.get(position));
        linearLayoutCompat.addView(appCompatTextView);
        linearLayoutCompat.addView(appCompatTextView2);
        frameLayout.addView(appCompatImageView);
        frameLayout.addView(linearLayoutCompat);
        container.addView(frameLayout, 0);
        return frameLayout;
    }

    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }
}
