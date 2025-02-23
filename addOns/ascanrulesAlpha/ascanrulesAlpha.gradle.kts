version = "26"
description = "The alpha quality Active Scanner rules"

zapAddOn {
    addOnName.set("Active scanner rules (alpha)")
    zapVersion.set("2.8.0")

    manifest {
        author.set("ZAP Dev Team")
        url.set("https://github.com/zaproxy/zap-extensions/wiki/HelpAddonsAscanrulesAlphaAscanalpha")
        extensions {
            register("org.zaproxy.zap.extension.ascanrulesAlpha.payloader.ExtensionPayloader") {
                classnames {
                    allowed.set(listOf("org.zaproxy.zap.extension.ascanrulesAlpha.payloader"))
                }
                dependencies {
                    addOns {
                        register("custompayloads") {
                            version.set("0.9.*")
                        }
                    }
                }
            }
        }
    }
}

dependencies {
    implementation("org.jsoup:jsoup:1.7.2")
    compileOnly(parent!!.childProjects.get("custompayloads")!!)

    testImplementation(parent!!.childProjects.get("custompayloads")!!)
    testImplementation(project(":testutils"))
}
