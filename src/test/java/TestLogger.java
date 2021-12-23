import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestLogger implements TestWatcher {

    Log log = new Log();
    String methodName;

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        methodName = context.getDisplayName();
        log.warn(methodName + " ---> " + "DISABLED!" + " ---> " + reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        methodName = context.getDisplayName();
        log.info(methodName + " ---> " + "PASSED!" );
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        methodName = context.getDisplayName();
        log.warn(methodName + " ---> " + "ABORTED!" + " --->" + cause.getMessage());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        methodName = context.getDisplayName();
        String testCause = cause.getMessage();
        log.error(methodName + " ---> " + "FAILED!" + " ---> " + testCause);
    }
}
