# Java's Project Loom & Co
## The end for reactive programming?

These are the code examples for my talk at the WeAreDevelopers World Congress 2024.

This repository contains 4 maven projects of runnable code that are described in more detail
in the following sections.

* For three of these projects you need to set your `JAVA_HOME` environment variable to a version 17 JDK.
* For one these projects you need to set your `JAVA_HOME` environment variable to a version 21 JDK.
* You also need Maven to run the projects.

You can run the projects from the command line as described below. Alternatively, you can run them 
from your favorite IDE.

### JDK 17 Blocking Code Example

This code example is meant to run faulty and it will break because the JVM will run
out of memory because too many threads are created.

In the directory [jdk17-blocking](./jdk17-blocking) you will find the Java class
[Main.java](./jdk17-blocking/src/main/java/org/example/Main.java). This class
contains the main implementation for this example.

This maven project needs to run with a JAVA_HOME variable pointing to a version 17 JDK.

```shell
$> cd jdk17-blocking
$> export JAVA_HOME=/Users/my_user/Library/Java/JavaVirtualMachines/openjdk-17.0.5/Contents/Home/
$> mvn clean compile exec:java
```

### JDK 17 Reactive Code Example

This code example is meant to run successfully by using the reactive framework Spring WebFlux.

In the directory [jdk17-reactive](./jdk17-reactive) you will find the Java class
[Main.java](./jdk17-reactive/src/main/java/org/example/Main.java). This class
contains the main implementation for this example.

This maven project needs to run with a JAVA_HOME variable pointing to a version 17 JDK.

```shell
$> cd jdk17-reactive
$> export JAVA_HOME=/Users/my_user/Library/Java/JavaVirtualMachines/openjdk-17.0.5/Contents/Home/
$> mvn clean compile exec:java
```

### JDK 17 Kotlin Coroutines Code Example

This code example is meant to run successfully by using the Kotlin Coroutines.

In the directory [kotlin-jdk-17](./kotlin-jdk-17) you will find the Kotlin class
[Main.kt](./kotlin-jdk-17/src/main/kotlin/Main.kt). This class
contains the main implementation for this example.

This maven project needs to run with a JAVA_HOME variable pointing to a version 17 JDK.

```shell
$> cd kotlin-jdk-17
$> export JAVA_HOME=/Users/my_user/Library/Java/JavaVirtualMachines/openjdk-17.0.5/Contents/Home/
$> mvn clean compile exec:java
```

### JDK 21 Java Code Example

This code example is meant to run successfully by using Java 21 Virtual Threads.

In the directory [jdk21-vt](./jdk21-vt) you will find the Java class
[Main.java](./jdk21-vt/src/main/java/org/example/Main.java). This class
contains the main implementation for this example.

This maven project needs to run with a JAVA_HOME variable pointing to a version 21 JDK.

```shell
$> cd jdk21-vt
$> export JAVA_HOME=/Users/my_user/Library/Java/JavaVirtualMachines/openjdk-21.0.2/Contents/Home/
$> mvn clean compile exec:java
```

License
=======
    Copyright [2024] [Holisticon AG]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.