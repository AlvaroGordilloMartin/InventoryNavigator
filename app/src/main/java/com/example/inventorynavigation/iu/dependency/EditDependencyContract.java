package com.example.inventorynavigation.iu.dependency;

import com.example.inventorynavigation.data.model.Dependency;
import com.example.inventorynavigation.iu.base.BaseListView;
import com.example.inventorynavigation.iu.base.BasePresenter;

public interface EditDependencyContract {
    interface View extends BaseListView<Dependency> {

        void setShortNameExists();

        void onSuccess();

    }

    interface Presenter extends BasePresenter {

        void furtherDependency(Dependency dependency);
        void editDepedency(Dependency dependency);

    }
}
