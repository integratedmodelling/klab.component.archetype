package ${package};

import org.integratedmodelling.klab.api.actors.RuntimeAgent;
import org.integratedmodelling.klab.api.services.runtime.extension.Actor;
import org.integratedmodelling.klab.api.services.runtime.extension.AgentAdapter;
import org.integratedmodelling.klab.api.services.runtime.extension.Library;
import org.integratedmodelling.klab.api.services.runtime.extension.Verb;

/** Example k.Actors extension library. */
@Library(name = "${artifactId}.agents", description = "Agents supplied by ${artifactId}")
public class ExampleAgents {

  @Actor(name = "${artifactId}.Example", description = "Example component-backed agent")
  public static class ExampleAgent {

    @AgentAdapter
    public static Object adapt(Object source, RuntimeAgent.Scope scope) {
      return source;
    }

    @Verb(name = "describe", description = "Describe the adapted agent", returns = String.class)
    public static String describe(Object agent) {
      return String.valueOf(agent);
    }
  }
}
