document.addEventListener("DOMContentLoaded", function () {

    const timerElement = document.getElementById("timer");
    const resendBtn = document.getElementById("resendBtn");

    if (!timerElement) return;

    const TIMER_DURATION_SECONDS = 300; // 5 min
    const STORAGE_KEY = "otp_expiry_time";

    let expiryTime = sessionStorage.getItem(STORAGE_KEY);

    if (!expiryTime) {
        expiryTime = Date.now() + TIMER_DURATION_SECONDS * 1000;
        sessionStorage.setItem(STORAGE_KEY, expiryTime);
    }

    function updateCountdown() {

        const now = Date.now();
        const timeLeft = Math.ceil((expiryTime - now) / 1000);

        if (timeLeft <= 0) {
            timerElement.textContent = "OTP expired!";
            timerElement.style.color = "red";
            sessionStorage.removeItem(STORAGE_KEY);
            clearInterval(timerInterval);
            return;
        }

        const minutes = Math.floor(timeLeft / 60);
        const seconds = String(timeLeft % 60).padStart(2, '0');

        timerElement.textContent = "OTP expires in: " + minutes + ":" + seconds;
    }

    updateCountdown();
    const timerInterval = setInterval(updateCountdown, 1000);

    // 🔥 FIX FOR RESEND
    if (resendBtn) {
        resendBtn.addEventListener("click", function () {
            const newExpiry = Date.now() + TIMER_DURATION_SECONDS * 1000;
            sessionStorage.setItem(STORAGE_KEY, newExpiry);
        });
    }

});