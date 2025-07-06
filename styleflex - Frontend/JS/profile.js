document.getElementById('profile-form').addEventListener('submit', function (e) {
  e.preventDefault();

  const name = document.getElementById('name').value.trim();
  const email = document.getElementById('email').value.trim();
  const phone = document.getElementById('phone').value.trim();

  if (name && email) {
    // You can also send this data to backend using fetch/AJAX
    document.getElementById('success-message').classList.remove('hidden');
    setTimeout(() => {
      document.getElementById('success-message').classList.add('hidden');
    }, 3000);
  } else {
    alert('Please fill in all required fields.');
  }
});
