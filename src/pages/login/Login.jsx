import React from "react";
import { useNavigate } from "react-router";
import './Login.css';
import { useAuth } from "../../context/AuthContext";
import { Link } from "react-router";

export default function Login() {
    const navigate = useNavigate();
    const { login } = useAuth();
    
    const handleLogin = () => {
        login();
        navigate('/produtos');
    }

    return (
        <div className="login-container">
            <form className="login-form">
                <h2>Login</h2>
                <input type="email" placeholder="Email"/>
                <input type="password" placeholder="Senha"/>
                <button type="button" onClick={handleLogin}>Entrar</button>
                <div className="login-signup-option">
                    <p>Não tem uma conta? <Link to="/cadastro"> Cadastrar</Link></p>
                </div>
            </form>
        </div>
    );
}