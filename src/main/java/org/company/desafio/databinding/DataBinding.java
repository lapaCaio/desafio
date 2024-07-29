package org.company.desafio.databinding;

import org.company.desafio.observer.Observavel;
import org.company.desafio.observer.Observer;

public class DataBinding<Model, View> {
    private Observavel<Model> modelObservavel = new Observavel<>();
    private Observavel<View> viewObservavel = new Observavel<>();

    private Model model;
    private View view;

    public DataBinding(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void configureOneWayBindingFromModelToView() {
        modelObservavel.addObserver(new Observer<Model>() {
            @Override
            public void update(Model obj) {
                // Aqui você pode definir como o model atualiza a view
                // Exemplo: view.setDisplay(obj.toString()); // Se houver um método setDisplay na view
            }
        });
    }

    public void configureOneWayBindingFromViewToModel() {
        viewObservavel.addObserver(new Observer<View>() {
            @Override
            public void update(View obj) {
                // Aqui você pode definir como a view atualiza o model
                // Exemplo: model.setData(obj.toString()); // Se houver um método setData no model
            }
        });
    }

    public void configureTwoWayBinding() {
        configureOneWayBindingFromModelToView();
        configureOneWayBindingFromViewToModel();
    }

    public void updateModel(Model novoModel) {
        model = novoModel;
        modelObservavel.notificaObservers(model);
    }

    public void updateView(View novaView) {
        view = novaView;
        viewObservavel.notificaObservers(view);
    }
}
