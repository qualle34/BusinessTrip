# Business Trip

Для запуска приложения необходимо
- JAVA 8 
- PostgreSQL
  
### Установка JAVA 
- Скачать JRE https://www.oracle.com/java/technologies/javase-jre8-downloads.html
- Установить JRE
- Проверить, правильно ли установлена java 
  - Win + R -> cmd -> java -version
       
### Установка PostgreSQL 
- Скачать PostgreSQL https://www.postgresql.org/download/
- Запускаем БД
- Открываем pgAdmin4 
- Создаём БД 
  - Serves -> PostgreSQL -> Databases
  - Правой кнопкой по Databases -> create -> database 
  - Название БД: **trip**
- Создаём таблицы 
  - trip -> Schemas -> public
  - Вверху кликаем на Tools -> Query Tool 
  - Копируем содержимое файла create из папки data
  - Вставляем в Editor и запускаем скрипт
- Добавляем тестовые данные 
  - trip -> Schemas -> public
  - Вверху кликаем на Tools -> Query Tool 
  - Копируем содержимое файла insert из папки data
  - Вставляем в Editor и запускаем скрипт

### Запуск
  - Кликаем 2 раза по файлу trip.jar
  - С помощью командной строки
  ```sh
  java -jar C:\Users\...\trip.jar
  ```
