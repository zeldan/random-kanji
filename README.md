[![Build Status](https://travis-ci.org/zeldan/random-kanji.svg?branch=master)](https://travis-ci.org/zeldan/random-kanji)

Website: www.randomkanji.com

# The project

Full source code of www.randomkanji.com web application. 

# How to start

1. Run MongoDB 4
2. Import kanji collection to MongoDB (data/kanji.json)
```
   mongoimport --db test --collection kanji kanji.json --jsonArray
```
3. Run application 
```
   ./mvnw spring-boot:run
  ```


# Technology Stack
- Java 8
- Spring boot 2.1.2
- MongoDB 4.0.2
