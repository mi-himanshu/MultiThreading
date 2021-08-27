Matrix Cross Product
==========
> Himanshu Mishra
-----

A project for showcasing the difference in performance time when using single and multi-threaded applications.

Project Structure
---
- Matrix: Main model to be used as a matrix (An interface).
- MatrixImpl: Implementation of the Matrix Interface.
- MatDS: A data structure used for programming the Matrix.
- MatDSImpl: Implementation of the MatDS Interface.
- CrossProduct: An abstract class used for multi-threading cross product operation.
- CrossProductImpl: Implementation of the CrossProduct abstract class.

- App: Main app to run on the console that gives the difference in speed of both methods.

Command
---
> mvn clean install exec:java