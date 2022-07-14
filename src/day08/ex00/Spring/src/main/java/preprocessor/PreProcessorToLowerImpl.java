package preprocessor;

import java.util.Locale;

public class PreProcessorToLowerImpl implements PreProcessor {
    @Override
    public String processing(String message) {
        return message.toLowerCase();
    }
}
