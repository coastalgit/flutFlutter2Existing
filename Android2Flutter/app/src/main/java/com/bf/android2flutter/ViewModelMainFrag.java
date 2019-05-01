package com.bf.android2flutter;

import android.arch.lifecycle.ViewModel;
import android.view.View;

public class ViewModelMainFrag extends ViewModel {

    private int activeFragIndex = 0;

    public ViewModelMainFrag() {
    }

    public int getActiveFragIndex() {
        return activeFragIndex;
    }

    public void setActiveFragIndex(int activeFragIndex) {
        this.activeFragIndex = activeFragIndex;
    }

}
