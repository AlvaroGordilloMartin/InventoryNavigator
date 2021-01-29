package com.example.inventorynavigation.data.model;

import java.io.Serializable;
import java.util.Objects;

public class Estanteria implements Serializable {

    String estanteria;
    Dependency dependencia;

    public Estanteria(String estanteria, Dependency dependencia) {
        this.estanteria = estanteria;
        this.dependencia = dependencia;
    }

    public String getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(String estanteria) {
        this.estanteria = estanteria;
    }

    public Dependency getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependency dependencia) {
        this.dependencia = dependencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estanteria that = (Estanteria) o;
        return Objects.equals(estanteria, that.estanteria) &&
                Objects.equals(dependencia, that.dependencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estanteria, dependencia);
    }

    public void Edit(Estanteria estanteria) {
        this.dependencia = estanteria.getDependencia();
        this.estanteria = estanteria.getEstanteria();
    }

    @Override
    public String toString() {
        return "Estanteria{" +
                "estanteria='" + estanteria + '\'' +
                ", dependencia=" + dependencia +
                '}';
    }
}
