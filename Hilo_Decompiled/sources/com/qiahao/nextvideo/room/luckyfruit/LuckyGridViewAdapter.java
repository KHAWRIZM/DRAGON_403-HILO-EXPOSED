package com.qiahao.nextvideo.room.luckyfruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.nextvideo.room.luckyfruit.LuckyBaseGridView;
import com.qiahao.nextvideo.room.luckyfruit.LuckyBaseGridView.BaseBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001:B\u001b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u00152\u0006\u0010,\u001a\u00028\u0000H&¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020*2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fJ\u0014\u00100\u001a\u00020*2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0010\u00101\u001a\u0004\u0018\u00010\u00152\u0006\u00102\u001a\u00020\u0007J\u0015\u00103\u001a\u0004\u0018\u00018\u00002\u0006\u00102\u001a\u00020\u0007¢\u0006\u0002\u00104J\b\u00105\u001a\u0004\u0018\u00010\u0015J\u000e\u00106\u001a\u00020*2\u0006\u00102\u001a\u00020\u0007J\u0010\u00107\u001a\u00020*2\u0006\u00108\u001a\u000209H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006;"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyGridViewAdapter;", "T", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyBaseGridView$BaseBean;", "", "context", "Landroid/content/Context;", "layoutRes", "", "<init>", "(Landroid/content/Context;I)V", "getContext", "()Landroid/content/Context;", "getLayoutRes", "()I", "listData", "", "getListData", "()Ljava/util/List;", "setListData", "(Ljava/util/List;)V", "listView", "Landroid/view/View;", "getListView", "setListView", "onClickListener", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyGridViewAdapter$OnItemClickListener;", "getOnClickListener", "()Lcom/qiahao/nextvideo/room/luckyfruit/LuckyGridViewAdapter$OnItemClickListener;", "setOnClickListener", "(Lcom/qiahao/nextvideo/room/luckyfruit/LuckyGridViewAdapter$OnItemClickListener;)V", "itemClickable", "", "getItemClickable", "()Z", "setItemClickable", "(Z)V", "centerView", "getCenterView", "()Landroid/view/View;", "setCenterView", "(Landroid/view/View;)V", "convert", "", "itemView", "item", "(Landroid/view/View;Lcom/qiahao/nextvideo/room/luckyfruit/LuckyBaseGridView$BaseBean;)V", "setData", "data", "setOnItemClickListener", "getItemView", "position", "getItem", "(I)Lcom/qiahao/nextvideo/room/luckyfruit/LuckyBaseGridView$BaseBean;", "onCreateItemView", "bindData", "onAddView", "parentView", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyBaseGridView;", "OnItemClickListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LuckyGridViewAdapter<T extends LuckyBaseGridView.BaseBean> {

    @Nullable
    private View centerView;

    @Nullable
    private final Context context;
    private boolean itemClickable;
    private final int layoutRes;

    @NotNull
    private List<T> listData = new ArrayList();

    @NotNull
    private List<View> listView = new ArrayList();

    @Nullable
    private OnItemClickListener<T> onClickListener;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0001H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyGridViewAdapter$OnItemClickListener;", "T", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "bean", "(Landroid/view/View;ILjava/lang/Object;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface OnItemClickListener<T> {
        void onItemClick(@NotNull View view, int position, T bean);
    }

    public LuckyGridViewAdapter(@Nullable Context context, int i) {
        this.context = context;
        this.layoutRes = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$0(LuckyGridViewAdapter luckyGridViewAdapter, int i, View view) {
        OnItemClickListener<T> onItemClickListener;
        if (luckyGridViewAdapter.itemClickable && (onItemClickListener = luckyGridViewAdapter.onClickListener) != null) {
            Intrinsics.checkNotNull(view);
            onItemClickListener.onItemClick(view, i, luckyGridViewAdapter.listData.get(i));
        }
    }

    public final void bindData(final int position) {
        if (this.listData.size() >= this.listView.size() && position >= 0 && position < this.listData.size()) {
            convert(this.listView.get(position), this.listData.get(position));
            View itemView = getItemView(position);
            if (itemView != null) {
                itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.r0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LuckyGridViewAdapter.bindData$lambda$0(LuckyGridViewAdapter.this, position, view);
                    }
                });
            }
        }
    }

    public abstract void convert(@Nullable View itemView, @NotNull T item);

    @Nullable
    public final View getCenterView() {
        return this.centerView;
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final T getItem(int position) {
        if (position >= 0 && position < this.listData.size()) {
            return this.listData.get(position);
        }
        return null;
    }

    public final boolean getItemClickable() {
        return this.itemClickable;
    }

    @Nullable
    public final View getItemView(int position) {
        if (position >= 0 && position < this.listView.size()) {
            return this.listView.get(position);
        }
        return null;
    }

    public final int getLayoutRes() {
        return this.layoutRes;
    }

    @NotNull
    public final List<T> getListData() {
        return this.listData;
    }

    @NotNull
    public final List<View> getListView() {
        return this.listView;
    }

    @Nullable
    public final OnItemClickListener<T> getOnClickListener() {
        return this.onClickListener;
    }

    public void onAddView(@NotNull LuckyBaseGridView parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
    }

    @Nullable
    public final View onCreateItemView() {
        if (this.layoutRes == 0) {
            return null;
        }
        return LayoutInflater.from(this.context).inflate(this.layoutRes, (ViewGroup) null);
    }

    public final void setCenterView(@Nullable View view) {
        this.centerView = view;
    }

    public final void setData(@Nullable List<T> data) {
        if (data == null) {
            this.listData.clear();
            this.listView.clear();
        } else {
            this.listData = data;
        }
    }

    public final void setItemClickable(boolean z) {
        this.itemClickable = z;
    }

    public final void setListData(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.listData = list;
    }

    public final void setListView(@NotNull List<View> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.listView = list;
    }

    public final void setOnClickListener(@Nullable OnItemClickListener<T> onItemClickListener) {
        this.onClickListener = onItemClickListener;
    }

    public final void setOnItemClickListener(@NotNull OnItemClickListener<T> onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.onClickListener = onClickListener;
    }
}
