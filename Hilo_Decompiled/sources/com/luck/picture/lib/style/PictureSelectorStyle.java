package com.luck.picture.lib.style;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PictureSelectorStyle {
    private AlbumWindowStyle albumWindowStyle;
    private BottomNavBarStyle bottomBarStyle;
    private SelectMainStyle selectMainStyle;
    private TitleBarStyle titleBarStyle;
    private PictureWindowAnimationStyle windowAnimationStyle;

    public AlbumWindowStyle getAlbumWindowStyle() {
        AlbumWindowStyle albumWindowStyle = this.albumWindowStyle;
        if (albumWindowStyle == null) {
            return new AlbumWindowStyle();
        }
        return albumWindowStyle;
    }

    public BottomNavBarStyle getBottomBarStyle() {
        BottomNavBarStyle bottomNavBarStyle = this.bottomBarStyle;
        if (bottomNavBarStyle == null) {
            return new BottomNavBarStyle();
        }
        return bottomNavBarStyle;
    }

    public SelectMainStyle getSelectMainStyle() {
        SelectMainStyle selectMainStyle = this.selectMainStyle;
        if (selectMainStyle == null) {
            return new SelectMainStyle();
        }
        return selectMainStyle;
    }

    public TitleBarStyle getTitleBarStyle() {
        TitleBarStyle titleBarStyle = this.titleBarStyle;
        if (titleBarStyle == null) {
            return new TitleBarStyle();
        }
        return titleBarStyle;
    }

    public PictureWindowAnimationStyle getWindowAnimationStyle() {
        if (this.windowAnimationStyle == null) {
            this.windowAnimationStyle = PictureWindowAnimationStyle.ofDefaultWindowAnimationStyle();
        }
        return this.windowAnimationStyle;
    }

    public void setAlbumWindowStyle(AlbumWindowStyle albumWindowStyle) {
        this.albumWindowStyle = albumWindowStyle;
    }

    public void setBottomBarStyle(BottomNavBarStyle bottomNavBarStyle) {
        this.bottomBarStyle = bottomNavBarStyle;
    }

    public void setSelectMainStyle(SelectMainStyle selectMainStyle) {
        this.selectMainStyle = selectMainStyle;
    }

    public void setTitleBarStyle(TitleBarStyle titleBarStyle) {
        this.titleBarStyle = titleBarStyle;
    }

    public void setWindowAnimationStyle(PictureWindowAnimationStyle pictureWindowAnimationStyle) {
        this.windowAnimationStyle = pictureWindowAnimationStyle;
    }
}
