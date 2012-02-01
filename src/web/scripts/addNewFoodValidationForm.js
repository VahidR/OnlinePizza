/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function validate(form){

if (form.foodName.value=="") {
        alert("Please fill the food name");
        form.foodName.focus();
    }
    else if(form.foodDescription.value=="") {
        alert("Please fill in a description for the food");
        form.foodDescription.focus();
    }
    else if(form.ingName1.value=="") {
        alert("You have to at least define one ingredient!");
        form.ingName1.focus();
    }
    else if(form.price1.value=="") {
        alert("You have to at least define one ingredient!");
        form.price1.focus();
    }
    else if(form.quantityNeeded1.value=="") {
        alert("You have to at least define one ingredient!");
        form.quantityNeeded1.focus();
    }
    else if(form.ingName2.value != "" || form.price2.value != 0 ||
                form.quantityNeeded2.value != 0)
        {
            if(form.ingName2.value == "" || form.price2.value == 0 ||
                  form.quantityNeeded2.value == 0)
                  {
                      alert("You have to provide full information of ingredients!");
                      form.ingName1.focus();
                  }
        }
    else {
    
        alert("ok");
        form.submit();
    }
}