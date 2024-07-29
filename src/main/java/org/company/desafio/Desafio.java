package org.company.desafio;

import org.company.desafio.model.Model;
import org.company.desafio.view.View;
import org.company.desafio.presenter.Presenter;

public class Desafio {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Presenter presenter = new Presenter(model, view);

        // Atualizando o modelo e visualização
        presenter.updateModelData("Novo dado do modelo");
        presenter.updateViewDisplay("Nova visualização");

        System.out.println("Modelo: " + model.getData());
        System.out.println("Visualização: " + view.getDisplay());
    }
}
