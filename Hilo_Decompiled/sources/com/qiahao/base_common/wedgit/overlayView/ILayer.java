package com.qiahao.base_common.wedgit.overlayView;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.model.overlay.Location;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J=\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH&¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bH&¨\u0006\u0010"}, d2 = {"Lcom/qiahao/base_common/wedgit/overlayView/ILayer;", "", "addHighlight", "Lcom/qiahao/base_common/wedgit/overlayView/BaseLayer;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "withView", "verticalOffset", "", "horizontalOffset", "locations", "", "Lcom/qiahao/base_common/model/overlay/Location;", "(Landroid/view/View;II[Lcom/qiahao/base_common/model/overlay/Location;)Lcom/qiahao/base_common/wedgit/overlayView/BaseLayer;", "withImage", "imgSrc", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface ILayer {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ BaseLayer withView$default(ILayer iLayer, View view, int i10, int i11, Location[] locationArr, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i10 = 0;
                }
                if ((i12 & 4) != 0) {
                    i11 = 0;
                }
                return iLayer.withView(view, i10, i11, locationArr);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withView");
        }
    }

    @NotNull
    BaseLayer addHighlight(@NotNull View view);

    @NotNull
    BaseLayer withImage(int imgSrc);

    @NotNull
    BaseLayer withView(@NotNull View view, int verticalOffset, int horizontalOffset, @NotNull Location... locations);
}
