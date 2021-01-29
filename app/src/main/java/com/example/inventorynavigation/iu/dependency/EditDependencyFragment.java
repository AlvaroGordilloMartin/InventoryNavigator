package com.example.inventorynavigation.iu.dependency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.inventorynavigation.R;
import com.example.inventorynavigation.data.model.Dependency;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class EditDependencyFragment extends Fragment implements EditDependencyContract.View{

    private EditDependencyContract.Presenter presenter;

    private TextInputLayout tilName;
    private TextInputLayout tilShortName;
    private TextInputLayout tilDescription;
    private TextInputLayout tilIrlImage;

    private TextInputEditText tieName;
    private TextInputEditText tieShortName;
    private TextInputEditText tieDescription;
    private TextInputEditText tieIrlImage;

    private Button btGuardar;

    private Bundle bundle;
    public EditDependencyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new EditDependencyPresenter(this);

        tilName = view.findViewById(R.id.tilName);
        tilDescription = view.findViewById(R.id.tilDescription);
        tilShortName = view.findViewById(R.id.tilShortName);
        tilIrlImage = view.findViewById(R.id.tilIrlImage);

        tieName = view.findViewById(R.id.tieName);
        tieShortName = view.findViewById(R.id.tieShortName);
        tieDescription = view.findViewById(R.id.tieDescription);
        tieIrlImage = view.findViewById(R.id.tieIrlImage);

        btGuardar = view.findViewById(R.id.btGuardar);

        bundle = getArguments();

        final Dependency dependency = (Dependency) bundle.getSerializable(Dependency.TAG);


        if (dependency!=null)
            haveDepemdencyToEdit(dependency);
        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dependency save = new Dependency();
                save.setName(tieName.getText().toString());
                save.setShortname(tieShortName.getText().toString());
                save.setDescription(tieDescription.getText().toString());
                save.setUrlImage(tieIrlImage.getText().toString());

                if (tilShortName.isEnabled())
                    presenter.furtherDependency(save);
                else
                    presenter.editDepedency(save);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_dependency, container, false);
    }

    @Override
    public void setShortNameExists() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onSuccess(List<Dependency> list) {

    }
    private void haveDepemdencyToEdit(Dependency edit){
        tieName.setText(edit.getName());
        tieDescription.setText(edit.getDescription());
        tieIrlImage.setText(edit.getUrlImage());
        tieShortName.setText(edit.getShortname());
        tilShortName.setEnabled(false);
    }
}