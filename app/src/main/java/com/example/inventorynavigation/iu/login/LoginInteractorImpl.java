package com.example.inventorynavigation.iu.login;

import android.os.Handler;
import android.text.TextUtils;

import com.example.inventorynavigation.data.repository.UserRepository;
import com.example.inventorynavigation.iu.utils.CommonUtils;

public class LoginInteractorImpl {

    private LoginInteractor presenter;

    /*
     * Definición de las interfaces que debe implementar cualquier presentador
     * que haga uso del Interactor.
     */
    public interface LoginInteractor {

        void onUserEmptyError(); //RN-U1 y Alternativa 1.1

        void onPasswordEmptyError(); //RN-U1 y Alternativa 1.1

        void onPasswordFormatError(); //RN-U2 y Alternativa 1.2

        void onAuthenticationError(); //Alternativa 1.3

        void onSuccess(); //Secuencia normal del caso de uso.
    }

    public LoginInteractorImpl(LoginInteractor presenter) {
        this.presenter = presenter;
    }

    /**
     * Este método contiene la lógica empresarial del caso de uso UC1-Login
     * Se crea un hilo para simular el retardo de dos segundos y ver cómo en la
     * vista se visualiza una barra de progreso.
     *
     * @param user
     * @param password
     */
    public void validateCredentials(final String user, final String password) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //Reglas de negocio y  Alternativas del caso de uso UC1-Login
                //RN-U1 y Alternativa 1.1.: el usuario no puede ser nulo
                if (TextUtils.isEmpty(user)) {
                    presenter.onUserEmptyError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    presenter.onPasswordEmptyError();
                    return;
                }
                if (!CommonUtils.isPasswordValid(password))
                {
                    presenter.onPasswordFormatError();
                    return;
                }
                if(!UserRepository.getInstance().validateCredentials(user,password)){
                    presenter.onAuthenticationError();
                    return;
                }
                //Caso de éxito
                presenter.onSuccess();
            }
        }, 2000);
    }
}
