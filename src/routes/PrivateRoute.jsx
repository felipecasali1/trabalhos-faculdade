import React from 'react'
import { useAuth } from '../context/AuthContext'
import { Navigate } from 'react-router';

export default function PrivateRoute( {children} ) {
    const { auth } = useAuth();

    if (!auth) {
        return <Navigate to={'/login'} replace/>
    }

    return children;
}