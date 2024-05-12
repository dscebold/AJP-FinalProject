function checkBox1(value) {
    console.log(value + " " + document.getElementById("form:passwordConfirm").value + " " + value.localeCompare(document.getElementById("form:passwordConfirm").value));
   if(value.localeCompare(document.getElementById("form:passwordConfirm").value) === 0) {
    if(value.length > 7) {
        document.getElementById("form:confirm").disabled = false;
        document.getElementById("errorLength").hidden = true;
        document.getElementById("errorMatch").hidden = true;
    }
    else{
        document.getElementById("errorLength").hidden = false;
        document.getElementById("form:confirm").disabled = true;
    }
   } 
   else{
    document.getElementById("errorMatch").hidden = false;
    document.getElementById("form:confirm").disabled = true;
    if(value.length < 8) {
        document.getElementById("errorLength").hidden = false;
    }
   }
}

function checkBox2(value) {
    console.log(value + " " + document.getElementById("form:passwordConfirm").value + " " + value.localeCompare(document.getElementById("form:password").value));
    if(value.localeCompare(document.getElementById("form:password").value) === 0) {
        if(value.length > 7) {
            document.getElementById("form:confirm").disabled = false;
            document.getElementById("errorLength").hidden = true;
            document.getElementById("errorMatch").hidden = true;
        }
        else{
            document.getElementById("errorLength").hidden = false;
            document.getElementById("form:confirm").disabled = true;
        }
       } 
       else{
        document.getElementById("errorMatch").hidden = false;
        document.getElementById("form:confirm").disabled = true;
        if(value.length < 8) {
            document.getElementById("errorLength").hidden = false;
        }
       }
}