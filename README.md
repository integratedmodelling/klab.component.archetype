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

Use JDK 21. The Maven wrapper pins Maven 3.9.5; on Windows run
`.\mvnw.cmd clean verify` (or `.\mvnw.cmd clean install` to install locally).

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

To use the published snapshot without installing this checkout first, merge this profile into
`~/.m2/settings.xml` (on Windows, `%USERPROFILE%\.m2\settings.xml`). Preserve any existing
servers, credentials, mirrors, and profiles:

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0">
  <profiles>
    <profile>
      <id>klab-snapshots</id>
      <repositories>
        <repository>
          <id>central-portal-snapshots</id>
          <url>https://central.sonatype.com/repository/maven-snapshots/</url>
          <releases><enabled>false</enabled></releases>
          <snapshots><enabled>true</enabled></snapshots>
        </repository>
      </repositories>
      <pluginRepositories>
        <pluginRepository>
          <id>central-portal-snapshots</id>
          <url>https://central.sonatype.com/repository/maven-snapshots/</url>
          <releases><enabled>false</enabled></releases>
          <snapshots><enabled>true</enabled></snapshots>
        </pluginRepository>
      </pluginRepositories>
    </profile>
  </profiles>
  <activeProfiles>
    <activeProfile>klab-snapshots</activeProfile>
  </activeProfiles>
</settings>
```

Then run the generation command above with `mvn -U` from the directory where you want the new
project. No publishing credentials are needed for downloads. In PowerShell, put the command on
one line and quote each `"-Dproperty=value"` argument; the backslashes above are POSIX shell
line continuations. For example:

```powershell
mvn -U org.apache.maven.plugins:maven-archetype-plugin:3.4.1:generate "-DarchetypeGroupId=org.integratedmodelling" "-DarchetypeArtifactId=klab.component.archetype" "-DarchetypeVersion=1.0.0-SNAPSHOT" "-DgroupId=org.example" "-DartifactId=klab.component.example" "-Dversion=1.0.0-SNAPSHOT" "-Dpackage=org.example.klab.component" "-DinteractiveMode=false"
```

The published snapshot changes only after a successful deployment. Local template fixes require
`mvn clean install` to use locally, or a new deployment to reach other machines.

All extension switches default to `true`. Set any of `includeLibrary`, `includeAgents`,
`includeAdapter`, `includeIO`, or `includeAuthority` to `false` to omit that starter. See
`klab-services/docs/MAVEN.md` for the complete property reference and release workflow.

## Publishing

The POM uses the same Sonatype Central snapshot and release endpoints as the other k.LAB Maven
artifacts. Deployment credentials are read from the `ossrh` server in the user's Maven settings;
they are never stored in this project.

`install` only writes to the local Maven repository. Publishing a snapshot requires `mvn deploy`.
Snapshot artifacts are served from
<https://central.sonatype.com/repository/maven-snapshots/>, separately from the Maven Central
release repository. `distributionManagement` configures uploads, not dependency downloads.
Generated projects explicitly configure snapshot dependency and plugin repositories so that
their snapshot parent and `klab.product` plugin can be resolved on a new machine.

Sonatype currently retains snapshots for 90 days. See the
[snapshot documentation](https://central.sonatype.org/publish/publish-portal-snapshots/).
After a missing artifact is published again, use `mvn -U clean install` to retry cached failed
lookups and refresh snapshots. Different cached builds of the same `-SNAPSHOT` version can
expose different APIs; use released versions when reproducible builds are required.
