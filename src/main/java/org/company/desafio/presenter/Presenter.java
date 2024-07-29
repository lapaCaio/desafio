package org.company.desafio.presenter;

import org.company.desafio.databinding.DataBinding;
import org.company.desafio.model.Model;
import org.company.desafio.view.View;

public class Presenter {
    private Model model;
    private View view;
    private DataBinding<Model, View> dataBinding;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
        dataBinding = new DataBinding<>(model, view);
        dataBinding.configureTwoWayBinding();
    }

    public void updateModelData(String newData) {
        model.setData(newData);
        dataBinding.updateModel(model);
    }

    public void updateViewDisplay(String newDisplay) {
        view.setDisplay(newDisplay);
        dataBinding.updateView(view);
    }
}
