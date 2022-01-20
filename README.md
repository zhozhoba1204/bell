# Bell Integrator
Запуск приложения: practice-0.0.1-SNAPSHOT.jar

## Требования к проекту:
* Все возвращаемые типы данных находятся в параметре data
* В случае ошибки возвращается парметр error
* Везде, где не написан метод, использовать POST.

Например, в случае, если запрос корректно отработает:</br>
```
{
  "data":{
    //то, что в параметре out
  }
}
```
А в случае ошибки возвращает: 
```
{
"error":"текст ошибки"
}
```
## Инструкция:
1. Для получения списка организаций:</br>
http://localhost:8080/api/organization/list
   </br>In:</br>
![](readme/org.list.input.png)
   </br>Пример:</br>
![](readme/postman/organization.list.in.png)
   </br>Out:</br>
![](readme/org.list.output.png)
   </br>Пример:</br>
![](readme/postman/organization.list.out.png)


2. Для получения организации по id(метод GET):</br>
http://localhost:8080/api/organization/{id}
   </br>Out:</br>
![](readme/user.id.output.png)
   </br>Пример:</br>
![](readme/postman/user.id.out.png)

   
3. Для сохранения новой организации:</br>
http://localhost:8080/api/organization/save
   </br>In:</br>
![](readme/org.save.input.png)
   </br>Пример:</br>
![](readme/postman/org.save.in.png)
   </br>Out:</br>
![](readme/postman/success.png)


4. Для изменения организации:</br>
   http://localhost:8080/api/organization/update
   </br>In:</br>
   ![](readme/org.update.input.png)
   </br>Пример:</br>
   ![](readme/postman/org.update.in.png)
   </br>Out:</br>
   ![](readme/postman/success.png)


5. Для получения списка офисов:</br>
   http://localhost:8080/api/office/list
   </br>
   In:</br>
   ![](readme/office.list.input.png)
   </br>Пример:</br>
   ![](readme/postman/off.list.in.png)
   </br>Out:</br>
   ![](readme/office.list.output.png)
   </br>Пример:</br>
   ![](readme/postman/off.list.out.png)


6. Для получения офиса по id(метод GET):</br>
   http://localhost:8080/api/office/{id}
   </br>Out:</br>
   ![](readme/office.id.output.png)
   </br>Пример:</br>
   ![](readme/postman/off.id.out.png)


7. Для сохранения нового офиса:</br>
   http://localhost:8080/api/office/save
   </br>In:</br>
   ![](readme/office.save.input.png)
   </br>Пример:</br>
   ![](readme/postman/off.save.in.png)
   </br>Out:</br>
   ![](readme/postman/success.png)


8. Для изменения офиса:</br>
   http://localhost:8080/api/office/update
   </br>In:</br>
   ![](readme/office.update.input.png)
   </br>Пример:</br>
   ![](readme/postman/off.update.in.png)
   </br>Out:</br>
   ![](readme/postman/success.png) 


9. Для получения списка сотрудников:</br>
   http://localhost:8080/api/user/list
   </br>
   In:</br>
   ![](readme/user.list.input.png)
   </br>Пример:</br>
   ![](readme/postman/user.list.in.png)
   </br>Out:</br>
  ![](readme/user.list.output.png)
   </br>Пример:</br>
  ![](readme/postman/user.list.out.png)


10. Для получения сотрудника по id(метод GET):</br>
   http://localhost:8080/api/user/{id}
   </br>Out:</br>
   ![](readme/user.id.output.png)
   </br>Пример:</br>
  ![](readme/postman/user.id.out.png)


11. Для сохранения нового сотрудника:</br>
   http://localhost:8080/api/user/save
   </br>In:</br>
   ![](readme/user.save.input.png)
   </br>Пример:</br>
  ![](readme/postman/user.save.in.png)
   </br>Out:</br>
   ![](readme/postman/success.png)


12. Для изменения сотрудника:</br>
   http://localhost:8080/api/user/update
   </br>In:</br>
  ![](readme/user.update.input.png)
   </br>Пример:</br>
   ![](readme/postman/user.update.in.png)
   </br>Out:</br>
   ![](readme/postman/success.png)

###Справочники

1. Справочник документов:</br>
    http://localhost:8080/api/docs
    </br>Out:</br>
    ![](readme/docs.output.png)


3. Справочник стран:</br>
    http://localhost:8080/api/countries
    </br>Out:</br>
    ![](readme/countries.output.png)


###При возникновении ошибки:
   Пример out:</br>
   ![](readme/postman/error.png)

Описание ошибки можно найти по номеру в логах. 
