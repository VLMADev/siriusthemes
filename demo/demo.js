// Однострочный комментарий
/* 
   Многострочный комментарий 
*/

// Переменные
let name = "VLMADev";
const version = 1.2;
let isActive = true;

// Функции
function greet(user) {
    if (user) {
        console.log(`Привет, ${user}! 🚀`);
    } else {
        console.warn("Пользователь не найден");
    }
}

// Объекты и массивы
const settings = {
    theme: "Sirius",
    features: ["Dark Mode", "Light Mode", "Syntax Highlighting"]
};

// Ошибки
try {
    throw new Error("Ошибка в теме!");
} catch (error) {
    console.error("Ошибка:", error.message);
}

