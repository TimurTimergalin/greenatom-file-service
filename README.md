# Микросервис-хранилище файлов

## Описание решения

### Что было реализовано?

- Метод создания файла;
- Метод получения файла по id;
- Тест сервиса на junit;
- Тесты в postman;
- Развертывание с помощью docker-compose.

### Что было использовано при решении?

Помимо Spring Boot были использованы следующие библиотеки:

- Apache Commons Codec - библиотека для работы с популярными кодировщиками (в данном случае, base64);
- Lombok - процессор аннотаций для сокращения шаблонного кода при создании классов;
- Mapstruct - генератор кода для автоматического создания mapper-ов - преобразователей сущностей;
- Mockito - библиотека для упрощения написания unit-тестов.

### Структура решения

#### src/main/java/com.tmtimergalin.greenatom_file_service

```
│   FileServiceApplication.java  // Точка входа для Spring Boot приложения
│
├───api  // Пакет с интерфейсами всех компонентов
│   ├───controller  
│   │   └───files  // Интерфейс REST - контроллера
│   │       │   FilesController.java  // Сам интерфейс
│   │       │
│   │       └───body
│   │           ├───request
│   │           │       CreateFileRequestBody.java  // Структура тела запроса создания файла
│   │           │
│   │           └───response
│   │                   GetFileResponse.java // Структура тела ответа на запрос получения файла
│   │
│   └───service  
│       └───files  // Интерфейс сервиса - реализации логики
│           │   FileDto.java  // Представление файла, с которым работает сервис.
│           │                 // Использование DTO позволяет сделать интерфейс сервиса независимым от других компонентов приложения
│           │   FileService.java  // Сам интерфейс
│           │
│           └───exceptions  // Исключения, выбрасываемые сервисом
│                   FileExistsException.java
│                   FileServiceException.java
│                   InvalidFileContent.java
│                   NoSuchFileException.java
│                   RequiredParameterMissingException.java
│
├───controller
│   └───files  // Реализация REST-контроллера
│           FileBodyToDtoMapper.java  // Интерфейс для преобразования DTO в тела запроса/ответа и наоборот
│           FilesControllerImpl.java  // САма реализация
│
├───data  // Работа с базой данных  
│   ├───entity  // ORM-сущности
│   │       File.java  // Сущность файла
│   │
│   └───repo
│           FileRepo.java  // CrudRepository для БД с файлами
│
├───service
│   └───files  // Реализация сервиса
│           FileEntityToDtoMapper.java  // Интерфейс для преобразования DTO в ORM-сущности и наоборот
│           FileServiceImpl.java  // Сама реализация
```

## Зупуск

Чтобы запустить сервис, необходимо:

1. Настроить переменные окружения в файле `.env` - внутри с помощью комментария указано, какие переменные нужно указать;
2. Запустить файл `file_service.sh` или `file_service.bat` (в зависимости от операционной системы). Данный файл соберет
   приложение и запустит его в докер-контейнере.

## Примеры запросов

Примеры запросов можно найти в коллекции Postman (файл `greenatom_file_service.postman_collection.json`). Также для
удобства приложено окружение Postman с тестовыми значениями (файл `greenatom_file_service.postman_environment.json`)
