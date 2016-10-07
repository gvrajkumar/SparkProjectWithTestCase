# SparkProjectWithTestCase

SBT Spark Project with testsuit and eclipse integration. Project gives the ability to write code in java and scala.

Steps

1. Clone or download the project
2. Download and install SBT
3. Add eclipse plugin to create eclipse project files.
```shell
mkdir -p ~/.sbt/0.13/plugins
vi ~/.sbt/0.13/plugins/plugins.sbt 
```
   and enter following in the file
```
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")
```
4. Create Eclipse Project files 
```
sbt eclipse
[info] Successfully created Eclipse project files for project(s):
[info] Spark Project
```
5. Creating package for deployment
```shell
sbt package
[info] Compiling 5 Scala sources and 1 Java source to /Users/vgunnu/workspacescala/SparkProjectWithTestCase/target/scala-2.11/classes...
[info] Packaging /Users/vgunnu/workspacescala/SparkProjectWithTestCase/target/scala-2.11/spark-project_2.11-1.0.jar ...
[info] Done packaging.
```
6. Running TestCase 
```shell
sbt test
[info] Run completed in 6 seconds, 657 milliseconds.
[info] Total number of tests run: 2
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 2, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[info] Passed: Total 5, Failed 0, Errors 0, Passed 5
```
