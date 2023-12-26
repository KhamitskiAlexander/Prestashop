# Mobile framework

## Table of contents

* [Environment Settings](#environment-settings)
    * [General](#general)
* [How to run tests](#how-to-run-tests)
* [Version Control System (VCS)](#vcs)

## Environment Settings

### General

1. Java 11 or later
2. Git
3. Gradle

## How to run tests

1. Open desktop Docker app
2. From command line from project's root:
    ``docker-compose up -d``
3. From command line from project's root:
    ``./gradlew clean executeUITests -DBROWSER='remote'``
4. Generate Allure Report:
    ``./gradlew allureReport``
