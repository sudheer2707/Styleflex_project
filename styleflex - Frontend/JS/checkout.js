document.getElementById('checkout-form').addEventListener('submit', function (e) {
  e.preventDefault();

  const fullName = document.getElementById('fullname').value.trim();
  const address = document.getElementById('address').value.trim();
  const payment = document.getElementById('payment').value;

  if (fullName && address && payment) {
    document.getElementById('checkout-form').style.display = 'none';
    const confirmation = document.getElementById('confirmation');
    confirmation.style.display = 'block';

    // Optionally clear cart here from localStorage
    localStorage.removeItem('cartItems');
  } else {
    alert('Please fill out all fields.');
  }
});
