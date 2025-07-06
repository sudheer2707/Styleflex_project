document.getElementById("register-form").addEventListener("submit", async function (e) {
  e.preventDefault();

  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value;

  const response = await fetch("http://localhost:8080/api/users/register", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ name, email, password })
  });

  const messageElement = document.getElementById("message");

  if (response.ok) {
    const result = await response.text();
    messageElement.textContent = result;
    messageElement.style.color = "green";

    // Redirect to login page after 1.5 seconds
    setTimeout(() => {
      window.location.href = "login.html";
    }, 1500);
  } else if (response.status === 409) {
    messageElement.textContent = "Email is already registered!";
    messageElement.style.color = "red";
  } else {
    const error = await response.text();
    messageElement.textContent = error || "Registration failed.";
    messageElement.style.color = "red";
  }
});
