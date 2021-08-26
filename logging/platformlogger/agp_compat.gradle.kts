val configuration = project.configurations.getByName("detektAndroidDebugUnitTest")
val artifactType = Attribute.of("artifactType", String::class.java)
// Some plugin can only work with configurations, while the Android Gradle Plugin (AGP) has the newer "artifact view"
// paradigm implemented. This makes it impossible to resolve most of the created, variant-aware
// configurations from AGP "by hand" without getting unmatched attribute exceptions.
// We now pick one artifact that holds our dependencies and add a custom compatibility rule
// for it which basically accepts all incoming compatibility issues as long as the produced value
// on "the other side" is a JAR or AAR artifact.
configuration.attributes {
    attribute(artifactType, "android-classes-directory")
}
project.dependencies {
    attributesSchema {
        getMatchingStrategy(artifactType).compatibilityRules.add(AgpCompatibility::class.java)
    }
}
class AgpCompatibility : AttributeCompatibilityRule<String> {
    override fun execute(details: CompatibilityCheckDetails<String>) {
        if (details.consumerValue == "android-classes-directory" &&
            (details.producerValue == "aar" || details.producerValue == "jar")) {
            details.compatible()
        }
    }
}
