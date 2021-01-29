package com.example.inventorynavigation.iu.signup;

import com.example.inventorynavigation.iu.base.BasePresenter;
import com.example.inventorynavigation.iu.user.UserView;

public interface SignUpContract {

    interface View extends UserView {

        //Mostrar un cuadro de diálogo.
        void showProgressDialog();

        //Ocultar el cuadro de diálogo.
        void hideProgressDialog();

        //Usuario duplicado en el sistema.
        void setUserExistsError();

        //Error en la confirmación de Password.
        void setConfirmPasswordError();

        //El email no puede ser nulo.
        void setEmailEmptyError();

        //El email debe cumplir un formato correcto.
        void setEmailFormatError();

    }

    interface Presenter extends BasePresenter {

        void validateUser(String user, String password, String confirmPassword, String email);

    }
}
