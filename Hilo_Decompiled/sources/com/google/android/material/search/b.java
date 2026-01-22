package com.google.android.material.search;

import android.animation.Animator;
import android.view.View;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private Animator f٩٨١٤d;

    /* renamed from: e, reason: collision with root package name */
    private Animator f٩٨١٥e;

    /* renamed from: a, reason: collision with root package name */
    private final Set f٩٨١١a = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    private final Set f٩٨١٢b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    private final Set f٩٨١٣c = new LinkedHashSet();

    /* renamed from: f, reason: collision with root package name */
    private boolean f٩٨١٦f = true;

    /* renamed from: g, reason: collision with root package name */
    private Animator f٩٨١٧g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z10) {
        this.f٩٨١٦f = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SearchBar searchBar) {
        Animator animator = this.f٩٨١٤d;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.f٩٨١٥e;
        if (animator2 != null) {
            animator2.end();
        }
        View centerView = searchBar.getCenterView();
        if (centerView != null) {
            centerView.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
        }
    }
}
