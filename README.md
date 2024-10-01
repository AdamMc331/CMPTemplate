:construction: <h2> UNDER CONSTRUCTION </h2> :construction:

This is an in progress template repo for a Compose Multiplatform application. The README will be updated last, so if you are reading this, you are using the template at your own risk.

# Compose Multiplatform Template

This is a GitHub template repository intended to kickstart development on a Compose Multiplatform application. This project comes set with a handful of tools that [Adam](https://github.com/AdamMc331) finds important and relevant to every project. If you think something is missing, or feel strongly that a setup should be changed, please submit an [Issue](https://github.com/AdamMc331/CMPTemplate/issues/new).

## Why This Template?

The purpose of this template is to avoid any opinions on writing code. The developers should have the freedom to choose their own architecture, third party dependencies, package structure, and more. 

This template _is_ opinionated about developer tooling. Dependency management is configured, git hooks are defined, code formatting and static analysis are all there, and it even has pull request templates. The purpose of this repo is to help you get started building your next project with confidence in your code, and not telling you how to write it. 

## Walkthrough

If you'd like a video walk through of this template and all it has to offer, you can find that on YouTube. 

// TODO: Adam to record walkthrough for this template.

## Using This Template

To use this template in your own project, click the "Use this template" button at the top right of the repository. Once you do, a repository will be created for your account that you can clone and use on your device.

To setup this repository to your needs, open the [setup.gradle](buildscripts/setup.gradle) file 
and tweak the `renameConfig` block to your needs. After that, you can run the `renameTemplate` 
gradle task to have the app module's package name and relevant strings replaced.

In addition, it will clean up the relevant setup files and workflows that are specific to this template, it should not require any manual deletion work on your part.

## What's Included

A number of third party dependencies are included in this template. They are also documented inside the [documentation folder](/documentation). The files inside this documentation folder are written in such a way that you can keep them in your real project, to let team members read up on why dependencies are included and how they work.

The dependencies in the template include:

* [Ktlint](/documentation/StaticAnalysis.md) for formatting.
* [Detekt](/documentation/StaticAnalysis.md) for code smells.
* [Git Hooks](/documentation/GitHooks.md) for automatically perform static analysis checks. 
* [Gradle Versions Plugin](/documentation/VersionsPlugin.md) for checking all dependencies for new versions.
* [GitHub Actions](/documentation/GitHubActions.md) for running continuous integration and ensuring code quality with every PR.
* [LeakCanary](https://square.github.io/leakcanary/) for detecting memory leaks.
* [Paparazzi](https://github.com/cashapp/paparazzi) for snapshot testing, which can be removed via setup.gradle if necessary.
* [SQLDelight](https://cashapp.github.io/sqldelight/2.0.2/multiplatform_sqlite/) for local databases, which can be removed via setup.gradle if necessary.
* [Multiplatform Settings](https://github.com/russhwolf/multiplatform-settings) for local Key-Value storage, which can be removed via setup.gradle if necessary.
* [Ktor](https://ktor.io/docs/client-create-multiplatform-application.html) for networking, which can be removed via setup.gradle if necessary.

### Danger

This template uses [Danger](https://danger.systems) which will perform some checks against our 
pull requests. You can find the list of checks in the [Dangerfile](Dangerfile). In addition, we 
have a GitHub Actions workflow for Danger checks. In order for that to work properly, you'll 
need to give Danger permission to comment on your repository.

You can do so by navigating to Repository Settings -> Actions -> General, scroll down to `Workflow Permissions`
and set the permissions to read and write. 

### Templates

There are also templates within this template. This repo comes shipped with a [Pull Request Template](/.github/pull_request_template.md) that will help you and your team write organized and detailed pull request descriptions. 

## Dependency Setup

You may notice that dependencies are set up in a very specific way. Each of the tools has its own Gradle file in the [buildscripts folder](/buildscripts). This is by design so that if you chose to have a multi module project, these dependencies can easily be shared between them. This is already configured inside our root `build.gradle.kts` file, by applying to each sub project:

```groovy
subprojects {
    apply from: "../buildscripts/detekt.gradle"
    apply from: "../buildscripts/versionsplugin.gradle"
}
```

In addition, all of the app module dependencies are defined using a gradle version catalog, found in this [toml](gradle/libs.versions.toml) file.
