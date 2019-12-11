package com.wd.doctor.presenter;

import com.wd.doctor.contract.Contract;
import com.wd.doctor.model.IModel;
import com.wd.mvplibrary.base.BasePresenter;

/**
 * describe:Presenter
 * date:2019/12/11
 * author:任(Lenovo)
 * function:
 */
public class Presenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private IModel iModel;

    @Override
    protected void initModel() {
        iModel = new IModel();
    }
}
