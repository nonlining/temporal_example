// @@@SNIPSTART hello-world-project-template-java-activity
package helloworldapp;

public class FormatImpl implements Format {

    @Override
    public String composeGreeting(String name) {
        return "Hello " + name + "!";
    }

    @Override
    public String AnotherGreeting(String name) {
        return "Hello " + name + " A!";
    }

    @Override
    public String OtherGreeting(String name) {
        return "Hello " + name + " B!";
    }
}
// @@@SNIPEND
