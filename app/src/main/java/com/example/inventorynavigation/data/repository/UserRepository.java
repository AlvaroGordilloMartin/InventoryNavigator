package com.example.inventorynavigation.data.repository;

import com.example.inventorynavigation.data.model.TypeUser;
import com.example.inventorynavigation.data.model.User;

import java.util.ArrayList;

/**
 * Esta clase será accesible desde cualquier punto de la aplicacion
 * Se accedera mediante el metodo estatico getInstance)= que devuelve
 * la instancia del repositorio que siempre se inicializa en un bloque
 * estatico
 */
public class UserRepository {

    private static UserRepository repository;
    private ArrayList<User> users;
    private int id;

    /**
     * Se inicializa las propiedades estáticas del repositorio
     * en el bloque static
     */
    static {
        repository=new UserRepository();
    }

    //Constructor privado donde se incicializaran las variables de objeto.
    private UserRepository(){
        users = new ArrayList<>();
        initialice();
    }

    /**
     * Inicializa lista de usuarios
     */
    private void initialice(){
        users.add(new User(1, "lourdes", "Lourdes18?", "Lourdes Rodriguez", "lourdes@iesportada.org","/img/lourdes", TypeUser.MANAGER));
        users.add(new User(2, "jesus", "Jesus19?", "Jesus González", "jesus@iesportada.org", "/img/jesus", TypeUser.TECHNICAL));
        users.add(new User(3, "israel", "Ayudaporfavor", "Israel", "israel@iesportada.org", "/img/israel", TypeUser.ADMIN));
        id = 4;
    }

    /**
     * Añade usuario a la lista
     * @param user
     */
    private void add(User user){
        users.add(user);
    }

    

    public static UserRepository getInstance(){
        //No es necesario comprobar si es null porque se ha inicializado
        //en el bloque static
        return repository;
    }

    public boolean validateCredentials(String useraux, String password) {
        for (User user:users){
            if(user.getUser().equals(useraux) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    /**
     * Método que añade un usuario con solo tres campos
     * @param useraux
     * @param password
     * @param email
     */
    public void add(String useraux, String password, String email) {
        User user = new User(id++,useraux,password,useraux,email,"/igm/"+useraux,TypeUser.TECHNICAL);
        add(user);
    }

    /**
     * Método que comprueba si un usuario está en el sistema
     * @param useraux
     * @return
     */
    public boolean userExists(String useraux) {
        for (User user:users){
            if(user.getUser().equals(useraux))
                return true;
        }
        return false;
    }
}
