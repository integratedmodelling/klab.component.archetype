# ${artifactId}

${componentDescription}

This project is a k.LAB component generated with `klab.component.archetype`. Its mandatory PF4J
entry point is `${package}.ComponentPlugin`.

## Build

Use JDK 21 and run:

```shell
mvn clean package
```

The k.LAB packaging plug-in produces the component archive under `target/` with classifier
`component` and type `kar`. Run `mvn install` to make the component available to local k.LAB
services through Maven coordinates, or `mvn deploy` to publish it using the configured `ossrh`
server credentials.

Before publishing, replace the generated project URL and SCM entries if the source repository is
not under the `integratedmodelling` GitHub organization. Add developers and adjust the license
metadata as appropriate. The generated `LICENSE.txt` contains the full GNU Affero General Public
License version 3, matching the default POM metadata.

## Starter extensions

Delete or replace the generated examples as the implementation grows. Extension names are public
and must remain unique across installed components.

The authority starter implements the current `api.services.Authority` contract, has a public
no-argument constructor, and advertises the same URN as its annotation. Its configuration and
resolution operations deliberately throw until a vocabulary is implemented. Add independent
configuration state, canonical identities, diagnostics, and release handling before using it.
Host k.LAB dependencies use `provided` scope. Packaging targets Reasoner, Runtime and Resources.

Build against matching current k.LAB snapshots. An annotation error about missing `urn`, `version`
or `embeddable`, or a required legacy `name`, means the resolved API is older than this template;
refresh or rebuild the k.LAB dependencies rather than changing back to the legacy contract.
