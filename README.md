# Custom HTML2 Generator Example

This example demonstrates how to create a customized HTML2 generator based on the `StaticHtml2Generator` generator
built into OpenAPI Generator.

This custom generator adds the ability to specify a Google Analytics identifier to inject into the index.html, and also includes a humans.txt file.

# Build the artifact

To build the custom generator, run the following:

```
cd html-generator
./gradlew assemble install
```

This will locally install the artifact `us.jimschubert.examples:html-generator:1.0-SNAPSHOT`.

## Consume it

There is a build file under `consumer` with a valid and invalid spec file. Change into the `consumer` directory to run commands in this section.

To build the custom and built-in HTML2 generators against the valid spec, run the following:

```
./gradlew buildCustomHtml2 && gradle buildOriginalHtml2
```

Outputs are under `build/custom-html/` and `build/html`.

Verify that custom-build includes the Google Analytics tag and identifier:

```
tail -10 build/custom-html/index.html
```

Verify that the Humans text file was created:

```
cat build/custom-html/humans.txt
```

