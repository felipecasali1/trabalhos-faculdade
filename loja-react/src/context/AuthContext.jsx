import React, { createContext, useContext, useState } from 'react';

//  Cria o contexto de autenticacao utilizando o hook
export const AuthContext = createContext();

//  Cria o provider (componente que fornece o contexto para os componentes children)
export const AuthProvider = ({children}) => {
    //const [user, setUser] = useState(null);

    //  Estado de autenticacao
    const [auth, setAuth] = useState(false);

    const signUp = () => {
        //  Simulacao
        setAuth(true);
    }
    
    const login = () => {
        //  Simulacao
        setAuth(true);
    }

    const logout = () => {
        setAuth(false);
    }

    //  Retorna o provider e compartilha o estado, envolvendo os componentes children
    return (
        <AuthContext.Provider value={ {auth, signUp, login, logout} }>
            {children}
        </AuthContext.Provider>
    );
};

//  Hook para usar o contexto
export const useAuth = () => useContext(AuthContext);

export default AuthProvider;