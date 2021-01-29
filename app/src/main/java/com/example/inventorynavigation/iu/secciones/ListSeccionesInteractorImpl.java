package com.example.inventorynavigation.iu.secciones;

import com.example.inventorynavigation.data.model.Estanteria;
import com.example.inventorynavigation.data.repository.SeccionesRepository;

import java.util.List;

public class ListSeccionesInteractorImpl {

    private ListSeccionesInteractor callback;


    /**
     * Interfaz que debe implementar el presentador que quiera utilizar el interactor
     */
    interface ListSeccionesInteractor {
        void OnNoData();

        void OnSuccess(List<Estanteria> list);

        void onSuccessDeleted();

        void onSuccessUndo();
    }

    public ListSeccionesInteractorImpl(ListSeccionesInteractor callback) {
        this.callback = callback;
    }

    /**
     * Método que solicita el conjunto de dependencias al Repository/Origen de datos
     */
    public void load() {
        List<Estanteria> list = SeccionesRepository.getInstance().getList();
        //1. No hay datos en el listado.
        if (list.isEmpty())
            callback.OnNoData();
        else
            callback.OnSuccess(list);
    }


    public void delete(Estanteria deleted) {
        SeccionesRepository.getInstance().delete(deleted);
        callback.onSuccessDeleted();
    }


    public void undo(Estanteria deleted) {
        SeccionesRepository.getInstance().add(deleted);
        callback.onSuccessUndo();
    }
}
