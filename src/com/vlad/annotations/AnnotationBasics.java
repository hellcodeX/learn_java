package com.vlad.annotations;

public class AnnotationBasics {
    /* Java Аннотации - специальный тип комментариев в коде с помощью которых можно:
    *   - Передавать какие-либо инструкции для Java компилятора
    *   - Передавать какие-либо инструкции для анализаторов исходного кода (пример: инструменты,
    *       которые генерируют документацию из исходного кода)
    *   - Передавать метаданные, которые могут быть использованы либо Java приложением (с помощью
    *       рефлексии), либо другими приложениями или фреймворками (пример: Spring Framework)
    *
    * Что такое метаданные:
    *   - данные о данных
    *   - не влияют на непосредственную работу программы, но могут быть выявлены другими программами
    *       на этапе компилирования или разработки, которые при этом скорректируют свою работу.
    *
    *   Примеры:
    *       - Тег <meta> в HTML, который используется для хранения информации о странице, предназначенной
    *           для браузеров и поисковых систем (ключевые слова например).
    *       - Аннотации в Java, которые дают дополнительную информацию о коде.
    *
    *   В Java могут быть аннотированы класс, метод, параметр, поле и многое другое.
    * Встроенные аннотации которые чаще всего используются: @Override, @Deprecated, @SuppressWarnings.
    * Можно создать свои аннотации.
    *   @Override - не даст скомпилировать программу если мы не переопределяем метод. Например, если
    * программист недоглядел в имени метода, или передаст лишний аргумент, вместо переопределения метода
    *  получит метод с новым именем. Во избежания этой неприятной ситуации следует использовать @Override.
    *   @Deprecated - означает что метод устарел и его лучше не использовать. В IDE имена таких методов
    * зачеркнуты.
    *   @SuppressWarnings - если метод генерирует в консоли предупреждения, эта аннотация их отключит.
    *
    *   Зачем нужны аннотации?:
    *       - Если мы реализуем анализатор исходного кода, мы можем создать свои аннотации, чтобы их можно
    *           было использовать в коде и тем самым передавать дополнительную информацию об этом коде
    *           (те самые метаданные)
    *       - Если мы реализуем свою библиотеку или фреймворк, мы можем создать свои аннотации, чтобы
    *           пользователь с помощью них взаимодействовал с нашей библиотекой или фреймворком.
    *           (например: Spring Framework). В этом сценарии активно используется рефлексия.
    *
    * Пример создания простейшей аннотации:
    *   public @interface MyAnnotation {    }
    *
    * У аннотаций могут быть поля:
    *   public @interface Author {
    *       String name();
    *       int dateOfBirth();
    *   }
    *   Использование:
    *       @MyAnnotation
    *       public class com.vlad.annotations.Test {    }
    *
    * Мы объявляем поля как будто бы сигнатуры методов.
    *   Использование:
    *       @Author(name = "Alex", dateOfBirth = 1950)
    *       public class com.vlad.annotations.Test {   }
    *
    * У полей могут быть значение по умолчанию с ключевым словом default.
    *       public @interface Author {
    *           String name() default "Vitaliy" ;
    *           int dateOfBirth() default 1995;
    *       }
    *
    * Если не указываем значение для поля, оно принимает значение по умолчанию:
    *       @Author()
    *       public class com.vlad.annotations.Test {   }
    *
    * Аннотации аннотирующие аннотации
    *   Лежат в пакете java.lang.annotation.
    *   @Target - указывает, к чему может быть применена аннотация. Значения берутся из перечисления (enum)
    *  ElementType (из того же пакета). В фигурных скобках через запятую можно указать несколько типов.
    * @Target({ElementType.METHOD, ElementType.TYPE})
        *   FIELD - поле
        *   METHOD - метод
        *   TYPE - класс, интерфейс, перечисление
    *   @Retention - политика удержания аннотации (до какого этапа компилирования или выполнения аннотация
    * видна). Значения лежат в перечислении RetentionPolicy.
    *   SOURCE - Отбрасываются при компиляции. Видны только в самом исходном коде (подойдет для анализаторов
    * исходного кода, например)
    *   CLASS - сохраняются в байт-коде, но не доступны во время работы программы (подойдет дя анализаторов
    * байт-кода).
    *   RUNTIME - сохраняются в байт-коде и доступны во время работы программы (с помощью рефлексии)
    *  */
}