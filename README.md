# Spring Boot Computer Store Application

### - Это приложение является простым онлайн-магазином, в котором продаются компьютеры и комплектующие. Приложение написано на Java с использованием Spring Boot, Spring Data JPA и встраиваемой базой данных H2.

#### Шаги для запуска проекта:

1. Клонирование приложения
git clone https://github.com/AleksandraMam/computer-store-spring-boot.git

2. Перейти в каталог приложения
cd computer-store-spring-boot

3. Сборка и запуск приложения с использованием maven
mvn spring-boot:run
Приложение запустится по умолчанию на порту 8080.

4. Перейти в браузере по ссылке http://localhost:8080
Вы должны увидеть запущенное приложение.

5. Доступ к H2 Database
Для доступа к консоли базы данных H2 перейдите в браузере по ссылке http://localhost:8080/h2-console
Вход в консоль H2 осуществляется с использованием следующих данных:

JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: password
