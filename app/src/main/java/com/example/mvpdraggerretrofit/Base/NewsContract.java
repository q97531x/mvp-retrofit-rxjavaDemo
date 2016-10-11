package com.example.mvpdraggerretrofit.Base;

import com.example.mvpdraggerretrofit.Model.BasNewsListBean;

import java.util.List;

/**
 * Created by XmacZone on 16/9/27.
 */

public interface NewsContract {
    interface View extends BaseView<Presenter> {
        void showError(String s);

        void showData(List<BasNewsListBean> newsListBean);
    }

    interface Presenter extends BasePresenter{
        void load();
    }
}
