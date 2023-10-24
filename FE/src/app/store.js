import { configureStore } from "@reduxjs/toolkit";

export const store = configureStore({
  reducer: {
    // about: AboutSliceReducer,
    // nhanvien: NhanVienSliceReducer,
  },
});

export const dispatch = store.dispatch;
export const getState = store.getState;