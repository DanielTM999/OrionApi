# Orion API

API publica de extensao para a Orion IDE. Este repositorio contem apenas os contratos usados para desenvolver plugins; a implementacao da IDE permanece em um repositorio privado.

## Requisitos

- JDK 25
- Maven 3.9+

## Compilar

```bash
mvn clean verify
```

## Usar em um plugin Maven

Adicione o repositorio JitPack ao `pom.xml` do plugin:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Depois, adicione a API como dependencia:

```xml
<dependency>
    <groupId>com.github.DanielTM999</groupId>
    <artifactId>OrionApi</artifactId>
    <version>1.0.0</version>
    <scope>provided</scope>
</dependency>
```

O escopo `provided` permite compilar o plugin sem incluir outra copia da API no JAR. A Orion IDE fornece a API ao carregar o plugin.
