package com.qmuiteam.qmui.widget.pullLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.collection.SimpleArrayMap;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout;
import ic.i;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIPullRefreshView extends AppCompatImageView implements QMUIPullLayout.c, fc.a {

    /* renamed from: c, reason: collision with root package name */
    private static SimpleArrayMap f١٣٢٤٣c;

    /* renamed from: a, reason: collision with root package name */
    private androidx.swiperefreshlayout.widget.a f١٣٢٤٤a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٣٢٤٥b;

    static {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(4);
        f١٣٢٤٣c = simpleArrayMap;
        simpleArrayMap.put("tintColor", Integer.valueOf(R.attr.qmui_skin_support_pull_refresh_view_color));
    }

    public QMUIPullRefreshView(Context context) {
        this(context, null);
    }

    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.c
    public void a() {
        this.f١٣٢٤٤a.start();
    }

    @Override // fc.a
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return f١٣٢٤٣c;
    }

    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.c
    public void h(QMUIPullLayout.g gVar, int i10) {
        if (this.f١٣٢٤٤a.isRunning()) {
            return;
        }
        float min = Math.min(r3, i10) * 0.85f;
        float n10 = gVar.n();
        this.f١٣٢٤٤a.d(true);
        this.f١٣٢٤٤a.j(DownloadProgress.UNKNOWN_PROGRESS, min / n10);
        this.f١٣٢٤٤a.g((i10 * 0.4f) / n10);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f١٣٢٤٤a.stop();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12 = this.f١٣٢٤٥b;
        setMeasuredDimension(i12, i12);
    }

    public void setColorSchemeColors(int... iArr) {
        this.f١٣٢٤٤a.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = androidx.core.content.a.getColor(context, iArr[i10]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setSize(int i10) {
        if (i10 != 0 && i10 != 1) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i10 == 0) {
            this.f١٣٢٤٥b = (int) (displayMetrics.density * 56.0f);
        } else {
            this.f١٣٢٤٥b = (int) (displayMetrics.density * 40.0f);
        }
        setImageDrawable(null);
        this.f١٣٢٤٤a.l(i10);
        setImageDrawable(this.f١٣٢٤٤a);
    }

    public QMUIPullRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٢٤٤a = new androidx.swiperefreshlayout.widget.a(context);
        setColorSchemeColors(i.b(context, R.attr.qmui_skin_support_pull_refresh_view_color));
        this.f١٣٢٤٤a.l(0);
        this.f١٣٢٤٤a.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
        this.f١٣٢٤٤a.e(0.8f);
        setImageDrawable(this.f١٣٢٤٤a);
        this.f١٣٢٤٥b = (int) (getResources().getDisplayMetrics().density * 40.0f);
    }
}
