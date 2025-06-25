
import { configureStore, createSlice } from '@reduxjs/toolkit';

const userSlice = createSlice({
  name: 'user',
  initialState: null,
  reducers: {
    login: (state, action) => action.payload,
    logout: () => null
  }
});

const cartSlice = createSlice({
  name: 'cart',
  initialState: [],
  reducers: {
    addItem: (state, action) => { state.push(action.payload); },
    removeItem: (state, action) => state.filter(item => item.id !== action.payload)
  }
});

export const { login, logout } = userSlice.actions;
export const { addItem, removeItem } = cartSlice.actions;

export default configureStore({
  reducer: {
    user: userSlice.reducer,
    cart: cartSlice.reducer
  }
});
