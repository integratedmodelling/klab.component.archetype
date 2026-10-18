package ${package};

import java.util.List;
import org.integratedmodelling.klab.api.collections.Pair;
import org.integratedmodelling.klab.api.services.Authority;

/** Starter provider: implement a validated vocabulary before enabling configuration. */
@org.integratedmodelling.klab.api.services.reasoner.Authority(
    urn = "${artifactId}.authority", version = "${version}", embeddable = true)
public final class ExampleAuthority implements Authority {
  public static final String URN = "${artifactId}.authority";
  public ExampleAuthority() {}
  @Override public String getUrn() { return URN; }
  @Override public String configure(ConfigurationRequest request) {
    // Retain independent state per bridge and validate all provider parameters.
    throw new UnsupportedOperationException("Implement authority configuration before enabling this starter");
  }
  @Override public Identity resolveIdentity(String configurationId, String identityId) {
    throw new UnsupportedOperationException("Implement canonical identity lookup and error diagnostics");
  }
  @Override public List<Identity> search(String query, String subAuthority, String configurationId) {
    throw new UnsupportedOperationException("Search is not advertised by this starter");
  }
  @Override public Authority subAuthority(String catalog) {
    throw new IllegalArgumentException("No sub-authorities are declared");
  }
  @Override public Capabilities getCapabilities() {
    return new Capabilities() {
      @Override public String getDescription() { return "Unimplemented authority starter"; }
      @Override public boolean isSearchable() { return false; }
      @Override public boolean isFuzzy() { return false; }
      @Override public List<Pair<String, String>> getSubAuthorities() { return List.of(); }
      @Override public List<String> getDocumentationFormats() { return List.of(); }
      @Override public String getWorldview() { return null; }
    };
  }
}
