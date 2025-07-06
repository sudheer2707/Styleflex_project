document.getElementById("login-form").addEventListener("submit", async function (e) {
  e.preventDefault();

  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value;

  const response = await fetch("http://localhost:8080/api/users/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ email, password })
  });

  const message = document.getElementById("login-message");

  if (response.ok) {
    const result = await response.text();
    message.style.color = "green";
    message.textContent = result;

    if (result.toLowerCase().includes("success")) {
      localStorage.setItem("userEmail", email);

      setTimeout(() => {
        window.location.href = "../HTML/index.html";
      }, 1000);
    }
  } else {
    const error = await response.text();
    message.style.color = "red";
    message.textContent = error;
  }
});
