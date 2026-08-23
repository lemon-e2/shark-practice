# 🦈 Shark & Fish API

Spring Boot와 JPA를 사용해 Shark와 Fish의 관계를 관리하는 간단한 REST API.
Spring Boot의 기본적인 CRUD와 Entity 관계, DTO 사용을 직접 연습하기 위해 만들었습니다.

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Gradle
* Docker

## 📌 주요 기능

### Shark

* 생성 / 조회 / 수정 / 삭제
* 연결된 Fish 조회

### Fish

* 생성 / 전체 조회 / 단건 조회 / 수정
* Shark 연결 및 해제
* 특정 Shark에 연결된 Fish 조회

## 🔗 Entity 관계

```text
Shark 1 ─── N Fish
```

Fish는 Shark에 연결되지 않은 **자유 물고기**로도 존재할 수 있습니다. 🐟💨

## 📦 DTO

Request / Response DTO를 사용하여 API 요청과 응답을 Entity와 분리했습니다.

* `CreateFishRequest`
* `UpdateFishRequest`
* `FishResponse`

## 📚 학습한 내용

* Controller / Service / Repository 구조
* REST API CRUD
* Spring Data JPA
* Entity 관계 매핑
* DTO
* Bean Validation
* Query Parameter
* PostgreSQL 연동
* Docker

## 🎯 목적

Spring Boot의 기본적인 서버 구조와 데이터 흐름을 직접 구현하고 이해하는 것을 목표로 한 학습 프로젝트입니다.
