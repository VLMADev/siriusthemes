package main

import (
    "fmt"
    "errors"
)

// === Константы и переменные ===
const ThemeName = "Sirius"
var version = 1.2

// === Структура ===
type User struct {
    ID       int
    Name     string
    IsActive bool
}

// === Функция ===
func greetUser(name string) error {
    if name == "" {
        return errors.New("имя не указано")
    }
    fmt.Printf("Привет, %s! 🚀\n", name)
    return nil
}

func main() {
    // === Условия и циклы ===
    if version > 1.0 {
        fmt.Println("Тема активна")
    }

    users := []User{
        {ID: 1, Name: "VLMADev", IsActive: true},
        {ID: 2, Name: "GoDev", IsActive: false},
    }

    for _, user := range users {
        if err := greetUser(user.Name); err != nil {
            fmt.Println("Ошибка:", err)
        }
    }

    // === Горутина и канал ===
    ch := make(chan string)
    go func() {
        ch <- "Сообщение из горутины"
    }()
    fmt.Println(<-ch)
}