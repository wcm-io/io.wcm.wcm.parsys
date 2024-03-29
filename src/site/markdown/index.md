## About WCM Parsys

AEM paragraph system based on path configuration in page components.

[![Maven Central](https://img.shields.io/maven-central/v/io.wcm/io.wcm.wcm.parsys)](https://repo1.maven.org/maven2/io/wcm/io.wcm.wcm.parsys/)


### Documentation

* [Usage][usage]
* [API documentation][apidocs]
* [Changelog][changelog]


### Overview

The wcm.io can be used in AEM in the same way the AEM-builtin paragraph system is used, and is supported by the Touch UI and Classic UI edit modes in the same fashion.

Differences to the AEM-builtin paragraph system:

* It does not use the design mode to configure the allowed components. Instead the metadata that described which components are allowed in which template at which position is stored as nodes in the page components and delivered together with the application.
* Allowed components can be defined based on path patterns and parent component relations.
* Additional rules for allowing or denying components can be provided via OSGi factory configurations.
* Via properties it is possible to change the decoration markup and CSS classes of the paragraph and paragraph items.
* This parsys does not support column controls or iparsys inheritance, it is only a simple paragraph system which allows full control about the markup generated for the child resources and the new area.
* Written in Sightly.


### AEM Version Support Matrix

|WCM Parsys version |AEM version supported
|-------------------|----------------------
|1.7.4 or higher    |AEM 6.5.17+, AEMaaCS
|1.7.0 - 1.7.2      |AEM 6.5.7+, AEMaaCS
|1.6.x              |AEM 6.4.5+, AEMaaCS
|1.4.x - 1.5.x      |AEM 6.3.3+, AEM 6.4.5+
|1.2.x - 1.3.x      |AEM 6.2+
|1.0.x - 1.1.x      |AEM 6.1+
|0.x                |AEM 6.0+


### Dependencies

To use this module you have to deploy also:

|---|---|---|
| [wcm.io Sling Commons](https://repo1.maven.org/maven2/io/wcm/io.wcm.sling.commons/) | [![Maven Central](https://img.shields.io/maven-central/v/io.wcm/io.wcm.sling.commons)](https://repo1.maven.org/maven2/io/wcm/io.wcm.sling.commons/) |
| [wcm.io AEM Sling Models Extensions](https://repo1.maven.org/maven2/io/wcm/io.wcm.sling.models/) | [![Maven Central](https://img.shields.io/maven-central/v/io.wcm/io.wcm.sling.models)](https://repo1.maven.org/maven2/io/wcm/io.wcm.sling.models/) |
| [wcm.io WCM Commons](https://repo1.maven.org/maven2/io/wcm/io.wcm.wcm.commons/) | [![Maven Central](https://img.shields.io/maven-central/v/io.wcm/io.wcm.wcm.commons)](https://repo1.maven.org/maven2/io/wcm/io.wcm.wcm.commons/) |


### GitHub Repository

Sources: https://github.com/wcm-io/io.wcm.wcm.parsys


[usage]: usage.html
[apidocs]: apidocs/
[changelog]: changes-report.html
