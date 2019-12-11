package com.wd.doctor.contract;

import com.wd.mvplibrary.base.IBaseView;

/**
 * describe:Contract
 * date:2019/12/11
 * author:任(Lenovo)
 * function:
 */
public interface Contract {
    //V层
    interface IView extends IBaseView {
        void onSuccess(Object obj);
        void onSuccessOne(Object one);
        void onSuccessTwo(Object two);
        void onSuccessThree(Object three);
        void onSuccessFour(Object four);
        void onFail(String str);
    }

    //P层
    interface IPresenter {

    }

    //M层
    interface IModel{
        interface IModelCallback{
            void onSuccess(Object obj);
            void onSuccessOne(Object one);
            void onSuccessTwo(Object two);
            void onSuccessThree(Object three);
            void onSuccessFour(Object four);
            void onFail(String str);
        }
    }
}
