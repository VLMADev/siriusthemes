#include <iostream>
#include <vector>
#include <memory>

// === Макросы ===
#define THEME_NAME "Sirius"

// === Классы ===
class Theme {
private:
    std::string name;
    float version;

public:
    Theme(const std::string& name, float version)
        : name(name), version(version) {}

    void activate() const {
        std::cout << "Тема " << name << " активирована (v" << version << ")" << std::endl;
    }
};

// === Шаблоны ===
template<typename T>
T max(T a, T b) {
    return (a > b) ? a : b;
}
int main() {
    // === Умные указатели ===
    auto theme = std::make_unique<Theme>("Sirius", 1.2f);
    theme->activate();

    // === STL контейнеры ===
    std::vector<std::string> features = {"Dark Mode", "Light Mode", "Syntax Highlighting"};
    for (const auto& feature : features) {
        std::cout << "- " << feature << std::endl;
    }

    // === Исключения ===
    try {
        if (theme == nullptr) {
            throw std::runtime_error("Тема не найдена");
        }
    } catch (const std::exception& e) {
        std::cerr << "Ошибка: " << e.what() << std::endl;
    }

    // === Шаблоны ===
    std::cout << "Максимум: " << max(10, 20) << std::endl;

    return 0;
}