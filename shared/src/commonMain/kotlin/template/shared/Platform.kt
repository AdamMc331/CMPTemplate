package template.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
