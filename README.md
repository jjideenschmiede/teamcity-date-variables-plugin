# TeamCity Date Variables Plugin

This plugin provides date and time-related variables for TeamCity builds. It allows you to access the current date and time components in your build configurations, which can be useful for versioning, naming artifacts, or other time-dependent operations.

---

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="https://github.com/user-attachments/assets/e576a978-8eb9-470d-9690-855a947e5440">
  <img src="[light-image.png](https://github.com/user-attachments/assets/b4fead79-173d-46f9-8767-3a1872de4ef8)" alt="Beschreibung des Bildes">
</picture>

## TeamCity Plugins, YouTrack Apps & more

### J&J Ideenschmiede GmbH - Your Partner for JetBrains Solutions

We are **TeamCity Certified** and **YouTrack Certified** developers, specializing in custom solutions for JetBrains products.

👉🏼 Visit our [website](https://www.jjideenschmiede.de) to learn more about our services.

---

## Features

The plugin adds the following variables to your TeamCity builds:

| Variable                  | Description                                  | Example                   |
|---------------------------|----------------------------------------------|---------------------------|
| `teamcity.date.year`      | Current year                                 | 2023                      |
| `teamcity.date.month`     | Current month (zero-padded)                  | 05                        |
| `teamcity.date.day`       | Current day of month (zero-padded)           | 17                        |
| `teamcity.date.hour`      | Current hour in 24h format (zero-padded)     | 14                        |
| `teamcity.date.minute`    | Current minute (zero-padded)                 | 30                        |
| `teamcity.date.second`    | Current second (zero-padded)                 | 45                        |
| `teamcity.date.timestamp` | Current Unix timestamp (seconds since epoch) | 1684331445                |
| `teamcity.date.iso`       | Current date and time in ISO 8601 format     | 2023-05-17T14:30:45+02:00 |

## Requirements

- TeamCity 2025.03 or later
- Java 8 or later

## Installation

1. Download the latest release from the [releases page](https://github.com/jjideenschmiede/teamcity-date-variables-plugin/releases)
2. Go to the TeamCity Administration area
3. Navigate to Plugins List
4. Click "Upload plugin zip"
5. Select the downloaded zip file
6. Restart TeamCity server

### Examples

#### Setting a build number with date:
```
%env.BUILD_NUMBER%.%teamcity.date.year%%teamcity.date.month%%teamcity.date.day%
```

#### Using in a command line runner:
```
echo "Build created on %teamcity.date.year%-%teamcity.date.month%-%teamcity.date.day% at %teamcity.date.hour%:%teamcity.date.minute%"
```

## Development

This plugin is built using Maven. To build it:

```bash
mvn clean package
```

The resulting plugin zip file will be in the `target` directory.
