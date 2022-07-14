package renderer;

import preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {

    private final PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void rendering(String message) {
        System.err.println(preProcessor.processing(message));
    }
}
