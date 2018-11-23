package us.jimschubert.examples.generators;

import org.openapitools.codegen.CliOption;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.languages.StaticHtml2Generator;

public class CustomGenerator extends StaticHtml2Generator {
    private static String gaKey = "googleAnalytics";

    @Override
    public String getName() {
        return "custom-html2";
    }

    @SuppressWarnings({"unused"})
    public CustomGenerator() {
        super();
        embeddedTemplateDir = templateDir = "customHtmlDocs2";

        supportingFiles.add(new SupportingFile("humans.mustache", "", "humans.txt"));

        cliOptions.add(new CliOption(gaKey, "Your GA identifier to be injected into the page."));
    }

    @Override
    public void processOpts() {
        super.processOpts();
        String gaIdentifier = additionalProperties.getOrDefault(gaKey, "XXXXX-X").toString();
        if (!gaIdentifier.startsWith("GA-")) {
            gaIdentifier = "GA-" + gaIdentifier;
        }
        additionalProperties.put(gaKey, gaIdentifier);
    }
}
