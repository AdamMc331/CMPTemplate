import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.apollo.graphql)
    alias(libs.plugins.cash.sqldelight)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

dependencies {
    androidRuntimeClasspath(libs.jetbrains.compose.ui.tooling)
}

kotlin {
    android {
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()

        namespace = "template.shared"

        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }

        androidResources {
            enable = true
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = false
        }
    }

    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.datastore.preferences)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.apollo.runtime)
            implementation(libs.cash.sqldelight.coroutines)
            implementation(libs.cash.sqldelight.runtime)
            implementation(libs.coil.compose)
            implementation(libs.coil.ktor)
            implementation(libs.compose.material3.adaptive)
            implementation(libs.jetbrains.compose.components.resources)
            implementation(libs.jetbrains.compose.foundation)
            implementation(libs.jetbrains.compose.material.icons.extended)
            implementation(libs.jetbrains.compose.material3)
            implementation(libs.jetbrains.compose.runtime)
            implementation(libs.jetbrains.compose.ui)
            implementation(libs.jetbrains.compose.ui.tooling.preview)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
        }

        androidMain.dependencies {
            implementation(libs.cash.sqldelight.android.driver)
            implementation(libs.ktor.client.android)
        }

        iosMain.dependencies {
            implementation(libs.cash.sqldelight.native.driver)
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.google.testparameterinjector)
            implementation(libs.koin.test)
        }

        targets.configureEach {
            val isAndroidTarget = platformType == KotlinPlatformType.androidJvm
            compilations.configureEach {
                compileTaskProvider.configure {
                    compilerOptions {
                        if (isAndroidTarget) {
                            freeCompilerArgs.addAll(
                                "-P",
                                "plugin:org.jetbrains.kotlin.parcelize:additionalAnnotation" +
                                    "=template.shared.Parcelize",
                            )
                        }
                    }
                }
            }
        }
    }
}

compose.resources {
    publicResClass = false
    packageOfResClass = "template.shared"
    generateResClass = auto
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("template.shared")
        }
    }
}

// NOTE: Replace the template schema.json with the schema for your apollo api.
apollo {
    service("service") {
        packageName.set("template.shared")
    }
}

tasks.withType<FormatTask> {
    exclude { it.file.path.contains("build/")}
}

tasks.withType<LintTask> {
    exclude { it.file.path.contains("build/")}
}
