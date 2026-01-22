package io.agora.rtc.video;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class WatermarkOptions {
    public boolean visibleInPreview = true;
    public Rectangle positionInLandscapeMode = new Rectangle();
    public Rectangle positionInPortraitMode = new Rectangle();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class Rectangle {
        public int height;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f١٤٩٥٥x;

        /* renamed from: y, reason: collision with root package name */
        public int f١٤٩٥٦y;

        public Rectangle() {
            this.f١٤٩٥٥x = 0;
            this.f١٤٩٥٦y = 0;
            this.width = 0;
            this.height = 0;
        }

        public Rectangle(int i10, int i11, int i12, int i13) {
            this.f١٤٩٥٥x = i10;
            this.f١٤٩٥٦y = i11;
            this.width = i12;
            this.height = i13;
        }
    }
}
