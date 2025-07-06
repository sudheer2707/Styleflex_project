const cartItemsContainer = document.getElementById("cart-items");
const cartTotal = document.getElementById("cart-total");
const checkoutBtn = document.getElementById("checkout-btn"); // ✅ New: checkout button

let cart = JSON.parse(localStorage.getItem("cart")) || [];

function renderCart() {
  cartItemsContainer.innerHTML = "";
  let total = 0;

  if (cart.length === 0) {
    cartItemsContainer.innerHTML = "<p>Your cart is empty.</p>";
    cartTotal.textContent = "0";
    return;
  }

  cart.forEach((item, index) => {
    if (!item || typeof item.price !== "number" || !item.name) {
      console.warn("Skipping invalid cart item", item);
      return; // skip broken item
    }

    const itemDiv = document.createElement("div");
    itemDiv.className = "cart-item";

    const subtotal = item.price * item.quantity;
    total += subtotal;

    itemDiv.innerHTML = `
      <img src="${item.imageUrl}" alt="${item.name}" />
      <div>
        <h3>${item.name}</h3>
        <p>Price: ₹${item.price}</p>
        <label>Quantity:
          <input type="number" min="1" value="${item.quantity}" onchange="updateQuantity(${index}, this.value)" />
        </label>
        <p>Subtotal: ₹${subtotal.toFixed(2)}</p>
        <button onclick="removeFromCart(${index})">Remove</button>
      </div>
    `;

    cartItemsContainer.appendChild(itemDiv);
  });

  cartTotal.textContent = total.toFixed(2);
}

function updateQuantity(index, newQty) {
  cart[index].quantity = parseInt(newQty);
  localStorage.setItem("cart", JSON.stringify(cart));
  renderCart();
}

function removeFromCart(index) {
  cart.splice(index, 1);
  localStorage.setItem("cart", JSON.stringify(cart));
  renderCart();
}

// ✅ Add checkout logic
function checkout() {
  if (cart.length === 0) {
    alert("Your cart is empty!");
    return;
  }

  // Optionally: send to backend
  // Here we only redirect to the checkout page
  window.location.href = "checkout.html"; // adjust path if needed
}

// ✅ Hook the checkout button
if (checkoutBtn) {
  checkoutBtn.addEventListener("click", checkout);
}

renderCart();
