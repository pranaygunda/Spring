<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  
  
<table border="1" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Type</th><th>Amount</th></tr>  
   <c:forEach var="i" items="${list}">   
   <tr>  
   <td>${i.id}</td>  
   <td>${i.name}</td>  
   <td>${i.type}</td>  
   <td>${i.amount}</td>  
   </tr>  
   </c:forEach>  
   </table>  