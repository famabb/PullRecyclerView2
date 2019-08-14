package com.famabb.pull;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;

/**
 * Created by ${ChenJC} on 2018/2/24.
 * 上拉更多基类
 */

public abstract class AbRefreshMoreView extends AbRefreshView {
    private int mRefreshHeight;

    public AbRefreshMoreView(Context context) {
        super(context);
        mRefreshHeight = onCreateRefreshLimitHeight();
        mMainView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
        setGravity(Gravity.TOP);
    }

    //触发刷新的最小高度
    protected abstract int onCreateRefreshLimitHeight();

    //正在下拉
    protected abstract void onPullingUp();

    //已经达到可以刷新的状态
    protected abstract void onReleaseState();

    //正在刷新
    protected abstract void onLoadingMore();

    //刷新成功
    protected abstract void onResultSuccess();

    //刷新失败
    protected abstract void onResultFail();

    protected int getRefreshHeight() {
        return mRefreshHeight;
    }

}
