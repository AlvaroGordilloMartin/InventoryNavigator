package com.example.inventorynavigation.iu.secciones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.inventorynavigation.R;
import com.example.inventorynavigation.data.model.Dependency;
import com.example.inventorynavigation.data.model.Estanteria;
import com.example.inventorynavigation.data.repository.DependencyRepository;
import com.example.inventorynavigation.data.repository.SeccionesRepository;

import java.util.List;

public class EditSeccionesFragment extends Fragment {


    Spinner spinner;
    EditText editText;
    Button button;
    List<Dependency> list;
    DependencyRepository repository = new DependencyRepository();
    SeccionesRepository seccionesRepository = new SeccionesRepository();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_secciones, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinner = view.findViewById(R.id.sp_secciones);
        editText = view.findViewById(R.id.edtSecciones);
        button = view.findViewById(R.id.btAddSecciones);
        list = repository.get();



        ArrayAdapter<Dependency> adapter = new ArrayAdapter<Dependency>(getContext(),  android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAdd();
            }
        });




    }

    private void validateAdd() {
        if(editText.toString().isEmpty())
            editText.setError("No puede estar vacio");
        else{
            Bundle bundle = new Bundle();
            bundle.putSerializable("estanteria",new Estanteria(editText.getText().toString(),(Dependency)spinner.getSelectedItem()));
            bundle.putBoolean("ConfirmAdd",true);
            NavHostFragment.findNavController(this).navigate(R.id.action_editSeccionesFragment_to_listSeccionesFragment,bundle);
        }

    }
}
