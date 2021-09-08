package com.vlad.enum_example;

/* Название enum всегда должно быть в единственном числе.
  DOG, CAT, FROG - имена объектов.
  Благодаря тому что DOG, CAT, FROG являются объектами, можно создать конструктор.
  Конструкторы делаются приватными, поскольку нам не нужно получить к ним доступ извне. По умолчанию
  конструктор приватный. Enum может содержать поля и методы. */
public enum Animal {
    DOG("Собака"), CAT("Кот"), FROG("Лягушка");

    private String translation;
    // У каждого объекта класса Animal есть поле translation.

    private Animal(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    @Override
    public String toString() {
        return "Перевод на рус. язык: " + translation;
    }
}
