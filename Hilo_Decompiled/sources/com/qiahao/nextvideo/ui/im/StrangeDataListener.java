package com.qiahao.nextvideo.ui.im;

import com.qiahao.nextvideo.data.strange.StrangeItemData;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/ui/im/StrangeDataListener;", "", "messageDataListener", "", "listMessageDate", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/strange/StrangeItemData;", "unReadMessage", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface StrangeDataListener {
    void messageDataListener(@NotNull ArrayList<StrangeItemData> listMessageDate, int unReadMessage);
}
