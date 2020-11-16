<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    
  
       <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>Id : </td>   
          <td><form:input path="id"  /></td>  
         </tr>    
         <tr>    
          <td>Name :</td>    
          <td><form:input path="name" /></td>  
         </tr>   
         <tr>    
          <td>Department :</td>    
          <td><form:input path="dept" /></td>  
         </tr>    
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    