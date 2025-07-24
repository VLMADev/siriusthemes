<?php

/**
 * === Многострочный комментарий ===
 * Это пример PHP-файла для демонстрации подсветки синтаксиса темы
 * @author Vlad (VLMADev)
 * @version 1.0
 */

// === Переменные ===
$name = "VLMADev";
$version = 1.2;
$isActive = true;

// Суперглобальные переменные
$userAgent = $_SERVER['HTTP_USER_AGENT'];
$getQuery = $_GET['id'] ?? 'default';

// Константы
define("MAX_USERS", 100);
const SITE_NAME = "Sirius Theme Demo";

// === Условия ===
if ($isActive && $version > 1.0) {
    echo "<h1>Добро пожаловать, $name!</h1>";
} else {
    echo "Версия устарела или тема не активна.";
}

// === Циклы ===
for ($i = 1; $i <= 5; $i++) {
    echo "<p>Попытка $i</p>";
}

$users = ["Alice", "Bob", "Charlie"];
foreach ($users as $user) {
    echo "Пользователь: $user<br>";
}

// === Функции ===
function formatName(string $name): string
{
    return ucfirst(strtolower($name));
}

echo "Отформатированное имя: " . formatName("vlmadEv");

// === Массивы ===
$settings = [
    "theme" => "Sirius",
    "version" => $version,
    "features" => ["Dark Mode", "Light Mode", "Syntax Highlighting"]
];

print_r($settings);

// === Строки и конкатенация ===
$message = 'Привет, ' . $name . '!';
echo "<p>$message</p>";

// === Классы и объекты ===
class ThemeManager
{
    private $themeName;

    public function __construct(string $themeName)
    {
        $this->themeName = $themeName;
    }

    public function getVersion(): string
    {
        return "v" . rand(1, 9) . "." . rand(0, 9);
    }
}

$manager = new ThemeManager(SITE_NAME);
echo "Текущая тема: " . $manager->getVersion();

// === Работа с файлами ===
if (file_exists("data.txt")) {
    $content = file_get_contents("data.txt");
    echo "<pre>$content</pre>";
} else {
    echo "Файл data.txt не найден.";
}

// === Исключения и ошибки ===
try {
    if ($version < 1.0) {
        throw new Exception("Версия темы устарела!");
    }
} catch (Exception $e) {
    echo "Ошибка: " . $e->getMessage();
}

// === Встроенные функции ===
$numbers = [10, 20, 30, 40, 50];
$sum = array_sum($numbers);
echo "Сумма чисел: $sum";

// === HEREDOC ===
$sql = <<<SQL
SELECT * FROM users
WHERE status = 'active'
ORDER BY name ASC;
SQL;

echo "<code>$sql</code>";

// === NOWDOC ===
$rawText = <<<'TEXT'
Это необработанный текст
С переменными: $name
TEXT;

echo "<pre>$rawText</pre>";

// === Завершение PHP ===

