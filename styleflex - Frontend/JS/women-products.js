const apiUrl = 'http://localhost:8080/Products';

fetch(apiUrl)
  .then(response => response.json())
  .then(products => {
    const container = document.getElementById('product-list');
    const womenProducts = products.filter(p => 
      p.category && p.category.name.toLowerCase() === 'women'
    );

    if (womenProducts.length === 0) {
      container.innerHTML = '<p>No women’s products available.</p>';
      return;
    }

    womenProducts.forEach(product => {
      const card = document.createElement('div');
      card.className = 'product-card';
      card.innerHTML = `
        <img src="${product.imageUrl}" alt="${product.name}" />
        <h3>${product.name}</h3>
        <p>${product.description}</p>
        <p class="price">₹${product.price}</p>
      `;
      container.appendChild(card);
    });
  })
  .catch(error => {
    console.error('Error loading products:', error);
  });
