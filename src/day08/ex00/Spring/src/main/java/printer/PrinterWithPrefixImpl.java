package printer;

import renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {

    private final Renderer renderer;
    private String prefix;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void print(String message) {
        renderer.rendering(prefix + " " + message);
    }
}
