// @@@SNIPSTART hello-world-project-template-java-activity-interface
package helloworldapp;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface Format {

    @ActivityMethod
    String composeGreeting(String name);

    @ActivityMethod
    String AnotherGreeting(String name);

    @ActivityMethod
    String OtherGreeting(String name);
}
// @@@SNIPEND
