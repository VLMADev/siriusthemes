/**
 * === JSDoc Комментарий ===
 * Интерфейс пользователя
 * @interface
 */
interface User {
    id: number;
    name: string;
    email?: string;
    isAdmin: boolean;
}

/**
 * === Перечисление (enum) ===
 * Роли пользователя
 */
enum UserRole {
    Admin = "admin",
    Editor = "editor",
    Guest = "guest"
}

/**
 * === Класс с декораторами ===
 * Класс для работы с пользователями
 */
@logClass
class UserService {
    // Статическое свойство
    static readonly API_URL = "https://api.example.com/users ";

    // Приватное свойство
    private users: User[] = [];

    // Конструктор
    constructor(initialUsers: User[] = []) {
        this.users = initialUsers;
    }

    /**
     * === Метод с Generic ===
     * Добавляет нового пользователя
     * @param user - Объект пользователя
     * @returns Обновлённый список пользователей
     */
    addUser<T extends User>(user: T): User[] {
        this.users.push(user);
        return this.users;
    }

    /**
     * === Асинхронный метод ===
     * Загружает пользователей с API
     * @returns Promise<User[]>
     */
    async fetchUsers(): Promise<User[]> {
        try {
            const response = await fetch(UserService.API_URL);
            const data = await response.json();
            return data as User[];
        } catch (error) {
            console.error("Ошибка загрузки пользователей:", error.message);
            return [];
        }
    }

    /**
     * === Метод с перечислением ===
     * Получает роль пользователя
     * @param userId - ID пользователя
     * @returns Роль пользователя
     */
    getUserRole(userId: number): UserRole {
        const user = this.users.find(u => u.id === userId);
        return user?.isAdmin ? UserRole.Admin : UserRole.Guest;
    }
}

/**
 * === Декоратор класса ===
 * Логирует создание класса
 * @param constructor - Конструктор класса
 */
function logClass(constructor: Function) {
    console.log(`Класс "${constructor.name}" создан.`);
}

// === Использование ===
const service = new UserService([
    { id: 1, name: "VLMADev", isAdmin: true }
]);

// Добавление пользователя
service.addUser({ id: 2, name: "John Doe", isAdmin: false });

// Асинхронная загрузка
service.fetchUsers().then(users => {
    console.log("Загруженные пользователи:", users);
});

// Получение роли
console.log("Роль пользователя 1:", service.getUserRole(1));