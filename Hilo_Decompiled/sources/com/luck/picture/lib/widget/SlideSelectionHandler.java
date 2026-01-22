package com.luck.picture.lib.widget;

import com.luck.picture.lib.widget.SlideSelectTouchListener;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SlideSelectionHandler implements SlideSelectTouchListener.OnAdvancedSlideSelectListener {
    private HashSet<Integer> mOriginalSelection;
    private final ISelectionHandler mSelectionHandler;
    private ISelectionStartFinishedListener mStartFinishedListener = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface ISelectionHandler {
        void changeSelection(int i10, int i11, boolean z10, boolean z11);

        Set<Integer> getSelection();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface ISelectionStartFinishedListener {
        void onSelectionFinished(int i10);

        void onSelectionStarted(int i10, boolean z10);
    }

    public SlideSelectionHandler(ISelectionHandler iSelectionHandler) {
        this.mSelectionHandler = iSelectionHandler;
    }

    private void checkedChangeSelection(int i10, int i11, boolean z10) {
        this.mSelectionHandler.changeSelection(i10, i11, z10, false);
    }

    @Override // com.luck.picture.lib.widget.SlideSelectTouchListener.OnSlideSelectListener
    public void onSelectChange(int i10, int i11, boolean z10) {
        boolean z11;
        while (i10 <= i11) {
            if (z10 != this.mOriginalSelection.contains(Integer.valueOf(i10))) {
                z11 = true;
            } else {
                z11 = false;
            }
            checkedChangeSelection(i10, i10, z11);
            i10++;
        }
    }

    @Override // com.luck.picture.lib.widget.SlideSelectTouchListener.OnAdvancedSlideSelectListener
    public void onSelectionFinished(int i10) {
        this.mOriginalSelection = null;
        ISelectionStartFinishedListener iSelectionStartFinishedListener = this.mStartFinishedListener;
        if (iSelectionStartFinishedListener != null) {
            iSelectionStartFinishedListener.onSelectionFinished(i10);
        }
    }

    @Override // com.luck.picture.lib.widget.SlideSelectTouchListener.OnAdvancedSlideSelectListener
    public void onSelectionStarted(int i10) {
        this.mOriginalSelection = new HashSet<>();
        Set<Integer> selection = this.mSelectionHandler.getSelection();
        if (selection != null) {
            this.mOriginalSelection.addAll(selection);
        }
        boolean contains = this.mOriginalSelection.contains(Integer.valueOf(i10));
        this.mSelectionHandler.changeSelection(i10, i10, !this.mOriginalSelection.contains(Integer.valueOf(i10)), true);
        ISelectionStartFinishedListener iSelectionStartFinishedListener = this.mStartFinishedListener;
        if (iSelectionStartFinishedListener != null) {
            iSelectionStartFinishedListener.onSelectionStarted(i10, contains);
        }
    }

    public SlideSelectionHandler withStartFinishedListener(ISelectionStartFinishedListener iSelectionStartFinishedListener) {
        this.mStartFinishedListener = iSelectionStartFinishedListener;
        return this;
    }
}
