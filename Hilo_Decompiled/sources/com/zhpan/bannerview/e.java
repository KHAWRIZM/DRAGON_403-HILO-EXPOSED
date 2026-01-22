package com.zhpan.bannerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class e extends RecyclerView.Adapter {
    public static final int MAX_VALUE = 1000;
    private boolean isCanLoop;
    protected List<Object> mList = new ArrayList();
    private a mPageClickListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface a {
        void a(View view, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(f fVar, View view) {
        int adapterPosition = fVar.getAdapterPosition();
        if (this.mPageClickListener != null && adapterPosition != -1) {
            this.mPageClickListener.a(view, dd.a.c(adapterPosition, getListSize()), adapterPosition);
        }
    }

    protected abstract void bindData(f fVar, Object obj, int i, int i2);

    public f createViewHolder(ViewGroup viewGroup, View view, int i) {
        return new f(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Object> getData() {
        return this.mList;
    }

    public final int getItemCount() {
        if (this.isCanLoop && getListSize() > 1) {
            return 1000;
        }
        return getListSize();
    }

    public final int getItemViewType(int i) {
        return getViewType(dd.a.c(i, getListSize()));
    }

    public abstract int getLayoutId(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getListSize() {
        return this.mList.size();
    }

    protected int getViewType(int i) {
        return 0;
    }

    public boolean isCanLoop() {
        return this.isCanLoop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanLoop(boolean z) {
        this.isCanLoop = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<Object> list) {
        if (list != null) {
            this.mList.clear();
            this.mList.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPageClickListener(a aVar) {
        this.mPageClickListener = aVar;
    }

    public final void onBindViewHolder(f fVar, int i) {
        int c = dd.a.c(i, getListSize());
        bindData(fVar, this.mList.get(c), c, getListSize());
    }

    public final f onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutId(i), viewGroup, false);
        final f createViewHolder = createViewHolder(viewGroup, inflate, i);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.zhpan.bannerview.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.b(createViewHolder, view);
            }
        });
        return createViewHolder;
    }
}
