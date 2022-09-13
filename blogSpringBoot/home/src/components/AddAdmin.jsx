import React from 'react'

const AddAdmin = () => {
    const addProductAPI = (event) => {
        event.preventDefault();
        console.log(product);
        nykaaAppApi
          .post(`/product`, {
            productName: product.productName,
            productPrice: parseInt(product.productPrice),
            productDescription: product.productDescription,
            categoryId: parseInt(product.categoryId),
          })
          .then((res) => {
            if (res.data.data) {
              alert("success");
            } else if (res.data.error) {
              console.log(res.data.error.message);
            } else {
              console.log("Something went wrong");
            }
          })
          .catch((error) => {
            console.log(`Error -> ${error}`);
          });
        };
  return (
    <div>

    </div>
  )
}

export default AddAdmin