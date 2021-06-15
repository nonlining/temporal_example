// @@@SNIPSTART hello-world-project-template-java-workflow
package helloworldapp;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;


public class HelloWorldWorkflowImpl implements HelloWorldWorkflow {

    ActivityOptions options = ActivityOptions.newBuilder()
            .setScheduleToCloseTimeout(Duration.ofSeconds(2))
            .build();

    // ActivityStubs enable calls to Activities as if they are local methods, but actually perform an RPC.
    private final Format format = Workflow.newActivityStub(Format.class, options);

    @Override
    public String getGreeting(String name, int time) {
        // This is the entry point to the Workflow.
        // If there were other Activity methods they would be orchestrated here or from within other Activities.

        System.out.println("Starting workflow ");
        System.out.println(time);

        if(time%2 == 1){
            System.out.println(format.AnotherGreeting(name));
        } else {
            System.out.println(format.OtherGreeting(name));
        }

        return format.composeGreeting(name);
    }
}
// @@@SNIPEND
