package ${package};

import org.integratedmodelling.klab.api.knowledge.Artifact;
import org.integratedmodelling.klab.api.lang.ServiceCall;
import org.integratedmodelling.klab.api.scope.ContextScope;
import org.integratedmodelling.klab.api.services.runtime.extension.KlabFunction;
import org.integratedmodelling.klab.api.services.runtime.extension.Library;

/** Example service library. Replace its public names and implementation before release. */
@Library(
    name = "${artifactId}.services",
    description = "Services and contextualizers supplied by ${artifactId}")
public class ExampleLibrary {

  @KlabFunction(
      name = "example",
      description = "Example contextualizer service",
      type = Artifact.Type.OBJECT)
  public Object contextualize(ServiceCall call, ContextScope scope) {
    throw new UnsupportedOperationException("Implement the example contextualizer");
  }
}
