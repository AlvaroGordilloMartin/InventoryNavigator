package com.example.inventorynavigation.data;

import android.content.Context;

import androidx.core.content.ContextCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.inventorynavigation.data.dao.DependencyDao;
import com.example.inventorynavigation.data.model.Dependency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Definir la configuracion de la base de datos
@Database(entities = {Dependency.class},version = 1)
public abstract class InventoryDatabase extends RoomDatabase {

    //Crear los metodos de obtencion de los Dao
    public  abstract DependencyDao dependencyDao();

    /**
     * Solucion Google: genera un problema ya que se necesita tener el contexto para obtener la BD
     */
    private static volatile InventoryDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static InventoryDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (InventoryDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            InventoryDatabase.class, "inventory")
                            .build();
                }
            }
        }
        return INSTANCE;
    }



    /**
     * Otra opcion es separar la creacion de la obtencion
     */
    public static void create(final Context context){
        if (INSTANCE == null) {
            synchronized (InventoryDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            InventoryDatabase.class, "inventory")
                            .build();
                }
            }
        }
    }

    public static InventoryDatabase getDatabase(){
        return INSTANCE;
    }
}


