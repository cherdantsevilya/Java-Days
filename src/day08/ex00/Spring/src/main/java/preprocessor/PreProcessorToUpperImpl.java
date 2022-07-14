package preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String processing(String message) {
        return message.toUpperCase();
    }
}
