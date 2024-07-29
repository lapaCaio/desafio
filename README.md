# Documentação do Projeto

## 1. Arquitetura do Projeto

### 1.1 Descrição Geral

O projeto é uma implementação de um módulo de data binding utilizando o padrão Observer, integrado ao padrão MVP (Model-View-Presenter) com a abordagem Passive View. A arquitetura do sistema é dividida em três principais componentes:

- **Model**: Representa os dados e a lógica de aplicação.
- **View**: Responsável pela exibição dos dados e interação com o usuário.
- **Presenter**: Coordena a comunicação entre o Model e a View, utilizando o módulo de data binding para facilitar a sincronização entre ambos.

### 1.2 Componentes do Projeto

- **Model**: Armazena os dados e fornece métodos para acessar e modificar esses dados. Exemplo: `Model.java`.
- **View**: Exibe os dados ao usuário e captura a entrada do usuário. Exemplo: `View.java`.
- **Presenter**: Gerencia a lógica de apresentação e atualiza o Model e a View conforme necessário. Exemplo: `Presenter.java`.
- **DataBinding**: Módulo responsável pela sincronização dos dados entre o Model e a View usando o padrão Observer. Exemplo: `DataBinding.java`.
- **Observável e Observer**: Implementam o padrão Observer para notificar mudanças entre Model e View. Exemplos: `Observavel.java` e `Observer.java`.

## 2. Padrão Observer Utilizado

O padrão Observer é utilizado para permitir a comunicação entre o Model e a View sem acoplamento direto entre eles. Os principais componentes são:

### 2.1 Classe Observável

- **Classe**: `Observavel<T>`
- **Responsabilidade**: Gerencia uma lista de observadores e notifica-os sobre mudanças no estado do objeto observado.
- **Métodos**:
    - `addObserver(Observer<T> observer)`: Adiciona um observador à lista de observadores.
    - `removeObserver(Observer<T> observer)`: Remove um observador da lista de observadores.
    - `notificaObservers(T obj)`: Notifica todos os observadores sobre uma mudança.

### 2.2 Interface Observer

- **Interface**: `Observer<T>`
- **Responsabilidade**: Define o método `update(T obj)` que é chamado quando há uma atualização no objeto observado.
- **Método**:
    - `void update(T obj)`: Recebe a notificação de mudança do objeto observado.

## 3. Configurações de Data Binding Suportadas

### 3.1 One-Way Binding (Unidirecional)

- **Model para View**:
    - **Descrição**: Atualiza a View automaticamente quando o Model muda.
    - **Configuração**: Utiliza o método `configureOneWayBindingFromModelToView()` da classe `DataBinding`.
    - **Exemplo**: Quando o `Presenter` atualiza o `Model`, a `View` é automaticamente atualizada para refletir a nova informação.

- **View para Model**:
    - **Descrição**: Atualiza o Model automaticamente quando a View muda.
    - **Configuração**: Utiliza o método `configureOneWayBindingFromViewToModel()` da classe `DataBinding`.
    - **Exemplo**: Quando o usuário modifica os dados na `View`, o `Model` é atualizado para refletir as mudanças.

### 3.2 Two-Way Binding (Bidirecional)

- **Descrição**: Sincroniza mudanças entre Model e View em ambas as direções.
- **Configuração**: Utiliza o método `configureTwoWayBinding()` da classe `DataBinding`.
- **Exemplo**: Mudanças no `Model` são refletidas na `View` e vice-versa. Se o `Model` é atualizado, a `View` reflete essa mudança e, se a `View` é modificada, o `Model` é atualizado.

## 4. Exemplos de Integração com o Padrão MVP - Passive View

### 4.1 Exemplo de One-Way Binding (Model para View)

#### Código: `Presenter.java`

```java
public class Presenter {
    private Model model;
    private View view;
    private DataBinding<Model, View> dataBinding;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
        dataBinding = new DataBinding<>(model, view);
        dataBinding.configureOneWayBindingFromModelToView();
    }

    public void updateModelData(String newData) {
        model.setData(newData);
        dataBinding.updateModel(model);
    }
}
```

### 4.2 Exemplo de Two-Way Binding

#### Código: `Presenter.java`

```java
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

```
## Descrição

O `Presenter` configura o binding bidirecional entre `Model` e `View`. As mudanças no `Model` são refletidas na `View` e as mudanças na `View` são refletidas no `Model`. O método `updateModelData` atualiza o `Model` e a `View` é atualizada automaticamente. O método `updateViewDisplay` atualiza a `View` e o `Model` é atualizado automaticamente.



