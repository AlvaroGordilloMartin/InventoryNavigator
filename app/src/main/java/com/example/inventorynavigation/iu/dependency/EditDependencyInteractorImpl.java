package com.example.inventorynavigation.iu.dependency;

import com.example.inventorynavigation.data.model.Dependency;
import com.example.inventorynavigation.data.repository.DependencyRepository;

public class EditDependencyInteractorImpl {
    private EditDependencyInteractor callback;

    /**
     * Interfaz que debe implementar el presentador que quiera utilizar el interactor.
     */
    interface EditDependencyInteractor {
        void OnShortNameExists();

        void OnSuccess();
    }

    public EditDependencyInteractorImpl(EditDependencyInteractorImpl.EditDependencyInteractor presenter) {
        this.callback = presenter;
    }
    public void furtherDependency(Dependency dependency){
        if (DependencyRepository.getInstance().Exists(dependency))
        {
            callback.OnShortNameExists();
            return;
        }
        DependencyRepository.getInstance().add(dependency);
        callback.OnSuccess();
    }

    public void editDependency(Dependency dependency){
        DependencyRepository.getInstance().Edit(dependency);
        callback.OnSuccess();
    }

}
