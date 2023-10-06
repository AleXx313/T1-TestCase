## Тестовое задание T1

### ТЗ
Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, вычисляющее частоту встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.

Пример входной строки: “aaaaabcccc”
Пример выходного результата: “a”: 5, “c”: 4, “b”: 1

Требования к решению:
Java 8+
Spring boot 2+
Решение должно быть покрыто тестами
У решения должна быть документация по запуску и формату входящих/исходящих параметров
Код решения необходимо разместить в публичном Github репозитории.

### Инструкции по запуску

В командной строке введите команды:

```
git clone https://github.com/AleXx313/T1-TestCase.git
cd T1-TestCase
./mvnw package
java -jar target/*.jar
```

Доступ к приложению осуществляется по адресу http://localhost:8080/api/v1/solve

### Работа с приложением

Вам необходимо с помощью Insomnia ли Postman или другого подходящего приложения направить post запрос по адресу http://localhost:8080/api/v1/solve с телом запроса следующего формата:
```
{
    "content": "Входные данные для проверки"
}
```
Для дополнительного удобства, подготовлена небольшая коллекция запросов в папке postman, которую можно импортировать в Postman.

### Входящий и исходящий форматы данных

На вход вы можете передать строку, содержащую любые символы, длинной от 2 до 500 символов.
В ответе вы получите строку из букв латинского алфавита с цифрой сообщающей как часто данная буква встречается во входящей строке.
