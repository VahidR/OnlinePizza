/* In this function ,validate the form by client side
   first: none of the fields are empty
 */

function loginValidate(form)
{
    if (form.userName.value=="")
    {
        alert("Please fill in your username");
        form.userName.focus();
    }
    else if(form.password.value=="")
    {
        alert("Please fill in your password");
        form.password.focus();
    }

    else
    {
        form.submit();
    }
}
