const apiUrl = 'http://localhost:8080/Products';

fetch(apiUrl)
  .then(response => response.json())
  .then(products => {
    const container = document.getElementById('product-list');
    const menProducts = products.filter(p => 
      p.category && p.category.name.toLowerCase() === 'men'
    );

    if (menProducts.length === 0) {
      container.innerHTML = '<p>No men’s products available.</p>';
      return;
    }

    menProducts.forEach(product => {
      const link = document.createElement('a');
      link.href = `product-detail.html?id=${product.id}`;
      link.className = 'product-card';

      link.innerHTML = `
        <img src="${product.imageUrl}" alt="${product.name}" />
        <h3>${product.name}</h3>
        <p>${product.description}</p>
        <p class="price">₹${product.price}</p>
      `;

      container.appendChild(link);
    });
  })
  .catch(error => {
    console.error('Error loading products:', error);
  });
