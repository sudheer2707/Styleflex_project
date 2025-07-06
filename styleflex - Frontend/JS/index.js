// Get user info from localStorage
const user = JSON.parse(localStorage.getItem("loggedInUser"));

// Display welcome message and adjust navbar
if (user) {
  const welcomeText = document.getElementById("welcome-text");
  if (welcomeText) {
    welcomeText.textContent = `Hi, ${user.name}`;
  }

  // Optionally hide login/register links
  const loginLink = document.querySelector('a[href="login.html"]');
  const registerLink = document.querySelector('a[href="register.html"]');
  if (loginLink) loginLink.style.display = "none";
  if (registerLink) registerLink.style.display = "none";
} else {
  // If not logged in, hide logout button
  const logoutBtn = document.getElementById("logout-btn");
  if (logoutBtn) logoutBtn.style.display = "none";
}

// Logout function
document.getElementById("logout-btn")?.addEventListener("click", () => {
  localStorage.removeItem("loggedInUser");
  window.location.href = "login.html";
});
