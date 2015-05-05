 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email Cliente</title>
    </head>
    <body>
        <h1>Email para contato</h1>
        <form method="POST" action="EmailDispacher">
            <table>
                <tr>
                    <td align="right"><b>Email :</b></td>
                    <td>
                        <input type="text"  name="email" size="65">                        
                    </td>      
                </tr>
                <tr>
                    <td align="right"><b>Assunto :</b></td>
                    <td>
                        <input type="text"  name="assunto" size="65">                        
                    </td>      
                </tr>
                <tr>
                    <td align="right"><b>Mensagem :</b></td>
                    <td>
                        <textarea  name="mensagem" cols="55" rows="7"></textarea>  
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Enviar">                        
                    </td>      
                </tr>
            </table>
        </form>
    </body>
</html>
