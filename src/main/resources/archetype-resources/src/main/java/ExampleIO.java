package ${package};

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.integratedmodelling.klab.api.knowledge.KlabAsset;
import org.integratedmodelling.klab.api.scope.Scope;
import org.integratedmodelling.klab.api.services.resources.adapters.Exporter;
import org.integratedmodelling.klab.api.services.resources.adapters.Importer;
import org.integratedmodelling.klab.api.services.runtime.extension.Library;

/** Example transport schemata. Replace the placeholder URN and payload logic. */
@Library(name = "${artifactId}.io", description = "Import and export schemata for ${artifactId}")
public class ExampleIO {

  @Importer(
      schema = "example.import",
      knowledgeClass = KlabAsset.KnowledgeClass.RESOURCE,
      mediaType = "text/plain",
      fileExtensions = {"txt"},
      description = "Import an example text resource")
  public String importResource(InputStream input, Scope scope) throws IOException {
    input.readAllBytes();
    throw new UnsupportedOperationException("Create and return the imported resource URN");
  }

  @Exporter(
      schema = "example.export",
      knowledgeClass = KlabAsset.KnowledgeClass.RESOURCE,
      mediaType = "text/plain",
      fileExtensions = {"txt"},
      description = "Export an example text resource")
  public InputStream exportResource(Scope scope) {
    return new ByteArrayInputStream("Replace this export".getBytes(StandardCharsets.UTF_8));
  }
}
