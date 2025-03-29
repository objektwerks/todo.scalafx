Todo ScalaFx
------------
>Todo ScalaFx app using Os-lib, uPickle and Scala 3.

Build
-----
1. ```sbt clean compile```

Test
----
1. ```sbt clean test```

Assembly
--------
1. ```sbt clean test assembly copyAssemblyJar```

Run
---
1. ```sbt run```

Execute
-------
1. ```java -jar target/scala-3.6.4/todo-scalafx-0.3-SNAPSHOT.jar```
>or:
1. ```java -jar .assembly/todo-scalafx-0.3-SNAPSHOT.jar```

Persistence
-----------
>**Todos** are stored as json files here:
```
~/.todofx/data
```

Logging
-------
>**Log** files are stored here:
```
~/.todo/log
```

Resources
---------
* [Os-Lib Github](https://github.com/com-lihaoyi/os-lib)