/**
 * === Javadoc комментарий ===
 * Основной класс для демонстрации синтаксиса Java
 * 
 * @author Vlad (VLMADev)
 * @version 1.2
 */
public class ThemeDemo {
    // === Константы и переменные ===
    private static final String themeName = "Sirius";
    private boolean isActive = true;

    // === Статический блок инициализации ===
    static {
        System.out.println("Класс ThemeDemo загружен");
    }

    // === Перечисление (enum) ===
    /**
     * Роли пользователя
     */
    public enum UserRole {
        ADMIN("admin"),
        EDITOR("editor"),
        GUEST("guest");

        private final String role;

        UserRole(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }
    }

    // === Функциональный интерфейс ===
    @FunctionalInterface
    public interface ThemeProcessor {
        String process(String input);
    }

    // === Лямбда-выражение ===
    ThemeProcessor themeStyler = (input) -> {
        return "Styled: " + input.toUpperCase();
    };

    // === Методы с Generics ===
    public <T> void logFeature(T feature) {
        System.out.println("Фича: " + feature);
    }

    // === Метод с аннотацией ===
    @Override
    public String toString() {
        return "ThemeDemo{" +
                "themeName='" + themeName + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    // === Внутренний класс ===
    public class ThemeSettings {
        private String version;

        public ThemeSettings(String version) {
            this.version = version;
        }

        public void display() {
            System.out.println("Тема: " + themeName + ", Версия: " + version);
        }
    }

    // === Метод с исключениями ===
    public void validateVersion(double version) throws IllegalArgumentException {
        if (version < 1.0) {
            throw new IllegalArgumentException("Версия устарела: " + version);
        }
    }

    // === Try-with-resources ===
    public void readLog() {
        try (var reader = new java.io.StringReader("Demo log message")) {
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (java.io.IOException e) {
            System.err.println("Ошибка чтения: " + e.getMessage());
        }
    }

    // === Main метод ===
    public static void main(String[] args) {
        ThemeDemo demo = new ThemeDemo();

        // === Использование перечисления ===
        UserRole role = UserRole.ADMIN;
        System.out.println("Роль пользователя: " + role.getRole());

        // === Generics и лямбда ===
        demo.logFeature("Dark Mode");
        demo.logFeature(1.2);
        System.out.println(demo.themeStyler.process("Sirius Theme"));

        // === Внутренний класс ===
        ThemeDemo.ThemeSettings settings = demo.new ThemeSettings("v1.2");
        settings.display();

        // === Обработка исключений ===
        try {
            demo.validateVersion(0.9);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // === Try-with-resources ===
        demo.readLog();
    }
}