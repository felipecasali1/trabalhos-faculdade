import React from "react";
import { useNavigate } from "react-router";
import './SignUp.css';
import { useAuth } from "../../context/AuthContext";
import { Link } from "react-router";

export default function SignUp() {
    const navigate = useNavigate();
    const { signUp } = useAuth();

    const handleSignUp = () => {
        signUp();
        navigate('/produtos');
    }
    
    return (
        <div className="signup-container">
            <form className="signup-form">
                <h2>Cadastro</h2>
                <input type="text" placeholder="Nome completo"/>
                <input type="email" placeholder="Email"/>
                <input type="password" placeholder="Senha"/>
                <input type="password" placeholder="Confirmar senha"/>
                <button type="button" onClick={handleSignUp}>Cadastrar</button>
                <div className="signup-login-option">
                    <p>Já tem uma conta? <Link to="/login"> Login</Link></p>
                </div>
            </form>
        </div>
    );
};