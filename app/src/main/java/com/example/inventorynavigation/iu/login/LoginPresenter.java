package com.example.inventorynavigation.iu.login;



/**
 * Clase que controla la reglas de negocio de la clase User
 */
public class LoginPresenter implements LoginContract.Presenter, LoginInteractorImpl.LoginInteractor {

    private LoginContract.View view;
    private LoginInteractorImpl interactor;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.interactor = new LoginInteractorImpl(this);
    }

    @Override
    public void validateCredentials(String user, String password) {
        //1. Llamamos al método validateCredentials del Interactor.
        view.showProgress();

        //El interactor realiza las acciones oportunas con el usuario y el password - Validará el usuario
        interactor.validateCredentials(user, password);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }

    //region Métodos del contrato del interactor

    @Override
    public void onUserEmptyError() {
        view.hideProgress();
        view.setUserEmptyError();
    }

    @Override
    public void onPasswordEmptyError() {
        view.hideProgress();
        view.setPasswordEmptyError();
    }

    @Override
    public void onPasswordFormatError() {
        view.hideProgress();
        view.setPasswordFormatError();
    }

    @Override
    public void onAuthenticationError() {
        view.hideProgress();
        view.setAuthenticationError();
    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        view.onSuccess();
    }

    //endregion
}