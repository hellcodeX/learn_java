package com.vlad.FileIO.Serialization;

import java.io.Serial;
import java.io.Serializable;

/* Settings -> Editor -> Inspections -> Java -> Serialization Issues ->
    -> Serializable class without SerialVersionUID */

public class SerialVersionUID implements Serializable {
    /* Если класс был модифицирован после сериализации объекта, а сохраненный объект в файле старой версии класса,
     *  при десериализации возникнет ошибка. Во ее избежание, IDE генерируется поле serialVersionUID, которое следует
     *  модифицировать после изменения класса. Таком образом, при несоответствии сохраненного объекта, нынешней
     *  версии класса, возникнет понятная ошибка, уведомляющая о случившимся. */
    @Serial
    private static final long serialVersionUID = -8459406818711158223L;

    private int id;
    private String name;
}
