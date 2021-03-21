# Business Trip

Для запуска приложения необходимо
- JAVA 8 
  
## Установка JAVA 
- Скачать JRE https://www.oracle.com/java/technologies/javase-jre8-downloads.html
- Установить JRE
- Проверить, правильно ли установлена java 
```sh
java -version
```
- Для запуска программы по двойному клику мыши 
```sh
assoc .jar=JARFile  
ftype JARFile="путь_к_jre\bin\javaw.exe" -jar "%1"
```

### Запуск
  - Кликаем 2 раза по файлу trip.jar
  - Или с помощью командной строки
  ```sh
  java -jar C:\Users\...\trip.jar
  ```
После запуска будут созданы 2 папки
  - logs - 2 файла с логами
  - data - H2 База данных 

## Настройка БД

Для запуска приложения менять конфигурацию не нужно.  
По умолчанию приложение запускается с H2 Database.   

### Изменение конфигурации БД
  Конфигурацию БД находится в application.properties файле,  
  файл находится в trip.jar  
  .jar можно открыть любым архиватором.  
  Путь к папке с файлом -> trip.jar\BOOT-INF\classes
  
- Для запуска с H2 -> spring.profiles.active=h2  
- Для запуска с PostgreSQL -> spring.profiles.active=postgres

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
