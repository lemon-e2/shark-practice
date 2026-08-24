# 🦈 Shark-Practice

Spring Boot와 JPA를 사용하여 Shark와 Fish의 관계를 관리하는 간단한 REST API 학습 프로젝트.

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
* Shark별 Fish 조회

## 🔗 Entity 관계

```text
Shark 1 ─── N Fish
```

Fish는 하나의 Shark에 연결될 수 있으며, 연결되지 않은 자유 물고기로도 존재할 수 있음. 🐟

## 📦 DTO

API 요청과 응답을 Entity와 분리하기 위해 Request / Response DTO를 사용.

* `CreateFishRequest`
* `UpdateFishRequest`
* `FishResponse`
* `SharkResponse`

## 📚 학습 내용

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

Spring Boot의 기본적인 서버 구조와 데이터 흐름을 직접 구현하고 이해하는 것을 목표로 한 학습 프로젝트.
