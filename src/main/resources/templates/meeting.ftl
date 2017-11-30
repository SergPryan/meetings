<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Meeting</title>
</head>
<body>

<h1>Тема</h1><input type="text" value="${meeting.topic}"><br>
<h1>Время проведения</h1><input type="date"><br>
<h1>Подразделение</h1><select>
    <#list listDepartment as list>
        <option value="${list.name}">${list.name}</option>
    </#list>
</select><br>
<h1>Отвественный</h1><select>
<#list listEmployee as list>
    <option value="${list.fullName}">${list.fullName}</option>
</#list>
</select><br>
<h1>Состав участников</h1>
<table>
    <tr>
        <th>Имя</th>
        <th>Возраст</th>
        <th>Подразделение</th>
        <th>Delete</th>
    </tr>
  <#list listOfParticipants as list>
      <tr>
          <td>${list.fullName}</td>
          <td>${currentYear - list.getBirthday().getYear()}</td>
          <td></td>
          <td></td>
      </tr>
  </#list>
</table>
<h3>Участник</h3><select>
<#list listEmployee as list>
    <option value="${list.fullName}">${list.fullName}</option>
</#list>
</select>
<button>Добавить</button>
</body>
</html>