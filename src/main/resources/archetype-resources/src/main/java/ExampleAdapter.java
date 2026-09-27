package ${package};

import org.integratedmodelling.klab.api.knowledge.Artifact;
import org.integratedmodelling.klab.api.services.resources.adapters.ResourceAdapter;

/** Example resource adapter. Add annotated lifecycle methods required by the resource type. */
@ResourceAdapter(
    name = "${artifactId}.example",
    description = "Example resource adapter supplied by ${artifactId}",
    version = "${version}",
    type = Artifact.Type.OBJECT,
    embeddable = true)
public class ExampleAdapter {}
