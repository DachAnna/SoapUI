#### Реализован тест через SoapUI на локальный проект https://github.com/spring-guides/gs-producing-web-service

В SoapUI в сьюте Contry data suit реализованы 4 ассерта

![изображение](https://user-images.githubusercontent.com/118796374/233204483-c6f399ce-d5d7-44ce-a21b-ae3516f35fe0.png)

из которых скриптом производится проверка следующих полей :
```bash
assert holder["//ns2:country"] != null
assert holder["//ns2:name"] == "Spain"
assert holder["//ns2:population"] =="46704314"
assert holder["//ns2:capital"] =="Madrid"
assert holder["//ns2:currency"] =="EUR"
 ```
 
 Также, реализован тест на метод 
 ```bash
/getCountry
 ```
 с проверкой статус кода ответа 200 и наличием в ответе города "Madrid"
