[![Build Status](https://travis-ci.org/zeldan/random-kanji.svg?branch=master)](https://travis-ci.org/zeldan/random-kanji)

Website: www.randomkanji.com

# Data

You can find the kanji collection in 'data' directory.

Import kanji:
mongoimport --db test --collection kanji kanji.json --jsonArray

# Technology Stack
- Java 8
- Spring boot 2.0.1
- MongoDB 3.4.10
