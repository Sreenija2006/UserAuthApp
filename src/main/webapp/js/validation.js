document.addEventListener("DOMContentLoaded", function () {

    // -------------------------------
    // ELEMENTS
    // -------------------------------
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("confirmPassword");
    const matchMsg = document.getElementById("msg");
    const strength = document.getElementById("strength");

    // -------------------------------
    // PASSWORD MATCH VALIDATION
    // -------------------------------
    if (password && confirmPassword && matchMsg) {

        confirmPassword.addEventListener("keyup", function () {

            //  DO NOT SHOW MESSAGE IF EMPTY
            if (password.value === "" || confirmPassword.value === "") {
                matchMsg.innerHTML = "";
                return;
            }

            if (password.value === confirmPassword.value) {
                matchMsg.style.color = "green";
                matchMsg.innerHTML = "Passwords match ✔";
            } else {
                matchMsg.style.color = "red";
                matchMsg.innerHTML = "Passwords do not match ✖";
            }
        });
    }

    // -------------------------------
    // PASSWORD STRENGTH CHECKER
    // -------------------------------
    if (password && strength) {

        password.addEventListener("keyup", function () {

            let val = password.value;

            // DO NOT SHOW IF EMPTY
            if (val.length === 0) {
                strength.innerHTML = "";
                return;
            }

            let msg = "";

            if (val.length < 4) {
                msg = "Weak";
                strength.style.color = "red";
            } 
            else if (val.length < 8) {
                msg = "Medium";
                strength.style.color = "orange";
            } 
            else {
                msg = "Strong";
                strength.style.color = "green";
            }

            strength.innerHTML = "Password Strength: " + msg;
        });
    }

});
