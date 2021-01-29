package com.example.inventorynavigation.data.repository;

import com.example.inventorynavigation.data.model.Dependency;
import com.example.inventorynavigation.data.model.Estanteria;

import java.util.ArrayList;
import java.util.List;

public class SeccionesRepository {

    private List<Estanteria> list;
    private static SeccionesRepository repository;

    static {
        repository = new SeccionesRepository();
    }

    public SeccionesRepository() {
        this.list = new ArrayList<>();
        initialice();
    }


    private void initialice() {
        list.add(0,new Estanteria("Estanteria A", new Dependency("2º Ciclo Formativo DAM","2DAM", "Aula del alumnado de 2ºDAM","")));
        list.add(1,new Estanteria("Estanteria B", new Dependency("2º Ciclo Formativo DAM","2DAM", "Aula del alumnado de 2ºDAM","")));
        list.add(2,new Estanteria("Estanteria C", new Dependency("2º Ciclo Formativo DAM","2DAM", "Aula del alumnado de 2ºDAM","")));

    }

    public static SeccionesRepository getInstance() {
        return repository;
    }

    public static boolean Exists(Estanteria estanteria){
        return estanteria.toString().isEmpty();
    }

    public List<Estanteria> getList(){
        return list;
    }

    public void add(Estanteria estanteria) {
        list.add(estanteria);
    }

    public void Edit(Estanteria estanteria) {
        list.get(list.lastIndexOf(estanteria)).Edit(estanteria);
    }

    public void delete(Estanteria estanteria) {
        list.remove(estanteria);
    }
}
