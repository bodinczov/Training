package org.training.patterns;

interface Button {
    void render();
}
interface Checkbox {
    void render();
}
class WinButton implements Button {
    public void render() {
        System.out.println("Windows Button");
    }
}
class MacButton implements Button {
    public void render() {
        System.out.println("Mac Button");
    }
}
class WinCheckbox implements Checkbox {
    public void render() {
        System.out.println("Windows Checkbox");
    }
}
class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Mac Checkbox");
    }
}
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}
class MacFactory implements GUIFactory {
    public Button createButton(){
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.render();
    }
}
