package com.qiahao.nextvideo.room.adapter;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/BaseMicroViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "mMicType", "", "getMMicType", "()I", "setMMicType", "(I)V", "getItemCount", "getItemId", "", "position", "changeMicType", "", "micType", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseMicroViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NotNull
    private static final String TAG = "BaseMicroViewAdapter";
    private int mMicType = 2;

    public final void changeMicType(int micType) {
        this.mMicType = micType;
    }

    public int getItemCount() {
        Log.d(TAG, "麦位----getItemCount: ----------------");
        if (this.mMicType != 1) {
            return 10;
        }
        return 5;
    }

    public long getItemId(int position) {
        return position;
    }

    public final int getMMicType() {
        return this.mMicType;
    }

    public final void setMMicType(int i) {
        this.mMicType = i;
    }
}
