Todo ScalaFx
------------
>Todo ScalaFx app using MainArgs, Os-lib, uPickle and Scala 3.

Build
-----
1. ```sbt clean compile```

Test
----
1. ```sbt clean test```

Assembly
--------
1. ```sbt clean test assembly```

Run
---
1. ```sbt run```

Execute
-------
1. ```java -jar target/scala-3.7.0-RC1/todo-scalafx-0.1-SNAPSHOT.jar```

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