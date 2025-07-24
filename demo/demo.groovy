// === Переменные ===
def name = "VLMADev"
def version = 1.2
def isActive = true

// === Списки и мапы ===
def features = ["Dark Mode", "Light Mode", "Syntax Highlighting"]
def settings = [
    theme: "Sirius",
    version: version
]

// === Методы ===
def greetUser = { String name ->
    if (name && isActive) {
        println "Привет, $name! 🚀"
    } else {
        println "Имя не указано или тема не активна"
    }
}

// === Замыкания ===
def multiply = { int x, int y -> x * y }
println "Результат: ${multiply(3, 4)}"

// === DSL-подобный синтаксис ===
def buildTheme = {
    theme {
        name "Sirius"
        version 1.2
        features {
            darkMode true
            lightMode true
        }
    }
}

// === Исключения ===
try {
    if (version < 1.0) {
        throw new Exception("Версия устарела")
    }
} catch (e) {
    println "Ошибка: $e.message"
}

// === Вызов ===
greetUser(name)