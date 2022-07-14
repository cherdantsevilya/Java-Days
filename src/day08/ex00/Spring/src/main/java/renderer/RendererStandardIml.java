package renderer;

import preprocessor.PreProcessor;

public class RendererStandardIml implements Renderer {

    PreProcessor preProcessor;

    public RendererStandardIml(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void rendering(String message) {
        System.out.println(preProcessor.processing(message));
    }
}
