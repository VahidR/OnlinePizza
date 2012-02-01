/* 
 * Do your validation in this file
 * 
 */
// this fun get a value and return true if it is
// integer (i.e int(value)==Value) otherwise return false
function is_int(in1){
  var s=in1;
  var i;
  s=s.toString()
  for(i=0; i<s.length ; i++)
      {
          if (s.charAt(i)<'0' || s.charAt(i)>'9')
              break;
      }
  if(i==s.length){
      return true;
  } else {
      return false;
  }
}
function validate(form){
   var fq=form.quantity.value;
   if (fq==""){
      alert("You have to oreder at least one to have in your basket");
      form.quantity.focus();
  }
  else if (!is_int(fq) || fq<=0 || fq.charAt(0)== '0'){
      alert("Pleae enter a positive integer number in the base of 10 for quantity!");
      form.quantity.focus();
  }
  else {
      form.submit();
     }
}

