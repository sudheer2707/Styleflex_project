let product = null;

document.addEventListener("DOMContentLoaded", () => {
  const params = new URLSearchParams(window.location.search);
  const productId = params.get("id");

  if (!productId) {
    document.querySelector(".product-container").innerHTML = "<p>Product ID not found in URL.</p>";
    return;
  }

  fetch(`http://localhost:8080/Products/${productId}`)
    .then(res => {
      if (!res.ok) throw new Error("Product not found");
      return res.json();
    })
    .then(data => {
      product = data;

      // Populate product details
      document.getElementById("product-img").src = product.imageUrl;
      document.getElementById("product-name").textContent = product.name;
      document.getElementById("product-brand").textContent = product.category?.name || "StyleFlex";
      document.getElementById("product-description").textContent = product.description;
      document.getElementById("product-price").textContent = product.price;
      document.getElementById("product-quantity").value = 1;

      // ✅ Attach buttons AFTER product is loaded
      document.getElementById("add-to-cart-btn").addEventListener("click", addToCart);
      document.getElementById("buy-now-btn").addEventListener("click", buyNow);
    })
    .catch(err => {
      console.error("Error loading product:", err);
      document.querySelector(".product-container").innerHTML = "<p>Unable to load product.</p>";
    });
});

function addToCart() {
  if (!product) {
    alert("Product not loaded.");
    return;
  }

  const quantity = parseInt(document.getElementById("product-quantity").value);
  let cart = JSON.parse(localStorage.getItem("cart")) || [];

  const existing = cart.find(item => item.id === product.id);
  if (existing) {
    existing.quantity += quantity;
  } else {
    cart.push({ ...product, quantity });
  }

  localStorage.setItem("cart", JSON.stringify(cart));
  alert("Added to cart!");
  window.location.href = "cart.html";
}

function buyNow() {
  addToCart();
  window.location.href = "checkout.html";
}
