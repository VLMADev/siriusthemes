# Однострочный комментарий
"""
Многострочный комментарий
"""

# Переменные
name = "VLMADev"
version = 1.2
active = True

# Функции
def greet(user):
    if user:
        print(f"Привет, {user}! 🚀")
    else:
        print("Пользователь не найден")

# Циклы
for i in range(5):
    greet(name + f" (Попытка {i})")

# Исключения
try:
    raise Exception("Ошибка в теме!")
except Exception as e:
    print(f"Ошибка: {e}")