import React from "react";
import { Routes, Route } from "react-router";
import Login from "../pages/login/Login";
import Products from "../pages/products/Products";
import SignUp from "../pages/signup/SignUp";
import PrivateRoute from "./PrivateRoute";

export default function AppRoutes() {
    return (
        <Routes>
            <Route path="/cadastro" element={<SignUp />}/>
            <Route path="/login" element={<Login />}/>
            <Route path="/produtos" element={
                <PrivateRoute>
                    <Products />
                </PrivateRoute>
            }/>
            <Route path="*" element={<SignUp />}/>
        </Routes>
    );
}