package tech.sud.mgp.SudMGPWrapper.model;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class GameViewInfoModel {
    public int ret_code;
    public String ret_msg;
    public GameViewSizeModel view_size = new GameViewSizeModel();
    public GameViewRectModel view_game_rect = new GameViewRectModel();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class GameViewRectModel {
        public int bottom;
        public int left;
        public int right;

        /* renamed from: top, reason: collision with root package name */
        public int f٩٤top;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class GameViewSizeModel {
        public int height;
        public int width;
    }
}
