# k.LAB component Maven archetype

This project provides the Maven archetype used to start a k.LAB component. Generated projects
follow the component and packaging conventions demonstrated by `klab.component.generators` and
`klab.component.geospatial`.

The generated project always contains the required `KlabComponent` plug-in entry point and may
independently include starter code for:

- a `@Library` with a `@KlabFunction` service/contextualizer;
- a k.Actors `@Actor` with a `@Verb` and `@AgentAdapter`;
- a `@ResourceAdapter`;
- `@Importer` and `@Exporter` schemata;
- a reasoner `@Authority`.

## Build and test

```shell
mvn clean verify
```

The integration tests generate both a full component and a minimal component, compile them, and
verify that conditional source files are present or absent as requested.

## Generate a component

Install this SNAPSHOT locally while developing the archetype:

```shell
mvn clean install
```

Then run:

```shell
mvn archetype:generate \
  -DarchetypeGroupId=org.integratedmodelling \
  -DarchetypeArtifactId=klab.component.archetype \
  -DarchetypeVersion=1.0.0-SNAPSHOT \
  -DgroupId=org.example \
  -DartifactId=klab.component.example \
  -Dversion=1.0.0-SNAPSHOT \
  -Dpackage=org.example.klab.component \
  -DinteractiveMode=false
```

All extension switches default to `true`. Set any of `includeLibrary`, `includeAgents`,
`includeAdapter`, `includeIO`, or `includeAuthority` to `false` to omit that starter. See
`klab-services/docs/MAVEN.md` for the complete property reference and release workflow.

## Publishing

The POM uses the same Sonatype Central snapshot and release endpoints as the other k.LAB Maven
artifacts. Deployment credentials are read from the `ossrh` server in the user's Maven settings;
they are never stored in this project.
