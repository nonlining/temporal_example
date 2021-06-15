// @@@SNIPSTART hello-world-project-template-java-workflow-initiator
package helloworldapp;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import java.util.*;

public class InitiateHelloWorld {

    public static void main(String[] args) throws Exception {

        System.out.println("init Hello World");
        GregorianCalendar gcalendar = new GregorianCalendar();
        int t = (gcalendar.get(Calendar.SECOND));

        String greeting = "";
        // This gRPC stubs wrapper talks to the local docker instance of the Temporal service.
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        // WorkflowClient can be used to start, signal, query, cancel, and terminate Workflows.
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(Shared.HELLO_WORLD_TASK_QUEUE)
                .build();
        // WorkflowStubs enable calls to methods as if the Workflow object is local, but actually perform an RPC.
        HelloWorldWorkflow workflow = client.newWorkflowStub(HelloWorldWorkflow.class, options);
        // Synchronously execute the Workflow and wait for the response.

        if(t%2 == 1){
            greeting = workflow.getGreeting("World", t);
        } else {
            greeting = workflow.getGreeting("World again", t);
        }

        System.out.println(greeting);

        System.exit(0);
    }
}
// @@@SNIPEND
