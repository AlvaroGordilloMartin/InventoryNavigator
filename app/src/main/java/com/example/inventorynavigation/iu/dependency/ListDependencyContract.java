package com.example.inventorynavigation.iu.dependency;

import com.example.inventorynavigation.data.model.Dependency;
import com.example.inventorynavigation.iu.base.BaseListView;
import com.example.inventorynavigation.iu.base.BasePresenter;

public interface ListDependencyContract {

    interface View extends BaseListView<Dependency> {

        //Método que muestra una barra de progreso en la interfaz
        //mientras se realiza una acción en el interactor
        void showProgress();

        //Método que oculta la barra de progreso en la interfaz
        void hideProgress();

        //Activa la parte de la vista que indica que no hay datos.
        void setNoData();

        void onSuccessDeleted();

        void onSuccessUndo();
    }

    interface Presenter extends BasePresenter {

        void load();

        void delete(Dependency deleted);

        void undo(Dependency deleted);
    }

}
