import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.7.22"
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
    annotation("org.springframework.cache.annotation.Cacheable")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("mysql:mysql-connector-java")

//    implementation ("org.mongodb:mongodb-driver-sync:4.3.1")

    /**
     * QueryDSL 의존성
     */
    implementation("com.querydsl:querydsl-jpa")
    annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jakarta")
    api("com.querydsl:querydsl-jpa:5.0.0:jakarta")

    /**
     * springdoc-openapi
     */
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.redis.testcontainers:testcontainers-redis-junit:1.6.2")
    testImplementation("org.springframework:spring-webflux")
    testImplementation("org.springframework.graphql:spring-graphql-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

/**
 * 전체 테스트 시간 측정
 */

tasks.named("test") {
    var startedAt: Long = System.currentTimeMillis()
    doFirst{
        startedAt = System.currentTimeMillis()
    }

    doLast {
        val totalSecondsTaken = (System.currentTimeMillis() - startedAt).toFloat() / 1000
        println("totalTimeTaken = ${totalSecondsTaken}s")
    }
}