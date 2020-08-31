![Build](https://github.com/OperationCrypto/hivej/workflows/CI/badge.svg?branch=master) [![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=org.operationcrypto.hivej&metric=alert_status)](https://sonarcloud.io/dashboard?id=org.operationcrypto.hivej)

![HiveJ Logo](https://github.com/OperationCrypto/hivej/wiki/images/HiveJLogo.png)

This project allows you to easily interact with the Hive blockchain. The project is based on the [SteemJ](https://github.com/marvin-we/steem-java-api-wrapper) initialized by <a href="https://steemit.com/@dez1337">dez1337 on steemit.com</a> in 2017, but the chance of the hive fork was used to refactor the code base and update the library to become fully functional again.

# Compatibility with Steem
The main focus of the project is - as the name suggests - the Hive blockchain. As the code base is pretty similar at the time this documenent is written, there is a high chance the library will also work for Steem.

# How to integrate HiveJ in your Java application

## Gradle
```Gradle
   Todo
```

## Maven
File: <i>pom.xml</i>
```Xml
   Todo
```

# Full Documentation
- Please have a look at the [Wiki](https://github.com/OperationCrypto/hivej/wiki) for a full documentation, examples, operational details and other information.
- Or have a look at the JavaDoc.

# Communication, Help and Feedback
For bugs or feature requests please create a [GitHub Issue](https://github.com/OperationCrypto/hivej/issues). 

For general discussions or questions you can also:
* Raise your question in the [HiveJ-Community](https://hive.blog/trending/hive-198065)
* Post your questions in the [Discord Java Channel](https://discord.gg/9jZQHv)
* Reply to one of the HiveJ update posts on [Hive.blog](https://hive.blog/@hivej)
* Create an [Issue](https://github.com/OperationCrypto/hivej/issues) here at GitHub.

# Binaries
HiveJ binaries are pushed into the maven central repository and can be integrated with a bunch of build management tools like Maven.

Please have a look at the [Wiki](https://github.com/OperationCrypto/hivej/wiki/How-to-add-HiveJ-to-your-project) to find examples for Maven, Ivy, Gradle and others.

# How to build the project
The project requires Maven and Java to be installed on your machine. It can be build with the default maven command:

>mvn clean package

The resulting JAR can be found in the target directory as usual.

# Example
The [sample module](https://github.com/OperationCrypto/hivej//tree/master/sample) of the Hive project provides showcases for the most common acitivies and operations users want to perform. 

Beside that you can find a lot of snippets and examples in the different [Wiki sections](https://github.com/OperationCrypto/hivej//wiki).  
