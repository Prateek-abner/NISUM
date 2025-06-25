
import React from 'react';
import withAdminAccess from './withAdminAccess';

const ProductEdit = () => {
  return (
    <div>
      <h2>Edit Product</h2>
      <input placeholder="Product Name" />
      <button>Save</button>
    </div>
  );
};

export default withAdminAccess(ProductEdit);
