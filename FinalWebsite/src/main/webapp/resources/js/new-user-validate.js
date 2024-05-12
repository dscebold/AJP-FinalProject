function checkPassword(value) {
    console.log(value.length + " " + value);
    if(value.length > 7) {
      console.log("hello");
      document.getElementById("form:create-button").disabled = false;
      document.getElementById("error").hidden = true;
    } 
    else{
        console.log("hello why");
        document.getElementById("error").hidden = false;
        document.getElementById("form:create-button").disabled = true;
    }
}