package com.bumptech.glide.integration.webp;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f٧٢٨٢a;

    /* renamed from: b, reason: collision with root package name */
    public final int f٧٢٨٣b;

    /* renamed from: c, reason: collision with root package name */
    public final int f٧٢٨٤c;

    /* renamed from: d, reason: collision with root package name */
    public final int f٧٢٨٥d;

    /* renamed from: e, reason: collision with root package name */
    public final int f٧٢٨٦e;

    /* renamed from: f, reason: collision with root package name */
    public final int f٧٢٨٧f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f٧٢٨٨g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f٧٢٨٩h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i10, WebpFrame webpFrame) {
        this.f٧٢٨٢a = i10;
        this.f٧٢٨٣b = webpFrame.getXOffest();
        this.f٧٢٨٤c = webpFrame.getYOffest();
        this.f٧٢٨٥d = webpFrame.getWidth();
        this.f٧٢٨٦e = webpFrame.getHeight();
        this.f٧٢٨٧f = webpFrame.getDurationMs();
        this.f٧٢٨٨g = webpFrame.isBlendWithPreviousFrame();
        this.f٧٢٨٩h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        return "frameNumber=" + this.f٧٢٨٢a + ", xOffset=" + this.f٧٢٨٣b + ", yOffset=" + this.f٧٢٨٤c + ", width=" + this.f٧٢٨٥d + ", height=" + this.f٧٢٨٦e + ", duration=" + this.f٧٢٨٧f + ", blendPreviousFrame=" + this.f٧٢٨٨g + ", disposeBackgroundColor=" + this.f٧٢٨٩h;
    }
}
