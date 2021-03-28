# Business Trip

## Установка с помощью инсталлятора  
Приложение можно скачать [тут](https://github.com/qualle34/BusinessTrip/releases/tag/1.0)  
- Рекомендуется просто нажимать кнопки Далее не изменяя конфигурацию  
  - Можно создать ярлык на рабочем столе  
- Путь к программе по умолчанию - C:\Users\...\AppData\Local\Programs\BusinessTrip
 
- По умолчанию используется H2 Database 

- После запуска будут созданы 2 папки
  - logs - 2 файла с логами
  - data - H2 База данных 


### Изменение конфигурации БД
  Конфигурация находится в папке config   
- Для запуска с H2
  - В файл application.properties добавляем строку spring.profiles.active=h2 
  - Конфигурация H2 находится в файле application-h2.properties
- Для запуска с PostgreSQL 
  - В файл application.properties добавляем строку spring.profiles.active=postgres
  - Конфигурация PostgreSQL находится в файле application-postgres.properties



## Запуск jar файла 
Для запуска jar файла необходимо
- JAVA 8 

### Установка JRE
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

### Настройка БД

Для запуска приложения менять конфигурацию не нужно.  
По умолчанию приложение запускается с H2 Database.   

### Изменение конфигурации БД
  Конфигурация БД находится в application.properties файле,  
  файл находится в trip.jar  
  .jar файл можно открыть любым архиватором.  
  Путь к папке с файлом -> trip.jar\BOOT-INF\classes
  
- Для запуска с H2
  - В файл application.properties добавляем строку spring.profiles.active=h2 
  - Конфигурация H2 находится в файле application-h2.properties
- Для запуска с PostgreSQL 
  - В файл application.properties добавляем строку spring.profiles.active=postgres
  - Конфигурация PostgreSQL находится в файле application-postgres.properties

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
