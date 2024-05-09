
function checkUsername(value) {
//    if(value.length > 8 && document.getElementById("password").value.length > 8) {
//      alert(value);   
//      document.getElementById("submitButton").disabled = false;
//    } 
//    else{
//        document.getElementById("submitButton").disabled = true;
//    }
}

function checkPassword(value) {
    if(value.length > 7) {
      document.getElementById("submitButton").disabled = false;
      document.getElementById("error").hidden = true;
    } 
    else{
        document.getElementById("error").hidden = false;
        document.getElementById("submitButton").disabled = true;
    }
}