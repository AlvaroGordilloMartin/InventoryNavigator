package com.example.inventorynavigation.iu.secciones;

import com.example.inventorynavigation.data.model.Estanteria;

import java.util.List;

public class ListSeccionesPresenter implements ListSeccionesContract.Presenter, ListSeccionesInteractorImpl.ListSeccionesInteractor {

    private ListSeccionesInteractorImpl interactor;
    private ListSeccionesContract.View view;

    public ListSeccionesPresenter(ListSeccionesContract.View view) {
        this.view = view;
        interactor = new ListSeccionesInteractorImpl(this);
    }

    @Override
    public void load() {
        view.showProgress();
        interactor.load();
    }

    @Override
    public void delete(Estanteria deleted) {
        interactor.delete(deleted);

    }

    @Override
    public void undo(Estanteria deleted) {
        interactor.undo(deleted);

    }

    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }


    @Override
    public void OnNoData() {
        view.hideProgress();
        view.setNoData();
    }

    @Override
    public void OnSuccess(List<Estanteria> list) {
        view.hideProgress();
        view.onSuccess(list);
    }

    @Override
    public void onSuccessDeleted() {
        view.onSuccessDeleted();

    }

    @Override
    public void onSuccessUndo() {
        view.onSuccessUndo();
    }
}
