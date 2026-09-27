package ${package};

import org.integratedmodelling.klab.api.services.reasoner.Authority;

/** Example authority provider. Add resolution and search methods for the provider contract. */
@Authority(urn = "${artifactId}.authority", embeddable = true)
public class ExampleAuthority {}
