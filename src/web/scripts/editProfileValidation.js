/*
 * Validation in client side by java script
 *
 */

/* In this function ,validate the form by client side
   first: none of the fields are empty and then check the postalCode
   and telephone to be numbers and integer  */

function editValidate(form){

 
    if(form.password.value=="") {
        alert("Please fill in your password");
        form.password.focus();
    }
    else if(form.password2.value==""|| form.password.value != form.password2.value){
        alert("Please confirm your password");
        form.password.focus();
    }
    else if(form.firstName.value=="") {
        alert("Please fill in your first name");
        form.firstName.focus();
    }
    else if(form.lastName.value=="") {
        alert("Please fill in your last name");
        form.lastName.focus();
    }
    else if(form.email.value=="") {
        alert("Please fill in your email address");
        form.email.focus();
    }
    else if(!isEmail(form.email.value)){
        alert("Invalid email address!");
        form.email.focus();
    }
    else if(form.address.value=="") {
        alert("Please fill in your address");
        form.address.focus();
    }
    else if(form.postalCode.value== 0) {
        alert("Please fill in your postal code");
        form.postalCode.focus();
    }
    else if (isNaN(form.postalCode.value) || form.postalCode.value<=0 ||
                !((parseFloat(form.postalCode.value)== parseInt(form.postalCode.value)))) {
        alert("Charecters are not allowed in the postal code. ");
        form.postalCode.focus();
    }
    else if(form.city.value=="") {
        alert("Please fill in your city");
        form.city.focus();
    }
    else if(form.telephone.value== 0) {
        alert("Please fill in your telephone");
        form.telephone.focus();
    }
    else if (isNaN(form.telephone.value) || form.telephone.value<=0 ||
                !((parseFloat(form.telephone.value) == parseInt(form.telephone.value)))) {
        alert("Charecters are not allowed in the phone number. ");
        form.telephone.focus();
    }
    else {
        form.submit();
    }
}
function isEmail(email1){
    var email = email1;
    var at = "@";
    var dot = ".";
    var lastAt = email.indexOf(at);
    var lenghtStr = email.length;
    var lastDot = email.indexOf(dot);

    if (email.indexOf(at)==-1){
        return false
    }

    if (email.indexOf(at)==-1 || email.indexOf(at)==0 || email.indexOf(at)==lenghtStr){
        return false
    }

    if (email.indexOf(dot)==-1 || email.indexOf(dot)==0 || email.indexOf(dot)==lenghtStr){
        return false
    }

    if (email.indexOf(at,(lastAt+1))!=-1){
        return false
    }

    if (email.substring(lastAt-1,lastAt)==dot || email.substring(lastAt+1,lastAt+2)==dot){
        return false
    }

    if (email.indexOf(dot,(lastAt+2))==-1){
        return false
    }

    if (email.indexOf(" ")!=-1){
        return false
    }
        return true
    }



