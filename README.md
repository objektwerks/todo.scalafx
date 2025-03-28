Todo CLI
--------
>Todo command line app using MainArgs, Os-lib, uPickle and Scala 3.

Build
-----
1. ```sbt clean compile```

Test
----
1. ```sbt clean test```

Assembly
--------
1. ```sbt clean test assembly```

Commands
--------
1. ```help```
2. ```list --filter```
3. ```add --todo```
4. ```complete --id```
>The command ```list --filter``` accepts ```all```, ```completed``` and ```incomplete```
* ```list --filter all | completed | incomplete```
>Since the ```list``` default is: ```--filter all```, this also works:
* ```list```

Run
---
1. ```sbt "run list --filter all"```
2. ```sbt "run add --todo drink beer"```
3. ```sbt "run complete --id 1"```
4. ```sbt "run help"```
>```sbt run``` displays the help menu.

Execute
-------
1. ```java -jar target/scala-3.7.0-RC1/todo-cli-0.8-SNAPSHOT.jar list --filter all```
2. ```java -jar target/scala-3.7.0-RC1/todo-cli-0.8-SNAPSHOT.jar add --todo Eat sushi!```
3. ```java -jar target/scala-3.7.0-RC1/todo-cli-0.8-SNAPSHOT.jar complete --id 1```
4. ```java -jar target/scala-3.7.0-RC1/todo-cli-0.8-SNAPSHOT.jar help```
>```java -jar target/scala-3.7.0-RC1/todo-cli-0.8-SNAPSHOT.jar``` displays the help menu.

Persistence
-----------
>**Todos** are stored as json files here:
```
~/.todo/data
```

Logging
-------
>**Log** files are stored here:
```
~/.todo/log
```

Resources
---------
* [MainArgs Github](https://github.com/com-lihaoyi/mainargs?tab=readme-ov-file#varargs-parameters)
* [Os-Lib Github](https://github.com/com-lihaoyi/os-lib)