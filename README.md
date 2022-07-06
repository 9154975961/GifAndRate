## GifAndRate

### Тестовое задание от Альфа-Банк

#### Описание 
___
```sh
Создать сервис, который обращается к сервису курсов валют, и отображает gif:
• если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich
• если ниже - отсюда https://giphy.com/search/broke
Ссылки
• REST API курсов валют - https://docs.openexchangerates.org/
• REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide
Must Have
• Сервис на Spring Boot 2 + Java / Kotlin
• Запросы приходят на HTTP endpoint (должен быть написан в соответствии с rest conventions), туда передается код валюты по отношению с которой сравнивается USD
• Для взаимодействия с внешними сервисами используется Feign
• Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки
• На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)
• Для сборки должен использоваться Gradle
• Результатом выполнения должен быть репо на GitHub с инструкцией по запуску
Nice to Have
• Сборка и запуск Docker контейнера с этим сервисом
```
### Endpoints:
___
Получить Gif:
```sh
http://localhost:8080/
```
Получить список кодов валют:
```sh
http://localhost:8080/rates
```
Получить Gif для определенной валюты - 
```sh
http://localhost:8080/rates/{USD} 
```
_*вместо USD указать код интересующей валюты_
### Запуск .jar:
___
```sh
java -jar GifAndRate-0.0.1-SNAPSHOT.jar
```

### Docker:
___
Для создания образа Docker из корневой папки запустить:
```sh
docker build -t gif-and-rates .
```
или скачать из репозитория docker:
```sh
docker pull genderman/gif-and-rate:latest
```
Запуск:
```sh
docker run -d -p 8080:8080 gif-and-rates
```
